public class Player extends Board{
	private int player; //Stores player id.

	public Player(int p){ 
		this.player = p;
	}

	public void reassign(){
		this.player = this.player;
	}
	public void makeMove(){      // To make a player move
		char c ='X';
		if(player==2) c = 'O';
		System.out.print("Player "+ player + "("+c +")"  +" select your desired location[0-8]: ");
		int n = sc.nextInt();
		int r = Fill(n/3,n%3,player);

		while(r!=2){
			if(r==1){
				System.out.println("The location " + n + " is already filled!");
			}
			else if(r==0){
				System.out.println("The entered location(" + n + ") is invalid!");
			}
			System.out.print("Player "+ player + "("+c +")"+" select your desired location[0-8]: ");
			n = sc.nextInt();
			r = Fill(n/3,n%3,player);
		}
	}

	public boolean isWin(){ // Checks if the player has won.
		char [][] board = getBoard();
		int f =0;
		char c = 'X';
		if(player ==2) c = 'O';

		for(int i =0;i<3;i++){
			if(board[i][0]== board[i][1] && board[i][0] == board[i][2] && board[i][0]==c)f=1;
			else if(board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i]==c)f=1;
		}
		
		if(board[0][0]==board[1][1] && board[1][1] == board[2][2] && board[0][0] ==c)f=1;
		else if(board[0][2] == board[1][1] && board[1][1]==board[2][0] && board[1][1] ==c)f=1;
		
		return (f==1);
	}
}