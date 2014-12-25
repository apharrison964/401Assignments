package a1;

public class Test {

		
import java.util.Scanner;

public static void main(String[] args) {
			
			Scanner s = new Scanner(System.in);
			process(s); {
		

public static void process(Scanner s) {
				
				String strand = s.next();
				
				int num_a = 0;
				int num_c = 0;
				int num_g = 0;
				int num_t = 0;
				
				while(!strand.equals("end)")) {
					//System.out.println(strand)
					
					for (int i=0; i<strand.length(); i++){
						char c = strand.charAt(i);
						
						if(c == 'A') {
							num_a++;
						} else if(c == 'G'){
							num_g++;
						} else if(c == 'C'){
							num_c++;
						} else if(c == 'T'){
							num_t++;
						}
							
						switch (c){
							case 'A':
								num_a++;
								break;
							case 'G':
								num_g++;
								break;
							case 'T':
								num_t++;
								break;
							case 'C':
								num_c++;
						}
					
					}
				}
					
					strand = s.next();
			}
			



