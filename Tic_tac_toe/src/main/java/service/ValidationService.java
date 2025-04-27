package service;

import model.Board;
import model.Icon;

public class ValidationService {
    public boolean isValidMove(int x,  int y ){
        Icon[][] gameBoard = Board.getBoard().getGameBoard();
        if(x<0 || x>= gameBoard.length || y<0 || y>= gameBoard[0].length)
            return false;
        return true;
    }
}
