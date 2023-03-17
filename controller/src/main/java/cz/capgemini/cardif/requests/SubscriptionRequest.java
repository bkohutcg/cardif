package cz.capgemini.cardif.requests;

import cz.capgemini.cardif.Quotation;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDate;

/**
 * @author Branislav Kohut
 */
public class SubscriptionRequest {

    public LocalDate startDate;
    public LocalDate validUntil;
    public Quotation quotation;

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDate validUntil) {
        this.validUntil = validUntil;
    }

    public Quotation getQuotation() {
        return quotation;
    }

    public void setQuotation(Quotation quotation) {
        this.quotation = quotation;
    }

    /**
     *
     * @param startDate LocalDate, start date, format YYYY-mm-dd
     * @param validUntil LocalDate, valid until, format YYYY-mm-dd
     * @param quotation Quotation, quotation data
     */
    public SubscriptionRequest(LocalDate startDate, LocalDate validUntil, Quotation quotation) {
        this.startDate = startDate;
        this.validUntil = validUntil;
        this.quotation = quotation;
    }

    protected SubscriptionRequest() {}

    @Override
    public String toString() {
        return "SubscriptionRequest{" +
                "startDate=" + startDate +
                ", validUntil=" + validUntil +
                ", quotation=" + quotation.toString() +
                '}';
    }
}
