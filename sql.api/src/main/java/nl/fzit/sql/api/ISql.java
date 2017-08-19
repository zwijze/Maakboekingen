package nl.fzit.sql.api;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ISql {
				
	public void makeConnection(String dbms,String serverName,String portNumber,String protocol,String dbName,String domain,String user, String password) throws SQLException, ClassNotFoundException;
	
	public ArrayList<String[]> sqlQueryResult(String query) throws SQLException;
	
	public int sqlInsert(String query) throws SQLException;
	
}
