package costumersService;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Mongo Repository interface that being implemented by the Spring framework
 * @author Ron
 *
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {
	
	void delete(Customer deleted);
	List<Customer> findAll();
	Customer findOne(String id);
	Customer save(Customer saved);
}
