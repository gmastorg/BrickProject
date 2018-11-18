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
public class SandBrick extends Bricks
{
    SandBrick(double len_ADB, double w_ADB, double p_ADB,double h_ADB)
    { 
        super(len_ADB, w_ADB, p_ADB, h_ADB);
        price_ADB = .71;
    }
    
    public double getBrickCost()
    { 
        return price_ADB;
    }
    
    public double [] convertToFeetAddMortar()
    {        
        double brickFeetLength = (LENGTH_ADB/12)+(.375/12);
        double brickFeetHeight = (HEIGHT_ADB/12)+(.375/12);
        double brickFeetWidth = (WIDTH_ADB/12);  
        
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
    
    public double getTotalBricks(double voidsArea, Bricks brick,double wallTotalarea_ADB)
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
            bricksWithExtra = (double)(bricks+1);

        return bricksWithExtra;       
    }
}
