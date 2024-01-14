package dev.sangwon.carwith.member.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String password;
    private String userName;
    private String roles;

    @Builder
    public UserInfo(Integer id, String email, String password, String userName, String roles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.roles = roles;
    }
}
