package com.francis.bottomfeeder.Initializer;

import com.francis.bottomfeeder.model.Role;
import com.francis.bottomfeeder.model.enums.ERole;
import com.francis.bottomfeeder.repository.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Data
@Component
@AllArgsConstructor
@Transactional
public class AppInitializer implements ApplicationRunner {

    private final RoleRepository roleRepository;

    @Override
    public void run(ApplicationArguments args) {
        log.info("In the app runner");
        Role role;
        if (roleRepository.findByName(ERole.ADMIN).isEmpty()) {
            role = new Role();
            role.setName(ERole.ADMIN);
            roleRepository.save(role);
        }
        if (roleRepository.findByName(ERole.USER).isEmpty()) {
            role = new Role();
            role.setName(ERole.USER);
            roleRepository.save(role);
        }

    }
}