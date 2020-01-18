package SimulatorCodeBase;

public interface World {
	World loadSimulation(String filename);
	void display();
	void updateSimulation(String command);
	boolean isSimulationOver();
}
