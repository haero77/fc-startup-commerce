package com.fc.commerce.domain.repository;

import com.fc.commerce.common.support.RepositoryTestSupport;
import com.fc.commerce.domain.entity.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class MemberRepositoryTest extends RepositoryTestSupport {

	@Autowired
	MemberRepository sut;

	@Test
	void findByName() {
		String name = "name1";
		Member member = Member.ofName(name);
		sut.save(member);

		Member actual = sut.findByName(name).get();

		assertAll(
			() -> assertThat(actual).isEqualTo(member),
			() -> assertThat(actual.getName()).isEqualTo(name)
		);
	}

}