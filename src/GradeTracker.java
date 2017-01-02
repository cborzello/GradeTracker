import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;


/**
 * Created by Connor Borzello on 12/26/2016.
 * Description: First Application with Javafx
 */
public class GradeTracker extends Application implements EventHandler {
    Stage primaryStage;

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
            }
        }
    }
}
