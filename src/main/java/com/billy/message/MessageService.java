package com.billy.message;
import com.billy.donor.DonorRepository;
import com.billy.hospital.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final HospitalRepository hospitalRepo;
    private final MessageRepo messageRepo;
    private final DonorRepository donorRepo;

    // Hospital sending Message To Donor
//    public void sendMessageToDonor(String sentMessage, Donor donor,Hospital hospital){
//
//        Optional<Donor> donorOptional = donorRepo.findDonorByFullName(donor.getFullname());
//        if (donorOptional.isPresent()){
//
//            message.setSent(hospital.getMessage().toString());
//
//        }
//        messageRepo.save(message);
//
//    }
}
