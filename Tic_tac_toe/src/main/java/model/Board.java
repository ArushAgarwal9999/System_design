package model;

public class Board {
    private  Icon[][] gameBoard = new Icon[3][3];

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private int count = 0;
    private Board(){

    }
    static Board board = new Board();
    public static Board getBoard(){
        return board;
    }
    public  Icon[][] getGameBoard(){
        return gameBoard;
    }

}
