package umc.spring.service.MissionService;


import umc.spring.domain.enums.MissionStatus;


public interface MissionQueryService {



    boolean findByMemberIdAndMissionIdAndStatus(Long memberId, Long missionId, MissionStatus status);
}