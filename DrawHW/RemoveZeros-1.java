//sp21
import java.util.Arrays;

class RemoveZeroes {
    // check() takes a test number and two array references expected and actual
    // if expected and actual refer to arrays with the same length and contents, then nothing happens
    // otherwise it prints a failure message including the test number
    private static void check(int testnum, int[] expected, int[] actual) {
        // Arrays.equals is a Java library function that compares length and contents of two arrays
        // The ! means NOT. That is, Boolean negation. So this condition reads..."if the arrays
        // are not equal".
        if (!Arrays.equals(expected, actual)) {
            // Arrays.toString is a Java library function that returns a String representation
            // of an array. We need this because if you just give an array reference to System.out.println
            // then it will print "nonsense".
            System.out.println("FAILED TEST " + testnum
                    + ": expected=" + Arrays.toString(expected)
                    + " actual=" + Arrays.toString(actual));
            // System.exit ends the program immediately
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        // You may have never seen a pair of curly braces {} that
        // wasn't associated with an "if", "for", or a method.
        // But you are allowed to do this, too, in Java. Just like other uses of braces,
        // it makes it so that the variables
        // declared inside (i.e., seqA1 and seqB1) cannot be used
        // outside of the braces. This just helps us avoid mistakes
        // since we have a lot of similarly named variables a1, a2 ....
        {
            int[] a1 = {-1, -2, -2, 4}; // input
            int[] a1_exp = {-1, -2, -2, 4};
            check(1, a1_exp, remove_zeroes(a1));
        }

        {
            int[] a2 = {0, 4, 3, 2, 1};
            int[] a2_exp = {4, 3, 2, 1};
            check(2, a2_exp, remove_zeroes(a2));
        }

        {
            int[] a3 = {5, -1, 10, 0, 11, 0};
            int[] a3_exp = {5, -1, 10, 11};
            check(3, a3_exp, remove_zeroes(a3));
        }

        {
            int[] a4 = {0, 0, -4, 5, -6, 7, 0, 4, 3};
            int[] a4_exp = {-4, 5, -6, 7, 4, 3};
            check(4, a4_exp, remove_zeroes(a4));
        }

        {
            int[] a5 = {1, 0, 0};
            int[] a5_exp = {1};
            check(5, a5_exp, remove_zeroes(a5));
        }

        {
            int[] a6 = {0, 0, 2, 0, 0, 0, 1, 0, 0, 0, 0};
            int[] a6_exp = {2, 1};
            check(6, a6_exp, remove_zeroes(a6));
        }

				/* We will test your code on additional test
				cases, so make sure it really works. (e.g., you can
				add more of your own test cases, just copy one of the
				above ones and modify it).
				*/

        System.out.println("Tests pass for remove_zeroes");
    }

    public static int[] remove_zeroes(int[] arr) {
        int num = 0;
        for (int i = 0; i<arr.length;i++){
            if(arr[i] == 0){
                num++;
            }
        }
        int[] myArray = new int[arr.length-num];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                continue;
            }
            myArray[k++] = arr[i];
        }
        return myArray;
    }
}
