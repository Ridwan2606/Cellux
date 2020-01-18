package SimulatorCodeBase;

public interface Character {
	String getName();
	String getPseudonym();
	int getX();
	int getY();
	void move(Directions d);
}
