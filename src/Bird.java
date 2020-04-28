import java.awt.Graphics;
import java.awt.Rectangle;

public class Bird extends GameObjectA {

	private float width = 34, height = 26, fly = -5, gravity = 0.2f;
	
	private Textures tex;
	private Animation anim;
	
	private GameObjectB tempObjectB;
	
	Game game;
	Handler handler;
	Foreground foreground;
	Score score;

	public Bird(float x, float y, Textures tex, Game game, Handler handler, Foreground foreground, Score score) {
		super(x, y);
		this.tex = tex;
		this.game = game;
		this.handler = handler;
		this.foreground = foreground;
		this.score = score;
				
		anim = new Animation(2, tex.player, game);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		velY += gravity;
		
		for (int i = 0; i < handler.getObjectB().size(); i++) {
			tempObjectB = handler.getObjectB().get(i);
			
			if (Physics.Collision(this, tempObjectB)) {
				
				if (score.getScore() > score.getBest())
					score.setBest(score.getScore());
				
				game.setState(State.End);
			}
		}
		
		if (y > foreground.getY() - height) {
			y = foreground.getY() - height;
			
			if (score.getScore() > score.getBest())
				score.setBest(score.getScore());
			
			game.setState(State.End);
		}
	}

	public void render(Graphics g) {
		if (game.getState() != State.End) {
			anim.drawAnimation(x, y, g, tex);
		} else {
			anim.stopAnimation(x, y, g, tex);
		}
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, (int) width, (int) height);
	}
	
	public void fly() {
		velY = fly;
	}
	
}
