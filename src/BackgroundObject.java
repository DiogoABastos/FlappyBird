import java.awt.Graphics;

public abstract class BackgroundObject {
	
	protected float x, y;
	protected float move = 3;
	
	public BackgroundObject(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getMove() {
		return move;
	}

	public void setMove(float move) {
		this.move = move;
	}
	
}
