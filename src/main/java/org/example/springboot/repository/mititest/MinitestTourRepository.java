package org.example.springboot.repository.mititest;

import org.example.springboot.model.minitest.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MinitestTourRepository extends JpaRepository<Tour, Integer> {
//    @Modifying
//    @Transactional
//    @Query("UPDATE tour b SET b.code = :code, b.destination = :destination, b.start = :start, b.img = :img WHERE b.id = :id")
//    void updateTour(@Param("code") String code,
//                    @Param("destination") String destination,
//                    @Param("start") Date start,
//                    @Param("img") String img,
//                    @Param("id") int id);
    Page<Tour> findByCodeContainingIgnoreCase(String query, Pageable pageable);

}