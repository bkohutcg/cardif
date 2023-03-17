package cz.capgemini.cardif;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author Branislav Kohut
 */
public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {

    Optional<Subscription> findById(Long id);

}
