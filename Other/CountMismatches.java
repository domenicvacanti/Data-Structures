//sp21
public class CountMismatches {
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
        // since we have a lot of similarly named variables seqA1, A2, A3, ....
        {
            String seqA1 = "ATCGATTGAGCTCTAGCG";
            String seqB1 = "TAGCTAACTCGAGATCGC";
            check(1, 0, count_mismatches(seqA1, seqB1));
        }

        {
            String seqA2 = "ATCGATGGAGCTGTAGCG";
            String seqB2 = "TAGCTAACTCGAGATCGA";
            check(2, 3, count_mismatches(seqA2, seqB2));
        }

        {
            String seqA3 = "ATCGATTGAGCT";
            String seqB3 = "TAGCTAACTCGAGATCGC";
            check(3,6, count_mismatches(seqA3, seqB3));
        }

        {
            String seqA4 = "ATCGATTGAGCTCTAGCG";
            String seqB4 = "TAGCTAACTCGAGATC";
            check(4,2, count_mismatches(seqA4, seqB4));
        }

        {
            String seqA5 = "ATCGATTGAGCTCTAGCG";
            String seqB5 = "ATCGATTGAGCTCTAGCG";
            check(5,18, count_mismatches(seqA5, seqB5));
        }

        {
            String seqA6 = "GGGGGGG";
            String seqB6 = "CTCCTCCCTCCCCT";
            check(6,9, count_mismatches(seqA6, seqB6));
        }

        /* We will test your code on additional test
        cases, so make sure it really works. (e.g., you can
        add more of your own test cases, just copy one of the
		above ones and modify it).
        */

        System.out.println("Tests pass for count_mismatches");
    }

    public static int count_mismatches(String seq1, String seq2) {
        int num = 0;
        int diff = 0;
        String a;
        String b;
        if (seq1.length() > seq2.length()) {
            diff = seq1.length() - seq2.length();
            a = seq2;
            b = seq1;
        }
        else {
            diff = seq2.length() - seq1.length();
            a = seq1;
            b = seq2;
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == 'A' && b.charAt(i) != 'T') num++;
            if (a.charAt(i) == 'T' && b.charAt(i) != 'A') num++;
            if (a.charAt(i) == 'G' && b.charAt(i) != 'C') num++;
            if (a.charAt(i) == 'C' && b.charAt(i) != 'G') num++;
        }
        num = num + diff;
        return num;
    }
}
