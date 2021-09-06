
import model.*;

import java.util.ArrayList;
import java.util.List;

public class SnakeLadderApplication {
    public static void main(String[] args) throws Exception {
        SnakeAndLadderGame snakeAndLadderGame = new SnakeAndLadderGame(getBoard(),getDiceList());
            Player player = new Player("P_1","Ronny");
            snakeAndLadderGame.addPlayer(player);
            PlayGameService playGameService=new PlayGameService(snakeAndLadderGame);
            //Play game for 10 turns
            for(int i=0;i<10;i++){
                playGameService.playChance(snakeAndLadderGame.anyDice());
            }

    }


   private static Board getBoard(){
      Board board= new Board(100);
      board.addSnake(new Snake(14,7));
      return board;
    }


    private static List<Dice> getDiceList() {
        Dice normalDice=new Dice(6,1,"NORMAL_DICE");
        Dice crookedDice=new CrookedDice(6,1,"CROOKED_DICE");
        List<Dice> diceList=new ArrayList();
        diceList.add(normalDice);
        diceList.add(crookedDice);
        return diceList;

    }

}
