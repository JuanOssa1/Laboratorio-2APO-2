package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.Club;
import model.Holding;
import model.NoPrameterFoundedException;


class testHolding {
	private Holding hol;

	public void setBinayScene() {
		//hol.addClub("xss", "ssss", "ssss", "ssddd");
		Club clubp = new Club("xss", "ssss", "ssss", "ssddd");
		try {
			ArrayList<Club> clubvip = new ArrayList<Club>();
			clubvip.add(clubp);
			hol.setClubs(clubvip);
			
			hol.searchClubToAdOwner("xss", "1006230587", "Juan", "ossa", "12/12/12");
			hol.searchClubToAdOwner("xss", "1006230588", "Juan", "ossa", "12/12/12");
			hol.searchClubToAdOwner("xss", "1006230589", "Juan", "ossa", "12/12/12");
			hol.searchClubToAdOwner("xss", "1006230590", "Juan", "ossa", "12/12/12");
			hol.searchClubToAdOwner("xss", "1006230591", "Juan", "ossa", "12/12/12");
			hol.searchClubToAdOwner("xss", "1006230592", "Juan", "ossa", "12/12/12");
			hol.searchClubToAdOwner("xss", "1006230593", "Juan", "ossa", "12/12/12");
			hol.searchClubToAdOwner("xss", "1006230594", "Juan", "ossa", "12/12/12");
			hol.searchClubToAdOwner("xss", "1006230595", "Juan", "ossa", "12/12/12");
			hol.searchClubToAdOwner("xss", "1006230596", "Juan", "ossa", "12/12/12");
			hol.searchClubToAdOwner("xss", "1006230597", "Juan", "ossa", "12/12/12");
		} catch (NoPrameterFoundedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void binaRyTest(){
		setBinayScene();
		hol.binarySearchingById("1006230587");
		assertEquals(1006230587, hol.binarySearchingById("1006230587"));
	}

}
