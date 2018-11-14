package gp_02_.pkg0910._canjuraoronawilliams;


public class Mortar {
    
    public static double pricePerBag = 11.10;
    
    
    public static double getBagsOfMortar(int bricks){
        
        double bagOfMortar = bricks/142;
        
        return bagOfMortar;
    }
    
    public static double getMortarPrice(double totalBags){
        
        double mortarCost = totalBags * pricePerBag;
        return mortarCost;
    }
    
}
