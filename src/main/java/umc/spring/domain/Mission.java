package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.mapping.MemberMission;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer reward;
    @Column(nullable = false)
    private Integer price;
    @Column(nullable = false)
    private LocalDate deadline;

    @Column(nullable = false)
    private String missionSpec;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private final List<MemberMission> memberMissionList = new ArrayList<>();

    public void setStore(Store store) {
        if(this.store != null)
            store.getMissionList().remove(this);
        this.store = store;
        store.getMissionList().add(this);
    }
    @Override
    public String toString() {
        Period period = Period.between(LocalDate.now(), deadline);
        int daysBetween = period.getDays() + (period.getMonths() * 30) + (period.getYears() * 365); // 근사치로 계산
        return "MemberMission{" +
                "id=" + id +
                ", name=" + store.getName() +
                ", deadline=" + daysBetween +
                ", price=" + price +
                ", reward=" + reward +
                '}';
    }
}