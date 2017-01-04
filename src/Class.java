/**
 * Created by Connor Borzello on 1/1/2017.
 * Description: Class objects for each course
 */
import java.util.ArrayList;

public class Class {
    String name;
    String professor;
    GradingScale gradingScale;
    ArrayList<Coursework> courseworks;
    ArrayList<Category> categories;

    public Class(String name, GradingScale gradingScale) {
        this.name = name;
        this.gradingScale = gradingScale;
        courseworks = new ArrayList<Coursework>();
        categories = new ArrayList<Category>();
    }

    private String calculateGrade() {
        double totalScore = 0;

        for(int i = 0; i < categories.size(); i++) {
            Category category = categories.get(i);
            double categoryPointsEarned = 0;
            double categoryPointsPossible = 0;
            double categoryScore = 0;
            for(int j = 0; j < courseworks.size(); j++) {
                Coursework coursework = courseworks.get(j);
                if(coursework.getCategory().equals(category)) {
                    categoryPointsEarned += coursework.getPointsEarned();
                    categoryPointsPossible += coursework.getPointsPossible();
                }
            }
            categoryScore = category.getWeight() * (categoryPointsEarned / categoryPointsPossible);
            totalScore += categoryScore;
        }

        if(gradingScale.isPercentageBased()) {
            return gradingScale.getGrade(totalScore * .01);
        } else if(!gradingScale.isPercentageBased()) {
            return gradingScale.getGrade(totalScore);
        }


        return "";
    }
    public String getGrade() {
        return calculateGrade();
    }

    public void addCoursework(Coursework cw) {
        courseworks.add(cw);
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public ArrayList<Coursework> getcoursework() {
        return courseworks;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public GradingScale getGradingScale() {
        return gradingScale;
    }
}
