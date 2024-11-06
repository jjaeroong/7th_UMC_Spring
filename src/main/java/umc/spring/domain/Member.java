package umc.spring.domain;

import jakarta.persistence.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.enums.MemberStatus;
import lombok.*;
import umc.spring.domain.enums.SocialType;
import umc.spring.domain.mapping.MemberAgree;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.mapping.MemberPrefer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity     // JPA가 entity로 인식하며 테이블과 링크될 클래스임을 나타냄
@Getter     // 자동으로 getter 메서드를 생성 - 코드에는 없지만 작성한 것과 동일한 효과
@Builder    // 해당 클래스의 빌더 패턴 클래스를 생성 - 생성자 상단에 생성자에 포함딘 필드만 빌더에 포함
@NoArgsConstructor(access = AccessLevel.PROTECTED)      // 매개변수가 없는 기본 생성자를 자동으로 만들어줌
@AllArgsConstructor     // 모든 필드에 대한 생성자를 자동으로 만들어줌 (모든 필드를 파라미터로 가짐)
public class Member extends BaseEntity {

    @Id // PK로 저장해줌
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // PK 생성 규칙 - 기본값을 자동으로 생성
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 40)
    private String address;

    @Column(nullable = false, length = 40)
    private String specAddress;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus status;

    private LocalDate inactiveDate;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private Integer point;

    private Integer age;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();
}