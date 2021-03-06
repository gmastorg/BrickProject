/*09/26/2018
  CSC 251
  Brick Calculator
  Canjura_Orona_Williams_Villafan_Bruce_Henry
  calculates the number of bricks used to build a structure
*/
package gp_02_.pkg0910._canjuraoronawilliams;

import java.util.Scanner;
import java.util.ArrayList;

public class GP_02_0910_CanjuraOronaWilliams 
{
    public static Scanner keyboard = new Scanner(System.in);
 
    public static void main(String[] args) 
    {  
        int choice;  
        
        do
        {   
            choice = InputValidation.validateMenu(StandardMessages.MainMenu(), 3);
            if (choice == 1 )
            {
                int brickChoice = InputValidation.validateMenu(StandardMessages.BrickMenu(), 3);
                Bricks myBrick = getBricks(brickChoice);
                int structChoice = InputValidation.validateMenu(StandardMessages.StructMenu(), 2);
                getChosenMethods(structChoice, myBrick);
            }
            if (choice == 2)
            {
                executeGUI.launchEXE(); 
            }
        }
        while (choice != 3);
    }

    public static void getChosenMethods(int choice, Bricks myBrick)
    {
        if (choice == 1)
        {
            getWalls(myBrick);
        }
        if (choice == 2)
        {
            getStructure(myBrick); 
        }
    }
    
    public static void getWalls(Bricks myBrick)
    {   
        ArrayList<Voids> voids = new ArrayList<Voids>();
        ArrayList<ArrayList> allVoids = new ArrayList<ArrayList>();
        double totalProjectArea_ADB = 0; 
        double wallTotalarea_ADB = 0;
        double length;
        double width ;
        
        int wallNumber = InputValidation.validateInteger(StandardMessages.Walls());
 
        for(int wallnum = 0; wallnum <wallNumber; wallnum++)
        //User input for the length and width of the wall to be covered 
        {   
            int  aWall = wallnum + 1;
            System.out.println ( "Enter Dimensions for Wall   "+  aWall);  
            
            length = InputValidation.validateDouble(StandardMessages.Length());
            
            width = InputValidation.validateDouble(StandardMessages.Width());
                  
            Walls myWall = new Walls (length, width);
            
            voids = getVoids();
            
            allVoids.add(voids);
            
            wallTotalarea_ADB += myWall.getArea();  
        } 
       
        // Total area of the voids aka Doors and windows 
        double voidTotalarea_ADB = getVoidAreaWall(allVoids);
        totalProjectArea_ADB =  (wallTotalarea_ADB - voidTotalarea_ADB); 
        getCost(allVoids, voidTotalarea_ADB, myBrick, totalProjectArea_ADB);   
       
    }
    
    public static void getStructure(Bricks myBrick)
    {
        double length;
        double height;
        double width;
        
        length = InputValidation.validateDouble(StandardMessages.Length());
            
        width = InputValidation.validateDouble(StandardMessages.Width()); 
        
        height = InputValidation.validateDouble(StandardMessages.Height()); 
                   
        Structure structure = new Structure(length, height, width);
            
        ArrayList<Voids> voids = new ArrayList<Voids>();

        voids = getVoids();
        double voidsArea = getVoidArea(voids);
        getCost(voids,voidsArea,myBrick,structure);    
     
    }
    
    public static ArrayList<Voids> getVoids()
    {
        int doors;
        double length;
        double width ;
        int windows;
        
        doors = InputValidation.validateInteger(StandardMessages.Doors());
                
        ArrayList<Voids> voids = new ArrayList<Voids>();
       
        for (int i=0; i<doors; i++)
        {
            String name = "Door";

            length = InputValidation.validateDouble(StandardMessages.Length());

            width = InputValidation.validateDouble(StandardMessages.Width());  

            voids.add(new Voids(name,length, width));
        }
       
        
        windows = InputValidation.validateInteger(StandardMessages.Windows());
        
         for (int i=0; i<windows; i++)
        {
            String name = "Window";

            //collects windows dimensions and assigns them to an object
            length = InputValidation.validateDouble(StandardMessages.Length());

            width = InputValidation.validateDouble(StandardMessages.Width());   

            voids.add(new Voids(name,length, width));
        }
        
        return voids;
    }
    
    public static double getVoidAreaWall(ArrayList<ArrayList> allVoids)
    {
        ArrayList<Voids> voids = new ArrayList<Voids>();
        
        double totalArea = 0;
        
        for (int i =0; i< allVoids.size(); i++)
        {
            voids = allVoids.get(i);
           
            for(int x = 0; x<voids.size(); x++)
            {
                totalArea += voids.get(x).getArea();
            }
        }
        
        return totalArea;
    }
    
