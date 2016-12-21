
package nl.fzit.maakboekingen.config;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:simpleType xmlns:ns="http://fzit.nl/maakboekingen/config" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="BooleanType">
 *   &lt;xs:restriction base="xs:string">
 *     &lt;xs:enumeration value="Y"/>
 *     &lt;xs:enumeration value="N"/>
 *   &lt;/xs:restriction>
 * &lt;/xs:simpleType>
 * </pre>
 */
public enum BooleanType {
    Y, N
}
