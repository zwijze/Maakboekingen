package nl.fzit.maakboekingen.makebooking.api;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IMakebooking {

	public void insertBookingLines(ArrayList<String[]> bookingLines) throws SQLException;
	
	
}
