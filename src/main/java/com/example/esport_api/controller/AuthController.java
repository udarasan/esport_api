package com.example.esport_api.controller;

import com.example.esport_api.dto.AuthDTO;
import com.example.esport_api.dto.ResponseDTO;
import com.example.esport_api.dto.UserDTO;
import com.example.esport_api.service.impl.UserServiceImpl;
import com.example.esport_api.utill.JwtUtil;
import com.example.esport_api.utill.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ResponseDTO responseDTO;


    @PostMapping("/authenticate")
    public ResponseEntity<ResponseDTO> authenticate(@RequestBody UserDTO userDTO) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword()));

        } catch (Exception e) {
            responseDTO.setCode(VarList.Unauthorized);
            responseDTO.setMessage("Invalid Credentials");
            responseDTO.setData(e.getMessage());
            return new ResponseEntity<>(responseDTO, HttpStatus.UNAUTHORIZED);
        }

        //final UserDetails userDetails = userService.loadUserByUsername(userDTO.getUsername());
        final UserDTO userDTO2=userService.loadUserDetailsByUsername(userDTO.getUsername());
        final String token = jwtUtil.generateToken(userDTO2);

        if (token!=null  && !token.isEmpty() ){

            UserDTO userDTO1=userService.loadUserDetailsByUsername(userDTO.getUsername());
            AuthDTO authDTO = new AuthDTO();
            authDTO.setUsername(userDTO1.getUsername());
            authDTO.setToken(token);
            //sendmail
            sendMail();
            responseDTO.setCode(VarList.Created);
            responseDTO.setMessage("Success");
            responseDTO.setData(authDTO);
            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        }
        responseDTO.setCode(VarList.Conflict);
        responseDTO.setMessage("Authorization Failure! Please Try Again");
        responseDTO.setData(null);
        return new ResponseEntity<>(responseDTO, HttpStatus.CONFLICT);
    }

    public void sendMail(){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom("esoftassigmenets@gmail.com");
        simpleMailMessage.setTo("udarassanjeewa@gmail.com");
        simpleMailMessage.setSubject("User Login Detection");
        simpleMailMessage.setText("Your are Login to Your Account");
        javaMailSender.send(simpleMailMessage);

    }
}
