import java.awt.Graphics;

public class Foreground extends BackgroundObject {
	
	private float width = 224;
	public static float HEIGHT = 112;
	
	Textures tex;

	public Foreground(float x, float y, Textures tex) {
		super(x, y);
		this.tex = tex;
	}

	public void tick() {
		x = (x - move) % (width / 2);
	}

	public void render(Graphics g) {
		g.drawImage(tex.foreground, (int) x, (int) y, null);
		g.drawImage(tex.foreground, (int) x + (int) width, (int) y, null);
	}
	
}
