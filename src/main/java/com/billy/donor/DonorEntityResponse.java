package com.billy.donor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DonorEntityResponse {
    private Long id;
    private String fullName;
    private String phoneNumber;
    private String bloodType;
    private String location;

}
