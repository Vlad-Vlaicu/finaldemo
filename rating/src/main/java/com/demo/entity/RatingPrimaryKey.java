package com.demo.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class RatingPrimaryKey implements Serializable {
    private int userID;
    private int bookId;
    private int ratingValue;
}
