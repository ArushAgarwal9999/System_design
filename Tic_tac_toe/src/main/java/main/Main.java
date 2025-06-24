package main;

import model.Game;
import model.Icon;
import service.CheckWinService;
import service.PrintBoard;
import service.UpdateGameBoardService;

import java.util.*;

public class Main {
    Game game = Game.getGame();
    PrintBoard printBoard = new PrintBoard();
    UpdateGameBoardService updateGameBoardService = new UpdateGameBoardService();
    CheckWinService checkWinService = new CheckWinService();
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Main main = new Main();
        main.getInput();
    }
    private void getInput(){

        HashMap<Integer, Icon> map = new HashMap<Integer, Icon>();
        int index=  1;
        for(Icon icon: Icon.values())
        {
            map.put(index, icon);
            index++;
        }
        System.out.print(" Enter Player 1 Name -> ");
        game.setPlayer1Name( sc.next());
        System.out.println();
        System.out.print(" Chose game icon  "+ map);
        int num1=  sc.nextInt();
        game.setPlayer1Icon(map.get(num1));
        map.remove(num1);
        System.out.print(" Enter Player 2 Name -> ");
        game.setPlayer2Name( sc.next());
        System.out.println();
        System.out.print(" Chose game icon  "+ map);
        int num2=  sc.nextInt();
        game.setPlayer1Icon( map.get(num2));
        startGame();
    }
    private void startGame(){
        int playerTurn = 0;
        while(true){
            System.out.print("Enter coordinate -> ");
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(playerTurn %2 ==0)
            {

                updateGameBoardService.updateGameBoard(x,y, game.getPlayer1Icon());
                playerTurn = 1;

            }
            else{
                updateGameBoardService.updateGameBoard(x,y, game.getPlayer2Icon());
                playerTurn = 0;
            }
            Icon winIcon = checkWinService.isAnyWin();
            if(winIcon != null && winIcon == game.getPlayer1Icon())
            {
                System.out.println(game.getPlayer1Name()+" Win");
                break;
            }
            if(winIcon != null && winIcon == game.getPlayer2Icon())
            {
                System.out.println(game.getPlayer1Name()+" Win");
                break;
            }
            if(checkWinService.isDraw())
            {
                System.out.println("Draw");
                break;
            }
            printBoard.printBoard();

        }
    }

}
