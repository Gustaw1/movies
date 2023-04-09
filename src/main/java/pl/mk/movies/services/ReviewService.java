package pl.mk.movies.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import pl.mk.movies.models.Movie;
import pl.mk.movies.models.Review;
import pl.mk.movies.repos.ReviewRepo;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String content, String filmwebId) {
        Review review = reviewRepo.insert(new Review(content));
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("filmwebId").is(filmwebId))
                .apply(new Update().push("reviewIds").value(review)).first();
        return review;
    }
}
