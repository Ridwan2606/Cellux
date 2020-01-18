package SimulatorCodeBase;

public class Avatar implements Character {

	private String aName;
	private int aX;
	private int aY;
	private String aPseudonym;
	
	public Avatar(String pName, String pPseudonym) {
		aX = 0;
		aY = 0;
		aName = pName;
		aPseudonym = pPseudonym;
	}
	
	public String getName() {
		return aName;
	}

	public String getPseudonym() {
		return aPseudonym;
	}
	
	public int getX() {
		return aX;
	}

	public int getY() {
		return aY;
	}

	public void move(Directions d) {
		switch(d) {
		  case NORTH:
		    aY--;
		    break;
		  case SOUTH:
		    aY++;
		    break;
		  case EAST:
			aX++;
			break;
		  case WEST:
		    aX--;
		    break;
		
		}

	}

}
