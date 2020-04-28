import java.awt.Graphics;

public class Background extends BackgroundObject {
	
	private float width = 275;
	public static float HEIGHT = 226;
	
	Textures tex;

	public Background(float x, float y, Textures tex) {
		super(x, y);
		this.tex = tex;
	}

	public void tick() {
	}

	public void render(Graphics g) {
		g.drawImage(tex.background, (int) x, (int) y, null);
		g.drawImage(tex.background, (int) x + (int) width, (int) y, null);
	}

}
