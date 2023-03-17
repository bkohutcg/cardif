package cz.capgemini.cardif;

import cz.capgemini.cardif.requests.CustomerRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author Branislav Kohut
 */
@RestController
public class CustomerController {

    private static final Logger log = LoggerFactory.getLogger(SubscriptionController.class);

    @Autowired
    private CustomerRepository repository;

    /**
     *
     * @param identificator id of Customer in database
     * @return Response 200 if customer found, Reponse 404 if not
     */
    @GetMapping("/customer/{identificator}")
    public ResponseEntity getCustomer(@PathVariable Long identificator) {
        log.info("Called get Customer with id: " + identificator);
        Optional<Customer> customer = repository.findById(identificator);
        if (customer.isPresent()){
            return ResponseEntity.ok(customer.get());
        }
        return new ResponseEntity(String.format("Customer with id: %s not found in DB", identificator),
                HttpStatus.NOT_FOUND);
    }

    /**
     *
     * @param request CustomerRequest object
     * @return Response 200 with saved object
     */
    @PostMapping("/customer/create")
    public ResponseEntity createCustomer(@RequestBody CustomerRequest request){
        log.info("Called create Customer with request: " + request.toString());
        Customer customer = new Customer(
                request.getFirstName(),
                request.getLastName(),
                request.getMiddleName(),
                request.getEmail(),
                request.getPhoneNumber(),
                request.getBirthDate()
        );
        return ResponseEntity.ok(repository.save(customer));
    }

    /**
     *
     * @param id id of Customer in database
     * @param customerRequest updated Customer object
     * @return Response 200 if customer found and updated, Response 404 if not found
     */
    @PutMapping("/customer/{id}/update")
    public ResponseEntity updateCustomer(@PathVariable Long id, @RequestBody CustomerRequest customerRequest){
        Optional<Customer> customer = repository.findById(id);
        log.info(String.format("Called update Customer with id: %s with request: %s", id, customerRequest));
        if (customer.isPresent()){
            return ResponseEntity.ok(customer.map(cust -> {
                cust.setFirstName(customerRequest.getFirstName());
                cust.setLastName(customerRequest.getLastName());
                cust.setMiddleName(customerRequest.getMiddleName());
                cust.setEmail(customerRequest.getEmail());
                cust.setPhoneNumber(customerRequest.getPhoneNumber());
                cust.setBirthDate(customerRequest.getBirthDate());
                return repository.save(cust);
            }));
        }
        return new ResponseEntity(String.format("Customer with id: %s not found in DB", id),
                HttpStatus.NOT_FOUND);
    }

}
