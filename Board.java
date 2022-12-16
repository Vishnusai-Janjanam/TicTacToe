import java.util.Scanner;
public class Board{

	public static Scanner sc = new Scanner(System.in); // For taking input in the child classes
	private static char [][] board = new char[3][3]; // The matrix to represent the current board.
	private static int left = 9;										// To check if the board is full or not

	public boolean isEmpty(){		// returns if the board is completely full
		return (left==0);
	}

	public char[][] getBoard(){ 		// returns the board.
		return this.board;
	}
	
	public Board(){							//Constuctor for the board.
		for(int i =0;i<3;i++) {
			for(int j =0;j<3;j++){
				board[i][j] = ' ';
			}
		}
	}

	public void reassign(){
		for(int i =0;i<3;i++) {
			for(int j =0;j<3;j++){
				board[i][j] = ' ';
			}
		}
		left = 9;
	}

	private boolean isFilled(int i,int j){ //To check if the given address is already full.
		return (board[i][j]!=' ');
	}

	public int Fill(int i,int j,int f){ //Tries to fill the cell with address 3*i+j.
		if(i*3+j>8 || i*3+j<0) return 0;
		if(isFilled(i,j)) return 1;
		if(f==1) board[i][j] = 'X';
		else board[i][j] = 'O';
		left--;
		return 2;
	}

	public void displayBoard(int f){ //To display the board
		for(int i =0;i<3;i++){
			for(int j = 0;j<3;j++){
				char c = board[i][j];
				if(f==0) c= (char)('0' + i*3+j);
				if(j==2) System.out.println(" "+c);
				else System.out.print(" " + c + " |");
			}
		}
	}

}