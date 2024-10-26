/*
created by chamois gihub: github.com/chamoisthefirst; discord: chamoisthefirst
*/

package main;

public class Key {
	
	String name = "key";
	
	Key(String name) {
		this.name = name;
	}
	
	void reset(String newKey) {
		name = newKey;
	}
	
	String[] apply () {
		String[] out = {"","","",""};
		String[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ`1234567890-=[]\\;',./ ~!@#$%^&*()_+{}|:\"<>?".split("");
		
		int j = 0;
		
		for(String i: chars) {
			
			if(name.contains(i)) {
				out[0]+=i;
			}else {
				out[j]+=i;
			}
			
			j++;
			if(j > 3) {
				j = 0;
			}
			
		}
		
		return out;
	}
	
	
}
