
public abstract class GameObjectB extends GameObject {
	
	protected String type;

	public GameObjectB(float x, float y, String type) {
		super(x, y);
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
