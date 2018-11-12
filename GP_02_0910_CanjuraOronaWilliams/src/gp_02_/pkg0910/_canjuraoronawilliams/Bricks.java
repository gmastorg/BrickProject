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
public class Bricks 
{
    private double brickLength; 
    private double brickHeight;
    private double brickWidth;
    private double brickCost;
    
    public Bricks (double len, double height, double width, double cost)
    {
        brickLength = len;
        brickHeight = height;
        brickWidth = width;
        brickCost = cost;        
               
    }
    public void setbrickLength(double len)
    {
        brickLength = len;
    }
    
    public void setbrickWidth(double width)
    {
        brickWidth = width;
    }
    
    public void setbrickHeight(double height)
    {
        brickHeight = height;
    } 
    
    public void setbrickCost(double cost)
    {
        brickCost = cost;
    }
    
    public double getbrickLength()
    {
        return brickLength;
    }
    
    public double getbrickWidth()
    {
        return brickWidth;
    }
    
    public double getbrickHeight()
    {
        return brickHeight;
    }
    
    public double getbrickCost()
    {
        return brickCost;
    }
    public double [] convertToFeetAddMortar()
    {        
        double brickFeetLength = (brickLength/12)+(.375/12);
        double brickFeetHeight = (brickHeight/12)+(.375/12);
        double brickFeetWidth = (brickWidth/12);  
        
        double [] brickSizeFeetWMortar = {brickFeetLength, brickFeetHeight, brickFeetWidth};
        
        return brickSizeFeetWMortar;
    }
    
        public double getTotalBricks(double voidsArea, Bricks brick,Structure structure)
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
            bricksWithExtra = (double)(bricks+1);

        return bricksWithExtra;       
    }
}
