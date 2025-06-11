package org.example.co2_data.db;

import org.example.co2_data.pojos.CO2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Co2Repository extends JpaRepository<CO2,Long> {
}
