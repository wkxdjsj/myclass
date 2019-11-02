import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Stack;

public class StackTrain {
    public static void main(String[] args){
        /*
        1,1
        2,2
        3,5/6 -1(312)
        4,14/24 -2(312) -2(423) -2(413) -2(412) -1(314) -1
        5,42/120

        3:
        123,132,213,232,321,(312)
        4;
        1234,1243,1324,1342,(1423),1432,
        2134,2143,2314,2341,(2413),2431,
        (3124),(3142),3214,3241,(3412),3421,
        (4123),(4132),(4213),(4231),(4312),4321

        1,12,123,1234,12345,
        312,41**, 42**,

        1/(n+1) * C(n,2n)
        */
        int n = 4;

        System.out.println("There are " +n+" stack of train.");

        int[] train = new int[n];
        for(int i=0;i<n;i++){
            train[i] = i+1;
        }

        Arrays.stream(train).forEach(a -> System.out.print(a + " "));
        System.out.println();
        System.out.println(validOut(train, new int[]{4, 3, 2, 1}));

        int len = 4;
        int total = 1;
        int valid = 0;
        int tempLen = len;
        while(tempLen > 1){
            total *= tempLen;
            tempLen = tempLen-1;
        }
        tempLen = len;
        valid = total;

        System.out.println(total);
        System.out.println(valid);

    }
    public static boolean validOut(int origin[], int desire[]){
        int len = origin.length;
        // maintain count of popped elements
        int j;
        j = 0;

        // an empty stack
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++)
        {

            stack.push(origin[i]);
            while (!stack.empty() && j < len &&
                    stack.peek() == desire[j])
            {
                stack.pop();
                j++;
            }
        }

        return j == len;
    }
}
