import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animation {
	
	Game game;
	private int speed;
	private BufferedImage[] images;
	
	public Animation(int speed, BufferedImage[] images, Game game) {
		this.game = game;
		this.speed = speed * 5;
		this.images = images;
		
	}
	
	private int getCurrentIndex() {
		return (game.getTimes() / speed) % images.length;
	}
	
	public void drawAnimation(double x, double y, Graphics g, Textures tex) {
		g.drawImage(tex.player[getCurrentIndex()], (int)x, (int)y, null);
	}
	
	
	public void stopAnimation(double x, double y, Graphics g, Textures tex) {
		g.drawImage(tex.player[1], (int)x, (int)y, null);
	}
}
