package umc.spring.service.ReviewService;

import jakarta.transaction.Transactional;
import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    @Transactional
    Review addReviewToStore(ReviewRequestDTO.addReviewDTO request);
}
