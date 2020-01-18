package SimulatorCodeBase;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class AbstractCell implements TerrainCell {

	protected int aX;
	protected int aY;
	protected ArrayList<Character> aCharacters = new ArrayList<>();
	
	public abstract String getName();
	public abstract Color getColour();

	public int getX() {
		return aX;
	}

	public int getY() {
		return aY;
	}
	
	public boolean isFree() {
		return aCharacters.isEmpty();
	}

	public void addCharacter(Character c) {
		aCharacters.add(c);
	}

	public void removeCharacter(Character c) {
		aCharacters.remove(c);
	}
	
	public Iterator<Character> getCharacters(){
		return aCharacters.iterator();
	}

}
