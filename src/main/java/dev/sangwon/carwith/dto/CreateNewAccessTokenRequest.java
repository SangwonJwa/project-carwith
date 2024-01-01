package dev.sangwon.carwith.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateNewAccessTokenRequest {
    private String refreshToken;
}
