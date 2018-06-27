package experiment;

public class testSubString {
    public static void main(String[] args) {
        String a="aaa交互国际化国际化";
        System.out.println(handle(a,6));
    }
    public static String handle(String a,int n){
        return a.substring(0,n);
    }
}
