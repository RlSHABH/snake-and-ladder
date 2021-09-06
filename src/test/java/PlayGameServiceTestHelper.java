import model.Board;
import model.CrookedDice;
import model.Dice;
import model.Snake;

import java.util.ArrayList;
import java.util.List;

public class PlayGameServiceTestHelper {



    static Board getBoard(){
        Board board= new Board(100);
        board.addSnake(new Snake(14,7));
        return board;
    }


     static List<Dice> getDiceList() {
        Dice normalDice=new Dice(6,1,"NORMAL_DICE");
        Dice crookedDice=new CrookedDice(6,1,"CROOKED_DICE");
        List<Dice> diceList=new ArrayList();
        diceList.add(normalDice);
        diceList.add(crookedDice);
        return diceList;

    }
}
