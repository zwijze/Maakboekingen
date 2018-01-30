
package nl.fzit.maakboekingen.config;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="http://fzit.nl/maakboekingen/config" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="config">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element type="xs:string" name="ClassNamePluginBookingProgram"/>
 *       &lt;xs:element type="ns:MT940TransactionsFilesType" name="MT940TransactionsFiles"/>
 *       &lt;xs:element type="ns:AdditionalTransactionsFilesType" name="AdditionalTransactionsFiles"/>
 *       &lt;xs:element type="ns:AccountsType" name="Accounts"/>
 *     &lt;/xs:sequence>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class Config
{
    private String classNamePluginBookingProgram;
    private MT940TransactionsFilesType MT940TransactionsFiles;
    private AdditionalTransactionsFilesType additionalTransactionsFiles;
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
     * Get the 'MT940TransactionsFiles' element value.
     * 
     * @return value
     */
    public MT940TransactionsFilesType getMT940TransactionsFiles() {
        return MT940TransactionsFiles;
    }

    /** 
     * Set the 'MT940TransactionsFiles' element value.
     * 
     * @param MT940TransactionsFiles
     */
    public void setMT940TransactionsFiles(
            MT940TransactionsFilesType MT940TransactionsFiles) {
        this.MT940TransactionsFiles = MT940TransactionsFiles;
    }

    /** 
     * Get the 'AdditionalTransactionsFiles' element value.
     * 
     * @return value
     */
    public AdditionalTransactionsFilesType getAdditionalTransactionsFiles() {
        return additionalTransactionsFiles;
    }

    /** 
     * Set the 'AdditionalTransactionsFiles' element value.
     * 
     * @param additionalTransactionsFiles
     */
    public void setAdditionalTransactionsFiles(
            AdditionalTransactionsFilesType additionalTransactionsFiles) {
        this.additionalTransactionsFiles = additionalTransactionsFiles;
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
