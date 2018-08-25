package com.shawnking07.webeditor.viewmodel;

import com.shawnking07.webeditor.domain.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author shawn
 */
@Setter
@Getter
public class UserViewModel {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public UserViewModel() {
    }

    public UserViewModel(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
    }
}
