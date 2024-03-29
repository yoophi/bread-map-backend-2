package com.depromeet.breadmapbackend.domain.flag;

import com.depromeet.breadmapbackend.domain.bakery.Bakery;
import com.depromeet.breadmapbackend.domain.common.BaseEntity;
import com.depromeet.breadmapbackend.domain.user.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Flag extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bakery_id")
    private Bakery bakery;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private FlagType flagType;

    @Builder
    private Flag(User user, Bakery bakery, FlagType flagType) {
        this.user = user;
        this.bakery = bakery;
        this.flagType = flagType;
    }

    public void updateFlagType(FlagType flagType) {
        this.flagType = flagType;
    }
}
