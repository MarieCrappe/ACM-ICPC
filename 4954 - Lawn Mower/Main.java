import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedInputStream is = new BufferedInputStream(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		BufferedOutputStream os = new BufferedOutputStream(System.out);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
		
		String s = br.readLine();
		
		while (!s.equals("0 0 0.0")) {
			
			String[] tokens = s.split(" ");
			
			int x = Integer.parseInt(tokens[0]);
			int y = Integer.parseInt(tokens[1]);
			double width = Double.parseDouble(tokens[2]);
			
			s = br.readLine();
			boolean result = check(s, x, width, 75.00);
			
			s = br.readLine();
			
			if (result == false){
				bw.write("NO");
				bw.newLine();
			} else {
				result = check(s, y, width, 100.00);
				if (result == false){
					bw.write("NO");
					bw.newLine();
				} else {
					bw.write("YES");
					bw.newLine();
				}
			}
		
			s = br.readLine();

		}
		
		bw.flush();
		bw.close();
			
	}
	
	public static boolean check(String input, int size, double width, double max) {
				
		double w = width/2;
		
		String[] ins = input.split(" ");
		double[] passes = new double[size];
		
		for (int i = 0; i < size; ++i) {
			passes[i] = Double.parseDouble(ins[i]); 
		}
		
		Arrays.sort(passes);
		
		if (passes[0] - w > 0) {
			return false;
		}
		
		for (int i = 0; i < size - 1; ++i) {
			if ( passes[i] + w < passes[i+1] - w) {
				return false;
			}	
		}
		
		if (passes[size-1] + w < max) {
			return false;
		} else {
			return true;
		}
		
	}
	

}
