package costumersService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
import javax.validation.Valid;
import java.util.List;
 
@RestController
@RequestMapping("/customers")
/*
 * The customer controller, the layer that interact with the client and respond accordingly
 */
class CustomerController {
 
	private static Logger logger = LoggerFactory.getLogger(CustomerController.class);
    private CustomerService service;
 
    @Autowired
    CustomerController(CustomerService service) {
        this.service = service;
    }
 
    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<CustomerDTO> create(@RequestBody @Valid CustomerDTO entry) {
    	logger.info("Creating new entity with id " + entry.getId());
    	CustomerDTO response =  service.create(entry);
    	if (response == null){
    		return new ResponseEntity<CustomerDTO>(HttpStatus.CONFLICT);
    	}
		logger.info("Customer " + entry.getId() + " was created");
    	return new ResponseEntity<CustomerDTO>(response, HttpStatus.CREATED);
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    ResponseEntity<CustomerDTO> delete(@PathVariable("id") String id) {
		logger.info("Delete entity with id " + id);
    	CustomerDTO response = service.delete(id);
    	if (response == null){
    		return new ResponseEntity<CustomerDTO>(HttpStatus.NOT_FOUND);
    	}
		logger.info("Customer " + id + " was deleted");
    	return new ResponseEntity<CustomerDTO>(HttpStatus.NO_CONTENT); 
    }
 
    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<CustomerDTO>> findAll() {
		logger.info("Find all entities");
    	List<CustomerDTO> responses = service.findAll();
    	if (responses.isEmpty()){
    		 return new ResponseEntity<List<CustomerDTO>>(HttpStatus.NO_CONTENT);
    	}
 		logger.info("Finished to loop through the entities");
    	return new ResponseEntity<List<CustomerDTO>>(responses, HttpStatus.OK);
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    ResponseEntity<CustomerDTO> findById(@PathVariable("id") String id) {
		logger.info("Get entity with id " + id);
    	CustomerDTO response = service.findById(id);
    	if (response == null){
    		return new ResponseEntity<CustomerDTO>(HttpStatus.NOT_FOUND);
    	}
		logger.info("Return entity with id " + id);
    	return new ResponseEntity<CustomerDTO>(response, HttpStatus.OK);
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    ResponseEntity<CustomerDTO> update(@RequestBody @Valid CustomerDTO entry) {
		logger.info("Update entity with id " + entry.getId());
    	CustomerDTO response = service.update(entry);
    	if (response == null){
    		return new ResponseEntity<CustomerDTO>(HttpStatus.NOT_FOUND);
    	}
		logger.info("Customer " + entry.getId() + " was updated");
    	return new ResponseEntity<CustomerDTO>(response, HttpStatus.OK);
    }
 
}