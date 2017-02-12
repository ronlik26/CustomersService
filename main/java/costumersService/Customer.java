package costumersService;

import java.util.List;

/*
 * Customer entity class
 */
public class Customer {

	private String id;
	private String name;
	private String email;
	private String address;
	private List<String> tokens;
	
	public Customer(){}
	
	// Private Ctor so the user will use the builder in order to create the entity
	private Customer(String id, String name, String email,
			String address, List<String> tokens){
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.tokens = tokens;
	}
	
	public String getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getAddress(){
		return address;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public List<String> getTokens(){
		return tokens;
	}
	
	// add credit card token to the current tokens list
	public void addTokens(List<String> tokens){
		for (String token : tokens){
			if (!this.tokens.contains(token)){
				this.tokens.add(token);
			}
		}
	}
	
	public static CustomerBuilder createBuilder(){
		return new CustomerBuilder();
	}
	
	
	
	public CustomerDTO convertToDTO(){
		
		 CustomerDTO cdto = new CustomerDTO();
		 cdto.setId(this.id);
		 cdto.setName(this.name);
		 cdto.setAddress(this.address);
		 cdto.setEmail(this.email);
		 cdto.setTokens(this.tokens);
		 
		 return cdto;
	}
	
	/**
	 * Builder design pattern
	 * @author Ron
	 *
	 */
	public static class CustomerBuilder{
		private String id;
		private String name;
		private String email;
		private String address;
		private List<String> tokens;
		
		CustomerBuilder(){}


		/**
		 * @param id the id to set
		 */
		public CustomerBuilder setId(String id) {
			this.id = id;
			return this;
		}

		/**
		 * @param name the name to set
		 */
		public CustomerBuilder setName(String name) {
			this.name = name;
			return this;
		}


		/**
		 * @param email the email to set
		 */
		public CustomerBuilder setEmail(String email) {
			this.email = email;
			return this;
		}


		/**
		 * @param address the address to set
		 * @return 
		 */
		public CustomerBuilder setAddress(String address) {
			this.address = address;
			return this;
		}


		/**
		 * @param tokens the tokens to set
		 */
		public CustomerBuilder setTokens(List<String> tokens) {
			this.tokens = tokens;
			return this;
		}
		
		 public Customer createCustomer(){
			 return new Customer(id, name, email, address, tokens);
		 }
		
		
	}
}
