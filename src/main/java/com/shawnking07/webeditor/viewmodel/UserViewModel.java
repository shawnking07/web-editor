package com.shawnking07.webeditor.viewmodel;

import com.shawnking07.webeditor.domain.User;
import lombok.Data;

/**
 * @author shawn
 */
@Data
public class UserViewModel {
    private String username;
    private String password;

    public UserViewModel() {
    }

    public UserViewModel(User user){
        this.username = user.getUsername();
        this.password = user.getPassword();
    }
}
