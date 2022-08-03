package com.demo.service;

import com.demo.dto.RatingRecordRequest;
import com.demo.dto.RatingRecordResponse;
import com.demo.entity.RatingPrimaryKey;
import com.demo.entity.RatingRecord;
import com.demo.mapper.EntityDtoRatingMapper;
import com.demo.repository.RatingRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RatingService {


    private final RatingRepository repository;

    public RatingRecordResponse registerRating(RatingRecordRequest request){

            RatingRecordResponse response = new RatingRecordResponse();

            if(validateBook(request.getBookId()) && validateUser(request.getUserId())){
                response.setStatus(HttpStatus.BAD_REQUEST);
                return response;
            }

            RatingRecord ratingRecord = EntityDtoRatingMapper.dtoToEntity(request);

            repository.save(ratingRecord);

            boolean isEntitySaved = isRatingRecordSaved(ratingRecord);

            if(isEntitySaved){
                response.setStatus(HttpStatus.OK);
            } else {
                response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return response;
    }

    private boolean validateUser(Integer userID){
        return false;
    }

    private boolean validateBook(Integer bookId){
        return false;
    }

    private boolean isRatingRecordSaved(RatingRecord ratingRecord){
        var res = repository.findById(new RatingPrimaryKey
                (ratingRecord.getPrimaryKey().getUserId(),
                ratingRecord.getPrimaryKey().getBookId()));

        return res.isPresent();
    }

    public RatingRecordResponse getRatingRecord(Integer userId, Integer bookId){
        RatingRecordResponse response = new RatingRecordResponse();
        var res = repository.findById(new RatingPrimaryKey(userId, bookId));
        if(res.isPresent()){
            response.setStatus(HttpStatus.OK);
            response.setData(List.of(EntityDtoRatingMapper.entityToDto(res.get())));
        } else {
            response.setStatus(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    public RatingRecordResponse getAllRatings(){
        RatingRecordResponse response = new RatingRecordResponse();
        response.setStatus(HttpStatus.OK);
        response.setData(repository.findAll().stream()
                .map(EntityDtoRatingMapper::entityToDto)
                .collect(Collectors.toList()));

        return response;
    }

    public RatingRecordResponse getRatingsByUser(int userId){
        RatingRecordResponse response = new RatingRecordResponse();
        response.setStatus(HttpStatus.OK);

        response.setData(getAllRatings().getData().stream()
                .filter(s -> s.getUserId().equals(userId))
                .collect(Collectors.toList()));

        return response;
    }

    public RatingRecordResponse getRatingsByBook(int bookId){
        RatingRecordResponse response = new RatingRecordResponse();
        response.setStatus(HttpStatus.OK);

        response.setData(getAllRatings().getData().stream()
                .filter(s -> s.getBookId().equals(bookId))
                .collect(Collectors.toList()));

        return response;
    }


}
