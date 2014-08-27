/** 
 * Implement pow(x, n) 
 */
public class ImplementPow {

    public double pow(double x, int n) {
    
        // if n is zero, just return 1.0
       if (n == 0) {
			return 1.0;
		}

        // use binary recursion can reduce the number of computation 
		double half = pow(x, n / 2);
		
		// being indivisible
		if (n % 2 == 0) {
			return half * half;
		} 
		// positive n
		else if (n > 0) {
			return half * half * x;
		}
		// negative n
		else {
			return half * half / x;
		}
    }
}
