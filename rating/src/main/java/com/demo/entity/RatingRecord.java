package com.demo.entity;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "rating")
@Data
public class RatingRecord {

    @EmbeddedId
    private RatingPrimaryKey primaryKey;

}
