package SimulatorCodeBase;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

public class GroundCell implements TerrainCell {

	private final String aName = "Ground";
	private final Color aColor = Color.green;
	private int aX;
	private int aY;
	private ArrayList<Character> aCharacters = new ArrayList<>();
	
	public GroundCell(int pX, int pY) {
		aX = pX;
		aY = pY;
	}

	public String getName() {
		return aName;
	}

	public int getX() {
		return aX;
	}

	public int getY() {
		return aY;
	}
	
	public Color getColour() {
		return aColor;
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
