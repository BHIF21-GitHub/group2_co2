package org.example.co2_data.pojos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CO2 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sensorNr;
    private float co2_value;


    private LocalDateTime dateTime;
}
