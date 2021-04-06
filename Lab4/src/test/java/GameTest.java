import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game = new Game();
    @Test
    void isValidInput() {
        String[] validInput = {"rock", "paper", "scissors"};
        String[] invalidInput = {"Hello", "$*()JGKL", "Software Testing"};

        for (int i = 0;i < validInput.length;i++) {
            assertTrue(game.isValidInput(validInput[i]));
        }

        for (int i = 0;i < invalidInput.length;i++) {
            int finalI = i; //  Variable used in lambda expression should be final or effectively final
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                game.isValidInput(invalidInput[finalI]);
            });
        }
    }

    @Test
    void getWinnerOfGame() {
        // all P1 win cases
        assertEquals(Game.WhoWinner.P1,
                     game.getWinnerOfGame(Game.R_P_S.ROCK, Game.R_P_S.SCISSORS));
        assertEquals(Game.WhoWinner.P1,
                     game.getWinnerOfGame(Game.R_P_S.PAPER, Game.R_P_S.ROCK));
        assertEquals(Game.WhoWinner.P1,
                     game.getWinnerOfGame(Game.R_P_S.SCISSORS, Game.R_P_S.PAPER));

        // all P1 lose cases
        assertEquals(Game.WhoWinner.P2,
                game.getWinnerOfGame(Game.R_P_S.SCISSORS, Game.R_P_S.ROCK));
        assertEquals(Game.WhoWinner.P2,
                game.getWinnerOfGame(Game.R_P_S.ROCK, Game.R_P_S.PAPER));
        assertEquals(Game.WhoWinner.P2,
                game.getWinnerOfGame(Game.R_P_S.PAPER, Game.R_P_S.SCISSORS));

        // all draw cases
        assertEquals(Game.WhoWinner.DRAW,
                     game.getWinnerOfGame(Game.R_P_S.ROCK, Game.R_P_S.ROCK));
        assertEquals(Game.WhoWinner.DRAW,
                     game.getWinnerOfGame(Game.R_P_S.PAPER, Game.R_P_S.PAPER));
        assertEquals(Game.WhoWinner.DRAW,
                     game.getWinnerOfGame(Game.R_P_S.SCISSORS, Game.R_P_S.SCISSORS));
    }
}