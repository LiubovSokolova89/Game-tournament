package ru.netology.game;

import ru.netology.data.Player;
import ru.netology.exception.NotRegisteredException;

import java.util.ArrayList;

public class Game {
    protected ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int round(String name1, String name2) {
        Player player1 = null;
        Player player2 = null;

        for(Player player : players) {
            if (player.getName().equals(name1)) {
                player1 = player;
            }
            if (player.getName().equals(name2)) {
                player2 = player;
            }
        }

        if (player1 == null) {
            throw new NotRegisteredException("Игрок" + name1 + "не зарегистрирован");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Игрок" + name2 + "не зарегистрирован");
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }
}
