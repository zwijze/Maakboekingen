package nl.fz.maakboekingen.sql;

import java.sql.SQLException;
import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import nl.fzit.sql.Sql;

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
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    public void testApp() throws ClassNotFoundException, SQLException
    {
    	
		String[] element;
		Sql sql=new Sql();
		sql.makeConnection("sqlite", "", "", "" ,"C:\\mijn documenten\\Maakboekingen\\GnuCashSqlite\\fz-it-jaar-2016.gnucash", "", "", "");
		
		//Selectie van leningen ophalen
		ArrayList <String[]> elementenLijst=sql.sqlQueryResult("select * from transactions");

        element=elementenLijst.get(0);
        System.out.println("Eerste element:");
        System.out.println(element[0]);

        assertTrue( true );
    }
}
