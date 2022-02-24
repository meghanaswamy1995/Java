/**
 Duration represents some amount of time in hours and minutes.
*/
public class Duration {
    // Problem restriction:
    // do not change the private instance variable definitions
    private int totMinutes; // representation invariant: totMinutes >= 0
    private int hrs;
    private int mins;
    /**
    Creates duration of the given hours and minutes
    PRE: hours >=0 and minutes >= 0
    */
    public Duration (int hours, int minutes) {
        hrs=hours;
        mins=minutes;

    }
    /**
    Creates a duration given as a total number of minutes.
    PRE: totalMinutes >= 0
    */
    public Duration (int totalMinutes) {
        hrs=totalMinutes/60;
        mins=totalMinutes%60;
    }

        /**
     Increase the current duration by the amount of time
    given by hours and minutes.
    PRE: hours >=0 and minutes >= 0
    */
    public void increase(int hours, int minutes) {
        hrs+=hours;
        mins+=minutes;
        if(mins>=60){
            int newHr = mins/60;
            int newmin = mins%60;
            if(newmin == 0){ mins = 0;}
            hrs+=newHr;
            mins+=newmin;
        }
    }
    /**
    Returns the sum of this duration and duration "b"
    This duration is unchanged by add.
    Note the return type is a Duration object.
    HINT: Java rules allow this method to access private data of other
    Duration objects besides "this": for example, b's private data.
    */
    public Duration add(Duration b) {
        int bhr = b.hrs;
        int bmin = b.mins;
        hrs+=bhr;
        mins+=bmin;
        if(mins>=60){
            int newHr = mins/60;
            int newmin = mins%60;
            if(newmin == 0){ mins = 0;}
            hrs+=newHr;
            mins+=newmin;
        }
        Duration retB = new Duration(hrs,mins);
        return retB;
    }
    /**
    Returns a String form of the duration using the format shown by
    example here: "8hrs 32min"
    */
    public String toString() {
        return (hrs+"hrs "+mins+"mins");
    }
    }