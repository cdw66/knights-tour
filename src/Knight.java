import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Knight {
	private Square currentSquare;
	private Square startingSquare;
	private boolean[][] board;
	static Random randy = new Random();
	private int[][] moves = {{-2,1},
							 {-1,2},
							 {1,2}, 
							 {2,1}, 
							 {2,-1}, 
							 {1,-2}, 
							 {-1,-2}, 
							 {-2,-1}};
	
	/**
	 * Creates a Knight with board of size rows x columns.
	 * Sets the value of board to true in the Square represented
	 * by s. Sets all other board values to false.
	 * Sets currentSquare and startingSquare to s.
	 * @param s the starting Square for this Knight
	 * @param rows the number of rows in this Knight's board
	 * @param cols the number of columns in this Knight's board
	 */
	public Knight(Square s, int rows, int cols) {
		board = new boolean[rows][cols];
//		for(int r = 0; r < rows; r++){
//			for(int c = 0; c < cols; c++){
//				board[r][c] = false;
//			}
//		}
		board[s.getRow()][s.getColumn()] = true;
		currentSquare = s;
		startingSquare = s;
	}
	
	/**
	 * Returns this Knight's current Square.
	 * @return this Knight's current Square.
	 */
	public Square getCurrentSquare() {
		return this.currentSquare;
	}

	/**
	 * Returns this Knight's starting Square.
	 * @return this Knight's starting Square.
	 */
	public Square getStartingSquare() {
		return this.startingSquare;
	}

	/**
	 * Returns this Knight's board.
	 * @return this Knight's board.
	 */
	public boolean[][] getBoard() {
		return board;
	}

	/**
	 * Returns a list of Squares representing a Knights Tour for this Knight.
	 * @return a list of Squares representing a Knights Tour for this Knight
	 */
	public ArrayList<Square> solve() {
		ArrayList<Square> sequence = new ArrayList<Square>();
		
		int pos = 1;
		sequence.add(currentSquare);
		do {
			board[currentSquare.getRow()][currentSquare.getColumn()] = true;
			ArrayList<Square> possible = getPossibleSquares();
			if (possible.isEmpty()) {
				sequence.clear();
				sequence.add(startingSquare);
				pos = 1;
				currentSquare = startingSquare;
				clearBoard();
			}
			else {
				Square best = getBestSquare(possible);
				sequence.add(best);
				currentSquare = best;
				pos++;
			}			
		} while (pos < board.length*board[0].length);		
		
		return sequence;
	}

	/**
	 * Determines if starting Square is reachable in one move from current Square.
	 * @return determines if starting Square is reachable in one move from current Square, false otherwise
	 */
	public boolean startIsReachableFromCurrent() {
		return false;
	}
	
	/**
	 * Returns a Square with the smallest score in possible.
	 * If several Squares in possible have the same lowest score,
	 * one of these Squares is selected at random and returned.
	 * @param possible the list of Squares
	 * @return a Square with the smallest score in possible
	 */
	public Square getBestSquare(ArrayList<Square> possible) {
		Square bestSquare = possible.get(0);
		ArrayList<Square> bestSquares = new ArrayList<Square>();
		for(int i = 0; i < possible.size(); i++) {
			currentSquare = possible.get(i);
			if(currentSquare.getScore() < bestSquare.getScore()) {
				bestSquare = currentSquare;
			}
		}
		for(int j = 0; j < possible.size(); j++) {
			currentSquare = possible.get(j);
			if(currentSquare.getScore() == bestSquare.getScore()) {
				bestSquares.add(currentSquare);
			}
		}
		return bestSquares.get(randy.nextInt(bestSquares.size()));
	}

	/**
	 * Sets all values in this Knight's board to false.
	 */
	public void clearBoard() {
		for(int r = 0; r < board.length; r++){
			for(int c = 0; c < board[r].length; c++){
				board[r][c] = false;
			}
		}
	}

	/**
	 * Returns a list of all unvisited Squares that are within one knight move of
	 * this Knight's current Square.
	 * Each Square in the returned list has been given a score representing
	 * the number of unvisited Squares that can be reached (with a knight move) from that Square.
	 * @return a list of all unvisited Squares that are within one knight move of
	 * this Knight's current Square
	 */
	public ArrayList<Square> getPossibleSquares() {
		ArrayList<Square> possible = new ArrayList<Square>();
		for(int r = 0; r < moves.length; r++) {
			int score = getScoreOfSquare(currentSquare.getRow()+moves[r][0],currentSquare.getColumn()+moves[r][1]);
			if(isValid(currentSquare.getRow()+moves[r][0],currentSquare.getColumn()+moves[r][1]) && board[currentSquare.getRow()+moves[r][0]][currentSquare.getColumn()+moves[r][1]]==false) {
				possible.add(new Square(currentSquare.getRow()+moves[r][0],currentSquare.getColumn()+moves[r][1], score));
			}
		}
		return possible;
	}

	/**
	 * Returns the number of unvisited Squares that can be reached (with a knight move) from the Square at row, col.
	 * @param row the row
	 * @param col the column
	 * @return the number of unvisited Squares that can be reached (with a knight move) from the Square at row, col
	 */
	public int getScoreOfSquare(int row, int col) {
		int score = 0;
		for(int r = 0; r < moves.length; r++) {
			if(isValid(row+moves[r][0],col+moves[r][1]) && board[row+moves[r][0]][col+moves[r][1]]==false) {
				score++;
			}
		}
		return score;
	}

	

	/**
	 * Returns true if the square at row r, column c is in this Knight's board; returns false otherwise.
	 * @param r the row
	 * @param c the column
	 * @return true if the square at row r, column c is in this Knight's board; false otherwise
	 */
	public boolean isValid(int r, int c) {
		if(r < board.length && r >= 0 && c < board[0].length && c >= 0){
			return true;
		}
		return false;
	}

	public void setCurrentSquare(Square currentSquare) {
		this.currentSquare = currentSquare;
	}	
}
