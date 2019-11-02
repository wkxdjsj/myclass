import java.util.Arrays;

public class SmallBranch {
    public static void main(String[] args){
        String[] a = {"1", "2", "3"};
        a = Arrays.copyOf(a, a.length-2);
        System.out.println(a.length);
    }

}

