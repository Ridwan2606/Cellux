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
	
	private class Pair<T,U> {
		
		private T right;
		private U left;
		
		public Pair(T t, U j) {
			right = t;
			left = j;
		}
		
		public T getCell() {
			return right;
		}
		
		public U getGUI() {
			return left;
		}
	}

	private Avatar aAvatar;
	private ArrayList<Character> aAutonomousChars = new ArrayList<Character>();
	private Pair<TerrainCell,JLabel>[][] aTerrain;

	public static void main(String[] args) {
		CellWorld w = new CellWorld();
		w.loadSimulation("SimulatorCodeBase/world.ini");
	}
	
	@Override
	public World loadSimulation(String filename) {		
		File file = new File(filename); 
		Scanner sc;
		try {
			sc = new Scanner(file); 
			while (sc.hasNextLine()) 
			      System.out.println(sc.nextLine());
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return null;
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
		// TODO Auto-generated method stub
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
