
package nl.fzit.maakboekingen.config;

import java.util.ArrayList;
import java.util.List;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://fzit.nl/maakboekingen/config" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="BookingsType">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="ns:BookingType" name="Booking" minOccurs="1" maxOccurs="unbounded"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class BookingsType
{
    private List<BookingType> bookingList = new ArrayList<BookingType>();

    /** 
     * Get the list of 'Booking' element items.
     * 
     * @return list
     */
    public List<BookingType> getBookingList() {
        return bookingList;
    }

    /** 
     * Set the list of 'Booking' element items.
     * 
     * @param list
     */
    public void setBookingList(List<BookingType> list) {
        bookingList = list;
    }
}
