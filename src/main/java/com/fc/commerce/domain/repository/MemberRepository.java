package com.fc.commerce.domain.repository;

import com.fc.commerce.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

	Optional<Member> findByName(String name);

}
