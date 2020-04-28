import java.awt.Graphics;
import java.awt.Rectangle;

public class Pipe extends GameObjectB {

	private float width = 53, height = 400;
	private float move = 3;
	
	Textures tex;
	Handler handler;
	
	public Pipe(float x, float y, String type, Textures tex, Handler handler) {
		super(x, y, type);
		this.tex = tex;
		this.handler = handler;
		
	}

	public void tick() {
		x -= move;
		
		if (x < -width)
			handler.removeObject(this);
	}

	public void render(Graphics g) {
		if (type == "UP") {
			g.drawImage(tex.pipeUp,(int) x, (int) y, null);	
		} else if (type == "DOWN") {
			g.drawImage(tex.pipeDown,(int) x, (int) y, null);
		}
		
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, (int) width, (int) height);
	}

	public float getHeight() {
		return height;
	}

	public String getType() {
		return type;
	}

}
