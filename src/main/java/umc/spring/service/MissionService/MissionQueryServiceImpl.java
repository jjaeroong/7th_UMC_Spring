package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.repository.MissionRepository.MissionRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService{

    private final MissionRepository missionRepository;

    @Override
    public Optional<Mission> findMission(Long id) {
        return missionRepository.findById(id);
    }

    @Override
    public List<Mission> findMissionByMissionStatus(MissionStatus status) {
        List<Mission> missions = missionRepository.dynamicQueryWithBooleanBuilder(status);

        missions.forEach(mission -> System.out.println("Mission: " + mission));

        return missions;
    }
}
