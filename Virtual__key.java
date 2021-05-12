import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Virtual__key {
		static File root = new File("H:\\java_full_stack\\phase 1");
		
		static int inputchoice()
        {
            String choice;
            int ret;
            Scanner sc = new Scanner(System.in);
            try {
                choice = sc.nextLine();
                ret = Integer.parseInt(choice);
                return (ret);
            } catch (Exception e) {
                return (0);
            }
        }
		
		static String filenameinput()
        {
            String choice="";
            Scanner sc=new Scanner(System.in);
            try{
                choice=sc.nextLine();
                return(choice);
            }
       catch(Exception e)
            {
                return("error!!! Invalid file name");
            }
        }
		
		public static void FileDelete() 
		{
			System.out.print("Enter the file name to be deleted : ");
			String fileToDelete = filenameinput();
			File fd = new File(root+"/"+fileToDelete);
			try {
				if (!fd.exists())System.out.println("File does not exist!!");
				else {
					boolean isDeleted = fd.delete();
					if(!isDeleted && fd.isDirectory()) {
						System.out.println("The entry is either a directory or invalid !!");
					}else System.out.println("File has been deleted successfully!!");
				}
			}catch(Exception e) {
				System.out.println("Exceptions occured "+e);
			}
		}
		public static void FileSearch() 
		{
			int found=0;
			String[] fileArray = root.list();
		    System.out.print("Enter the name of the file to be searched: ");
		    String filetoBeSearched = filenameinput();
		    if (fileArray == null) {
	            System.out.println("Empty directory.");
	        }
	        else 
	        {
	            for (int i = 0; i < fileArray.length; i++) 
	            {
	                if (filetoBeSearched.equalsIgnoreCase(fileArray[i])) {
	                    System.out.println(filetoBeSearched + " found");
	                    found = 1;
	                }
	            }
	        }
	  
	        if (found == 0) {
	            System.out.println("File Not Found");
	        }
	    }

		
	public static void main(String[] args) {
		
		System.out.println("Project Name : Company Lockers Pvt. Ltd.'s File Handling\n");
        System.out.println("Project developed by : Pooja\n");

        System.out.println("Root Directory:- "+root);

    while(true)
    {
    System.out.println("\n1.Show the files in root directory in Ascending Order");
    System.out.println("2. Business-level operations");
    System.out.println("3. Close the Application\n");
    int choice=0;
        choice=inputchoice();
       if(choice==0 || choice > 3)
          {
              System.out.println("Invalid Input!--- Please Select from above choices !!!");
          }
       else if(choice==1)
       {
           File[] fileascending=root.listFiles();
           Arrays.sort(fileascending);
            if(fileascending.length==0)
            	System.out.println("No files found");
            else
                   {
            		System.out.println("The files are :-");
                    for(File e:fileascending)
                    System.out.println(e.getName());
                    }
       }
       else if(choice==2)
       {
           while(true)
           {
               int choice2=0;
               System.out.println("\n1. Add a new File");
               System.out.println("2. Delete a file");
               System.out.println("3. Search a file");
               System.out.println("4. Go Back to the Main Menu");
               choice2=inputchoice();

               if(choice2==1)
               {
                   String filename;
                   System.out.println("Enter the file name:");
                   filename=filenameinput();
                   if(filename.equals("error")||filename.equals(""))
                   {
                       System.out.println("Invalid Input-- Please try Again");
                   }
                   else
                   {
                	   String path=root.getAbsolutePath();
                	   String filenameinput;
                	   path=path.concat("\\"+filename);
                	   File addfile= new File(path);
                	   if(addfile.exists())
                	   {
                		   System.out.println("A file exists with the same name");
                	   }
                	   else
                	   {
                		   try{
                			   addfile.createNewFile();
                			   System.out.println("New File has been created successfully");
                		   }
                		   catch(IOException e)
                		   {
                			   System.out.println("IO exception!!");
                		   }
                         
                	   }
                   }
               }
               else if(choice2==2)
               {
            	   FileDelete();
               }
               else if(choice2==3)
               {
            	   FileSearch();
               }
               else if(choice2==4)
               {
                   break;
               }
               else
               {
                   System.out.println("Invalid Input!!");
               }
           }
       }
       else if(choice==3)               
       {
            System.out.println("Thank you for using our application!!");
            System.exit(0);
       }

    }
  }
}