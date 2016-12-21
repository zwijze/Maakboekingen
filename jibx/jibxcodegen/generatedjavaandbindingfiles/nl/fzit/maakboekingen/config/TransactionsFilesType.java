
package nl.fzit.maakboekingen.config;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://fzit.nl/maakboekingen/config" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="TransactionsFilesType">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="xs:string" name="DirectoryTransactionFiles"/>
 *     &lt;xs:element type="xs:string" name="RegexTransactionFilesToRead"/>
 *     &lt;xs:element type="xs:string" name="RegexBeginBalance"/>
 *     &lt;xs:element type="xs:string" name="RegexBookingDateAndAmount"/>
 *     &lt;xs:element type="xs:string" name="RegexEndBalance"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class TransactionsFilesType
{
    private String directoryTransactionFiles;
    private String regexTransactionFilesToRead;
    private String regexBeginBalance;
    private String regexBookingDateAndAmount;
    private String regexEndBalance;

    /** 
     * Get the 'DirectoryTransactionFiles' element value.
     * 
     * @return value
     */
    public String getDirectoryTransactionFiles() {
        return directoryTransactionFiles;
    }

    /** 
     * Set the 'DirectoryTransactionFiles' element value.
     * 
     * @param directoryTransactionFiles
     */
    public void setDirectoryTransactionFiles(String directoryTransactionFiles) {
        this.directoryTransactionFiles = directoryTransactionFiles;
    }

    /** 
     * Get the 'RegexTransactionFilesToRead' element value.
     * 
     * @return value
     */
    public String getRegexTransactionFilesToRead() {
        return regexTransactionFilesToRead;
    }

    /** 
     * Set the 'RegexTransactionFilesToRead' element value.
     * 
     * @param regexTransactionFilesToRead
     */
    public void setRegexTransactionFilesToRead(
            String regexTransactionFilesToRead) {
        this.regexTransactionFilesToRead = regexTransactionFilesToRead;
    }

    /** 
     * Get the 'RegexBeginBalance' element value.
     * 
     * @return value
     */
    public String getRegexBeginBalance() {
        return regexBeginBalance;
    }

    /** 
     * Set the 'RegexBeginBalance' element value.
     * 
     * @param regexBeginBalance
     */
    public void setRegexBeginBalance(String regexBeginBalance) {
        this.regexBeginBalance = regexBeginBalance;
    }

    /** 
     * Get the 'RegexBookingDateAndAmount' element value.
     * 
     * @return value
     */
    public String getRegexBookingDateAndAmount() {
        return regexBookingDateAndAmount;
    }

    /** 
     * Set the 'RegexBookingDateAndAmount' element value.
     * 
     * @param regexBookingDateAndAmount
     */
    public void setRegexBookingDateAndAmount(String regexBookingDateAndAmount) {
        this.regexBookingDateAndAmount = regexBookingDateAndAmount;
    }

    /** 
     * Get the 'RegexEndBalance' element value.
     * 
     * @return value
     */
    public String getRegexEndBalance() {
        return regexEndBalance;
    }

    /** 
     * Set the 'RegexEndBalance' element value.
     * 
     * @param regexEndBalance
     */
    public void setRegexEndBalance(String regexEndBalance) {
        this.regexEndBalance = regexEndBalance;
    }
}
