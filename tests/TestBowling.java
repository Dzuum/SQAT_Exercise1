import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {
	
	////////////////
	//FRAME CREATION

	@Test(expected=BowlingException.class)
	public void test_NegativeScore1() throws BowlingException {
		Frame frame = new Frame(-1, 2);
	}

	@Test(expected=BowlingException.class)
	public void test_NegativeScore2() throws BowlingException {
		Frame frame = new Frame(3, -2);
	}
	
	@Test(expected=BowlingException.class)
	public void test_TooBigThrow() throws BowlingException {
		Frame frame = new Frame(13, 2);
	}
	
	@Test(expected=BowlingException.class)
	public void test_TooBigScore() throws BowlingException {
		Frame frame = new Frame(9, 2);
	}
	
	//////////////
	//BASIC SCORES
	
	@Test
	public void test_FrameScore() throws BowlingException {
		Frame frame = new Frame(3, 6);
		assertEquals(9, frame.score());
	}
	
	@Test
	public void test_GameNotStarted_Score() {
		BowlingGame game = new BowlingGame();
		assertEquals(0, game.score());
	}
	
	@Test
	public void test_FullGame_Score() throws BowlingException {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(1, 5));
		game.addFrame(new Frame(3, 6));
		game.addFrame(new Frame(7, 2));
		game.addFrame(new Frame(3, 6));
		game.addFrame(new Frame(4, 4));
		game.addFrame(new Frame(5, 3));
		game.addFrame(new Frame(3, 3));
		game.addFrame(new Frame(4, 5));
		game.addFrame(new Frame(8, 1));
		game.addFrame(new Frame(2, 6));
		assertEquals(81, game.score());
	}
	
	@Test
	public void test_StrikeInBeginning_Score() throws BowlingException {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(10, 0));
		game.addFrame(new Frame(3, 6));
		game.addFrame(new Frame(7, 2));
		game.addFrame(new Frame(3, 6));
		game.addFrame(new Frame(4, 4));
		game.addFrame(new Frame(5, 3));
		game.addFrame(new Frame(3, 3));
		game.addFrame(new Frame(4, 5));
		game.addFrame(new Frame(8, 1));
		game.addFrame(new Frame(2, 6));
		assertEquals(94, game.score());
	}
	
	@Test
	public void test_SpareInBeginning_Score() throws BowlingException {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(1, 9));
		game.addFrame(new Frame(3, 6));
		game.addFrame(new Frame(7, 2));
		game.addFrame(new Frame(3, 6));
		game.addFrame(new Frame(4, 4));
		game.addFrame(new Frame(5, 3));
		game.addFrame(new Frame(3, 3));
		game.addFrame(new Frame(4, 5));
		game.addFrame(new Frame(8, 1));
		game.addFrame(new Frame(2, 6));
		assertEquals(88, game.score());
	}
	
	
}
