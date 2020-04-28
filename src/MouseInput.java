import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {
	
	Bird bird;
	Game game;
	Handler handler;
	Score score;
	
	public MouseInput(Bird bird, Game game, Handler handler, Score score) {
		this.bird = bird;
		this.game = game;
		this.handler = handler;
		this.score = score;
	}

	public void mouseClicked(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		
		int mX = e.getX();
		int mY = e.getY();
		
		if (game.getState() == State.Start) {
			game.setState(State.Game);
		} else if (game.getState() == State.Game) {
			bird.fly();
		} else if (game.getState() == State.End) {
			
			if (mX > 127 && mX < 208 && mY > 296 && mY < 322) {
				game.setTimes(0);
				bird.restart(30, 80);
				handler.restart();
				score.restart();
				game.setState(State.Start);
			}

		}
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

}
