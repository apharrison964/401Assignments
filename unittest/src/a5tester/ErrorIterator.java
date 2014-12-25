package a5tester;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class ErrorIterator implements Iterator<String>{
	
	private int position=0;
	private int size;
	private ErrorLog log;
	private boolean verbose;
	
	public ErrorIterator(ErrorLog log, boolean verbose){
		this.log=log;
		this.size=log.size();
		this.verbose=verbose;
	}
	
	public boolean hasNext(){
		if (this.verbose)
			return this.position!=this.size;
		int pos=this.position;
		while (pos<this.size){
			if (!(boolean)this.log.get(pos)[0]){
				this.position=pos;
				return true;
			}
			pos++;
		}
		return false;
	}
	
	public String next(){
		if (!this.hasNext())
			throw new NoSuchElementException();
		Object[] next_item=null;
		String result="";
		if (this.verbose){
			next_item=this.log.get(this.position++);
			result=(boolean)next_item[0]?"":"-> ";
		}
		else {
			int pos=this.position;
			while (pos<this.size){
				if (!(boolean)this.log.get(pos)[0]){
					next_item=this.log.get(this.position++);
					result=(boolean)next_item[0]?"":"-> ";
					break;
				}
				pos++;
			}
			this.position=pos+1;
		}
		return result+(String)next_item[1];
	}
	
	public void remove(){
		throw new UnsupportedOperationException();
	}
}
