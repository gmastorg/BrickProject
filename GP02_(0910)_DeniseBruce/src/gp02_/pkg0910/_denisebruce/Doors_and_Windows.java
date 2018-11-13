/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gp02_.pkg0910._denisebruce;

/**
 *
 * @author denise
 */
public class Doors_and_Windows {
      private double length_ADB; 
    private double width_ADB;
    
    /** Constructor 
     * @param len_ADB The length of the wall.
     * @param w_ADB the width of the wall. 
     */
    
    Doors_and_Windows (double len_ADB, double w_ADB)
    { 
        length_ADB = len_ADB; 
        width_ADB = w_ADB; 
        
    }
    
   /*The setLength method stores a value in the length field. 
    @param length_ADB 
    */ 
    
    public void  setLength(double len_ADB)
    {
     length_ADB = len_ADB; 
    }
    
    /*The setLength method stores a value in the length field. 
    @param length_ADB 
    */ 
    
    public void  setWidth(double w_ADB)
    {
     width_ADB = w_ADB; 
    }
    
    /**The getLength method returns the wall objects length. 
     * @return the value of length_ADB field
     */
    public double getLength() 
    {
        return length_ADB; 
    }
    
    /** The getWidth method returns the wall objects width.
     * @return  the value of the width_ADB field 
     */
    
    public double getWidth()
    { 
        return width_ADB;
    }
    
    /** The getArea method returns the wall objects area. 
     * @return the product of length times width. 
     */
    
    public double getArea ()
    {
        return length_ADB * width_ADB; 
    }
    
}

