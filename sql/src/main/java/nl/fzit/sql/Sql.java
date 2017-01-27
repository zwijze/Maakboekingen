package nl.fzit.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import nl.fzit.sql.api.*;

public class Sql implements ISql {

	private Connection conn=null;
	
	public Sql (String dbms,String serverName,String portNumber,String dbName,String user, String password) throws SQLException, ClassNotFoundException{
	    Properties connectionProps = new Properties();
	    if (dbms.equals("sybase")) {
		    connectionProps.put("ServiceName", dbName);	    
	    	connectionProps.put("user", user);
		    connectionProps.put("password", password);
	    	Class.forName("com.sybase.jdbc4.jdbc.SybDriver");//http://osdn.net/projects/sfnet_id2d/downloads/jdbc%20drivers/jconn4.jar/, jconn4.jar  
	    	//Class.forName("net.sourceforge.jtds.jdbc.Driver");//https://www.dbvis.com/doc/sybase-ase-database-drivers/,jtds-1.3.1.jar
	    	conn = DriverManager.getConnection(
				           "jdbc:" + dbms + ":Tds:" +
				           serverName +
				           ":" + Integer.parseInt(portNumber),
				           connectionProps);
	    } else if (dbms.equals("sqlserver")) {
		    connectionProps.put("databaseName", dbName);	    
		    connectionProps.put("integratedSecurity","true");
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	//Class.forName("net.sourceforge.jtds.jdbc.Driver");//https://www.dbvis.com/doc/sybase-ase-database-drivers/,jtds-1.3.1.jar  
	    	if (portNumber==""){ 
		    	conn = DriverManager.getConnection("jdbc:" + dbms + "://" + serverName + ";",connectionProps);
	    	} else{
	    		conn = DriverManager.getConnection("jdbc:" + dbms + "://" + serverName + ":" + Integer.parseInt(portNumber) + ";",connectionProps);	    		
	    	}
	    } else if (dbms.equals("sqlite")) {
	    	Class.forName("org.sqlite.JDBC");
	    	conn = DriverManager.getConnection("jdbc:sqlite:" + dbName);
	    } else {
	    	System.out.println("Specifeer een ander database management systeem(dbms)!" + dbms);
	    	System.exit(0);
	    }
	    System.out.println("Connected to database server: " + serverName);
		
	}
	
	
	
	public ArrayList <String[]> sqlQueryResult(String query) throws SQLException{
	    
		ArrayList <String[]> result = new ArrayList<String[]>();
		Statement stmt;
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery( query );
		int columnCount = rs.getMetaData().getColumnCount();
		while(rs.next())
		{
		    String[] row = new String[columnCount];
		    for (int i=0; i <columnCount ; i++)
		    {
		       row[i] = rs.getString(i + 1);
		    }
		    result.add(row);
		}
		return result;
		
	}

}