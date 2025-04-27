package model;

public class Game {
    static Game game = new Game();
    private Game(){

    }
    private String player1Name;
    private String player2Name;
    private Icon player1Icon;
    private  Icon player2Icon;

    public String getPlayer1Name() {
        return player1Name;
    }

    public void setPlayer1Name(String player1Name) {
        this.player1Name = player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public void setPlayer2Name(String player2Name) {
        this.player2Name = player2Name;
    }

    public Icon getPlayer1Icon() {
        return player1Icon;
    }

    public void setPlayer1Icon(Icon player1Icon) {
        this.player1Icon = player1Icon;
    }

    public Icon getPlayer2Icon() {
        return player2Icon;
    }

    public void setPlayer2Icon(Icon player2Icon) {
        this.player2Icon = player2Icon;
    }

    public static Game getGame(){
        return game;
    }
}
