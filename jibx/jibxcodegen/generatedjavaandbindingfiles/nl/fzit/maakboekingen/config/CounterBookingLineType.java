
package nl.fzit.maakboekingen.config;

import java.math.BigDecimal;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://fzit.nl/maakboekingen/config" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="CounterBookingLineType">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="xs:string" name="BookingAccount"/>
 *     &lt;xs:element type="ns:DebitCreditType" name="DebitCredit"/>
 *     &lt;xs:element type="xs:decimal" name="PercentageOfTotalAmount" minOccurs="0"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class CounterBookingLineType
{
    private String bookingAccount;
    private DebitCreditType debitCredit;
    private BigDecimal percentageOfTotalAmount;

    /** 
     * Get the 'BookingAccount' element value.
     * 
     * @return value
     */
    public String getBookingAccount() {
        return bookingAccount;
    }

    /** 
     * Set the 'BookingAccount' element value.
     * 
     * @param bookingAccount
     */
    public void setBookingAccount(String bookingAccount) {
        this.bookingAccount = bookingAccount;
    }

    /** 
     * Get the 'DebitCredit' element value.
     * 
     * @return value
     */
    public DebitCreditType getDebitCredit() {
        return debitCredit;
    }

    /** 
     * Set the 'DebitCredit' element value.
     * 
     * @param debitCredit
     */
    public void setDebitCredit(DebitCreditType debitCredit) {
        this.debitCredit = debitCredit;
    }

    /** 
     * Get the 'PercentageOfTotalAmount' element value.
     * 
     * @return value
     */
    public BigDecimal getPercentageOfTotalAmount() {
        return percentageOfTotalAmount;
    }

    /** 
     * Set the 'PercentageOfTotalAmount' element value.
     * 
     * @param percentageOfTotalAmount
     */
    public void setPercentageOfTotalAmount(BigDecimal percentageOfTotalAmount) {
        this.percentageOfTotalAmount = percentageOfTotalAmount;
    }
}
