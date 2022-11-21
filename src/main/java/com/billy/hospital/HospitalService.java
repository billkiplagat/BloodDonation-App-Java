package com.billy.hospital;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    public void registerHospital(NewHospitalRegistrationRequest hospitalRequest) {
        Hospital hospital = new Hospital();
        BeanUtils.copyProperties(hospitalRequest, hospital);
        hospitalRepository.save(hospital);
    }

    public List<HospitalResponse> getAllHospitals() {
        List<Hospital> hospitalList = hospitalRepository.findAll();

        return hospitalList.stream().map(hospital -> HospitalResponse.builder()
                .id(hospital.getId())
                .address(hospital.getAddress())
                .email(hospital.getEmail())
                .name(hospital.getName())
                .phoneNumber(hospital.getPhoneNumber())
                .bloodType(hospital.getBloodType())
                .build()
        ).collect(Collectors.toList());
    }





}