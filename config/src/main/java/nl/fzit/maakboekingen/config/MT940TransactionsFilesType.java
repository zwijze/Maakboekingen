
package nl.fzit.maakboekingen.config;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://fzit.nl/maakboekingen/config" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="MT940TransactionsFilesType">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="xs:string" name="DirectoryTransactionFiles"/>
 *     &lt;xs:element type="xs:string" name="TransactionFilesToReadRegex"/>
 *     &lt;xs:element type="xs:string" name="BeginBalanceRegex"/>
 *     &lt;xs:element type="xs:string" name="BookingDateAndAmountRegex"/>
 *     &lt;xs:element type="xs:string" name="EndBalanceRegex"/>
 *     &lt;xs:element type="xs:string" name="AccountNumberRegex"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class MT940TransactionsFilesType
{
    private String directoryTransactionFiles;
    private String transactionFilesToReadRegex;
    private String beginBalanceRegex;
    private String bookingDateAndAmountRegex;
    private String endBalanceRegex;
    private String accountNumberRegex;

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
     * Get the 'TransactionFilesToReadRegex' element value.
     * 
     * @return value
     */
    public String getTransactionFilesToReadRegex() {
        return transactionFilesToReadRegex;
    }

    /** 
     * Set the 'TransactionFilesToReadRegex' element value.
     * 
     * @param transactionFilesToReadRegex
     */
    public void setTransactionFilesToReadRegex(
            String transactionFilesToReadRegex) {
        this.transactionFilesToReadRegex = transactionFilesToReadRegex;
    }

    /** 
     * Get the 'BeginBalanceRegex' element value.
     * 
     * @return value
     */
    public String getBeginBalanceRegex() {
        return beginBalanceRegex;
    }

    /** 
     * Set the 'BeginBalanceRegex' element value.
     * 
     * @param beginBalanceRegex
     */
    public void setBeginBalanceRegex(String beginBalanceRegex) {
        this.beginBalanceRegex = beginBalanceRegex;
    }

    /** 
     * Get the 'BookingDateAndAmountRegex' element value.
     * 
     * @return value
     */
    public String getBookingDateAndAmountRegex() {
        return bookingDateAndAmountRegex;
    }

    /** 
     * Set the 'BookingDateAndAmountRegex' element value.
     * 
     * @param bookingDateAndAmountRegex
     */
    public void setBookingDateAndAmountRegex(String bookingDateAndAmountRegex) {
        this.bookingDateAndAmountRegex = bookingDateAndAmountRegex;
    }

    /** 
     * Get the 'EndBalanceRegex' element value.
     * 
     * @return value
     */
    public String getEndBalanceRegex() {
        return endBalanceRegex;
    }

    /** 
     * Set the 'EndBalanceRegex' element value.
     * 
     * @param endBalanceRegex
     */
    public void setEndBalanceRegex(String endBalanceRegex) {
        this.endBalanceRegex = endBalanceRegex;
    }

    /** 
     * Get the 'AccountNumberRegex' element value.
     * 
     * @return value
     */
    public String getAccountNumberRegex() {
        return accountNumberRegex;
    }

    /** 
     * Set the 'AccountNumberRegex' element value.
     * 
     * @param accountNumberRegex
     */
    public void setAccountNumberRegex(String accountNumberRegex) {
        this.accountNumberRegex = accountNumberRegex;
    }
}
