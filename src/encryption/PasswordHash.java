package encryption;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * A class for making a hashcode(integer) from a given password(string)
 * @author Simon Curtis
 *
 */
public class PasswordHash {

	/**
	 * Returns an integer between 0 and 20000 based on a given string. 
	 * Ensures that the same string will always return the same integer.
	 * 
	 * Uses the MD5 hash algorithm and then maps it to an integer between 1
	 * and 20000
	 * 
	 * @param password, the string to hash on
	 * @return an integer hashcode between 1 and 20000
	 * @throws NoSuchAlgorithmException
	 */
	public static int get_hash(String password) throws NoSuchAlgorithmException{
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.reset();
		m.update(password.getBytes());
		byte[] digest = m.digest();
		BigInteger passwordInt = new BigInteger(1,digest);
		BigInteger maxSize = new BigInteger("340282380000000000000"
				+ "000000000000000000");
		BigInteger compression = new BigInteger("20000");
		
		BigDecimal passwordDecimal = new BigDecimal(passwordInt);
		BigDecimal maxSizeDecimal = new BigDecimal(maxSize);
		BigDecimal compressionDecimal = new BigDecimal(compression);
		
		BigDecimal finalDecimal = compressionDecimal.multiply(
				passwordDecimal.divide(maxSizeDecimal,20,BigDecimal.ROUND_UP));
		return finalDecimal.intValue();
	}
}
