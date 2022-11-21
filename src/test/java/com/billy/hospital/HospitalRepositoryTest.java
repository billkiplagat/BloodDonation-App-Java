//package com.billy.hospital;
//import lombok.RequiredArgsConstructor;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest
//@RequiredArgsConstructor
//class HospitalRepositoryTest {
//    private HospitalRepository hospitalRepository;
//
//    @Test
//    public void createHospitalWithDonation(){
//
//        Hospital hospital = Hospital.builder()
//                .name("kenyatta")
//                .address("Nai")
//                .phoneNumber("23424234")
//                .email("hosi@gmail.com")
//                .build();
//
//
//        HospitalDonationRequest hospitalDonationRequest = HospitalDonationRequest
//                .builder()
//                .bloodType("A+")
//                .hospital(hospital)
//                .build();
//
//        hospitalRepository.save(hospitalDonationRequest);
//    }
//
//}