import java.util.ArrayList;

import javafx.geometry.Point2D;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Snake {
	
	private GridPane gp;
	private ArrayList<Point2D> al;
	
	public Snake(GridPane gp) {
		this.gp = gp;
		al = new ArrayList<Point2D>();
		
		for (int i=0,j=0;j<3;j++)
			al.add(new Point2D(j, i));
		
		for (Point2D p : al) {
			gp.add(new Rectangle(50, 50, Color.BLACK), (int) p.getX(), (int) p.getY());
		}
	}
	
	
	
}
