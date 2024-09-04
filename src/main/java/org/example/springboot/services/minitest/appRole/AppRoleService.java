package org.example.springboot.services.minitest.appRole;

import org.example.springboot.model.minitest.AppRole;
import org.example.springboot.repository.mititest.AppRoleRepo;
import org.example.springboot.repository.mititest.AppUserRepo;
import org.example.springboot.services.minitest.IGenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppRoleService implements IAppRoleService {
    @Autowired
    private AppRoleRepo appRoleRepository;

    @Override
    public Iterable<AppRole> findAll() {
        return appRoleRepository.findAll();
    }

    @Override
    public Optional<AppRole> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(AppRole appRole) {

    }

    @Override
    public void remove(int id) {

    }
}
