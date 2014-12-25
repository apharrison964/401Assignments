package lec19.v07;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class CalculatorModel extends Observable {

	private List<Operation> history;
	private double value;

	public CalculatorModel() {
		history = new ArrayList<Operation>();
		value = 0.0;
	}

	public double getValue() {
		return value;
	}
	
	public void eval(Operation op) {
		history.add(op);
		
		switch (op.getType()) {
		case ADD:
			value += op.getOperand();
			break;
		case SUB:
			value -= op.getOperand();
			break;
		case MULT:
			value *= op.getOperand();
			break;
		case DIV:
			value /= op.getOperand();
			break;
		case SET:
			value = op.getOperand();
			break;
		}
		
		setChanged();
		notifyObservers(op);
	}
	
	public void reset() {
		history = new ArrayList<Operation>();
		value = 0.0;
	}
}
