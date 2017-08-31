
package nl.fzit.maakboekingen.config;

import java.math.BigInteger;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://fzit.nl/maakboekingen/config" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="BookingType">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="xs:string" name="CounterAccountNumber"/>
 *     &lt;xs:element type="xs:string" name="BookingDescription"/>
 *     &lt;xs:element type="xs:string" name="BookingDescriptionUsedToBook"/>
 *     &lt;xs:element type="xs:integer" name="AddExtraYearsMonthsDaysToDateInBookingDescriptionUsedToBook" minOccurs="0" maxOccurs="1"/>
 *     &lt;xs:element type="ns:CounterBookingLinesType" name="CounterBookingLines"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class BookingType
{
    private String counterAccountNumber;
    private String bookingDescription;
    private String bookingDescriptionUsedToBook;
    private BigInteger addExtraYearsMonthsDaysToDateInBookingDescriptionUsedToBook;
    private CounterBookingLinesType counterBookingLines;

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
     * Get the 'AddExtraYearsMonthsDaysToDateInBookingDescriptionUsedToBook' element value.
     * 
     * @return value
     */
    public BigInteger getAddExtraYearsMonthsDaysToDateInBookingDescriptionUsedToBook() {
        return addExtraYearsMonthsDaysToDateInBookingDescriptionUsedToBook;
    }

    /** 
     * Set the 'AddExtraYearsMonthsDaysToDateInBookingDescriptionUsedToBook' element value.
     * 
     * @param addExtraYearsMonthsDaysToDateInBookingDescriptionUsedToBook
     */
    public void setAddExtraYearsMonthsDaysToDateInBookingDescriptionUsedToBook(
            BigInteger addExtraYearsMonthsDaysToDateInBookingDescriptionUsedToBook) {
        this.addExtraYearsMonthsDaysToDateInBookingDescriptionUsedToBook = addExtraYearsMonthsDaysToDateInBookingDescriptionUsedToBook;
    }

    /** 
     * Get the 'CounterBookingLines' element value.
     * 
     * @return value
     */
    public CounterBookingLinesType getCounterBookingLines() {
        return counterBookingLines;
    }

    /** 
     * Set the 'CounterBookingLines' element value.
     * 
     * @param counterBookingLines
     */
    public void setCounterBookingLines(
            CounterBookingLinesType counterBookingLines) {
        this.counterBookingLines = counterBookingLines;
    }
}
