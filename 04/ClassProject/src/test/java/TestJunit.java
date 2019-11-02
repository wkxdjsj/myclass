import org.junit.Test;

public class TestJunit {
    @Test  // isAnnotationPresent to check, that's why newer version need not test as method name first word
    public void printSysOut() {
        System.out.println("print any thing");
    }
}