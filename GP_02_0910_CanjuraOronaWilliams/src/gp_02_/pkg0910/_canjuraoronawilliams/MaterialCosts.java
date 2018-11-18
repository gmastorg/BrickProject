package gp_02_.pkg0910._canjuraoronawilliams;


public class MaterialCosts 
{
    
    public static double pricePerBag = 11.10;
    
    
    public static double getBagsOfMortar(int bricks)
    {
        
        double bagOfMortar = bricks/142;
        
        return bagOfMortar;
    }
    
    public static double getMortarPrice(int bricks)
    {
        double totalBags = getBagsOfMortar(bricks);
        double mortarCost = totalBags * pricePerBag;
        return mortarCost;
    }
    
    public static double costs(Bricks brick, int bricks)
    {
        int numOfPallets;
        double remBricks;
        double regCostBricks;
        double cost = 0;
        
        if (bricks >= 2500)
        {
             numOfPallets = bricks/500;
             remBricks = bricks%500;
             
             regCostBricks = remBricks*brick.getBrickCost();
             
             if (regCostBricks >= (brick.getPalletCost()*.9))
             {
                 cost = (numOfPallets+1)*brick.getPalletCost()*.9;
             }
             else
             {
                 cost = (numOfPallets*brick.getPalletCost()*.9)+regCostBricks;
             }
        }
        else if (bricks >= 500)
        {
            numOfPallets = bricks/500;
            remBricks = bricks%500;
             
            regCostBricks = remBricks*brick.getBrickCost();
             
             if (regCostBricks >= brick.getPalletCost())
             {
                 cost = (numOfPallets+1)*brick.getPalletCost();
             }
             else
             {
                 cost = (numOfPallets*brick.getPalletCost())+regCostBricks;
             }
        }
        
        return cost;
    }
}
