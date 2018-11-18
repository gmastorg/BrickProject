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
        String mainMenu = "1.Get bricks for a wall\n2.Get bricks for a "
                    + "structure\n3.Exit";
        
        return mainMenu;
    }
    
    public static String Walls()
    {
        String walls = "How many walls are you covering?";
        
        return walls;
    }
    
    public static String Length()
    {
        String length = "Enter the length of the walls in feet: ";
        
        return length;
    }
    
    public static String Width()
    {
        String width = "Enter the width of the walls in feet: ";
        
        return width;
    }
    
    public static String Height()
    {
        String height = "Enter the height of the walls in feet: ";
        
        return height;
    }
    
    public static String Doors()
    {
        String doors = "How many doors would you like to enter?";
        
        return doors;
    }
    
    public static String Windows()
    {
        String windows = "How many windows would you like to enter?";
        
        return windows;
    } 

    public static String BrickMenu()
    {
        String menu = "Choose a style of Brick:\n1.Extruded\n2.Sand Molded"
                + "\n3.Hand Molded\n";
        
        return menu;
    } 
     
}
