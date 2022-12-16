import java.util.Scanner;

public class TicTacToe{
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
		
		System.out.print("\033[H\033[2J");  // clears the screen.
		System.out.flush();  
		
		char c = 'P';
		
		do{
			System.out.print("Type P to play with another player or type C to play with a computer: ");
			c = sc.next().charAt(0);
		}
		while(c!='P' && c!='C');   //Takes input while user enters 'P' or 'C'
		
		Player p1 = new Player(1);
		Player p2 = new Player(2);
		
		if(c =='C')p2 = new Computer(2);
		System.out.print("Do you want to start a new game[Y/N]? "); // For staring new game.
		char choice  = sc.next().charAt(0);
		

		while(choice!='N'){
				Board board = new Board();
				System.out.print("\033[H\033[2J");  	//clears the screen.
				System.out.flush(); 			
				board.reassign();
				p2.reassign();
				p1.reassign();
				System.out.println("The address of each cell is shown below. Enter the address of the cell you want to fill.");
				board.displayBoard(0); // Display board with address of each cell.
				
				int win =0;

				while(!board.isEmpty()){ // Looping till the board is not empty.
					p1.makeMove();								//player1 makes a move
					if(p1.isWin()){								//checking if he/she wins.
						win =1;
						System.out.println("\nPlayer1 Won!\n");
						break;
					}
					if(c!='C')board.displayBoard(1); //Displaying board in a PvP mode only
					if(board.isEmpty())break;			//Checking if the board is empty.

					p2.makeMove();								//Player2 or computer makes a move.
					if(p2.isWin()){								//checking if he/she/it wins.
						win =1;
						String s= "Player2";
						if(c=='C') s = "Computer";
						System.out.println("\n" + s+ " Won!\n");
						break;
					}
					System.out.println("The current Board: "); // Display the current board.
					board.displayBoard(1);
				}
				
				if(win==0){																	// Checking if the games ended in a draw.
					System.out.println("\nIt is a draw!\n");
				}
				board.displayBoard(1);
				System.out.print("Do you want to start a new game[Y/N]? "); // prompting for a new game.
				choice  = sc.next().charAt(0);
		}

		System.out.println("Thank you!");
	}

}