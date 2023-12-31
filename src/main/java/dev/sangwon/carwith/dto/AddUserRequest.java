package dev.sangwon.carwith.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequest {
    private String email;
    private String password;
    private String name;
    private String phoneNumber;

    private String gender;
}
