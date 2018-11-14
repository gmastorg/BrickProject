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
            System.out.println("1.Get bricks for a wall\n2.Get bricks for a "
                    + "structure\n3.Exit");
            
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
    
    public static void getWalls()
    {   
        ArrayList<Voids> voids = new ArrayList<Voids>();
        double totalProjectArea_ADB = 0; 
        double wallTotalarea_ADB = 0;
        String input;
        double length = 0;
        double width = 0;
        boolean gateA = false;
        
        System.out.print ("How many walls are you covering?");
        double wallNumber = keyboard.nextDouble(); 
 
        for( double wallnum = 1; wallnum <= wallNumber; wallnum++ )
        //User input for the length and width of the wall to be covered 
        { 
            while (gateA != true || length<=0)
            {
                System.out.println("Enter the length of the walls in feet: ");
      
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
            while (gateA != true || length<=0)
            {
                System.out.println("Enter the width of the walls in feet: ");
      
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
            
            Walls myWall = new Walls (length, width);
      
            voids = getVoids();
      
            wallTotalarea_ADB =  wallTotalarea_ADB +  myWall.getArea();  
        } 
        
        // Total area of the voids aka Doors and windows 
        double voidTotalarea_ADB = getVoidArea(voids);
        // Loop for each wall. 
       
       totalProjectArea_ADB =  (wallTotalarea_ADB - voidTotalarea_ADB); 
       Bricks brick = getBrickDimensions();
       getCost(voids,voidTotalarea_ADB,brick,wallTotalarea_ADB);   
       
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
            getCost(voids,voidsArea,brick,structure);    
     
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
    
        public static void getCost(ArrayList<Voids> voids,double voidsArea, Bricks brick, double wallTotalarea_ADB)
    { 
        double totalBricks = brick.getTotalBricks(voidsArea, brick, wallTotalarea_ADB);
        
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
        
        System.out.println("The total area for your wall(s) is: ");
        System.out.println(wallTotalarea_ADB);
        System.out.println("You entered that your wall(s) have the following "
                + "number of doors and windows:");
        System.out.println("Windows: "+windows);
        System.out.println("Doors: "+doors);
        System.out.println("The following removes the spaces for doors and windows.");
        System.out.println("Bricks: "+totalBricks);      
        System.out.println("Cost: "+str_cost);
    }
}