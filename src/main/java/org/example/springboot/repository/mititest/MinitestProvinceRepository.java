package org.example.springboot.repository.mititest;

import org.example.springboot.model.dto.ProvinceDTO;
import org.example.springboot.model.minitest.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MinitestProvinceRepository extends JpaRepository<Province, Integer> {
    @Query(value = "SELECT p.name AS name, COUNT(t.id) AS number FROM province p LEFT JOIN tour t ON p.id = t.province_id GROUP BY p.name", nativeQuery = true)
    List<ProvinceDTO> getTourProvinceNumber();

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "CALL UpdateAndDeleteProvince(:id)")
    void deleteProvinceById(@Param("id") int id);
}