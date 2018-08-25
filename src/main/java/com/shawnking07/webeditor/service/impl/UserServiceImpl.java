package com.shawnking07.webeditor.service.impl;

import com.shawnking07.webeditor.domain.Role;
import com.shawnking07.webeditor.domain.RoleName;
import com.shawnking07.webeditor.domain.User;
import com.shawnking07.webeditor.exception.ConflictException;
import com.shawnking07.webeditor.repository.RoleRepository;
import com.shawnking07.webeditor.repository.UserRepository;
import com.shawnking07.webeditor.security.JwtTokenProvider;
import com.shawnking07.webeditor.service.UserService;
import com.shawnking07.webeditor.util.UserUtil;
import com.shawnking07.webeditor.viewmodel.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * @author shawn
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, AuthenticationManager authenticationManager, JwtTokenProvider tokenProvider, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Long signup(UserViewModel userViewModel) throws ConflictException {
        User user = new User();
        user.setUsername(userViewModel.getUsername());
        user.setPassword(passwordEncoder.encode(userViewModel.getPassword()));
        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow();
        user.setRoles(Collections.singleton(userRole));
        try {
            return userRepository.save(user).getId();
        } catch (Exception e) {
            throw new ConflictException("username has been used");
        }
    }

    @Override
    public String login(UserViewModel userViewModel) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userViewModel.getUsername(),
                        userViewModel.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return tokenProvider.generateToken(authentication);
    }

    @Override
    public void modifyInfo(UserViewModel userViewModel) {
        User user = userRepository.findById(UserUtil.getCurrentUserId())
                .orElseThrow();
        user.setPassword(passwordEncoder.encode(userViewModel.getPassword()));
        userRepository.save(user);
    }
}
