package data;

public class EntryInfo {
	private String username;
	private String password;
	private String organisation;
	private String other;
	
	public EntryInfo(String username, String password, String organisation, String other) {
		this.username = username;
		this.password = password;
		this.organisation = organisation;
		this.other = other;
	}
	
	public String get_username() {
		return username;
	}
	
	public String get_password() {
		return password;
	}
	
	public String get_organisation() {
		return organisation;
	}
	
	public String get_other() {
		return other;
	}
	
	public void set_username(String username) {
		this.username = username;
	}
	
	public void set_password(String password) {
		this.password = password;
	}
	
	public void set_organisation(String organisation) {
		this.organisation = organisation;
	}
	
	public void set_other(String other) {
		this.other = other;
	}
}
