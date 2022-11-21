package com.billy.hospital;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewHospitalRegistrationRequest {
    @NotNull(message = "hospital name cannot be null")
    private String name;
    private String address;
    private String phoneNumber;
    @Email(message = "please provide a valid email")
    private String email;
    private String bloodType;

}
