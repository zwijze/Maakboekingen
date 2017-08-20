package nl.fzit.MaakBoekingGnuCash.configGnuCash;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IMarshallingContext;
import org.jibx.runtime.IUnmarshallingContext;
import org.jibx.runtime.JiBXException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import nl.fzit.maakboekinggnucash.configgnucash.ConfigGnuCash;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
		try {
			
            // note that you can use multiple bindings with the same class, in
            //  which case you need to use the getFactory() call that takes the
            //  binding name as the first parameter
            IBindingFactory bfact = BindingDirectory.getFactory(ConfigGnuCash.class);
            
            // unmarshal customer information from file
            IUnmarshallingContext uctx = bfact.createUnmarshallingContext();
//            FileInputStream in = new FileInputStream("src\\main\\config\\config.xml");
            FileInputStream in = new FileInputStream("C:\\mijn documenten\\Maakboekingen\\maakboekingen\\plugins\\config\\configGnuCash.xml");            
            ConfigGnuCash configGnuCash = (ConfigGnuCash)uctx.unmarshalDocument(in, null);
            // you can add code here to alter the unmarshalled customer
            
			// marshal object back out to file (with nice indentation, as UTF-8)
			IMarshallingContext mctx = bfact.createMarshallingContext();
			mctx.setIndent(2);
			FileOutputStream out = new FileOutputStream("C:\\mijn documenten\\Maakboekingen\\maakboekingen\\plugins\\config\\configGnuCash_test.xml");
			mctx.marshalDocument(configGnuCash, "UTF-8", null, out);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
            System.exit(1);
		} catch (JiBXException e) {
			e.printStackTrace();
            System.exit(1);
		}

    	
        assertTrue( true );
    }
}
