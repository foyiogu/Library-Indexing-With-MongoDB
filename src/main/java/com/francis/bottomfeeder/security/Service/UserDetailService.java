package com.francis.bottomfeeder.security.Service;

import com.francis.bottomfeeder.exception.ResourceNotFoundException;
import com.francis.bottomfeeder.model.UserEntity;
import com.francis.bottomfeeder.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@AllArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email).orElseThrow
                (()-> new ResourceNotFoundException("User with email :" + email+ ", not found"));
        log.info("Loading user from database by username");
        return UserDetailsImpl.build(user);
    }

}