package org.example.co2_data.web;

import org.example.co2_data.db.CO2Repository;
import org.example.co2_data.pojos.CO2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @GetMapping("/api/CO2/stats")
    public ResponseEntity<?> getCo2Stats(
        @RequestParam String classRoom,
        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime from,
        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime to
    ) {
        Float max = co2Repository.findMaxCo2Value(classRoom, from, to);
        Float min = co2Repository.findMinCo2Value(classRoom, from, to);
        Float avg = co2Repository.findAvgCo2Value(classRoom, from, to);

        if (max == null && min == null && avg == null) {
            return ResponseEntity.ok("Keine Daten im angebenen Zeitraum");
        }

        List stats = new ArrayList<Float>();
        stats.add(max);
        stats.add(min);
        stats.add(avg);

        return ResponseEntity.ok(
            stats
        );
    }

    @GetMapping("/api/CO2/live")
    public ResponseEntity<?> getLatestValue(@RequestParam String classRoom) {
        Float latestCO2 = co2Repository.getLatestMeasurement(classRoom);

        return ResponseEntity.ok(latestCO2);
    }

}
