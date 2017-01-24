package nl.fzit.sql.api;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ISql {

	public ISql makeConnection(String dbms,String serverName,String portNumber,String dbName,String user, String password) throws SQLException, ClassNotFoundException;
	
	public ArrayList <String[]> sqlQueryResult(String query) throws SQLException;
	
}
