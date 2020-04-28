import java.awt.image.BufferedImage;

public class Textures {
	
	public BufferedImage[] player = new BufferedImage[4];
	public BufferedImage pipeUp, pipeDown, foreground, background, start, end;
	public BufferedImage[] medals = new BufferedImage[5];
	
	public SpriteSheet ss;
	
	public Textures(Game game) {
		ss = new SpriteSheet(game.getSpriteSheet());
		
		getTextures();
	}
	
	private void getTextures() {
		
		player[0] = ss.grabImage(276, 112, 34, 26);
		player[1] = ss.grabImage(276, 139, 34, 26);
		player[2] = ss.grabImage(276, 164, 34, 26);
		player[3] = ss.grabImage(276, 139, 34, 26);
		
		pipeUp = ss.grabImage(553, 0, 53, 400);
		
		pipeDown = ss.grabImage(502, 0, 53, 400);
		
		foreground = ss.grabImage(276, 0, 224, 112);
		
		background = ss.grabImage(0, 0, 275, 226);
		
		start = ss.grabImage(0, 228, 173, 152);
		
		end = ss.grabImage(175, 228, 225, 200);
		
		medals[0] = ss.grabImage(450, 120, 48, 48); // no medal
		medals[1] = ss.grabImage(310, 110, 48, 48); // platina medal
		medals[2] = ss.grabImage(358, 110, 48, 48); // silver medal
		medals[3] = ss.grabImage(310, 158, 48, 48); // gold medal
		medals[4] = ss.grabImage(358, 158, 48, 48); // bronze medal
		
	}
}
