package tests;

import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.ArrayList;
import java.util.List;

import encryption.EncryptionDetails;
import encryption.ModularExponentiation;

public class Experiment {

	   public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException, InterruptedException {
		   /*
		   EncryptionDetails e = new EncryptionDetails(5000);
		   String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()-=[];',./_+{}|:<>?";
		   byte[] bytes = s.getBytes("US-ASCII");
		   List<Long> codes = new ArrayList<Long>();
		   List<Byte> decodes = new ArrayList<Byte>();
		   for(int i = 0; i < s.length(); i++){
			   codes.add(ModularExponentiation.find(bytes[i], e.get_e(), e.get_mod()));
		   }
		   for(int i = 0; i < s.length(); i++) {
			   decodes.add((byte)ModularExponentiation.find(codes.get(i), e.get_d(), e.get_mod()));
		   }
		   boolean error = false;
		   for(int i = 0; i < s.length(); i++){
			   System.out.print(bytes[i]+" ");//use StringBuilder to go backwards
			   System.out.println(decodes.get(i));
			   if(bytes[i] != (byte)decodes.get(i)) {
				   error = true;
			   }
		   }
		   if(error) {
				   System.out.println("error");
		   }
		   */
		   
		   
	   }
}
