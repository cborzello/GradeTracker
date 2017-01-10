import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
            overview.setId("Overview");
            overview.setOnAction(eventHandler);
            rightTilePane.getChildren().add(overview);

            Button finalsCalc = new Button("Finals Calc");
            finalsCalc.setId("FinalsCalc");
            finalsCalc.setOnAction(eventHandler);
            rightTilePane.getChildren().add(finalsCalc);

            Button classView = new Button("View Class");
            classView.setId("ViewClass");
            classView.setOnAction(eventHandler);
            rightTilePane.getChildren().add(classView);

            Button newClass = new Button("New Class");
            newClass.setId("NewClass");
            newClass.setOnAction(eventHandler);
            rightTilePane.getChildren().add(newClass);

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

    public static Scene BuildNewClassScene(EventHandler eventHandler) {
        Scene newClassScene;
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.TOP_LEFT);
        gridPane.setVgap(20);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(insetSize, insetSize, insetSize, insetSize));
        Font entryFont = Font.font("Arial", 20);
        Font boldEntryFont = Font.font("Arial", FontWeight.BOLD, 25);

        Text classText = new Text("Class Name:  ");
        classText.setFont(boldEntryFont);
        TextField classField = new TextField();
        classField.setPromptText("Class Name");
        classField.setFont(entryFont);
        gridPane.add(classText, 0, 0);
        gridPane.add(classField, 1, 0);

        Text professorText = new Text("Professor:     ");
        professorText.setFont(boldEntryFont);
        TextField professorField = new TextField();
        professorField.setPromptText("Professor Name");
        professorField.setFont(entryFont);
        gridPane.add(professorText,0, 1);
        gridPane.add(professorField, 1, 1);

        Text f = new Text("F");
        Text dMinus = new Text("D-");
        Text d = new Text("D");
        Text dPlus = new Text("D+");
        Text cMinus = new Text("C-");
        Text c = new Text("C");
        Text cPlus = new Text("C+");
        Text bMinus = new Text("B-");
        Text b = new Text("B");
        Text bPlus = new Text("B+");
        Text aMinus = new Text("A-");
        Text a = new Text("A");
        Text aPlus = new Text("A+");
        f.setFont(boldEntryFont);
        dMinus.setFont(boldEntryFont);
        d.setFont(boldEntryFont);
        dPlus.setFont(boldEntryFont);
        cMinus.setFont(boldEntryFont);
        c.setFont(boldEntryFont);
        cPlus.setFont(boldEntryFont);
        bMinus.setFont(boldEntryFont);
        b.setFont(boldEntryFont);
        bPlus.setFont(boldEntryFont);
        aMinus.setFont(boldEntryFont);
        a.setFont(boldEntryFont);
        aPlus.setFont(boldEntryFont);
        gridPane.add(f, 0, 2);
        gridPane.add(dMinus, 0, 3);
        gridPane.add(d, 0, 4);
        gridPane.add(dPlus, 0, 5);
        gridPane.add(cMinus, 0, 6);
        gridPane.add(c, 0, 7);
        gridPane.add(cPlus, 0, 8);
        gridPane.add(bMinus, 0, 9);
        gridPane.add(b, 0, 10);
        gridPane.add(bPlus, 0, 11);
        gridPane.add(aMinus, 0, 12);
        gridPane.add(a, 0, 13);
        gridPane.add(aPlus, 0, 14);

        TextField fLowerBoundField = new TextField("NONE");
        fLowerBoundField.setEditable(false);
        fLowerBoundField.setMaxWidth(200);
        gridPane.add(fLowerBoundField, 1,2);
        TextField fUpperBoundField = new TextField();
        fUpperBoundField.setMaxWidth(200);
        gridPane.add(fUpperBoundField, 2,2);
        TextField dMinusLowerBoundField = new TextField();
        dMinusLowerBoundField.setMaxWidth(200);
        gridPane.add(dMinusLowerBoundField, 1, 3);
        TextField dMinusUpperBoundField = new TextField();
        dMinusUpperBoundField.setMaxWidth(200);
        gridPane.add(dMinusUpperBoundField, 2, 3);
        TextField dLowerBoundField = new TextField();
        dLowerBoundField.setMaxWidth(200);
        gridPane.add(dLowerBoundField, 1, 4);
        TextField dUpperBoundField = new TextField();
        dUpperBoundField.setMaxWidth(200);
        gridPane.add(dUpperBoundField, 2, 4);
        TextField dPlusLowerBoundField = new TextField();
        dPlusLowerBoundField.setMaxWidth(200);
        gridPane.add(dPlusLowerBoundField, 1, 5);
        TextField dPlusUpperBoundField = new TextField();
        dPlusUpperBoundField.setMaxWidth(200);
        gridPane.add(dPlusUpperBoundField, 2, 5);
        TextField cMinusLowerBoundField = new TextField();
        cMinusLowerBoundField.setMaxWidth(200);
        gridPane.add(cMinusLowerBoundField, 1, 6);
        TextField cMinusUpperBoundField = new TextField();
        cMinusUpperBoundField.setMaxWidth(200);
        gridPane.add(cMinusUpperBoundField, 2, 6);
        TextField cLowerBoundField = new TextField();
        cLowerBoundField.setMaxWidth(200);
        gridPane.add(cLowerBoundField, 1, 7);
        TextField cUpperBoundField = new TextField();
        cUpperBoundField.setMaxWidth(200);
        gridPane.add(cUpperBoundField, 2, 7);
        TextField cPlusLowerBoundField = new TextField();
        cPlusLowerBoundField.setMaxWidth(200);
        gridPane.add(cPlusLowerBoundField, 1, 8);
        TextField cPlusUpperBoundField = new TextField();
        cPlusUpperBoundField.setMaxWidth(200);
        gridPane.add(cPlusUpperBoundField, 2, 8);
        TextField bMinusLowerBoundField = new TextField();
        bMinusLowerBoundField.setMaxWidth(200);
        gridPane.add(bMinusLowerBoundField, 1, 9);
        TextField bMinusUpperBoundField = new TextField();
        bMinusUpperBoundField.setMaxWidth(200);
        gridPane.add(bMinusUpperBoundField, 2, 9);
        TextField bLowerBoundField = new TextField();
        bLowerBoundField.setMaxWidth(200);
        gridPane.add(bLowerBoundField, 1, 10);
        TextField bUpperBoundField = new TextField();
        bUpperBoundField.setMaxWidth(200);
        gridPane.add(bUpperBoundField, 2, 10);
        TextField bPlusLowerBoundField = new TextField();
        bPlusLowerBoundField.setMaxWidth(200);
        gridPane.add(bPlusLowerBoundField, 1, 11);
        TextField bPlusUpperBoundField = new TextField();
        bPlusUpperBoundField.setMaxWidth(200);
        gridPane.add(bPlusUpperBoundField, 2, 11);
        TextField aMinusLowerBoundField = new TextField();
        aMinusLowerBoundField.setMaxWidth(200);
        gridPane.add(aMinusLowerBoundField, 1, 12);
        TextField aMinusUpperBoundField = new TextField();
        aMinusUpperBoundField.setMaxWidth(200);
        gridPane.add(aMinusUpperBoundField, 2, 12);
        TextField aLowerBoundField = new TextField();
        aLowerBoundField.setMaxWidth(200);
        gridPane.add(aLowerBoundField, 1, 13);
        TextField aUpperBoundField = new TextField();
        aUpperBoundField.setMaxWidth(200);
        gridPane.add(aUpperBoundField, 2, 13);
        TextField aPlusLowerBoundField = new TextField();
        aPlusLowerBoundField.setMaxWidth(200);
        gridPane.add(aPlusLowerBoundField, 1, 14);
        TextField aPlusUpperBoundField = new TextField("NONE");
        aPlusUpperBoundField.setEditable(false);
        aPlusUpperBoundField.setMaxWidth(200);
        gridPane.add(aPlusUpperBoundField, 2, 14);
        fUpperBoundField.setId("fUpperBoundField");
        dMinusLowerBoundField.setId("dMinusLowerBoundField");
        dMinusUpperBoundField.setId("dMinusUpperBoundField");
        dLowerBoundField.setId("dLowerBoundField");
        dUpperBoundField.setId("dUpperBoundField");
        dPlusLowerBoundField.setId("dPlusLowerBoundField");
        dPlusUpperBoundField.setId("dPlusUpperBoundField");
        cMinusLowerBoundField.setId("cMinusLowerBoundField");
        cMinusUpperBoundField.setId("cMinusUpperBoundField");
        cLowerBoundField.setId("cLowerBoundField");
        cUpperBoundField.setId("cUpperBoundField");
        cPlusLowerBoundField.setId("cPlusLowerBoundField");
        cPlusUpperBoundField.setId("cPlusUpperBoundField");
        bMinusLowerBoundField.setId("bMinusLowerBoundField");
        bMinusUpperBoundField.setId("bMinusUpperBoundField");
        bLowerBoundField.setId("bLowerBoundField");
        bUpperBoundField.setId("bUpperBoundField");
        bPlusLowerBoundField.setId("bPlusLowerBoundField");
        bPlusUpperBoundField.setId("bPlusUpperBoundField");
        aMinusLowerBoundField.setId("aMinusLowerBoundField");
        aMinusUpperBoundField.setId("aMinusUpperBoundField");
        aLowerBoundField.setId("aLowerBoundField");
        aUpperBoundField.setId("aUpperBoundField");
        aPlusLowerBoundField.setId("aPlusLowerBoundField");


        Text instructionOne = new Text("If no plus/minus scale,\nleave those boxes blank");
        instructionOne.setFont(boldEntryFont);
        gridPane.add(instructionOne,2,0, 3,2);
        TextArea lowBoundInstruction = new TextArea("Low Bound");
        TextArea highBoundInstruction = new TextArea("High Bound");
        lowBoundInstruction.setMaxWidth(200);
        highBoundInstruction.setMaxWidth(200);
        lowBoundInstruction.setMaxHeight(40);
        highBoundInstruction.setMaxHeight(40);
        lowBoundInstruction.setEditable(false);
        highBoundInstruction.setEditable(false);
        gridPane.add(lowBoundInstruction,1,15);
        gridPane.add(highBoundInstruction, 2, 15);

        Button back = new Button("Back");
        back.setOnAction(eventHandler);
        gridPane.add(back, 3,11,4,2);
        back.setId("Back");
        Button create = new Button("Create");
        create.setOnAction(eventHandler);
        gridPane.add(create, 3, 14, 4, 2);
        create.setId("Create");




        newClassScene = new Scene(gridPane, defaultWidth, defaultHeight);
        newClassScene.getStylesheets().add
                (GradeTracker.class.getResource("Theme.css").toExternalForm());
        return newClassScene;
    }
}
