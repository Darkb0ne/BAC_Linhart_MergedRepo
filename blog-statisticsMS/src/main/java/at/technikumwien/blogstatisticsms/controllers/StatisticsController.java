package at.technikumwien.blogstatisticsms.controllers;

import at.technikumwien.blogstatisticsms.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/statistics/")
public class StatisticsController {

    @Autowired
    private EventService eventservice;

    @GetMapping(produces = { "application/json" }, path = "/attraction/last-month")
    public ResponseEntity<Map<String, Integer>> getLastMonthAttractionStatistics(){
        return new ResponseEntity<>(eventservice.calculateStatistics("attraction", 1), HttpStatus.OK);
    }

    @GetMapping(produces = { "application/json" }, path = "/attraction/all-time")
    public ResponseEntity<Map<String, Integer>> getAllTimeAttractionStatistics(){
        return new ResponseEntity<>(eventservice.calculateStatistics("attraction", 2), HttpStatus.OK);
    }

    @GetMapping(produces = { "application/json" }, path = "/news/last-month")
    public ResponseEntity<Map<String, Integer>> getLastMonthNewsStatistics(){
        return new ResponseEntity<>(eventservice.calculateStatistics("news", 1), HttpStatus.OK);

    }

    @GetMapping(produces = { "application/json" }, path = "/news/all-time")
    public ResponseEntity<Map<String, Integer>> getAllTimeNewsStatistics(){
        return new ResponseEntity<>(eventservice.calculateStatistics("news", 2), HttpStatus.OK);

    }
}
