package com.trungtamjava.multidatasource.repository.card;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trungtamjava.multidatasource.model.card.Card;

public interface CardRepository extends JpaRepository<Card, Long> {
}
