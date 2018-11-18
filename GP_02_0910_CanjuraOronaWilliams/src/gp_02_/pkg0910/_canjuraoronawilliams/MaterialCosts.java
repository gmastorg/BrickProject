package gp_02_.pkg0910._canjuraoronawilliams;


public class MaterialCosts 
{
    
    public static double pricePerBag = 11.10;
    
    
    public static int getBagsOfMortar(int bricks)
    { 
        int bagOfMortar = 1;
        
        if (bricks%142 != 0)
        {
            bagOfMortar = bricks/142;
            
            bagOfMortar += 1;
            
            return bagOfMortar;       
        }
        
        if ((bricks/142) <= 0)
        {
            bagOfMortar = 1;
            
            return bagOfMortar;
        }
        
        return bagOfMortar;
    }
    
    public static double getMortarPrice(int totalBricks)
    {
        System.out.println(totalBricks);
        
        double totalBags = getBagsOfMortar(totalBricks);
        System.out.println(totalBags);
        
        double mortarCost = totalBags * pricePerBag;
        return mortarCost;
    }
    
    public static double costs(Bricks brick, int bricks)
    {
        int numOfPallets;
        double remBricks;
        double regCostBricks;
        double cost;
        
        System.out.println(brick.getBrickCost());
        if (bricks >= 2500)
        {
             numOfPallets = bricks/500;
             remBricks = bricks%500;
             
             regCostBricks = remBricks*brick.getBrickCost();
             
             if (regCostBricks >= (brick.getPalletCost()*.9))
             {
                 cost = (numOfPallets+1)*brick.getPalletCost()*.9;
                 
                 return cost;
             }
             else
             {
                 cost = (numOfPallets*brick.getPalletCost()*.9)+regCostBricks;
                 return cost;
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
                 return cost;
             }
             else
             {
                 cost = (numOfPallets*brick.getPalletCost())+regCostBricks;
                 return cost;
             }
        }
        else
        {
            regCostBricks = bricks*brick.getBrickCost();
            
            if (regCostBricks >= brick.getPalletCost())
            {
                cost = brick.getPalletCost();
                return cost;
            }
            
            else
            {
                cost = regCostBricks;
                return cost;
            }
        }
    }
    
    public static double [] getDiscount()
    {
        
        double brickDisc=0;
        double mortarDisc=0;
        int discChoice = 0;
        
        while (discChoice !=2)
        {
            discChoice = InputValidation.validateMenu(StandardMessages.DiscountMenu(), 2);
                
            if (discChoice == 1)
            {
                int discType = InputValidation.validateMenu(StandardMessages.DiscountTypeMenu(), 2);
            
                if (discType == 1)
                {
                    brickDisc = InputValidation.validateDouble(StandardMessages.Discount());
                    mortarDisc = 0;
                }
                if (discType == 2)
                {
                    mortarDisc = InputValidation.validateDouble(StandardMessages.Discount());
                    brickDisc = 0;
                }
            }
            else
            {
                brickDisc = 0;
                mortarDisc = 0;
            }
        }
        double [] discounts = {1-brickDisc, 1-mortarDisc};
        
        return discounts;
    }
}
