
package nl.fzit.maakboekingen.config;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="http://fzit.nl/maakboekingen/config" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="config">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element type="xs:string" name="ClassNamePluginBookingProgram"/>
 *       &lt;xs:element type="ns:TransactionsFilesType" name="TransactionsFiles"/>
 *       &lt;xs:element type="ns:AccountsType" name="Accounts"/>
 *     &lt;/xs:sequence>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class Config
{
    private String classNamePluginBookingProgram;
    private TransactionsFilesType transactionsFiles;
    private AccountsType accounts;

    /** 
     * Get the 'ClassNamePluginBookingProgram' element value. Classname plugin booking program that creates a booking.
     * 
     * @return value
     */
    public String getClassNamePluginBookingProgram() {
        return classNamePluginBookingProgram;
    }

    /** 
     * Set the 'ClassNamePluginBookingProgram' element value. Classname plugin booking program that creates a booking.
     * 
     * @param classNamePluginBookingProgram
     */
    public void setClassNamePluginBookingProgram(
            String classNamePluginBookingProgram) {
        this.classNamePluginBookingProgram = classNamePluginBookingProgram;
    }

    /** 
     * Get the 'TransactionsFiles' element value.
     * 
     * @return value
     */
    public TransactionsFilesType getTransactionsFiles() {
        return transactionsFiles;
    }

    /** 
     * Set the 'TransactionsFiles' element value.
     * 
     * @param transactionsFiles
     */
    public void setTransactionsFiles(TransactionsFilesType transactionsFiles) {
        this.transactionsFiles = transactionsFiles;
    }

    /** 
     * Get the 'Accounts' element value.
     * 
     * @return value
     */
    public AccountsType getAccounts() {
        return accounts;
    }

    /** 
     * Set the 'Accounts' element value.
     * 
     * @param accounts
     */
    public void setAccounts(AccountsType accounts) {
        this.accounts = accounts;
    }
}
