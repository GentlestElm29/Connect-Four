
/**
 * Write a description of class ConnectFour here.
 *
 * @author (John Xie)
 * @version (a version number or a date)
 */
public class ConnectFour
{
    //Connect four board is typically 6 rows by 7 columns
    private String gameBoard[][] = new String [6][7];
    /**
     * Constructor for objects of class GameBoard
     * Calls for the method to initalize the Board
     */
    public ConnectFour()
    {
        initializeBoardToNull();
    }
    
    //Sets the board to all empty strings
    private String [][] initializeBoardToNull()
    {
        //Initialize the board for the game
        for(int i = 0; i < gameBoard.length; i++) {
            
            for(int j = 0; j < gameBoard[i].length; j++)
            {
                gameBoard[i][j] = "";
            }
        }
        return gameBoard;
    }
    
    //can be called from main and prints the board
    public void printBoard()
    {
        for(int i = 0; i < gameBoard.length; i++) {
            
            for(int j = 0; j < gameBoard[i].length; j++)
            {
                System.out.print("| " + gameBoard[i][j]);
            }
            System.out.println(" |");
        }
    }
    
    //prints the piece onto the board
    private boolean placePiece(int column, String character)
    {
        for(int i = gameBoard.length - 1; i >= 0; i--)
        {
            
            if(gameBoard[i][column].equals(""))
            {
                gameBoard[i][column] = character;
                return true;
            }
        }
        return false;
    }
    
    //basically checks to see if valid then prints it by calling the place piece Method
    public boolean playerOne(int column)
    {
        return placePiece(column, "@");
    }
    
    //Does the same thing as the other except uses player two's character
    public boolean playerTwo(int column)
    {
        return placePiece(column, "#");
    }
    
    //check to see if board is full by checking for empty string values, can be called from main
    public boolean checkBoardFull()
    {
        for(int i = 0; i < gameBoard.length; i++) 
        {
            for(int j = 0; j < gameBoard[i].length; j++)
            {
                if(gameBoard[i][j].equals(""))
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    //Checking for connect four winning conditions with Player 1
    public boolean checkConnectFourPlayerOne()
    {
        return checkConnectFour("@");
    }
    
    //Checking for connect four winning conditions with Player 2
    public boolean checkConnectFourPlayerTwo()
    {
        return checkConnectFour("#");
    }
    
    //Checking for connect four winning conditions with a general method
    private boolean checkConnectFour(String character)
    {
        if(checkHorizontal(character) == true 
            || checkVertical(character) == true 
            || checkDiagonalOne(character) == true 
            || checkDiagonalTwo(character) == true)
        {
            return true;
        }
        return false;
    }
    
    //Checks for the horizontal win condition
    private boolean checkHorizontal(String character)
    {
        int count;
        for(int i = 0; i < gameBoard.length; i++)
        {
            count = 0;
            for(int j = 0; j < gameBoard[i].length; j++)
            {
                if(gameBoard[i][j].equals(character))
                {
                    count++;
                    if(count == 4)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    //checks for vertical win condition
    private boolean checkVertical(String character)
    {
        int count;
        for(int j = 0; j < gameBoard[0].length; j++)
        {
            count = 0;
            for(int i = 0; i < gameBoard.length; i++)
            {
                if(gameBoard[i][j].equals(character))
                {
                    count++;
                    if(count == 4)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    //checks for diagonal win condition
    private boolean checkDiagonalOne(String character)
    {
        int count;
        for(int i = 0; i < gameBoard.length - 3; i++)
        {
            count = 0;
            for(int j = 0; j < gameBoard[i].length - 3; j++)
            {
                if(gameBoard[i][j].equals(character) 
                    && gameBoard[i+1][j+1].equals(character) 
                    && gameBoard[i+2][j+2].equals(character) 
                    && gameBoard[i+3][j+3].equals(character))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    //checks for diagonal win condtions
    private boolean checkDiagonalTwo(String character)
    {
        int count;
        for(int i = 0; i < gameBoard.length - 3; i++)
        {
            count = 0;
            for(int j = 3; j < gameBoard[i].length; j++)
            {
                if(gameBoard[i][j].equals(character) 
                    && gameBoard[i+1][j-1].equals(character) 
                    && gameBoard[i+2][j-2].equals(character) 
                    && gameBoard[i+3][j-3].equals(character))
                {
                    return true;
                }
            }
        }
        return false;
    }
}
