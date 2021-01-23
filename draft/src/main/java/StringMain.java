
public class StringMain {
    public static void main(String[] args) {
        String x="x";
        String y="y";
        String s = new String(x + y);
        String intern = s.intern();
        System.out.println(s==intern);//1.6 false  1.7+ true
    }
}
