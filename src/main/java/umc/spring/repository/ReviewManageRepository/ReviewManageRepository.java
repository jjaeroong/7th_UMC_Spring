package umc.spring.repository.ReviewManageRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Review;

public interface ReviewManageRepository extends JpaRepository<Review, Long>, ReviewManageRepositoryCustom {
}
