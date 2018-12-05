package gp_02_.pkg0910._canjuraoronawilliams;

public class executeGUI 
{
      public static void launchEXE()
    {
        String workingDir = System.getProperty("user.dir");
        
        String filePath = workingDir+"/WindowsFormsApplication1.exe";
            try {
             
                Process p = Runtime.getRuntime().exec(filePath);
             
                } 
            catch (Exception e) {
                    e.printStackTrace();
                }
    }
}
