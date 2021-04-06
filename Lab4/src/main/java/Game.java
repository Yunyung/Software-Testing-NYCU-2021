public class Game {


    public enum R_P_S {
        ROCK, PAPER, SCISSORS
    }

    public enum WhoWinner {
        P1, P2, DRAW
    }

    public boolean isValidInput(String p) {
        // validate
        if (!p.equals("rock") && !p.equals("paper") && !p.equals("scissors"))
            throw new IllegalArgumentException();

        return true;
    }

    public WhoWinner getWinnerOfGame(R_P_S p1, R_P_S p2) {
        // DRAW
        if (p1 == p2) return WhoWinner.DRAW;

        // p1 win
        if (p1 == R_P_S.ROCK && p2 == R_P_S.SCISSORS ||
            p1 == R_P_S.PAPER && p2 == R_P_S.ROCK    ||
            p1 == R_P_S.SCISSORS && p2 == R_P_S.PAPER)
        {
            return WhoWinner.P1;
        }
        else return WhoWinner.P2;
    }

    // Translate string to enum
    public Game.R_P_S assignR_P_S(String s) {
        s = s.toUpperCase();
        Game.R_P_S res = null;

        res = Game.R_P_S.valueOf(s);
        return res;
    }
}
