package umc.spring.service.MissionService;

import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.enums.MissionStatus;

import java.util.List;
import java.util.Optional;

public interface MissionQueryService {
    Optional<Mission> findMission(Long id);
    List<Mission> findMissionByMissionStatus(MissionStatus status);
}
