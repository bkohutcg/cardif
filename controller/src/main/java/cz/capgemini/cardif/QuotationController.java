package cz.capgemini.cardif;

import cz.capgemini.cardif.requests.QuotationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Branislav Kohut
 */
@RestController
public class QuotationController {

    private static final Logger log = LoggerFactory.getLogger(QuotationController.class);

    @Autowired
    private QuotationrRepository repository;

    /**
     *
     * @param request Quotation object
     * @return Response 200 with saved object
     */
    @PostMapping("/quotation/create")
    public ResponseEntity setSubscription(@RequestBody QuotationRequest request){
        log.info("Called create Quotation with request: " + request.toString());
        Quotation quotation = new Quotation(
                request.getBeginningOfInsurance(),
                request.getInsuredAmount(),
                request.getDateOfSigningMortgage(),
                request.getCustomer()
        );
        return ResponseEntity.ok(repository.save(quotation));
    }

}
