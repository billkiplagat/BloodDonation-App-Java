package com.billy.hospital;

import com.billy.config.AesEncryptor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Convert;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HospitalResponse {
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String bloodType;
}

