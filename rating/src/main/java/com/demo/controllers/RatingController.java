package com.demo.controllers;

import com.demo.dto.RatingRecordRequest;
import com.demo.dto.RatingRecordResponse;
import com.demo.service.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/ratings")
@AllArgsConstructor
public class RatingController {

    private final RatingService ratingService;

    @Transactional
    @PostMapping
    public ResponseEntity<RatingRecordResponse> registerRating(@RequestBody RatingRecordRequest ratingRecordRequest){
        RatingRecordResponse response = ratingService.registerRating(ratingRecordRequest);
        return ResponseEntity.of(Optional.of(response));
    }

    @GetMapping("/testPing")
    public ResponseEntity<Integer> testPing(){
        return ResponseEntity.of(Optional.of(777));
    }

    @GetMapping("/get")
    public ResponseEntity<RatingRecordResponse> getRating(@RequestParam Map<String,String> primaryKey){
        String userIdRequest = primaryKey.get("userId");
        String bookIdRequest = primaryKey.get("bookId");

        if(userIdRequest == null || bookIdRequest == null){
            RatingRecordResponse response = new RatingRecordResponse();
            response.setStatus(HttpStatus.BAD_REQUEST);
            return ResponseEntity.of(Optional.of(response));
        }
        int userId = 0;
        int bookId = 0;
        try{
            userId = Integer.parseInt(userIdRequest);
            bookId = Integer.parseInt(bookIdRequest);
        }catch(Exception e){
            RatingRecordResponse response = new RatingRecordResponse();
            response.setStatus(HttpStatus.BAD_REQUEST);
            return ResponseEntity.of(Optional.of(response));
        }

        return ResponseEntity.of(Optional.of(ratingService.getRatingRecord(userId,bookId)));
    }

    @GetMapping
    public ResponseEntity<RatingRecordResponse> getAllRatings(){
        return ResponseEntity.of(Optional.of(ratingService.getAllRatings()));
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<RatingRecordResponse> getRatingsByUser(@PathVariable Integer userId){
        return ResponseEntity.of(Optional.of(ratingService.getRatingsByUser(userId)));
    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<RatingRecordResponse> getRatingsByBook(@PathVariable Integer bookId){
        return ResponseEntity.of(Optional.of(ratingService.getRatingsByBook(bookId)));
    }

}
