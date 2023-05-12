package com.example.esport_api.service.impl;

import com.example.esport_api.dto.UserDTO;
import com.example.esport_api.entity.User;
import com.example.esport_api.repository.UserRepository;
import com.example.esport_api.utill.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author udarasan
 * @TimeStamp 2023-02-04 09:28
 * @ProjectDetails esport_api
 */
@Service
@Transactional
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuditServiceImpl auditService;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        auditService.saveAudit("loadUserByUsername","PASS:Load User By User Name"+username);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
    }
    public UserDTO loadUserDetailsByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        auditService.saveAudit("loadUserDetailsByUsername","PASS:Load User Detail By User Name"+username);

        return modelMapper.map(user,UserDTO.class);
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getRoleCode().toString()));
        return authorities;
    }

    public int saveUser(UserDTO userDTO) {
        if (userRepository.existsByUsername(userDTO.getUsername())) {
            auditService.saveAudit("saveUser","PASS:Save User Now"+userDTO.getName());
            return VarList.Not_Acceptable;
        } else {
            userRepository.save(modelMapper.map(userDTO, User.class));
            auditService.saveAudit("saveUser","FAIL:Save User Now"+userDTO.getName());
            return VarList.Created;
        }
    }

    public int deleteUser(String username) {
        if (userRepository.existsByUsername(username)) {
            userRepository.deleteByUsername(username);
            return VarList.Created;
        } else {
            return VarList.Not_Found;
        }
    }


    public List<UserDTO> getAllUsers() {
        List<User> users=userRepository.findAllByRole(1);
        return modelMapper.map(users, new TypeToken<ArrayList<UserDTO>>() {
        }.getType());
    }

    public UserDTO searchUser(String username) {
        if (userRepository.existsByUsername(username)) {
            User user=userRepository.findByUsername(username);
            return modelMapper.map(user,UserDTO.class);
        } else {
            return null;
        }
    }

    public int updateUser(UserDTO userDTO) {
        if (!userRepository.existsByUsername(userDTO.getUsername())) {
            auditService.saveAudit("updateUser","PASS:Save User Now"+userDTO.getName());
            return VarList.Not_Acceptable;
        } else {
            userRepository.save(modelMapper.map(userDTO, User.class));
            auditService.saveAudit("updateUser","FAIL:Save User Now"+userDTO.getName());
            return VarList.Created;
        }
    }
}
