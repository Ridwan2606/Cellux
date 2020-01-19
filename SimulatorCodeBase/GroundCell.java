/*
 * Author: Ridwan Kurmally
 * Git Repository: https://github.com/Ridwan2606/Simulator-Seminar
 */

package SimulatorCodeBase;

import java.awt.Color;

public class GroundCell extends AbstractCell {
	
	private final String aName = "Ground";
	private final Color aColor = Color.green;
	
	public GroundCell(int pX, int pY) {
		aX = pX;
		aY = pY;
	}
	
	public String getName() {
		return aName;
	}

	public Color getColour() {
		return aColor;
	}

}
