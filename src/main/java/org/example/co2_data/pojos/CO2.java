package org.example.co2_data.pojos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class CO2 {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private int sensorNr;

  private float co2;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime date;
}
