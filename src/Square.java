public class Square {
	private int row;
	private int column;
	private int score;
	
	/**
	 * Constructs a Square with given row, column, and score.
	 * @param row the row
	 * @param column the column
	 * @param sc the score
	 */
	public Square(int row, int column, int score) {
		super();
		this.row = row;
		this.column = column;
		this.score = score;
	}

	/**
	 * Returns the row of this Square
	 * @return the row of this Square
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Returns the column of this Square
	 * @return the column of this Square
	 */
	public int getColumn() {
		return column;
	}
	
	/**
	 * Returns the score of this Square
	 * @return the score of this Square
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * Sets the score of this Square to s
	 * @param s the score of this Square
	 */
	public void setScore(int s) {
		score = s;
	}

	/** 
	 * Returns true if this Square and x have the same row and the same column.
	 * Otherwise, returns false.
	 */
	public boolean equals(Object x) {
		Square other = (Square)x;
		if(this.row == other.row && this.column == other.column) {
			return true;
		}
		else {
			return false;
		}
	}
}
