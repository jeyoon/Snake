import javafx.animation.AnimationTimer;
import javafx.geometry.HPos;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class WindowController extends StackPane {
	
	private World gp;
	private static Snake snake;

	public WindowController(int width, int height) {
		super();
		
		gp = new World();
		gp.setGridLinesVisible(true);
		
		if (width == height)
			for (int i=0;i<width/50;i++) {
				RowConstraints rc = new RowConstraints(50);
				ColumnConstraints cc = new ColumnConstraints(50);
				
				rc.setValignment(VPos.CENTER);
				cc.setHalignment(HPos.CENTER);
				
				gp.getRowConstraints().add(rc);
				gp.getColumnConstraints().add(cc);
			}
		
		for (int i=0;i<gp.getRowConstraints().size();i++) {
			for (int j=0;j<gp.getColumnConstraints().size();j++) {
				//gp.add(new Button(), j, i);
			}
		}
		
		snake = new Snake(gp);
		
		System.out.println("abcd " + gp.getChildren().size());
		
		Text ta = new Text("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		
		setAlignment(ta, Pos.CENTER);
		
		getChildren().add(ta);
		getChildren().add(gp);
		
		new AnimationTimer() {
			
			private int timeElapsed = 0;
			
			@Override
			public void handle(long now) {
				
				boolean hasApple = false;
				
				for (Node node : gp.getChildren())
					if (node instanceof Apple)
						hasApple = true;
				
				if (!hasApple) {
					int x, y;
					do {
						
					x = (int) (Math.random() * 8);
					y = (int) (Math.random() * 8);
					
					} while (!gp.isOccupied(new Point2D(x, y)));
					
					Apple apple = new Apple();
					
					apple.setOnMouseEntered(event -> {
						gp.getChildren().remove(apple);
					});
					
					gp.add(apple, x, y);
				}
				
				if (((int) (now / 1e9)) > timeElapsed + 1) {
					snake.next();
					timeElapsed = (int) (now / 1e9);
				}
			}
			
		}.start();
	}
}