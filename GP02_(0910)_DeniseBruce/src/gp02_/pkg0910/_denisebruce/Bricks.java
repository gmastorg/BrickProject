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
public class Bricks {
    
      private double length_ADB; 
    private double width_ADB;
    private double price_ADB; 
    private double CONVERTFEET = 12; 
    
    /** Constructor 
     * @param len_ADB The length of the brick.
     * @param w_ADB the width of the brick. 
     * @param p_ADB the price of the brick. 
     */
    
    Bricks(double len_ADB, double w_ADB, double p_ADB)
    { 
        length_ADB = len_ADB; 
        width_ADB = w_ADB; 
        price_ADB = p_ADB; 
        
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
    
    /*The setPrice method stores a value in the price field. 
    @ pram price_ADB 
    */
    public void setPrice (double p_ADB)
    {
        price_ADB = p_ADB; 
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
    
    /** The getWidth method returns the wall objects width.
     * @return  the value of the width_ADB field 
     */
    
    public double getPrice()
    { 
        return price_ADB;
    }
    
    /** The getArea method returns the wall objects area. 
     * @return the product of length times width. 
     */
    
    public double getArea ()
    {
        return length_ADB * width_ADB; 
    }
    
    /**The getsqftArea method return the brick object area in feet. 
     * 
     * @return the product of length times 12 inches, and 
     */
   public double getsqftArea() 
   { 
       return (length_ADB/CONVERTFEET) * (width_ADB/CONVERTFEET);
   }
   
  
          
          
}
   
