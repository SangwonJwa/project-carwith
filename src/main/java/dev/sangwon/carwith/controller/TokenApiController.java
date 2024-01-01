package dev.sangwon.carwith.controller;

import dev.sangwon.carwith.dto.CreateNewAccessTokenRequest;
import dev.sangwon.carwith.dto.CreateNewAccessTokenResponse;
import dev.sangwon.carwith.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TokenApiController {
    private final TokenService tokenService;

    @PostMapping("/api/token")
    public ResponseEntity<CreateNewAccessTokenResponse> createNewAccessToken(
            @RequestBody CreateNewAccessTokenRequest request){
        String newAccessToken = tokenService.createNewAccessToken(request.getRefreshToken());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CreateNewAccessTokenResponse(newAccessToken));
    }
}
