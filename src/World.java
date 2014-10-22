import java.util.HashMap;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;


public class World extends GridPane {
	
	private HashMap<Point2D, Node> nodes;
	
	public World() {
		super();
		nodes = new HashMap<Point2D, Node>();
		setFocusTraversable(true);
	}	
	
	@Override
    public void add(Node child, int columnIndex, int rowIndex) {
		super.add(child, columnIndex, rowIndex);
		nodes.put(new Point2D(rowIndex, columnIndex), child);
    }
	
	public boolean isValid(Point2D pt) {
		if (getColumnConstraints().size() -1 < pt.getX() || getRowConstraints().size() -1 < pt.getY())
			return false;
		return true;
	}
	
	public boolean isOccupied(Point2D pt) {
		if (nodes.containsKey(pt) && nodes.get(pt) != null)
			return false;
		return true;
	}
	
	public boolean contains(Node node) {
		if (nodes.containsValue(node))
			return true;
		return false;
	}
}