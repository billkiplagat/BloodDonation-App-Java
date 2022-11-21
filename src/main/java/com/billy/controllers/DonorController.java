package com.billy.controllers;

import com.billy.donor.DonorService;
import com.billy.hospital.HospitalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/donor")
@RequiredArgsConstructor
@Slf4j
public class DonorController {
    private final DonorService donorService;
    private final HospitalService hospitalService;




}
