package main.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BusinessLookupGUI extends Application {

	@Override
	public void start(Stage stage) throws Exception {
        StackPane root = new StackPane();
        Image img = new Image("file:res/small-business-icon.jpg");
        ImageView imgV = new ImageView(img);
        root.getChildren().add(imgV);    
        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Yelp Demo");
        stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
