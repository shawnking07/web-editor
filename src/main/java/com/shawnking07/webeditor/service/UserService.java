package com.shawnking07.webeditor.service;

import com.shawnking07.webeditor.viewmodel.UserViewModel;

/**
 * @author shawn
 */
public interface UserService {
    /**
     * sign up
     * @param userViewModel user info
     * @return Long userId
     */
    Long signup(UserViewModel userViewModel);

    /**
     * login
     * @param userViewModel user info
     * @return token
     */
    String login(UserViewModel userViewModel);

    /**
     * change user info
     *
     * @param userViewModel user info
     */
    void modifyInfo(UserViewModel userViewModel);
}
