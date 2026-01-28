public class TimeClient {
    
    public static void main(String[] args) {
        Time t1 = new Time();
        Time t2 = new Time(14, 21, 45);
        Time t3 = new Time(0, 0, 0);
        Time t4 = new Time(1, 38, 30);

        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);

        System.out.println(t1.getHour() + "-" + t1.getMinute() + "-" + t1.getSecond());
        System.out.println(t2.add(t4));
        System.out.println(t2.subtract(t4));
        System.out.println(t1.equals(t3));
    }


}
