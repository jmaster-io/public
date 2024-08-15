package com.trungtamjava.multidatasource;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.trungtamjava.multidatasource.model.card.Card;
import com.trungtamjava.multidatasource.model.cardholder.CardHolder;
import com.trungtamjava.multidatasource.model.member.Member;
import com.trungtamjava.multidatasource.repository.card.CardRepository;
import com.trungtamjava.multidatasource.repository.cardholder.CardHolderRepository;
import com.trungtamjava.multidatasource.repository.member.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultipledatasourcesApplicationTests {

	/*
	 * We will be using mysql databases we configured in our properties file for our
	 * tests Make sure your datasource connections are correct otherwise the test
	 * will fail
	 */

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private CardHolderRepository cardHolderRepository;

	@Autowired
	private CardRepository cardRepository;

	private Member member;
	private Card card;
	private CardHolder cardHolder;

	@Before
	public void initializeDataObjects() {

		member = new Member();
		member.setMemberId("M001");
		member.setName("Maureen Mpofu");

		cardHolder = new CardHolder();
		cardHolder.setCardNumber("4111111111111111");
		cardHolder.setMemberId(member.getMemberId());

		card = new Card();
		card.setExpirationMonth(01);
		card.setExpirationYear(2020);
		card.setName(member.getName());

	}

	@Test
	public void shouldSaveMemberToMemberDB() {
		Member savedMember = memberRepository.save(member);
		Optional<Member> memberFromDb = memberRepository.findById(savedMember.getId());
		assertTrue(memberFromDb.isPresent());
	}

	@Test
	public void shouldSaveCardHolderToCardHolderDB() {
		CardHolder savedCardHolder = cardHolderRepository.save(cardHolder);
		Optional<CardHolder> cardHolderFromDb = cardHolderRepository.findById(savedCardHolder.getId());
		assertTrue(cardHolderFromDb.isPresent());
	}

	@Test
	public void shouldSaveCardToCardDB() {
		Card savedCard = cardRepository.save(card);
		Optional<Card> cardFromDb = cardRepository.findById(savedCard.getId());
		assertTrue(cardFromDb.isPresent());
	}
}
