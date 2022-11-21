package com.billy.user;

import com.billy.config.AesEncryptor;
import com.billy.config.ApplicationUserRole;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(
        name = "tbl_user",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "user_email_unique",
                        columnNames = "email"
                )
        }

)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Convert(converter = AesEncryptor.class)
    private String email;
    private ApplicationUserRole role;
    private String password;
}
