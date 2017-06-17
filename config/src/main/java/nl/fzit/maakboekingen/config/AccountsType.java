
package nl.fzit.maakboekingen.config;

import java.util.ArrayList;
import java.util.List;

/**  
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://fzit.nl/maakboekingen/config" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="AccountsType">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="ns:AccountType" name="Account" minOccurs="0" maxOccurs="unbounded"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre> 
 */
public class AccountsType
{
    private List<AccountType> accountList = new ArrayList<AccountType>();

    /** 
     * Get the list of 'Account' element items.
     * 
     * @return list
     */
    public List<AccountType> getAccountList() {
        return accountList;
    }

    /** 
     * Set the list of 'Account' element items.
     * 
     * @param list
     */
    public void setAccountList(List<AccountType> list) {
        accountList = list;
    }
}
