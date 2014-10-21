import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class Main extends Application implements Runnable {

    @Override
    public void start(final Stage stage) throws Exception {
        WindowController controller = new WindowController(400, 400);
        
		Platform.setImplicitExit(false);
		
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				System.exit(0);
			}
        	
        });
		
        stage.setScene(new Scene(controller, 400, 400));
        stage.setTitle("Snake");        
		stage.setResizable(false);
        
        stage.show();
    }
    
	@Override
	public void run() {
		launch( (String[]) null);
	}
	
	public static void main(String[] args) {
		launch( (String[]) null);
	}
	
}