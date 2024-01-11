package dev.sangwon.carwith.user.service;

import dev.sangwon.carwith.user.domain.User;
import dev.sangwon.carwith.user.dto.SignupRequest;
import dev.sangwon.carwith.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public User signup(SignupRequest dto){
        return userRepository.save(User.builder()
                .email(dto.getEmail())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .userName(dto.getUserName())
                .phone(dto.getPhone())
                .build());
    }

}
