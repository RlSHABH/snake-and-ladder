import model.CrookedDice;
import model.Dice;
import model.Player;
import model.SnakeAndLadderGame;
import org.junit.jupiter.api.*;

import java.io.InvalidObjectException;
import java.util.NoSuchElementException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PlayGameServiceTest {


    private  SnakeAndLadderGame snakeAndLadderGame;


    @BeforeEach
     void beforeEach(){
        snakeAndLadderGame=new SnakeAndLadderGame(PlayGameServiceTestHelper.getBoard(),
                PlayGameServiceTestHelper.getDiceList());
    }

    @Test
    @DisplayName("should move player to new position  as per dice value")
    void playChance_shouldMovePlayer_AsPerDiceValue() throws Exception {
        Player player=new Player("P1","P1");
        snakeAndLadderGame.addPlayer(player);
        PlayGameService playGameService=new PlayGameService(snakeAndLadderGame);
        Dice dice=mock(Dice.class);

        when(dice.roll()).thenReturn(4);
        playGameService.playChance(dice);

        Assertions.assertEquals(4,player.getPosition());

    }

    @Test
    @DisplayName("should move player to snake tail when snake bites")
    void playChance_shouldMovePlayerToSnakeTail_IfLandsOnSnakeHead() throws Exception {
        Player player=new Player("P1","P1");
        snakeAndLadderGame.addPlayer(player);
        PlayGameService playGameService=new PlayGameService(snakeAndLadderGame);
        Dice dice=mock(Dice.class);
        when(dice.roll()).thenReturn(14);
        playGameService.playChance(dice);

        Assertions.assertEquals(7,player.getPosition());

    }

    @Test
    @DisplayName("should return always even no if crooked dice")
    void playChance_shouldReturnAlwaysEvenNumber_IfCrookedDice() throws Exception {
        Player player=new Player("P1","P1");
        snakeAndLadderGame.addPlayer(player);
        PlayGameService playGameService=new PlayGameService(snakeAndLadderGame);
        CrookedDice dice=new CrookedDice(6,1,"CROOKED_DICE");
        playGameService.playChance(dice);
        Assertions.assertNotEquals(1, player.getPosition() % 2);

    }

    @Test
    @DisplayName("should return error If game is over")
    void playChance_shouldReturnError_IfGameIsOver() throws Exception {
        Player player=new Player("P1","P1");
        snakeAndLadderGame.addPlayer(player);
        snakeAndLadderGame.setGameAsOver();
        PlayGameService playGameService=new PlayGameService(snakeAndLadderGame);
        CrookedDice dice=new CrookedDice(6,1,"NORMAL_DICE");

        Assertions.assertThrows(InvalidObjectException.class,
                () -> {
                    playGameService.playChance(dice);;
                });
    }
}