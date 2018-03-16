import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class KnightTest {	
	@Test
	public void testKnight() {
		Knight rider = new Knight(new Square(2,3,0),8,8);
		assertEquals(8,rider.getBoard().length);
		assertEquals(8,rider.getBoard()[0].length);
		assertEquals(3,rider.getStartingSquare().getColumn());
		assertEquals(2,rider.getStartingSquare().getRow());
		assertEquals(3,rider.getCurrentSquare().getColumn());
		assertEquals(2,rider.getCurrentSquare().getRow());
		
		for (int r = 0; r < rider.getBoard().length; r++) {
			for (int c = 0; c < rider.getBoard()[r].length; c++) {
				if (r != rider.getCurrentSquare().getRow() || c != rider.getCurrentSquare().getColumn()) {
					assertFalse(rider.getBoard()[r][c]);
				}
			}
		}
		
		assertTrue(rider.getBoard()[rider.getCurrentSquare().getRow()][rider.getCurrentSquare().getColumn()]);
	}
	
	@Test
	public void testSequence() {
		Knight lancelot = new Knight(new Square(2,2,0),5,5);
		//secons move:
		ArrayList<Square> possible = lancelot.getPossibleSquares();
		assertEquals(8,possible.size());
		for (Square sq: possible) {
			assertEquals(2,sq.getScore());
		}
		assertTrue(possible.contains(new Square(0,1,2)));
		assertTrue(possible.contains(new Square(0,3,2)));
		assertTrue(possible.contains(new Square(1,0,2)));
		assertTrue(possible.contains(new Square(1,4,2)));
		assertTrue(possible.contains(new Square(3,0,2)));
		assertTrue(possible.contains(new Square(3,4,2)));
		assertTrue(possible.contains(new Square(4,1,2)));
		assertTrue(possible.contains(new Square(4,3,2)));
		lancelot.setCurrentSquare(new Square(3,0,2));
		lancelot.getBoard()[3][0] = true;
		
		//3rd move:
		possible = lancelot.getPossibleSquares();
		assertEquals(2,possible.size());
		assertTrue(possible.contains(new Square(1,1,2)));
		assertTrue(possible.contains(new Square(4,2,2)));
		for (Square sq: possible) {
			assertEquals(3,sq.getScore());
		}
		lancelot.setCurrentSquare(new Square(4,2,3));
		lancelot.getBoard()[4][2] = true;
		
		//4th move:
		possible = lancelot.getPossibleSquares();
		assertEquals(3,possible.size());
		assertTrue(possible.contains(new Square(2,1,5)));
		assertTrue(possible.contains(new Square(2,3,5)));
		assertTrue(possible.contains(new Square(3,4,1)));
		assertEquals(new Square(3,4,1),lancelot.getBestSquare(possible));
		lancelot.setCurrentSquare(new Square(3,4,1));
		lancelot.getBoard()[3][4] = true;
		
		//5th move:
		possible = lancelot.getPossibleSquares();
		assertEquals(1,possible.size());
		assertEquals(new Square(1,3,3),lancelot.getBestSquare(possible));
		lancelot.setCurrentSquare(new Square(1,3,3));
		lancelot.getBoard()[1][3] = true;
		
		//6th move:
		possible = lancelot.getPossibleSquares();
		assertEquals(3,possible.size());
		assertTrue(possible.contains(new Square(0,1,1)));
		assertTrue(possible.contains(new Square(2,1,4)));
		assertTrue(possible.contains(new Square(3,2,5)));
		assertEquals(1,lancelot.getScoreOfSquare(0, 1));
		assertEquals(4,lancelot.getScoreOfSquare(2, 1));
		assertEquals(5,lancelot.getScoreOfSquare(3, 2));
		assertEquals(new Square(0,1,1),lancelot.getBestSquare(possible));
		lancelot.setCurrentSquare(new Square(0,1,1));
		lancelot.getBoard()[0][1] = true;
		
		//7th move:
		possible = lancelot.getPossibleSquares();
		assertEquals(1,possible.size());
		assertTrue(possible.contains(new Square(2,0,3)));
		assertEquals(3,lancelot.getScoreOfSquare(2, 0));
		assertEquals(new Square(2,0,3),lancelot.getBestSquare(possible));
		lancelot.setCurrentSquare(new Square(2,0,3));
		lancelot.getBoard()[2][0] = true;
		
		//8th move:
		possible = lancelot.getPossibleSquares();
		assertEquals(3,possible.size());
		assertTrue(possible.contains(new Square(1,2,5)));
		assertTrue(possible.contains(new Square(3,2,4)));
		assertTrue(possible.contains(new Square(4,1,1)));
		assertEquals(5,lancelot.getScoreOfSquare(1,2));
		assertEquals(4,lancelot.getScoreOfSquare(3,2));
		assertEquals(1,lancelot.getScoreOfSquare(4,1));
		assertEquals(new Square(4,1,1),lancelot.getBestSquare(possible));
		lancelot.setCurrentSquare(new Square(4,1,1));
		lancelot.getBoard()[4][1] = true;
		
		//9th move:
		possible = lancelot.getPossibleSquares();
		assertEquals(1,possible.size());
		assertTrue(possible.contains(new Square(3,3,3)));
		assertEquals(3,lancelot.getScoreOfSquare(3,3));
		assertEquals(new Square(3,3,3),lancelot.getBestSquare(possible));
		lancelot.setCurrentSquare(new Square(3,3,3));
		lancelot.getBoard()[3][3] = true;
		
		//10th move:
		possible = lancelot.getPossibleSquares();
		assertEquals(3,possible.size());
		assertTrue(possible.contains(new Square(1,2,4)));
		assertTrue(possible.contains(new Square(1,4,1)));
		assertTrue(possible.contains(new Square(2,1,3)));
		assertEquals(4,lancelot.getScoreOfSquare(1,2));
		assertEquals(1,lancelot.getScoreOfSquare(1,4));
		assertEquals(3,lancelot.getScoreOfSquare(2,1));
		assertEquals(new Square(1,4,1),lancelot.getBestSquare(possible));
		lancelot.setCurrentSquare(new Square(1,4,1));
		lancelot.getBoard()[1][4] = true;
		
		//11th move:
		possible = lancelot.getPossibleSquares();
		assertEquals(1,possible.size());
		assertTrue(possible.contains(new Square(0,2,3)));
		assertEquals(3,lancelot.getScoreOfSquare(0,2));
		assertEquals(new Square(0,2,3),lancelot.getBestSquare(possible));
		lancelot.setCurrentSquare(new Square(0,2,3));
		lancelot.getBoard()[0][2] = true;
		
		//12th move:
		possible = lancelot.getPossibleSquares();
		assertEquals(3,possible.size());
		assertTrue(possible.contains(new Square(1,0,1)));
		assertTrue(possible.contains(new Square(2,1,2)));
		assertTrue(possible.contains(new Square(2,3,4)));
		assertEquals(1,lancelot.getScoreOfSquare(1,0));
		assertEquals(2,lancelot.getScoreOfSquare(2,1));
		assertEquals(4,lancelot.getScoreOfSquare(2,3));
		assertEquals(new Square(1,0,1),lancelot.getBestSquare(possible));
		lancelot.setCurrentSquare(new Square(1,0,1));
		lancelot.getBoard()[1][0] = true;
		
		//13th move:
		possible = lancelot.getPossibleSquares();
		assertEquals(1,possible.size());
		assertTrue(possible.contains(new Square(3,1,3)));
		assertEquals(3,lancelot.getScoreOfSquare(3,1));
		assertEquals(new Square(3,1,3),lancelot.getBestSquare(possible));
		lancelot.setCurrentSquare(new Square(3,1,3));
		lancelot.getBoard()[3][1] = true;
		
		//14th move:
		possible = lancelot.getPossibleSquares();
		assertEquals(3,possible.size());
		assertTrue(possible.contains(new Square(1,2,3)));
		assertTrue(possible.contains(new Square(2,3,3)));
		assertTrue(possible.contains(new Square(4,3,1)));
		assertEquals(3,lancelot.getScoreOfSquare(1,2));
		assertEquals(3,lancelot.getScoreOfSquare(2,3));
		assertEquals(1,lancelot.getScoreOfSquare(4,3));
		assertEquals(new Square(4,3,1),lancelot.getBestSquare(possible));
		lancelot.setCurrentSquare(new Square(4,3,1));
		lancelot.getBoard()[4][3] = true;
		
		//15th move:
		possible = lancelot.getPossibleSquares();
		assertEquals(1,possible.size());
		assertTrue(possible.contains(new Square(2,4,3)));
		assertEquals(3,lancelot.getScoreOfSquare(2,4));
		assertEquals(new Square(2,4,3),lancelot.getBestSquare(possible));
		lancelot.setCurrentSquare(new Square(2,4,3));
		lancelot.getBoard()[2][4] = true;
		
		//16th move:
		possible = lancelot.getPossibleSquares();
		assertEquals(3,possible.size());
		assertTrue(possible.contains(new Square(0,3,1)));
		assertTrue(possible.contains(new Square(1,2,2)));
		assertTrue(possible.contains(new Square(3,2,3)));
		assertEquals(1,lancelot.getScoreOfSquare(0,3));
		assertEquals(2,lancelot.getScoreOfSquare(1,2));
		assertEquals(3,lancelot.getScoreOfSquare(3,2));
		assertEquals(new Square(0,3,1),lancelot.getBestSquare(possible));
		lancelot.setCurrentSquare(new Square(0,3,1));
		lancelot.getBoard()[0][3] = true;
		
		//17th move:
		possible = lancelot.getPossibleSquares();
		assertEquals(1,possible.size());
		assertTrue(possible.contains(new Square(1,1,2)));
		assertEquals(2,lancelot.getScoreOfSquare(1,1));
		assertEquals(new Square(1,1,3),lancelot.getBestSquare(possible));
		lancelot.setCurrentSquare(new Square(1,1,2));
		lancelot.getBoard()[1][1] = true;
		
		//18th move:
		possible = lancelot.getPossibleSquares();
		assertEquals(2,possible.size());
		assertTrue(possible.contains(new Square(2,3,2)));
		assertTrue(possible.contains(new Square(3,2,2)));
		assertEquals(2,lancelot.getScoreOfSquare(2,3));
		assertEquals(2,lancelot.getScoreOfSquare(3,2));
		lancelot.setCurrentSquare(new Square(3,2,2));
		lancelot.getBoard()[3][2] = true;
		
		//19th move:
		possible = lancelot.getPossibleSquares();
		assertEquals(2,possible.size());
		assertTrue(possible.contains(new Square(4,0,1)));
		assertTrue(possible.contains(new Square(4,4,1)));
		assertEquals(1,lancelot.getScoreOfSquare(4,0));
		assertEquals(1,lancelot.getScoreOfSquare(4,4));
		lancelot.setCurrentSquare(new Square(4,4,1));
		lancelot.getBoard()[4][4] = true;
		
		//20th move:
		possible = lancelot.getPossibleSquares();
		assertEquals(1,possible.size());
		assertTrue(possible.contains(new Square(2,3,1)));
		assertEquals(1,lancelot.getScoreOfSquare(2,3));
		assertEquals(new Square(2,3,1),lancelot.getBestSquare(possible));
		lancelot.setCurrentSquare(new Square(2,3,1));
		lancelot.getBoard()[2][3] = true;
		
		//21st move:
		possible = lancelot.getPossibleSquares();
		assertEquals(1,possible.size());
		assertTrue(possible.contains(new Square(0,4,1)));
		assertEquals(1,lancelot.getScoreOfSquare(0,4));
		assertEquals(new Square(0,4,1),lancelot.getBestSquare(possible));
		lancelot.setCurrentSquare(new Square(0,4,1));
		lancelot.getBoard()[0][4] = true;
		
		//22nd move:
		possible = lancelot.getPossibleSquares();
		assertEquals(1,possible.size());
		assertTrue(possible.contains(new Square(1,2,1)));
		assertEquals(1,lancelot.getScoreOfSquare(1,2));
		assertEquals(new Square(1,2,1),lancelot.getBestSquare(possible));
		lancelot.setCurrentSquare(new Square(1,2,1));
		lancelot.getBoard()[1][2] = true;
		
		//23rd move:
		possible = lancelot.getPossibleSquares();
		assertEquals(1,possible.size());
		assertTrue(possible.contains(new Square(0,0,1)));
		assertEquals(1,lancelot.getScoreOfSquare(0,0));
		assertEquals(new Square(0,0,1),lancelot.getBestSquare(possible));
		lancelot.setCurrentSquare(new Square(0,0,1));
		lancelot.getBoard()[0][0] = true;
		
		//24th move:
		possible = lancelot.getPossibleSquares();
		assertEquals(1,possible.size());
		assertTrue(possible.contains(new Square(2,1,1)));
		assertEquals(1,lancelot.getScoreOfSquare(2,1));
		assertEquals(new Square(2,1,1),lancelot.getBestSquare(possible));
		lancelot.setCurrentSquare(new Square(2,1,1));
		lancelot.getBoard()[2][1] = true;
		
		//25th move:
		possible = lancelot.getPossibleSquares();
		assertEquals(1,possible.size());
		assertTrue(possible.contains(new Square(4,0,0)));
		assertEquals(0,lancelot.getScoreOfSquare(4,0));
		assertEquals(new Square(4,0,1),lancelot.getBestSquare(possible));
		lancelot.setCurrentSquare(new Square(4,0,0));
		lancelot.getBoard()[4][0] = true;

	}

	@Test
	public void testGetBestSquare() {
		Knight lancelot = new Knight(new Square(0,0,0),8,8);
		ArrayList<Square> possible = lancelot.getPossibleSquares();
		Square sq = lancelot.getBestSquare(possible);
		assertTrue(sq.equals(new Square(1,2,0)) || sq.equals(new Square(2,1,0)));
		Knight mildred = new Knight(new Square(4,4,0),8,8);
		possible = mildred.getPossibleSquares();
		sq = mildred.getBestSquare(possible);
		assertTrue(sq.equals(new Square(3,6,0)) || sq.equals(new Square(5,6,0)) ||
				sq.equals(new Square(6,3,0)) || sq.equals(new Square(6,5,0)));
	}

	@Test
	public void testClearBoard() {
		Knight lancelot = new Knight(new Square(0,0,0),8,8);
		lancelot.clearBoard();
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				assertFalse(lancelot.getBoard()[r][c]);
			}
		}
	}

	@Test
	public void testGetPossibleSquares() {
		Knight lancelot = new Knight(new Square(0,0,0),8,8);
		ArrayList<Square> possible = lancelot.getPossibleSquares();
		assertEquals(2,possible.size());
		for (Square sq: possible) {
			assertEquals(5,sq.getScore());
		}
		
		Knight mildred = new Knight(new Square(4,4,0),8,8);
		possible = mildred.getPossibleSquares();
		assertEquals(8,possible.size());
	}

	@Test
	public void testGetScoreOfSquare() {
		Knight lancelot = new Knight(new Square(0,0,0),8,8);
		assertEquals(5,lancelot.getScoreOfSquare(1,2));
		assertEquals(5,lancelot.getScoreOfSquare(2,1));
	}

	@Test
	public void testIsValid() {
		Knight lancelot = new Knight(new Square(0,0,0),8,8);
		assertFalse(lancelot.isValid(-1, 1));
		assertFalse(lancelot.isValid(1, -1));
		assertFalse(lancelot.isValid(1, 8));
		assertFalse(lancelot.isValid(8, 1));
		
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				assertTrue(lancelot.isValid(r, c));
			}
		}
	}
}
