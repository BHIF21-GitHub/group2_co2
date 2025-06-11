package org.example.co2_data.web;

import org.example.co2_data.pojos.CO2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CO2Repository extends JpaRepository<CO2, Long> {
    @Query("SELECT c FROM CO2 c WHERE c.classRoom = :classRoom AND c.dateTime BETWEEN :from AND :to")
    List<CO2> findValuesByClassRoomAndDateRange(
            @Param("classRoom") String classRoom,
            @Param("from") LocalDateTime from,
            @Param("to") LocalDateTime to
    );
}
