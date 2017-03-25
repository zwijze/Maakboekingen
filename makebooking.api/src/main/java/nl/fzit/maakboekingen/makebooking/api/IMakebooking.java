package nl.fzit.maakboekingen.makebooking.api;

import java.util.ArrayList;

import nl.fzit.sql.api.*;

public interface IMakebooking {

	public void insertBookingLines(ISql sql,ArrayList<String[]> bookingLines);
	
	
}
