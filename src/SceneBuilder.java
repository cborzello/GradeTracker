import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Created by Connor Borzello on 12/31/2016.
 * Description: This creates a Scene object of the title screen for the app
 */
public class SceneBuilder{
    static int defaultWidth = 900, defaultHeight = 900, insetSize = 5;
    public static Scene BuildTitleScene(EventHandler eventHandler) {
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(insetSize, insetSize, insetSize, insetSize));  //This is the size of the space that

        Text sceneTitle = new Text("Welcome");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 50));
        HBox titleBox = new HBox(10);
        titleBox.setAlignment(Pos.BOTTOM_CENTER);
        titleBox.getChildren().add(sceneTitle);
        borderPane.setTop(titleBox);

        ImageView imageView = new ImageView();
        imageView.setImage(new Image("Pics/Purdue Logo.png"));
        imageView.setFitWidth(defaultWidth);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
        VBox imageBox = new VBox(10);
        imageBox.setPadding(new Insets(100, 0, 0, 00));
        imageBox.setAlignment(Pos.BASELINE_CENTER);
        imageBox.getChildren().add(imageView);
        borderPane.setCenter(imageBox);
        borderPane.setAlignment(imageView,Pos.BOTTOM_CENTER);

        Button startButton = new Button("Begin");
        startButton.setOnAction(eventHandler);
        startButton.setId("Start");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.TOP_CENTER);
        hbBtn.getChildren().add(startButton);
        borderPane.setBottom(hbBtn);

        Scene titleScene = new Scene(borderPane, defaultWidth, defaultHeight);
        titleScene.getStylesheets().add
                (GradeTracker.class.getResource("Theme.css").toExternalForm());
        return titleScene;
    }

    public static Scene BuildMenuScene(EventHandler eventHandler) {
        Scene menuScene;
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(insetSize, insetSize, insetSize, insetSize));  //This is the size of the space that

            FlowPane leftFlowPane = new FlowPane();
            leftFlowPane.getStyleClass().add("altBackground");
            Text classesHeader = new Text("Classes");
            classesHeader.setFont(Font.font("Tahoma", FontWeight.BOLD, 50));
            classesHeader.setId("silver");
            leftFlowPane.getChildren().add(classesHeader);

        borderPane.setCenter(leftFlowPane);

            TilePane rightTilePane = new TilePane(Orientation.VERTICAL);
            rightTilePane.setPrefRows(10);
            rightTilePane.setTileAlignment(Pos.BASELINE_CENTER);
            rightTilePane.setVgap(40);
            rightTilePane.setMaxWidth(defaultWidth/3);
            rightTilePane.setPadding(new Insets(30, 0, 0, 10));


            Button overview = new Button("Overview");
            rightTilePane.getChildren().add(overview);

            Button finalsCalc = new Button("Finals Calc");
            rightTilePane.getChildren().add(finalsCalc);

            Button classView = new Button("Class View");
            rightTilePane.getChildren().add(classView);

            Button editClass = new Button("Edit Class");
            rightTilePane.getChildren().add(editClass);

            Text semesterGPA = new Text("Semester GPA");
            semesterGPA.setFont(Font.font("Arial", FontWeight.BOLD,40));
            semesterGPA.setId("Black");
            rightTilePane.getChildren().add(semesterGPA);



        borderPane.setRight(rightTilePane);

        menuScene = new Scene(borderPane, defaultWidth, defaultHeight);
        menuScene.getStylesheets().add
                (GradeTracker.class.getResource("Theme.css").toExternalForm());
        return menuScene;
    }
}
