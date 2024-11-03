package br.com.start.meupet.dto;

public class UserRequestDTO {

	private String name;
	private String password;
	private String email;
	private String cellPhoneNumber;

	public UserRequestDTO() {

	}

	public UserRequestDTO(String name, String password, String email, String cellPhoneNumber) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.cellPhoneNumber = cellPhoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}

	public void setCellPhoneNumber(String cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}

}
