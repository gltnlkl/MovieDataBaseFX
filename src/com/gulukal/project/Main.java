package com.gulukal.project;

import java.util.ArrayList;

import com.gulukal.project.control.MovieEntityController;
import com.gulukal.project.entity.MovieEntity;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {


	

	public static void main(String[] args) {
		
		
		MovieEntityController movieController = new MovieEntityController();
		
		ArrayList<MovieEntity> movieEntities = movieController.list();
		for (MovieEntity movieEntity : movieEntities) {
		System.out.println(movieEntity);
		
		}
	
		launch(args);
	}

	@Override

	// javafx bilgileri burada bulunuyor
	public void start(Stage primaryStage) throws Exception {
		try {
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("MovieDB.fxml"));
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
