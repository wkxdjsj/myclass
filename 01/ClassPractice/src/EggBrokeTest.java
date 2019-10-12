public class EggBrokeTest {

    public static void main(String[] args){
        int egg = 3;
        int floor = 100;
        int limitLevel = 100;

        //try for each X level, then x-1, then x-2 .....2, 1. Thus worst case remain the same.
        // Thus (x * (x+1) / 2) = total floor.
        // in first case, 2 eggs and 100 floor, X = 14;
        // x = ((-1 + √(1+8k))/2) for each egg usage.
        int steps = 0;
        int x = (int) Math.ceil((-1 + Math.sqrt((double) (1 + 8 * floor))) / 2);
        int result = 0;
        int low= 0 ;
        int high = 0;

        while(result+x <= floor){
            result += x;
            x = x - 1;
            steps += 1;
            if(result<limitLevel) {
                System.out.println("Step " + steps + ": tried " + result + "th floor. Egg safe");
                low = result;
            } else {
                System.out.println("Step " + steps + ": tried " + result + "th floor. An egg broke.");
                high = result;
                break;
            }
        }
        result = low;
        while(result <= floor){
            result += 1;
            steps += 1;
            if(result<limitLevel) {
                System.out.println("Step " + steps + ": tried " + result + "th floor. Egg safe");
            } else {
                System.out.println("Step " + steps + ": tried " + result + "th floor. An egg broke.");
                result -= 1;
                break;
            }
        }

        System.out.println("the highest egg level is :" + result + ".");

    }

}
