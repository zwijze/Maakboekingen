
package nl.fzit.maakboekingen.config;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://fzit.nl/maakboekingen/config" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="BookingsType">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="ns:AccountType" name="Account" minOccurs="0"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class BookingsType
{
    private AccountType account;

    /** 
     * Get the 'Account' element value.
     * 
     * @return value
     */
    public AccountType getAccount() {
        return account;
    }

    /** 
     * Set the 'Account' element value.
     * 
     * @param account
     */
    public void setAccount(AccountType account) {
        this.account = account;
    }
}
