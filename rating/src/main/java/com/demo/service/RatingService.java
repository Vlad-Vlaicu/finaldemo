package com.demo.service;

import com.demo.dto.RatingRecordRequest;
import com.demo.dto.RatingRecordResponse;
import com.demo.entity.RatingPrimaryKey;
import com.demo.entity.RatingRecord;
import com.demo.repository.RatingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RatingService {
    private final RatingRepository repository;
    public RatingRecordResponse registerRating(RatingRecordRequest request){ //DTO

            //TODO:validate input

            //TODO:mapping

        RatingRecord entityRecord = new RatingRecord();
        RatingPrimaryKey primaryKey = new RatingPrimaryKey();
        primaryKey.setUserID(request.getUserId());
        primaryKey.setBookId(request.getBookId());
        primaryKey.setRatingValue(request.getRatingValue());

        entityRecord.setPrimaryKey(primaryKey);
        //repository.save()

           // return restTemplate.postForObject("http://localhost:8081/api/v1/registerRating", request, RatingRecordResponse.class);
            return new RatingRecordResponse(request.getRatingValue());
    }

}
