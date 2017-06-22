package model.element;

import java.util.ArrayList;
import java.util.List;

import model.IElement;
import model.element.mobile.Mobile;
import model.element.mobile.Player;
import model.element.mobile.gravity.Diamond;
import model.element.mobile.gravity.Rock;
import model.element.mobile.monster.Monster_Diamond;
import model.element.mobile.monster.Monster_Score;
import model.element.motionless.Air;
import model.element.motionless.Amoeba;
import model.element.motionless.Door;
import model.element.motionless.Earth;
import model.element.motionless.Explosion;
import model.element.motionless.SpecialWall;
import model.element.motionless.Wall;

public class ElementFactory {

	/** The object EARTH */
	private static Earth EARTH;
	
	/** The object AIR */
	private static Air AIR;
	
	/** The object WALL */
	private static Wall WALL;
	
	/** The object SPECIAL_WALL */
	private static SpecialWall SPECIAL_WALL;
	
	/** The object DOOR */
	private static Door DOOR;
	
	/** The object AMOEBA */
	private static Amoeba AMOEBA;
	
	/** The object EXPLOSION */
	private static Explosion EXPLOSION;
	
	/** The object ROCK */
	private static Rock ROCK;
	
	/** The object ROCK */
	private static Diamond DIAMOND;
	
	/** The object DIAMOND */
	private static Monster_Score MONSTER_SCORE;
	
	/** The object MONSTER_SCORE */
	private static Monster_Diamond MONSTER_DIAMOND;
	
	/** The object MONSTER_DIAMOND */
	private static Player PLAYER;

	/** List containing all the previous elements */
	private static List<Mobile> MobileElements;

	/**
	 * Renews all the elements and places them into the list
	 * 
	 */
	public static void factoryReset() {
		
		EARTH = new Earth();
		AIR = new Air();
		WALL = new Wall();
		SPECIAL_WALL = new SpecialWall();
		DOOR = new Door();
		AMOEBA = new Amoeba();
		EXPLOSION = new Explosion();
		ROCK = new Rock();
		DIAMOND = new Diamond();
		MONSTER_SCORE = new Monster_Score();
		MONSTER_DIAMOND = new Monster_Diamond();
		PLAYER = new Player(0,0);
		
		MobileElements = new ArrayList<Mobile>();
		
		MobileElements.add(EARTH);
		MobileElements.add(AIR);
		MobileElements.add(WALL);
		MobileElements.add(SPECIAL_WALL);
		MobileElements.add(DOOR);
		MobileElements.add(AMOEBA);
		MobileElements.add(EXPLOSION);
		MobileElements.add(ROCK);
		MobileElements.add(DIAMOND);
		MobileElements.add(MONSTER_SCORE);
		MobileElements.add(MONSTER_DIAMOND);
		MobileElements.add(PLAYER);
	}
	
	/** Returns Earth */
	public static Mobile createEarth() {
		return EARTH;
	}

	/** Returns Air */
	public static Mobile createAir() {
		return AIR;
	}

	/** Returns Wall */
	public static Mobile createWall() {
		return WALL;
	}

	/** Returns SpecialWall */
	public static Mobile createSpecialWall() {
		return SPECIAL_WALL;
	}

	/** Returns Door */
	public static Mobile createDoor() {
		return DOOR;
	}

	/** Returns Amoeba */
	public static Mobile createAmoeba() {
		return AMOEBA;
	}
	
	/** Returns Explosion */
	public static Mobile createExplosion() {
		return EXPLOSION;
	}

	/** Returns Rock */
	public static Mobile createRock() {
		return ROCK;
	}

	/** Returns Diamond */
	public static Mobile createDiamond() {
		return DIAMOND;
	}

	/** Returns Monster_Score */
	public static Mobile createMonsterScore() {
		return MONSTER_SCORE;
	}

	/** Returns Monster_Diamond */
	public static Mobile createMonsterDiamond() {
		return MONSTER_DIAMOND;
	}

	/** Returns Player */
	public static Mobile createPlayer() {
		return PLAYER;
	}

	/**
	 * Returns the corresponding object to a certain symbol
	 * 
	 * @param fileSymbol
	 * @return
	 */
	public static IElement getFromFileSymbol(final char fileSymbol) {

		factoryReset();
		
		for (Mobile mobile : MobileElements) {
			if (mobile.getSprite().getConsoleImage() == fileSymbol) {
				return mobile;
			}
		}
		return new Air();
	}
}
