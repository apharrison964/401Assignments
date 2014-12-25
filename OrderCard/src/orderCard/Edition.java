package orderCard;

public class Edition {

	private static int[] editionCheck;
	private static int edition;

	public Edition (int edition) {
		edition = editionCheck[edition];
		Edition.edition = edition;
	}

	public static int getEdition(int check) throws EditionException {
		check = edition;
		if(editionCheck.length < 4){
			throw new EditionException();
		}else if(editionCheck.length > 4){
			throw new EditionException();
		}else if(editionCheck.length != 4){
			throw new EditionException();
		}else{
			return edition;
		}
	}


}


