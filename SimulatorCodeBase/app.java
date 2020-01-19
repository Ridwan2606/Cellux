/*
 * Author: Ridwan Kurmally
 * Git Repository: https://github.com/Ridwan2606/Simulator-Seminar
 */

package SimulatorCodeBase;

import java.util.Scanner;

public class app {
	
	public static void main(String[] args) {
		CellWorld w = new CellWorld("My Cell World");
		w.loadSimulation("SimulatorCodeBase/world2.ini");
		Scanner sc = new Scanner(System.in);
		while (!w.isSimulationOver()) {
			w.display();
		    String command = sc.nextLine();  
			w.updateSimulation(command);
		}
		sc.close();	
	}
	
}
