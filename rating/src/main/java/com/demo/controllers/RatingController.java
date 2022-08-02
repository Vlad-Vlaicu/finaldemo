package com.demo.controllers;

import com.demo.dto.RatingRecordRequest;
import com.demo.dto.RatingRecordResponse;
import com.demo.service.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/rating")
@AllArgsConstructor
public class RatingController {

    private final RatingService ratingService;

    @PostMapping
    public ResponseEntity<RatingRecordResponse> registerRating(@RequestBody RatingRecordRequest ratingRecordRequest){
        RatingRecordResponse response = ratingService.registerRating(ratingRecordRequest);
        return ResponseEntity.of(Optional.of(response));
    }

    @GetMapping("/testPing")
    public ResponseEntity<Integer> testPing(){
        return ResponseEntity.of(Optional.of(777));
    }
}
