package UI;

import data.Model;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class View {

	public View(Model model) {
	}

	public Scene getScene() {
		VBox root = new VBox();
		return new Scene(root, 800, 220);
	}

}
