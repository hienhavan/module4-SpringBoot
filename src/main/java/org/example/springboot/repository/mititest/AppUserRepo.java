package org.example.springboot.repository.mititest;

import org.example.springboot.model.minitest.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser, Integer> {
    Optional<AppUser>  findByEmail(String email);
}
