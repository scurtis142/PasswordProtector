package encryption;

import org.apache.commons.math3.primes.Primes;

/**
 * A class for storing the encryption details of an instance of the RSA 
 * encryption algorithm. 
 * 
 * @author Simon
 *
 */
public class EncryptionDetails {
	private long p1;
	private long p2;
	private long mod;
	private long e;
	private long d;
	private long totient;
	
	/**
	 * Will create RSA encryption detailes based on a given hashcode. The same
	 * hashcode will always create the same detailes. 
	 * 
	 * Creates two primes p1, p2 based on the given hashcode and calculates the
	 * mod, e, d and the totient.
	 * 
	 * @param hashcode
	 */
	public EncryptionDetails(int hashcode){
		p1 = (long)Primes.nextPrime(hashcode*2);
		p2 = (long)Primes.nextPrime(hashcode/2);
		mod = p1*p2;
		totient = (p1-1)*(p2-1);
		e = calculate_e();
		d = calculate_d();
	}
	
	private long calculate_e() {
		long e = 65537;
		long gcd;
		do{
			e = Primes.nextPrime((int)(e+1));
			gcd = ExtendedEuclidAlgorithm.find_gcd(totient, e);
		}while(gcd != 1);
		return e;
	}

	private long calculate_d(){
		return ExtendedEuclidAlgorithm.find_inverse(e, totient);
	}
	
	public long get_mod(){
		return mod;
	}
	
	public long get_totient(){
		return totient;
	}
	
	public long get_e(){
		return e;
	}
	
	public long get_d(){
		return d;
	}
	
	public String toString(){
		return "p = "+p1+": q = "+p2+": mod = "+mod+": totient = "+totient+": e = "+e+": d = "+d;
	}
}
