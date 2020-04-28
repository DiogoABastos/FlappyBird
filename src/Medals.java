import java.awt.Graphics;

public class Medals extends BackgroundObject {
	
	Textures tex;
	Score score;

	public Medals(float x, float y, Textures tex, Score score) {
		super(x, y);
		this.tex = tex;
		this.score = score;
	}

	public void tick() {
		
	}

	public void render(Graphics g) {
		if (score.getScore() < 5) {
			g.drawImage(tex.medals[0], (int) x, (int) y, null);	
		} else if (score.getScore() < 10) {
			g.drawImage(tex.medals[4], (int) x, (int) y, null);
		} else if (score.getScore() < 15) {
			g.drawImage(tex.medals[3], (int) x, (int) y, null);
		} else if (score.getScore() < 20) {
			g.drawImage(tex.medals[2], (int) x, (int) y, null);
		} else if (score.getScore() < 25) {
			g.drawImage(tex.medals[1], (int) x, (int) y, null);
		}
	}
	
}
