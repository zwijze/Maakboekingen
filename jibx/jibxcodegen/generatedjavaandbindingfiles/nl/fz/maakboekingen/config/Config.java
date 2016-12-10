
package nl.fz.maakboekingen.config;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="http://fz.nl/maakboekingen/config" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="config">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element type="xs:string" name="PadEnFileNaamGnuCash"/>
 *     &lt;/xs:sequence>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class Config
{
    private String padEnFileNaamGnuCash;

    /** 
     * Get the 'PadEnFileNaamGnuCash' element value.
     * 
     * @return value
     */
    public String getPadEnFileNaamGnuCash() {
        return padEnFileNaamGnuCash;
    }

    /** 
     * Set the 'PadEnFileNaamGnuCash' element value.
     * 
     * @param padEnFileNaamGnuCash
     */
    public void setPadEnFileNaamGnuCash(String padEnFileNaamGnuCash) {
        this.padEnFileNaamGnuCash = padEnFileNaamGnuCash;
    }
}
