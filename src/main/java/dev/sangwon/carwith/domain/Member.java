package dev.sangwon.carwith.domain;

import dev.sangwon.carwith.constant.Role;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100, unique = true)
    private String nickName;

    @Column(length = 11)
    private String phoneNumber;

    @Column
    private String imageUrl;

    @Column(length = 1)
    private String gender;

    @Column(length = 8)
    private String birthDate;

    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public Member(String name, String email, String picture, Role role){
        this.name = name;
        this.email = email;
        this.imageUrl = picture;
        this.role = role;
    }

    public Member update(String name, String picture){
        this.name = name;
        this.imageUrl = picture;

        return this;
    }

    public String getRoleKey(){
        return this.role.getRole();
    }
}


