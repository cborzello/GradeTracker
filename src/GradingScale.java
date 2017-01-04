import Exceptions.InvalidGradingScaleException;

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
    int round;
    public static int ROUND = 0, ROUNDUP = 1, ROUNDDOWN = 2;

    public GradingScale(boolean percentageBased, double[] bounds, int round) throws InvalidGradingScaleException {
        if(bounds.length != 8 && bounds.length != 24) {
            throw new InvalidGradingScaleException("Wrong number of bounds");
        }
        this.percentageBased = percentageBased;
        this.round = round;
        checkValidBounds(bounds);
        if(bounds.length == 8) {
            plusMinusScale = false;
            fUpperBound = bounds[0];
            dLowerBound = bounds[1];
            dUpperBound = bounds[2];
            cLowerBound = bounds[3];
            cUpperBound = bounds[4];
            bLowerBound = bounds[5];
            bUpperBound = bounds[6];
            aLowerBound = bounds[7];
        } else if(bounds.length == 24) {
            this.plusMinusScale = true;

            fUpperBound = bounds[0];
            dMinusLowerBound = bounds[1];
            dMinusUpperBound = bounds[2];
            dLowerBound = bounds[3];
            dUpperBound = bounds[4];
            dPlusLowerBound = bounds[5];
            dPlusUpperBound = bounds[6];
            cMinusLowerBound = bounds[7];
            cMinusUpperBound = bounds[8];
            cLowerBound = bounds[9];
            cUpperBound = bounds[10];
            cPlusLowerBound = bounds[11];
            cPlusUpperBound = bounds[12];
            bMinusLowerBound = bounds[13];
            bMinusUpperBound = bounds[14];
            bLowerBound = bounds[15];
            bUpperBound = bounds[16];
            bPlusLowerBound = bounds[17];
            bPlusUpperBound = bounds[18];
            aMinusLowerBound = bounds[19];
            aMinusUpperBound = bounds[20];
            aLowerBound = bounds[21];
            aUpperBound = bounds[22];
            aPlusLowerBound = bounds[23];
        }
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
        if(round == ROUND) {
            score = Math.round(score);
        } else if(round == ROUNDUP) {
            score = Math.ceil(score);
        } else if(round == ROUNDDOWN) {
            score = Math.floor(score);
        }
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

    public boolean isPercentageBased() {
        return percentageBased;
    }
}
