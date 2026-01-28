public class Time{
    
    private int seconds; // total number of seconds in the time
    static final int SEC_IN_HOUR = 3600;
    static final int SEC_IN_MIN = 60;
    static final int HOUR_IN_DAY = 24;

    public Time() {
        this.seconds = 0;
    }

    public Time(int hour, int minute, int second) {
        this.seconds = (hour * SEC_IN_HOUR) + (minute * SEC_IN_MIN) + second;
    }

    public int getHour() {
        return this.seconds / SEC_IN_HOUR;
    }

    public int getMinute() {
        return (this.seconds % SEC_IN_HOUR) / SEC_IN_MIN;
    }

    public int getSecond() {
        return this.seconds % SEC_IN_MIN;
    }

    // Adds this time to other and returns a new Time object.
    // If the time wraps over to another day, adjusts the time to be within a 24-hour day
    public Time add(Time other) {
        int totalSecs = this.seconds + other.seconds;
        int normalizedSecs = totalSecs % (HOUR_IN_DAY * SEC_IN_HOUR);
        return new Time(0, 0, normalizedSecs);
    }

    // Subtracts this time to other and returns a new Time object.
    // If the time is negative, adjust the time to be within a 24-hour day
    public Time subtract(Time other) {
        int diffSecs = this.seconds - other.seconds;
        
        if (diffSecs < 0) {
            diffSecs += (HOUR_IN_DAY * SEC_IN_HOUR);
        }
        
        return new Time(0, 0, diffSecs);
    }

    // Returns true if this time and the other time represent the same clock time
    public boolean equals(Time other){
        final double DELTA = 0.001;
        return this.getHour() == other.getHour() && this.getMinute() == other.getMinute() && Math.abs(this.getSecond() - other.getSecond()) < DELTA;
    }

    public String toString() {
        return String.format("%2d:%02d:%02d", getHour(), getMinute(), getSecond());
    }

}