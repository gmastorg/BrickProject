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
public class ExtrudedBrick extends Bricks
{
    ExtrudedBrick(String type, double p_ADB,double palP_GMC)
    { 
        super(type, p_ADB, palP_GMC);
        
        Type_GMC = "Extruded";
        price_ADB = .51;
        palletPrice_GMC = 400.00;
    }
    
        /** The getWidth method returns the brick objects cost.
     * @return  the value of the price_ADB field 
     */
    
    @Override
    public String getBrickType()
    { 
        return Type_GMC;
    }
    
    @Override
    public double getBrickCost()
    { 
        return price_ADB;
    }
    
   /** The getWidth method returns the brick objects pallet cost.
     * @return  the value of the palletPrice_GMC field 
     */
    @Override
    public double getPalletCost()
    {
        return palletPrice_GMC;
    }
}
