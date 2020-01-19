/*
 * Author: Ridwan Kurmally
 * Git Repository: https://github.com/Ridwan2606/Simulator-Seminar
 */

package SimulatorCodeBase;

import java.awt.Color;

public class WaterCell extends AbstractCell {

	private final String aName = "Water";
	private final Color aColor = Color.blue;
	
	public WaterCell(int pX, int pY) {
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
