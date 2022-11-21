package com.billy.user;

import com.billy.config.ApplicationUserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("no username with that password"));

        return User.builder()
                .username(userEntity.getEmail())
                .password(userEntity.getPassword())
                .authorities(userEntity.getRole().getAuthority())
                .accountExpired(false)
                .credentialsExpired(false)
                .build();
    }

    public void registerUser(NewUserRegistrationRequest registrationRequest) {
        UserEntity userEntity = new UserEntity();

        BeanUtils.copyProperties(registrationRequest, userEntity);
        userEntity.setRole(ApplicationUserRole.DONOR);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userRepository.save(userEntity);
    }

    public void registerAdmin(NewUserRegistrationRequest registrationRequest) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(registrationRequest, userEntity);
        userEntity.setRole(ApplicationUserRole.ADMIN);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userRepository.save(userEntity);
    }

//    public UserProfileResponse getUserById(Long userId) {
//        UserEntity user = userRepository.findById(userId)
//                .orElseThrow(()-> new RuntimeException("no user with that profile"));
//        UserProfileResponse response = new UserProfileResponse();
//        BeanUtils.copyProperties(user, response);
//        return response;
//    }


}
