import java.util.ArrayList;
import java.util.List;

//Finish time:
//ID: 112

public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	private int bonusFirst; //Lazy workaround
	private int bonusSecond;
	
	public BowlingGame(){}
	
	// adds a frame to the game
	public void addFrame(Frame frame){
		frames.add(frame);
	}
	
	// Sets the bonus throws at the end of the game
	public void setBonus(int firstThrow, int secondThrow) throws BowlingException {
		bonus = new Frame(firstThrow, secondThrow);
	}
	
	public void setBonus(int firstThrow) throws BowlingException {
		this.setBonus(firstThrow, 0);
	}
	
	// Returns the game score
	public int score() {
		int score = 0;
		int frameScore = 0;
		
		for (int i = 0; i < frames.size(); i++) {
			frameScore = frames.get(i).score();
			
			if (frames.get(i).isStrike()) { //Strike
				if ((i + 1) == frames.size()) //Last throw was strike
					frameScore += bonus.score();
				else if ((i + 1) < frames.size()) {
					frameScore += frames.get(i + 1).score();
					
					//Consecutive strikes
					if (frames.get(i + 1).isStrike() && (i + 2) < frames.size())
						frameScore += frames.get(i + 2).getFirstThrow();
				}
			} else if (frames.get(i).isSpare()) { //Spare
				if ((i + 1) == frames.size()) //Last throw was spare
					frameScore += bonus.getFirstThrow();
				else if ((i + 1) < frames.size())
					frameScore += frames.get(i + 1).getFirstThrow();
			}
			
			score += frameScore;
		}
		
		return score;
	}
}
