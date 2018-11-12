/*
 *This is a collaborative group project for Advanced Java fall 2018. 
This program estimates the materials cost for adding brick to a surface.  Users 
will be asked for brick deminsions, cost of each brick, and the length and width
of each area to be covered.  The program will calculate the total number of 
bricks needed 
plus 10% and return a cost estimate. 

This program will use variables, methods, and decision structures.  


 */
package gp02_.pkg0910._denisebruce;

/**
 *
 * @author denise
 */
import java.util.Scanner;
import java.text.DecimalFormat;

public class GP02_0910_DeniseBruce {

    
    public static void main(String[] args) {
        
        double totalProjectArea_ADB = 0; 
        double wallTotalarea_ADB = 0;
        
       // User input for brick information and wall information. 
      System.out.print ("Welcome to the brick estimator.\n"
            +  "This program accounts for a 3/8 of an inch mortar joint \n"
            +  "and 10% excess materials.\n\n");
      Scanner keyboard = new Scanner(System.in);
      
      
     
      //User input for bricks (length, width) 
      System.out.println("Enter the length of the brick in inches:");
      double brickLength = keyboard.nextDouble();
      
      //User input for brickWidth 
      System.out.println("Enter the  width of the brick in inches:");
      double brickWidth = keyboard.nextDouble();  
      
      //User input for brickWidth 
      System.out.println("Enter the  height of the brick in inches:");
      double brickHeight = keyboard.nextDouble();  
      
      //User input for cost of each brick
      System.out.println("Enter the price of each brick:");
      double brickCost = keyboard.nextDouble();
      
      //Creates Brick Ojbect 
      Bricks myBrick = new Bricks(brickLength, brickWidth, brickHeight,  brickCost);
      
      
      // Total area of the walls 
        
        
      //Number of walls to covered 
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
      /*
        This will be a an exception class. 
      //Validation for positive measurements 
      if (wallLength <= 0 ||  wallWidth <= 0 || brickLength <=0 || 
              brickWidth <=0)
      {
          System.out.println("measurements cannot be less than or equal"
                  + " to zero!");
      }
      else 
      // Method Calls and Calculations 
       
      {double brickCalculation =  wallInformation(wallLength, wallWidth, 
              openingArea) / (bricksInformation(brickLength, brickWidth));
       
      //System.out.print(brickCalculation+"\n"); 
      DecimalFormat myFormat = new DecimalFormat("#,###.00");
      System.out.println("Total number of bricks you will need: " 
                  +  myFormat.format(brickCalculation));
      
      double brickTotal = brickPrice(brickCost, brickCalculation); 
      System.out.println("\nTotal cost of the project is: $" 
              +  myFormat.format(brickTotal));
      }
    
              */
      
    //bricksInformation method takes in the length and width of the brick in 
    //inches and adds a standard 3/8 inche mortar joint to the brick size. 
    //It returns the total area of each brick to the main. 
   
    }
   