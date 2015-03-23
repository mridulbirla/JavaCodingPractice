package com.mridul.birla.codinginterview;

public class Problem1_1 {
	
	
	String getuser_input(String arg[]){
		
		return arg[0];
	}
	
	Boolean isStringUnique(String str){
		
		String lowercase_string= str.toLowerCase();
		int check_flag=0;
		for(int i=0;i<lowercase_string.length();i++){
			int val=lowercase_string.charAt(i)-'a';
			if((check_flag & (1<<val))>0){
				return false;
			}else{
				check_flag|=(1<<val);
			}
		}
		return true;
	}
	
	public static void main(String args[]){
		
		Problem1_1 p= new Problem1_1();
		
		String input_string= p.getuser_input(args);
		
		if(input_string.length()==0){
			System.out.println("String passed is having length zero");
		}
		else{
			Boolean result=p.isStringUnique(input_string);
			
			if(result)
				System.out.println("Yes String: '"+input_string+"' has all character Unique");
			else
				System.out.println("No String: '"+input_string +"' does not contain unique character");
			
			
			
		}
	}
	
	

}
