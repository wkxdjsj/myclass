public class reverseInt {
    public static void main(String[] args){
        int input = 12345;
        int result = 0;
        while(input !=0){
            result = result*10;
            result += (input%10);
            input = input/10;
        }
        System.out.println(result);

    }
}
