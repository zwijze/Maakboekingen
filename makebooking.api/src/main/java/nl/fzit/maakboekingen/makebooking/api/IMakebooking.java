package nl.fzit.maakboekingen.makebooking.api;

import java.sql.SQLException;
import java.util.ArrayList;

import nl.fzit.sql.api.*;

public interface IMakebooking {

	public void test();
	public void test2(ArrayList<String[]> xyz);

	
	public void insertBookingLines(ISql sql,ArrayList<String[]> bookingLines) throws SQLException;
	
	
}
