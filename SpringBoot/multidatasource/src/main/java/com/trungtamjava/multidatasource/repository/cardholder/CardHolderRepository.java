package com.trungtamjava.multidatasource.repository.cardholder;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trungtamjava.multidatasource.model.cardholder.CardHolder;

public interface CardHolderRepository extends JpaRepository<CardHolder, Long> {
}