import java.awt.Graphics;

public class Start extends BackgroundObject {
	
	Textures tex;

	public Start(float x, float y, Textures tex) {
		super(x, y);
		this.tex = tex;
	}

	public void tick() {
		
	}

	public void render(Graphics g) {
		g.drawImage(tex.start, (int) x, (int) y, null);
	}
	
}
