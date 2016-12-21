
package nl.fzit.maakboekingen.config;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://fzit.nl/maakboekingen/config" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="DatabaseType">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="xs:string" name="Dbms"/>
 *     &lt;xs:element type="xs:string" name="ServerName" minOccurs="0"/>
 *     &lt;xs:element type="xs:string" name="PortNumber" minOccurs="0"/>
 *     &lt;xs:element type="xs:string" name="DbName"/>
 *     &lt;xs:element type="xs:string" name="User" minOccurs="0"/>
 *     &lt;xs:element type="xs:string" name="Password" minOccurs="0"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class DatabaseType
{
    private String dbms;
    private String serverName;
    private String portNumber;
    private String dbName;
    private String user;
    private String password;

    /** 
     * Get the 'Dbms' element value.
     * 
     * @return value
     */
    public String getDbms() {
        return dbms;
    }

    /** 
     * Set the 'Dbms' element value.
     * 
     * @param dbms
     */
    public void setDbms(String dbms) {
        this.dbms = dbms;
    }

    /** 
     * Get the 'ServerName' element value.
     * 
     * @return value
     */
    public String getServerName() {
        return serverName;
    }

    /** 
     * Set the 'ServerName' element value.
     * 
     * @param serverName
     */
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    /** 
     * Get the 'PortNumber' element value.
     * 
     * @return value
     */
    public String getPortNumber() {
        return portNumber;
    }

    /** 
     * Set the 'PortNumber' element value.
     * 
     * @param portNumber
     */
    public void setPortNumber(String portNumber) {
        this.portNumber = portNumber;
    }

    /** 
     * Get the 'DbName' element value.
     * 
     * @return value
     */
    public String getDbName() {
        return dbName;
    }

    /** 
     * Set the 'DbName' element value.
     * 
     * @param dbName
     */
    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    /** 
     * Get the 'User' element value.
     * 
     * @return value
     */
    public String getUser() {
        return user;
    }

    /** 
     * Set the 'User' element value.
     * 
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /** 
     * Get the 'Password' element value.
     * 
     * @return value
     */
    public String getPassword() {
        return password;
    }

    /** 
     * Set the 'Password' element value.
     * 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
