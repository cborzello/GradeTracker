import java.util.ArrayList;

/**
 * Created by Connor Borzello on 1/1/2017.
 * Description: Used to determine the grading scale of a class
 */
public class GradingScale {
    boolean percentageBased;
    boolean plusMinusScale;
    double fUpperBound;
    double dLowerBound, dUpperBound;
    double cLowerBound, cUpperBound;
    double bLowerBound, bUpperBound;
    double aLowerBound, aUpperBound;
    double dMinusLowerBound, dMinusUpperBound, dPlusLowerBound, dPlusUpperBound;
    double cMinusLowerBound, cMinusUpperBound, cPlusLowerBound, cPlusUpperBound;
    double bMinusLowerBound, bMinusUpperBound, bPlusLowerBound, bPlusUpperBound;
    double aMinusLowerBound, aMinusUpperBound, aPlusLowerBound;

    public GradingScale(boolean percentageBased,double fUpperBound, double dLowerBound, double dUpperBound,
                        double cLowerBound, double cUpperBound, double bLowerBound,
                        double bUpperBound, double aLowerBound) throws InvalidGradingScaleException{
        this.percentageBased = percentageBased;
        double[] bounds = {fUpperBound, dLowerBound, dUpperBound, cLowerBound, cUpperBound, bLowerBound, bUpperBound,
                aLowerBound};
        checkValidBounds(bounds);
        plusMinusScale = false;
        this.fUpperBound = fUpperBound;
        this.dLowerBound = dLowerBound;
        this.dUpperBound = dUpperBound;
        this.cLowerBound = cLowerBound;
        this.cUpperBound = cUpperBound;
        this.bLowerBound = bLowerBound;
        this.bUpperBound = bUpperBound;
        this.aLowerBound = aLowerBound;
    }
    public GradingScale(boolean percentageBased,double fUpperBound, double dLowerBound, double dUpperBound,
                        double cLowerBound, double cUpperBound, double bLowerBound,
                        double bUpperBound, double aLowerBound, double aUpperBound, double dMinusLowerBound,
                        double dMinusUpperBound, double dPlusLowerBound, double dPlusUpperBound, double cMinusLowerBound,
                        double cMinusUpperBound, double cPlusLowerBound, double cPlusUpperBound,double bMinusLowerBound,
                        double bMinusUpperBound, double bPlusLowerBound, double bPlusUpperBound,double aMinusLowerBound,
                        double aMinusUpperBound, double aPlusLowerBound) throws InvalidGradingScaleException{
        this.percentageBased = percentageBased;
        /*double[] bounds = {fUpperBound, dMinusLowerBound, dMinusUpperBound, dLowerBound, dUpperBound, dPlusLowerBound,
                dPlusUpperBound, cMinusLowerBound, cMinusUpperBound, cLowerBound, cUpperBound, cPlusLowerBound,
                cPlusUpperBound, bMinusLowerBound, bMinusUpperBound, bLowerBound, bUpperBound, bPlusLowerBound, bPlusUpperBound
                aLowerBound, aUpperBound};*/
        checkValidBounds(bounds);
        plusMinusScale = false;
        this.fUpperBound = fUpperBound;
        this.dLowerBound = dLowerBound;
        this.dUpperBound = dUpperBound;
        this.cLowerBound = cLowerBound;
        this.cUpperBound = cUpperBound;
        this.bLowerBound = bLowerBound;
        this.bUpperBound = bUpperBound;
        this.aLowerBound = aLowerBound;
    }
    public void checkValidBounds(double [] bounds) throws InvalidGradingScaleException{
        if(bounds[0] < 0) {
            throw new InvalidGradingScaleException("A Bound cannot be less than zero");
        }
        for(int i = 0; i < bounds.length-1; i++) {
            double bound = bounds[i];
            for(int j = i+1; j < bounds.length; j++) {
                if(bound >= bounds[j]) {
                    throw new InvalidGradingScaleException("Bounds Cannot Overlap");
                }
            }

        }
        for(int i = 0; i < bounds.length; i++) {
            if(percentageBased && bounds[i] > 100) {
                throw new InvalidGradingScaleException("Percentage can't be expected to be over 100%");
            }
        }
    }
    public String getGrade(double score) {
        if(score <= fUpperBound) {
            return "F";
        }else if(score >= dLowerBound && score <= dUpperBound) {
            return "D";
        }else if(score >= cLowerBound && score <= cUpperBound) {
            return "C";
        }else if(score >= bLowerBound && score <= bUpperBound) {
            return "B";
        }else if( (score >= aLowerBound && !plusMinusScale) || (score >= aLowerBound && score <= aUpperBound) ) {
            return "A";
        }else if(score >= dMinusLowerBound && score <= dMinusUpperBound) {
            return "D-";
        } else if(score >= dPlusLowerBound && score <= dPlusUpperBound) {
            return "D+";
        }else if(score >= cMinusLowerBound && score <= cMinusUpperBound) {
            return "C-";
        } else if(score >= cPlusLowerBound && score <= cPlusUpperBound) {
            return "C+";
        }else if(score >= bMinusLowerBound && score <= bMinusUpperBound) {
            return "B-";
        } else if(score >= bPlusLowerBound && score <= bPlusUpperBound) {
            return "B+";
        }else if(score >= aMinusLowerBound && score <= aMinusUpperBound) {
            return "A-";
        } else if(score >= aPlusLowerBound) {
            return "A+";
        } else {
            return null;
        }
    }
}
