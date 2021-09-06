package model;


import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int size;

    private final ArrayList<Snake> snakes;

    private final List<Ladder> ladders;

    public Board(int size) {
        this.size = size;
        this.snakes=new ArrayList<Snake>();
        this.ladders=new ArrayList<Ladder>();
    }

   public boolean addSnake(Snake snake){
        if(snake.getHead()>snake.getTail()){
            snakes.add(snake);
            return true;
        }
        return false;
    }


    public int getEnd() {
        return size-1;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }
}