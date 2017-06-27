
package nl.fzit.maakboekingen.config;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="http://fzit.nl/maakboekingen/config" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="config">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element type="ns:DatabaseType" name="DatabaseBookingProgram"/>
 *       &lt;xs:element type="xs:string" name="JarFilePluginBookingProgram"/>
 *       &lt;xs:element type="xs:string" name="ClassNamePluginBookingProgram"/>
 *       &lt;xs:element type="xs:string" name="JarFilePluginSql"/>
 *       &lt;xs:element type="xs:string" name="ClassNamePluginSql"/>
 *       &lt;xs:element type="ns:TransactionsFilesType" name="TransactionsFiles"/>
 *       &lt;xs:element type="ns:AccountsType" name="Accounts"/>
 *     &lt;/xs:sequence>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class Config
{
    private DatabaseType databaseBookingProgram;
    private String jarFilePluginBookingProgram;
    private String classNamePluginBookingProgram;
    private String jarFilePluginSql;
    private String classNamePluginSql;
    private TransactionsFilesType transactionsFiles;
    private AccountsType accounts;

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
     * Get the 'JarFilePluginBookingProgram' element value.
     * 
     * @return value
     */
    public String getJarFilePluginBookingProgram() {
        return jarFilePluginBookingProgram;
    }

    /** 
     * Set the 'JarFilePluginBookingProgram' element value.
     * 
     * @param jarFilePluginBookingProgram
     */
    public void setJarFilePluginBookingProgram(
            String jarFilePluginBookingProgram) {
        this.jarFilePluginBookingProgram = jarFilePluginBookingProgram;
    }

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
     * Get the 'JarFilePluginSql' element value.
     * 
     * @return value
     */
    public String getJarFilePluginSql() {
        return jarFilePluginSql;
    }

    /** 
     * Set the 'JarFilePluginSql' element value.
     * 
     * @param jarFilePluginSql
     */
    public void setJarFilePluginSql(String jarFilePluginSql) {
        this.jarFilePluginSql = jarFilePluginSql;
    }

    /** 
     * Get the 'ClassNamePluginSql' element value. Classname Sql connection.
     * 
     * @return value
     */
    public String getClassNamePluginSql() {
        return classNamePluginSql;
    }

    /** 
     * Set the 'ClassNamePluginSql' element value. Classname Sql connection.
     * 
     * @param classNamePluginSql
     */
    public void setClassNamePluginSql(String classNamePluginSql) {
        this.classNamePluginSql = classNamePluginSql;
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
