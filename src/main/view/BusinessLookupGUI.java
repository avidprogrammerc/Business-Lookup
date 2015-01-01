package main.view;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import main.data_structures.LinkedList;
import main.model.Business;
import main.yelp_api.YelpAPI;

import com.beust.jcommander.Parameter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class BusinessLookupGUI extends Application {
	public static class YelpAPICLI {
		@Parameter(names = { "-q", "--term" }, description = "Search Query Term")
		public String term = YelpAPI.DEFAULT_TERM;

		@Parameter(names = { "-l", "--location" }, description = "Location to be Queried")
		public String location = YelpAPI.DEFAULT_LOCATION;
		
		@Parameter(names = { "-n", "--limit" }, description = "Number of Businesses to be Queried")
		public int number = YelpAPI.DEFAULT_LIMIT;
	}

	@Override
	public void start(Stage stage) throws Exception {
		LinkedList<Business> list = new LinkedList<Business>();
		// Call to yelp
		YelpAPICLI yelpApiCli = new YelpAPICLI();
		//new JCommander(yelpApiCli, args);

		YelpAPI yelpApi = new YelpAPI(main.yelp_api.YelpAPI.CONSUMER_KEY,
				main.yelp_api.YelpAPI.CONSUMER_SECRET,
				main.yelp_api.YelpAPI.TOKEN, main.yelp_api.YelpAPI.TOKEN_SECRET);
		JSONArray businesses = YelpAPI.queryAPI(yelpApi, yelpApiCli);

		for (int i = 0; i < businesses.size(); i++) {
			JSONObject business = (JSONObject) businesses.get(i);
			Business bus = new Business(business.toString());
			list.insertAtEnd(bus);
//			String id = business.get("id").toString();
//			
//			Business bus = new Business(yelpApi.searchByBusinessId(id));
//			System.out.println("========== Business #" + (i+1) + " ==========");
//			System.out.println(bus);
		}
		
		
        GridPane gridPane = new GridPane();
        //gridPane.setPadding(new Insets(50, 50, 50, 50));
        gridPane.setHgap(5);
        gridPane.setVgap(10);
        
        Scene scene = new Scene(gridPane);
        
        Image img = new Image(list.getCurrentElement().getImageURL());
        ImageView imgV = new ImageView(img);
        gridPane.add(imgV, 0, 0);    
        GridPane.setHalignment(imgV, HPos.CENTER);
        GridPane.setHgrow(imgV, Priority.ALWAYS);
        
        Label name = new Label(list.getCurrentElement().getName());
        gridPane.add(name, 0, 1);
        GridPane.setHalignment(name, HPos.CENTER);
        GridPane.setHgrow(name, Priority.ALWAYS);
        
        GridPane buttons = new GridPane();
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        buttons.getColumnConstraints().add(col1);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);
        buttons.getColumnConstraints().add(col2);
        Button next = new Button("Next ->");
        next.setMaxWidth(Double.MAX_VALUE);
        next.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				list.next();
				Image temp = null;
				String imgUrl = list.getCurrentElement().getImageURL();
				if (imgUrl != null) {
					temp = new Image(imgUrl);
				} else {
					temp = new Image("file:res/small-business-icon.jpg");
				}
				imgV.setImage(temp);
				name.setText(list.getCurrentElement().getName());
			}
        });
        Button prev = new Button("<- Previous");
        prev.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				list.previous();
				Image temp = null;
				String imgUrl = list.getCurrentElement().getImageURL();
				if (imgUrl != null) {
					temp = new Image(imgUrl);
				} else {
					temp = new Image("file:res/small-business-icon.jpg");
				}
				imgV.setImage(temp);
				name.setText(list.getCurrentElement().getName());
			}
        });
        prev.setMaxWidth(Double.MAX_VALUE);
        
        buttons.add(prev, 0, 0);
        buttons.add(next, 1, 0);
        
        gridPane.add(buttons, 0, 2);
        
        stage.setScene(scene);
        stage.setTitle("Yelp Demo");
        stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
