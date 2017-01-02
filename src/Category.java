/**
 * Created by Connor Borzello on 1/1/2017.
 * Description:
 */
public class Category {
    String name;
    //Percentage for 80 percent would be 80.0 (NOT .80)
    double percentage;

    public Category(String name, double percentage) {
        this.name = name;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public double getPercentage() {
        return percentage;
    }
}
