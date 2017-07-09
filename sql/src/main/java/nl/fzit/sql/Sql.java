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
	
	public void makeConnection(String dbms,String serverName,String portNumber,String protocol,String dbName,String domain,String user, String password) throws SQLException, ClassNotFoundException{
	    Properties connectionProps = new Properties();
	    if (dbms.equals("sybase")  && protocol.equals("TCP")) {
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
	    } else if (dbms.equals("sqlserver")  && protocol.equals("TCP")) {
		    connectionProps.put("databaseName", dbName);	    
		    connectionProps.put("integratedSecurity","true");
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	//Class.forName("net.sourceforge.jtds.jdbc.Driver");//https://www.dbvis.com/doc/sybase-ase-database-drivers/,jtds-1.3.1.jar  
	    	if (portNumber==""){ 
		    	conn = DriverManager.getConnection("jdbc:" + dbms + "://" + serverName + ";",connectionProps);
	    	} else{
	    		conn = DriverManager.getConnection("jdbc:" + dbms + "://" + serverName + ":" + Integer.parseInt(portNumber) + ";",connectionProps);	    		
	    	}
	    } else if (dbms.equals("sqlserver") && protocol.equals("NamedPipes")) {
	         //Use JTDS for this, because sqljdbc doesn't work for NmaedPipes. Add plugin to Pom.xml
			 connectionProps.put("domain", domain);     
			 connectionProps.put("user", user);
			 connectionProps.put("password", password);         
			 //connectionProps.put("integratedSecurity","true");
			 Class.forName("net.sourceforge.jtds.jdbc.Driver");
			 //conn = DriverManager.getConnection("jdbc:jtds:sqlserver://" + "./RRSTestdata" + ";domain=RABODEVEU;namedPipe=true",connectionProps);
			 //Servername can be . meaning this machine. So don't mention the instance name, because the instance is determined based on the named pipe=sql/query. Jtds always assumes the pipe name is sql/query. Other values it can't handle!!!
	         conn = DriverManager.getConnection("jdbc:jtds:sqlserver://" + serverName + "/" + dbName + ";namedPipe=true;",connectionProps);
	         //Connection via TCP via jtds
	        //conn = DriverManager.getConnection("jdbc:jtds:sqlserver://" + "localhost:1433;" + ";domain=RABODEVEU;",connectionProps);
	    } else if (dbms.equals("sqlite")) {
	    	Class.forName("org.sqlite.JDBC");
	    	//conn = DriverManager.getConnection("jdbc:sqlite:C:\\mijn documenten\\Sqlite_test\\Sqlite_test\\test.db");
	    	conn = DriverManager.getConnection("jdbc:" + dbms + ":" + dbName,connectionProps);	    		
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
	
	public int sqlInsert(String query) throws SQLException{
	    
		ArrayList <String[]> result = new ArrayList<String[]>();
		Statement stmt;
		stmt = conn.createStatement();
		return stmt.executeUpdate( query );
	
	}

}