package com.company.Backtracking;

public class PrintAllSubOfAString {
    void print(String input,String output){
        if(input.length()==0){
            System.out.println(output);
            return;
        }
        print(input.substring(1),output);
        print(input.substring(1),output+input.charAt(0));
    }

    public static void main(String[] args) {
        PrintAllSubOfAString p=new PrintAllSubOfAString();
        p.print("abc","");
    }
}
