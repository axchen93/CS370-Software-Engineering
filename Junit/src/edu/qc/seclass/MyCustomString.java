package edu.qc.seclass;

import java.util.*;

public class MyCustomString implements MyCustomStringInterface{

    private String currentString;
    private Map<Character, String> numToString;

    public MyCustomString(){
        currentString = null;
        numToString = new HashMap<Character, String>();
        setMap();

    }

    public MyCustomString(String s){
        currentString = s;
        numToString = new HashMap<Character, String>();
        setMap();
    }

    private void setMap(){
        numToString.put('0', "Zero");
        numToString.put('1', "One");
        numToString.put('2', "Two");
        numToString.put('3', "Three");
        numToString.put('4', "Four");
        numToString.put('5', "Five");
        numToString.put('6', "Six");
        numToString.put('7', "Seven");
        numToString.put('8', "Eight");
        numToString.put('9', "Nine");
    }

    public String getString(){
        return currentString;
    }

    public void setString(String string){
        currentString = string;
    }

    public int countNumbers() throws NullPointerException{
        if(currentString == null) throw new NullPointerException("String is empty");
        int count = 0;
        boolean onNumber = false;
        for(int i = 0; i<currentString.length(); i++){
            char x = currentString.charAt(i);
            if(x >= '0' && x<='9' && !onNumber){
                onNumber = true;
                count++;
            }
            if(onNumber && x < '0' || x>'9'){
                onNumber = false;

            }
        }
        return count;
    }

    public String getEveryNthCharacterFromBeginningOrEnd(int n, boolean startFromEnd) throws NullPointerException, IllegalArgumentException{
        if(n <= 0) throw new IllegalArgumentException("Illegal argument for n");
        if(currentString == null && n > 0) throw new NullPointerException("String is empty");
        if(currentString.length() < n) return "";

        StringBuilder str = new StringBuilder();
        if(!startFromEnd){
            for(int i = n-1; i<currentString.length(); i+=n) {
                char x = currentString.charAt(i);
                str.append(x);
            }
        }else{
            for(int i = currentString.length()-n; i>=0; i-=n){
                char x = currentString.charAt(i);
                str.insert(0,x);
            }
        }

        return str.toString();

    }

    public void convertDigitsToNamesInSubstring(int startPosition, int endPosition) throws IllegalArgumentException, NullPointerException, MyIndexOutOfBoundsException{
        if(startPosition > endPosition) throw new IllegalArgumentException("Illegal Arguments");
        if(currentString == null) throw new NullPointerException("Null pointer exception");
        if(startPosition < 0 || endPosition > currentString.length()) throw new MyIndexOutOfBoundsException("Index out of bound");

        StringBuilder str = new StringBuilder();
        str.append(currentString.substring(0,startPosition-1));

        for(int i = startPosition-1; i<endPosition; i++){
            char x = currentString.charAt(i);
            if(Character.isDigit(x))
                str.append(numToString.get(x));
            else
                str.append(x);

        }

        str.append(currentString.substring(endPosition, currentString.length()));

        currentString =  str.toString();
    }


}