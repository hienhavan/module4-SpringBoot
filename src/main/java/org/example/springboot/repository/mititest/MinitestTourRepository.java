package org.example.springboot.repository.mititest;

import org.example.springboot.model.minitest.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MinitestTourRepository extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student> {
    //    @Modifying
//    @Transactional
//    @Query("UPDATE tour b SET b.code = :code, b.destination = :destination, b.start = :start, b.img = :img WHERE b.id = :id")
//    void updateTour(@Param("code") String code,
//                    @Param("destination") String destination,
//                    @Param("start") Date start,
//                    @Param("img") String img,
//                    @Param("id") int id);
    Page<Student> findByNameContainingIgnoreCase(String query, Pageable pageable);

}