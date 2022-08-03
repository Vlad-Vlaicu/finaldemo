package com.demo.controllers;

import com.demo.dto.RatingRecordRequest;
import com.demo.dto.RatingRecordResponse;
import com.demo.service.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
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

    @GetMapping("/getRating")
    public ResponseEntity<RatingRecordResponse> getRating(@RequestParam Map<String,String> primaryKey){
        int userId = Integer.parseInt(primaryKey.get("userId"));
        int bookId = Integer.parseInt(primaryKey.get("bookId"));
        return ResponseEntity.of(Optional.of(ratingService.getRatingRecord(userId,bookId)));
    }

    @GetMapping("/getAllRatings")
    public ResponseEntity<RatingRecordResponse> getAllRatings(){
        return ResponseEntity.of(Optional.of(ratingService.getAllRatings()));
    }

    @GetMapping("/getRatingByUser/{userId}")
    public ResponseEntity<RatingRecordResponse> getRatingsByUser(@PathVariable Integer userId){
        return ResponseEntity.of(Optional.of(ratingService.getRatingsByUser(userId)));
    }

    @GetMapping("/getRatingByBook/{bookId}")
    public ResponseEntity<RatingRecordResponse> getRatingsByBook(@PathVariable Integer bookId){
        return ResponseEntity.of(Optional.of(ratingService.getRatingsByBook(bookId)));
    }


}
