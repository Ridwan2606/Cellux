/*
 * Author: Ridwan Kurmally
 * Git Repository: https://github.com/Ridwan2606/Simulator-Seminar
 */

package SimulatorCodeBase;
import java.awt.Color;
import java.util.Iterator;

public interface TerrainCell {
	String getName();
	int getX();
	int getY();
	Color getColour();
	boolean isFree();
	void addCharacter(Character c);
	void removeCharacter(Character c);
	Iterator<Character> getCharacters();
}
