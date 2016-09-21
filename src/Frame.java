public class Frame {
	private int firstThrow;
	private int secondThrow;
	
	public Frame(int firstThrow, int secondThrow) throws BowlingException {
		if (firstThrow < 0 || secondThrow < 0
			|| firstThrow > 10 || secondThrow > 10
			|| firstThrow + secondThrow > 10)
			throw new BowlingException();
		
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
	}
	
	public int getFirstThrow() {
		return firstThrow;
	}

	public int getSecondThrow() {
		return secondThrow;
	}

	//returns the score of a single frame
	public int score(){
		int score = firstThrow + secondThrow;
		return score;
	}

	//returns whether the frame is a strike or not
	public boolean isStrike(){
		return (firstThrow == 10);
	}
	
	//return whether a frame is a spare or not
	public boolean isSpare(){
		return (firstThrow + secondThrow == 10);
	}
}
