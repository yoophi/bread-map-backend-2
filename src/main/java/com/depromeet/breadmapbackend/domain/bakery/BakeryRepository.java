package com.depromeet.breadmapbackend.domain.bakery;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BakeryRepository extends JpaRepository<Bakery, Long>, BakeryRepositoryCustom {

}