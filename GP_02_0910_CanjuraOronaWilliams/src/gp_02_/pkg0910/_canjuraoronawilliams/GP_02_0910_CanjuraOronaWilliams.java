/*09/26/2018
  CSC 251
  Brick Calculator
  Canjura_Orona_Williams
  calculates the number of bricks used to build a structure
*/
package gp_02_.pkg0910._canjuraoronawilliams;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;

public class GP_02_0910_CanjuraOronaWilliams 
{
    public static Scanner keyboard = new Scanner(System.in);
 
    public static void main(String[] args) 
    {
        int choice = 0;
        
        do
        {   
            choice = menu();
            getChosenMethods(choice);
        }
        while (choice != 3);
    }
    
    public static int menu()
    {
        String input;
        int choice = 0;
        boolean gateA = false;       
          
        while (gateA != true || choice<=0 || choice>3)
        {
            //collects structure dimensions and assigns them to an object
            System.out.println("What is the length of the structure?(Use Feet) ");
            
            if (keyboard.hasNextInt())
            {
                input = keyboard.next();
                choice = Integer.parseInt(input);
                gateA = true;
            }
            else
            {
                input = keyboard.next();
            }
        }  
        
        return choice;
    }
    
    public static void getChosenMethods(int choice)
    {
        if (choice == 1)
        {
            getWalls();
        }
        if (choice == 2)
        {
            getStructure(); 
        }
    }
    
    public static void getWalls
    {
        double totalProjectArea_ADB = 0; 
        double wallTotalarea_ADB = 0;
        
        System.out.print ("How many walls are you covering?");
      double wallNumber = keyboard.nextDouble(); 
      
      
       // Total area of the voids aka Doors and windows 
        double voidTotalarea_ADB = 0;
      // Loop for each wall. 
      for( double wallnum = 1; wallnum <= wallNumber; wallnum++ )
      //User input for the length and width of the wall to be covered 
      { 
          System.out.println("Enter the length of the walls in feet: ");
      
      double wallLength = keyboard.nextDouble();
      
      System.out.println("Enter the width of the walls in feet: ");
      double wallWidth = keyboard.nextDouble();  
      //
      Walls myWall = new Walls (wallLength, wallWidth);
      
        
        
      //Number of voids in the wall.
      System.out.print ("How many doors, windows, or vents are in the walls?");
      double voidNumber_ADB = keyboard.nextDouble(); 
      
      // Loop for each wall. 
      for( double voidnum_ADB = 1; voidnum_ADB <= voidNumber_ADB; voidnum_ADB++ )
      //User input for the length and width of the wall to be covered 
      { 
          System.out.println("Enter the length of the door, window, or vent in feet: ");
      
      double voidLength_ADB = keyboard.nextDouble();
      
      System.out.println("Enter the width of the door, window, or vent in feet: ");
      double voidWidth_ADB = keyboard.nextDouble();  
      //
      Doors_and_Windows myVoid = new Doors_and_Windows (voidLength_ADB, voidWidth_ADB);
     
      voidTotalarea_ADB =  voidTotalarea_ADB +  myVoid.getArea();  
      
      } 
      
      wallTotalarea_ADB =  wallTotalarea_ADB +  myWall.getArea();  
      
      } 
       
       totalProjectArea_ADB =  (wallTotalarea_ADB - voidTotalarea_ADB); 
       double totalBricks = totalProjectArea_ADB/myBrick.getArea();
      DecimalFormat myformat = new DecimalFormat("#,###.00");
      System.out.println("total number of bricks you will need; " + 
              myformat.format(totalBricks));
       
    }
    
    public static void getStructure()
    {
        String input;
        double length = 0;
        double height = 0;
        double width = 0;
        boolean gateA = false;
        
        while (gateA != true || length<=0)
        {
            //collects structure dimensions and assigns them to an object
            System.out.println("What is the length of the structure?(Use Feet) ");
            
            if (keyboard.hasNextDouble())
            {
                input = keyboard.next();
                length = Double.parseDouble(input);
                gateA = true;
            }
            else
            {
                input = keyboard.next();
            }
        }    
        while (gateA != true || height<=0)
        {
            System.out.println("What is the height of the structure?(Use Feet) ");
            if (keyboard.hasNextDouble())
            {
                input = keyboard.next();
                height = Double.parseDouble(input);
                gateA = true;
            }
            else
            {
                input = keyboard.next();
            }
        }
        
        while (gateA != true || width<=0)
        {
            System.out.println("What is the width of the structure?(Use Feet) ");
            if (keyboard.hasNextDouble())
            {
                input = keyboard.next();
                width = Double.parseDouble(input);
                gateA = true;
            }
            else
            {
                input = keyboard.next();
            }
        }
            
            Structure structure = new Structure(length, height, width);
            
            ArrayList<Voids> voids = new ArrayList<Voids>();

            voids = getVoids();
            double voidsArea = getVoidArea(voids);
            Bricks brick = getBrickDimensions();
            getCost(voids, voidsArea,brick,structure);    
     
    }
    
    public static ArrayList<Voids> getVoids()
    {
        System.out.println("How many doors would you like to enter?");
        int doors = keyboard.nextInt();
        
        ArrayList<Voids> voids = new ArrayList<Voids>();
        
        for (int i=0; i<doors; i++)
        {
            String name = "Door";
            System.out.println("Enter length:(Use Feet)");
            double length= keyboard.nextDouble();
            
            System.out.println("Enter width:(Use Feet)");
            double width= keyboard.nextDouble();
            
            voids.add(new Voids(name,length, width));
        }
        
        System.out.println("How many windows would you like to enter?");
        int windows = keyboard.nextInt();
        
          for (int i=0; i<windows; i++)
        {
            String name = "Window";
            System.out.println("Enter length:(Use Feet)");
            double length= keyboard.nextDouble();
            
            System.out.println("Enter width:(Use Feet)");
            double width= keyboard.nextDouble();
            
            voids.add(new Voids(name,length, width));
        }
        
        return voids;
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
    
    public static Bricks getBrickDimensions()
    {       
        System.out.println("Enter the dimensions and cost for the bricks you would "
                + "like to use.(Use inches)\nLength:");
        double length = keyboard.nextDouble();
        System.out.println("Width:");
        double width = keyboard.nextDouble();
        System.out.println("Height:");
        double height = keyboard.nextDouble();
        System.out.println("Cost:");
        double cost = keyboard.nextDouble();
          
        Bricks myBrick = new Bricks(length,height,width,cost);
        
        return myBrick;
    }
     
    public static void getCost(ArrayList<Voids> voids,double voidsArea, Bricks brick, Structure structure)
    { 
        double totalBricks = brick.getTotalBricks(voidsArea, brick, structure);
        
        double cost = totalBricks*brick.getbrickCost();
        
        String str_cost = String.format("$%,.2f",cost);
        
        int doors = 0;
        int windows = 0;
        for (int i =0; i< voids.size(); i++)
        {
            if (voids.get(i).getName()=="Door")
            {
                doors += 1;
            }
            else
            {
                windows +=1;
            }
        }
        
        System.out.println("The Structure you wish to create has the following"
                + " dimensions: (LxHxW)");
        System.out.println(structure.getLength()+" x "+structure.getHeight()+" x "
        +structure.getWidth());
        System.out.println("You entered that your structure has the following "
                + "number of doors and windows:");
        System.out.println("Windows: "+windows);
        System.out.println("Doors: "+doors);
        System.out.println("The following removes the spaces for doors and windows.");
        System.out.println("Bricks: "+totalBricks);      
        System.out.println("Cost: "+str_cost);
    }
    
}
