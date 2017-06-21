package model.element.motionless;

import model.IElement;
import model.element.mobile.Mobile;
import model.element.mobile.gravity.Diamond;
import model.element.mobile.gravity.Gravity;
import model.element.mobile.gravity.Rock;
import model.element.mobile.monster.Monster;

public class MotionlessFactory {

	private static final Earth EARTH = new Earth();
	private static final Air AIR = new Air();
	private static final Wall WALL = new Wall();
	private static final SpecialWall SPECIAL_WALL = new SpecialWall();
	private static final Door DOOR = new Door();
	private static final Amoeba AMOEBA = new Amoeba();
	private static final Explosion EXPLOSION = new Explosion();
	
	private static final Rock ROCK = new Rock();
	private static final Diamond DIAMOND = new Diamond();
	//private static final Monster MONSTER_SCORE = new Monster();
	//private static final Monster MONSTER_DIAMOND = new Monster();
	
	private static Motionless[] MotionlessElements = {
		EARTH,
		AIR,
		WALL,
		SPECIAL_WALL,
		DOOR,
		AMOEBA,
		EXPLOSION
	};
	
	private static Mobile[] MobileElements = {
		ROCK,
		DIAMOND,
	};
	
	public static Motionless createEarth() {
		return EARTH;
	}
	
	public static Motionless createAir() {
		return AIR;
	}
	
	public static Motionless createWall() {
		return WALL;
	}
	
	public static Motionless createSpecialWall() {
		return SPECIAL_WALL;
	}
	
	public static Motionless createDoor() {
		return DOOR;
	}
	
	public static Motionless createAmoeba() {
		return AMOEBA;
	}
	
	public static Motionless createExplosion() {
		return EXPLOSION;
	}
	
	public static IElement getFromFileSymbol(final char fileSymbol) {
		
		if(fileSymbol == 'O' || fileSymbol == 'X' || fileSymbol == '1' || fileSymbol == '2') {
			for(Mobile mobile : MobileElements) {
				if(mobile.getSprite().getConsoleImage() == fileSymbol) {
					return mobile;
				}
			}
		} else {
			for(Motionless motionless : MotionlessElements) {
				if(motionless.getSprite().getConsoleImage() == fileSymbol) {
					return motionless;
				}
			}
		}
		return AIR;
	}
}
