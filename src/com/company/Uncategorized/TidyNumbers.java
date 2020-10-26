package com.company.Uncategorized;
public class TidyNumbers {
    int maxTidyNumber(int n){
        String number=Integer.toString(n);
        int i=1;
        for(i=1;i<number.length();i++){
                if(number.charAt(i-1)>number.charAt(i)){
                    char j=(char)(number.charAt(i-1)-1);
                    number=number.replace(number.charAt(i-1),j);
                    break;
                }
        }
        for(;i<number.length();i++){
            number=number.replace(number.charAt(i),'9');
        }

        return Integer.parseInt(number);
    }

    public static void main(String[] args) {
        TidyNumbers t=new TidyNumbers();
        System.out.println(t.maxTidyNumber(5123));
    }
}
