import java.util.Scanner;

public class ReverseImage {
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	String image=sc.next();
        int operations = minOperationsToReverse(image);
        if(operations>=3)
        {
        	System.out.println(3);
        }
        else
        {
        System.out.println(2);
        }
    }

    public static int minOperationsToReverse(String image) {
        int n = image.length();
        int minOperations = Math.min(n, 2); 
        for (int i = 0; i < n; i++) {
            int operations = 0;
            StringBuilder sb = new StringBuilder(image);
            for (int j = 0; j < i; j++) {
                char c = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(c);
                operations++;
            }
            String reversed = sb.reverse().toString();
            if (reversed.equals(image)) {
                minOperations = Math.min(minOperations, operations);
            }
        }
        return minOperations;
    }
}