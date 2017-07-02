
package nl.fzit.maakboekingen.config;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://fzit.nl/maakboekingen/config" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="AccountType">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="xs:string" name="BookingAccountForAccountNumber"/>
 *     &lt;xs:element type="ns:BookingsType" name="Bookings"/>
 *   &lt;/xs:sequence>
 *   &lt;xs:attribute type="xs:string" use="required" name="AccountNumber"/>
 * &lt;/xs:complexType>
 * </pre>
 */
public class AccountType
{
    private String bookingAccountForAccountNumber;
    private BookingsType bookings;
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
     * Get the 'Bookings' element value.
     * 
     * @return value
     */
    public BookingsType getBookings() {
        return bookings;
    }

    /** 
     * Set the 'Bookings' element value.
     * 
     * @param bookings
     */
    public void setBookings(BookingsType bookings) {
        this.bookings = bookings;
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
