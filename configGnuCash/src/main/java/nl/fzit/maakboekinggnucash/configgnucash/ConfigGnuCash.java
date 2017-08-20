
package nl.fzit.maakboekinggnucash.configgnucash;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="http://fzit.nl/maakboekingGnuCash/configGnuCash" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="configGnuCash">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element type="ns:DatabaseType" name="DatabaseBookingProgram"/>
 *     &lt;/xs:sequence>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class ConfigGnuCash
{
    private DatabaseType databaseBookingProgram;

    /** 
     * Get the 'DatabaseBookingProgram' element value. Database booking program.
     * 
     * @return value
     */
    public DatabaseType getDatabaseBookingProgram() {
        return databaseBookingProgram;
    }

    /** 
     * Set the 'DatabaseBookingProgram' element value. Database booking program.
     * 
     * @param databaseBookingProgram
     */
    public void setDatabaseBookingProgram(DatabaseType databaseBookingProgram) {
        this.databaseBookingProgram = databaseBookingProgram;
    }
}
