package com.demo.mapper;

import com.demo.dto.RatingRecordRequest;
import com.demo.entity.RatingPrimaryKey;
import com.demo.entity.RatingRecord;

public class EntityDtoRatingMapper {
    private EntityDtoRatingMapper() {
    }

    public static RatingRecordRequest entityToDto(RatingRecord entity){
        RatingRecordRequest dto = new RatingRecordRequest();
        dto.setRatingValue(entity.getRatingValue());
        dto.setBookId(entity.getPrimaryKey().getBookId());
        dto.setUserId(entity.getPrimaryKey().getUserId());
        return dto;
    }

    public static RatingRecord dtoToEntity(RatingRecordRequest dto){
        RatingRecord entity = new RatingRecord();
        RatingPrimaryKey primaryKey = new RatingPrimaryKey();
        primaryKey.setUserId(dto.getUserId());
        primaryKey.setBookId(dto.getBookId());
        entity.setPrimaryKey(primaryKey);
        entity.setRatingValue(dto.getRatingValue());
        return entity;
    }
}
