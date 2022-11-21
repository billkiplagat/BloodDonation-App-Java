package com.billy.hospital;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Hospital {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "hospital_id")
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String bloodType;

}
