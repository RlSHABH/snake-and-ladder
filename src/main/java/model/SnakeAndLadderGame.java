package model;

import utils.RandomUtils;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;


public class SnakeAndLadderGame {

    private final Queue<Player> players;
    private final Board board;
    private final List<Dice> diceList;
    private GameStatus gameStatus;

    public SnakeAndLadderGame(Board board, List<Dice> diceList) {
        this.players = new ArrayDeque();
       this.board = board;
        this.diceList = diceList;
        this.gameStatus=GameStatus.STARTED;

    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Queue<Player> getPlayers() {
        return players;
    }



    public Board getBoard() {
        return board;
    }

    public List<Dice> getDiceList() {
        return diceList;
    }

    public Dice anyDice()
    {
        int index = RandomUtils.getRandomNumberUsingNextInt(0,diceList.size());
        Dice dice = diceList.get(index);
        System.out.print("current dice "+dice.getName());
        return dice;

    }

    public void setGameAsOver() {
        this.gameStatus = GameStatus.END;
    }

    public boolean isGameOver(){
        return GameStatus.END.equals(gameStatus);
   }

    public int getNewPositionIfEncounterSnakeOrLadder(int newPosition) {
        for (Snake snake : board.getSnakes()) {
            if (snake.getHead() == newPosition) {
                System.out.println("Snake Bit");
                return snake.getTail();
            }
        }

        for (Ladder ladder : board.getLadders()) {
            if (ladder.getStart() == newPosition) {
                System.out.println("ladder climb");
                return ladder.getEnd();
            }
        }

        return newPosition;
    }
}
