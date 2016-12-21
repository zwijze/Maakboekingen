
package nl.fzit.maakboekingen.config;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="http://fzit.nl/maakboekingen/config" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="config">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element type="ns:TransactionsFilesType" name="TransactionsFiles"/>
 *       &lt;xs:element type="ns:DatabaseType" name="DatabaseBookingProgram"/>
 *       &lt;xs:element type="ns:BookingsType" name="Bookings"/>
 *     &lt;/xs:sequence>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class Config
{
    private TransactionsFilesType transactionsFiles;
    private DatabaseType databaseBookingProgram;
    private BookingsType bookings;

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

    /** 
     * Get the 'Bookings' element value.
     * 
     * @return value
     */
    public BookingsType getBookings() {
        return bookings;
    }

    /** 
     * Set the 'Bookings' element value.
     * 
     * @param bookings
     */
    public void setBookings(BookingsType bookings) {
        this.bookings = bookings;
    }
}
