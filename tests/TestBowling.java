import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test(expected=BowlingException.class)
	public void test_NegativeScore1() throws BowlingException {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(-1, 2));
	}

	@Test(expected=BowlingException.class)
	public void test_NegativeScore2() throws BowlingException {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(3, -2));
	}
	
	@Test(expected=BowlingException.class)
	public void test_TooBigThrow() throws BowlingException {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(13, 2));
	}
	
	@Test(expected=BowlingException.class)
	public void test_TooBigScore() throws BowlingException {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(9, 2));
	}
	
	@Test
	public void test_FrameScore() throws BowlingException {
		Frame frame = new Frame(3, 6);
		assertEquals(9, frame.score());
	}
	
	@Test
	public void test_GameNotStarted() {
		BowlingGame game = new BowlingGame();
		assertEquals(0, game.score());
	}
}
