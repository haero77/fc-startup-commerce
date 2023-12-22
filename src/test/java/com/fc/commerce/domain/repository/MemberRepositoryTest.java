package com.fc.commerce.domain.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.fc.commerce.common.support.RepositoryTestSupport;
import com.fc.commerce.domain.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

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