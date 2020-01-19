/*
 * Author: Ridwan Kurmally
 * Git Repository: https://github.com/Ridwan2606/Simulator-Seminar
 */

package SimulatorCodeBase;

public interface World {
	World loadSimulation(String filename);
	void display();
	void updateSimulation(String command);
	boolean isSimulationOver();
}
