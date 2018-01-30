
package nl.fzit.maakboekingen.config;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://fzit.nl/maakboekingen/config" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="AdditionalTransactionsFilesType">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="xs:string" name="DirectoryTransactionFiles"/>
 *     &lt;xs:element type="xs:string" name="TransactionFilesToReadRegex"/>
 *     &lt;xs:element type="xs:string" name="BookingRegex"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class AdditionalTransactionsFilesType
{
    private String directoryTransactionFiles;
    private String transactionFilesToReadRegex;
    private String bookingRegex;

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
     * Get the 'BookingRegex' element value.
     * 
     * @return value
     */
    public String getBookingRegex() {
        return bookingRegex;
    }

    /** 
     * Set the 'BookingRegex' element value.
     * 
     * @param bookingRegex
     */
    public void setBookingRegex(String bookingRegex) {
        this.bookingRegex = bookingRegex;
    }
}
