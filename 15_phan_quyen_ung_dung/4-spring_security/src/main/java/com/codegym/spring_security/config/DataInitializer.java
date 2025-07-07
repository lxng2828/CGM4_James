package com.codegym.spring_security.config;

import com.codegym.spring_security.model.Role;
import com.codegym.spring_security.model.User;
import com.codegym.spring_security.repository.RoleRepository;
import com.codegym.spring_security.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, RoleRepository roleRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.count() == 0) {
            Role memberRole = new Role();
            memberRole.setName("ROLE_MEMBER");
            roleRepository.save(memberRole);
            Role adminRole = new Role();
            adminRole.setName("ROLE_ADMIN");
            roleRepository.save(adminRole);
        }
        if (userRepository.count() == 0) {
            Role memberRole = roleRepository.findByName("ROLE_MEMBER").get();
            Role adminRole = roleRepository.findByName("ROLE_ADMIN").get();
            User member = new User();
            member.setUsername("member");
            member.setPassword(passwordEncoder.encode("123"));
            member.setRoles(Set.of(memberRole));
            userRepository.save(member);
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("123"));
            admin.setRoles(Set.of(memberRole, adminRole));
            userRepository.save(admin);
        }
    }
}