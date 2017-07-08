package Assignment2;
import java.io.*;
import java.util.*;

public class Benford {
	
	private List<Integer> count = new ArrayList<>(Arrays.asList(0,0,0,0,0,0,0,0,0,0));
	
	
	public Benford() {
		// TODO Auto-generated constructor stub
	}
	
	public Benford(List<Integer> count){
		this.count = count;
	}

	public List<Integer> readCounts(Scanner in)
							throws FileNotFoundException{
		
		while (in.hasNext()){
			int n = firstDigitInString(in.next());
			//int x = first(n);
			//count.add(x);
			count.set(n, count.get(n)+1);
		}
	    return count;
	} 

	public int firstDigitInString (String token){
		for (char ch: token.toCharArray()){//Takes the first digit in the token
			if (ch>= '1'&& ch <= '9'){
				return ch - '0';
			}
		} return 0;
	}
	
	/*public static double first(int n){
		double result = Math.abs(n);//return the first digit
		while (result >= 10){
			result = result/10.0;
		}
		return result;
	}*/
	
	public double totalPop(){
		double sum = 0;
		for (int i: count){
			sum += i;
		}
		return sum;
	}
	
	public double[] benfordPercents(){
		double[] benfordPercents = new double[10];
		for (int i = 0; i < count.size(); i++){
			benfordPercents[i] = (count.get(i)*100.0)/totalPop();
		}
		return benfordPercents;
	}
	
}
