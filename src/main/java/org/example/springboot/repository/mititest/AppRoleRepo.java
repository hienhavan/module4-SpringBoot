package org.example.springboot.repository.mititest;

import org.example.springboot.model.minitest.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepo extends JpaRepository<AppRole, Integer> {
}
