package model.element.motionless;

import model.IElement;
import model.element.mobile.Mobile;
import model.element.mobile.Player;
import model.element.mobile.gravity.Diamond;
import model.element.mobile.gravity.Gravity;
import model.element.mobile.gravity.Rock;
import model.element.mobile.monster.Monster;
import model.element.mobile.monster.Monster_Diamond;
import model.element.mobile.monster.Monster_Score;

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
	private static final Monster_Score MONSTER_SCORE = new Monster_Score();
	private static final Monster_Diamond MONSTER_DIAMOND = new Monster_Diamond();
	private static final Player PLAYER = new Player();

	private static Motionless[] MotionlessElements = { EARTH, AIR, WALL, SPECIAL_WALL, DOOR, AMOEBA, EXPLOSION };

	private static Gravity[] GravityElements = { ROCK, DIAMOND };

	private static Mobile[] MobileElements = { MONSTER_SCORE, MONSTER_DIAMOND, PLAYER };

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

	public static Gravity createRock() {
		return ROCK;
	}

	public static Gravity createDiamond() {
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

		// Case of Monsters (or player)
		if (fileSymbol == '1' || fileSymbol == '2' || fileSymbol == '+') {
			for (Mobile mobile : MobileElements) {
				if (mobile.getSprite().getConsoleImage() == fileSymbol) {
					return mobile;
				}
			}

			// Case of Gravity affected items (Rocks / Diamonds)
		} else if (fileSymbol == 'X' || fileSymbol == 'O') {
			for (Gravity gravity : GravityElements) {
				if (((IElement) gravity).getSprite().getConsoleImage() == fileSymbol) {
					return (IElement) gravity;
				}
			}
			// Case of Motionless Items (Earth / Walls / ...)
		} else {
			for (Motionless motionless : MotionlessElements) {
				if (motionless.getSprite().getConsoleImage() == fileSymbol) {
					return motionless;
				}
			}
		}
		return AIR;
	}
}
