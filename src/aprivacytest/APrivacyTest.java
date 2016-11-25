/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aprivacytest;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Léo Andéol
 */
public class APrivacyTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // INPUTS
        int n;
        Scanner sc = new Scanner(System.in);
        do
        {
           System.out.println("Enter the length of the array (1<= n <= 100) :");
           n = sc.nextInt();
        }while(n<1||n>100);
        int array[] = new int[n];
        boolean cont = true;
        while(cont)
        {
            sc = new Scanner(System.in);
            System.out.println("Enter all integers, separated by spaces");
            String input = sc.nextLine();
            String[] ints = input.split(" ");
            if(ints.length!=n)
            {
                System.out.println("You have to print n integers");
                continue;
            }
            for(int i = 0; i < n; i++)
            {
                int tmp = Integer.parseInt(ints[i]);
                if(Math.abs(tmp)>Math.pow(10, 4))
                {
                    System.out.println("-10pow4 <= ai <= 10pow4");
                    continue;
                }
                array[i]=tmp;
            }
            cont = false;
        }
        //COMPUTATION
        int count = 0;
        for(int start = 0; start < array.length-1; start++)
        {
            for(int len = 0; len < array.length; len++)
            {
                // actually useless here since copyOfRange fills with 0 the gaps
                if (start + len >= array.length) {
                    continue;
                }
                int sum = 0;
                int tmp[] = Arrays.copyOfRange(array, start, start + len + 1);
                for (int i = 0; i < tmp.length; i++) {
                    sum += tmp[i];
                }
                if (sum < 0) {
                    // Uncomment the two following lines to output explanation
                    //int v = start + len;
                    //System.out.println("[" + start + ";" + v + "] => " + sum);
                    count++;
                }
            }
        }
        //OUTPUT
        System.out.println("The number of negative subarrays is : "+count);
    }
    
}
