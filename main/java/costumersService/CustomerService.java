package costumersService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

@Service
/*
 * Customer service, the layer that interact with the DB
 */
public class CustomerService implements Service {
	
	private static Logger logger = LoggerFactory.getLogger(CustomerService.class);
	private CustomerRepository repository;
	
	@Autowired
	public CustomerService(CustomerRepository repository){
		this.repository = repository;
	}

	public CustomerDTO create(CustomerDTO cstdto) {
		logger.info("Creating new entity with id " + cstdto.getId());
		CustomerDTO exists = findById(cstdto.getId());
		if (exists != null){
			return null;
		}
		Customer created = Customer.createBuilder().setId(cstdto.getId())
				.setName(cstdto.getName()).setEmail(cstdto.getEmail())
				.setAddress(cstdto.getAddress())
				.setTokens(cstdto.getTokens()).createCustomer();
		
		created = repository.save(created);
		logger.info("Customer " + cstdto.getId() + " was created");
		return created.convertToDTO();
	}

	public CustomerDTO delete(String id) {
		logger.info("Delete entity with id " + id);
		Customer cste = repository.findOne(id);
		if (cste == null){
			return null;
		}
		this.repository.delete(cste);
		logger.info("Customer " + id + " was deleted");
		return cste.convertToDTO();
	}

	public List<CustomerDTO> findAll() {
		logger.info("Find all entities");
		List<Customer> csteList = repository.findAll();
		List<CustomerDTO> cstdList = new ArrayList<CustomerDTO>();
		
		for (Customer cste : csteList){
			cstdList.add(cste.convertToDTO());
		}
		logger.info("Finished to loop through the entities");
		return cstdList;
	}

	public CustomerDTO findById(String id) {
		logger.info("Get entity with id " + id);
		Customer cste = repository.findOne(id);
		if (cste == null){
			return null;
		}
		logger.info("Return entity with id " + id);
		return cste.convertToDTO();		
	}

	public CustomerDTO update(CustomerDTO cstdto) {
		logger.info("Update entity with id " + cstdto.getId());
		Customer cste = repository.findOne(cstdto.getId());
		if (cste == null){
			return null;
		}
		
		cste.setName(cstdto.getName());
		cste.setEmail(cstdto.getEmail());
		cste.setAddress(cstdto.getAddress());
		cste.addTokens(cstdto.getTokens());
		
		cste = repository.save(cste);
		logger.info("Customer " + cstdto.getId() + " was updated");
		return cste.convertToDTO();
		
	}

	public Class<? extends Annotation> annotationType() {
		// TODO Auto-generated method stub
		return null;
	}

	public String value() {
		// TODO Auto-generated method stub
		return null;
	}

}
