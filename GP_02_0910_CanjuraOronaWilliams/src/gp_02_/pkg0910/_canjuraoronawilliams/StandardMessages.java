/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gp_02_.pkg0910._canjuraoronawilliams;

public class StandardMessages 
{
    public static String MainMenu()
    {
        String menu = "1.Begin\n2.Exit";
        
        return menu;
    }
    
    public static String StructMenu()
    {
        String menu = "1.Get bricks for a wall\n2.Get bricks for a "
                    + "structure";
        
        return menu;
    }
    
    public static String Walls()
    {
        String walls = "How many walls are you covering?\n";
        
        return walls;
    }
    
    public static String Length()
    {
        String length = "Enter the length in feet:\n";
        
        return length;
    }
    
    public static String Width()
    {
        String width = "Enter the width feet:\n";
        
        return width;
    }
    
    public static String Height()
    {
        String height = "Enter the height in feet:\n";
        
        return height;
    }
    
    public static String Doors()
    {
        String doors = "How many doors would you like to enter?\n";
        
        return doors;
    }
    
    public static String Windows()
    {
        String windows = "How many windows would you like to enter?\n";
        
        return windows;
    } 

    public static String BrickMenu()
    {
        String menu = "Choose a style of Brick:\n1.Extruded\n2.Sand Molded"
                + "\n3.Hand Molded";
        
        return menu;
    } 
    
    public static String DiscountMenu()
    {
        String menu = "Do you qualify for any discounts?\n1.Yes\n2.No";
        
        return menu;
    } 
    
    public static String DiscountTypeMenu()
    {
        String menu = "What is your discount for?\n1.Bricks\n2.Mortar";
        
        return menu;
    }
    
    public static String Discount()
    {
        String discount = "How much is your discount for?";
        
        return discount;
    }
}
