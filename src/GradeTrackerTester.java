import Exceptions.InvalidCourseworkException;
import org.junit.jupiter.api.Test;

/**
 * Created by Connor Borzello on 1/1/2017.
 * Description:
 */
public class GradeTrackerTester {
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
