package gp_02_.pkg0910._canjuraoronawilliams;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author canjurag4010
 */
 public abstract class Bricks 
 {
    public String Type_GMC; 
    protected double LENGTH_ADB; 
    protected double WIDTH_ADB;
    protected double HEIGHT_ADB; 
    protected double CONVERTFEET = 12; 
    public double price_ADB; 
    public double palletPrice_GMC;
    //protected String color_ADB; 
    
    /** Constructor 
     * @param len_ADB The length of the brick.
     * @param w_ADB the width of the brick. 
     * @param p_ADB the price of the brick. 
     */
    
    Bricks(String type, double p_ADB, double palP_GMC)
    { 
        Type_GMC = type;
        LENGTH_ADB = 8; 
        HEIGHT_ADB = 2; 
        WIDTH_ADB = 4; 
        price_ADB = p_ADB;   
        palletPrice_GMC = palP_GMC;
    }

    /** The setColor method stores a string in the color field. Not implemented
     * yet
    
      @pram color_ADB 
    **/
   
   /* 
   public void setColor(String c_ADB) 
   { 
      color_ADB = c_ADB;
   }
    */
    
    public String getBrickType()
    { 
        return Type_GMC;
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
        /** The getWidth method returns the brick objects cost.
     * @return  the value of the price_ADB field 
     */
    
   public abstract double getBrickCost();
    
    
   /** The getWidth method returns the brick objects pallet cost.
     * @return  the value of the palletPrice_GMC field 
     */
    public abstract double getPalletCost();

    
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
   
   public double [] convertToFeetAddMortar()
    {        
        double brickFeetLength = (LENGTH_ADB/12)+(.375/12);
        double brickFeetHeight = (HEIGHT_ADB/12)+(.375/12);
        double brickFeetWidth = (WIDTH_ADB/12);  
        
        double [] brickSizeFeetWMortar = {brickFeetLength, brickFeetHeight, brickFeetWidth};
        
        return brickSizeFeetWMortar;
    }
    
    public int getTotalBricks(double voidsArea, Bricks brick,Structure structure)
    {
        double brickArea;
        double numofBricks;
        double bricksWithExtra;
        double [] brickSizeFeetWMortar = brick.convertToFeetAddMortar();
        
        brickArea = brickSizeFeetWMortar[0] * brickSizeFeetWMortar[1];

        numofBricks = structure.calculateSurfaceArea(brick)/ brickArea;

        numofBricks = numofBricks -(voidsArea/brickArea);

        bricksWithExtra = numofBricks*1.05;
        
        int bricks = (int)(bricksWithExtra);      
        
        if (bricksWithExtra%bricks !=0)
        {
            bricks += 1;
        }
        
        return bricks;       
    }
    
    public int getTotalBricks(double voidsArea, Bricks brick,double wallTotalarea_ADB)
    {
        double brickArea;
        double numofBricks;
        double bricksWithExtra;
        double [] brickSizeFeetWMortar = brick.convertToFeetAddMortar();
        
        brickArea = brickSizeFeetWMortar[0] * brickSizeFeetWMortar[1];

        numofBricks = wallTotalarea_ADB/ brickArea;

        numofBricks = numofBricks -(voidsArea/brickArea);

        bricksWithExtra = numofBricks*1.05;
        
        int bricks = (int)(bricksWithExtra);      
        
        if (bricksWithExtra%bricks !=0)
        {
            bricks += 1;
        }
        
        return bricks;   
    }       
   /** Not yet implemented
   public String getColor() 
   { 
       return (color_ADB);
   }
   **/
    
}        
