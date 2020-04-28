import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	private BufferedImage image;
	
	public SpriteSheet(BufferedImage image) {
		this.image = image;
	}
	
	public BufferedImage grabImage(int x, int y, int width, int height) {
		
		BufferedImage img = image.getSubimage(x, y, width, height);
		
		return img;
	}
}
