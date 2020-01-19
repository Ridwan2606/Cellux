/*
 * Author: Ridwan Kurmally
 * Git Repository: https://github.com/Ridwan2606/Simulator-Seminar
 */

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

	public CellWorld(String pName) {
		aName = pName;
	}
	private String aName;
	private Avatar aAvatar;
	private TerrainGUIPair[][] aTerrain;
	// private ArrayList<Character> aAutonomousChars = new ArrayList<Character>();

    JFrame aMainFrame;
    JPanel grid = new JPanel();
	
	public World loadSimulation(String filename) {	
		initialiseWindow();
		SetUp(filename);
		aMainFrame.setVisible(true);
		return this;
	}

	private void initialiseWindow() {
		aMainFrame = new JFrame(aName);
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
					
					line = sc.next();
					
					while (!line.startsWith("[")) {
				
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
						
						line = sc.next();
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
							addTerrain(terrainSymbol,j,i);
						}
						sc.next();
					}
					sc.next();
				}
			}
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		spawnCharacter(aAvatar);
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
		aTerrain[pY][pX] = pair;
		grid.add(current);
	}
	
	@Override
	public void display() {
		SwingUtilities.updateComponentTreeUI(aMainFrame);
	}

	@Override
	public void updateSimulation(String command) {
		
		Direction direction = null;
		
		if (command.equalsIgnoreCase("north")) {
			direction = Direction.NORTH;
		} else if (command.equalsIgnoreCase("south")) {
			direction = Direction.SOUTH;
		} else if (command.equalsIgnoreCase("east")) {
			direction = Direction.EAST;
		} else if (command.equalsIgnoreCase("west")) {
			direction = Direction.WEST;
		}
		
		if ( direction!=null & !isOutOfBound(aAvatar,direction)) moveCharacter(aAvatar,direction);
		
	}
	
	private void spawnCharacter(Character character) {
		TerrainGUIPair spawnLocation = aTerrain[character.getY()][character.getX()];
		spawnLocation.getCell().addCharacter(character);
		spawnLocation.getGUI().setText(character.getName());
	}
	
	private void moveCharacter(Character character, Direction d) {
		
		TerrainGUIPair previousLocation = aTerrain[character.getY()][character.getX()];
		previousLocation.getCell().removeCharacter(character);
		previousLocation.getGUI().setText("");
		
		character.move(d);
		
		TerrainGUIPair newLocation = aTerrain[character.getY()][character.getX()];
		newLocation.getCell().addCharacter(character);
		newLocation.getGUI().setText(character.getName());
		
	}

	private boolean isOutOfBound(Character character, Direction d) {
		switch(d) {
		  case NORTH:
		    return (character.getY()-1<0);
		  case SOUTH:
			return (character.getY()+1>=aTerrain.length);
		  case EAST:
			return (character.getX()+1>=aTerrain[0].length);
		  case WEST:
			return (character.getX()-1<0);
		}
		return false;
	}

	public boolean isSimulationOver() {
		return false;
	}

	public String getName() {
		return aName;
	}
	
}