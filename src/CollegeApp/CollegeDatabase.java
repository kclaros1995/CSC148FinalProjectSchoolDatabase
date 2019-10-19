package CollegeApp;

import Model.College;
import View.RootPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CollegeDatabase extends Application {
	private Stage primaryStage;
	private Pane rootPane;


	@Override
	public void start(Stage primaryStage) {
		try { 
			College college = new College(100, 100, 100, 100, 100);
			buildRootPane();
			this.primaryStage = primaryStage;
			Scene scene = new Scene(rootPane, 1000, 500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Suffolk County Community College Registrar");
			primaryStage.show();
		} catch (Exception e) { 
			e.printStackTrace(); 
		}


	}
	

	public void buildRootPane() {
		this.rootPane = new RootPane().getRootPane();
	}

	public static void main(String[] args) {
		launch(args);
	}
}