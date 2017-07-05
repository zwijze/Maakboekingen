
package nl.fzit.maakboekingen.config;

import java.util.ArrayList;
import java.util.List;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://fzit.nl/maakboekingen/config" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="CounterBookingLinesType">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="ns:CounterBookingLineType" name="CounterBookingLine" minOccurs="1" maxOccurs="unbounded"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class CounterBookingLinesType
{
    private List<CounterBookingLineType> counterBookingLineList = new ArrayList<CounterBookingLineType>();

    /** 
     * Get the list of 'CounterBookingLine' element items.
     * 
     * @return list
     */
    public List<CounterBookingLineType> getCounterBookingLineList() {
        return counterBookingLineList;
    }

    /** 
     * Set the list of 'CounterBookingLine' element items.
     * 
     * @param list
     */
    public void setCounterBookingLineList(List<CounterBookingLineType> list) {
        counterBookingLineList = list;
    }
}
