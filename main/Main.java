/*
created by chamois gihub: github.com/chamoisthefirst; discord: chamoisthefirst

log:
OCT 22nd 2024: started
OCT 26 2024: fixed issue with key
*/

package main;

import java.util.Scanner;

public class Main { 
	public static void main(String[] args) {
		
		Key key = new Key("");
		
		String[] KEY = key.apply();
		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter a key");
		String nk = scanner.nextLine();
		key.reset(nk);
		
		System.out.println("Key:"+key.name+"\n\ncommands:\n  e [message] to encode\n  d [message] to decode encoded message\n  _resetKey [new key] to change key\n  _showKey to show key\n  _fullKey to show code version of key\n\nwaiting for command");
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
				if(key.name.equals("")) {
					System.out.println("No key applied");
				}else {
					System.out.println("Key: "+key.name);
				}
			}
			if(message.startsWith("_fullKey")) {
				System.out.print("KEY: {\n");
				for(String i: KEY) {
					System.out.println("    "+i);
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
