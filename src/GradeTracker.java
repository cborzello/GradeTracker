import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;



/**
 * Created by Connor Borzello on 12/26/2016.
 * Description: First Application with Javafx
 */
public class GradeTracker extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Grade Tracker");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);

        grid.setHgap(10);
        grid.setVgap(10);

        int insetSize = 10;
        grid.setPadding(new Insets(insetSize, insetSize, insetSize, insetSize));  //This is the size of the space that

        Text sceneTitle = new Text("Welcome");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 40));

        grid.add(sceneTitle, 1, 3, 3, 1);

        Button btn = new Button("Begin");
        btn.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 50, 3, 3);
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
               //Go to next screen
            }
        });


        Scene scene = new Scene(grid, 500, 700);
        primaryStage.setScene(scene);

        scene.getStylesheets().add
                (GradeTracker.class.getResource("Theme.css").toExternalForm());

        primaryStage.show();
    }
}
