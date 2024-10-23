package main;

import java.util.Scanner;

public class Main { 
	public static void main(String[] args) {
		
		Key key = new Key("hello world");
		
		String[] KEY = key.apply();
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a message");
		while(true) {
			String message = scanner.nextLine();
			boolean encode = message.startsWith("encode");
			boolean decode = message.startsWith("decode");
			boolean reset = message.startsWith("reset");
			
			if(message.startsWith("e ")) {
				System.out.println(encode(message.substring(2), KEY));
			}
			if(message.startsWith("d ")) {
				System.out.println(decode(message.substring(2), KEY));
			}
			if(message.startsWith("_resetKey ")) {
				key.reset(message.substring(2));
				KEY = key.apply();
				System.out.println("key set to '"+message.substring(10)+"'");
			}
			if(message.startsWith("_showKey")) {
				System.out.println("Key: "+key.name);
			}
			if(message.startsWith("_fullKey")) {
				System.out.print("KEY: {");
				for(String i: KEY) {
					System.out.print(","+i);
				}
				System.out.println("}");
			}
		}
		
	}
	
	
	 static String encode(String message, String[] key) {
		 String out = "";

		 
		 for(String i: message.split("")) {
			 for(int j = 0; j < key.length; j++) {
				 for(int k = 0; k < key[j].length(); k++) {
					 String[] J = key[j].split("");
					 String curChar = J[k];
					 if(i.equals(curChar)) {
						 out+=""+j;
						 out+=key[j].charAt(key[j].length()-k-1);
					 }
				 }
			 }
		 }
		 return out;
	}
	 
	static String decode(String message, String[] key) {
		String out = "";
		
		for(int i = 0; i < message.length(); i+=2) {
			int j = (int)message.charAt(i);
			j -= 48;
			
			for(int k = 0; k < key[j].length(); k++) {
				if(key[j].charAt(k) == message.charAt(i+1)) {
					out+=key[j].charAt(key[j].length()-k-1);
				}
			}
		}
		
		return out;
	}

}
