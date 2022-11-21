package com.billy.donor;

import com.billy.config.AesEncryptor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Convert;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewDonationRequest {
    private String fullName;
    @NotBlank(message = "Number cannot be blank")
    private String phoneNumber;
    private String bloodType;
    private String location;
}
//