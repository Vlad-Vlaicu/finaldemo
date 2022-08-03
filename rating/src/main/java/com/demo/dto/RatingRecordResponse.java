package com.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class RatingRecordResponse {
    HttpStatus status;
    List<RatingRecordRequest> data;
}
