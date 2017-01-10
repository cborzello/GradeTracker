import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.util.ArrayList;


/**
 * Created by Connor Borzello on 12/26/2016.
 * Description: First Application with Javafx
 */
public class GradeTracker extends Application implements EventHandler {
    Stage primaryStage;
    ArrayList<TextField> textFields;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Grade Tracker");

        Scene titleScene = SceneBuilder.BuildTitleScene(this);

        primaryStage.setScene(titleScene);
        primaryStage.show();
    }

    @Override
    public void handle(Event event) {
        if(event.getSource() instanceof Button) {
            Button button = (Button) event.getSource();
            String buttonId = button.getId();

            if(buttonId.equals("Start")) {
                Scene menu = SceneBuilder.BuildMenuScene(this);
                primaryStage.setScene(menu);
            }else if(buttonId.equals("NewClass")) {
                Scene newClass = SceneBuilder.BuildNewClassScene(this);
                getTextFields(newClass);
                primaryStage.setScene(newClass);
            }else if(buttonId.equals("Create")) {
                //Create Class
            }else if (buttonId.equals("Back")){
                Scene menu = SceneBuilder.BuildMenuScene(this);
                primaryStage.setScene(menu);
            }
        }
    }

    public void getTextFields(Scene newClass) {
        textFields = new ArrayList<TextField>();
        GridPane gridPane = (GridPane) newClass.getRoot();
        ObservableList<Node> nodes = gridPane.getChildren();
        for(int i = 0; i < nodes.size(); i++) {
            if(nodes.get(i) instanceof TextField) {
                textFields.add(((TextField) nodes.get(i)));
            }
        }

    }
}
