//sp21
public class MaxOfBoth {
    // check() takes a test number and two ints expected and actual
    // if expected and actual are equal, then nothing happens
    // otherwise it prints a failure message including the test number
    private static void check(int testnum, int expected, int actual) {
        if (expected != actual) {
            System.out.println("FAILED TEST " + testnum + ": expected=" + expected + " actual=" + actual);
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
        // since we have a lot of similarly named variables a1, a2....
        {
            int[] a1 = {2, 4, 6, 8, 10, 12, 14};
            int[] b1 = {7, 7, 5, 4};
            // checks both orders of arguments since order doesn't matter
            check(1, 4, max_of_both(a1, b1));
            check(2, 4, max_of_both(b1, a1));
        }

        {
            int[] a2 = {2, 4, 6, 8};
            int[] b2 = {3, 5, 7};
            check(3, Integer.MIN_VALUE, max_of_both(a2, b2));
            check(4, Integer.MIN_VALUE, max_of_both(b2, a2));
        }

        {
            int[] a3 = {7, 6, 22, 4, 4};
            int[] b3 = {4, 5, 5, 25, 6};
            check(5, 6, max_of_both(a3, b3));
            check(6, 6, max_of_both(b3, a3));
        }

        {
            int[] a4 = {10, 20, 30, 40, 50, 60, 70};
            int[] b4 = {50, 40, 70, 60, 10};
            check(7, 70, max_of_both(a4, b4));
            check(8, 70, max_of_both(b4, a4));
        }


				/* We will test your code on additional test
				cases, so make sure it really works. (e.g., you can
				add more of your own test cases, just copy one of the
				above ones and modify it).
				*/

        System.out.println("Tests passed for max_of_both");
    }

    public static int max_of_both(int[] x, int[] y) {
        int num = Integer.MIN_VALUE;
        for (int i = 0; i < x.length; i++){
            for (int j = 0; j < y.length; j++){
                if(x[i] == y[j] && x[i] > num) num = x[i];
            }
        }
        return num;
    }
}
