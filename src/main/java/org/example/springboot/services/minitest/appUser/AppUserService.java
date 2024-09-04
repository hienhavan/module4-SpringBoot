package org.example.springboot.services.minitest.appUser;

import org.example.springboot.model.minitest.AppUser;
import org.example.springboot.model.minitest.UserPrinciple;
import org.example.springboot.repository.mititest.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipal;
import java.util.Optional;

@Service
public class AppUserService implements IAppUserService {
    @Autowired
    private AppUserRepo appUserRepo;

    @Override
    public Iterable<AppUser> findAll() {
        return appUserRepo.findAll();
    }

    @Override
    public Optional<AppUser> findById(int id) {
        return appUserRepo.findById(id);
    }

    @Override
    public void save(AppUser appUser) {
        appUserRepo.save(appUser);

    }

    @Override
    public void remove(int id) {
        appUserRepo.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Optional<AppUser> userOptional = appUserRepo.findByEmail(userEmail);
        AppUser appUser = userOptional.get();
        if (appUser == null) {
            throw new UsernameNotFoundException("User not found with email: " + userEmail);
        }
        return UserPrinciple.build(appUser);
    }
}
