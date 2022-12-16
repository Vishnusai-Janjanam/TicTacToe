
public class Computer extends Player{
	private int computer; // Stores id of computer.
	private static int chance =1;		//For checking the move of computer.
	private static  int [][] arr= new int[8][2]; // stores the edges and corners in clockwise order respective.
	
	public Computer(int p){    //Constructor for computer.
		super(p);
		computer = p;
		arr[0][0]=0;arr[0][1] = 1;
		arr[1][0]=1;arr[1][1] = 2;
		arr[2][0]=2;arr[2][1] = 1;
		arr[3][0]=1;arr[3][1] = 0;
		arr[4][0]=0;arr[4][1] = 2;
		arr[5][0]=2;arr[5][1] = 2;
		arr[6][0]=2;arr[6][1] = 0;
		arr[7][0]=0;arr[7][1] = 0;
	}
	public void reassign(){
		chance = 1;
	}
	private int stopWin(char [][] board){			//Checks if another player is winning and tires ot sop it.
		for(int i =0;i<3;i++){									// Checking if two elements in a row or a column are 'X' and the third is free.
			for(int j = 0;j<2;j++){
				for(int k = 0;k<2;k++){
					if(board[i][j] == board[i][(j+1+k)%3] && board[i][j] == 'X'){
						for(int m =0;m<3;m++){
							if(Fill(i,m,2)==2) return i*3 +m;
						}
					}
					if(board[j][i] =='X' && board[(j+1+k)%3][i] == board[j][i]){
						for(int m =0;m<3;m++){
							if(Fill(m,i,2)==2) return m*3+i;
						}
					}
				}
			}	
		}
		if(board[0][0]==board[1][1] && board[1][1] == 'X'){     // Checking diagonals if two elements in a diagonal are 'X' and the third is free.
			if(Fill(2,2,2)==2) return 8;
		}
		else if(board[1][1] == board[2][2] && board[1][1] == 'X'){
			if(Fill(0,0,2)==2) return 0;
		}
		else if(board[0][0]==board[2][2] && board[0][0]== 'X'){
			if(Fill(1,1,2)==2) return 4;
		}
		else if(board[0][2]== board[1][1] && board[1][1] == 'X'){
			if(Fill(2,0,2)==2) return 6;
		}
		else if(board[2][0]== board[1][1] && board[1][1] == 'X'){
			if(Fill(0,2,2)==2) return 2;
		}
		else if(board[0][2]==board[2][0] && board[0][2] == 'X'){
			if(Fill(1,1,2)==2) return 4;
		}
		return -1;
	}

	private int canWin(char [][] board){ // Checks if the computer can win.
		for(int i =0;i<3;i++){														// Checking if two elements in a row or a column are 'O' and the third is free.
			for(int j = 0;j<2;j++){
				for(int k = 0;k<2;k++){
					if(board[i][j] == board[i][(j+1+k)%3] && board[i][j] == 'O'){
						for(int m =0;m<3;m++){
							if(Fill(i,m,2)==2) return i*3+m;
						}
					}
					if(board[j][i] =='O' && board[(j+1+k)%3][i] == board[j][i]){
						for(int m =0;m<3;m++){
							if(Fill(m,i,2)==2) return m*3+i;
						}
					}
				}
			}	
		}
		if(board[0][0]==board[1][1] && board[1][1] == 'O'){    // Checking diagonals if two elements in a diagonal are 'O' and the third is free.
			if(Fill(2,2,2)==2) return 8;
		}
		else if(board[1][1] == board[2][2] && board[1][1] == 'O'){
			if(Fill(0,0,2)==2) return 0;
		}
		else if(board[0][0]==board[2][2] && board[0][0]== 'O'){
			if(Fill(1,1,2)==2) return 4;
		}
		else if(board[0][2]== board[1][1] && board[1][1] == 'O'){
			if(Fill(2,0,2)==2) return 6;
		}
		else if(board[2][0]== board[1][1] && board[1][1] == 'O'){
			if(Fill(0,2,2)==2) return 2;
		}
		else if(board[0][2]==board[2][0] && board[0][2] == 'O'){
			if(Fill(1,1,2)==2) return 4;
		}
		return -1;
	}

	public void makeMove(){			// To make a computer move.
		char [][] board = getBoard();
		int choice=-1;
		if(chance==1){
			if(board[1][1]==' '){
				Fill(1,1,computer);			//Claim center if not already claimed.
				choice =4;
			}
			else {
				Fill(0,2,computer); // Claim top right corner if center is claimed.
				choice =2;
			}
			chance =2;
			System.out.println("The computer chose: "+choice);
		}
		else{
			choice =canWin(board);						//First checking if the computer can win.
			if(choice!=-1){
				System.out.println("The computer chose: "+choice);
				return;
			}
			choice = stopWin(board);				//Then checking if it is possible to another player.
			if(choice!=-1){
				System.out.println("The computer chose: "+choice);
				return;
			}
			if(chance==2){											//Handling some corner cases.
				if(board[1][1]==board[2][0] && board[1][1] == 'X'){
					Fill(0,0,2);
					chance=3;
					choice = 0;
					System.out.println("The computer chose: lol "+choice);
					return;
				}
			}
			for(int i =0;i<4;i++){			// Checking if consecutive edges are same and the corner included is free.
				if(board[arr[i][0]][arr[i][1]]==board[arr[(i+1)%4][0]][arr[(i+1)%4][1]] && board[arr[i][0]][arr[i][1]]=='X' && board[arr[i+4][0]][arr[i+4][1]]==' '){
					Fill(arr[i+4][0],arr[i+4][1],2);
					choice = 3*arr[i+4][0]+ arr[i+4][1];

					System.out.println("The computer chose: "+choice);
					return;
				}
			}
			for(int i =0;i<8;i++){		//Then Checking for edges in clockwise order staring from the top and then checking for the corner in clockwise order staring from the top right corner.
				if(Fill(arr[i][0],arr[i][1],2)==2){
					choice = 3*arr[i][0] + arr[i][1];
					System.out.println("The computer chose: "+choice);
					return;
				}
			}
		}
	}
	public boolean isWin(){			//Checking if the computer has won.
		char [][] board = getBoard();
		int f =0;
		char c = 'O';

		for(int i =0;i<3;i++){
			if(board[i][0]== board[i][1] && board[i][0] == board[i][2] && board[i][0]==c)f=1;
			else if(board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i]==c)f=1;
		}
		
		if(board[0][0]==board[1][1] && board[1][1] == board[2][2] && board[0][0] ==c)f=1;
		else if(board[0][2] == board[1][1] && board[1][1]==board[2][0] && board[1][1] ==c)f=1;
		
		return (f==1);
	}
}