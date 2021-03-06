/*
 * Author: Ridwan Kurmally
 * Git Repository: https://github.com/Ridwan2606/Simulator-Seminar
 */

package SimulatorCodeBase;

public interface Character {
	String getName();
	String getPseudonym();
	int getX();
	int getY();
	void move(Direction d);
}
