import Exceptions.InvalidCourseworkException;
import Exceptions.InvalidGradingScaleException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Connor Borzello on 1/1/2017.
 * Description:
 */
public class GradeTrackerTester {

    @Test
    public void testOneCorrectGradeClass() throws InvalidGradingScaleException, InvalidCourseworkException{
        double[] bounds = {
                59, 60, 69, 70, 79, 80, 89, 90
        };
        GradingScale gradingScale = new GradingScale(false, bounds, GradingScale.ROUND);
        Class class1 = new Class("Calculus", "Professor Connor", gradingScale);
        Category category = new Category("Exam", 100, true);
        class1.addCategory(category);
        Coursework coursework = new Coursework("Final Exam", "Exam", 40, 50, false);
        class1.addCoursework(coursework);
        assertEquals("B", class1.getGrade());
    }

    @Test
    public void testTwoCorrectGradeClass() throws InvalidGradingScaleException, InvalidCourseworkException{
        double[] bounds = {
                59, 60, 69, 70, 79, 80, 89, 90
        };
        GradingScale gradingScale = new GradingScale(false, bounds, GradingScale.ROUND);
        Class class1 = new Class("Calculus", "Professor Connor", gradingScale);
        Category category = new Category("Exam", 90, true);
        Category category2 = new Category("Homework", 10, true);
        class1.addCategory(category);
        class1.addCategory(category2);
        Coursework coursework = new Coursework("Final Exam", "Exam", 50, 50, false);
        class1.addCoursework(coursework);
        Coursework coursework2 = new Coursework("HW1" , "Homework", 50, 20, true);
        class1.addCoursework(coursework2);
        assertEquals("A", class1.getGrade());
    }

    @Test
    public void testGetNameClass() throws InvalidGradingScaleException{
        double[] bounds = {
                59, 60, 69, 70, 79, 80, 89, 90
        };
        GradingScale gradingScale = new GradingScale(false, bounds, GradingScale.ROUND);
        Class class1 = new Class("Calculus", "Professor Connors", gradingScale);
        assertEquals("Calculus", class1.getName());
    }

    @Test
    public void testOneCorrectGradeGradingScale() throws InvalidGradingScaleException{
            double[] bounds = {
                    59, 60, 69, 70, 79, 80, 89, 90
            };
            GradingScale gradingScale = new GradingScale(false, bounds, GradingScale.ROUND);
        assertEquals("A", gradingScale.getGrade(99));
    }

    @Test
    public void testTwoCorrectGradeGradingScale() throws InvalidGradingScaleException{
        double[] bounds = {
                59, 60, 69, 70, 79, 80, 89, 90
        };
        GradingScale gradingScale = new GradingScale(false, bounds, GradingScale.ROUND);
        assertEquals("F", gradingScale.getGrade(59));
    }

    @Test
    public void testThreeCorrectGradeGradingScale() throws InvalidGradingScaleException{
        double[] bounds = {
                59, 60, 69, 70, 79, 80, 89, 90
        };
        GradingScale gradingScale = new GradingScale(false, bounds, GradingScale.ROUND);
        assertEquals("D", gradingScale.getGrade(65));
    }

    @Test
    public void testFourCorrectGradeGradingScale() throws InvalidGradingScaleException{
        double[] bounds = {
                59, 60, 62, 63, 67, 68, 69, 70, 72, 73, 77, 78, 79, 80, 82, 83, 87, 88, 89, 90, 92, 93, 97, 98
        };
        GradingScale gradingScale = new GradingScale(false, bounds, GradingScale.ROUND);
        assertEquals("A+", gradingScale.getGrade(200));
    }

    @Test
    public void testFiveCorrectGradeGradingScale() throws InvalidGradingScaleException{
        double[] bounds = {
                59, 60, 62, 63, 67, 68, 69, 70, 72, 73, 77, 78, 79, 80, 82, 83, 87, 88, 89, 90, 92, 93, 97, 98
        };
        GradingScale gradingScale = new GradingScale(false, bounds, GradingScale.ROUND);
        assertEquals("C-", gradingScale.getGrade(72));
    }

    @Test
    public void testNegativeBoundsGradingScale() {
        boolean thrown = false;

        try{
            double[] bounds = {
                    -5, 60, 69, 70, 79, 80, 89, 90
            };
            new GradingScale(false, bounds, GradingScale.ROUND);
        }catch (InvalidGradingScaleException e) {
            System.out.println(e.getMessage());
            thrown = true;
        }
        assert(thrown);
    }

