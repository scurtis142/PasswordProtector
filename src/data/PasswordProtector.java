package data;

import UI.Controller;
import UI.View;
import javafx.application.Application;
import javafx.stage.Stage;

public class PasswordProtector extends Application{

	public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Model model = new Model();
        View view = new View(model);
        new Controller(model, view);

        stage.setScene(view.getScene());
        stage.setTitle("Event Allocator");
        stage.setHeight(700);
        stage.setWidth(900);
        stage.show();
        
    }

}
