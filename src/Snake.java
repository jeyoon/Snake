import java.util.ArrayList;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Snake {
	
	private World gp;
	private ArrayList<Point2D> al;
	
	private String direction;
	
	public Snake(World gp) {
		this.gp = gp;
		al = new ArrayList<Point2D>();
		
		direction = "EAST";
		
		for (int j=0;j<3;j++)
			al.add(new Point2D(j, 0));
		
		for (Point2D p : al) {
			p("x " + p.getX() + " y " + p.getY());
			Rectangle r = new Rectangle(48, 48, Color.PLUM);
			gp.add(r, (int) p.getX(), (int) p.getY());
		}
				
		drawSnake();
	}
	
	public void next() {
		int dx = 0, dy = 0;
		
		switch (direction) {
		case "NORTH":
			break;
		case "WEST":
			break;
		case "SOUTH":
			break;
		case "EAST":
			for (int i=al.size();i>0;i--) {
				Point2D loc = al.get(i-1);
				loc = new Point2D(loc.getX() +1, loc.getY());
				if (gp.isValid(loc)) {
					al.set(i-1, loc);
				} else {
					break;
				}
			}
			
			drawSnake();
			break;
		}
	}
	
	private void drawSnake() {
		
		Platform.runLater(new Runnable() {
			
            @Override
            public void run() {
            	ArrayList<Node> al2 = new ArrayList<Node>();
            	for (Node node : gp.getChildren())
            		al2.add(node);
            	
    			p("a" + al2.size());
    			
    			for (int i=0;i<al2.size();i++) {
    				p(i + " " + al2.get(i).getClass());
    				if (al2.get(i) instanceof Rectangle)
    					p(gp.getChildren().remove(al2.get(i)));
    			}
    			
    			p("ol size" + al2.size());
    			p("gp children size" + gp.getChildren().size());
            	
				for (Point2D p : al) {
					Rectangle r = new Rectangle(48, 48, Color.PLUM);
					gp.add(r, (int) p.getX(), (int) p.getY());
				}
				p("init gp children size " + gp.getChildren().size());
		    }
		});
	}
	
	private void p(Object str) {
		System.out.println("DEBUG: " + str);
	}
}