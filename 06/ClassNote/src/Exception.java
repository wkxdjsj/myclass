import java.io.File;

public class Exception extends Throwable {
    public static void main(String[] args){
        int c;
        try {
            int a = 1;
            int b = 0;
            c = a/b;
            System.out.println(a / b);
            System.out.println("where am i?");
        } catch (ArithmeticException e) {
            System.out.println("something went wrong");
            System.err.println("something went wrong");
            e.printStackTrace();
        }finally {
            System.out.println("finally I will print out");
        }
        System.out.println("end of try catch");

        System.out.println(File.separator);
        System.out.println(File.pathSeparator);
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));


    }

}
