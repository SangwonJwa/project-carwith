package dev.sangwon.carwith.service;

import dev.sangwon.carwith.domain.User;
import dev.sangwon.carwith.dto.AddUserRequest;
import dev.sangwon.carwith.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long signUp(AddUserRequest requestDTO){

        return userRepository.save(User.builder()
                .email(requestDTO.getEmail())
                .password(bCryptPasswordEncoder.encode(requestDTO.getPassword()))
                .name(requestDTO.getName())
                .phoneNumber(requestDTO.getPhoneNumber())
                .gender(requestDTO.getGender())
                .build()
                ).getId();
    }

    public User findById(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }

    public boolean isEmailDuplicate(String email){
        return userRepository.existsByEmail(email);
    }
    public boolean isPhoneNumberDuplicate(String phoneNumber){
        return userRepository.existsByPhoneNumber(phoneNumber);
    }
}
