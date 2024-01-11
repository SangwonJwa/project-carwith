package dev.sangwon.carwith.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest {
    private String email;
    private String password;
    private String userName;
    private String phone;
}
