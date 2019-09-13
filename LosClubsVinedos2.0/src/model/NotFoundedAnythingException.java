package model;

public class NotFoundedAnythingException extends Exception {
	public NotFoundedAnythingException(String estavacioperdon){
		super(estavacioperdon); 
	}
}