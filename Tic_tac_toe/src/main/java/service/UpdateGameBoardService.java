package service;

import model.Board;
import model.Icon;

public class UpdateGameBoardService {
    ValidationService validationService = new ValidationService();
    public void updateGameBoard(int x, int y, Icon icone){
        Icon[][] gameBoard = Board.getBoard().getGameBoard();
        if(!validationService.isValidMove(x,y)){
            System.out.println("Invalid Move");
        }
        gameBoard[x][y] = icone;
        Board.getBoard().setCount(Board.getBoard().getCount()+1);

    }
}
