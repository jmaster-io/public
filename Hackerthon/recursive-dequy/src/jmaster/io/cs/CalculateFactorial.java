package jmaster.io.cs;

public class CalculateFactorial {
    public static void main(String[] args) {
	// loop - vong lap
	int result1 = withLoop(10);
	System.out.println(result1);

	// recursive - de quy
	int result2 = withRecursive(10);
	System.out.println(result2);
    }

    public static int withLoop(int k) {
	int gt = 1;
	for (int i = 1; i <= k; i++) {
	    gt *= i;
	}
	return gt;
    }

    public static int withRecursive(int k) {
	if (k > 0) {
	    return k * withRecursive(k - 1);
	} else {
	    return 1;
	}
    }

//    10 * withRecursive(9)
//    10 * ( 9 * withRecursive(8) )
//    10 * ( 9 * ( 8 * withRecursive(7) ) )
//    ...
//    10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1 * withRecursive(0)
//    10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1 * 1
}
