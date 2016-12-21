
package nl.fzit.maakboekingen.config;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:simpleType xmlns:ns="http://fzit.nl/maakboekingen/config" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="DebitCreditType">
 *   &lt;xs:restriction base="xs:string">
 *     &lt;xs:enumeration value="D"/>
 *     &lt;xs:enumeration value="C"/>
 *   &lt;/xs:restriction>
 * &lt;/xs:simpleType>
 * </pre>
 */
public enum DebitCreditType {
    D, C
}
