package cz.capgemini.cardif;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Branislav Kohut
 */
public interface QuotationrRepository extends CrudRepository<Quotation, Long> {
}
