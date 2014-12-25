package lec8.ex1.v3;

public class ProfessorImpl extends PersonImpl implements Professor { // extends
																		// has
																		// to be
																		// before
																		// implements

	private Rank rank;

	public ProfessorImpl(String first, String last, String address) {
		super(first, last, address); // the very first line in a constructor
										// with a subclass must be chained
										// or you have to define the parent
										// class. Just do like the example
		rank = Rank.ASSISTANT;
	}

	public ProfessorImpl(String first, String last) {
		this(first, last, "Address Unknown");
	}

	public Rank getRank() {
		return rank;
	}

	public void promote() {
		switch (rank) {
		case ASSISTANT:
			rank = Rank.ASSOCIATE;
			break;
		case ASSOCIATE:
			rank = Rank.FULL;
			break;
		case FULL:
			// Can't go any higher than full.
		}
	}
}
