package cz.capgemini.cardif;

import cz.capgemini.cardif.requests.SubscriptionRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author Branislav Kohut
 */
@RestController
public class SubscriptionController {

    private static final Logger log = LoggerFactory.getLogger(SubscriptionController.class);

    @Autowired
    private SubscriptionRepository repository;

    /**
     *
     * @param identificator id of Subscription in database
     * @return Response 200 if subscription found, Reponse 404 if not
     */
    @GetMapping("/subscription/{identificator}")
    public ResponseEntity getSubscription(@PathVariable Long identificator) {
        log.info("Called get Subscription with id: " + identificator);
        Optional<Subscription> subscription = repository.findById(identificator);
        if (subscription.isPresent()){
            return ResponseEntity.ok(subscription.get());
        }
        return new ResponseEntity(String.format("Subscription with id: %s not found in DB", identificator),
                HttpStatus.NOT_FOUND);
    }

    /**
     *
     * @param request SubscriptionRequest object
     * @return Response 200 with saved Subscription object
     */
    @PostMapping("/subscription/create")
    public ResponseEntity setSubscription(@RequestBody SubscriptionRequest request){
        log.info("Called create Subscription with request: " + request.toString());
        Subscription subscription = new Subscription(
                request.getStartDate(),
                request.getValidUntil(),
                request.getQuotation()
        );
        return ResponseEntity.ok(repository.save(subscription));
    }

}
