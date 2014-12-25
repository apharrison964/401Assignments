package a5tester;

import java.util.Iterator;

public class Main {
	public static void main(String[] args){
		
		/*
		 * All tests run by this script are taken
		 * directly from requirements outlined at:
		 * http://www.cs.unc.edu/~kmp/comp401fall14/assignments/a5.html
		 */
		
		/*
		 * boolean verbose=false;
		 * 
		 * Change this to enable verbose output,
		 * i.e. show all tests even if they pass
		 */
		boolean verbose=false;
		
		
		Tester noviceTester = new NoviceTester();
		ErrorLog noviceLog = new ErrorLog();
		
		Tester adeptTester = new AdeptTester();
		ErrorLog adeptLog = new ErrorLog();
		
		Tester jediTester = new JediTester();
		ErrorLog jediLog = new ErrorLog();
		
		int loop=0;
		while (loop<3){
			try {
				switch (loop){
				case 0:
					noviceLog = noviceTester.run("novice");
					adeptLog = adeptTester.run("novice");
					jediLog = jediTester.run("novice");
					break;
				case 1:
					adeptLog.addAll(adeptTester.run("adept"));
					jediLog.addAll(jediTester.run("adept"));
					break;
				case 2:
					jediLog.addAll(jediTester.run("jedi"));
				default:
					break;
				}
			}
			catch (Exception e){
				System.out.println("unexpected exception, aborting.");
				e.printStackTrace();
			}
			loop++;
		}
		Object[][] logs={
				new Object[]{"novice",noviceLog},
				new Object[]{"adept",adeptLog},
				new Object[]{"jedi",jediLog}
		};
		
		for (Object[] log:logs){
			System.out.printf("Errors in a5%s: %d\n", (String)log[0], ((ErrorLog)log[1]).numErrors());
			Iterator<String> iterator=((ErrorLog)log[1]).outputIterator(verbose);
			while (iterator.hasNext()){
				System.out.println(iterator.next());
			}
		}
	}
	
}