    @Test
    public void testPercentageBoundsCantExceed100GradingScale() {
        boolean thrown = false;

        try{
            double[] bounds = {
                    59, 60, 62, 63, 67, 68, 69, 70, 72, 73, 77, 78, 79, 80, 82, 83, 87, 88, 89, 90, 92, 93, 97, 102
            };
            new GradingScale(false, bounds, GradingScale.ROUND);
        }catch (InvalidGradingScaleException e) {
            System.out.println(e.getMessage());
            thrown = true;
        }
        assert(thrown);
    }

    @Test
    public void testOneOverlappingBoundsGradingScale() {
        boolean thrown = false;

        try{
            double[] bounds = {
                    60, 60, 69, 70, 79, 80, 89, 90
            };
            new GradingScale(false, bounds, GradingScale.ROUND);
        }catch (InvalidGradingScaleException e) {
            thrown = true;
        }
        assert(thrown);
    }

    @Test
    public void testTwoOverlappingBoundsGradingScale() {
        boolean thrown = false;

        try{
            double[] bounds = {
                    59, 60, 84, 70, 79, 80, 89, 90
            };
            new GradingScale(false, bounds, GradingScale.ROUND);
        }catch (InvalidGradingScaleException e) {
            thrown = true;
        }
        assert(thrown);
    }

    @Test
    public void testRoundGradingScale() throws InvalidGradingScaleException {
        double[] bounds = {
                59, 60, 62, 63, 67, 68, 69, 70, 72, 73, 77, 78, 79, 80, 82, 83, 87, 88, 89, 90, 92, 93, 97, 98
        };
        GradingScale gradingScale = new GradingScale(false, bounds, GradingScale.ROUND);
        assertEquals("C-", gradingScale.getGrade(72.3));
    }

    @Test
    public void testRoundUpGradingScale() throws InvalidGradingScaleException {
        double[] bounds = {
                59, 60, 62, 63, 67, 68, 69, 70, 72, 73, 77, 78, 79, 80, 82, 83, 87, 88, 89, 90, 92, 93, 97, 98
        };
        GradingScale gradingScale = new GradingScale(false, bounds, GradingScale.ROUNDUP);
        assertEquals("C", gradingScale.getGrade(72.3));
    }

    @Test
    public void testRoundDownGradingScale() throws InvalidGradingScaleException {
        double[] bounds = {
                59, 60, 62, 63, 67, 68, 69, 70, 72, 73, 77, 78, 79, 80, 82, 83, 87, 88, 89, 90, 92, 93, 97, 98
        };
        GradingScale gradingScale = new GradingScale(false, bounds, GradingScale.ROUNDDOWN);
        assertEquals("C-", gradingScale.getGrade(72.99));
    }

    @Test
    public void testNameCoursework()throws Exception {
            Coursework coursework = new Coursework("Final Exam", "Final", 40, 50, true);
        assertEquals("Final Exam", coursework.getName());
    }

    @Test
    public void testCategoryCoursework()throws Exception {
        Coursework coursework = new Coursework("Final Exam", "Final", 40, 50, true);
        assertEquals("Final", coursework.getCategory());
    }

    @Test
    public void testCalculatePointsPossible()throws Exception {
        Coursework coursework = new Coursework("Final Exam", "Final", 40, 50, true);
        assertEquals(20, coursework.getPointsEarned());
    }

    @Test
    public void testCalculatePercentage()throws Exception {
        Coursework coursework = new Coursework("Final Exam", "Final", 40, 50, false);
        assertEquals(80, (int)coursework.getPercentage());
    }

    @Test
    public void testNegativeScoreCoursework() {
        boolean thrown = false;

        try{
            Coursework coursework = new Coursework("Final Exam", "Final", -10, 50, true);
        }catch (InvalidCourseworkException e) {
            thrown = true;
        }
        assert(thrown);
    }

    @Test
    public void testNegativePossiblePointCoursework() {
        boolean thrown = false;

        try{
            Coursework coursework = new Coursework("Final Exam", "Final", 50, -10, true);
        }catch (InvalidCourseworkException e) {
            thrown = true;
        }
        assert(thrown);
    }

    @Test
    public void testNullNameCourseWork() {
        boolean thrown = false;

        try{
            Coursework coursework = new Coursework(null, "Final", 50, 10, true);
        }catch (InvalidCourseworkException e) {
            thrown = true;
        }
        assert(thrown);
    }

    @Test
    public void testNullCategoryCourseWork() {
        boolean thrown = false;

        try{
            Coursework coursework = new Coursework("Chicken", null, 50, 10, true);
        }catch (InvalidCourseworkException e) {
            thrown = true;
        }
        assert(thrown);
    }
}
