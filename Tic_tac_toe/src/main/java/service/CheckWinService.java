package service;

import model.Board;
import model.Icon;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CheckWinService {
    Icon[][] gameBoard = Board.getBoard().getGameBoard();
    public Icon isAnyWin(){
        for(int i = 0;i<gameBoard.length;i++)
        {
            HashMap<Icon, Integer> map1 = new HashMap<>();
            HashMap<Icon, Integer> map2 = new HashMap<>();
            for(int j = 0;j<gameBoard[i].length;j++)
            {
                if(gameBoard[i][j] != null){
                    map1.put(gameBoard[i][j], map1.getOrDefault(gameBoard[i][j],0)+1);
                }

                if(gameBoard[j][i] != null)
                map2.put(gameBoard[j][i], map2.getOrDefault(gameBoard[j][i],0)+1);
            }
            Optional<Map.Entry<Icon, Integer>> first = map1.entrySet().stream().filter((e) -> e.getValue() == 3).findFirst();
            if(!first.isEmpty()){
                return first.get().getKey();
            }
            first = map2.entrySet().stream().filter((e) -> e.getValue() == 3).findFirst();
            if(!first.isEmpty()){
                return first.get().getKey();
            }

        }
        int counter = gameBoard.length-1;
        HashMap<Icon, Integer> map1 = new HashMap<>();
        HashMap<Icon, Integer> map2 = new HashMap<>();
        for(int i = 0;i<gameBoard.length;i++)
        {
            map1.put(gameBoard[i][i], map1.getOrDefault(gameBoard[i][i],0)+1);
            map2.put(gameBoard[i][counter], map2.getOrDefault(gameBoard[i][counter],0)+1);
            counter--;
        }
        Optional<Map.Entry<Icon, Integer>> first = map1.entrySet().stream().filter((e) -> e.getValue() == 3).findFirst();
        if(!first.isEmpty()){
            return first.get().getKey();
        }
        first = map2.entrySet().stream().filter((e) -> e.getValue() == 3).findFirst();
        if(!first.isEmpty()){
            return first.get().getKey();
        }


        return null;
    }
    public boolean isDraw(){
        if(gameBoard.length* gameBoard[0].length == Board.getBoard().getCount())
            return true;
        return false;
    }
}
