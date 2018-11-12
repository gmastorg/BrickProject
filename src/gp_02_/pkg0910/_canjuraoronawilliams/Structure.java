/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gp_02_.pkg0910._canjuraoronawilliams;

/**
 *
 * @author gmastorg
 */
public class Structure 
{
    private double structureLength; 
    private double structureHeight;
    private double structureWidth;
    
    public Structure (double len, double height, double width)
    {
        structureLength = len;
        structureHeight = height;
        structureWidth = width;            
    }
    
    public void setstructureLength(double len)
    {
        structureLength = len;
    }
    
    public void setstructureWidth(double width)
    {
        structureWidth = width;
    }
    
    public void setstructureHeight(double height)
    {
        structureHeight = height;
    } 
    
    public double getLength()
    {
        return structureLength;
    }
    
    public double getWidth()
    {
        return structureWidth;
    }
    
    public double getHeight()
    {
        return structureHeight;
    }
    
    public double calculateSurfaceArea(Bricks brick)
    {        
       double [] brickSizeFeetWMortar = brick.convertToFeetAddMortar();
        
       double totalLength = ((structureLength +(2*brickSizeFeetWMortar[2]))*structureHeight);
             
       double totalWidth = structureWidth*structureHeight;

       double structureSurfaceArea = (totalLength + totalWidth)*2;
       
       return structureSurfaceArea;
    }
}
    

