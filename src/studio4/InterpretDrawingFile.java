package studio4;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import edu.princeton.cs.introcs.StdDraw;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class InterpretDrawingFile {

	public static void main(String[] args) throws FileNotFoundException {
		JFileChooser chooser = new JFileChooser("resources");
		chooser.showOpenDialog(null);
		File f = new File(chooser.getSelectedFile().getPath());
		Scanner in = new Scanner(f); //making Scanner with a File
		
		String shapeType = in.next();
		int redComponent = in.nextInt();
		int greenComponent = in.nextInt();
		int blueComponent = in.nextInt();
		boolean isFilled = in.nextBoolean();

		double[] xy = new double[6];
		int i = 0;
		while (in.hasNextDouble()) {
			xy[i] = in.nextDouble();
			i++;
		}
		
		if (shapeType.equals("rectangle")) {
			if (isFilled) {
				Color newColor = new Color(redComponent, greenComponent, blueComponent);
				StdDraw.setPenColor(newColor);
				StdDraw.filledRectangle(xy[0], xy[1], xy[2], xy[3]);
			}
			else {
				Color newColor = new Color(redComponent, greenComponent, blueComponent);
				StdDraw.setPenColor(newColor);
				StdDraw.rectangle(xy[0], xy[1], xy[2], xy[3]);
			}
		}
		else if (shapeType.equals("ellipse")) {
			if (isFilled) {
				Color newColor = new Color(redComponent, greenComponent, blueComponent);
				StdDraw.setPenColor(newColor);
				StdDraw.filledEllipse(xy[0], xy[1], xy[2], xy[3]);
			}
			else {
				Color newColor = new Color(redComponent, greenComponent, blueComponent);
				StdDraw.setPenColor(newColor);
				StdDraw.ellipse(xy[0], xy[1], xy[2], xy[3]);
			}
		}
		else {
			double[] xs = {xy[0], xy[1], xy[2]};
			double[] ys = {xy[3], xy[4], xy[5]};
			if (isFilled) {
				Color newColor = new Color(redComponent, greenComponent, blueComponent);
				StdDraw.setPenColor(newColor);
				StdDraw.filledPolygon(xs, ys);
			}
			else {
				Color newColor = new Color(redComponent, greenComponent, blueComponent);
				StdDraw.setPenColor(newColor);
				StdDraw.polygon(xs, ys);
			}
		}


	}
}
