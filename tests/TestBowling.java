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
	
	////////////////////
	//STRIKES AND SPARES
	
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
	
	@Test
	public void test_StrikeFollowedBySpare_Score() throws BowlingException {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(10, 0));
		game.addFrame(new Frame(4, 6));
		game.addFrame(new Frame(7, 2));
		game.addFrame(new Frame(3, 6));
		game.addFrame(new Frame(4, 4));
		game.addFrame(new Frame(5, 3));
		game.addFrame(new Frame(3, 3));
		game.addFrame(new Frame(4, 5));
		game.addFrame(new Frame(8, 1));
		game.addFrame(new Frame(2, 6));
		assertEquals(103, game.score());
	}
	
	@Test
	public void test_ConsecutiveStrikes_Score() throws BowlingException {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(10, 0));
		game.addFrame(new Frame(10, 0));
		game.addFrame(new Frame(7, 2));
		game.addFrame(new Frame(3, 6));
		game.addFrame(new Frame(4, 4));
		game.addFrame(new Frame(5, 3));
		game.addFrame(new Frame(3, 3));
		game.addFrame(new Frame(4, 5));
		game.addFrame(new Frame(8, 1));
		game.addFrame(new Frame(2, 6));
		assertEquals(112, game.score());
	}
	
	@Test
	public void test_ConsecutiveSpares_Score() throws BowlingException {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(8, 2));
		game.addFrame(new Frame(5, 5));
		game.addFrame(new Frame(7, 2));
		game.addFrame(new Frame(3, 6));
		game.addFrame(new Frame(4, 4));
		game.addFrame(new Frame(5, 3));
		game.addFrame(new Frame(3, 3));
		game.addFrame(new Frame(4, 5));
		game.addFrame(new Frame(8, 1));
		game.addFrame(new Frame(2, 6));
		assertEquals(98, game.score());
	}
	
	@Test
	public void test_LastFrameSpare_Score() throws BowlingException {
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
		game.addFrame(new Frame(2, 8));
		game.setBonus(7);
		assertEquals(90, game.score());
	}
	
	@Test
	public void test_LastFrameStrike_Score() throws BowlingException {
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
		game.addFrame(new Frame(10, 0));
		game.setBonus(7, 2);
		assertEquals(92, game.score());
	}
	
	@Test
	public void test_BonusIsStrikeAfterSpare_Score() throws BowlingException {
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
		game.addFrame(new Frame(2, 8));
		game.setBonus(10);
		assertEquals(93, game.score());
	}
	
	@Test
	public void test_AllStrikes_Score() throws BowlingException {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(10, 0));
		game.addFrame(new Frame(10, 0));
		game.addFrame(new Frame(10, 0));
		game.addFrame(new Frame(10, 0));
		game.addFrame(new Frame(10, 0));
		game.addFrame(new Frame(10, 0));
		game.addFrame(new Frame(10, 0));
		game.addFrame(new Frame(10, 0));
		game.addFrame(new Frame(10, 0));
		game.addFrame(new Frame(10, 0));
		game.setBonus(10, 10, true);
		assertEquals(300, game.score());
	}
}
