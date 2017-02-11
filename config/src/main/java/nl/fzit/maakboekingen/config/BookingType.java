
package nl.fzit.maakboekingen.config;

import java.util.ArrayList;
import java.util.List;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://fzit.nl/maakboekingen/config" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="BookingType">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="xs:string" name="BookingDescriptionRegex"/>
 *     &lt;xs:element type="xs:string" name="BookingDescription"/>
 *     &lt;xs:element type="ns:BooleanType" name="AddDateToBookingDescription" minOccurs="0"/>
 *     &lt;xs:element type="ns:BookingLineType" name="BookingLine" minOccurs="1" maxOccurs="unbounded"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class BookingType
{
    private String bookingDescriptionRegex;
    private String bookingDescription;
    private BooleanType addDateToBookingDescription;
    private List<BookingLineType> bookingLineList = new ArrayList<BookingLineType>();

    /** 
     * Get the 'BookingDescriptionRegex' element value.
     * 
     * @return value
     */
    public String getBookingDescriptionRegex() {
        return bookingDescriptionRegex;
    }

    /** 
     * Set the 'BookingDescriptionRegex' element value.
     * 
     * @param bookingDescriptionRegex
     */
    public void setBookingDescriptionRegex(String bookingDescriptionRegex) {
        this.bookingDescriptionRegex = bookingDescriptionRegex;
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
     * Get the 'AddDateToBookingDescription' element value.
     * 
     * @return value
     */
    public BooleanType getAddDateToBookingDescription() {
        return addDateToBookingDescription;
    }

    /** 
     * Set the 'AddDateToBookingDescription' element value.
     * 
     * @param addDateToBookingDescription
     */
    public void setAddDateToBookingDescription(
            BooleanType addDateToBookingDescription) {
        this.addDateToBookingDescription = addDateToBookingDescription;
    }

    /** 
     * Get the list of 'BookingLine' element items.
     * 
     * @return list
     */
    public List<BookingLineType> getBookingLineList() {
        return bookingLineList;
    }

    /** 
     * Set the list of 'BookingLine' element items.
     * 
     * @param list
     */
    public void setBookingLineList(List<BookingLineType> list) {
        bookingLineList = list;
    }
}
