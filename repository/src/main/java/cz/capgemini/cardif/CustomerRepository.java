package cz.capgemini.cardif;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author Branislav Kohut
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Optional<Customer> findById(Long id);

}
