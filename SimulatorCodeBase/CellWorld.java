package SimulatorCodeBase;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class CellWorld implements World {
	
	private class TerrainGUIPair {
		
		private TerrainCell right;
		private JLabel left;
		
		public TerrainGUIPair(TerrainCell t, JLabel j) {
			right = t;
			left = j;
		}
		
		public TerrainCell getCell() {
			return right;
		}
		
		public JLabel getGUI() {
			return left;
		}
	}

	private Avatar aAvatar;
	private ArrayList<Character> aAutonomousChars = new ArrayList<Character>();
	private TerrainGUIPair[][] aTerrain;

    JFrame aMainFrame;
    JPanel grid = new JPanel();
	
	public static void main(String[] args) {
		CellWorld w = new CellWorld();
		w.loadSimulation("SimulatorCodeBase/world.ini");
		System.out.println("Ended Simulation");
	}
	
	public World loadSimulation(String filename) {	
		initialiseWindow();
		SetUp(filename);
		aMainFrame.setVisible(true);
		SwingUtilities.updateComponentTreeUI(aMainFrame);
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	private void initialiseWindow() {
		aMainFrame = new JFrame("The World");
		aMainFrame.setSize(1000,650);
		aMainFrame.setLayout(new GridLayout(1, 1));
	}

	private void SetUp (String filename) {
		File file = new File(filename); 
		Scanner sc;
		try {
			sc = new Scanner(file); 
			sc.useDelimiter("\\s");
			String line;
			while (sc.hasNextLine()) {
				
				line = sc.next();
				
				if (line.equalsIgnoreCase("[AVATAR]")) {
					String pName="Anonymous";
					String pPseudo="A";
					int pX=0;
					int pY=0;
					
					while (!line.startsWith("[")) {
						line = sc.next();
						if (line.equalsIgnoreCase("name=")) {
							pName = sc.next();
						} 
						if (line.equalsIgnoreCase("pseudonym=")) {
							pPseudo = sc.next();
						} 
						if (line.equalsIgnoreCase("x=")) {
							pX = Integer.parseInt(sc.next());
						} 
						if (line.equalsIgnoreCase("y=")) {
							pY = Integer.parseInt(sc.next());
						}
					}
					aAvatar = new Avatar(pName, pPseudo, pX, pY);
				}
				
				if (line.equalsIgnoreCase("[TERRAIN]")) {
					
					int rowSize = 0;
					int colSize = 0;
					line = sc.next();
					
					while (!line.contains("{")) {
						
						if (line.equalsIgnoreCase("rowsize=")) {
							rowSize = Integer.parseInt(sc.next());
						} 
						if (line.equalsIgnoreCase("colsize=")) {
							colSize = Integer.parseInt(sc.next());
						} 
						
						line = sc.next();
					}
					aTerrain = new TerrainGUIPair[rowSize][colSize];
				    grid.setLayout(new GridLayout(rowSize, colSize));
				    aMainFrame.add(grid);
				    
				    sc.next();
				    
					for (int i=0; i<rowSize; i++) {
						for (int j=0; j<colSize; j++) {
							String terrainSymbol = sc.next();
							addTerrain(terrainSymbol,i,j);
						}
						sc.next();
						System.out.println();
					}
					sc.next();
				}
			}
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void addTerrain(String terrainSymbol, int pX, int pY) {
		
		JLabel current = new JLabel("",SwingConstants.CENTER);
        current.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        current.setOpaque(true);
        
        TerrainCell cell = null;
        TerrainGUIPair pair = null;
        
		if (terrainSymbol.equalsIgnoreCase("w")) {
			cell = new WaterCell(pX, pY);
			current.setBackground(Color.blue);
		} else {
			cell = new GroundCell(pX, pY);
			current.setBackground(Color.green);
		}
		
		pair = new TerrainGUIPair(cell,current);
		aTerrain[pX][pY] = pair;
		grid.add(current);
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateSimulation(String command) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isSimulationOver() {
		return false;
	}
	
	/*
	static void drawGrid() {
	    int width = 10, height = 10;
	    int i,j;

	    JLabel[][] LabelArray = new JLabel[width][height];

	    JFrame mainFrame = new JFrame("The World");
	    mainFrame.setSize(1000,650);
	    mainFrame.setLayout(new GridLayout(1, 1));                         

	    JPanel grid = new JPanel();                                        
	    grid.setLayout(new GridLayout(width, height));

	    mainFrame.add(grid);

	    for(i=0;i<width;i++) {
	        for (j = 0; j < height; j++) {
	            JLabel current = new JLabel("",SwingConstants.CENTER);
	            current.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	            current.setOpaque(true);

	            if (j%2==0) current.setBackground(Color.blue);
	            else current.setBackground(Color.green);

	            if (j+i == 10) current.setText("Hello");

	            LabelArray[i][j] = current;
	            grid.add(LabelArray[i][j]);
	        }
	    }

	    mainFrame.setVisible(true);
	    
	    try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

        LabelArray[5][5].setBackground(Color.yellow);;
        //grid.add(LabelArray[5][5]);
        
        //mainFrame.setVisible(false);
        //mainFrame.setVisible(true);
        SwingUtilities.updateComponentTreeUI(mainFrame);
	}
	*/

}
