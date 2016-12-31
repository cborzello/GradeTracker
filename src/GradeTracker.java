import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
        BorderPane borderPane = new BorderPane();

        int insetSize = 10;
        borderPane.setPadding(new Insets(insetSize, insetSize, insetSize, insetSize));  //This is the size of the space that

        Text sceneTitle = new Text("Welcome");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 50));
        HBox titleBox = new HBox(10);
        titleBox.setAlignment(Pos.BOTTOM_CENTER);
        titleBox.getChildren().add(sceneTitle);
        borderPane.setTop(titleBox);




        ImageView imageView = new ImageView();
        imageView.setImage(new Image("Purdue Logo.png"));
        imageView.setFitWidth(500);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
        VBox imageBox = new VBox(10);
        imageBox.setPadding(new Insets(100, 0, 0, 00));
        imageBox.setAlignment(Pos.BASELINE_CENTER);
        imageBox.getChildren().add(imageView);
        borderPane.setCenter(imageBox);
        borderPane.setAlignment(imageView,Pos.BOTTOM_CENTER);

        Button btn = new Button("Begin");
        btn.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
               //Go to next screen
            }
        });
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.TOP_CENTER);
        hbBtn.getChildren().add(btn);
        borderPane.setBottom(hbBtn);


        Scene scene = new Scene(borderPane, 500, 700);
        primaryStage.setScene(scene);

        scene.getStylesheets().add
                (GradeTracker.class.getResource("Theme.css").toExternalForm());

        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
