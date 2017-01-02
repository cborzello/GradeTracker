/**
 * Created by Connor Borzello on 1/1/2017.
 * Description: Class objects for each course
 */
import java.util.ArrayList;

public class Class {
    String name;
    String professor;
    GradingScale gradingScale;
    ArrayList<Coursework> courseWork;
    ArrayList<Category> categories;

    public Class(String name, GradingScale gradingScale) {
        this.name = name;
        this.gradingScale = gradingScale;
        courseWork = new ArrayList<Coursework>();
        categories = new ArrayList<Category>();
    }

    public void addCourseWork(Coursework cw) {
        courseWork.add(cw);
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

    public ArrayList<Coursework> getCourseWork() {
        return courseWork;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public GradingScale getGradingScale() {
        return gradingScale;
    }
}
