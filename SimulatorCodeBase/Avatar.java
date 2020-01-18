package SimulatorCodeBase;

public class Avatar implements Character {

	private String aName;
	private int aX;
	private int aY;
	private String aDescription;
	
	public Avatar(String pName, String pDescription) {
		aX = 0;
		aY = 0;
		aName = pName;
		aDescription = pDescription;
	}
	
	public String getName() {
		return aName;
	}

	public String getDescription() {
		return aDescription;
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
