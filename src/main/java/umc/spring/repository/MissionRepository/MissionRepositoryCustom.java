package umc.spring.repository.MissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;

import java.util.List;

public interface MissionRepositoryCustom {
    Page<Mission> findMissionsByMemberIdAndStatus(Long memberId, MissionStatus status, Long lastMissionId, Pageable pageable);
    Page<Mission> findNotStartedMissionByMemberIdAndStatusAndRegionName(Long memberId, MissionStatus status, String regionName, Long lastMissionId, Pageable pageable);
    int findCompletedMissionCountByMemberIdAndStatus(Long memberId, MissionStatus status);
}

