package model;




public class Player {

    private final String playerId;
    private final String name;

    private int position;

    private boolean won;
    public Player(String playerId,String name) {
        this.playerId=playerId;
        this.name = name;
        this.position = 0;
        this.won = false;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setWon(boolean won) {
        this.won = won;
    }
}
