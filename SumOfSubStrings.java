import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
	public static void main (String[] args) {
                      // Your code here
					  Scanner inp = new Scanner(System.in);
					  String s = inp.next();
					  int l = s.length();
					  long modulo = 1000000007;
					  long sum = Character.getNumericValue(s.charAt(0));
					  long prev = sum;
					  for (int i=1;i<l;i++){
						  long num = Character.getNumericValue(s.charAt(i));
						  prev = ((num*(i+1))+(10*prev))%modulo;
						  sum  = (sum + prev)%modulo;;
					  }
					  System.out.println(sum);
	}
}
