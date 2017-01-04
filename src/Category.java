/**
 * Created by Connor Borzello on 1/1/2017.
 * Description:
 */
public class Category {
    String name;
    //Percentage for 80 percent would be 80.0 (NOT .80)
    double weight;
    boolean percentage;

    public Category(String name, double weight, boolean percentage) {
        this.name = name;
        this.weight = weight;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }
    public double getWeight() { return weight; }

    public boolean isPercentage() {
        return percentage;
    }
}
