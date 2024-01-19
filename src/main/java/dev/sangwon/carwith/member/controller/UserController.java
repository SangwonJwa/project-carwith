package dev.sangwon.carwith.member.controller;

import dev.sangwon.carwith.member.domain.UserInfo;
import dev.sangwon.carwith.member.dto.AuthRequest;
import dev.sangwon.carwith.member.service.JwtService;
import dev.sangwon.carwith.member.service.UserInfoService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@NoArgsConstructor
public class UserController {

    private UserInfoService userInfoService;
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to Spring Security tutorial";
    }

    @GetMapping("/nothing")
    public void nothing(){

    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(authRequest.getEmail());
        } else{
            throw new UsernameNotFoundException("Invalid User Request");
        }
    }

    @PostMapping("/users")
    public String addUser(@RequestBody UserInfo userInfo){
        return userInfoService.addUser(userInfo);
    }

    @GetMapping("/users")
    public List<UserInfo> getAllUsers(){
        return userInfoService.getAllUser();
    }

    @GetMapping("/users/{id}")
    public UserInfo getUser(@PathVariable Integer id){
        return userInfoService.getUser(id);
    }
}
