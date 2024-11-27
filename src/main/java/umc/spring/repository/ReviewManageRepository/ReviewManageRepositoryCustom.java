package umc.spring.repository.ReviewManageRepository;

import umc.spring.domain.ReviewManageDTO;

import java.util.List;

public interface ReviewManageRepositoryCustom {
    List<ReviewManageDTO> findReviewListByStore(Long storeId);


}
