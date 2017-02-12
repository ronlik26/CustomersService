package costumersService;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
 
import org.springframework.web.client.RestTemplate;
 
 
public class TestClient {
 
    public static final String REST_SERVICE_URI = "http://localhost:8080/customers/";
     
    /* GET ALL */
    @SuppressWarnings("unchecked")
    private static void listAllCustomers(){
        System.out.println("Testing list all Customers API-----------");
         
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(REST_SERVICE_URI, List.class);
         
        if(usersMap!=null){
            for(LinkedHashMap<String, Object> map : usersMap){
                System.out.println("User : id="+map.get("id")+", Name="+map.get("name"));
            }
        }else{
        	System.out.println("No Customers----------");
        }
    }
     
    /* GET */
    private static void getCustomer(String id){
        System.out.println("Testing get Customer API----------");
        RestTemplate restTemplate = new RestTemplate();
        try{
        	CustomerDTO cstdto = restTemplate.getForObject(REST_SERVICE_URI + id, CustomerDTO.class);
        	System.out.println("id: " + id + " name: " + cstdto.getName());
        }
        catch(org.springframework.web.client.HttpClientErrorException e){
        	System.out.println("Customer " + id + " not exists----------");
        }
    }
     
    /* POST */
    private static void createCustomer(String id) {
        System.out.println("Testing create Customer API----------");
        RestTemplate restTemplate = new RestTemplate();
        CustomerDTO customer = new CustomerDTO();
        customer.setId(id);
        customer.setName("Ron" + id);
        customer.setEmail("Ron@gmail.com");
        customer.setAddress("bla");
        List<String> tokens  = Arrays.asList("4324","1231","43543");
        customer.setTokens(tokens);
        try{
        	restTemplate.postForObject(REST_SERVICE_URI, customer, CustomerDTO.class);
        	System.out.println("Customer " + id + " created----------");
        }
        catch(org.springframework.web.client.HttpClientErrorException e){
        	System.out.println("Customer " + id + " already exists----------");
        }
    }
 
    /* PUT */
    private static void updateCustomer(String id) {
        System.out.println("Testing update Customer API----------");
        RestTemplate restTemplate = new RestTemplate();
        CustomerDTO customer = new CustomerDTO();
        customer.setId(id);
        customer.setName("Moshe" + id);
        customer.setEmail("Moshe@gmail.com");
        customer.setAddress("bla");
        List<String> tokens  = Arrays.asList("43256464");
        customer.setTokens(tokens);
        try{
        	restTemplate.put(REST_SERVICE_URI + id, customer);
        	System.out.println("Customer " + id + " updated----------");
        }
        catch(org.springframework.web.client.HttpClientErrorException e){
        	System.out.println("Customer " + id + " not exists----------");
        }
    }
 
    /* DELETE */
    private static void deleteCustomer(String id) {
        System.out.println("Testing delete Customer API----------");
        RestTemplate restTemplate = new RestTemplate();
        try{
            restTemplate.delete(REST_SERVICE_URI + id);
        	System.out.println("Customer " + id + " deleted----------");
        }
        catch(org.springframework.web.client.HttpClientErrorException e){
        	System.out.println("Customer " + id + " not exists----------");
        }
    }
 
    public static void main(String args[]){
        getCustomer("4");
        createCustomer("6");
        getCustomer("6");
        updateCustomer("6");
        getCustomer("6");
        createCustomer("7");
        createCustomer("8");
        createCustomer("9");
        listAllCustomers();
        updateCustomer("8");
        deleteCustomer("6");
        listAllCustomers();
        deleteCustomer("7");
        deleteCustomer("8");
        listAllCustomers();
        deleteCustomer("9");
        listAllCustomers();

    }
}