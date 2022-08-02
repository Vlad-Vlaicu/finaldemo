package com.demo.dto;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class RatingRecordRequest{

    Integer userId;
    Integer bookId;
    Integer ratingValue;

}
