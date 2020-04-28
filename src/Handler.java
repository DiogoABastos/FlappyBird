import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

public class Handler {
	
	private LinkedList<GameObjectA> objectA = new LinkedList<GameObjectA>();
	private LinkedList<GameObjectB> objectB = new LinkedList<GameObjectB>();
	
	private GameObjectA tempObjectA;
	private GameObjectB tempObjectB;
	
	private int pipeCreationSpeed = 100;
	private int gap = 100;
	
	private Pipe tempPipeUp;
	private Pipe tempPipeDown;
	
	private Random r = new Random();
	
	Game game;
	Textures tex;
	Score score;
	
	public Handler(Game game, Textures tex, Score score) {
		this.game = game;
		this.tex = tex;
		this.score = score;
		
	}
	
	public void tick() {
		
		for (int i = 0; i < objectB.size(); i++) {
			tempObjectB = objectB.get(i);
			
			tempObjectB.tick();
		}
		
		for (int i = 0; i < objectA.size(); i++) {
			tempObjectA = objectA.get(i);
			
			tempObjectA.tick();
		}
	
	}
	
	public void render(Graphics g) {
		
		for (int i = 0; i < objectB.size(); i++) {
			tempObjectB = objectB.get(i);
			
			tempObjectB.render(g);
		}
		
		for (int i = 0; i < objectA.size(); i++) {
			tempObjectA = objectA.get(i);
			
			tempObjectA.render(g);
		}
	
	}
	
	public void addObject(GameObjectA block) {
		objectA.add(block);
	}
	
	public void removeObject(GameObjectA block) {
		objectA.remove(block);
	}
	
	public void addObject(GameObjectB block) {
		objectB.add(block);
	}
	
	public void removeObject(GameObjectB block) {
		objectB.remove(block);
		
		if (block.getType() == "UP")
			score.setScore(score.getScore() + 1);
		
	}
	
	public void createPipes() {
		
		if (game.getTimes() % pipeCreationSpeed == 0) {
			float upHeight = r.nextFloat() * (-200 + 350) - 300;
			
			tempPipeUp = new Pipe(Game.WIDTH, upHeight, "UP", tex, this);
			addObject(tempPipeUp);
			
			float downHeight = tempPipeUp.y + tempPipeUp.getHeight() + gap;
			
			tempPipeDown = new Pipe(Game.WIDTH, downHeight, "DOWN", tex, this);
			addObject(tempPipeDown);
		}
	}

	public LinkedList<GameObjectB> getObjectB() {
		return objectB;
	}
	
	public void restart() {
		objectB.clear();
	}
	
}
