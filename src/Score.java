import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Score  extends BackgroundObject {
	
	private int score = 0;
	private int best = 0;
	
	private int scoreX = 230, scoreY = 218, bestX = 230, bestY = 260;
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	Game game;

	public Score(float x, float y, Game game) {
		super(x, y);
		this.game = game;
	}

	public void tick() {
	}

	public void render(Graphics g) {
		Font fnt0 = new Font("arial", Font.BOLD, 50);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString(Integer.toString(score), (int) x, (int) y);
		
		if (game.getState() == State.End) {
			Font fnt1 = new Font("arial", Font.BOLD, 30);
			g.setFont(fnt1);
			g.drawString(Integer.toString(score), scoreX, scoreY);
			g.drawString(Integer.toString(best), bestX, bestY);
			
		}
		
	}
	
	public void restart() {
		score = 0;
	}

	public int getBest() {
		return best;
	}

	public void setBest(int best) {
		this.best = best;
	}

}
