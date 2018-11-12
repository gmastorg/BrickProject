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
public class Voids 
{
    private String Name;
    private double length;
    private double width;

    /**
     * Constructor
     * @param len The length of the rectangle
     * @param wid The width of the rectangle
     */
    
    public Voids(String name, double len, double wid)
    {
        Name = name;
        length = len;
        width = wid;
    }
    
    
    /**
     * The setLength method stores a value in the length field
     * @param len The value to store in length
     */    
    public void setName(String name)
    {
        Name = name;
    }
    
    public void setLength(double len)
    {
        length = len;
    } 
    
    /**
     * The setWidth method stores a value in the width field
     * @param wid The value to store in width
     */    
    public void setWidth(double wid)
    {
        width = wid;
    }
    
    public String getName()
    {
        return Name;
    }
    /**
     * The getLength method returns the length of a void
     * @return The value in the length field
     */    
    public double getLength()
    {
        return length;
    }
    
    /**
     * The getWidth method returns the width of a void
     * @return The value in the width field
     */        
    public double getWidth()
    {
        return width;
    }
    
    /**
     * The getArea method returns the area of a void
     * @return The product of length times width
     */    
    public double getArea()
    {
        return length * width;
    }
}
