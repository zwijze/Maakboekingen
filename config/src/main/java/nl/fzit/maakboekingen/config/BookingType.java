
package nl.fzit.maakboekingen.config;

import java.util.ArrayList;
import java.util.List;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://fzit.nl/maakboekingen/config" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="BookingType">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="xs:string" name="CounterAccountNumber"/>
 *     &lt;xs:element type="ns:DebitCreditType" name="DebitCredit"/>
 *     &lt;xs:element type="xs:string" name="BookingDescription" minOccurs="0"/>
 *     &lt;xs:element type="xs:string" name="BookingDescriptionUsedToBook"/>
 *     &lt;xs:element type="ns:BooleanType" name="AddDateToBookingDescriptionUsedToBook" minOccurs="0"/>
 *     &lt;xs:element type="ns:BookingLineType" name="BookingLines" minOccurs="1" maxOccurs="unbounded"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class BookingType
{
    private String counterAccountNumber;
    private DebitCreditType debitCredit;
    private String bookingDescription;
    private String bookingDescriptionUsedToBook;
    private BooleanType addDateToBookingDescriptionUsedToBook;
    private List<BookingLineType> bookingLineList = new ArrayList<BookingLineType>();

    /** 
     * Get the 'CounterAccountNumber' element value.
     * 
     * @return value
     */
    public String getCounterAccountNumber() {
        return counterAccountNumber;
    }

    /** 
     * Set the 'CounterAccountNumber' element value.
     * 
     * @param counterAccountNumber
     */
    public void setCounterAccountNumber(String counterAccountNumber) {
        this.counterAccountNumber = counterAccountNumber;
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
     * Get the 'BookingDescription' element value.
     * 
     * @return value
     */
    public String getBookingDescription() {
        return bookingDescription;
    }

    /** 
     * Set the 'BookingDescription' element value.
     * 
     * @param bookingDescription
     */
    public void setBookingDescription(String bookingDescription) {
        this.bookingDescription = bookingDescription;
    }

    /** 
     * Get the 'BookingDescriptionUsedToBook' element value.
     * 
     * @return value
     */
    public String getBookingDescriptionUsedToBook() {
        return bookingDescriptionUsedToBook;
    }

    /** 
     * Set the 'BookingDescriptionUsedToBook' element value.
     * 
     * @param bookingDescriptionUsedToBook
     */
    public void setBookingDescriptionUsedToBook(
            String bookingDescriptionUsedToBook) {
        this.bookingDescriptionUsedToBook = bookingDescriptionUsedToBook;
    }

    /** 
     * Get the 'AddDateToBookingDescriptionUsedToBook' element value.
     * 
     * @return value
     */
    public BooleanType getAddDateToBookingDescriptionUsedToBook() {
        return addDateToBookingDescriptionUsedToBook;
    }

    /** 
     * Set the 'AddDateToBookingDescriptionUsedToBook' element value.
     * 
     * @param addDateToBookingDescriptionUsedToBook
     */
    public void setAddDateToBookingDescriptionUsedToBook(
            BooleanType addDateToBookingDescriptionUsedToBook) {
        this.addDateToBookingDescriptionUsedToBook = addDateToBookingDescriptionUsedToBook;
    }

    /** 
     * Get the list of 'BookingLines' element items.
     * 
     * @return list
     */
    public List<BookingLineType> getBookingLineList() {
        return bookingLineList;
    }

    /** 
     * Set the list of 'BookingLines' element items.
     * 
     * @param list
     */
    public void setBookingLineList(List<BookingLineType> list) {
        bookingLineList = list;
    }
}