    public static double getVoidArea(ArrayList<Voids> voids)
    {
        double totalArea = 0;
        
        for(int i = 0; i<voids.size(); i++)
        {
            totalArea += voids.get(i).getArea();
        }
        
        return totalArea;
    }
    
    public static Bricks getBricks( int choice)
    {   
        Bricks myBrick = null;
        
        if (choice == 1)
        {
            myBrick = new ExtrudedBrick("Extruded",.51,400.00);
        }
        if (choice == 2)
        {
            myBrick = new SandBrick("Sand Molded",.71,600.00);
        }
        if (choice == 3)
        {
            myBrick = new HandMoldedBrick("Hand Molded",.91,800.00);
        }
            
        return myBrick;
    }
     
    public static void getCost(ArrayList<Voids> voids, double voidsArea, Bricks brick, Structure structure)
    {         
        int totalBricks = brick.getTotalBricks(voidsArea, brick, structure);
        
        //gets cost of bricks
        double brickCost = MaterialCosts.costs(brick, totalBricks);
       
        //gets cost of mortar
        double mortarCost = MaterialCosts.getMortarPrice(totalBricks);
        
        //gets any discounts
        double [] discount = MaterialCosts.getDiscount();
        
        //gets total cost
        double cost = brickCost*discount[0] + mortarCost*discount[1]; 
        
        double savings = (brickCost+mortarCost)-cost;
        
        String str_discount = String.format("$%,.2f",savings);
        
        String str_cost = String.format("$%,.2f",cost);
        
        int doors = 0;
        int windows = 0;
        
        for (int x = 0; x < voids.size(); x++)
        {
            if (voids.get(x).getName().equals("Door"))
            {
                doors += 1;
            }
            else
            {
                windows +=1;
            }
        }
        
        
        //output
        System.out.println("Type of Brick: "+brick.getBrickType());     
        System.out.println("The Structure you wish to create has the following"
                + " dimensions: (LxHxW)");
        System.out.println(structure.getLength()+" x " + structure.getHeight()+ " x "
        + structure.getWidth());
        System.out.println("You entered that your structure has the following "
                + "number of doors and windows:");
        System.out.println("Windows: " + windows);
        System.out.println("Doors: " + doors);
        System.out.println("The following total removes the spaces for doors "
            + "and windows. It also includes 5% more bricks for incidentals.");
        System.out.println("Bricks: "+totalBricks);      
        System.out.println("Cost: "+str_cost);
        System.out.println("Cost includes any applicable discounts.");
        System.out.println("Savings from Discount: "+str_discount);
    }
    
    public static void getCost(ArrayList<ArrayList> allVoids,double voidsArea, Bricks brick, double totalProjectArea_ADB)
    { 
        ArrayList<Voids> voids = new ArrayList<Voids>();
        
        int totalBricks = brick.getTotalBricks(voidsArea, brick, totalProjectArea_ADB);
        
        double brickCost = MaterialCosts.costs(brick, totalBricks);
               
        double mortarCost = MaterialCosts.getMortarPrice(totalBricks);
        
        //gets any discounts
        double [] discount = MaterialCosts.getDiscount();
        
        //gets total cost
        double cost = brickCost*discount[0] + mortarCost*discount[1]; 
        
        double savings = (brickCost+mortarCost)-cost;
        
        String str_discount = String.format("$%,.2f",savings);
        
        String str_cost = String.format("$%,.2f",cost);
        
        int doors = 0;
        int windows = 0;
        
        for (int i =0; i< allVoids.size(); i++)
        {
            voids = allVoids.get(i);
            
            for (int x = 0; x < voids.size(); x++)
            {
                if (voids.get(x).getName().equals("Door"))
                {
                    doors += 1;
                }
                else
                {
                    windows +=1;
                } 
            }
        }
        
        System.out.println("Type of Brick: "+brick.getBrickType());
        System.out.println("The total area for your wall(s) minus voids is: ");
        System.out.println(totalProjectArea_ADB);
        System.out.println("You entered that your wall(s) have the following "
                + "number of doors and windows:");
        System.out.println("Windows: "+windows);
        System.out.println("Doors: "+doors);
        System.out.println("The following total removes the spaces for doors "
            + "and windows. It also includes 5% more bricks for incidentals.");
        System.out.println("Bricks: "+totalBricks);      
        System.out.println("Cost: "+str_cost);
        System.out.println("Cost includes any applicable discounts.");
        System.out.println("Savings from Discount: "+str_discount);
    }
}