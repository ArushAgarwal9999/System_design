package service;

import model.Board;
import model.Icon;

public class PrintBoard {

    public void printBoard(){
        Icon[][] gameBoard = Board.getBoard().getGameBoard();
        for(int i = 0;i<gameBoard.length;i++)
        {
            for(int j = 0;j<gameBoard[i].length;j++)
            {
                if(gameBoard[i][j] != null)
                    System.out.print(gameBoard[i][j]+"  ,");
                else
                    System.out.print("  ,");
            }
            System.out.println();
        }
    }
}
