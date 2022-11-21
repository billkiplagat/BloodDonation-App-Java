package com.billy.controllers;

import com.billy.donor.DonorService;
import com.billy.donor.NewDonationRequest;
import com.billy.hospital.HospitalResponse;
import com.billy.hospital.HospitalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/universal")
@RequiredArgsConstructor
@Slf4j
public class AdminAndDonorController {
    private final DonorService donorService;
    private final HospitalService hospitalService;

    @PostMapping("/saveNewDonor")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerNewDonor (@RequestBody @Valid NewDonationRequest newDonationRequest){
        log.info("New Donor Registered: {}",newDonationRequest);
        donorService.registerNewDonor(newDonationRequest);
    }
    @GetMapping("/getAllHospitals")
    public List<HospitalResponse> getAllHospitals() {
        return hospitalService.getAllHospitals();
    }

}
