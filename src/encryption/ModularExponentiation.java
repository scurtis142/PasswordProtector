package encryption;

public class ModularExponentiation {
	public static long find(long base, long exponant, long mod) {
		
		long c = 1;
		long eprime = 0;
		while(eprime < exponant){
			eprime ++;
			c = (base * c) % (mod);
		}
		return c;
	}
}
