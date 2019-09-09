package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.Club;
import model.Holding;
import model.NoPrameterFoundedException;


class testHolding {
	private Holding hol;
	ArrayList<Club> clubvip = new ArrayList<Club>();

	public void setBinayScene() {
		
			Club clubp = new Club("1231231", "12312313", "1231231", "12313");
			Club clubp1 = new Club("1231232", "1231232", "1231232", "1231232");
			Club clubp2 = new Club("1231233", "1231233", "1231233", "1231233");
			Club clubp3 = new Club("1231234", "1231234", "1231234", "1231234");
			Club clubp4 = new Club("1231235", "1231235", "1231235", "1231235");
			Club clubp5 = new Club("1231236", "1231236", "1231236", "1231236");
			Club clubp6 = new Club("1231237", "1231237", "1231237", "1231237");
			Club clubp7 = new Club("1231238", "1231238", "1231238", "1231238");
			clubvip.add(clubp);
			clubvip.add(clubp1);
			clubvip.add(clubp2);
			clubvip.add(clubp3);
			clubvip.add(clubp4);
			clubvip.add(clubp5);
			clubvip.add(clubp6);
			clubvip.add(clubp7);
//			hol.searchClubToAdOwner("xss", "1006230587", "Juan", "ossa", "12/12/12");
//			hol.searchClubToAdOwner("xss", "1006230588", "Juan", "ossa", "12/12/12");
//			hol.searchClubToAdOwner("xss", "1006230589", "Juan", "ossa", "12/12/12");
//			hol.searchClubToAdOwner("xss", "1006230590", "Juan", "ossa", "12/12/12");
//			hol.searchClubToAdOwner("xss", "1006230591", "Juan", "ossa", "12/12/12");
//			hol.searchClubToAdOwner("xss", "1006230592", "Juan", "ossa", "12/12/12");
//			hol.searchClubToAdOwner("xss", "1006230593", "Juan", "ossa", "12/12/12");
//			hol.searchClubToAdOwner("xss", "1006230594", "Juan", "ossa", "12/12/12");
//			hol.searchClubToAdOwner("xss", "1006230595", "Juan", "ossa", "12/12/12");
//			hol.searchClubToAdOwner("xss", "1006230596", "Juan", "ossa", "12/12/12");
//			hol.searchClubToAdOwner("xss", "1006230597", "Juan", "ossa", "12/12/12");

		
		
	}
	
	
	private  String binarySearchingById(String id){
		String clubInfo = ""; 
		boolean finded = false;
		int startAt = 0;
		int deadAt = clubvip.size()-1; 
		while((startAt <= deadAt) && finded == false) {
			int mediumValue = (startAt + deadAt)/2; 
			if(clubvip.get(mediumValue).getId().equals(id)) {
				clubInfo = clubvip.get(mediumValue).toString();
			}
			else if(clubvip.get(mediumValue).compareClubWithId(id)>0) {
				deadAt = mediumValue -1;
			}
			else{
				startAt = mediumValue+1;
			}
		}
		
		return clubInfo;
	}
	@Test
	public void binaRyTest(){
		setBinayScene();
		binarySearchingById("1231233");
		assertEquals(1231233, binarySearchingById("1231233"));
	}

}
