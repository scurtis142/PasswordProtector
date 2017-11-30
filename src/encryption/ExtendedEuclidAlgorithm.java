package encryption;

public class ExtendedEuclidAlgorithm {
	
	/**
	 * Returns d such that de = 1 mod(z)   given e and z
	 * @param e
	 * @param totient
	 * @return d
	 */
	public static long find_inverse(long e, long z) {
		long vals[] = gcd(e, z);
		long d = vals[1];
		while(d < 0) {
			d += z;
		}
		return d;
	}
	
	public static long find_gcd(long a, long b) {
		long vals[] = gcd(a, b);
		return vals[0];
	}
	
	private static long[] gcd(long p, long q) {
	      if (q == 0)
	         return new long[] { p, 1, 0 };

	      long[] vals = gcd(q, p % q);
	      long d = vals[0];
	      long a = vals[2];
	      long b = vals[1] - (p / q) * vals[2];
	      return new long[] { d, a, b };
	   }
}
