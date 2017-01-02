/**
 * Created by Connor Borzello on 1/1/2017.
 * Description: Class objects for each course
 */
import java.util.ArrayList;

public class Class {
    String name;
    String professor;
    ArrayList<CourseWork> courseWork;
    ArrayList<Category> categories;
    boolean plusMinusScale;
    boolean passFail;

    public Class(String name) {
        this.name = name;
        courseWork = new ArrayList<CourseWork>();
        categories = new ArrayList<Category>();
    }

    public void addCourseWork(CourseWork cw) {
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

    public ArrayList<CourseWork> getCourseWork() {
        return courseWork;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public boolean isPlusMinusScale() {
        return plusMinusScale;
    }

    public void setPlusMinusScale(boolean plusMinusScale) {
        this.plusMinusScale = plusMinusScale;
    }

    public boolean isPassFail() {
        return passFail;
    }

    public void setPassFail(boolean passFail) {
        this.passFail = passFail;
    }
}
