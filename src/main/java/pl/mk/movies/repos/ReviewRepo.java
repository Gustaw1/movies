package pl.mk.movies.repos;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.mk.movies.models.Review;

@Repository
public interface ReviewRepo extends MongoRepository<Review, ObjectId> {
}
