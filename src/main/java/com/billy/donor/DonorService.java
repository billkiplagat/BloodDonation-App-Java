package com.billy.donor;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DonorService {
    private final DonorRepository donorRepository;


    public void registerNewDonor(NewDonationRequest newDonationRequest) {
        DonorEntity donorEntity = new DonorEntity();
        BeanUtils.copyProperties(newDonationRequest, donorEntity);
        donorRepository.save(donorEntity);

    }
//    public List<DonorEntity> getAllDonors(){
//        return donorRepository.findAll();
//    }

    public List<DonorEntityResponse> getAllDonors() {
        List<DonorEntity> donorEntityList = donorRepository.findAll();
        return donorEntityList.stream().map(donorEntity -> DonorEntityResponse.builder()
                .id(donorEntity.getId())
                .phoneNumber(donorEntity.getPhoneNumber())
                .bloodType(donorEntity.getBloodType())
                .fullName(donorEntity.getFullName())
                .location(donorEntity.getLocation())
                .build()

        ).collect(Collectors.toList());
    }
}
