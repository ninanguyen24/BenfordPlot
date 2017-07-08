package Assignment2;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.*;

public class BenfordPlot {
	
	

	public static void main(String[] args) throws FileNotFoundException {
		//Replace the file's path here
		Scanner input = new Scanner(new File ("C:\\Users\\Nina\\Desktop\\CSE143\\src\\Assignment2\\popData.txt"));
		Benford test = new Benford();
		test.readCounts(input);
		Font defaultFont = new Font ("Courier New", 1, 20);
		
		double[] temp = new double [9];
		temp = test.benfordPercents();
		
		DrawingPanel panel = new DrawingPanel(1500,1100);
		Graphics g = panel.getGraphics();
		panel.setBackground(Color.GRAY);
	
		
		for(int i = 0; i < temp.length; i++){//Changed i to 1
			temp[i] = (temp[i]);
			g.setColor(Color.YELLOW);
			g.setFont(defaultFont);
			g.fillRect(30, i*100+70,(int) ((temp[i])*20), 50);//x needs to be multiplied by 20 to match scale
		}
		
		defaultPercent(g, defaultFont);
		printPercent(g, temp);
		
		System.out.println(test.readCounts(input));
		System.out.println(test.totalPop());
		System.out.println(Arrays.toString(test.benfordPercents()));
	}
	
	//This method prints the ^ with the default Benford percent
	public static void defaultPercent(Graphics g, Font defaultFont){
		double[] defaultCount = new double[]{30.1, 17.6, 12.5, 9.7, 7.9, 6.7, 5.8, 5.1, 4.6};
		Font myFont = new Font ("Times New Roman", 1, 40);
		g.drawString("Population of Countries", 500, 40);
		String[] number = {"1","2","3","4","5","6","7","8","9"};
		for(int i = 0; i <defaultCount.length; i++){
			g.setColor(Color.RED);
			g.setFont(myFont);
			g.drawString("^",(int)defaultCount[i]*20, i*100+110);//x needs to be multiplied by 20 to match scale
			g.setColor(Color.YELLOW);
			g.setFont(defaultFont); 
			g.drawString(number[i], 10, i*100+100);
		}
		
	}
	
	public static void printPercent(Graphics g, double[] temp){
		Font percentFont = new Font ("Times New Roman", 1, 15);
		for (int i = 0; i < temp.length; i++){
			g.setColor(Color.BLACK);
			g.setFont(percentFont);
			String result = String.format("%.2f", temp[i]);
			g.drawString("" +result+ "%", ((int) (temp[i]*20))/2, i*100+110);
		}
		
		
	}
}
