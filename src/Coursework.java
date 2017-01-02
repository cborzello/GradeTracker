/**
 * Created by Connor Borzello on 1/1/2017.
 * Description:
 */
public class Coursework {
    String name;
    String category;
    //Percentage for 80 percent would be 80.0 (NOT .80)
    double percentage;
    double pointsEarned;
    double pointsPossible;
    boolean extraCredit;

    public Coursework(String name, String category, double score, double pointsPossible, boolean isPercentage)
            throws InvalidCourseworkException{
        if(name == null || category == null) {
            throw new InvalidCourseworkException("Invalid Coursework");
        }else if(pointsPossible < 0) {
            throw new InvalidCourseworkException("Points Possible Cannot be negative");
        } else if (score < 0) {
            throw new InvalidCourseworkException("Score Cannot be negative");
        }
        this.name = name;
        this.category = category;
        if(!isPercentage) {
            this.pointsEarned = score;
            this.pointsPossible = pointsPossible;
            this.percentage = calculatePercentage();
        } else {
            this.percentage = score;
            this.pointsPossible = pointsPossible;
            this.pointsEarned = calculateScore();
        }
        if(pointsPossible == 0) {
            extraCredit = true;

        }
    }
    private double calculatePercentage(){
        return pointsEarned / pointsPossible;
    }
    private double calculateScore() {
        return .01 * percentage * pointsPossible;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPercentage() {
        return percentage;
    }

    public double getPointsEarned() {
        return pointsEarned;
    }

    public double getPointsPossible() {
        return pointsPossible;
    }
    public boolean isExtraCredit() {
        return extraCredit;
    }
}
