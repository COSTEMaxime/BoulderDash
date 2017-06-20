package model.element.motionless;

public class MotionlessFactory {

	private static final Earth EARTH = new Earth();
	private static final Air AIR = new Air();
	private static final Wall WALL = new Wall();
	private static final SpecialWall SPECIAL_WALL = new SpecialWall();
	private static final Door DOOR = new Door();
	private static final Amoeba AMOEBA = new Amoeba();
	private static final Explosion EXPLOSION = new Explosion();
	
	private static Motionless[] MotionlessElements = {
			EARTH,
			AIR,
			WALL,
			SPECIAL_WALL,
			DOOR,
			AMOEBA,
			EXPLOSION
	};
	
	public static Motionless createEarth() {
		return null;
	}
	
	public static Motionless createAir() {
		return null;
	}
	
	public static Motionless createWall() {
		return null;
	}
	
	public static Motionless createSpecialWall() {
		return null;
	}
	
	public static Motionless createDoor() {
		return null;
	}
	
	public static Motionless createAmoeba() {
		return null;
	}
	
	public static Motionless createExplosion() {
		return null;
	}
	
	public static Motionless getFileFromSymbol() {
		return null;
	}
}
