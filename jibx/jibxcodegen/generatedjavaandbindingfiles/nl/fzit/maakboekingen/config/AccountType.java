
package nl.fzit.maakboekingen.config;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://fzit.nl/maakboekingen/config" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="AccountType">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="xs:string" name="BookingAccountForAccountNumber" minOccurs="1"/>
 *     &lt;xs:element type="ns:BookingType" name="Booking" minOccurs="0"/>
 *   &lt;/xs:sequence>
 *   &lt;xs:attribute type="xs:string" use="required" name="AccountNumber"/>
 * &lt;/xs:complexType>
 * </pre>
 */
public class AccountType
{
    private String bookingAccountForAccountNumber;
    private BookingType booking;
    private String accountNumber;

    /** 
     * Get the 'BookingAccountForAccountNumber' element value.
     * 
     * @return value
     */
    public String getBookingAccountForAccountNumber() {
        return bookingAccountForAccountNumber;
    }

    /** 
     * Set the 'BookingAccountForAccountNumber' element value.
     * 
     * @param bookingAccountForAccountNumber
     */
    public void setBookingAccountForAccountNumber(
            String bookingAccountForAccountNumber) {
        this.bookingAccountForAccountNumber = bookingAccountForAccountNumber;
    }

    /** 
     * Get the 'Booking' element value.
     * 
     * @return value
     */
    public BookingType getBooking() {
        return booking;
    }

    /** 
     * Set the 'Booking' element value.
     * 
     * @param booking
     */
    public void setBooking(BookingType booking) {
        this.booking = booking;
    }

    /** 
     * Get the 'AccountNumber' attribute value.
     * 
     * @return value
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /** 
     * Set the 'AccountNumber' attribute value.
     * 
     * @param accountNumber
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
