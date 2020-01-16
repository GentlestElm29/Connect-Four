import java.util.Scanner;
/**
 * This is the main method and is what runs the whole program. 
 * Testing the Connect Four Board
 * Using this class will essentially be able to compile the game board,
 * game pieces and instructions inputted by the user.
 * @author John Xie
 * @version 12/5/2017
 */
public class XieJohn_ConnectFour
{
    /**
     * The main method
     */
    public static void main(String[] args)
    {
        //scanner
        Scanner userInput = new Scanner(System.in);
        //user input for column number
        int placement;
        
        //intro
        System.out.println("Welcome to Connect Four!");
        System.out.println("Player 1's piece is: @ ");
        System.out.println("Player 2's piece is: # ");
        
        //initializes the board to all empty string values
        ConnectFour game = new ConnectFour();
        
        //testHorizontal();
        //testVertical();
        //testDiagonalOne();
        //testDiagonalTwo();
        
        //assume winGame is false because the games hasn't been won yet
        boolean winGame = false;
        
        do
        {           
            //Player 1's turn
            System.out.println("Player 1's turn");
            System.out.println("Enter Column: ");
            placement = userInput.nextInt();
            
            //if incorrect input or if column is full, ask for a different input
            while(game.playerOne(placement) == false)
            {
                System.out.println("Sorry incorrect input.");
                System.out.println("Please enter a new column from 0 to 6");
                placement = userInput.nextInt();
            }
            
            //check for winning condition for player 1
            if(game.checkConnectFourPlayerOne() == true)
            {
                System.out.println("Player One Wins!!!");
                winGame = true;
                break;
            }
            //print out the updated board
            game.printBoard();
            
            //player 2's turn
            System.out.println("Player 2's turn");
            System.out.println("Enter Column: ");
            placement = userInput.nextInt();
            
            //if incorrect input or if column is full, ask for a different input
            while(game.playerTwo(placement) == false)
            {
                System.out.println("Sorry incorrect input.");
                System.out.println("Please enter a new column from 0 to 6");
                placement = userInput.nextInt();
            }
            
            //Check for winning condition for player 2
            if(game.checkConnectFourPlayerTwo() == true)
            {
                System.out.println("Player Two Wins!!!");
                winGame = true;
                break;
            }
            //print out the updated board
            game.printBoard();
        }while(game.checkBoardFull() == false);
        
        //If all of them are filled in but no win condition is met, print out tie game
        if(winGame == false)
        {
            System.out.println("Tie Game");
        }
    }
    
    //test Horizontal
    public static void testHorizontal()
    {
        ConnectFour game = new ConnectFour();
        game.playerOne(0);
        game.playerTwo(0);
        game.playerOne(1);
        game.playerTwo(1);
        game.playerOne(2);
        game.playerTwo(2);
        game.playerOne(3);
        game.printBoard();
        
        if(game.checkConnectFourPlayerOne() == true)
        {
            System.out.println("Player One Wins");
        }
    }
    
    //test Vertical
    public static void testVertical()
    {
        ConnectFour game = new ConnectFour();
        game.playerOne(0);
        game.playerTwo(1);
        game.playerOne(0);
        game.playerTwo(1);
        game.playerOne(0);
        game.playerTwo(1);
        game.playerOne(0);
        game.printBoard();
        
        if(game.checkConnectFourPlayerOne() == true)
        {
            System.out.println("Player One Wins");
        }
    }
    
    //test Diagonal from top to bottom
    public static void testDiagonalOne()
    {
        ConnectFour game = new ConnectFour();
        game.playerOne(0);
        game.playerTwo(0);
        game.playerOne(0);
        game.playerTwo(1);
        game.playerOne(0);
        game.playerTwo(1);
        game.playerOne(1);
        game.playerTwo(2);
        game.playerOne(2);
        game.playerTwo(2);
        game.playerOne(3);
        game.printBoard();
        
        if(game.checkConnectFourPlayerOne() == true)
        {
            System.out.println("Player One Wins");
        }
    }
    
    //test Diagonal from bottom to top
    public static void testDiagonalTwo()
    {
        ConnectFour game = new ConnectFour();
        game.playerOne(0);
        game.playerTwo(1);
        game.playerOne(1);
        game.playerTwo(2);
        game.playerOne(3);
        game.playerTwo(2);
        game.playerOne(2);
        game.playerTwo(3);
        game.playerOne(4);
        game.playerTwo(3);
        game.playerOne(3);
        game.printBoard();
        
        if(game.checkConnectFourPlayerOne() == true)
        {
            System.out.println("Player One Wins");
        }
    }
}
