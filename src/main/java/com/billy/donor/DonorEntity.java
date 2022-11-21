package com.billy.donor;

import com.billy.config.AesEncryptor;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tbl_donor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DonorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "donor_id")
    private Long id;
    @Convert(converter = AesEncryptor.class)
    private String fullName;
    @Convert(converter = AesEncryptor.class)
    private String phoneNumber;
    private String bloodType;
    private String location;


}
