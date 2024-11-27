package umc.spring.repository.MissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Mission;
import umc.spring.domain.QRegion;
import umc.spring.domain.QStore;
import umc.spring.domain.mapping.QMemberMission;
import umc.spring.domain.QMission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.repository.MissionRepository.MissionRepositoryCustom;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMemberMission memberMission = QMemberMission.memberMission;
    private final QMission mission = QMission.mission;
    private final QStore store = QStore.store;
    private final QRegion region = QRegion.region;



    @Override
    public int findCompletedMissionCountByMemberIdAndStatus(Long memberId, MissionStatus status) {
        BooleanBuilder predicate = new BooleanBuilder();
        if(memberId != null) {
            predicate.and(memberMission.member.id.eq(memberId));
        }
        if(status != null) {
            predicate.and(memberMission.status.eq(status));
        }

        return jpaQueryFactory
                .selectFrom(memberMission)
                .where(predicate)
                .fetch().size();
    }

}
