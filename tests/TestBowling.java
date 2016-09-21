import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test(expected=BowlingException.class)
	public void test_NegativeScore1()  {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(-1, 2));
	}

}
