# Tic Tac Toe in JAVA
This is a simple Tic Tac Toe game in Java. It is a two player game with computer mode. The first player is X and the second player is O. The game is played on a 3x3 grid. The first player to get 3 of their marks in a row (up, down, across, or diagonally) is the winner. When all 9 squares are full, the game is over. If no player has 3 marks in a row, the game ends in a tie. 

## How to run the game

- To compile the java file use terminal command :   
```bash
javac TicTacToe.java
```
- To run the program use  terminal command : 
```bash 
java TicTacToe
```
- The first player is 'X' and the second player or computer is always 'O'. All the characters mentioned below are case sensitive!
- To play with another player type 'P'(without quotes).To play with a computer type 'C'(without quotes).
- To start a New game type 'Y'(without quotes).
- Enter the position for your move. You and the computer or another player will move alternatively.
- The game ends in a draw or one of the players win.
- Type 'Y' to start a new game with same first choice('P' or 'C') or 'N' to exit the game.


## The computer works as follows. 
The computer first checks if the computer can fill according to the rules and moves according to the priority given below:
1. It checks if the player is winning in a single move. It it happens then it tries to stop it.
2. If neither happens then it checks for a few corner cases.
3. Then it tries to fill the edges in clockwise order starting from top.
4. After that it tries to fill the corners starting from top right in clockwise order.0