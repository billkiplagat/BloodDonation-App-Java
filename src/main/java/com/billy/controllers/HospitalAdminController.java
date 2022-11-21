package com.billy.controllers;

import com.billy.donor.DonorEntity;
import com.billy.donor.DonorEntityResponse;
import com.billy.donor.DonorService;
import com.billy.hospital.HospitalService;
import com.billy.hospital.NewHospitalRegistrationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@Slf4j
public class HospitalAdminController {
    private final HospitalService hospitalService;
    private final DonorService donorService;

    @PostMapping("/registerHospital")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerHospital(@RequestBody @Valid NewHospitalRegistrationRequest hospitalRequest) {
        log.info("Hospital Registration: {}", hospitalRequest);
        hospitalService.registerHospital(hospitalRequest);
    }
//    @GetMapping("/allDonors")
//    public List<DonorEntity> getAllDonors(){
//        return donorService.getAllDonors();
//    }

    @GetMapping("/allDonors")
    public List<DonorEntityResponse>getAllDonors(){
        return donorService.getAllDonors();
    }

//    public void registerHospitalWithDonation()

}
