package org.example.co2_data.db;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.annotation.PostConstruct;
import org.example.co2_data.pojos.CO2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class InitDB {
  @Autowired
  private Co2Repository co2Repository;

  @PostConstruct
  public void createDateFromFile() {
    InputStream inputStream = this.getClass().getResourceAsStream("/mockdata.json");
    ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    try {
      List<CO2> co2 = objectMapper.readerForListOf(CO2.class).readValue(inputStream);
      co2Repository.saveAll(co2);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
