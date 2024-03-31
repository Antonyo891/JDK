package TicTacToe.logic;

import java.util.Arrays;
import java.util.Random;

public class GameLogik {
    private final char DOT_HUMAN = 'X';
    private final char DOT_AI = 'O';
    private final char DOT_EMPTY = '.';
    private Winner winner;
    private Random random;
    private char[][] field;
    private int sizeX;
    private int sizeY;
    private int winLineLength;
    private boolean trueHumanTurn;

    public GameLogik(int sizeX, int sizeY, int winLineLength) {
        this.random = new Random();
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.winLineLength = winLineLength;
        winner = Winner.None;
        initialize();
    }

    private void initialize(){
        field = new char[sizeX][sizeY];
        for(int x = 0; x < sizeX; x++){
            for(int y = 0; y < sizeY; y++){
                field[x][y] = DOT_EMPTY;
            }
        }
        System.out.println(Arrays.toString(field[0]) + "From GameLogic");
    }

    public boolean makeMove(int posX, int posY){
        if (humanTurn(posX,posY)) {
            if (gameCheck(DOT_HUMAN)) return true;
            aiTurn();
            return gameCheck(DOT_AI);
        }
        return false;
    }

    public boolean humanTurn(int posX, int posY) {
        trueHumanTurn = true;
         if (isCellValid(posX, posY) && isCellEmpty(posX, posY)) {
             field[posX][posY] = DOT_HUMAN;
             return true;
         }
         trueHumanTurn = false;
         return false;
    }
    private boolean isCellEmpty(int posX, int posY) {
        return field[posX][posY] == DOT_EMPTY;
    }

    private boolean isCellValid(int posX, int posY){
        return posX >= 0 && posX < sizeX
                && posY >= 0 && posY < sizeY;
    }
    private void aiTurn() {
        if (aiTrueTurn()) return; //проверка хорошего хода
        int posX, posY;
        do {
            posX = random.nextInt(sizeX);
            posY = random.nextInt(sizeY);
        } while(!isCellEmpty(posX, posY));
        field[posX][posY] = DOT_AI;
    }

    //метод проверяет есть ли хороший ход
    // если есть то выполняет ход
    private boolean aiTrueTurn() {
        int [] true_turn = goodMove(DOT_AI);
        if (true_turn[0]>-1) {
            field[true_turn[0]][true_turn[1]]=DOT_AI;
            return true;
        }
        true_turn = goodMove(DOT_HUMAN);
        if (true_turn[0]>-1){
            field[true_turn[0]][true_turn[1]]=DOT_AI;
            return true;
        }
        return false;
    }


