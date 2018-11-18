/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gp_02_.pkg0910._canjuraoronawilliams;

import java.util.Scanner;

/**
 *
 * @author gmastorg
 */
public class InputValidation 
{
    public static Scanner keyboard = new Scanner(System.in);
    
    
    public static int validateMenu(String text, int maxChoice)
    {
        String input;
        int choice = 0;
        boolean gateA = false;  
        
        while (gateA != true || choice<=0 || choice>maxChoice)
        {
            System.out.println(text);
            
            if (keyboard.hasNextInt())
            {
                input = keyboard.next();
                choice = Integer.parseInt(input);
                gateA = true;
            }
            else
            {
                input = keyboard.next();
            }
        } 
        
        return choice;
    }
     
    public static double validateDouble (String text)
    {
        String input;
        double dub = 0.0;
        boolean gateA = false;  
        
            while (gateA != true || dub<0)
            {
                System.out.print (text);
      
                if (keyboard.hasNextDouble())
                {
                    input = keyboard.next();
                    dub = Double.parseDouble(input);
                    gateA = true;
                }
                else
                {
                    input = keyboard.next();
                }
            }
            
            return dub;
    }
    
    public static int validateInteger (String text)
    {
        String input;
        int inte = 0;
        boolean gateA = false;  
        
            while (gateA != true || inte<0)
            {
                System.out.print (text);
      
                if (keyboard.hasNextInt())
                {
                    input = keyboard.next();
                    inte = Integer.parseInt(input);
                    gateA = true;
                }
                else
                {
                    input = keyboard.next();
                }
            }
            
            return inte;
    }
    
    
}
