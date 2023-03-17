package cz.capgemini.cardif;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Branislav Kohut
 */
@Entity
public class Quotation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long id;
    public LocalDate beginningOfInsurance;
    public BigDecimal insuredAmount;
    public LocalDate dateOfSigningMortgage;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    public Customer customer;

    public Long getId() {
        return id;
    }

    public LocalDate getBeginningOfInsurance() {
        return beginningOfInsurance;
    }

    public void setBeginningOfInsurance(LocalDate beginningOfInsurance) {
        this.beginningOfInsurance = beginningOfInsurance;
    }

    public BigDecimal getInsuredAmount() {
        return insuredAmount;
    }

    public void setInsuredAmount(BigDecimal insuredAmount) {
        this.insuredAmount = insuredAmount;
    }

    public LocalDate getDateOfSigningMortgage() {
        return dateOfSigningMortgage;
    }

    public void setDateOfSigningMortgage(LocalDate dateOfSigningMortgage) {
        this.dateOfSigningMortgage = dateOfSigningMortgage;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    protected Quotation() {}

    /**
     *
     * @param beginningOfInsurance LocalDate, begining of insurance, format YYYY-mm-dd
     * @param insuredAmount BigDecimal, amount insured
     * @param dateOfSigningMortgage LocalDate, date of mortgage signing, format YYYY-mm-dd
     * @param customer Customer, customer data
     */
    public Quotation(LocalDate beginningOfInsurance, BigDecimal insuredAmount, LocalDate dateOfSigningMortgage, Customer customer) {
        this.beginningOfInsurance = beginningOfInsurance;
        this.insuredAmount = insuredAmount;
        this.dateOfSigningMortgage = dateOfSigningMortgage;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Quotation{" +
                "id=" + id +
                ", beginningOfInsurance=" + beginningOfInsurance +
                ", insuredAmount=" + insuredAmount +
                ", dateOfSigningMortgage=" + dateOfSigningMortgage +
                ", customer=" + customer.toString() +
                '}';
    }
}
