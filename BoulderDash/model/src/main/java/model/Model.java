package model;

public class Model {
	
	private IMap map;
	private IMobile player;
	
	public Model(String fileName) {
		
	}

	public IMap getMap() {
		return map;
	}

	public void setMap(IMap map) {
		this.map = map;
	}

	public IMobile getPlayer() {
		return player;
	}

	public void setPlayer(IMobile player) {
		this.player = player;
	}
}
