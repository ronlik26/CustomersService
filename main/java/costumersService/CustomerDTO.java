package costumersService;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

/*
 * This class represents the customer DTO, which his the entity that interact with 
 * the controller
 */
public class CustomerDTO {
	
	@NotEmpty
	private String id;
	@NotEmpty
	private String name;
	private String email;
	private String address;
	private List<String> tokens;
	
	public CustomerDTO(){}
	
	public String getId() {
		return id;
	}
	
	/**
	 * set id
	 * @param id -
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name to name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the tokens
	 */
	public List<String> getTokens() {
		return tokens;
	}
	/**
	 * @param tokens the tokens to set
	 */
	public void setTokens(List<String> tokens) {
		this.tokens = tokens;
	}
	
}
