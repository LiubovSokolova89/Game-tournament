package ru.netology.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.Player;
import ru.netology.exception.NotRegisteredException;

public class GameTest {
    Game game = new Game();

    Player player1 = new Player(1, "Alex", 10);
    Player player2 = new Player(2, "Leo", 15);
    Player player3 = new Player(3, "Geo", 10);

    @BeforeEach
    public void setup() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
    }

    @Test
    public void shouldFirstPlayerWins() {
        int actual = game.round(player2.getName(), player1.getName());
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSecondPlayerWins() {
        int actual = game.round(player3.getName(), player2.getName());
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldShowNobodyWings() {
        int actual = game.round(player1.getName(), player3.getName());
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldShowNotRegisteredExceptionFirst() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Sveta" , player3.getName());
        });
    }

    @Test
    public void shouldShowNotRegisteredExceptionSecond() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player1.getName(), "Masha");
        });
    }

    @Test
    public void shouldShowNotRegisteredExceptionTwo() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Masha", "Dasha");
        });
    }

    @Test
    public void shouldSearchById() {
        int expected = 3;
        int actual = player3.getId();
        Assertions.assertEquals(expected, actual);
    }
}
