package SimulatorCodeBase;

public interface Character {
	String getName();
	String getDescription();
	int getX();
	int getY();
	void move(Directions d);
}
