package org.example.co2_data.web;

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
public class InitData {
    @Autowired
    private CO2Repository repository;

    @PostConstruct
    private void initData(){
        InputStream inputStream = this.getClass().getResourceAsStream("/co2_data.json");
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

        try {
            List<CO2> co2Values = objectMapper.readerForListOf(CO2.class)
                    .readValue(inputStream);

            repository.saveAll(co2Values);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
