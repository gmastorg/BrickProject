/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gp_02_.pkg0910._canjuraoronawilliams;

/**
 *
 * @author Aaron
 */
public class HandMoldedBrick extends Bricks
{
    HandMoldedBrick(double len_ADB, double w_ADB, double p_ADB,double h_ADB,double palP_GMC)
    { 
        super(len_ADB, w_ADB, p_ADB, h_ADB, palP_GMC);
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
            bricks += 1;

        return bricks;       
    }
    
    @Override
    public double getTotalBricks(double voidsArea, Bricks brick, double wallTotalarea_ADB)
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
}
