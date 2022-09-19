package com.luv2code.practice;
public class IsAnagram
{    
    //Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String a,String b)
    {
        if(a.length() != b.length()){
            return false;
        }
        
        char[] charAs = a.toCharArray();
        int i=0;
        while(i < charAs.length){
        String replaceTo=Character.toString(charAs[i]);
         System.out.println("e :: "+replaceTo);
         b = b.replaceFirst(replaceTo ,"");
         System.out.println("b :: "+b);
         i++;
        }
        
        // System.out.println(b.length());
        
        if(b.length() == 0){
            return true;
        }
        
        return false;
    }
    
    public static void main(String[] args) {
    	isAnagram("forgeeksgeeks", "geeksforgeeks");
		}
}