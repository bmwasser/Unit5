public class TimeClient {
    
    public static void main(String[] args) {
        Time time = new Time(11, 59, 59);
        Time newTime = new Time();
        System.out.println(newTime);
        System.out.println(time); 
        System.out.println(time.getHour()); 
        System.out.println(time.getMinute());
        System.out.println(time.getSecond());
        newTime.setHour(5);
        newTime.setMinute(35);
        newTime.setSecond(45);
        System.out.println(newTime);
    }


}
