package umc.spring.repository.MissionRepository;

import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;

import java.util.List;

public interface MissionRepositoryCustom {
    int findCompletedMissionCountByMemberIdAndStatus(Long memberId, MissionStatus status);
}

