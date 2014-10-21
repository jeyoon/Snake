import javafx.animation.AnimationTimer;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class WindowController extends AnchorPane {
	
	private GridPane gp;

	public WindowController(int width, int height) {
		super();
		
		gp = new GridPane();
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
		
		new Snake(gp);
		
		System.out.println(gp.getChildren().size());
		
		new AnimationTimer() {
			
			@Override
			public void handle(long now) {
			}
			
		}.start();
		
		getChildren().add(gp);
	}
}