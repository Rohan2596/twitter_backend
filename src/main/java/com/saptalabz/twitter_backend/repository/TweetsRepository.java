package com.saptalabz.twitter_backend.repository;

import com.saptalabz.twitter_backend.model.Tweet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetsRepository extends MongoRepository<Tweet, String> {
}
