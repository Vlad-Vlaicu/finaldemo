package com.demo.repository;

import com.demo.entity.RatingPrimaryKey;
import com.demo.entity.RatingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<RatingRecord, RatingPrimaryKey> {

}
