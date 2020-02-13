import java.io.*;
import java.util.*;
import java.lang.*;

public class ReadNetBenefit {
	
	private IntQueueImpl<Integer> queue1 = new IntQueueImpl<Integer>();
	private IntQueueImpl<Integer> queue2 = new IntQueueImpl<Integer>();
	
	 public void loadFile(String data) {
		int counter = 0;	
        File f = null;
        BufferedReader reader = null;
		String line;
		int quantity = 0;
		int total = 0;
		int sold = 0;
		int quantityCheck = 0;
	
        try {
            f = new File(data);
        } catch (NullPointerException e) {
            System.err.println("File not found.");
        }

        try {
            reader = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            System.err.println("Error opening file!");
        }

        try {
			line = reader.readLine();  
			while(line != null){
				if((line.trim().toUpperCase().startsWith("BUY"))) {
					String[] splited = line.split(" ");
					String part1 = splited[0];
					int buy = Integer.parseInt(splited[1]);
					String part3 = splited[2];
					int price = Integer.parseInt(splited[3]);
					queue1.put(buy);
					queue2.put(price);
					quantityCheck += buy;
					line = reader.readLine();
				} else if ((line.trim().toUpperCase().startsWith("SELL"))) {
					String[] splited = line.split(" ");
					String part1 = splited[0];
					int sell = Integer.parseInt(splited[1]);
					String part3 = splited[2];
					int price = Integer.parseInt(splited[3]);
					while(quantity != sell) {
						if (quantityCheck < sell) {
							System.out.println("METOXES: "+ quantityCheck +"\nSELL: "+sell);
							System.out.println("Not enough metoxes to sell !!!");
							System.exit(0);
						}
						if ((quantity + queue1.peek()) <= sell) {
							int q = queue1.get();
							int s = queue2.get();
							quantity += q;
							total += (q * (price - s));
							counter++;
						} else {
							int q = queue1.get();
							int s = queue2.get();
							int dif = (quantity + q) - sell;
							quantity += (q - dif);
							total += ((q - dif) * (price - s));
							queue1.put(dif);
							queue2.put(s);
						}
					}
					quantityCheck -= quantity;
					quantity = 0;
					line = reader.readLine();
				}
			}//while
			if (total >= 0) {
				System.out.println("\nTotal Profit : "+total);
			} else {
				System.out.println("\nTotal Damage : "+ total);
			}
							
								


        } catch (IOException e) {
            System.out.println("Error reading line " + counter + ".");
        }

        try {
            reader.close();
        } catch (IOException e) {
            System.err.println("Error closing file.");
        }
    }
}

