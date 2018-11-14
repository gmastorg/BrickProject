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
public abstract class Bricks {
    
    protected double LENGTH_ADB; 
    protected double WIDTH_ADB;
    protected double HEIGHT_ADB; 
    private double price_ADB; 
    protected double CONVERTFEET = 12; 
    protected String color_ADB; 
    
    /** Constructor 
     * @param len_ADB The length of the brick.
     * @param w_ADB the width of the brick. 
     * @param p_ADB the price of the brick. 
     */
    
    Bricks(double len_ADB, double w_ADB, double p_ADB,double h_ADB, String c_ADB)
    { 
        LENGTH_ADB = len_ADB; 
        HEIGHT_ADB = h_ADB; 
        WIDTH_ADB = w_ADB; 
        price_ADB = p_ADB; 
        color_ADB = c_ADB;  
        
    }

    public void setPrice (double p_ADB)
    {
        price_ADB = p_ADB; 
    }
    
    /* The setColor method stores a string in the color field. 
      @pram color_ADB 
    */
   public void setColor(String c_ADB) 
   { 
      color_ADB = c_ADB;
   }
      
    /**The getLength method returns the wall objects length. 
     * @return the value of LENGTH_ADB field
     */
    public double getLength() 
    {
        return LENGTH_ADB; 
    }
    
     /**The getHeight method returns the wall objects Height. 
     * @return the value of HEIGHT_ADB field
     */
    public double getHeight() 
    {
        return HEIGHT_ADB; 
    }
    
    /** The getWidth method returns the wall objects width.
     * @return  the value of the WIDTH_ADB field 
     */
    
    public double getWidth()
    { 
        return WIDTH_ADB;
    }
    
    /** The getWidth method returns the wall objects width.
     * @return  the value of the WIDTH_ADB field 
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
        return LENGTH_ADB * WIDTH_ADB; 
    }
    
    /**The getsqftArea method return the brick object area in feet. 
     * 
     * @return the product of length times 12 inches, and 
     */
   public double getsqftArea() 
   { 
       return (LENGTH_ADB/CONVERTFEET) * (WIDTH_ADB/CONVERTFEET);
   }
   
   public String getColor() 
   { 
       return (color_ADB);
   }
          
          
}
   
