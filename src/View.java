/**
 * Created by Connor Borzello on 12/21/2016.
 * Description: The GUI for the application
 */
import javax.swing.*;
import java.awt.*;

public class View {
    JFrame frame;
    CardLayout cardLayout;
    JPanel mainPanel;
    //Color scheme from lightest to darkest
    Color themeOne = new Color(88, 185, 88), themeTwo = new Color(50, 155, 50),
            themeThree = new Color(26,130,26), themeFour = new Color(6, 101, 6),
            themeFive = new Color(0,67,0);

    public View() {
        frame = new JFrame("Grade Tracker");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int frameWidth = screenSize.width/3;
        int frameHeight = (int) (screenSize.height * .75);
        frame.setLocation(screenSize.width/2 - frameWidth/2,(screenSize.height-frameHeight) /2);
        frame.setSize(frameWidth, frameHeight);  //Height Actually 765?
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBackground(themeThree);
        frame.add(mainPanel);
        frame.setResizable(false);
        frame.setVisible(true);
    }

}
