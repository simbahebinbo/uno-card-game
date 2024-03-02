//package com.github.lansheng228.domain.testhelper;
//
//import com.github.lansheng228.domain.player.HandCardList;
//import com.github.lansheng228.domain.player.Player;
//
//public class PlayerTestFactory {
//    public static Player[] createPlayers(int total) {
//        Player[] players = new Player[total];
//
//        for (int i = 0; i < players.length; i++) {
//            var handCards = new HandCardList();
//            players[i] = new Player(String.format("%s", i + 1), handCards);
//        }
//
//        return players;
//    }
//}
