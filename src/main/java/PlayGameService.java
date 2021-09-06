
import model.Board;
import model.Dice;
import model.Player;
import model.SnakeAndLadderGame;

import java.io.InvalidObjectException;
import java.security.InvalidKeyException;
import java.util.Queue;

public class PlayGameService {

    private final SnakeAndLadderGame snakeAndLadderGame;

    PlayGameService(SnakeAndLadderGame snakeAndLadderGame) {
        this.snakeAndLadderGame = snakeAndLadderGame;

    }

    public void playChance(Dice dice) throws Exception {

        Player player = snakeAndLadderGame.getPlayers().poll();
            if(player==null){
                throw new InvalidKeyException("no player found");
            }
        if (snakeAndLadderGame.isGameOver()) {
            throw new InvalidObjectException("game already over");
        }
        int oldPosition=player.getPosition();
        int val = dice.roll();
        System.out.println(":"+val);
        Board board = snakeAndLadderGame.getBoard();
        Queue<Player> players = snakeAndLadderGame.getPlayers();
        int newPosition = player.getPosition() + val;
        if (newPosition > board.getEnd()) {
            player.setPosition(player.getPosition());
            players.offer(player);
        } else {
            player.setPosition(snakeAndLadderGame.getNewPositionIfEncounterSnakeOrLadder(newPosition));
            if (player.getPosition() == board.getEnd()) {
                player.setWon(true);
                snakeAndLadderGame.setGameAsOver();
                System.out.println("Player " + player.getName() + " Won.");
            } else {
                System.out.println(player.getName() + "'s old position: "+oldPosition+", new position: " + player.getPosition());
                players.offer(player);
            }
        }
    }
}

