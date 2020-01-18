package SimulatorCodeBase;

import java.awt.*;
import javax.swing.*;

public class test {
	public static void main(String[] args) {
		drawGrid();
	}
	
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
	}

}

