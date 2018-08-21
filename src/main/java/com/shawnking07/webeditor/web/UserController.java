package com.shawnking07.webeditor.web;

import com.shawnking07.webeditor.service.UserService;
import com.shawnking07.webeditor.viewmodel.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author shawn
 */
@RestController
@RequestMapping(value = "/auth")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(@Valid @RequestBody UserViewModel userViewModel) {
        return ResponseEntity.ok(userService.login(userViewModel));
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<Long> signup(@Valid @RequestBody UserViewModel userViewModel) {
        return ResponseEntity.ok(userService.signup(userViewModel));
    }
}
