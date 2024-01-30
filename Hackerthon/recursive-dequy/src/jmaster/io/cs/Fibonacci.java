package jmaster.io.cs;

public class Fibonacci {

    public static void main(String args[]) {
	int n = 5;
	System.out.println("fib(" + n + ") : " + fibonacci(n));
	fibSequence(n);
    }

    // F(n) = F(n-1) + F(n-2)
    // F0 = 0 and F1 = 1.
    public static int fibonacci(int n) {
	if (n <= 1)
	    return n;
	return fibonacci(n - 1) + fibonacci(n - 2);
    }

//  fibonacci(4) + fibonacci(3)
//  fibonacci(3) + fibonacci(2) +  fibonacci(2) + fibonacci(1)
//  fibonacci(2) + fibonacci(1) + fibonacci(1) + fibonacci(0) + fibonacci(1) + fibonacci(0) + 1
//  fibonacci(1) + fibonacci(0) + 1 + 1 + 0 + 1 + 0 + 1 
//  1 + 0 + 1 + 1 + 0 + 1 + 0 + 1 
    
    public static void fibSequence(int n) {
	int total = 0;
	System.out.print("Fibonacci sequence: ");

	for (int i = 0; i <= n; i++) {
	    System.out.print(fibonacci(i) + " ");

	    total += fibonacci(i);
	}

	System.out.println("Sum: " + total);
    }
}
