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

	private static Earth EARTH;
	private static Air AIR;
	private static Wall WALL;
	private static SpecialWall SPECIAL_WALL;
	private static Door DOOR;
	private static Amoeba AMOEBA;
	private static Explosion EXPLOSION;
	private static Rock ROCK;
	private static Diamond DIAMOND;
	private static Monster_Score MONSTER_SCORE;
	private static Monster_Diamond MONSTER_DIAMOND;
	private static Player PLAYER;

	private static List<Mobile> MobileElements;

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
	
	public static Mobile createEarth() {
		return EARTH;
	}

	public static Mobile createAir() {
		return AIR;
	}

	public static Mobile createWall() {
		return WALL;
	}

	public static Mobile createSpecialWall() {
		return SPECIAL_WALL;
	}

	public static Mobile createDoor() {
		return DOOR;
	}

	public static Mobile createAmoeba() {
		return AMOEBA;
	}

	public static Mobile createExplosion() {
		return EXPLOSION;
	}

	public static Mobile createRock() {
		return ROCK;
	}

	public static Mobile createDiamond() {
		return DIAMOND;
	}

	public static Mobile createMonsterScore() {
		return MONSTER_SCORE;
	}

	public static Mobile createMonsterDiamond() {
		return MONSTER_DIAMOND;
	}

	public static Mobile createPlayer() {
		return PLAYER;
	}

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
