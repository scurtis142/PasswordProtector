package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import encryption.EncryptionDetails;
import encryption.ModularExponentiation;
import encryption.PasswordHash;

public class Model {
	
	private static final String FILENAME = "data/accounts.txt";
	private Map<Long, Character> decrypt;
	private Map<Character, Long> encrypt;
	private CurrentState state;
	private LinkedList<EntryInfo> mainlist;
	private EncryptionDetails eDetails;
	private String givenPassword;
	
	public Model() throws UnsupportedEncodingException {
		Scanner sc = new Scanner(System.in);
		givenPassword = sc.next();
		try {
			eDetails = new EncryptionDetails(PasswordHash.get_hash(givenPassword));
			createMaps();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			System.exit(1);
		}
		sc.close();
		load_data();
	}

	private void createMaps() throws UnsupportedEncodingException {
		encrypt = new HashMap<Character, Long>();
		decrypt = new HashMap<Long, Character>();
		String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()-=[];',./_+{}|<>?";
		byte[] bytes = s.getBytes("US-ASCII");
		for(int i = 0; i < s.length(); i++) {
			Long number = ModularExponentiation.find(bytes[i], eDetails.get_e(), eDetails.get_mod());
			encrypt.put(s.charAt(i), number);
			decrypt.put(number, s.charAt(i));
		}
	}

	private void load_data() {
		FileReader fr = null;
		BufferedReader br = null;
		try{
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			String firstLine = br.readLine();
			Scanner sc = new Scanner(firstLine);
			sc.useDelimiter(" ");
			StringBuilder s = new StringBuilder();
			while(sc.hasNextLong()) {
				long next = sc.nextLong();
				char character = decrypt.get(next);
				s.append(character);
			}
			if(givenPassword.equals(s.toString())){
				System.out.println(true);
			}
			loadAccounts(br);
			
		} catch(IOException e){
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void loadAccounts(BufferedReader br) throws IOException {
		String currentLine = br.readLine();
		Scanner searchParts;
		Scanner searchChars;
		while(currentLine != null) {
			searchParts = new Scanner(currentLine);
			searchParts.useDelimiter(":");
			if(searchParts.hasNextLong()) {
				
			}
			
			currentLine = br.readLine();
		}
	}
}
