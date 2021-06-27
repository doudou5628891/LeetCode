package Hash;

import java.util.HashSet;
import java.util.Set;

public class isHappy {
    public static boolean isHappy(int n) {

        Set<Integer> set1 = new HashSet<>();
        set1.add(n);
        while(true){
            int sum = 0;
            while(n>0){
                int temp = n % 10;
                n /= 10;
                sum += (int)(Math.pow(temp,2));
            }
            if (sum==1)
                return true;
            else{
                if(set1.contains(sum))
                    return false;
                set1.add(sum);
                n=sum;
            }
        }
    }
    public static void main(String[] args) {
        int data = 1111111;
        boolean result = isHappy(data);
        System.out.print(result);
    }
}
