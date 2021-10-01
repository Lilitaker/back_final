package com.dh.clinicaOdontologicaTI.service.security;

import com.dh.clinicaOdontologicaTI.entity.AppUser;
import com.dh.clinicaOdontologicaTI.entity.AppUserRole;
import com.dh.clinicaOdontologicaTI.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private IUserRepository userRepository;

    @Autowired
    public DataLoader(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("ContraseniaAdmin");
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        String hashedPassword2 = passwordEncoder.encode("ContraseniaUser");

        userRepository.save(new AppUser("Admin","Admin","administradorlv@odontologia.com",
                hashedPassword, AppUserRole.ADMIN));
        userRepository.save(new AppUser("User","User","usuario@odontologia.com",
                hashedPassword, AppUserRole.USER));

    }

}
