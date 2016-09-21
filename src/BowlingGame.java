import java.util.ArrayList;
import java.util.List;

//Finish time:
//ID: 112

public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	
	public BowlingGame(){}
	
	// adds a frame to the game
	public void addFrame(Frame frame){
		frames.add(frame);
	}
	
	// Sets the bonus throws at the end of the game
	public void setBonus(int firstThrow, int secondThrow) {
		//to be implemented
	}
	
	// Returns the game score
	public int score() {
		if (frames == null)
			throw new BowlingException();
		
		int score = 0;
		
		for (int i = 0; i < frames.size(); i++)
			score += frames.get(i).score();
		
		return score;
	}
}
