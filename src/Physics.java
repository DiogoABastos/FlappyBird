
public class Physics {
	
	public static boolean Collision(GameObjectA objectA, GameObjectB objectB) {
		if (objectA.getBounds().intersects(objectB.getBounds()))
			return true;
		
		return false;		
	}
}
