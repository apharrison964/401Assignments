package a5tester;

import java.util.ArrayList;
import java.util.Iterator;

class ErrorLog extends ArrayList<Object[]>{

	private int errors=0;
	
	public ErrorLog(){
		super();
	}
	
	public void addFromAssert(Object[] asserted){
		if (!(boolean)asserted[0])
			this.errors++;
		this.add(new Object[]{
				(boolean)asserted[0],
				(String)asserted[1]});
	}
	
	public boolean add(String string){
		
		return super.add(new Object[]{true, string});
		
	}
	
	public void addAll(ErrorLog log){
		
		this.errors+=log.numErrors();
		
		super.addAll(log);
		
	}
	
	public int numErrors(){
		
		return this.errors;
		
	}
	
	public Iterator<String> outputIterator(boolean verbose){
		
		return new ErrorIterator(this, verbose);
				
	}
}
