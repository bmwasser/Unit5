public class Time{
    
    private int hour;
    private int minute;
    private int second;

    public Time() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getSecond() {
        return this.second;
    }

    public void setHour(int newHour) {
        if (newHour >= 0 && newHour <= 23){
            this.hour = newHour;
        } else {
            throw new IllegalArgumentException("Invalid hour: " + newHour);
        }
        
    }

    public void setMinute(int newMinute) {
        if (newMinute >= 0 && newMinute <= 59){
            this.minute = newMinute;
        } else {
            throw new IllegalArgumentException("Invalid minute: " + newMinute);
        }
        
    }

    public void setSecond(int newSecond) {
        if (newSecond >= 0 && newSecond <= 59){
            this.second = newSecond;
        } else {
            throw new IllegalArgumentException("Invalid second: " + newSecond);
        }
        
    }

    public String toString() {
        return String.format("%2d:%02d:%02d", this.hour, this.minute, this.second);
    }

}