    //возвращает координаты хорошего хода в массиве
    // или возвращает [-1,-1]
    // или null если победа
    private int[] goodMove(char symbol) {
        int countSymbolInLine;
        int preWinningLength = winLineLength - 1;
        int trueX;
        int trueY;
        // Поиск первого хорошего хода по всем горизонталям
        for(int x = 0; x < sizeX; x++ ){
            countSymbolInLine = 1;
            for (int y = 0; y < sizeY - 1; y++){
                if ((symbol==field[x][y])&(symbol==field[x][y+1])) {
                    countSymbolInLine++;
                    if (countSymbolInLine == winLineLength) return null;
                }
                else if ((preWinningLength == countSymbolInLine)) {
                    if (field[x][y+1]==DOT_EMPTY) {
                        trueX = x;
                        trueY = y+1;
                        return new int[]{trueX,trueY};
                    } else if ((y >= countSymbolInLine)&&((field[x][(y - countSymbolInLine)] == DOT_EMPTY))) {
                        trueX = x;
                        trueY = y - countSymbolInLine;
                        return new int[]{trueX,trueY};
                    } else countSymbolInLine = 1;
                }
                else countSymbolInLine = 1;
                if ((y == sizeY - 2)&(preWinningLength == countSymbolInLine)&&
                        (field[x][((y + 1) - countSymbolInLine)] == DOT_EMPTY)) {
                    trueX = x;
                    trueY = (y + 1) - countSymbolInLine;
                    return new int[]{trueX,trueY};
                }
            }
        }
        // Поиск первого хорошего хода по вертикалям
        for (int y = 0; y < sizeY; y++) {
            countSymbolInLine = 1;
            for (int x = 0; x < sizeX -1; x++) {
                if ((symbol == field[x][y])&(symbol == field[x+1][y])){
                    countSymbolInLine++;
                    if (countSymbolInLine == winLineLength) return null;
                }
                else if ((preWinningLength == countSymbolInLine)) {
                    if (field[x+1][y]==DOT_EMPTY) {
                        trueX = x+1;
                        trueY = y;
                        return new int[]{trueX,trueY};
                    } else if ((x >= countSymbolInLine)&&(field[x - countSymbolInLine][y] == DOT_EMPTY)) {
                        trueX = x - countSymbolInLine;
                        trueY = y;
                        return new int[]{trueX,trueY};
                    } else countSymbolInLine = 1;
                } else countSymbolInLine = 1;
                if ((x == sizeX - 2 )&&(preWinningLength == countSymbolInLine)&&
                        (field[(x + 1) - countSymbolInLine][y] == DOT_EMPTY)) {
                    trueX = (x + 1) - countSymbolInLine;
                    trueY = y;
                    return new int[]{trueX,trueY};
                }
            }
        }
//      Поиск первого хорошего хода главной диагонали
        countSymbolInLine = 1;
        for (int y = 0; y < sizeY -1; y++) {
            if ((symbol == field[y][y])&&(symbol == field[y+1][y+1])) {
                countSymbolInLine++;
                if (countSymbolInLine == winLineLength) return null;
            }
            else if (preWinningLength == countSymbolInLine) {
                if (field[y+1][y+1] == DOT_EMPTY) {
                    trueX = y+1;
                    trueY = y+1;
                    return new int[]{trueX,trueY};
                } else if ((y >= countSymbolInLine)&&(field[y - countSymbolInLine][y - countSymbolInLine] == DOT_EMPTY )) {
                    trueX = y - countSymbolInLine;
                    trueY = y - countSymbolInLine;
                    return new int[]{trueX,trueY};
                } else countSymbolInLine = 1;
            } else countSymbolInLine = 1;
            if ((y == (sizeY -2))&&( preWinningLength == countSymbolInLine)&&
                    (DOT_EMPTY==field[(y + 1) - countSymbolInLine][(y + 1) - countSymbolInLine])) {
                trueX = y + 1 - countSymbolInLine;
                trueY = y + 1 - countSymbolInLine;
                return new int[]{trueX,trueY};
            }
        }
        // Проверка по побочной диагонали
        countSymbolInLine = 1;
        int x;
        for (int y = 0; y < sizeY - 1; y++) {
            x = sizeX - 1 - y;
            if ((symbol == field[x][y])&&(symbol == field[x-1][y+1])) {
                countSymbolInLine++;
                System.out.printf("PreWINNING = %d, y = %d",preWinningLength, y);
                System.out.println("CountSymbol " + symbol + " = " + countSymbolInLine);
                if (countSymbolInLine == winLineLength) return null;
                System.out.println(preWinningLength == countSymbolInLine);
            } else if (preWinningLength == countSymbolInLine) {
                System.out.println("PRE-WINNING LINE. DOT UPPER = " + field[x-1][y+1] );
                if (field[x-1][y+1]==DOT_EMPTY) {
                    trueX = x-1;
                    trueY = y+1;
                    System.out.println("True x =" + trueX + "True Y =  " + trueY );
                    return new int[]{trueX,trueY};
                } else if ((y >= countSymbolInLine)&&
                        (field[x + countSymbolInLine][y - countSymbolInLine]==DOT_EMPTY)) {
                    System.out.println("1PRE-WINNING LINE. DOT UNDER = " + field[x+countSymbolInLine][y-countSymbolInLine] );
                    trueX = x + countSymbolInLine;
                    trueY = y - countSymbolInLine;
                    System.out.println("True x =" + trueX + "True Y =  " + trueY );
                    return new int[]{trueX,trueY};
                } else countSymbolInLine = 1;
            } else countSymbolInLine = 1;
            if ((y == (sizeY - 2))&&(preWinningLength == countSymbolInLine)&&
                    (DOT_EMPTY==field[x - 1 + countSymbolInLine][y + 1 - countSymbolInLine])) {
                System.out.println("2PRE-WINNING LINE. DOT UNDER = " +
                        field[x - 1 + countSymbolInLine][y + 1 - countSymbolInLine] );
                trueX = x - 1 + countSymbolInLine;
                trueY = y + 1 - countSymbolInLine;
                System.out.println("True x =" + trueX + "True Y =  " + trueY );
                return new int[]{trueX,trueY};
            }
        }
        return new int[] {-1,-1};
    }


    private boolean gameCheck(char symbol){
        if(checkWin(symbol)){
            System.out.println(symbol + " win.");
            return true;
        }
        if(checkDraw()){
            System.out.println("Draw");
            return true;
        }
        return false;
    }

    private boolean checkDraw() {
        for(int x = 0; x < sizeX; x++){
            for(int y = 0; y < sizeY; y++){
                if(isCellEmpty(x, y)) return false;
            }
        }
        winner = Winner.Draw;
        return true;
    }


    private boolean checkWin(char symbol) {
        if (goodMove(DOT_HUMAN)==null){
            winner = Winner.Human;
            return true;
        }
        if (goodMove(DOT_AI)==null){
            winner = Winner.Bot;
            return true;
        }
        return false;
    }

    public char[][] getField() {
        return field;
    }

    public Winner getWinner() {
        return winner;
    }

    public boolean isFalseHumanTurn() {
        return !trueHumanTurn;
    }
}
