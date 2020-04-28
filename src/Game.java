import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = -8921419424614180143L;
	
	public static int WIDTH = 320, HEIGHT = 480;
	
	public Game() {
		new Window(WIDTH, HEIGHT, "Flappy Bird", this);
	}
	
	private Thread thread;
	private boolean running = false;
	private int times = 0;
	
	private BufferedImage spriteSheet = null;
	
	private Textures tex;
	private Handler handler;
	private Bird bird;
	private Background background;
	private Foreground foreground;
	private Start start;
	private End end;
	private Score score;
	private Medals medals;
	
	private State state = State.Start;
	
	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public synchronized void start() {
		if (running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	private void init() {
		BufferedImageLoader loader = new BufferedImageLoader();
		
		try {
			spriteSheet = loader.loadImage("/sprite_sheet.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		tex = new Textures(this);
		
		score = new Score(WIDTH / 2 - 10, 50, this);
		
		handler = new Handler(this, tex, score);
		
		foreground = new Foreground(0, HEIGHT - Foreground.HEIGHT, tex);
		
		bird = new Bird(30, 80, tex, this, handler, foreground, score);
		
		start = new Start(WIDTH / 4, HEIGHT / 4, tex);
		
		end = new End(WIDTH / 4 - 25, HEIGHT / 4, tex);
		
		handler.addObject(bird);
		
		medals = new Medals(78, 205, tex, score);
		
		background = new Background(0, HEIGHT - Background.HEIGHT - Foreground.HEIGHT, tex);
		
		addMouseListener(new MouseInput(bird, this, handler, score));
		
	}

	public void run() {
		init();
		this.requestFocus();
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				tick();
				updates++;
				times++;
				delta--;
			}
			
			render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(updates + " ticks, fps " + frames);
				updates = 0;
				frames = 0;
			}
		}
	}
	
	public int getTimes() {
		return times;
	}
	
	public void setTimes(int times) {
		this.times = times;
	}

	public void tick() {
		
		if (state == State.Game) {
		
			handler.createPipes();
			
			handler.tick();
			
			foreground.tick();
			
		} else if (state == State.End) {
			bird.tick();
		}
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		//////////////////////////////////
		
		g.setColor(Color.cyan);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		background.render(g);
		
		handler.render(g);
		
		if (state == State.Start)
			start.render(g);
		
		if (state == State.End) {
			end.render(g);
			medals.render(g);
			
		}
		
		foreground.render(g);
		
		score.render(g);
			
		/////////////////////////////////
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		new Game();
	}

	public BufferedImage getSpriteSheet() {
		return spriteSheet;
	}

}
