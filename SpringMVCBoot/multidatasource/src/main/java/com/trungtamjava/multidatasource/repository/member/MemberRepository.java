package com.trungtamjava.multidatasource.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trungtamjava.multidatasource.model.member.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}