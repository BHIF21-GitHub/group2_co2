package org.example.co2_data.web;

import org.example.co2_data.db.CO2Repository;
import org.example.co2_data.pojos.CO2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class CO2Controller {

    @Autowired
    private CO2Repository co2Repository;

    @GetMapping("/api/CO2/values")
    public ResponseEntity<List<CO2>> getValuesOfClassroomByTimeSpan(
            @RequestParam String classRoom,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime from,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime to
    ) {
        List<CO2> result = co2Repository.findValuesByClassRoomAndDateRange(classRoom, from, to);
        return ResponseEntity.ok(result);
    }
}
