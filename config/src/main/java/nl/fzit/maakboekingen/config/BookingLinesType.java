
package nl.fzit.maakboekingen.config;

import java.util.ArrayList;
import java.util.List;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://fzit.nl/maakboekingen/config" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="BookingLinesType">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="ns:BookingLineType" name="BookingLine" minOccurs="1" maxOccurs="unbounded"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class BookingLinesType
{
    private List<BookingLineType> bookingLineList = new ArrayList<BookingLineType>();

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
