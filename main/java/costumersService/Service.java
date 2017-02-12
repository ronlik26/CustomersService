package costumersService;

import java.util.List;

/**
 * This interface represents all the methods that the customer service supports
 * @author Ron
 *
 */
public interface Service {

	// Get info from the controller and create it in the DB
	CustomerDTO create(CustomerDTO cstdto);
	// Get specific id to be deleted and delete it from the DB
	CustomerDTO delete(String id);
	// Get entity from the DB
	CustomerDTO findById(String id);
	// Get all the customers that exists in the system
	List<CustomerDTO> findAll();
	// Update the customer information according to the information 
	//that was delivered to the controller
	CustomerDTO update(CustomerDTO cstdto);
}
