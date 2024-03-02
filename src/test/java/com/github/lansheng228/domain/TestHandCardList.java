//package com.github.lansheng228.domain;
//
//import com.github.lansheng228.domain.card.CardColor;
//import com.github.lansheng228.domain.player.HandCardList;
//import com.github.lansheng228.domain.testhelper.CardTestFactory;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class TestHandCardList {
//    @Test
//    public void GivenSameNumberCard_ShouldExist() {
//        var numberCard = CardTestFactory.createNumberCard(1, CardColor.YELLOW);
//        var sameNumberCard = CardTestFactory.createNumberCard(1, CardColor.YELLOW);
//
//        var handCards = new HandCardList();
//        handCards.addCard(numberCard);
//
//        var result = handCards.hasCard(sameNumberCard);
//
//        assertTrue(result);
//    }
//
//    @Test
//    public void GivenDifferentNumberCard_ShouldNotExist() {
//        var numberCard = CardTestFactory.createNumberCard(1, CardColor.YELLOW);
//        var anotherNumberCard = CardTestFactory.createNumberCard(2, CardColor.YELLOW);
//
//        var handCards = new HandCardList();
//        handCards.addCard(numberCard);
//
//        var result = handCards.hasCard(anotherNumberCard);
//
//        assertFalse(result);
//    }
//}
