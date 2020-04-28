import java.awt.Graphics;

public class End extends BackgroundObject {
	
	Textures tex;
	
	

	public End(float x, float y, Textures tex) {
		super(x, y);
		this.tex = tex;
	}

	public void tick() {
		
	}

	public void render(Graphics g) {
		g.drawImage(tex.end, (int) x, (int) y, null);
	}

}
