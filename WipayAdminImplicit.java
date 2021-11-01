package com.Selenium.Project;
import java.io.File;
import java.io.FileWriter;

import java.io.IOException;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.ElementNotInteractableException;
	import org.openqa.selenium.InvalidArgumentException;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.NoSuchElementException;
	import org.openqa.selenium.NoSuchFrameException;
	import org.openqa.selenium.UnhandledAlertException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class WipayAdminImplicit {

    public static void main(String[] args) throws InterruptedException, IOException {	
		         
			    //Creating a driver object referencing WebDriver interface
			    WebDriver driver;
			    String Error="";         		            	         
				//Setting webdriver.gecko.driver property
			    System.setProperty("webdriver.gecko.driver", "E:\\freshers\\Firefox\\geckodriver.exe");
					         
				 //launching browser
			    driver = new FirefoxDriver();   
				WebDriverWait wait=new WebDriverWait(driver,30);	
			   //JavascriptExecutor js = (JavascriptExecutor) driver;
					       

		        int i;         
		        for(i=1;i<=2;i++) 
		       {	
	        	try {
		            File WiLog = new File("E:\\freshers\\WIPAYE"+i+".txt");
		            if (WiLog.createNewFile()) {
		              System.out.println("File created: " + WiLog.getName());
		            } else {
		              System.out.println("File already exists.");
		            }
		          } 
				  catch (IOException e)
				  {
		            System.out.println("An error occurred.");
		            e.printStackTrace();
		          }
			    System.out.println("Sanity Test no : "+i);
			       System.out.println("##############################################################################");
			    driver.get("http://192.168.1.65:8080/WiPayAdmin/login.jsp");
			   
			    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			   	driver.findElement(By.id("uname")).sendKeys("admin");
			    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			    driver.findElement(By.id("pass")).sendKeys("admin123");
			    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			    driver.findElement(By.tagName("button")).submit();
			    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			    System.out.println("WiPay Loged-in successfully....");
			    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			     //MANAGE OPENED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 	          
		        try{
					  driver.findElement(By.xpath("//a[@title='Manage']")).click();
					  System.out.println("Manage Module expanded");
						      
					 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
						    //SEND SMS OPENED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		       	try{
					  driver.findElement(By.xpath("//a[@title='Send SMS']")).click();
					  System.out.println("Send SMS page opened....");
					        
					  Thread.sleep(2000);
					  driver.switchTo().frame(0);
					  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        	    try{  	
			          WebElement gid = driver.findElement(By.name("groupId"));
			          Select select = new Select(gid);
			          select.selectByVisibleText("Idea");
			          System.out.println("Network idea selected");
                   }
				   catch(NoSuchElementException e)
		           { 
		               FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				       String Error2i=e.getMessage();
				       Error=Error+"\n"+"\n"+Error2i;
				       MISWriter.write(Error);
				       MISWriter.close();
				       e.printStackTrace();
				       System.out.println("NETWORK DROPDOWN  Not Available:::::::"+e);
		           }
		        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				try{
					 driver.findElement(By.xpath("//input[@value='txt']")).click();
					 System.out.println("Text Message selected");
					 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				   }
				   catch(NoSuchElementException e)
				   { 
					 FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				     String Error2ii=e.getMessage();
				     Error=Error+"\n"+"\n"+Error2ii;
				     MISWriter.write(Error);
				     MISWriter.close();
					 e.printStackTrace();
					System.out.println("Text Message Radio button Not Available:::::::"+e);
		          }
				try{
					 driver.findElement(By.xpath("//input[@value='sm']")).click();
					 System.out.println("Service Message selected");
					 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		           }
				   catch(NoSuchElementException e) 
		           { 
				     FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				     String Error2iii=e.getMessage();
				     Error=Error+"\n"+"\n"+Error2iii;
				     MISWriter.write(Error);
				     MISWriter.close();
				     e.printStackTrace();
				     System.out.println("Service Message Radio button Not Available:::::::"+e);
		           }
		        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		       try {
					  driver.findElement(By.name("to")).sendKeys("919652319319,919652319320,919652319321,919652319322");
					  System.out.println("Mobile Numbers Entered");
					  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		           }
				   catch(NoSuchElementException e)
		           {
				      FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				      String Error2iv=e.getMessage();
				      Error=Error+"\n"+"\n"+Error2iv;
				      MISWriter.write(Error);
				      MISWriter.close();
				      e.printStackTrace();
				      System.out.println("Mobile Number text field not available:::::::::::::::"+e);
		           }
		          driver.findElement(By.name("msg")).sendKeys("Hi, Your Subscription Activation successfull");
		          System.out.println("Message Entered"); 	
	           try {
					  driver.findElement(By.name("txt")).sendKeys("http://www.google.com");
					  System.out.println(" URL Entered");
					  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		           }
				   catch(NoSuchElementException e)
		           {
				      FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				      String Error2v=e.getMessage();
				      Error=Error+"\n"+"\n"+Error2v;
				      MISWriter.write(Error);
				      MISWriter.close();
				      e.printStackTrace();
				      System.out.println("URL field not available:::::::::::::::"+e);
		           }
		       try {
					  driver.findElement(By.className("upload")).click();
					  //  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					       
					  String ss=driver.findElement(By.xpath("/html/body/div/font/b")).getText();
					  System.out.println("<<<<<<<<<"+ss+">>>>>>>>>");
		           }
		           catch(UnhandledAlertException e)
		           {
				      FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				      String Error2vi=e.getMessage();
				      Error=Error+"\n"+"\n"+Error2vi;
				      MISWriter.write(Error);
				      MISWriter.close();
				      e.printStackTrace();
				      System.out.println("Upload Failed:::::::::::::::"+e);
		           }	
		        
	             Thread.sleep(200);
		       	   }
				   catch (ElementNotInteractableException e)
				   {
				      FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				      String Error2vii=e.getMessage();
				      Error=Error+"\n"+"\n"+Error2vii;
				      MISWriter.write(Error);
				      MISWriter.close();
				      e.printStackTrace();
				      System.out.println("  send sms  ::" +e);
				      System.out.println("@@@@@@@@@@@@@ Send SMS page Opening failed @@@@@@@@@@@@");
		           }	
		       	//SEND SMS IS CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		         driver.switchTo().defaultContent();
		        //UNSUBSCRIPTION OPENED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		       try {
					 driver.findElement(By.xpath("//a[@title='Unsubscription']")).click();
					 System.out.println("Unsubscription opened....");
					        
					        	        
					 //  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					 Thread.sleep(2000);
					 driver.switchTo().frame(0);
		        
		       try {
					 driver.findElement(By.xpath("//input[@value='S']")).click();
					 System.out.println("Single radio button selected");
		           }
				   catch(NoSuchElementException e)
		        
		           {
				     FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				     String Error3i=e.getMessage();
				     Error=Error+"\n"+"\n"+Error3i;
				     MISWriter.write(Error);
				     MISWriter.close();
				     e.printStackTrace();
				     System.out.println("Single  radio button not available:::::::::::::::"+e);
		           }
		        
		       try {
					 driver.findElement(By.xpath("//input[@value='B']")).click();
					 System.out.println("Bulk radio button selected");
		           }
				   catch(NoSuchElementException e)
		           {
				     FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				     String Error3ii=e.getMessage();
				     Error=Error+"\n"+"\n"+Error3ii;
				     MISWriter.write(Error);
				     MISWriter.close();
				     e.printStackTrace();
				     System.out.println("Bulk radio button not available:::::::::::::::"+e);
		           }
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			WebElement chooseFile = null;
		      try {
				     chooseFile = driver.findElement(By.id("upfile"));
				     System.out.println("Browse button clicked");
		          }
				  catch(NoSuchElementException e)
		          {
			         e.printStackTrace();
			         System.out.println("Bbrowse  button not available:::::::::::::::"+e);	
		          }
		        
		      try {
				     chooseFile.sendKeys("E:\\freshers\\selenium\\msisdn.csv");
				      
				     System.out.println("CSV file picked from source folder");	       
		          }
				  catch(InvalidArgumentException e)
		          {
				     FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				     String Error3iii=e.getMessage();
				     Error=Error+"\n"+"\n"+Error3iii;
				     MISWriter.write(Error);
				     MISWriter.close();
				     e.printStackTrace();
				     System.out.println("CSV file not available:::::::::::::::"+e);
		         }
		        
		     try {
				     driver.findElement(By.xpath("//input[@name='save']")).click();
				        
				     System.out.println("Submited");
		         }
				 catch(NoSuchElementException e)
		         {
				     FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				     String Error3iv=e.getMessage();
				     Error=Error+"\n"+"\n"+Error3iv;
				     MISWriter.write(Error);
				     MISWriter.close();
				     e.printStackTrace();
				     System.out.println("Submit button not available:::::::::::::::"+e);
		        	
		         }
		        
		        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		        
		    try {	        	        
				     String rs=driver.findElement(By.xpath("/html/body/form/div/table[2]/tbody/tr[2]/td")).getText();
				     System.out.println("<<<<<<<<<<"+rs+">>>>>>>>>>");
		        }
				catch(UnhandledAlertException e)
		        { 
				     FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				     String Error3v=e.getMessage();
				     Error=Error+"\n"+"\n"+Error3v;
				     MISWriter.write(Error);
				     MISWriter.close();
				     //e.printStackTrace();
				     System.out.println("Form Not submited:::::::::::::::"+e);
		        }	
		        }
				catch(NoSuchElementException e)
		        {
				     FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				     String Error3vi=e.getMessage();
				     Error=Error+"\n"+"\n"+Error3vi;
				     MISWriter.write(Error);
				     MISWriter.close();
				     e.printStackTrace();
				     System.out.println("Unsubscription menu not available:::::::::::::::"+e);
		        }
		        //UNSUBSCRIPTION IS CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		        driver.switchTo().defaultContent();
		        
		        //BLACK LIST NUMBER<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		    try {
					 driver.findElement(By.xpath("//a[@title='Black List Number']")).click();
					 System.out.println("Black List Number opened....");
					 Thread.sleep(2000);     
					 driver.switchTo().frame(0);
		        
		    try {
					 WebElement gid2=driver.findElement(By.id("groupId"));
				     Select select2=new Select(gid2);
					 select2.selectByVisibleText("Vodafone");
					 System.out.println("Network Vodafone Selected");
					 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);;
		        }
				catch(NoSuchElementException e)
		        
		        {
		        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		        	String Error4i=e.getMessage();
		        	Error=Error+"\n"+"\n"+Error4i;
		        	MISWriter.write(Error);
		        	MISWriter.close();
		        	e.printStackTrace();
		        	System.out.println("Group ID not avaialble:::::::::::::::"+e);
		        }
		        
		        try {
		        driver.findElement(By.xpath("//input[@value='T']")).click();
		        System.out.println("+++ Add MSISDN radio button selected +++");
		        }catch(NoSuchElementException e)
		        
		        {
		        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		        	String Error4ii=e.getMessage();
		        	Error=Error+"\n"+"\n"+Error4ii;
		        	MISWriter.write(Error);
		        	MISWriter.close();
		        	e.printStackTrace();
		        	System.out.println("ADD MSISDN radio button not avaialble:::::::::::::::"+e);
		        }
		        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		    try {
		           driver.findElement(By.name("block_msisdn")).sendKeys("919652319319,919652319320,919652319321,919652319322,919652319323");
		           System.out.println("MSISDNs entered");
	            }
				catch(NoSuchElementException e)
		        
		        {
	              FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error4iii=e.getMessage();
		          Error=Error+"\n"+"\n"+Error4iii;
		          MISWriter.write(Error);
		          MISWriter.close();
		          e.printStackTrace();
		          System.out.println("block_msisdn text not avaialble:::::::::::::::"+e);
		        }
		        
		        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		        
		   try {
		          driver.findElement(By.name("expires_in")).clear();
		       }
			   catch(NoSuchElementException e)
		        
		       {
		          FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error4iv=e.getMessage();
		          Error=Error+"\n"+"\n"+Error4iv;
		          MISWriter.write(Error);
		          MISWriter.close();
		          e.printStackTrace();
		          System.out.println("expires_in text not avaialble:::::::::::::::"+e);
		       }
		        
		   try {
		          driver.findElement(By.name("expires_in")).sendKeys("4");
		          System.out.println("Expiry days entered");
		       }
			   catch(NoSuchElementException e)
		        
		       {
		          FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error4v=e.getMessage();
		          Error=Error+"\n"+"\n"+Error4v;
		          MISWriter.write(Error);
		          MISWriter.close();
		          e.printStackTrace();
		          System.out.println("expires_in text not avaialble:::::::::::::::"+e);
		       }
		        
		   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		        
		   try {
		          driver.findElement(By.xpath("//input[@value='Submit']"));
		          System.out.println("Block List Numbers Submited");
		       }
			   catch(NoSuchElementException e)
		        
		       {
		          e.printStackTrace();
		          System.out.println("Block List Numbers submit button not avaialble:::::::::::::::"+e);
		       }
		        
		   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		        
		  try {
		          driver.findElement(By.xpath("//input[@value='F']")).click();
		          System.out.println("+++ Upload File radio button selected +++");
		      }catch(NoSuchElementException e)
		        
		      {
		          FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error4vi=e.getMessage();
		          Error=Error+"\n"+"\n"+Error4vi;
		          MISWriter.write(Error);
		          MISWriter.close();
		          e.printStackTrace();
		          System.out.println("Upload File radio button not avaialble:::::::::::::::"+e);
		      }
		        
		        
		  try {
		          driver.findElement(By.name("expires_in")).clear();
		        
		      }catch(NoSuchElementException e)
		        
		      {
		          FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error4vii=e.getMessage();
		          Error=Error+"\n"+"\n"+Error4vii;
		          MISWriter.write(Error);
		          MISWriter.close();
		          e.printStackTrace();
		          System.out.println("expires_in text not avaialble:::::::::::::::"+e);
		      }
		        
		  try {
		          driver.findElement(By.name("expires_in")).sendKeys("0");
	          }
			  catch(NoSuchElementException e)
		      {
	              FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error4viii=e.getMessage();
		          Error=Error+"\n"+"\n"+Error4viii;
		          MISWriter.write(Error);
		          MISWriter.close();
		          e.printStackTrace();
		          System.out.println("expires_in text not avaialble:::::::::::::::"+e);
		      }
		        
		        
	       driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		        
		      WebElement chooseFile1=null;
		  try {
		          chooseFile1=driver.findElement(By.id("myfile"));
		          System.out.println("Browse button clicked");
		      }
			  catch(NoSuchElementException e)
		        
		      {
		          FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error4ix=e.getMessage();
		          Error=Error+"\n"+"\n"+Error4ix;
		          MISWriter.write(Error);
		          MISWriter.close();
		          e.printStackTrace();
		          System.out.println("Browse button Not clicked:::::::::::::::"+e);
		      }
		        
		        
		   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  try {
		          chooseFile1.sendKeys("E:\\freshers\\selenium\\msisdn2.zip");
		          System.out.println("CSV Zip file picked from source folder");
		      }
			  catch(NoSuchElementException e)
		        
		      {
		          FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error4x=e.getMessage();
		          Error=Error+"\n"+"\n"+Error4x;
		          MISWriter.write(Error);
		          MISWriter.close();
		          e.printStackTrace();
		          System.out.println("CSV Zip file Not picked from source:::::::::::::::"+e);
		      }
		        
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  try {
		          driver.findElement(By.name("expires_in")).clear();
		          driver.findElement(By.name("expires_in")).sendKeys("5");
		      }
			  catch(NoSuchElementException e)
			  {
		          FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error4xi=e.getMessage();
		          Error=Error+"\n"+"\n"+Error4xi;
		          MISWriter.write(Error);
		          MISWriter.close();
		          e.printStackTrace();
		          System.out.println("expires_in text not available:::::::::::::::"+e);
		      }

		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);;
		  try {
		          driver.findElement(By.id("submit")).click();
		          System.out.println("Upload Submited");
		      }
			  catch(NoSuchElementException e)
		      {
		          FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error4xii=e.getMessage();
		          Error=Error+"\n"+"\n"+Error4xii;
		          MISWriter.write(Error);
		          MISWriter.close();
		          e.printStackTrace();
		          System.out.println("submit button not clicked:::::::::::::::"+e);
		      }
		        
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		        
		  try {
		          driver.findElement(By.xpath("//input[@value='S']")).click();
		          System.out.println("+++ Search radio button selected +++");
		      }
			  catch(NoSuchElementException e)
		        
		      {
		          FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error4xiii=e.getMessage();
		          Error=Error+"\n"+"\n"+Error4xiii;
		          MISWriter.write(Error);
		          MISWriter.close();
		          e.printStackTrace();
		          System.out.println("Search radio button not selected:::::::::::::::"+e);
		      }
		        
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  try {
		          driver.findElement(By.xpath("//input[@value='D']")).click();
		          System.out.println("+++ Delete All radio button slected +++");
		      }
			  catch(NoSuchElementException e)
		        
		      {
		          e.printStackTrace();
		          System.out.println("Delete All radio button Not slected:::::::::::::::"+e);
		      }
		        
		          driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		      
              }
			  catch(UnhandledAlertException e)
		        
		      {
		          FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error4=e.getMessage();
		          Error=Error+"\n"+"\n"+Error4;
		          MISWriter.write(Error);
		          MISWriter.close();
		          e.printStackTrace();
		          System.out.println("Black List Number Menu not avaialble:::::::::::::::"+e);
		      }
	//BLACK LIST NUMBER CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		      }
		      catch(NoSuchElementException e)
		      {
		          FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error1=e.getMessage();
		          Error=Error+"\n"+"\n"+Error1;
		          MISWriter.write(Error);
		          MISWriter.close();
		          e.printStackTrace();
		          System.out.println("^^^^^^^Exception^^^^^^^^"+e);
		          System.out.println("##############Manage Module expand Failed###############");
		      }
     //MANAGE CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		  driver.switchTo().defaultContent();
     //MIS REPORTS OPENED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		  try {	        
			      driver.findElement(By.xpath("//a[@title='MIS Reports']")).click();
			      System.out.println("MIS Reports Menu opened....");
		        
			      driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	 
	 //REVENUE REPORTS <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 
	      try {
		          driver.findElement(By.xpath("//a[@title='Revenue Reports']")).click();
		          System.out.println("Revenue Reports Expanded............");
		          driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	//MOBILE USER REPORTS OPENED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<     
		  try {
		          driver.findElement(By.xpath("//a[@title='Mobile User Report']")).click();
		          System.out.println("Mobile User Report opened.....");
		          Thread.sleep(2000);        
	              driver.switchTo().frame(0);
	      try {
			      WebElement frd=driver.findElement(By.name("fromd"));
			      Select frdsel=new Select(frd);
			      frdsel.selectByValue("3");
			      System.out.println("From Date 3 selected");
			        
	          }
			  catch(NoSuchElementException e)
			        
		      {
	              FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error7i=e.getMessage();
		          Error=Error+"\n"+"\n"+Error7i;
		          MISWriter.write(Error);
		          MISWriter.close();
		          e.printStackTrace();
		          System.out.println("From Date Not selected:::::::::::::::"+e);
		      }
		        
		  Thread.sleep(3000);
		        
	      try {
		          WebElement frm=driver.findElement(By.name("fromm"));
		          Select frdsel2=new Select(frm);
		          frdsel2.selectByValue("2");
		          System.out.println("From month 'FEB' selected");
		      }
			  catch(ElementNotInteractableException e)
		        
		      {
		          FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error7ii=e.getMessage();
		          Error=Error+"\n"+"\n"+Error7ii;
		          MISWriter.write(Error);
		          MISWriter.close();
		          e.printStackTrace();
		          System.out.println("From month Not selected:::::::::::::::"+e);
		      }
		Thread.sleep(1000);
		  try {
		  	      WebElement frm=driver.findElement(By.name("fromy"));
		  	      Select frdsel3=new Select(frm);
		  	      frdsel3.selectByValue("2019");
		  	      System.out.println("From year '2019' selected");
		  	  }
			  catch(ElementNotInteractableException e)
		  	  {
		  	      FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error7iii=e.getMessage();
		          Error=Error+"\n"+"\n"+Error7iii;
		          MISWriter.write(Error);
		          MISWriter.close();
		  	      e.printStackTrace();
		  	      System.out.println("From year '2019' Not selected:::::::::::::::"+e);
		  	  }
	  Thread.sleep(2000);
			        
		  try {
		          WebElement frd2=driver.findElement(By.name("tod"));
		          Select frdsel4=new Select(frd2);
		          frdsel4.selectByValue("23"); 
		          System.out.println("From Date 23 selected");
		      }
			  catch(ElementNotInteractableException e)
		        
		      {
		          FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error7iv=e.getMessage();
		          Error=Error+"\n"+"\n"+Error7iv;
		          MISWriter.write(Error);
		          MISWriter.close();
		          e.printStackTrace();
		          System.out.println("From Date Not selected:::::::::::::::"+e);
		      }
		   Thread.sleep(2000);
			        
	      try {
		          WebElement frm2=driver.findElement(By.name("tom"));
		          Select frdsel5=new Select(frm2);
		          frdsel5.selectByValue("3");
		          System.out.println("From month 'March' selected");
		      }
			  catch(ElementNotInteractableException e)
		      {
		          FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error7v=e.getMessage();
		          Error=Error+"\n"+"\n"+Error7v;
		          MISWriter.write(Error);
		          MISWriter.close();
		          e.printStackTrace();
		          System.out.println("From Month Not selected:::::::::::::::"+e);
		      }
		        
		 Thread.sleep(2000);
	      try {
	  	          WebElement frm=driver.findElement(By.name("toy"));
	  	          Select frdsel6=new Select(frm);
	  	          frdsel6.selectByValue("2021");
	  	          System.out.println("From year'2021' selected");
	  	      }
			  catch(ElementNotInteractableException e)
	  	        
	  	      {
	  	          FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error7vi=e.getMessage();
		          Error=Error+"\n"+"\n"+Error7vi;
		          MISWriter.write(Error);
		          MISWriter.close();
	  	          e.printStackTrace();
	  	          System.out.println("From year'2021' Not selected:::::::::::::::"+e);
	  	      }
	  	        
	   Thread.sleep(2000);
	      try {
    	          driver.findElement(By.xpath("//input[@value='20']")).click();
    	          System.out.println("Today Selected.....impl wait");
    	      }
			  catch(NoSuchElementException e)
    	        
    	      {
    	          FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error7vii=e.getMessage();
		          Error=Error+"\n"+"\n"+Error7vii;
		          MISWriter.write(Error);
		          MISWriter.close();
    	          e.printStackTrace();
    	          System.out.println("Today Not Selected:::::::::::::::"+e);
    	      }
    	   //Thread.sleep(3000);	 
    	   Thread.sleep(2000);
	      try {
    	  	      driver.findElement(By.xpath("//input[@value='21']")).click();
    	  	      System.out.println("Last 1 Oneday Selected.....impl wait");
		  	  }
			  catch(NoSuchElementException e)
		  	        
		  	  {
		  	      FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error7viii=e.getMessage();
		          Error=Error+"\n"+"\n"+Error7viii;
		          MISWriter.write(Error);
		          MISWriter.close();
		  	      e.printStackTrace();
		  	      System.out.println("Last 1 Oneday Not Selected:::::::::::::::"+e);
		  	  }
		  //Thread.sleep(3000);	 
		   Thread.sleep(2000);
	      try {
		          driver.findElement(By.xpath("//input[@value='7']")).click();
		          System.out.println("Last 1 Week Selected.....impl wait");
		      }
			  catch(NoSuchElementException e)
		        
		      {
		          FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error7ix=e.getMessage();
		          Error=Error+"\n"+"\n"+Error7ix;
		          MISWriter.write(Error);
		          MISWriter.close();
		          e.printStackTrace();
		          System.out.println("Last 1 Week Not Selected:::::::::::::::"+e);
		      }
	      try {
			      driver.findElement(By.xpath("//input[@value='1']")).click();
		          System.out.println("Last 1 Month Selected.....impl wait");
		      }
			  catch(NoSuchElementException e)
		        
		      {
		          FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error7x=e.getMessage();
		          Error=Error+"\n"+"\n"+Error7x;
		          MISWriter.write(Error);
		          MISWriter.close();
		          e.printStackTrace();
		          System.out.println("Last 1  Month Not Selected:::::::::::::::"+e);
		      }
		 Thread.sleep(2000);
		      
	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  try {	        	        
	  	          WebElement gsname=driver.findElement(By.name("groupsName"));
	  	          Select select3=new Select(gsname);
	  	          select3.selectByVisibleText("Idea");
	  	          System.out.println("Idea Network opened");
	  	      }
			  catch(NoSuchElementException e)
	  	        
	  	      {
	  	          FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error7xi=e.getMessage();
		          Error=Error+"\n"+"\n"+Error7xi;
		          MISWriter.write(Error);
		          MISWriter.close();
	  	          e.printStackTrace();
	  	          System.out.println("Idea Network Not opened:::::::::::::::"+e);
	  	      }
	  	        
	   Thread.sleep(2000);
	      try {	        	        
		          WebElement gname=driver.findElement(By.name("groupName"));
		          Select select3=new Select(gname);
		          select3.selectByVisibleText("WiPayTest");
		          System.out.println("WiPayTest Merchant opened");
		      }
			  catch(NoSuchElementException e)
		        
		      {
		          FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error7xii=e.getMessage();
		          Error=Error+"\n"+"\n"+Error7xii;
		          MISWriter.write(Error);
		          MISWriter.close();
		          e.printStackTrace();
		          System.out.println("WiPayTest Merchant Not opened:::::::::::::::"+e);
		      }
		         
          try {	        	        
	  	          WebElement zone=driver.findElement(By.name("zoneid"));
	  	          Select select3=new Select(zone);
	  	          select3.selectByVisibleText("East");
	  	          System.out.println("East Zone opened");
	  	      }
			  catch(NoSuchElementException e)
	  	        
	  	      {
	  	          FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error7xiii=e.getMessage();
		          Error=Error+"\n"+"\n"+Error7xiii;
		          MISWriter.write(Error);
		          MISWriter.close();
	  	          e.printStackTrace();
	  	          System.out.println("East Zone Not opened:::::::::::::::"+e);
	  	      }
	  	        
	  Thread.sleep(2000);
	  	 try {	        	        
		  	      WebElement circle=driver.findElement(By.id("circle"));
		  	      Select select3=new Select(circle);
		  	      select3.selectByVisibleText("All");
		  	      System.out.println("Circle All opened");
		     }
			 catch(NoSuchElementException e)
		  	 {
		  		  FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error7xiv=e.getMessage();
		          Error=Error+"\n"+"\n"+Error7xiv;
		          MISWriter.write(Error);
		          MISWriter.close();
		  	      e.printStackTrace();
		  	      System.out.println("Circle All Not opened:::::::::::::::"+e);
		  	 }
			  	        
	Thread.sleep(2000);
	     try {	        	        
			      WebElement ctype=driver.findElement(By.name("Ctype"));
			      Select select3=new Select(ctype);
			      select3.selectByVisibleText("Animations");
			      System.out.println("ContentType Animations opened");
			 }
			 catch(NoSuchElementException e)	  	        
			 {
				  FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error7xv=e.getMessage();
		          Error=Error+"\n"+"\n"+Error7xv;
		          MISWriter.write(Error);
		          MISWriter.close();
			      e.printStackTrace();
		          System.out.println("ContentType Animations Not opened:::::::::::::::"+e);
			 }
	Thread.sleep(2000);
	     try {	        	        
			      WebElement type=driver.findElement(By.name("flags"));
			      Select select3=new Select(type);
			      select3.selectByVisibleText("Promotions");
			      System.out.println("Type Promotions opened");
			 }
			 catch(NoSuchElementException e)
			 {
				  FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error7xvi=e.getMessage();
		          Error=Error+"\n"+"\n"+Error7xvi;
		          MISWriter.write(Error);
		          MISWriter.close();
			      e.printStackTrace();
			      System.out.println("Type Promotions Not opened:::::::::::::::"+e);
			 }
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 try {	        	        
			      WebElement type=driver.findElement(By.name("bill_type"));
			      Select select3=new Select(type);
			      select3.selectByVisibleText("PPD");
			      System.out.println("BillType opened");
			 }
			 catch(NoSuchElementException e)
			 {
				  FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error7xvii=e.getMessage();
		          Error=Error+"\n"+"\n"+Error7xvii;
		          MISWriter.write(Error);
		          MISWriter.close();
			      e.printStackTrace();
			      System.out.println("BillType Not opened:::::::::::::::"+e);
			 }
	 Thread.sleep(3000);
		 try {
		          driver.findElement(By.xpath("//input[@value='Submit']")).click();
		          System.out.println("Mobile User report submited");
		     }
			 catch(NoSuchElementException e)
			 {
		    	  FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error7xviii=e.getMessage();
		          Error=Error+"\n"+"\n"+Error7xviii;
		          MISWriter.write(Error);
		          MISWriter.close();
		          e.printStackTrace();
		          System.out.println("Moble User report Not submited:::::::::::::::"+e);
		     }
		        
	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 try {
		          driver.findElement(By.xpath("//button[@id='hide']")).click();
		          System.out.println("Hide clicked");
		     }
			 catch(NoSuchElementException e)
		     {
		    	  FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error7xix=e.getMessage();
		          Error=Error+"\n"+"\n"+Error7xix;
		          MISWriter.write(Error);
		          MISWriter.close();
		          e.printStackTrace();
		          System.out.println("Hide Not clicked:::::::::::::::"+e);
		     }
	 Thread.sleep(2000);
		        
	     try {
				  WebElement frd=driver.findElement(By.name("fromd"));
				  Select frdsel=new Select(frd);
				  frdsel.selectByValue("3");
				  System.out.println("From Date 3 selected");
		     }
			 catch(NoSuchElementException e)
		     {
		    	  FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error7xx=e.getMessage();
		          Error=Error+"\n"+"\n"+Error7xx;
		          MISWriter.write(Error);
		          MISWriter.close();
		          e.printStackTrace();
		          System.out.println("From Date Not selected:::::::::::::::"+e);
		     }
		 try {
		          WebElement frm=driver.findElement(By.name("fromm"));
		          Select frdsel2=new Select(frm);
		          frdsel2.selectByValue("2");
		          System.out.println("From month 'FEB' selected");
		     }
			 catch(ElementNotInteractableException e)
		        
		     {
		    	  FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error7xxi=e.getMessage();
		          Error=Error+"\n"+"\n"+Error7xxi;
		          MISWriter.write(Error);
		          MISWriter.close();
		          e.printStackTrace();
		          System.out.println("From month Not selected:::::::::::::::"+e);
		     }
		 try {
	  	          WebElement frm=driver.findElement(By.name("fromy"));
	  	          Select frdsel3=new Select(frm);
	  	          frdsel3.selectByValue("2019");
	  	          System.out.println("From year '2019' selected");
	  	     }
			 catch(ElementNotInteractableException e) 
	  	     {
	  	    	  FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error7xxii=e.getMessage();
		          Error=Error+"\n"+"\n"+Error7xxii;
		          MISWriter.write(Error);
		          MISWriter.close();
	  	          e.printStackTrace();
	  	          System.out.println("From year '2019' Not selected:::::::::::::::"+e);
	  	     }
	  	 Thread.sleep(2000);
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 try {
		          WebElement frd2=driver.findElement(By.name("tod"));
		          Select frdsel3=new Select(frd2);
		          frdsel3.selectByValue("23"); 
		          System.out.println("From Date 23 selected");
		     }
			 catch(ElementNotInteractableException e)
		        
		     {
		          FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error7xxiii=e.getMessage();
		          Error=Error+"\n"+"\n"+Error7xxiii;
		          MISWriter.write(Error);
		          MISWriter.close();
		          e.printStackTrace();
		          System.out.println("From Date Not selected:::::::::::::::"+e);
		     }
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		        
		 try {
		          WebElement frm2=driver.findElement(By.name("tom"));
		          Select frdsel4=new Select(frm2);
		          frdsel4.selectByValue("3");
		          System.out.println("From month 'March' selected");
		     }
			 catch(ElementNotInteractableException e)
		        
		     {
		          FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error7xxiv=e.getMessage();
		          Error=Error+"\n"+"\n"+Error7xxiv;
		          MISWriter.write(Error);
		          MISWriter.close();
		          e.printStackTrace();
		          System.out.println("From Month Not selected:::::::::::::::"+e);
		     }
	     try {
		  	      WebElement frm=driver.findElement(By.name("toy"));
		  	      Select frdsel6=new Select(frm);
		  	      frdsel6.selectByValue("2021");
		  	      System.out.println("From year'2021' selected");
		  	 }
			 catch(ElementNotInteractableException e)
		  	        
		  	 {
		  	      FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			      String Error7xxv=e.getMessage();
			      Error=Error+"\n"+"\n"+Error7xxv;
			      MISWriter.write(Error);
			      MISWriter.close();
		  	      e.printStackTrace();
		  	      System.out.println("From year'2021' Not selected:::::::::::::::"+e);
		  	 }
		  	        
		 Thread.sleep(2000);
		        
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		        
		 try {
		          driver.findElement(By.xpath("//input[@value='Submit']")).click();
		          System.out.println("Form Submitted");
		        
		     }
			 catch(ElementNotInteractableException e)
		        
		     {
		          FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error7xxvi=e.getMessage();
		          Error=Error+"\n"+"\n"+Error7xxvi;
		          MISWriter.write(Error);
		          MISWriter.close();
		          e.printStackTrace();
		          System.out.println("Form Not submited:::::::::::::::"+e);
		     }
		        
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
             }
			 catch(ElementNotInteractableException e)
		        
		     {
		          FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		          String Error7=e.getMessage();
		          Error=Error+"\n"+"\n"+Error7;
		          MISWriter.write(Error);
		          MISWriter.close();
		          e.printStackTrace();
		          System.out.println("Mobile User Report Not opened:::::::::::::::"+e);
		     }
		 //MOBILE USER REPORTS CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 
		  Thread.sleep(2000);

		 try {
		        driver.switchTo().defaultContent();
		     }
			 catch(UnhandledAlertException e)
		        
		     {
		        FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		        String Errorpp=e.getMessage();
		        Error=Error+"\n"+"\n"+Errorpp;
		        MISWriter.write(Error);
		        MISWriter.close();
		        e.printStackTrace();
		        System.out.println("Default frame not selected:::::::::::::::"+e);
		     }
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        //MSISDN REPORTS OPENED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	    try {
		       driver.findElement(By.xpath("//a[@title='MSISDN Report']")).click();
		       System.out.println("MSISDN Report Opened");
		       driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	     try {
		        driver.switchTo().frame(0);
		        System.out.println("MSISDN Report frame  Opened");
		     }
			 catch(NoSuchFrameException e)
		        
		    {
		      FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		      String Error8i=e.getMessage();
		      Error=Error+"\n"+"\n"+Error8i;
		      MISWriter.write(Error);
		      MISWriter.close();
		      e.printStackTrace();
		      System.out.println("MSISDN Report frame Not Opened:::::::::::::::"+e);
		    }

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		        
		try {
		      driver.findElement(By.name("msisdn_id")).sendKeys("917772995645");
		      System.out.println("MSISDN Entered");
		    }
			catch(NoSuchElementException e)
		        
		    {
		       FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		       String Error8ii=e.getMessage();
		       Error=Error+"\n"+"\n"+Error8ii;
		       MISWriter.write(Error);
		       MISWriter.close();
		       e.printStackTrace();
		       System.out.println("MSISDN text not available:::::::::::::::"+e);
		        }
		        
		          driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		    try {
		  	       WebElement frd9=driver.findElement(By.name("fromd"));
		  	       Select seld8=new Select(frd9);
		  	       seld8.selectByVisibleText("10");
		  	       System.out.println("From date selected");
		  	    }catch(NoSuchElementException e)
		  	        
		  	        {
		  	        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error8iii=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error8iii;
			        	MISWriter.write(Error);
			        	MISWriter.close();
		  	        	e.printStackTrace();
		  	        	System.out.println("From date Not selected:::::::::::::::"+e);
		  	        }
		  	        
		  	        Thread.sleep(2000);     
		        try {
				WebElement frm5=driver.findElement(By.name("fromm"));
				Select frdsel6=new Select(frm5);
				frdsel6.selectByValue("3");
				System.out.println("From month 'MARCH' selected");
		        }catch(ElementNotInteractableException e)
		        
		        {
		        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		        	String Error8iv=e.getMessage();
		        	Error=Error+"\n"+"\n"+Error8iv;
		        	MISWriter.write(Error);
		        	MISWriter.close();
		        	e.printStackTrace();
		        	System.out.println("From month Not selected:::::::::::::::"+e);
		        }
		        try {
			        WebElement fry9=driver.findElement(By.name("fromy"));
			        Select selm8=new Select(fry9);
			        selm8.selectByValue("2019");
			        System.out.println("From Date 2019 selected");
			        }catch(NoSuchElementException e)
			        
			        {
			        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error8v=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error8v;
			        	MISWriter.write(Error);
			        	MISWriter.close();
			        	e.printStackTrace();
			        	System.out.println("From Date 2019 not selected:::::::::::::::"+e);
			        }
			        
			        Thread.sleep(2000);

				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		        			
				try {
				WebElement frd3=driver.findElement(By.name("tod"));
		        Select frdsel7=new Select(frd3);
		        frdsel7.selectByValue("30"); 
		        System.out.println("From Date 30 selected");
		        }catch(ElementNotInteractableException e)
		        
		        {
		        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		        	String Error8vi=e.getMessage();
		        	Error=Error+"\n"+"\n"+Error8vi;
		        	MISWriter.write(Error);
		        	MISWriter.close();
		        	e.printStackTrace();
		        	System.out.println("From Date Not selected:::::::::::::::"+e);
		        }

		        
		          driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	 	        try {
		        WebElement tom=driver.findElement(By.name("tom"));
		        Select frdsel8=new Select(tom);
		        frdsel8.selectByValue("4");
		        System.out.println("From month 'April' selected");
		        }catch(ElementNotInteractableException e)
		        
		        {
		        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		        	String Error8vii=e.getMessage();
		        	Error=Error+"\n"+"\n"+Error8vii;
		        	MISWriter.write(Error);
		        	MISWriter.close();
		        	e.printStackTrace();
		        	System.out.println("From month Not selected:::::::::::::::"+e);
		        }
	 	       try {
		  	        WebElement frm=driver.findElement(By.name("toy"));
		  	        Select frdsel6=new Select(frm);
		  	        frdsel6.selectByValue("2021");
		  	        System.out.println("From year'2021' selected");
		  	        }catch(ElementNotInteractableException e)
		  	        
		  	        {
		  	        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error8viii=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error8viii;
			        	MISWriter.write(Error);
			        	MISWriter.close();
		  	        	e.printStackTrace();
		  	        	System.out.println("From year'2021' Not selected:::::::::::::::"+e);
		  	        }
		  	        
		  	          Thread.sleep(2000);
		        
		        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		          
		        try {
		        driver.findElement(By.xpath("//input[@value='Submit']")).click();
		        
		        }catch(ElementNotInteractableException e)
		        
		        {
		        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		        	String Error8ix=e.getMessage();
		        	Error=Error+"\n"+"\n"+Error8ix;
		        	MISWriter.write(Error);
		        	MISWriter.close();
		        	e.printStackTrace();
		        	System.out.println("Submit button Not Available :::::::::::::::"+e);
		        }
		        
		        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		        
		        try{
		        driver.findElement(By.xpath("//button[@id='hide']")).click();	
		        System.out.println("Hide button clicked");
		        }catch(ElementNotInteractableException e)
		        
		        {
		        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		        	String Error8x=e.getMessage();
		        	Error=Error+"\n"+"\n"+Error8x;
		        	MISWriter.write(Error);
		        	MISWriter.close();
		        	e.printStackTrace();
		        	System.out.println("Hide button Not clicked"+e);
		        }
     }catch(NoSuchElementException e)
		        
		        {
		        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		        	String Error8=e.getMessage();
		        	Error=Error+"\n"+"\n"+Error8;
		        	MISWriter.write(Error);
		        	MISWriter.close();
		        	e.printStackTrace();
		        	System.out.println("MSISDN Report Not Opened:::::::::::::::"+e);
		        }
		        
	  	      //MSISDN REPORTS CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	  	        Thread.sleep(2000);

		        
		        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		        	        
		        driver.switchTo().defaultContent();
		        //TRANSACTION REPORTS OPENED<<<<<<<<<<<<<<<<<<<<<<<<<<
		        try {
		        driver.findElement(By.xpath("//a[@title='Transaction Report']")).click();
		        System.out.println("Transaction Report Opened....");
		        Thread.sleep(2000);
		              
		        driver.switchTo().frame(0); 
		        
		        try {
		        WebElement frd9=driver.findElement(By.name("fromd"));
		        Select seld8=new Select(frd9);
		        seld8.selectByVisibleText("10");
		        System.out.println("From date selected");
		        }catch(NoSuchElementException e)
		        
		        {
		        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		        	String Error9i=e.getMessage();
		        	Error=Error+"\n"+"\n"+Error9i;
		        	MISWriter.write(Error);
		        	MISWriter.close();
		        	e.printStackTrace();
		        	System.out.println("From date Not selected:::::::::::::::"+e);
		        }
		        
		        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		        
		        try {
		        WebElement frm9=driver.findElement(By.name("fromm"));
		        Select selm8=new Select(frm9);
		        selm8.selectByValue("3");
		        System.out.println("From month selected");
		        }catch(NoSuchElementException e)
		        
		        {
		        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		        	String Error9ii=e.getMessage();
		        	Error=Error+"\n"+"\n"+Error9ii;
		        	MISWriter.write(Error);
		        	MISWriter.close();
		        	e.printStackTrace();
		        	System.out.println("From month Not selected:::::::::::::::"+e);
		        }
		        try {
			        WebElement fry9=driver.findElement(By.name("fromy"));
			        Select selm8=new Select(fry9);
			        selm8.selectByValue("2019");
			        System.out.println("From Date 2019 selected");
			        }catch(NoSuchElementException e)
			        
			        {
			        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error9iii=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error9iii;
			        	MISWriter.write(Error);
			        	MISWriter.close();
			        	e.printStackTrace();
			        	System.out.println("From Date 2019 not selected:::::::::::::::"+e);
			        }
			        
			        Thread.sleep(2000);
			        
		        
		        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		        try {
			        WebElement frd2=driver.findElement(By.name("tod"));
			        Select frdsel4=new Select(frd2);
			        frdsel4.selectByValue("23"); 
			        System.out.println("From Date 23 selected");
			        }catch(ElementNotInteractableException e)
			        
			        {
			        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error9iv=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error9iv;
			        	MISWriter.write(Error);
			        	MISWriter.close();
			        	e.printStackTrace();
			        	System.out.println("From Date Not selected:::::::::::::::"+e);
			        }
			          Thread.sleep(2000);
			        
			        try {
			        WebElement frm2=driver.findElement(By.name("tom"));
			        Select frdsel5=new Select(frm2);
			        frdsel5.selectByValue("9");
			        System.out.println("From month 'september' selected");
			        }catch(ElementNotInteractableException e)
			        
			        {
			        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error9v=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error9v;
			        	MISWriter.write(Error);
			        	MISWriter.close();
			        	e.printStackTrace();
			        	System.out.println("From Month Not selected:::::::::::::::"+e);
			        }
			        
			          Thread.sleep(2000);
			         try {
			  	        WebElement frm=driver.findElement(By.name("toy"));
			  	        Select frdsel6=new Select(frm);
			  	        frdsel6.selectByValue("2021");
			  	        System.out.println("From year'2021' selected");
			  	        }catch(ElementNotInteractableException e)
			  	        
			  	        {
			  	        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				        	String Error9vi=e.getMessage();
				        	Error=Error+"\n"+"\n"+Error9vi;
				        	MISWriter.write(Error);
				        	MISWriter.close();
			  	        	e.printStackTrace();
			  	        	System.out.println("From year'2021' Not selected:::::::::::::::"+e);
			  	        }
			  	        
			  	          Thread.sleep(2000);
		        
		        try {
		        driver.findElement(By.xpath("//input[@onclick='displayCalendarSelectBox(document.forms[0].toy,document.forms[0].tom,document.forms[0].tod,false,false,this)']")).click();
		        System.out.println("Date picker clicked");
		        }catch(ElementNotInteractableException e)
		        
		        {
		        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		        	String Error9vii=e.getMessage();
		        	Error=Error+"\n"+"\n"+Error9vii;
		        	MISWriter.write(Error);
		        	MISWriter.close();
		        	e.printStackTrace();
		        	System.out.println("Date picker Not found:::::::::::::::"+e);
		        }
		        
		        
		        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		        
		        try {
		        driver.findElement(By.xpath("/html/body/div[2]/div[4]/div[3]/img")).click();
		        driver.findElement(By.xpath("//*[@id=\"monthDiv_2\"]")).click();
		        driver.findElement(By.xpath("/html/body/div[2]/div[7]/table/tbody/tr[6]/td[2]")).click();
		        System.out.println("date picker month selected");
		        }catch(ElementNotInteractableException e)
		        
		        {
		        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		        	String Error9viii=e.getMessage();
		        	Error=Error+"\n"+"\n"+Error9viii;
		        	MISWriter.write(Error);
		        	MISWriter.close();
		        	e.printStackTrace();
		        	System.out.println("date picker month NOT selected:::::::::::::::"+e);
		        }
		        
		        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		        try {	              
		        driver.findElement(By.xpath("/html/body/div[2]/div[4]/img")).click();
		        System.out.println("Calender close(x) clicked ");
		        }catch(ElementNotInteractableException e)
		        
		        {
		        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		        	String Error9ix=e.getMessage();
		        	Error=Error+"\n"+"\n"+Error9ix;
		        	MISWriter.write(Error);
		        	MISWriter.close();
		        	e.printStackTrace();
		        	System.out.println("Calender close(x) NOT found clicked:::::::::::::::"+e);
		        }
		        
		        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		        try {
	    	        driver.findElement(By.xpath("//input[@value='20']")).click();
	    	        System.out.println("Today Selected.....impl wait");
	    	        }catch(NoSuchElementException e)
	    	        
	    	        {
	    	        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error9x=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error9x;
			        	MISWriter.write(Error);
			        	MISWriter.close();
	    	        	e.printStackTrace();
	    	        	System.out.println("Today Not Selected:::::::::::::::"+e);
	    	        }
	    	        //Thread.sleep(3000);	 
	    	         Thread.sleep(2000);
		    	    try {
	    	  	    driver.findElement(By.xpath("//input[@value='21']")).click();
	    	  	    System.out.println("Last 1 Oneday Selected.....impl wait");
			  	     }catch(NoSuchElementException e)
			  	        
			  	     {
			  	    	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error9xi=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error9xi;
			        	MISWriter.write(Error);
			        	MISWriter.close();
			  	     e.printStackTrace();
			  	     System.out.println("Last 1 Oneday Not Selected:::::::::::::::"+e);
			  	     }
			  	     //Thread.sleep(3000);	 
			  	      Thread.sleep(2000);
		            try {
			        driver.findElement(By.xpath("//input[@value='7']")).click();
			        System.out.println("Last 1 Week Selected.....impl wait");
			        }catch(NoSuchElementException e)
			        
			        {
			        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error9xii=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error9xii;
			        	MISWriter.write(Error);
			        	MISWriter.close();
			        e.printStackTrace();
			        System.out.println("Last 1 Week Not Selected:::::::::::::::"+e);
			        }
		            try {
				    driver.findElement(By.xpath("//input[@value='1']")).click();
			        System.out.println("Last 1 Month Selected.....impl wait");
			        }catch(NoSuchElementException e)
			        
			        {
			        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error9xiii=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error9xiii;
			        	MISWriter.write(Error);
			        	MISWriter.close();
			        	e.printStackTrace();
			        	System.out.println("Last 1  Month Not Selected:::::::::::::::"+e);
			        }
			        
		  	          
		  	        Thread.sleep(2000);
			      
			          driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			        try {	        	        
		  	        WebElement gsname=driver.findElement(By.name("groupsName"));
		  	        Select select3=new Select(gsname);
		  	        select3.selectByVisibleText("Idea");
		  	        System.out.println("Idea Network opened");
		  	        }catch(NoSuchElementException e)
		  	        
		  	        {
		  	        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error9xiv=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error9xiv;
			        	MISWriter.write(Error);
			        	MISWriter.close();
		  	        	e.printStackTrace();
		  	        	System.out.println("Idea Network Not opened:::::::::::::::"+e);
		  	        }
		  	        
		  	          Thread.sleep(2000);
		            try {	        	        
			        WebElement gname=driver.findElement(By.name("groupName"));
			        Select select3=new Select(gname);
			        select3.selectByVisibleText("WiPayTest");
			        System.out.println("WiPayTest Merchant opened");
			        }catch(NoSuchElementException e)
			        
			        {
			        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error9xv=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error9xv;
			        	MISWriter.write(Error);
			        	MISWriter.close();
			        	e.printStackTrace();
			        	System.out.println("WiPayTest Merchant Not opened:::::::::::::::"+e);
			        }
			         
	                try {	        	        
		  	        WebElement zone=driver.findElement(By.name("zoneid"));
		  	        Select select3=new Select(zone);
		  	        select3.selectByVisibleText("East");
		  	        System.out.println("East Zone opened");
		  	        }catch(NoSuchElementException e)
		  	        
		  	        {
		  	        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error9xvi=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error9xvi;
			        	MISWriter.write(Error);
			        	MISWriter.close();
		  	        	e.printStackTrace();
		  	        	System.out.println("East Zone Not opened:::::::::::::::"+e);
		  	        }
		  	        
		  	       Thread.sleep(2000);
		  	       try {	        	        
			  	   WebElement circle=driver.findElement(By.id("circle"));
			  	   Select select3=new Select(circle);
			  	   select3.selectByVisibleText("All");
			  	   System.out.println("Circle All opened");
			  	   }catch(NoSuchElementException e)
			  	   {
			  		 FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error9xvii=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error9xvii;
			        	MISWriter.write(Error);
			        	MISWriter.close();
			  	   e.printStackTrace();
			  	   System.out.println("Circle All Not opened:::::::::::::::"+e);
			  	   }
				  	        
				    Thread.sleep(2000);
				   try {	        	        
				   WebElement ctype=driver.findElement(By.name("Ctype"));
				   Select select3=new Select(ctype);
				   select3.selectByVisibleText("Animations");
				   System.out.println("ContentType Animations opened");
				   }catch(NoSuchElementException e)	  	        
				   {
					   FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error9xviii=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error9xviii;
			        	MISWriter.write(Error);
			        	MISWriter.close();
				   e.printStackTrace();
			       System.out.println("ContentType Animations Not opened:::::::::::::::"+e);
				   }
				   Thread.sleep(2000);
				    try {	        	        
				   WebElement type=driver.findElement(By.name("flags"));
				   Select select3=new Select(type);
				   select3.selectByVisibleText("Promotions");
				   System.out.println("Type Promotions opened");
				   }catch(NoSuchElementException e)
				   {
					   FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error9xix=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error9xix;
			        	MISWriter.write(Error);
			        	MISWriter.close();
				   e.printStackTrace();
				   System.out.println("Type Promotions Not opened:::::::::::::::"+e);
				   }
				   Thread.sleep(3000);
		        try {
		        driver.findElement(By.xpath("//input[@value='Submit']")).click();
		        System.out.println("Page Submit successfull ");
		        }catch(ElementNotInteractableException e)
		        
		        {
		        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		        	String Error9xx=e.getMessage();
		        	Error=Error+"\n"+"\n"+Error9xx;
		        	MISWriter.write(Error);
		        	MISWriter.close();
		        	e.printStackTrace();
		        	System.out.println("Page Submit Failed:::::::::::::::"+e);
		        }
		        
		        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		              
		        System.out.println("Revenue Reports passed in Sanity test");
    }catch(ElementNotInteractableException e)
		        
		        {
		        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		        	String Error9=e.getMessage();
		        	Error=Error+"\n"+"\n"+Error9;
		        	MISWriter.write(Error);
		        	MISWriter.close();
		        	e.printStackTrace();
		        	System.out.println("Transaction Report Not Opened:::::::::::::::"+e);
		        }
		        //TRANSACTION REPORTS CLOSED >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		        Thread.sleep(2000);
       }catch(ElementNotInteractableException e)
		        
		        {
		        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		        	String Error6=e.getMessage();
		        	Error=Error+"\n"+"\n"+Error6;
		        	MISWriter.write(Error);
		        	MISWriter.close();
		        	e.printStackTrace();
		        	System.out.println("Revenue Reports Not Expanded:::::::::::::::"+e);
		        }
               //REVENUE REPORTS CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
		        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		        driver.switchTo().defaultContent();
		        //REVENUE ANALYSIS REPORTS<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		        try {
		        driver.findElement(By.xpath("//a[@title='Revenue Analysis Reports']")).click();
		        System.out.println("Revenue Analysis Reports Expanded...");
		        		        
		        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		        //HOURLY REPORTS OPENED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		        try {
			        driver.findElement(By.xpath("//a[@title='Hourly Report']")).click();
			        System.out.println("Hourly Report Opened...");
			        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			       
			        driver.switchTo().frame(0);
			        
			        try {
			        driver.findElement(By.xpath("//input[@onclick='displayCalendarSelectBox(document.forms[0].fromy,document.forms[0].fromm,document.forms[0].fromd,false,false,this)']")).click();
			        System.out.println("Date picker clicked");
			        }catch(ElementNotInteractableException e)
			        
			        {
			        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error11i=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error11i;
			        	MISWriter.write(Error);
			        	MISWriter.close();
			        	e.printStackTrace();
			        	System.out.println("Date picker click Failed:::::::::::::::"+e);
			        }

			        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			        
			        try {
			        driver.findElement(By.xpath("/html/body/div[5]/div[4]/div[3]/img")).click();
			        driver.findElement(By.xpath("//*[@id=\"monthDiv_1\"]")).click();
			        driver.findElement(By.xpath("/html/body/div[5]/div[7]/table/tbody/tr[5]/td[7]")).click();
			        System.out.println("From date picker month & date selected");
			        }catch(ElementNotInteractableException e)
			        
			        {
			        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error11ii=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error11ii;
			        	MISWriter.write(Error);
			        	MISWriter.close();
			        	e.printStackTrace();
			        	System.out.println("From date picker month & date NOT selected:::::::::::::::"+e);
			        }
			      
			        
			        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			        
			        try {
			        driver.findElement(By.xpath("/html/body/div[5]/div[4]/img")).click();
			        System.out.println("Calender close(x) clicked ");
			        }catch(ElementNotInteractableException e)
			        
			        {
			        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error11iii=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error11iii;
			        	MISWriter.write(Error);
			        	MISWriter.close();
			        	e.printStackTrace();
			        	System.out.println("Calender close(x) NOT found clicked:::::::::::::::"+e);
			        }
			        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			        try {
			        driver.findElement(By.xpath("//input[@onclick='displayCalendarSelectBox(document.forms[0].toy,document.forms[0].tom,document.forms[0].tod,false,false,this)']")).click();
			        System.out.println("To Date picker clicked");
			        }catch(ElementNotInteractableException e)
			        
			        {
			        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error11iv=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error11iv;
			        	MISWriter.write(Error);
			        	MISWriter.close();
			        	e.printStackTrace();
			        	System.out.println("Date picker click Failed:::::::::::::::"+e);
			        }
			        
			        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			        
			        try {
			        driver.findElement(By.xpath("/html/body/div[5]/div[4]/div[3]/img")).click();
			        System.out.println("Month Drop down clicked");
			        driver.findElement(By.xpath("//*[@id=\"monthDiv_2\"]")).click();
			        System.out.println("MARCH Month selected");
			        driver.findElement(By.xpath("/html/body/div[5]/div[7]/table/tbody/tr[6]/td[3]")).click();
			        System.out.println("31st date selected");
			        }catch(ElementNotInteractableException e)
			        
			        {
			        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error11v=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error11v;
			        	MISWriter.write(Error);
			        	MISWriter.close();
			        	e.printStackTrace();
			        	System.out.println("From date picker month & date NOT selected:::::::::::::::"+e);
			        }
			        
			        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			        
			        try {
			        driver.findElement(By.xpath("/html/body/div[5]/div[4]/img")).click();
			        System.out.println("Calender close(x) clicked ");
			        }catch(ElementNotInteractableException e)
			        
			        {
			        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error11vi=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error11vi;
			        	MISWriter.write(Error);
			        	MISWriter.close();
			        	e.printStackTrace();
			        	System.out.println("Calender close(x) NOT found clicked:::::::::::::::"+e);
			        }
			        
			        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			        try {
		    	        driver.findElement(By.xpath("//input[@value='20']")).click();
		    	        System.out.println("Today Selected.....impl wait");
		    	        }catch(NoSuchElementException e)
		    	        
		    	        {
		    	        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				        	String Error11vii=e.getMessage();
				        	Error=Error+"\n"+"\n"+Error11vii;
				        	MISWriter.write(Error);
				        	MISWriter.close();
		    	        	e.printStackTrace();
		    	        	System.out.println("Today Not Selected:::::::::::::::"+e);
		    	        }
		    	        //Thread.sleep(3000);	 
		    	         Thread.sleep(2000);
			    	    try {
		    	  	    driver.findElement(By.xpath("//input[@value='21']")).click();
		    	  	    System.out.println("Last 1 Oneday Selected.....impl wait");
				  	     }catch(NoSuchElementException e)
				  	        
				  	     {
				  	    	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				        	String Error11viii=e.getMessage();
				        	Error=Error+"\n"+"\n"+Error11viii;
				        	MISWriter.write(Error);
				        	MISWriter.close();
				  	     e.printStackTrace();
				  	     System.out.println("Last 1 Oneday Not Selected:::::::::::::::"+e);
				  	     }
				  	     //Thread.sleep(3000);	 
				  	      Thread.sleep(2000);
			            try {
				        driver.findElement(By.xpath("//input[@value='7']")).click();
				        System.out.println("Last 1 Week Selected.....impl wait");
				        }catch(NoSuchElementException e)
				        
				        {
				        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				        	String Error11ix=e.getMessage();
				        	Error=Error+"\n"+"\n"+Error11ix;
				        	MISWriter.write(Error);
				        	MISWriter.close();
				        e.printStackTrace();
				        System.out.println("Last 1 Week Not Selected:::::::::::::::"+e);
				        }
			            try {
					    driver.findElement(By.xpath("//input[@value='1']")).click();
				        System.out.println("Last 1 Month Selected.....impl wait");
				        }catch(NoSuchElementException e)
				        
				        {
				        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				        	String Error11x=e.getMessage();
				        	Error=Error+"\n"+"\n"+Error11x;
				        	MISWriter.write(Error);
				        	MISWriter.close();
				        	e.printStackTrace();
				        	System.out.println("Last 1  Month Not Selected:::::::::::::::"+e);
				        }
				        
			  	          
			  	        Thread.sleep(2000);
				      
				          driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				        try {	        	        
			  	        WebElement gsname=driver.findElement(By.name("groupsName"));
			  	        Select select3=new Select(gsname);
			  	        select3.selectByVisibleText("Idea");
			  	        System.out.println("Idea Network opened");
			  	        }catch(NoSuchElementException e)
			  	        
			  	        {
			  	        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				        	String Error11xi=e.getMessage();
				        	Error=Error+"\n"+"\n"+Error11xi;
				        	MISWriter.write(Error);
				        	MISWriter.close();
			  	        	e.printStackTrace();
			  	        	System.out.println("Idea Network Not opened:::::::::::::::"+e);
			  	        }
			  	        
			  	          Thread.sleep(2000);
			            try {	        	        
				        WebElement gname=driver.findElement(By.name("groupName"));
				        Select select3=new Select(gname);
				        select3.selectByVisibleText("WiPayTest");
				        System.out.println("WiPayTest Merchant opened");
				        }catch(NoSuchElementException e)
				        
				        {
				        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				        	String Error11xii=e.getMessage();
				        	Error=Error+"\n"+"\n"+Error11xii;
				        	MISWriter.write(Error);
				        	MISWriter.close();
				        	e.printStackTrace();
				        	System.out.println("WiPayTest Merchant Not opened:::::::::::::::"+e);
				        }
				         Thread.sleep(2000);
		             try {	        	        
					   WebElement ctype=driver.findElement(By.name("Ctype"));
					   Select select3=new Select(ctype);
					   select3.selectByVisibleText("Animations");
					   System.out.println("ContentType Animations opened");
					   }catch(NoSuchElementException e)	  	        
					   {
						   FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				        	String Error11xiii=e.getMessage();
				        	Error=Error+"\n"+"\n"+Error11xiii;
				        	MISWriter.write(Error);
				        	MISWriter.close();
					   e.printStackTrace();
				       System.out.println("ContentType Animations Not opened:::::::::::::::"+e);
					   }
					   Thread.sleep(2000);
					    try {	        	        
					   WebElement type=driver.findElement(By.name("flags"));
					   Select select3=new Select(type);
					   select3.selectByVisibleText("Promotions");
					   System.out.println("Type Promotions opened");
					   }catch(NoSuchElementException e)
					   {
						   FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				        	String Error11xiv=e.getMessage();
				        	Error=Error+"\n"+"\n"+Error11xiv;
				        	MISWriter.write(Error);
				        	MISWriter.close();
					   e.printStackTrace();
					   System.out.println("Type Promotions Not opened:::::::::::::::"+e);
					   }
					   Thread.sleep(3000);
			        try {
			        driver.findElement(By.xpath("//input[@value='Submit']")).click();
			        System.out.println("Page Submit successfull ");
			        }catch(ElementNotInteractableException e)
			        
			        {
			        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error11xv=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error11xv;
			        	MISWriter.write(Error);
			        	MISWriter.close();
			        	e.printStackTrace();
			        	System.out.println("Page Submit Failed:::::::::::::::"+e);
			        }
			        
			        
			        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			        	             
			        System.out.println("Hourly Report Generated");
			        }catch(ElementNotInteractableException e)
		        
		        {
		        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		        	String Error11=e.getMessage();
		        	Error=Error+"\n"+"\n"+Error11;
		        	MISWriter.write(Error);
		        	MISWriter.close();
		        	e.printStackTrace();
		        	System.out.println("Hourly Report Not Opened:::::::::::::::"+e);
		        }

		       //HOURLY REPORTS CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		        Thread.sleep(2000);
			        
			        driver.switchTo().defaultContent();

				   //WIPAY AVERAGES SUMMARY REPORT<<<<<<<<<<<<<<<<<<<<<<     
			        try {
			        driver.findElement(By.xpath("//a[@title='WiPay Averages Summary Report']")).click();
			        System.out.println("WiPay Averages Summary Report Opened...");
			        Thread.sleep(2000);
			      
			       
		            driver.switchTo().frame(0);
	                try {
			        WebElement frd=driver.findElement(By.name("fromd"));
			        Select frdsel=new Select(frd);
			        frdsel.selectByValue("3");
			        System.out.println("From Date 3 selected");
			        
			        }catch(NoSuchElementException e)
			        
			        {
			        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error12i=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error12i;
			        	MISWriter.write(Error);
			        	MISWriter.close();
			        	e.printStackTrace();
			        	System.out.println("From Date Not selected:::::::::::::::"+e);
			        }
			        
			        Thread.sleep(3000);
			        
			        try {
			        WebElement frm=driver.findElement(By.name("fromm"));
			        Select frdsel2=new Select(frm);
			        frdsel2.selectByValue("2");
			        System.out.println("From month 'FEB' selected");
			        }catch(ElementNotInteractableException e)
			        
			        {
			        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error12ii=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error12ii;
			        	MISWriter.write(Error);
			        	MISWriter.close();
			        	e.printStackTrace();
			        	System.out.println("From month Not selected:::::::::::::::"+e);
			        }
			        Thread.sleep(1000);
			        try {
		  	        WebElement frm=driver.findElement(By.name("fromy"));
		  	        Select frdsel3=new Select(frm);
		  	        frdsel3.selectByValue("2019");
		  	        System.out.println("From year '2019' selected");
		  	        }catch(ElementNotInteractableException e)
		  	        
		  	        {
		  	        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error12iii=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error12iii;
			        	MISWriter.write(Error);
			        	MISWriter.close();
		  	        	e.printStackTrace();
		  	        	System.out.println("From year '2019' Not selected:::::::::::::::"+e);
		  	        }
		  	        
		  	          Thread.sleep(2000);
			        
			        try {
			        WebElement frd2=driver.findElement(By.name("tod"));
			        Select frdsel4=new Select(frd2);
			        frdsel4.selectByValue("23"); 
			        System.out.println("From Date 23 selected");
			        }catch(ElementNotInteractableException e)
			        
			        {
			        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error12iv=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error12iv;
			        	MISWriter.write(Error);
			        	MISWriter.close();
			        	e.printStackTrace();
			        	System.out.println("From Date Not selected:::::::::::::::"+e);
			        }
			          Thread.sleep(2000);
			        
			        try {
			        WebElement frm2=driver.findElement(By.name("tom"));
			        Select frdsel5=new Select(frm2);
			        frdsel5.selectByValue("3");
			        System.out.println("From month 'March' selected");
			        }catch(ElementNotInteractableException e)
			        
			        {
			        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error12v=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error12v;
			        	MISWriter.write(Error);
			        	MISWriter.close();
			        	e.printStackTrace();
			        	System.out.println("From Month Not selected:::::::::::::::"+e);
			        }
			        
			          Thread.sleep(2000);
		            try {
		  	        WebElement frm=driver.findElement(By.name("toy"));
		  	        Select frdsel6=new Select(frm);
		  	        frdsel6.selectByValue("2021");
		  	        System.out.println("From year'2021' selected");
		  	        }catch(ElementNotInteractableException e)
		  	        
		  	        {
		  	        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error12vi=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error12vi;
			        	MISWriter.write(Error);
			        	MISWriter.close();
		  	        	e.printStackTrace();
		  	        	System.out.println("From year'2021' Not selected:::::::::::::::"+e);
		  	        }
		  	        
		  	          Thread.sleep(2000);
		        
		  	        try {
	    	        driver.findElement(By.xpath("//input[@value='D']")).click();
	    	        System.out.println("LifeTimeAvg....impl wait");
	    	        }catch(NoSuchElementException e)
	    	        
	    	        {
	    	        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error12vii=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error12vii;
			        	MISWriter.write(Error);
			        	MISWriter.close();
	    	        	e.printStackTrace();
	    	        	System.out.println("LifeTimeAvg Not Selected:::::::::::::::"+e);
	    	        }
	    	        //Thread.sleep(3000);	 
	    	         Thread.sleep(2000);

				    try {
				        driver.findElement(By.xpath("//input[@value='W']")).click();
				        System.out.println("DayOfWeekAvg....impl wait");
			        }catch(NoSuchElementException e)
			        
			        {
			        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error12viii=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error12viii;
			        	MISWriter.write(Error);
			        	MISWriter.close();
			        	e.printStackTrace();
			        	System.out.println("DayOfWeekAvg Not Selected:::::::::::::::"+e);
			        }
			        //Thread.sleep(3000);	 
			         Thread.sleep(2000);
				     try {	        	        
			  	        WebElement gsname=driver.findElement(By.name("groupsName"));
			  	        Select select3=new Select(gsname);
			  	        select3.selectByVisibleText("Idea");
			  	        System.out.println("Idea Network opened");
			  	        }catch(NoSuchElementException e)
			  	        
			  	        {
			  	        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				        	String Error12ix=e.getMessage();
				        	Error=Error+"\n"+"\n"+Error12ix;
				        	MISWriter.write(Error);
				        	MISWriter.close();
			  	        	e.printStackTrace();
			  	        	System.out.println("Idea Network Not opened:::::::::::::::"+e);
			  	        }
			  	       Thread.sleep(1000);
				        try {	        	        
				        WebElement gname=driver.findElement(By.name("groupName"));
				        Select select3=new Select(gname);
				        select3.selectByVisibleText("WiPayTest");
				        System.out.println("WiPayTest Merchant opened");
				        }catch(NoSuchElementException e)
				        
				        {
				        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				        	String Error12x=e.getMessage();
				        	Error=Error+"\n"+"\n"+Error12x;
				        	MISWriter.write(Error);
				        	MISWriter.close();
				        	e.printStackTrace();
				        	System.out.println("WiPayTest Merchant Not opened:::::::::::::::"+e);
				        }
				        
				          Thread.sleep(1000);
				       
				          try {	        	        
				 			 WebElement bill=driver.findElement(By.name("bill_type"));
				 			 Select select3=new Select( bill);
				 			 select3.selectByVisibleText("ValuePack");
				 			System.out.println("BillType ValuePack opened");
				 			 }catch(NoSuchElementException e)
				 			 {
				 				FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
					        	String Error12xi=e.getMessage();
					        	Error=Error+"\n"+"\n"+Error12xi;
					        	MISWriter.write(Error);
					        	MISWriter.close();
				 			e.printStackTrace();
				 			  System.out.println("BillType ValuePack Not opened:::::::::::::::"+e);
				 			}
				 							  	        
				
				          Thread.sleep(1000);
				          try { 
				    	        driver.findElement(By.xpath("//input[@name='mid_wise']")).click();
				    	        System.out.println("Mid_Wise CheckBox...Selected wait");
				    	        }catch(NoSuchElementException e)
				    	        
				    	        {
				    	        FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
						        	String Error12xii=e.getMessage();
						        	Error=Error+"\n"+"\n"+Error12xii;
						        	MISWriter.write(Error);
						        	MISWriter.close();
				    	        	e.printStackTrace();
				    	        System.out.println("Mid_Wise CheckBoxNot Selected:::::::::::::::"+e);
				    	        }
				    	        //Thread.sleep(3000);	 
				    	         Thread.sleep(2000);
				    	  try {
				    		    driver.findElement(By.xpath("//input[@name='op_wise']")).click();
				    		    System.out.println("op_Wise CheckBox...Selected wait");
				    	        }catch(NoSuchElementException e)
				    	        
				    	        {
				    	        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
						        	String Error12xiii=e.getMessage();
						        	Error=Error+"\n"+"\n"+Error12xiii;
						        	MISWriter.write(Error);
						        	MISWriter.close();
				    	        	e.printStackTrace();
				    	        	System.out.println("DayOfWeekAvg Not Selected:::::::::::::::"+e);
				    	        }
				    	        //Thread.sleep(3000);	 
				    	         Thread.sleep(2000);
				    	         
				    	         
				    	 try {
				              driver.findElement(By.xpath("//input[@name='bill_typewise']")).click();
				    		  System.out.println("bill_typewise CheckBox...Selected wait");
				    	      }catch(NoSuchElementException e)
				    	        
				    	      {
				    	    	  FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
						        	String Error12xiv=e.getMessage();
						        	Error=Error+"\n"+"\n"+Error12xiv;
						        	MISWriter.write(Error);
						        	MISWriter.close();
				    	       e.printStackTrace();
				    	      	System.out.println("bill_typewise Not Selected:::::::::::::::"+e);
				    	      }
				    	       //Thread.sleep(3000);	 
				    	       Thread.sleep(2000);
				        try {
				             driver.findElement(By.xpath("//input[@name='ct_type']")).click();
						     System.out.println("ct_type CheckBox...Selected wait");
						      }catch(NoSuchElementException e)
						        
						      {
						     FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
						        	String Error12xv=e.getMessage();
						        	Error=Error+"\n"+"\n"+Error12xv;
						        	MISWriter.write(Error);
						        	MISWriter.close();
						       e.printStackTrace();
						      	System.out.println("ct_type Not Selected:::::::::::::::"+e);
						      }
						       //Thread.sleep(3000);	 
						       Thread.sleep(2000);
						       
					     try
					     {
					    	 driver.findElement(By.xpath("//input[@name='billreq']")).click();
				    		  System.out.println("billreq CheckBox...Selected wait");
				    	      }catch(NoSuchElementException e)
				    	        
				    	      {
				    	    	  FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
						        	String Error12xvi=e.getMessage();
						        	Error=Error+"\n"+"\n"+Error12xvi;
						        	MISWriter.write(Error);
						        	MISWriter.close();
				    	       e.printStackTrace();
				    	      	System.out.println("billreq Not Selected:::::::::::::::"+e);
				    	       }
				    	       //Thread.sleep(3000);	 
				    	       Thread.sleep(2000);
				    	       
				    	    try
				    	    {
				    	    	driver.findElement(By.xpath("//input[@name='ubillreq']")).click();
					    		System.out.println("ubillreq CheckBox...Selected wait");
					    	    }catch(NoSuchElementException e)
					    	        
					    	    {
					    	    FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
						        	String Error12xvii=e.getMessage();
						        	Error=Error+"\n"+"\n"+Error12xvii;
						        	MISWriter.write(Error);
						        	MISWriter.close();
					    	     e.printStackTrace();
					    	     System.out.println("ubillreq Not Selected:::::::::::::::"+e);
					    	     }
					    	       //Thread.sleep(3000);	 
					    	    Thread.sleep(2000);
					     try
					    {
					     	driver.findElement(By.xpath("//input[@name='billerror']")).click();
				    		System.out.println("billerror CheckBox...Selected wait");
				    	    }catch(NoSuchElementException e)
				    	        
				    	    {
				    	    	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
					        	String Error12xviii=e.getMessage();
					        	Error=Error+"\n"+"\n"+Error12xviii;
					        	MISWriter.write(Error);
					        	MISWriter.close();
				    	     e.printStackTrace();
				    	     System.out.println("billerror Not Selected:::::::::::::::"+e);
				    	     }
				    	       //Thread.sleep(3000);	 
				    	    Thread.sleep(2000);
				    	    
				       try
				    	    {
				
					     	driver.findElement(By.xpath("//input[@name='lowbal']")).click();
				    		System.out.println("lowbal CheckBox...Selected wait");
				    	    }catch(NoSuchElementException e)
				    	        
				    	    {
				    	    	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
					        	String Error12xix=e.getMessage();
					        	Error=Error+"\n"+"\n"+Error12xix;
					        	MISWriter.write(Error);
					        	MISWriter.close();
				    	     e.printStackTrace();
				    	     System.out.println("lowbal Not Selected:::::::::::::::"+e);
				    	     }
				    	       //Thread.sleep(3000);	 
				    	    Thread.sleep(2000);
				    	    
				    	  try
				    	  {
				    	driver.findElement(By.xpath("//input[@name='bills']")).click();
					    System.out.println("bills CheckBox...Selected wait");
					      }catch(NoSuchElementException e)
					    	        
					     {
					    	  FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
					        	String Error12xx=e.getMessage();
					        	Error=Error+"\n"+"\n"+Error12xx;
					        	MISWriter.write(Error);
					        	MISWriter.close();
					    e.printStackTrace();
					    System.out.println("bills Not Selected:::::::::::::::"+e);
					     }
					    	       //Thread.sleep(3000);	 
					     Thread.sleep(2000);
				    	   try
				    	   {
				    		   driver.findElement(By.xpath("//input[@name='ubills']")).click();
							    System.out.println("ubills CheckBox...Selected wait");
							      }catch(NoSuchElementException e)
							    	        
							     {
							  FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error12xxi=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error12xxi;
							        	MISWriter.write(Error);
							        	MISWriter.close();
							    e.printStackTrace();
							    System.out.println("ubills Not Selected:::::::::::::::"+e);
							     }
							    	       //Thread.sleep(3000);	 
							     Thread.sleep(2000);	
							  try
							  {
								driver.findElement(By.xpath("//input[@name='rev_dsp']")).click();
								System.out.println("rev_dsp CheckBox...Selected wait");
								 }catch(NoSuchElementException e)
								    	        
								 {
							 FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error12xxii=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error12xxii;
							        	MISWriter.write(Error);
							        	MISWriter.close();
								 e.printStackTrace();
								 System.out.println("rev_dsp Not Selected:::::::::::::::"+e);
								 }
								    	       //Thread.sleep(3000);	 
								 Thread.sleep(2000);	  
							 
				         /* try {
					  		  driver.findElement(By.xpath("//input[@name='mid_wise']")).click();
					  		  System.out.println("MerchantWise Selected....");
					  		  }catch(NoSuchElementException e)
					  		        
					  		  {
					  		   e.printStackTrace();
					  		   System.out.println("MerchantWise Not Selected:::::::::::::::"+e);
					  		  }
					  		 //Thread.sleep(3000);	*/ 
				          try {
						        driver.findElement(By.xpath("//input[@value='Submit']")).click();
						        System.out.println("Form Submitted");
						        
						        }catch(ElementNotInteractableException e)
						        
						        {
						      FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
						        	String Error12xxiii=e.getMessage();
						        	Error=Error+"\n"+"\n"+Error12xxiii;
						        	MISWriter.write(Error);
						        	MISWriter.close();
						        	e.printStackTrace();
						        	System.out.println("Form Not submited:::::::::::::::"+e);
						        }
						        
						        Thread.sleep(2000);
                }catch(ElementNotInteractableException e)
			        
			        {
			        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error12=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error12;
			        	MISWriter.write(Error);
			        	MISWriter.close();
			        	e.printStackTrace();
			        	System.out.println("WiPay Averages Summary Report NOT Opened...:::::::::::::::"+e);
			        }
			        //WIPAY AVERAGES SUMMARY REPORTS CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		            Thread.sleep(2000);
						        try {
						        driver.switchTo().defaultContent();
						        
						        }catch(UnhandledAlertException e)
						        
						        {
						      FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
						        	String Erroro=e.getMessage();
						        	Error=Error+"\n"+"\n"+Erroro;
						        	MISWriter.write(Error);
						        	MISWriter.close();
						        	e.printStackTrace();
						        	System.out.println("Default frame not selected:::::::::::::::"+e);
						        }
						          Thread.sleep(2000);
					  //HOURLY SUMMARY REPORTS<<<<<<<<<<<<<<<<<<<<<<<<<  	   
		        try {	       
		        driver.findElement(By.xpath("//a[@title='Hourly Summary Report']")).click();
		        System.out.println("Hourly Summary Report Opened...");
		        Thread.sleep(200);
		       
		        
	            driver.switchTo().frame(0);
		        
	                   

		        try {
		        WebElement frd=driver.findElement(By.name("fromd"));
		        Select frdsel=new Select(frd);
		        frdsel.selectByValue("3");
		        System.out.println("From Date 3 selected");
		        
		        }catch(NoSuchElementException e)
		        
		        {
		        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		        	String Error13i=e.getMessage();
		        	Error=Error+"\n"+"\n"+Error13i;
		        	MISWriter.write(Error);
		        	MISWriter.close();
		        	e.printStackTrace();
		        	System.out.println("From Date Not selected:::::::::::::::"+e);
		        }
		        
		        Thread.sleep(3000);
		        
		        try {
		        WebElement frm=driver.findElement(By.name("fromm"));
		        Select frdsel2=new Select(frm);
		        frdsel2.selectByValue("2");
		        System.out.println("From month 'FEB' selected");
		        }catch(ElementNotInteractableException e)
		        
		        {
		        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		        	String Error13ii=e.getMessage();
		        	Error=Error+"\n"+"\n"+Error13ii;
		        	MISWriter.write(Error);
		        	MISWriter.close();
		        	e.printStackTrace();
		        	System.out.println("From month Not selected:::::::::::::::"+e);
		        }
		        Thread.sleep(1000);
		        try {
		  	        WebElement frm=driver.findElement(By.name("fromy"));
		  	        Select frdsel3=new Select(frm);
		  	        frdsel3.selectByValue("2019");
		  	        System.out.println("From year '2019' selected");
		  	        }catch(ElementNotInteractableException e)
		  	        
		  	        {
		  	        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error13iii=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error13iii;
			        	MISWriter.write(Error);
			        	MISWriter.close();
		  	        	e.printStackTrace();
		  	        	System.out.println("From year '2019' Not selected:::::::::::::::"+e);
		  	        }
		  	        
		  	          Thread.sleep(2000);
		        
		        try {
		        WebElement frd2=driver.findElement(By.name("tod"));
		        Select frdsel4=new Select(frd2);
		        frdsel4.selectByValue("23"); 
		        System.out.println("From Date 23 selected");
		        }catch(ElementNotInteractableException e)
		        
		        {
		        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		        	String Error13iv=e.getMessage();
		        	Error=Error+"\n"+"\n"+Error13iv;
		        	MISWriter.write(Error);
		        	MISWriter.close();
		        	e.printStackTrace();
		        	System.out.println("From Date Not selected:::::::::::::::"+e);
		        }
		          Thread.sleep(2000);
		        
		        try {
		        WebElement frm2=driver.findElement(By.name("tom"));
		        Select frdsel5=new Select(frm2);
		        frdsel5.selectByValue("3");
		        System.out.println("From month 'March' selected");
		        }catch(ElementNotInteractableException e)
		        
		        {
		        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		        	String Error13v=e.getMessage();
		        	Error=Error+"\n"+"\n"+Error13v;
		        	MISWriter.write(Error);
		        	MISWriter.close();
		        	e.printStackTrace();
		        	System.out.println("From Month Not selected:::::::::::::::"+e);
		        }
		        
		          Thread.sleep(2000);
		         try {
		  	        WebElement frm=driver.findElement(By.name("toy"));
		  	        Select frdsel6=new Select(frm);
		  	        frdsel6.selectByValue("2021");
		  	        System.out.println("From year'2021' selected");
		  	        }catch(ElementNotInteractableException e)
		  	        
		  	        {
		  	        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error13vi=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error13vi;
			        	MISWriter.write(Error);
			        	MISWriter.close();
		  	        	e.printStackTrace();
		  	        	System.out.println("From year'2021' Not selected:::::::::::::::"+e);
		  	        }
		  	        
		  	          Thread.sleep(2000);
		  	        try {
		    	        driver.findElement(By.xpath("//input[@value='20']")).click();
		    	        System.out.println("Today Selected.....impl wait");
		    	        }catch(NoSuchElementException e)
		    	        
		    	        {
		    	        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				        	String Error13vii=e.getMessage();
				        	Error=Error+"\n"+"\n"+Error13vii;
				        	MISWriter.write(Error);
				        	MISWriter.close();
		    	        	e.printStackTrace();
		    	        	System.out.println("Today Not Selected:::::::::::::::"+e);
		    	        }
		    	        //Thread.sleep(3000);	 
		    	         Thread.sleep(2000);
		    	    try {
		    	  	    driver.findElement(By.xpath("//input[@value='21']")).click();
		    	  	    System.out.println("Last 1 Oneday Selected.....impl wait");
		    	  	     }catch(NoSuchElementException e)
		    	  	        
		    	  	     {
		    	  	    	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				        	String Error13viii=e.getMessage();
				        	Error=Error+"\n"+"\n"+Error13viii;
				        	MISWriter.write(Error);
				        	MISWriter.close();
		    	  	     e.printStackTrace();
		    	  	     System.out.println("Last 1 Oneday Not Selected:::::::::::::::"+e);
		    	  	     }
		    	  	     //Thread.sleep(3000);	 
		    	  	      Thread.sleep(2000);
		    	  	 try {
		    	  		  driver.findElement(By.xpath("//input[@value='7']")).click();
		    	  		  System.out.println("Last 1 Week Selected.....impl wait");
		    	  		  }catch(NoSuchElementException e)
		    	  		        
		    	  		  {
		    	  			FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				        	String Error13ix=e.getMessage();
				        	Error=Error+"\n"+"\n"+Error13ix;
				        	MISWriter.write(Error);
				        	MISWriter.close();
		    	  		   e.printStackTrace();
		    	  		   System.out.println("Last 1 Week Not Selected:::::::::::::::"+e);
		    	  		  }
		    	  		 //Thread.sleep(3000);	 
		    	    Thread.sleep(2000);
		            try {
			        driver.findElement(By.xpath("//input[@value='1']")).click();
			        System.out.println("Last 1 Month Selected.....impl wait");
			        }catch(NoSuchElementException e)
			        
			        {
			        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error13x=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error13x;
			        	MISWriter.write(Error);
			        	MISWriter.close();
			        	e.printStackTrace();
			        	System.out.println("Last 1  Month Not Selected:::::::::::::::"+e);
			        }
			        //Thread.sleep(3000);	 
		            try {
		    	        driver.findElement(By.xpath("//input[@value='C']")).click();
		    	        System.out.println("Cumulative.....impl wait");
		    	        }catch(NoSuchElementException e)
		    	        
		    	        {
		    	        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				        	String Error13xi=e.getMessage();
				        	Error=Error+"\n"+"\n"+Error13xi;
				        	MISWriter.write(Error);
				        	MISWriter.close();
		    	        	e.printStackTrace();
		    	        	System.out.println("Cumulative Not Selected:::::::::::::::"+e);
		    	        }
		    	        //Thread.sleep(3000);	 
		    	         Thread.sleep(2000);
		    	       try
		    	       {
		    	    	  driver.findElement(By.xpath("//input[@value='D']")).click();
			    	      System.out.println("DayWise.....impl wait");
			    	      }catch(NoSuchElementException e)
		    	       { 
			    	    	  FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
					        	String Error13xii=e.getMessage();
					        	Error=Error+"\n"+"\n"+Error13xii;
					        	MISWriter.write(Error);
					        	MISWriter.close();
			    	      e.printStackTrace();
			    	      System.out.println("DayWise Not Selected:::::::::::::::"+e);
			    	      }
			    	        //Thread.sleep(3000);	 
			    	     Thread.sleep(2000); 
			    	   
		    	      try
		    	      {
		    	    	  
		    	    	  driver.findElement(By.xpath("//input[@value='A']")).click();
			    	        System.out.println("Comparative.....impl wait");
			    	        }catch(NoSuchElementException e)
			    	        
			    	        {
			    	        FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
					        	String Error13xiii=e.getMessage();
					        	Error=Error+"\n"+"\n"+Error13xiii;
					        	MISWriter.write(Error);
					        	MISWriter.close();
			    	        	e.printStackTrace();
			    	        	System.out.println("Comparative Not Selected:::::::::::::::"+e);
			    	        }
			    	        //Thread.sleep(3000);	 
			    	         Thread.sleep(2000);
			    	    try
			    	    {
			    	    	
			    	    	driver.findElement(By.xpath("//input[@value='W']")).click();
			    	        System.out.println("DayOfWeek....impl wait");
			    	        }catch(NoSuchElementException e)
			    	        
			    	        {
			    	        FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
					        	String Error13xiv=e.getMessage();
					        	Error=Error+"\n"+"\n"+Error13xiv;
					        	MISWriter.write(Error);
					        	MISWriter.close();
			    	        	e.printStackTrace();
			    	        	System.out.println("DayOfWeek Not Selected:::::::::::::::"+e);
			    	        }
			    	        //Thread.sleep(3000);	 
			    	         Thread.sleep(2000);
			    	         try {	        	        
						  	        WebElement gsname=driver.findElement(By.name("groupsName"));
						  	        Select select3=new Select(gsname);
						  	        select3.selectByVisibleText("Idea");
						  	        System.out.println("Idea Network opened");
						  	        }catch(NoSuchElementException e)
						  	        
						  	        {
						  	  FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error13xv=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error13xv;
							        	MISWriter.write(Error);
							        	MISWriter.close();
						  	        	e.printStackTrace();
						  	        	System.out.println("Idea Network Not opened:::::::::::::::"+e);
						  	        }
						  	        
						  	          Thread.sleep(1000);
						        try {	        	        
						        WebElement gname=driver.findElement(By.name("groupName"));
						        Select select3=new Select(gname);
						        select3.selectByVisibleText("WiPayTest");
						        System.out.println("WiPayTest Merchant opened");
						        }catch(NoSuchElementException e)
						        
						        {
						      FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
						        	String Error13xvi=e.getMessage();
						        	Error=Error+"\n"+"\n"+Error13xvi;
						        	MISWriter.write(Error);
						        	MISWriter.close();
						        	e.printStackTrace();
						       System.out.println("WiPayTest Merchant Not opened:::::::::::::::"+e);
						        }
						        
						          Thread.sleep(1000);
						       
						          try {	        	        
						 			 WebElement bill=driver.findElement(By.name("bill_type"));
						 			 Select select3=new Select( bill);
						 			 select3.selectByVisibleText("ValuePack");
						 			System.out.println("BillType ValuePack opened");
						 			 }catch(NoSuchElementException e)
						 			 {
						 	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error13xvii=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error13xvii;
							        	MISWriter.write(Error);
							        	MISWriter.close();
						 			e.printStackTrace();
						 		System.out.println("BillType ValuePack Not opened:::::::::::::::"+e);
						 			}
						 							  	        

						          Thread.sleep(1000);
						          try {
						    	        driver.findElement(By.xpath("//input[@name='count_dsp']")).click();
						    	        System.out.println("CountDisplay....impl wait");
						    	        }catch(NoSuchElementException e)
						    	        
						    	        {
						   FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
								        	String Error13xviii=e.getMessage();
								        	Error=Error+"\n"+"\n"+Error13xviii;
								        	MISWriter.write(Error);
								        	MISWriter.close();
						    	        	e.printStackTrace();
						    	   	System.out.println("CountDisplay Not Selected:::::::::::::::"+e);
						    	        }
						    	        //Thread.sleep(3000);	 
						    	         Thread.sleep(2000);
						    	         
						    	         
						    	  try
						    	  {
						    		  driver.findElement(By.xpath("//input[@name='rev_dsp']")).click();
						    	        System.out.println("RevenueDisplay....impl wait");
						    	        }catch(NoSuchElementException e)
						    	        
						    	        {
						   FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
								        	String Error13xix=e.getMessage();
								        	Error=Error+"\n"+"\n"+Error13xix;
								        	MISWriter.write(Error);
								        	MISWriter.close();
						    	        	e.printStackTrace();
						    	     System.out.println("RevenueDisplay Not Selected:::::::::::::::"+e);
						    	        }
						    	        //Thread.sleep(3000);	 
						    	         Thread.sleep(2000);
							    	  	
		  	        try {
				        driver.findElement(By.xpath("//input[@value='Submit']")).click();
				        System.out.println("Form Submitted");
				        
				        }catch(ElementNotInteractableException e)
				        
				        {
				        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				        	String Error13xx=e.getMessage();
				        	Error=Error+"\n"+"\n"+Error13xx;
				        	MISWriter.write(Error);
				        	MISWriter.close();
				        	e.printStackTrace();
				        	System.out.println("Form Not submited:::::::::::::::"+e);
				        }
             }catch(ElementNotInteractableException e)
		        
		        {
		        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		        	String Error13=e.getMessage();
		        	Error=Error+"\n"+"\n"+Error13;
		        	MISWriter.write(Error);
		        	MISWriter.close();
		        	e.printStackTrace();
		        	System.out.println("Hourly Summary Report NOT Opened...:::::::::::::::"+e);
		        }
		        //HOURLY SUMMARY REPORTS CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        Thread.sleep(2000);
				        Thread.sleep(2000);
				        try {
				        driver.switchTo().defaultContent();
				        
				        }catch(UnhandledAlertException e)
				        
				        {
				        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				        	String Errork=e.getMessage();
				        	Error=Error+"\n"+"\n"+Errork;
				        	MISWriter.write(Error);
				        	MISWriter.close();
				        	e.printStackTrace();
				        	System.out.println("Default frame not selected:::::::::::::::"+e);
				        }
				          Thread.sleep(2000);
				          //SUB ANALYTICS REPORT OPENED<<<<<<<<<<<<<<<<<<<<<<<
				          try {
				          driver.findElement(By.xpath("//a[@title='Sub Analytics Report']")).click();
					        System.out.println("Sub Analytics Report Opened...");
					        Thread.sleep(2000);
					        driver.switchTo().frame(0);
					        
			                

					        try {
					        WebElement frd=driver.findElement(By.name("fromd"));
					        Select frdsel=new Select(frd);
					        frdsel.selectByValue("3");
					        System.out.println("From Date 3 selected");
					        
					        }catch(NoSuchElementException e)
					        
					        {
					       FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
					        	String Error14i=e.getMessage();
					        	Error=Error+"\n"+"\n"+Error14i;
					        	MISWriter.write(Error);
					        	MISWriter.close();
					        	e.printStackTrace();
					        	System.out.println("From Date Not selected:::::::::::::::"+e);
					        }
					        
					        Thread.sleep(2000);
					        
					        try {
					        WebElement frm=driver.findElement(By.name("fromm"));
					        Select frdsel2=new Select(frm);
					        frdsel2.selectByValue("2");
					        System.out.println("From month 'FEB' selected");
					        }catch(ElementNotInteractableException e)
					        
					        {
					        FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
					        	String Error14ii=e.getMessage();
					        	Error=Error+"\n"+"\n"+Error14ii;
					        	MISWriter.write(Error);
					        	MISWriter.close();
					        	e.printStackTrace();
					        	System.out.println("From month Not selected:::::::::::::::"+e);
					        }
					        Thread.sleep(2000);
					        try {
					  	        WebElement frm=driver.findElement(By.name("fromy"));
					  	        Select frdsel3=new Select(frm);
					  	        frdsel3.selectByValue("2019");
					  	        System.out.println("From year '2019' selected");
					  	        }catch(ElementNotInteractableException e)
					  	        
					  	        {
					  	      FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
						        	String Error14iii=e.getMessage();
						        	Error=Error+"\n"+"\n"+Error14iii;
						        	MISWriter.write(Error);
						        	MISWriter.close();
					  	        	e.printStackTrace();
					  	       System.out.println("From year '2019' Not selected:::::::::::::::"+e);
					  	        }
					  	        
					  	          Thread.sleep(2000);
					  	        try
					    	    {
					    	    	
					    	    	driver.findElement(By.xpath("//input[@value='o']")).click();
					    	        System.out.println("OperatorWise...impl wait");
					    	        }catch(NoSuchElementException e)
					    	        
					    	        {
					    	 FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error14iv=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error14iv;
							        	MISWriter.write(Error);
							        	MISWriter.close();
					    	        	e.printStackTrace();
					    	        	System.out.println("OperatorWise Not Selected:::::::::::::::"+e);
					    	        }
					    	        //Thread.sleep(3000);	 
					    	         Thread.sleep(2000);
					    	     try
					    	     {

						    	   driver.findElement(By.xpath("//input[@value='m']")).click();
						    	    System.out.println("MerchantWise...impl wait");
						    	    }catch(NoSuchElementException e)
						    	        
						    	    {
						    FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error14v=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error14v;
							        	MISWriter.write(Error);
							        	MISWriter.close();
						    	   	e.printStackTrace();
						    	   	System.out.println("MerchantWise Not Selected:::::::::::::::"+e);
						    	    }
						    	        //Thread.sleep(3000);	 
						    	         Thread.sleep(2000);
					  	          
					  	        try {
							        driver.findElement(By.xpath("//input[@value='Submit']")).click();
							        System.out.println("Form Submitted");
							        
							        }catch(ElementNotInteractableException e)
							        
							        {
							  FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error14vi=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error14vi;
							        	MISWriter.write(Error);
							        	MISWriter.close();
							        	e.printStackTrace();
							        	System.out.println("Form Not submited:::::::::::::::"+e);
							        }
				          }catch(ElementNotInteractableException e)
					        
					        {
					  FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
					        	String Error14=e.getMessage();
					        	Error=Error+"\n"+"\n"+Error14;
					        	MISWriter.write(Error);
					        	MISWriter.close();
					        	e.printStackTrace();
					       System.out.println("SUB ANALYTIC REPORTS Not Opened:::::::::::::::"+e);
					        }
				          //SUB ANALYTIC REPORTS CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
							        Thread.sleep(2000);
							        try {
							        driver.switchTo().defaultContent();
							        
							        }catch(UnhandledAlertException e)
							        
							        {
							  FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Errorn=e.getMessage();
							        	Error=Error+"\n"+"\n"+Errorn;
							        	MISWriter.write(Error);
							        	MISWriter.close();
							        	e.printStackTrace();
							        System.out.println("Default frame not selected:::::::::::::::"+e);
							        }
							       Thread.sleep(2000);
		        
		        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				 //DAILY SUMMARY REPORTS<<<<<<<<<<<<<<<<<<<<<<<<<<
		        try {
		        driver.findElement(By.xpath("//a[@title='Daily Summary Report']")).click();
		        System.out.println("Daily Summary Report Opened...");
		        Thread.sleep(200);
		        
	            driver.switchTo().frame(0);
		        
	                   

		        try {
		        WebElement frd=driver.findElement(By.name("fromd"));
		        Select frdsel=new Select(frd);
		        frdsel.selectByValue("3");
		        System.out.println("From Date 3 selected");
		        
		        }catch(NoSuchElementException e)
		        
		        {
		        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		        	String Error15i=e.getMessage();
		        	Error=Error+"\n"+"\n"+Error15i;
		        	MISWriter.write(Error);
		        	MISWriter.close();
		        	e.printStackTrace();
		        	System.out.println("From Date Not selected:::::::::::::::"+e);
		        }
		        
		        Thread.sleep(3000);
		        
		        try {
		        WebElement frm=driver.findElement(By.name("fromm"));
		        Select frdsel2=new Select(frm);
		        frdsel2.selectByValue("2");
		        System.out.println("From month 'FEB' selected");
		        }catch(ElementNotInteractableException e)
		        
		        {
		        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		        	String Error15ii=e.getMessage();
		        	Error=Error+"\n"+"\n"+Error15ii;
		        	MISWriter.write(Error);
		        	MISWriter.close();
		        	e.printStackTrace();
		        	System.out.println("From month Not selected:::::::::::::::"+e);
		        }
		        Thread.sleep(1000);
		        try {
		  	        WebElement frm=driver.findElement(By.name("fromy"));
		  	        Select frdsel3=new Select(frm);
		  	        frdsel3.selectByValue("2019");
		  	        System.out.println("From year '2019' selected");
		  	        }catch(ElementNotInteractableException e)
		  	        
		  	        {
		  	        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error15iii=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error15iii;
			        	MISWriter.write(Error);
			        	MISWriter.close();
		  	        	e.printStackTrace();
		  	        	System.out.println("From year '2019' Not selected:::::::::::::::"+e);
		  	        }
		  	        
		  	          Thread.sleep(2000);
		        
		        try {
		        WebElement frd2=driver.findElement(By.name("tod"));
		        Select frdsel4=new Select(frd2);
		        frdsel4.selectByValue("23"); 
		        System.out.println("From Date 23 selected");
		        }catch(ElementNotInteractableException e)
		        
		        {
		        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		        	String Error15iv=e.getMessage();
		        	Error=Error+"\n"+"\n"+Error15iv;
		        	MISWriter.write(Error);
		        	MISWriter.close();
		        	e.printStackTrace();
		        	System.out.println("From Date Not selected:::::::::::::::"+e);
		        }
		          Thread.sleep(2000);
		        
		        try {
		        WebElement frm2=driver.findElement(By.name("tom"));
		        Select frdsel5=new Select(frm2);
		        frdsel5.selectByValue("3");
		        System.out.println("From month 'March' selected");
		        }catch(ElementNotInteractableException e)
		        
		        {
		        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		        	String Error15v=e.getMessage();
		        	Error=Error+"\n"+"\n"+Error15v;
		        	MISWriter.write(Error);
		        	MISWriter.close();
		        	e.printStackTrace();
		        	System.out.println("From Month Not selected:::::::::::::::"+e);
		        }
		        
		          Thread.sleep(2000);
		         try {
		  	        WebElement frm=driver.findElement(By.name("toy"));
		  	        Select frdsel6=new Select(frm);
		  	        frdsel6.selectByValue("2021");
		  	        System.out.println("From year'2021' selected");
		  	        }catch(ElementNotInteractableException e)
		  	        
		  	        {
		  	        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error15vi=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error15vi;
			        	MISWriter.write(Error);
			        	MISWriter.close();
		  	        	e.printStackTrace();
		  	        	System.out.println("From year'2021' Not selected:::::::::::::::"+e);
		  	        }
		  	        
		  	          Thread.sleep(2000);
		  	          
		  	        try {
		    	        driver.findElement(By.xpath("//input[@value='20']")).click();
		    	        System.out.println("Today Selected.....impl wait");
		    	        }catch(NoSuchElementException e)
		    	        
		    	        {
		    	        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				        	String Error15vii=e.getMessage();
				        	Error=Error+"\n"+"\n"+Error15vii;
				        	MISWriter.write(Error);
				        	MISWriter.close();
		    	        	e.printStackTrace();
		    	        	System.out.println("Today Not Selected:::::::::::::::"+e);
		    	        }
		    	        //Thread.sleep(3000);	 
		    	         Thread.sleep(2000);
		    	    try {
		    	  	    driver.findElement(By.xpath("//input[@value='21']")).click();
		    	  	    System.out.println("Last 1 Oneday Selected.....impl wait");
		    	  	     }catch(NoSuchElementException e)
		    	  	        
		    	  	     {
		    	  	    	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				        	String Error15viii=e.getMessage();
				        	Error=Error+"\n"+"\n"+Error15viii;
				        	MISWriter.write(Error);
				        	MISWriter.close();
		    	  	     e.printStackTrace();
		    	  	     System.out.println("Last 1 Oneday Not Selected:::::::::::::::"+e);
		    	  	     }
		    	  	     //Thread.sleep(3000);	 
		    	  	      Thread.sleep(2000);
		    	  	 try {
		    	  		  driver.findElement(By.xpath("//input[@value='7']")).click();
		    	  		  System.out.println("Last 1 Week Selected.....impl wait");
		    	  		  }catch(NoSuchElementException e)
		    	  		        
		    	  		  {
		    	  			FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				        	String Error15ix=e.getMessage();
				        	Error=Error+"\n"+"\n"+Error15ix;
				        	MISWriter.write(Error);
				        	MISWriter.close();
		    	  		   e.printStackTrace();
		    	  		   System.out.println("Last 1 Week Not Selected:::::::::::::::"+e);
		    	  		  }
		    	  		 //Thread.sleep(3000);	 
		    	    Thread.sleep(2000);
		            try {
			        driver.findElement(By.xpath("//input[@value='1']")).click();
			        System.out.println("Last 1 Month Selected.....impl wait");
			        }catch(NoSuchElementException e)
			        
			        {
			        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
			        	String Error15x=e.getMessage();
			        	Error=Error+"\n"+"\n"+Error15x;
			        	MISWriter.write(Error);
			        	MISWriter.close();
			        	e.printStackTrace();
			        	System.out.println("Last 1  Month Not Selected:::::::::::::::"+e);
			        }
			        //Thread.sleep(3000);	 
		        
		  	        try {
		
		  	        	driver.findElement(By.xpath("//input[@value='C']")).click();
		    	        System.out.println("Cumulative...impl wait");
		    	        }catch(NoSuchElementException e)
		    	        
		    	        {
		    	        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				        	String Error15xi=e.getMessage();
				        	Error=Error+"\n"+"\n"+Error15xi;
				        	MISWriter.write(Error);
				        	MISWriter.close();
		    	        	e.printStackTrace();
		    	        	System.out.println("Cumulative Not Selected:::::::::::::::"+e);
		    	        }
		    	        //Thread.sleep(3000);	 
		    	         Thread.sleep(2000);

				  	        try {
				    	        driver.findElement(By.xpath("//input[@value='D']")).click();
				    	        System.out.println("DaysWise....impl wait");
				    	        }catch(NoSuchElementException e)
				    	        
				    	        {
				    	      FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
						        	String Error15xii=e.getMessage();
						        	Error=Error+"\n"+"\n"+Error15xii;
						        	MISWriter.write(Error);
						        	MISWriter.close();
				    	        	e.printStackTrace();
				    	        	System.out.println("DaysWise Not Selected:::::::::::::::"+e);
				    	        }
				    	        //Thread.sleep(3000);	 
				    	         Thread.sleep(2000);
					    	  	
					  	        try {	        	        
						  	        WebElement gsname=driver.findElement(By.name("groupsName"));
						  	        Select select3=new Select(gsname);
						  	        select3.selectByVisibleText("Idea");
						  	        System.out.println("Idea Network opened");
						  	        }catch(NoSuchElementException e)
						  	        
						  	        {
						  	  FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error15xiii=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error15xiii;
							        	MISWriter.write(Error);
							        	MISWriter.close();
						  	        	e.printStackTrace();
						  	        	System.out.println("Idea Network Not opened:::::::::::::::"+e);
						  	        }
						  	        
						  	          Thread.sleep(1000);
						        try {	        	        
						        WebElement gname=driver.findElement(By.name("groupName"));
						        Select select3=new Select(gname);
						        select3.selectByVisibleText("WiPayTest");
						        System.out.println("WiPayTest Merchant opened");
						        }catch(NoSuchElementException e)
						        
						        {
						      FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
						        	String Error15xiv=e.getMessage();
						        	Error=Error+"\n"+"\n"+Error15xiv;
						        	MISWriter.write(Error);
						        	MISWriter.close();
						        	e.printStackTrace();
						        	System.out.println("WiPayTest Merchant Not opened:::::::::::::::"+e);
						        }
						        
						          Thread.sleep(1000);
						          try {
								        driver.findElement(By.xpath("//input[@value='Submit']")).click();
								        System.out.println("Form Submitted");
								        
								        }catch(ElementNotInteractableException e)
								        
								        {
							FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
								        	String Error15xv=e.getMessage();
								        	Error=Error+"\n"+"\n"+Error15xv;
								        	MISWriter.write(Error);
								        	MISWriter.close();
								        	e.printStackTrace();
								        	System.out.println("Form Not submited:::::::::::::::"+e);
								        }
						          Thread.sleep(2000);
               }catch(ElementNotInteractableException e)
		        
		        {
		        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
		        	String Error15=e.getMessage();
		        	Error=Error+"\n"+"\n"+Error15;
		        	MISWriter.write(Error);
		        	MISWriter.close();
		        	e.printStackTrace();
		        	System.out.println("DAILY  Summary Report NOT Opened...:::::::::::::::"+e);
		        }
		        //DAILY SUMMARY REPORTS CLOSED>>>>>>>>>>>>>>>>>>>>>
        Thread.sleep(2000);
	     try {
				  driver.switchTo().defaultContent();
								        
			  }catch(UnhandledAlertException e)
										        {
						FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
								        	String Errorj=e.getMessage();
								        	Error=Error+"\n"+"\n"+Errorj;
								        	MISWriter.write(Error);
								        	MISWriter.close();
								        	e.printStackTrace();
								     System.out.println("Default frame not selected:::::::::::::::"+e);
								        }
								          Thread.sleep(2000);
								        //DAILY AGGREGATION REPORT OPENED<<<<<<<<<<<<<<<<<<<<<<<<<<<<
										     try {  
						        
								  driver.findElement(By.xpath("//a[@title='Daily Aggregation Report']")).click();
						          System.out.println("Daily Aggregation Report..");
						          Thread.sleep(200);
						          driver.switchTo().frame(0);
							        
				                  

							        try {
							        WebElement frd=driver.findElement(By.name("fromd"));
							        Select frdsel=new Select(frd);
							        frdsel.selectByValue("3");
							        System.out.println("From Date 3 selected");
							        
							        }catch(NoSuchElementException e)
							        
							        {
							        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error18a=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error18a;
							        	MISWriter.write(Error);
							        	MISWriter.close();
							        	e.printStackTrace();
							        	System.out.println("From Date Not selected:::::::::::::::"+e);
							        }
							        
							        Thread.sleep(3000);
							        
							        try {
							        WebElement frm=driver.findElement(By.name("fromm"));
							        Select frdsel2=new Select(frm);
							        frdsel2.selectByValue("2");
							        System.out.println("From month 'FEB' selected");
							        }catch(ElementNotInteractableException e)
							        
							        {
							        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error18b=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error18b;
							        	MISWriter.write(Error);
							        	MISWriter.close();
							        	e.printStackTrace();
							        	System.out.println("From month Not selected:::::::::::::::"+e);
							        }
							        Thread.sleep(1000);
							        try {
							  	        WebElement frm=driver.findElement(By.name("fromy"));
							  	        Select frdsel3=new Select(frm);
							  	        frdsel3.selectByValue("2019");
							  	        System.out.println("From year '2019' selected");
							  	        }catch(ElementNotInteractableException e)
							  	        
							  	        {
							  	        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
								        	String Error18c=e.getMessage();
								        	Error=Error+"\n"+"\n"+Error18c;
								        	MISWriter.write(Error);
								        	MISWriter.close();
							  	        	e.printStackTrace();
							  	        	System.out.println("From year '2019' Not selected:::::::::::::::"+e);
							  	        }
							  	        
							  	          Thread.sleep(2000);
							        
							        try {
							        WebElement frd2=driver.findElement(By.name("tod"));
							        Select frdsel4=new Select(frd2);
							        frdsel4.selectByValue("23"); 
							        System.out.println("From Date 23 selected");
							        }catch(ElementNotInteractableException e)
							        
							        {
							        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error18d=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error18d;
							        	MISWriter.write(Error);
							        	MISWriter.close();
							        	e.printStackTrace();
							        	System.out.println("From Date Not selected:::::::::::::::"+e);
							        }
							          Thread.sleep(2000);
							        
							        try {
							        WebElement frm2=driver.findElement(By.name("tom"));
							        Select frdsel5=new Select(frm2);
							        frdsel5.selectByValue("3");
							        System.out.println("From month 'March' selected");
							        }catch(ElementNotInteractableException e)
							        
							        {
							        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error18e=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error18e;
							        	MISWriter.write(Error);
							        	MISWriter.close();
							        	e.printStackTrace();
							        	System.out.println("From Month Not selected:::::::::::::::"+e);
							        }
							        
							          Thread.sleep(2000);
							         try {
						  	        WebElement frm=driver.findElement(By.name("toy"));
						  	        Select frdsel6=new Select(frm);
						  	        frdsel6.selectByValue("2021");
						  	        System.out.println("From year'2021' selected");
						  	        }catch(ElementNotInteractableException e)
						  	        
						  	        {
						  	        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error18f=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error18f;
							        	MISWriter.write(Error);
							        	MISWriter.close();
						  	        	e.printStackTrace();
						  	        	System.out.println("From year'2021' Not selected:::::::::::::::"+e);
						  	        }
						  	        
						  	         Thread.sleep(2000);
							  	     try {
					    	  	     driver.findElement(By.xpath("//input[@value='21']")).click();
					    	  	     System.out.println("Last 1 Oneday Selected.....impl wait");
					    	  	     }catch(NoSuchElementException e)
					    	  	        
					    	  	     {
					    	  	    	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error18g=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error18g;
							        	MISWriter.write(Error);
							        	MISWriter.close();
					    	  	     e.printStackTrace();
					    	  	     System.out.println("Last 1 Oneday Not Selected:::::::::::::::"+e);
					    	  	     }
					    	  	     //Thread.sleep(3000);	 
					    	  	     Thread.sleep(2000);
						    	     try {
					    	  		  driver.findElement(By.xpath("//input[@value='7']")).click();
					    	  		  System.out.println("Last 1 Week Selected.....impl wait");
					    	  		  }catch(NoSuchElementException e)
					    	  		        
					    	  		  {
					    	  			FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error18h=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error18h;
							        	MISWriter.write(Error);
							        	MISWriter.close();
					    	  		   e.printStackTrace();
					    	  		   System.out.println("Last 1 Week Not Selected:::::::::::::::"+e);
					    	  		  }
					    	  		 //Thread.sleep(3000);	 
					    	          Thread.sleep(2000);
							          try {
							          driver.findElement(By.xpath("//input[@value='1']")).click();
							          System.out.println("Last 1 Month Selected.....impl wait");
							          }catch(NoSuchElementException e)
							        
							          {
							        	  FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
								        	String Error18i=e.getMessage();
								        	Error=Error+"\n"+"\n"+Error18i;
								        	MISWriter.write(Error);
								        	MISWriter.close();
							        	e.printStackTrace();
							        	System.out.println("Last 1  Month Not Selected:::::::::::::::"+e);
							          }
							        //Thread.sleep(3000);
							          try {
							    	  driver.findElement(By.xpath("//input[@value='C']")).click();
							    	  System.out.println("Cumulative....impl wait");
							    	  }catch(NoSuchElementException e)
							    	        
							    	  {
							    		  FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
								        	String Error18j=e.getMessage();
								        	Error=Error+"\n"+"\n"+Error18j;
								        	MISWriter.write(Error);
								        	MISWriter.close();
							    	  e.printStackTrace();
							    	  System.out.println("Cumulative Not Selected:::::::::::::::"+e);
							    	        }
							    	        //Thread.sleep(3000);	 
							    	  Thread.sleep(2000);
							          try {
						    	      driver.findElement(By.xpath("//input[@value='D']")).click();
						    	      System.out.println("DayWise....impl wait");
						    	      }catch(NoSuchElementException e)
						    	      {
						    	    	  FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
								        	String Error18k=e.getMessage();
								        	Error=Error+"\n"+"\n"+Error18k;
								        	MISWriter.write(Error);
								        	MISWriter.close();
				    	        	  e.printStackTrace();
				    	        	  System.out.println("DayWise Not Selected:::::::::::::::"+e);
						    	      }
						    	        //Thread.sleep(3000);	 
						    	      Thread.sleep(2000);
						    	      try {
						    	      driver.findElement(By.xpath("//input[@value='A']")).click();
						    	      System.out.println("Cumulative....impl wait");
						    	      }catch(NoSuchElementException e)
						    	        
						    	      {
						    	    	  FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
								        	String Error18l=e.getMessage();
								        	Error=Error+"\n"+"\n"+Error18l;
								        	MISWriter.write(Error);
								        	MISWriter.close();
						    	      e.printStackTrace();
						    	      System.out.println("Cumulative. Not Selected:::::::::::::::"+e);
						    	      }
						    	        //Thread.sleep(3000);	 
						    	      Thread.sleep(2000);

								  	 try {
					    	         driver.findElement(By.xpath("//input[@value='W']")).click();
					    	         System.out.println("DayOfWeek....impl wait");
					    	         }catch(NoSuchElementException e)
					    	        
					    	         {
					    	        	 FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
					 		        	String Error18n=e.getMessage();
					 		        	Error=Error+"\n"+"\n"+Error18n;
					 		        	MISWriter.write(Error);
					 		        	MISWriter.close();
					    	         e.printStackTrace();
					    	         System.out.println("DayOfWeek Not Selected:::::::::::::::"+e);
					    	         }
					    	        //Thread.sleep(3000);	 
					    	         Thread.sleep(2000);
									 try {	        	        
						  	         WebElement gsname=driver.findElement(By.name("groupsName"));
						  	         Select select3=new Select(gsname);
						  	         select3.selectByVisibleText("Idea");
						  	         System.out.println("Idea Network opened");
						  	         }catch(NoSuchElementException e)
						  	        
						  	          {
						  	        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error18o=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error18o;
							        	MISWriter.write(Error);
							        	MISWriter.close();
					  	        	 e.printStackTrace();
					  	        	 System.out.println("Idea Network Not opened:::::::::::::::"+e);
						  	         }
						  	        
						  	          Thread.sleep(1000);
							        try {	        	        
							        WebElement gname=driver.findElement(By.name("groupName"));
							        Select select3=new Select(gname);
							        select3.selectByVisibleText("WiPayTest");
							        System.out.println("WiPayTest Merchant opened");
							        }catch(NoSuchElementException e)
							        
							        {
							        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error18p=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error18p;
							        	MISWriter.write(Error);
							        	MISWriter.close();
							        	e.printStackTrace();
							        	System.out.println("WiPayTest Merchant Not opened:::::::::::::::"+e);
							        }
							        
							         Thread.sleep(1000);
							       
						            try {	        	        
						 			WebElement bill=driver.findElement(By.name("bill_type"));
						 			Select select3=new Select( bill);
						 			select3.selectByVisibleText("ValuePack");
						 			System.out.println("BillType ValuePack opened");
						 		    }catch(NoSuchElementException e)
						 			{
						 		    	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error18q=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error18q;
							        	MISWriter.write(Error);
							        	MISWriter.close();
						 			e.printStackTrace();
						 			System.out.println("BillType ValuePack Not opened:::::::::::::::"+e);
						 			}
						 
						            Thread.sleep(1000);
						            try { 
					    	        driver.findElement(By.xpath("//input[@name='mid_wise']")).click();
					    	        System.out.println("Mid_Wise CheckBox...Selected wait");
					    	        }catch(NoSuchElementException e)
					    	        
					    	        {
					    	        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error18r=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error18r;
							        	MISWriter.write(Error);
							        	MISWriter.close();
					    	        	e.printStackTrace();
					    	        	System.out.println("Mid_Wise CheckBoxNot Selected:::::::::::::::"+e);
					    	        }
					    	        //Thread.sleep(3000);	 
					    	        Thread.sleep(2000);
						    	   try {
					    		   driver.findElement(By.xpath("//input[@name='op_wise']")).click();
					    		   System.out.println("op_Wise CheckBox...Selected wait");
					    	       }catch(NoSuchElementException e)
					    	        
					    	       {
					    	    	   FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error18s=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error18s;
							        	MISWriter.write(Error);
							        	MISWriter.close();
					    	       e.printStackTrace();
					    	       System.out.println("DayOfWeekAvg Not Selected:::::::::::::::"+e);
					    	       }
					    	        //Thread.sleep(3000);	 
					    	       Thread.sleep(2000);
					
						    	   try {
						    	   driver.findElement(By.xpath("//input[@name='bill_typewise']")).click();
						           System.out.println("bill_typewise CheckBox...Selected wait");
						    	   }catch(NoSuchElementException e)
						    	        
					    	       {
						    		   FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error18t=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error18t;
							        	MISWriter.write(Error);
							        	MISWriter.close();
					    	       e.printStackTrace();
					    	       System.out.println("bill_typewise Not Selected:::::::::::::::"+e);
					    	       }
					    	       //Thread.sleep(3000);	 
					    	       Thread.sleep(2000);
								   try
								    {
								    driver.findElement(By.xpath("//input[@name='ct_type']")).click();
							    	System.out.println("ct_type CheckBox...Selected wait");
							        }catch(NoSuchElementException e)
							        {
							        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error18u=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error18u;
							        	MISWriter.write(Error);
							        	MISWriter.close();
							        e.printStackTrace();
							       	System.out.println("ct_type Not Selected:::::::::::::::"+e);
							        }
					    	        //Thread.sleep(3000);	 
					    	        Thread.sleep(2000);
							        try
										 {
							    	 driver.findElement(By.xpath("//input[@name='billreq']")).click();
						    		 System.out.println("billreq CheckBox...Selected wait");
						    	     }catch(NoSuchElementException e)  
						    	     {
						    	    	 FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
								        	String Error18v=e.getMessage();
								        	Error=Error+"\n"+"\n"+Error18v;
								        	MISWriter.write(Error);
								        	MISWriter.close();
						    	     e.printStackTrace();
						    	   	 System.out.println("billreq Not Selected:::::::::::::::"+e);
						    	     }
						    	       //Thread.sleep(3000);	 
						    	     Thread.sleep(2000);
										    	       
								     try
						    	    {
					    	    	driver.findElement(By.xpath("//input[@name='ubillreq']")).click();
						    		System.out.println("ubillreq CheckBox...Selected wait");
						    	    }catch(NoSuchElementException e)
						    	        
						    	    {
						    	    	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error18w=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error18w;
							        	MISWriter.write(Error);
							        	MISWriter.close();
						    	     e.printStackTrace();
						    	     System.out.println("ubillreq Not Selected:::::::::::::::"+e);
						    	     }
						    	       //Thread.sleep(3000);	 
						    	    Thread.sleep(2000);
									 try
								    {
							     	driver.findElement(By.xpath("//input[@name='billerror']")).click();
						    		System.out.println("billerror CheckBox...Selected wait");
						    	    }catch(NoSuchElementException e)
						    	        
						    	    {
						    	    	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error18x=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error18x;
							        	MISWriter.write(Error);
							        	MISWriter.close();
						    	    e.printStackTrace();
						    	    System.out.println("billerror Not Selected:::::::::::::::"+e);
						    	    }
						    	       //Thread.sleep(3000);	 
						    	    Thread.sleep(2000);
										    	    
								    try
						    	    {

							     	driver.findElement(By.xpath("//input[@name='lowbal']")).click();
						    		System.out.println("lowbal CheckBox...Selected wait");
						    	    }catch(NoSuchElementException e)
						    	        
						    	    {
						    	    	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error18y=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error18y;
							        	MISWriter.write(Error);
							        	MISWriter.close();
						    	     e.printStackTrace();
						    	     System.out.println("lowbal Not Selected:::::::::::::::"+e);
						    	     }
						    	       //Thread.sleep(3000);	 
						    	    Thread.sleep(2000);
								    try
							    	 {
							    	driver.findElement(By.xpath("//input[@name='bills']")).click();
								    System.out.println("bills CheckBox...Selected wait");
								    }catch(NoSuchElementException e)
								    	        
								    {
								    	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error18z=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error18z;
							        	MISWriter.write(Error);
							        	MISWriter.close();
								    e.printStackTrace();
								    System.out.println("bills Not Selected:::::::::::::::"+e);
								    }
								    	       //Thread.sleep(3000);	 
								    Thread.sleep(2000);
						    	   try
						    	   {
						    	   driver.findElement(By.xpath("//input[@name='ubills']")).click();
								   System.out.println("ubills CheckBox...Selected wait");
								   }catch(NoSuchElementException e)
									    	        
								   {
									   FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error19a=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error19a;
							        	MISWriter.write(Error);
							        	MISWriter.close();
								   e.printStackTrace();
								   System.out.println("ubills Not Selected:::::::::::::::"+e);
								   }
								    	       //Thread.sleep(3000);	 
								   Thread.sleep(2000);	
								   try
								   {
								   driver.findElement(By.xpath("//input[@name='rev_dsp']")).click();
								   System.out.println("rev_dsp CheckBox...Selected wait");
								   }catch(NoSuchElementException e)
								    	        
								   {
									   FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error19b=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error19b;
							        	MISWriter.write(Error);
							        	MISWriter.close();
								   e.printStackTrace();
								   System.out.println("rev_dsp Not Selected:::::::::::::::"+e);
								   }
								    	       //Thread.sleep(3000);	 
								   Thread.sleep(2000);	  
													 
						         /* try {
					    	  		  driver.findElement(By.xpath("//input[@name='mid_wise']")).click();
					    	  		  System.out.println("MerchantWise Selected....");
					    	  		  }catch(NoSuchElementException e)
					    	  		        
					    	  		  {
					    	  		   e.printStackTrace();
					    	  		   System.out.println("MerchantWise Not Selected:::::::::::::::"+e);
					    	  		  }
					    	  		 //Thread.sleep(3000);	*/ 
						           try {
							       driver.findElement(By.xpath("//input[@value='Submit']")).click();
							       System.out.println("Form Submitted");
							       }catch(ElementNotInteractableException e)
							       {
							    	   FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error19c=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error19c;
							        	MISWriter.write(Error);
							        	MISWriter.close();
							        e.printStackTrace();
							        	System.out.println("Form Not submited:::::::::::::::"+e);
							        }
						           Thread.sleep(2000);
									}catch(UnhandledAlertException e)
										        
										        {
										      	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
										        	String Error19d=e.getMessage();
										        	Error=Error+"\n"+"\n"+Error19d;
										        	MISWriter.write(Error);
										        	MISWriter.close();
									        	e.printStackTrace();
									        	System.out.println("DAILY AGGREGATION not selected:::::::::::::::"+e);
													        }
										         Thread.sleep(2000);
							        //DAILY AGGREGATION REPORT CLOSED>>>>>>>>>>>>>>>>>>>>>>>
							       
							        try {
							        driver.switchTo().defaultContent();
							        
							        }catch(UnhandledAlertException e)
							        
							        {
							        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error19e=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error19e;
							        	MISWriter.write(Error);
							        	MISWriter.close();
						        	e.printStackTrace();
						        	System.out.println("Default frame not selected:::::::::::::::"+e);
										        }
							         Thread.sleep(2000);
								//SUBSCRIBER HISTORY REPORTS OPENED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
							         try {
						         driver.findElement(By.xpath("//a[@title='Subscribers History Report']")).click();
						         System.out.println("Subscribers History Report Opened...");
				                 Thread.sleep(2000);
					             driver.switchTo().frame(0);
					             driver.findElement(By.name("msisdn_id")).sendKeys("919652319317");
					    	     System.out.println("Subscribers History Report - MSISDN Enetered");
						         try {
						         WebElement frd=driver.findElement(By.name("fromd"));
						         Select frdsel=new Select(frd);
						         frdsel.selectByValue("3");
						         System.out.println("From Date 3 selected");
						        
						         }catch(NoSuchElementException e)
						        
						         {
						        	 FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error19f=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error19f;
							        	MISWriter.write(Error);
							        	MISWriter.close();
						         e.printStackTrace();
						        	System.out.println("From Date Not selected:::::::::::::::"+e);
						        }
						        
						        Thread.sleep(3000);
						        
						        try {
						        WebElement frm=driver.findElement(By.name("fromm"));
						        Select frdsel2=new Select(frm);
						        frdsel2.selectByValue("2");
						        System.out.println("From month 'FEB' selected");
						        }catch(ElementNotInteractableException e)
						        
						        {
						        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
						        	String Error19g=e.getMessage();
						        	Error=Error+"\n"+"\n"+Error19g;
						        	MISWriter.write(Error);
						        	MISWriter.close();
						        	e.printStackTrace();
						        	System.out.println("From month Not selected:::::::::::::::"+e);
						        }
						        Thread.sleep(1000);
						        try {
					  	        WebElement frm=driver.findElement(By.name("fromy"));
					  	        Select frdsel3=new Select(frm);
					  	        frdsel3.selectByValue("2019");
					  	        System.out.println("From year '2019' selected");
					  	        }catch(ElementNotInteractableException e)
					  	        
					  	        {
					  	        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
						        	String Error19h=e.getMessage();
						        	Error=Error+"\n"+"\n"+Error19h;
						        	MISWriter.write(Error);
						        	MISWriter.close();
					  	        	e.printStackTrace();
					  	        	System.out.println("From year '2019' Not selected:::::::::::::::"+e);
					  	        }
					  	        
					  	          Thread.sleep(2000);
						        
						        try {
						        WebElement frd2=driver.findElement(By.name("tod"));
						        Select frdsel4=new Select(frd2);
						        frdsel4.selectByValue("23"); 
						        System.out.println("From Date 23 selected");
						        }catch(ElementNotInteractableException e)
						        
						        {
						        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
						        	String Error19i=e.getMessage();
						        	Error=Error+"\n"+"\n"+Error19i;
						        	MISWriter.write(Error);
						        	MISWriter.close();
						        	e.printStackTrace();
						        	System.out.println("From Date Not selected:::::::::::::::"+e);
						        }
						          Thread.sleep(2000);
						        
						        try {
						        WebElement frm2=driver.findElement(By.name("tom"));
						        Select frdsel5=new Select(frm2);
						        frdsel5.selectByValue("3");
						        System.out.println("From month 'March' selected");
						        }catch(ElementNotInteractableException e)
						        
						        {
						        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
						        	String Error19j=e.getMessage();
						        	Error=Error+"\n"+"\n"+Error19j;
						        	MISWriter.write(Error);
						        	MISWriter.close();
						        	e.printStackTrace();
						        	System.out.println("From Month Not selected:::::::::::::::"+e);
						        }
						        
						          Thread.sleep(2000);
						        try {
					  	        WebElement frm=driver.findElement(By.name("toy"));
					  	        Select frdsel6=new Select(frm);
					  	        frdsel6.selectByValue("2021");
					  	        System.out.println("From year'2021' selected");
					  	        }catch(ElementNotInteractableException e)
					  	        
					  	        {
					  	        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
						        	String Error19k=e.getMessage();
						        	Error=Error+"\n"+"\n"+Error19k;
						        	MISWriter.write(Error);
						        	MISWriter.close();
					  	        	e.printStackTrace();
					  	        	System.out.println("From year'2021' Not selected:::::::::::::::"+e);
					  	        }
					  	        
					  	        Thread.sleep(2000);
					  	    
					  	        try {
						        driver.findElement(By.xpath("//input[@value='Submit']")).click();
						        System.out.println("Form Submitted");
						        
						        }catch(ElementNotInteractableException e)
						        
						        {
						        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
						        	String Error19l=e.getMessage();
						        	Error=Error+"\n"+"\n"+Error19l;
						        	MISWriter.write(Error);
						        	MISWriter.close();
						        	e.printStackTrace();
						        	System.out.println("Form Not submited:::::::::::::::"+e);
						        }
							         }catch(ElementNotInteractableException e)
								        
								        {
								        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
								        	String Error19m=e.getMessage();
								        	Error=Error+"\n"+"\n"+Error19m;
								        	MISWriter.write(Error);
								        	MISWriter.close();
								        	e.printStackTrace();
								        System.out.println("Subscriber history reports not opened:::::::::::::::"+e);
								        }
					  	      
						        //SUBSCRIBER HISTORY REPORTS CLOSED<<<<<<<<<<<<<<<<<<<
						        Thread.sleep(2000);
						        try {
						        driver.switchTo().defaultContent();
						        
						        }catch(UnhandledAlertException e)
						        
						        {
						        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
						        	String Error19o=e.getMessage();
						        	Error=Error+"\n"+"\n"+Error19o;
						        	MISWriter.write(Error);
						        	MISWriter.close();
						        	e.printStackTrace();
						        	System.out.println("Default frame not selected:::::::::::::::"+e);
						        }
						        Thread.sleep(2000);
						       

						        driver.findElement(By.xpath("//*[@id=\"mCSB_1\"]")).sendKeys(Keys.CONTROL, Keys.END);
						        
						    		
						        System.out.println("Page scrolled down");
						        Thread.sleep(2000);
						        //SUBSCRIBER LIFETIME REPORTS<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
						       try {
						        driver.findElement(By.xpath("//a[@title='Subscriber LifeTime Report']")).click();
						        
					            System.out.println("Subscriber LifeTime Report Opened...");
					            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					            Thread.sleep(2000);
					            driver.switchTo().frame(0);
					            driver.findElement(By.name("msisdn_id")).sendKeys("919652319317");
					    	    System.out.println("Subscriber LifeTime Report - MSISDN Entered");
					    	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					    	    
					  	        
					    	    driver.findElement(By.xpath("//input[@value='Submit']")).click();
					    	    System.out.println("Subscriber LifeTime Report - Submit clicked");
					    
					    	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
						       }catch(ElementNotInteractableException e)
						        
						        {
						        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
						        	String Error19p=e.getMessage();
						        	Error=Error+"\n"+"\n"+Error19p;
						        	MISWriter.write(Error);
						        	MISWriter.close();
						        	e.printStackTrace();
						        	System.out.println("Subscriber LifeTime Reports not opened....."+e);
						        }
					    	        
						    //SUBSCRIBER LIFETIME REPORTS CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 
				        }catch(ElementNotInteractableException e)
						        
						        {
						        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
						        	String Error19q=e.getMessage();
						        	Error=Error+"\n"+"\n"+Error19q;
						        	MISWriter.write(Error);
						        	MISWriter.close();
						        	e.printStackTrace();
						        	System.out.println("Revenue Analysis Reports Expanding Failed:::::::::::::::"+e);
						        }
						       //REVENUE ANALYSIS CLOSED >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
						        driver.switchTo().defaultContent();
						        //ACTION REPORTS OPENED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
						 try {
						        driver.findElement(By.xpath("//a[@title='Actions Reports']")).click();
						        System.out.println("Action Reports Expanded");
						        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
						        //MSISDN ACTION OPEN<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
						       try {
						        driver.findElement(By.xpath("//a[@title='MSISDN Actions']")).click();
						        System.out.println("MSISDN Actions Opened");
						        Thread.sleep(2000);
						        driver.switchTo().frame(0);
						        try {
							        driver.findElement(By.name("msisdn_id")).sendKeys("919652319319");
							        System.out.println("MSISDNs entered");
						            }catch(NoSuchElementException e)
							        
							        {
						            	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error19r=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error19r;
							        	MISWriter.write(Error);
							        	MISWriter.close();
							        	e.printStackTrace();
							        	System.out.println("block_msisdn text not avaialble:::::::::::::::"+e);
							        }
							        
							          driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
						        
						        try {
							        WebElement frd=driver.findElement(By.name("fromd"));
							        Select frdsel=new Select(frd);
							        frdsel.selectByValue("3");
							        System.out.println("From Date 3 selected");
							        
							        }catch(NoSuchElementException e)
							        
							        {
							        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error19s=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error19s;
							        	MISWriter.write(Error);
							        	MISWriter.close();
							        	e.printStackTrace();
							        	System.out.println("From Date Not selected:::::::::::::::"+e);
							        }
							        
							        Thread.sleep(3000);
							        
						        try {
							        WebElement frm=driver.findElement(By.name("fromm"));
							        Select frdsel2=new Select(frm);
							        frdsel2.selectByValue("2");
							        System.out.println("From month 'FEB' selected");
							        }catch(ElementNotInteractableException e)
							        
							        {
							        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error19t=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error19t;
							        	MISWriter.write(Error);
							        	MISWriter.close();
							        	e.printStackTrace();
							        	System.out.println("From month Not selected:::::::::::::::"+e);
							        }
							        Thread.sleep(1000);
						        try {
						  	        WebElement frm=driver.findElement(By.name("fromy"));
						  	        Select frdsel3=new Select(frm);
						  	        frdsel3.selectByValue("2019");
						  	        System.out.println("From year '2019' selected");
						  	        }catch(ElementNotInteractableException e)
						  	        
						  	        {
						  	        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error19u=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error19u;
							        	MISWriter.write(Error);
							        	MISWriter.close();
						  	        	e.printStackTrace();
						  	        	System.out.println("From year '2019' Not selected:::::::::::::::"+e);
						  	        }
						  	        
						  	          Thread.sleep(2000);
						        
							     try {
							        WebElement frd2=driver.findElement(By.name("tod"));
							        Select frdsel4=new Select(frd2);
							        frdsel4.selectByValue("23"); 
							        System.out.println("From Date 23 selected");
							        }catch(ElementNotInteractableException e)
							        
							        {
							        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error19v=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error19v;
							        	MISWriter.write(Error);
							        	MISWriter.close();
							        	e.printStackTrace();
							        	System.out.println("From Date Not selected:::::::::::::::"+e);
							        }
							          Thread.sleep(2000);
							        
							      try {
							        WebElement frm2=driver.findElement(By.name("tom"));
							        Select frdsel5=new Select(frm2);
							        frdsel5.selectByValue("3");
							        System.out.println("From month 'March' selected");
							        }catch(ElementNotInteractableException e)
							        
							        {
							        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error19w=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error19w;
							        	MISWriter.write(Error);
							        	MISWriter.close();
							        	e.printStackTrace();
							        	System.out.println("From Month Not selected:::::::::::::::"+e);
							        }
							        
							          Thread.sleep(2000);
							       try {
							  	        WebElement frm=driver.findElement(By.name("toy"));
							  	        Select frdsel6=new Select(frm);
							  	        frdsel6.selectByValue("2021");
							  	        System.out.println("From year'2021' selected");
							  	        }catch(ElementNotInteractableException e)
							  	        
							  	        {
							  	        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
								        	String Error19x=e.getMessage();
								        	Error=Error+"\n"+"\n"+Error19x;
								        	MISWriter.write(Error);
								        	MISWriter.close();
							  	        	e.printStackTrace();
							  	        	System.out.println("From year'2021' Not selected:::::::::::::::"+e);
							  	        }
							 
						          driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
						          
						          try {
								        driver.findElement(By.xpath("//input[@value='Submit']")).click();
								        System.out.println("Form Submitted");
								        
								        }catch(ElementNotInteractableException e)
								        
								        {
								        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
								        	String Error19y=e.getMessage();
								        	Error=Error+"\n"+"\n"+Error19y;
								        	MISWriter.write(Error);
								        	MISWriter.close();
								        	e.printStackTrace();
								        	System.out.println("Form Not submited:::::::::::::::"+e);
								        }
								        
								        Thread.sleep(2000);
						       }catch(ElementNotInteractableException e)
						        
						        {
						        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
						        	String Error19z=e.getMessage();
						        	Error=Error+"\n"+"\n"+Error19z;
						        	MISWriter.write(Error);
						        	MISWriter.close();
						        	e.printStackTrace();
						        	System.out.println("Action MISdn Reports not opened:::::::::::::::"+e);
						        }
						       //MSISDN ACTION CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
						        Thread.sleep(2000);
								    try {
								        driver.switchTo().defaultContent();
								        }catch(UnhandledAlertException e)
								        
								        {
								        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
								        	String Error20a=e.getMessage();
								        	Error=Error+"\n"+"\n"+Error20a;
								        	MISWriter.write(Error);
								        	MISWriter.close();
								        	e.printStackTrace();
								        	System.out.println("Default frame not selected:::::::::::::::"+e);
								        }
								          Thread.sleep(2000);
					    	   //WIPAY ACTION SUMMARY REPORTS OPENED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
					       	 	       try { 
							        driver.findElement(By.xpath("//a[@title='Wipay Action Summary Report']")).click();
							        System.out.println("Wipay Action Summary Report Opened");
							        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
							        Thread.sleep(2000);  
						            driver.switchTo().frame(0);
						                   
							        try {
							        WebElement frd=driver.findElement(By.name("fromd"));
							        Select frdsel=new Select(frd);
							        frdsel.selectByValue("3");
							        System.out.println("From Date 3 selected");
							        
							        }catch(NoSuchElementException e)
							        
							        {
							        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error20b=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error20b;
							        	MISWriter.write(Error);
							        	MISWriter.close();
							        	e.printStackTrace();
							        	System.out.println("From Date Not selected:::::::::::::::"+e);
							        }
							        
							        Thread.sleep(3000);
							        
							        try {
							        WebElement frm=driver.findElement(By.name("fromm"));
							        Select frdsel2=new Select(frm);
							        frdsel2.selectByValue("2");
							        System.out.println("From month 'FEB' selected");
							        }catch(ElementNotInteractableException e)
							        
							        {
							        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error20c=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error20c;
							        	MISWriter.write(Error);
							        	MISWriter.close();
							        	e.printStackTrace();
							        	System.out.println("From month Not selected:::::::::::::::"+e);
							        }
							        Thread.sleep(1000);
							        try {
							  	        WebElement frm=driver.findElement(By.name("fromy"));
							  	        Select frdsel3=new Select(frm);
							  	        frdsel3.selectByValue("2019");
							  	        System.out.println("From year '2019' selected");
							  	        }catch(ElementNotInteractableException e)
							  	        
							  	        {
							  	        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
								        	String Error20d=e.getMessage();
								        	Error=Error+"\n"+"\n"+Error20d;
								        	MISWriter.write(Error);
								        	MISWriter.close();
							  	        	e.printStackTrace();
							  	        	System.out.println("From year '2019' Not selected:::::::::::::::"+e);
							  	        }
							  	        
							  	          Thread.sleep(2000);
							        
							        try {
							        WebElement frd2=driver.findElement(By.name("tod"));
							        Select frdsel4=new Select(frd2);
							        frdsel4.selectByValue("23"); 
							        System.out.println("From Date 23 selected");
							        }catch(ElementNotInteractableException e)
							        
							        {
							        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error20e=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error20e;
							        	MISWriter.write(Error);
							        	MISWriter.close();
							        	e.printStackTrace();
							        	System.out.println("From Date Not selected:::::::::::::::"+e);
							        }
							          Thread.sleep(2000);
							        
							        try {
							        WebElement frm2=driver.findElement(By.name("tom"));
							        Select frdsel5=new Select(frm2);
							        frdsel5.selectByValue("3");
							        System.out.println("From month 'March' selected");
							        }catch(ElementNotInteractableException e)
							        
							        {
							        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error20ff=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error20ff;
							        	MISWriter.write(Error);
							        	MISWriter.close();
							        	e.printStackTrace();
							        	System.out.println("From Month Not selected:::::::::::::::"+e);
							        }
							        
							          Thread.sleep(2000);
							        try {
						  	        WebElement frm=driver.findElement(By.name("toy"));
						  	        Select frdsel6=new Select(frm);
						  	        frdsel6.selectByValue("2021");
						  	        System.out.println("From year'2021' selected");
						  	        }catch(ElementNotInteractableException e)
						  	        
						  	        {
						  	        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error20f=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error20f;
							        	MISWriter.write(Error);
							        	MISWriter.close();
						  	        	e.printStackTrace();
						  	        	System.out.println("From year'2021' Not selected:::::::::::::::"+e);
						  	        }
						  	        
						  	          Thread.sleep(2000);
							  	    try {	        	        
						  	        WebElement gsname=driver.findElement(By.name("groupsName"));
						  	        Select select3=new Select(gsname);
						  	        select3.selectByVisibleText("Ida");
						  	        System.out.println("Idea Network opened");
						  	        }catch(NoSuchElementException e)
						  	        
						  	        {
						  	        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error20g=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error20g;
							        	MISWriter.write(Error);
							        	MISWriter.close();
						  	        	e.printStackTrace();
						  	        	System.out.println("Idea Network Not opened:::::::::::::::"+e);
						  	        }
						  	        
						  	          Thread.sleep(1000);
								    try {	        	        
							        WebElement gname=driver.findElement(By.name("groupName"));
							        Select select3=new Select(gname);
							        select3.selectByVisibleText("WiPayTest");
							        System.out.println("WiPayTest Merchant opened");
							        }catch(NoSuchElementException e)
							        
							        {
							        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error20h=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error20h;
							        	MISWriter.write(Error);
							        	MISWriter.close();
							        	e.printStackTrace();
							        	System.out.println("WiPayTest Merchant Not opened:::::::::::::::"+e);
							        }
							        
							          Thread.sleep(1000);
								       
								     try {	        	        
						 			 WebElement billtype=driver.findElement(By.name("billtype"));
						 			 Select select3=new Select(billtype);
						 			 select3.selectByVisibleText("ValuePack");
						 			 System.out.println("BillType ValuePack opened");
						 			 }catch(NoSuchElementException e)
						 			 {
						 				FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error20i=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error20i;
							        	MISWriter.write(Error);
							        	MISWriter.close();
						 			 e.printStackTrace();
						 			 System.out.println("BillType ValuePack Not opened:::::::::::::::"+e);
						 			 }
						 							  	        

						            Thread.sleep(100);
								     try
								      {
					    	    	 driver.findElement(By.xpath("//input[@name='day_wise']")).click();
						    		 System.out.println("DayWise CheckBox...Selected wait");
						    	     }catch(NoSuchElementException e)
						    	        
						    	     {
						    	    	 FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
								        	String Error20j=e.getMessage();
								        	Error=Error+"\n"+"\n"+Error20j;
								        	MISWriter.write(Error);
								        	MISWriter.close();
						    	     e.printStackTrace();
						    	     System.out.println("DayWise  Not Selected:::::::::::::::"+e);
						    	       }
						    	       //Thread.sleep(3000);	 
						    	     Thread.sleep(2000);
									 try
									    {
					    	    	 driver.findElement(By.xpath("//input[@name='op_wise']")).click();
						    		 System.out.println("OperatorWise CheckBox...Selected wait");
						    	     }catch(NoSuchElementException e)
						    	        
						    	     {
						    	    	 FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
								        	String Error20k=e.getMessage();
								        	Error=Error+"\n"+"\n"+Error20k;
								        	MISWriter.write(Error);
								        	MISWriter.close();
						    	     e.printStackTrace();
						    	     System.out.println("OperatorWise  Not Selected:::::::::::::::"+e);
						    	     }
						    	       //Thread.sleep(3000);	 
						    	     Thread.sleep(2000);
								     try
								    	 {
					    		     driver.findElement(By.xpath("//input[@name='bill_type']")).click();
						    		 System.out.println("BillType CheckBox...Selected wait");
						    	     }catch(NoSuchElementException e)
						    	        
						    	     {
						    	    	 FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
								        	String Error20l=e.getMessage();
								        	Error=Error+"\n"+"\n"+Error20l;
								        	MISWriter.write(Error);
								        	MISWriter.close();
						    	     e.printStackTrace();
						    	     System.out.println("BillType   Not Selected:::::::::::::::"+e);
						    	     }
						    	       //Thread.sleep(3000);	 
						    	     Thread.sleep(2000);
									 try
									    {
									    		
						    		 driver.findElement(By.xpath("//input[@name='ct_type']")).click();
						    		 System.out.println("ContentType CheckBox...Selected wait");
						    	     }catch(NoSuchElementException e)
						    	        
						    	    {
						    	    	 FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
								        	String Error20m=e.getMessage();
								        	Error=Error+"\n"+"\n"+Error20m;
								        	MISWriter.write(Error);
								        	MISWriter.close();
						    	    e.printStackTrace();
						    	  	System.out.println("ContentType   Not Selected:::::::::::::::"+e);
						    	    }
						    	       //Thread.sleep(3000);	 
						    	    Thread.sleep(2000);
							  	    
							  	    try {
							        driver.findElement(By.xpath("//input[@value='Submit']")).click();
							        System.out.println("Form Submitted");
							        
							        }catch(ElementNotInteractableException e)
							        
							        {
							        	e.printStackTrace();
							        	System.out.println("Form Not submited:::::::::::::::"+e);
							        }
					       	 	   }catch(ElementNotInteractableException e)
					   		        
					   		        {
					   		        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
					   		        	String Error20n=e.getMessage();
					   		        	Error=Error+"\n"+"\n"+Error20n;
					   		        	MISWriter.write(Error);
					   		        	MISWriter.close();
					   		        	e.printStackTrace();
					   		        	System.out.println("WIPAY ACTION SUMMARY REPORTS Not opened:::::::::::::::"+e);
					   		        }
					       	 	       //WIPAY ACTION SUMMARY REPORTS CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
					   		        Thread.sleep(2000);
					   		       
				         }catch(ElementNotInteractableException e)
						        
						        {
						        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
						        	String Error20m=e.getMessage();
						        	Error=Error+"\n"+"\n"+Error20m;
						        	MISWriter.write(Error);
						        	MISWriter.close();
						        	e.printStackTrace();
						        	System.out.println("ACTION Reports Menu Not opened:::::::::::::::"+e);
						        }
						 //ACTION REPORTS CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
						 Thread.sleep(2000);    
				            }catch(ElementNotInteractableException e)
						        
						        {
						        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
						        	String Error20n=e.getMessage();
						        	Error=Error+"\n"+"\n"+Error20n;
						        	MISWriter.write(Error);
						        	MISWriter.close();
						        	e.printStackTrace();
						        	System.out.println("MIS Reports Menu Not opened:::::::::::::::"+e);
						        }
						 //MIS REPORTS CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
						        Thread.sleep(2000);
								    try {
							        driver.switchTo().defaultContent();
							        
							        }catch(UnhandledAlertException e)
							        
							        {
							        	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
							        	String Error20o=e.getMessage();
							        	Error=Error+"\n"+"\n"+Error20o;
							        	MISWriter.write(Error);
							        	MISWriter.close();
							        	e.printStackTrace();
							        	System.out.println("Default frame not selected:::::::::::::::"+e);
							        }
							          Thread.sleep(2000);
				        
							          /* ############Administration Module############### */
				                      try
				                      {
				                   driver.findElement(By.xpath("//a[@title='Administration']")).click();
				                    System.out.println("Administration Expanded");
				                    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				                   
				                    try {
				                         driver.findElement(By.xpath("//a[@title='Users']")).click();
				                          System.out.println("Users Expanded");
				             
				                   //Thread.sleep(3000);    
				                    
				                          
				                                    
				                   try
				                   {
				                    
				                    driver.findElement(By.xpath("//a[@title='Add User']")).click();
				                    System.out.println("Add User opened");
				                   }
				                   catch(NoSuchElementException e)
				                    
				                    {
				                	   FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                       String Error22a=e.getMessage();
				                       Error=Error+"\n"+"\n"+Error22a;
				                       MISWriter.write(Error);
				                       MISWriter.close();
				                       e.printStackTrace();
				                       System.out.println("Add User Not Clicked:::::::::::::::"+e);
				                    }
				                    
				                   
				                    Thread.sleep(2000);
				                    
				                    driver.switchTo().frame(0);
				                    try {
				                    driver.findElement(By.name("username")).sendKeys("vickyy"+i);
				                    System.out.println("User name text entered");}
				                catch(NoSuchElementException e)
				                    
				                    {
				                	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                    String Error22b=e.getMessage();
				                    Error=Error+"\n"+"\n"+Error22b;
				                    MISWriter.write(Error);
				                    MISWriter.close();
				                       e.printStackTrace();
				                       System.out.println("username not entered:::::::::::::::"+e);
				                    }
				                    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				                    try {
				                    driver.findElement(By.name("password1")).sendKeys("vicky123");
				                    System.out.println("password text entered");}
				                   catch(NoSuchElementException e)
				                    
				                    {
				                	   FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                       String Error22c=e.getMessage();
				                       Error=Error+"\n"+"\n"+Error22c;
				                       MISWriter.write(Error);
				                       MISWriter.close();
				                       e.printStackTrace();
				                       System.out.println("Add User Not Clicked:::::::::::::::"+e);
				                    }
				                    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				                    try {
				                    driver.findElement(By.name("password2")).sendKeys("vicky123");
				                    System.out.println("confirm password text entered");}
				                catch(NoSuchElementException e)
				                    
				                    {
				                	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                    String Error22d=e.getMessage();
				                    Error=Error+"\n"+"\n"+Error22d;
				                    MISWriter.write(Error);
				                    MISWriter.close();
				                       e.printStackTrace();
				                       System.out.println("password not Entered:::::::::::::::"+e);
				                    }
				                    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				                    try {
				                    WebElement roletypes=driver.findElement(By.name("roletypes"));
				                    Select rname=new Select(roletypes);
				                    rname.selectByVisibleText("Support");
				                    System.out.println("Role selected support");}
				                 catch(NoSuchElementException e)
				                    
				                    {
				                	 FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                     String Error22e=e.getMessage();
				                     Error=Error+"\n"+"\n"+Error22e;
				                     MISWriter.write(Error);
				                     MISWriter.close();
				                       e.printStackTrace();
				                       System.out.println("RoleType Not Selected:::::::::::::::"+e);
				                    }
				                    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				                    Thread.sleep(2000);
				                    try {
				                    driver.findElement(By.xpath("//input[@value='I']")).click();
				                    System.out.println("Internal Radio button selected");
				                    Thread.sleep(2000);}
				                catch(NoSuchElementException e)
				                    
				                    {
				                	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                    String Error22f=e.getMessage();
				                    Error=Error+"\n"+"\n"+Error22f;
				                    MISWriter.write(Error);
				                    MISWriter.close();
				                       e.printStackTrace();
				                       System.out.println("Internal Radio Button Not Selected:::::::::::::::"+e);
				                    }
				                    try {
				                    driver.findElement(By.xpath("//input[@value='N']")).click();
				                    System.out.println("Telco Radio button selected");}
				                catch(NoSuchElementException e)
				                    
				                    {
				                	FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                    String Error22g=e.getMessage();
				                    Error=Error+"\n"+"\n"+Error22g;
				                    MISWriter.write(Error);
				                    MISWriter.close();
				                       e.printStackTrace();
				                       System.out.println("Telco Radio button not selected:::::::::::::::"+e);
				                    }
				                    Thread.sleep(2000);
				                     try {                     
				                    WebElement gname=driver.findElement(By.name("gid_teleco"));
				                    Select select3=new Select(gname);
				                    select3.selectByValue("1");
				                    System.out.println("Airtel(Operator) Operator selected");
				                    }catch(NoSuchElementException e)
				                    
				                    {FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                  String Error22h=e.getMessage();
				                  Error=Error+"\n"+"\n"+Error22h;
				                  MISWriter.write(Error);
				                  MISWriter.close();
				                       e.printStackTrace();
				                       System.out.println("Airtel(Operator) Operator Not selected::::::::::::::"+e);
				                    }
				                   //  driver.switchTo().defaultContent();
				                    /*driver.findElement(By.name("mobile_phone_number")).sendKeys("919652319318");
				                     System.out.println("phone number text entered ");
				                     Thread.sleep(2000);*/
				               
				                    /*driver.findElement(By.xpath("//input[@value='A']")).click();
				                    System.out.println("Merchant Radio button selected");
				                    
				                    Thread.sleep(2000);
				                    driver.findElement(By.xpath("//input[@value='C']")).click();
				                    System.out.println("ContentProvider Radio button selected");
				                    Thread.sleep(2000);*/
				                  try {
				                    driver.findElement(By.xpath("//input[@value='Save']"));
				                    System.out.println("SAVE button Clicked ");}
				                  catch(NoSuchElementException e)
				                    
				                    {FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                  String Error22i=e.getMessage();
				                  Error=Error+"\n"+"\n"+Error22i;
				                  MISWriter.write(Error);
				                  MISWriter.close();
				                       e.printStackTrace();
				                       System.out.println("Save Button Not Selected::::::::::::::"+e);
				                    }
				                  
				                    
				                    driver.switchTo().defaultContent();
				                    
				                    Thread.sleep(2000);
				                    try {
				                    driver.findElement(By.xpath("//a[@title='View User']")).click();
				                    System.out.println("View User opened");}
				                 catch(NoSuchElementException e)
				                    {FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                  String Error22j=e.getMessage();
				                  Error=Error+"\n"+"\n"+Error22j;
				                  MISWriter.write(Error);
				                  MISWriter.close();
				                       e.printStackTrace();
				                       System.out.println("Airtel(Operator) Operator Not selected::::::::::::::"+e);
				                    }
				                    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				                    try {
				                    driver.findElement(By.xpath("//a[@title='Edit/Delete User']")).click();
				                    System.out.println("Edit/Delete User opened");}
				                catch(NoSuchElementException e)
				                    
				                    {FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                  String Error22k=e.getMessage();
				                  Error=Error+"\n"+"\n"+Error22k;
				                  MISWriter.write(Error);
				                  MISWriter.close();
				                       e.printStackTrace();
				                       System.out.println("Edit/Delete User Not Opened::::::::::::::"+e);
				                    }
				                      driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				                    }catch(NoSuchElementException e)
				             
				                {
				                        FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                       String Error22l=e.getMessage();
				                       Error=Error+"\n"+"\n"+Error22l;
				                       MISWriter.write(Error);
				                       MISWriter.close();
				               e.printStackTrace();
				                System.out.println("Users Not Expanded:::::::::::::::"+e);
				               }
				                    
				                  try {
				                    driver.findElement(By.xpath("//a[@title='Roles']")).click();
				                    System.out.println("Roles clicked");
				                 
				                      driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				                    try {
				                    driver.findElement(By.xpath("//a[@title='Add Role']")).click();
				                    System.out.println("Add Role opened");}
				               catch(NoSuchElementException e)
				                    
				                    {FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                  String Error22m=e.getMessage();
				                  Error=Error+"\n"+"\n"+Error22m;
				                  MISWriter.write(Error);
				                  MISWriter.close();
				                       e.printStackTrace();
				                       System.out.println("Add Role Not Opened::::::::::::::"+e);
				                    }
				                   
				                    Thread.sleep(2000);
				                              
				                    driver.switchTo().frame(0);
				                    //driver.findElement(By.xpath("//input[@id='role']")).click();
				                       
				                        
				                  try {
				                    driver.findElement(By.xpath("//input[@id='role']")).sendKeys("WICORE3"+i);
				                    System.out.println("Role text entered");
				                    System.out.println("KKKKKKKKKKK"+i);
				                  }
				                catch(NoSuchElementException e)
				                    
				                    {FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                  String Error22n=e.getMessage();
				                  Error=Error+"\n"+"\n"+Error22n;
				                  MISWriter.write(Error);
				                  MISWriter.close();
				                       e.printStackTrace();
				                       System.out.println("Roel Text Not Entered::::::::::::::"+e);
				                    }
				                   
				                               
				                    Thread.sleep(2000);
				                    try {
				                    driver.findElement(By.xpath("//input[@value='Permissions']")).click();
				                    System.out.println("Add Role Submited");}
				              catch(NoSuchElementException e)
				                    
				                    {FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                  String Error22o=e.getMessage();
				                  Error=Error+"\n"+"\n"+Error22o;
				                  MISWriter.write(Error);
				                  MISWriter.close();
				                       e.printStackTrace();
				                       System.out.println("Add Role Not Submitted::::::::::::::"+e);
				                    }
				                   
				                    
				                    
				                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				                    
				                    try {
				                    WebElement option1 = driver.findElement(By.name("04"));                                     
				                   option1.click();
				                   System.out.println("Manage");
				                   WebElement option11 = driver.findElement(By.name("0401"));
				                   
				                   option1.click();
				                   System.out.println("Send Sms Clicked");
				                   
				                   Thread.sleep(2000);
				                 WebElement option12 = driver.findElement(By.name("0402"));
				                   
				                   option1.click();
				                   System.out.println("Send BulkSms Clicked");
				               WebElement option13 = driver.findElement(By.name("0409"));
				              option1.click();
				                   System.out.println("Unsubscription Clicked");
				               WebElement option14 = driver.findElement(By.name("0411"));
				               option1.click();
				                   System.out.println("BlackListNumber Clicked");
				              
				                   WebElement option2 = driver.findElement(By.name("08"));                                     
				                   option2.click();                
				                   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				                   try {
				                   driver.findElement(By.xpath("//input[@value='Save Permissions']")).click();}
				                 catch(NoSuchElementException e)
				                    
				                    {FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                  String Error22p=e.getMessage();
				                  Error=Error+"\n"+"\n"+Error22p;
				                  MISWriter.write(Error);
				                  MISWriter.close();
				                       e.printStackTrace();
				                       System.out.println("Save Permissions Not Opened::::::::::::::"+e);
				                    }
				                   
				                   
				                    }catch(NoSuchElementException e)
				                    
				                    {
				                       FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                       String Error22q=e.getMessage();
				                       Error=Error+"\n"+"\n"+Error22q;
				                       MISWriter.write(Error);
				                       MISWriter.close();
				                       e.printStackTrace();
				                       System.out.println(":::::::::::Add Role name already exist...:::::::::::::::"+  e);
				                    }
				                    
				                    
				                    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				                    
				                    driver.switchTo().defaultContent();
				                    
				                    driver.findElement(By.xpath("//a[@title='View Role']")).click();
				                    System.out.println("View Role clicked");
				                    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				                    Thread.sleep(2000);
				                    driver.switchTo().frame(0);
				                    try
				                    {
				                    driver.findElement(By.xpath("/html/body/div/table[1]/tbody/tr[2]/td[3]/a/img")).click();
				                    System.out.println("View Role - VIEW button clicked");}
				               catch(NoSuchElementException e)
				                    
				                    {FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                  String Error22r=e.getMessage();
				                  Error=Error+"\n"+"\n"+Error22r;
				                  MISWriter.write(Error);
				                  MISWriter.close();
				                       e.printStackTrace();
				                       System.out.println("View Role -VIEW button Not Clicked::::::::::::::"+e);
				                    }
				                   
				                    
				                    Thread.sleep(3000);
				                    try {
				                    driver.findElement(By.xpath("//input[@value='Back']")).click();
				                    System.out.println("View Role - VIEW BACK clicked");}
				              catch(NoSuchElementException e)
				                    
				                    {FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                  String Error22s=e.getMessage();
				                  Error=Error+"\n"+"\n"+Error22s;
				                  MISWriter.write(Error);
				                  MISWriter.close();
				                       e.printStackTrace();
				                       System.out.println("View Role-VIEW BACK not Clicked::::::::::::::"+e);
				                    }
				                   
				                    
				                    
				                    driver.switchTo().defaultContent();
				                    try {
				                    driver.findElement(By.xpath("//a[@title='Edit/Delete Role']")).click();
				                    System.out.println("Edit/Delete Role clicked");}
				                catch(NoSuchElementException e)
				                    
				                    {FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                  String Error22t=e.getMessage();
				                  Error=Error+"\n"+"\n"+Error22t;
				                  MISWriter.write(Error);
				                  MISWriter.close();
				                       e.printStackTrace();
				                       System.out.println("Edit/Delete User Not Opened::::::::::::::"+e);
				                    }
				                   
				                    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				                    Thread.sleep(2000);
				                    driver.switchTo().frame(0);
				                    try {
				                    driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[3]/a[1]/img")).click();
				                    System.out.println("Edit/Delete Role - Edit button clicked");
				                    }
				                catch(NoSuchElementException e)
				                    
				                    {FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                  String Error22u=e.getMessage();
				                  Error=Error+"\n"+"\n"+Error22u;
				                  MISWriter.write(Error);
				                  MISWriter.close();
				                       e.printStackTrace();
				                       System.out.println("Edit/Delete Role-Edit Button Not Clicked::::::::::::::"+e);
				                    }
				                   
				                    Thread.sleep(3000);
				                    try {
				                    driver.findElement(By.xpath("//input[@value='Save Permissions']")).click();
				                    System.out.println("Edit/Delete Role - Save Permissions clicked");}
				             catch(NoSuchElementException e)
				                    
				                    {FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                  String Error22v=e.getMessage();
				                  Error=Error+"\n"+"\n"+Error22v;
				                  MISWriter.write(Error);
				                  MISWriter.close();
				                       e.printStackTrace();
				                       System.out.println("Edit/Delete Save Permissions Not Clicked::::::::::::::"+e);
				                    }
				                   

				                    Thread.sleep(3000);
				                    
				                    driver.switchTo().alert().accept();
				                    System.out.println("Alert clicked OK");
				                    
				                    driver.switchTo().defaultContent();
				                               
				                           
				                    driver.findElement(By.xpath("//a[@title='Menu Order']")).click();
				                    System.out.println(" ROLE Menu Order clicked");
				                   
				                    Thread.sleep(2000);
				                    driver.switchTo().frame(0);
				                    try {
				                    driver.findElement(By.xpath("/html/body/div[2]/form/table/tbody/tr[1]/td[1]/select/option[8]")).click();
				                    System.out.println(" Role Menu Selected");}
				                catch(NoSuchElementException e)
				                    
				                    {FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                  String Error22w=e.getMessage();
				                  Error=Error+"\n"+"\n"+Error22w;
				                  MISWriter.write(Error);
				                  MISWriter.close();
				                       e.printStackTrace();
				                       System.out.println("Role MEnu Not Seledted::::::::::::::"+e);
				                    }
				                   
				                    
				                    Thread.sleep(3000);
				                    try {
				                    driver.findElement(By.xpath("//input[@value='Move Down']")).click();
				                    System.out.println("Menu Move Down clicked");}
				                catch(NoSuchElementException e)
				                    
				                    {FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                  String Error22x=e.getMessage();
				                  Error=Error+"\n"+"\n"+Error22x;
				                  MISWriter.write(Error);
				                  MISWriter.close();
				                       e.printStackTrace();
				                       System.out.println("Move Down Not Clicked::::::::::::::"+e);
				                    }
				                   
				                    
				                    Thread.sleep(3000);
				                    try {
				                    driver.findElement(By.xpath("/html/body/div[2]/form/table/tbody/tr[1]/td[2]/table/tbody/tr[1]/td/input")).click();
				                    System.out.println("Menu Move UP clicked");
				                    }
				               catch(NoSuchElementException e)
				                    
				                    {FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                  String Error22x=e.getMessage();
				                  Error=Error+"\n"+"\n"+Error22x;
				                  MISWriter.write(Error);
				                  MISWriter.close();
				                       e.printStackTrace();
				                       System.out.println("Menu Move Up Not Clicked::::::::::::::"+e);
				                    }
				                   
				                    Thread.sleep(3000);
				                    
				                    try {
				                    driver.findElement(By.xpath("//input[@value='Save']")).click();
				                    System.out.println("Role - MENU ORDER Save clicked");}
				                 catch(NoSuchElementException e)
				                    
				                    {FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                  String Error22y=e.getMessage();
				                  Error=Error+"\n"+"\n"+Error22y;
				                  MISWriter.write(Error);
				                  MISWriter.close();
				                       e.printStackTrace();
				                       System.out.println("Role-MENU ORDER Save Not Clicked::::::::::::::"+e);
				                    }
				                   

				                    //Thread.sleep(3000);
				                    //String ss1=driver.findElement(By.xpath("/html/body/div[1]")).getText();
				                    
				                    //System.out.println("@@@<<<<<<<<<"+ss1+">>>>>>>>>@@@");
				                    
				                    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				                    driver.switchTo().defaultContent();
				                }catch(NoSuchElementException e)
				             
				                {
				                  FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                  String Error22z=e.getMessage();
				                  Error=Error+"\n"+"\n"+Error22z;
				                  MISWriter.write(Error);
				                  MISWriter.close();
				               e.printStackTrace();
				                System.out.println("Roles Not Expanded:::::::::::::::"+e);
				               }
				                      }
				                  catch(NoSuchElementException e)
				                    
				                    {FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                  String Error23a=e.getMessage();
				                  Error=Error+"\n"+"\n"+Error23a;
				                  MISWriter.write(Error);
				                  MISWriter.close();
				                       e.printStackTrace();
				                       System.out.println("Roles Not Expanded::::::::::::::"+e);
				                    }
				                   
				                      try {
				                    driver.findElement(By.xpath("//a[@title='Manual Settings']")).click();
				                    System.out.println(" Manual Settings Expanded");
				                    try {
				                         driver.findElement(By.xpath("//a[@title='View Settings']")).click();
				                         System.out.println("View Settings Clicked............");
				                         }catch(ElementNotInteractableException e)
				                         
				                         {
				                            FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                            String Error23b=e.getMessage();
				                            Error=Error+"\n"+"\n"+Error23b;
				                            MISWriter.write(Error);
				                            MISWriter.close();
				                            e.printStackTrace();
				                            System.out.println("View Settings Not Clicked:::::::::::::::"+e);
				                         }
				                   
				                         Thread.sleep(2000);
				                         driver.switchTo().frame(0) ;
				                        System.out.println("FramView opened");
				                        driver.switchTo().defaultContent();
				                   
				                           
				                         driver.findElement(By.xpath("//a[@title='Edit Settings']")).click();
				                         System.out.println(" Edit Settings Settings clicked");
				                        driver.switchTo().frame(0) ;
				                         System.out.println("FramEdit opened");
				                      }catch(ElementNotInteractableException e)
				                         
				                         {
				                            FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                      String Error23c=e.getMessage();
				                      Error=Error+"\n"+"\n"+Error23c;
				                      MISWriter.write(Error);
				                      MISWriter.close();
				                            e.printStackTrace();
				                            System.out.println("Manual  Settings Not Expanded:::::::::::::::"+e);
				                         }
				                   
				                        driver.switchTo().defaultContent();
				                        try
				                        {
				                        driver.findElement(By.xpath("//a[@title='Country']")).click();
				                         System.out.println(" Country Expanded");
				                         try {
				                               driver.findElement(By.xpath("//a[@title='Add/Edit/View/Delete']")).click();
				                               System.out.println("Add/Edit/View/DeleteClicked............");
				                               }catch(ElementNotInteractableException e)
				                               
				                               {
				                                       FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                                  String Error23d=e.getMessage();
				                                  Error=Error+"\n"+"\n"+Error23d;
				                                  MISWriter.write(Error);
				                                  MISWriter.close();
				                                  e.printStackTrace();
				                                  System.out.println("Add/Edit/View/Delete Not Clicked:::::::::::::::"+e);
				                               }
				                        }catch(ElementNotInteractableException e)
				                         
				                         {
				                                  FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                            String Error23e=e.getMessage();
				                            Error=Error+"\n"+"\n"+Error23e;
				                            MISWriter.write(Error);
				                            MISWriter.close();
				                            e.printStackTrace();
				                            System.out.println("Country Not Expanded:::::::::::::::"+e);
				                         }
				                 driver.switchTo().defaultContent();
				                 try
				                 {
				                         driver.findElement(By.xpath("//a[@title='Groups']")).click();
				                         System.out.println(" Groups Expanded");
				                         try {
				                               driver.findElement(By.xpath("//a[@title='Manage Operator']")).click();
				                               System.out.println("Manage Operator Clicked............");
				                               }catch(ElementNotInteractableException e)
				                               
				                               {
				                                       FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                                  String Error23f=e.getMessage();
				                                 Error=Error+"\n"+"\n"+Error23f;
				                                  MISWriter.write(Error);
				                                  MISWriter.close();
				                                  e.printStackTrace();
				                                  System.out.println("Manage Operator Not Clicked:::::::::::::::"+e);
				                               }
				                         Thread.sleep(2000);
				                         driver.switchTo().frame(0);
				                         System.out.println("Manage Operator frame Opened");
				                         driver.switchTo().defaultContent();
				                         
				                         driver.findElement(By.xpath("//a[@title='Subscription Master Products']")).click();
				                         System.out.println(" Subscription Master Products Expanded");
				                         Thread.sleep(2000);
				                         driver.switchTo().frame(0);
				                         try {                      
				                              WebElement gsname=driver.findElement(By.name("groupId"));
				                              Select select3=new Select(gsname);
				                              select3.selectByVisibleText("Idea");
				                             System.out.println("Idea Network opened");
				                              }catch(NoSuchElementException e)
				                              
				                              {
				                                      FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                                 String Error23g=e.getMessage();
				                                 Error=Error+"\n"+"\n"+Error23g;
				                                 MISWriter.write(Error);
				                                 MISWriter.close();
				                                 e.printStackTrace();
				                                 System.out.println("Idea Network Not opened:::::::::::::::"+e);
				                              }
				                              
				                                Thread.sleep(2000);
				                                
				                              try {
				                                    driver.findElement(By.xpath("//input[@value='Go']")).click();
				                                    System.out.println("Go Clicked");
				                                    
				                                    }catch(ElementNotInteractableException e)
				                                    
				                                    {
				                                            FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                                       String Error23h=e.getMessage();
				                                       Error=Error+"\n"+"\n"+Error23h;
				                                       MISWriter.write(Error);
				                                       MISWriter.close();
				                                       e.printStackTrace();
				                                       System.out.println("Go Not Clicked:::::::::::::::"+e);
				                                    }
				                                    
				                                    Thread.sleep(2000);
				                                try {
				                                    driver.switchTo().defaultContent();
				                                    
				                                    }catch(UnhandledAlertException e)
				                                    
				                                    {
				                                            FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                                       String Error23i=e.getMessage();
				                                       Error=Error+"\n"+"\n"+Error23i;
				                                       MISWriter.write(Error);
				                                       MISWriter.close();
				                                       e.printStackTrace();
				                                       System.out.println("Default frame not selected:::::::::::::::"+e);
				                                    }
				                                      Thread.sleep(2000);
				                                    driver.findElement(By.xpath("//a[@title='Price Point Ids']")).click();
				                                     System.out.println(" Price Point Ids");
				                                    Thread.sleep(2000);   
				                                     driver.switchTo().frame(0);

				                         driver.switchTo().defaultContent();
				                         Thread.sleep(2000);
				                         driver.findElement(By.xpath("//*[@id=\"mCSB_1\"]")).sendKeys(Keys.CONTROL, Keys.END);
				                         System.out.println("Settings Scrolled");
				                         Thread.sleep(2000);
				                         driver.findElement(By.xpath("//a[@title='Settings']")).click();
				                         System.out.println("Settings Expanded");
				                                                                                                                                                     
				                         Thread.sleep(2000);
				                        
				                         //JavascriptExecutor js = (JavascriptExecutor)driver;  
				                         //js.executeScript("scrollBy(0, 4500)");   
				                       
				                   try {
				                         driver.findElement(By.xpath("/html/body/div/section/aside/div/div[1]/section/div[1]/ul/li[3]/ul/li[5]/ul/li[5]/ul/li[1]/a/span")).click();
				                         System.out.println("(Settings)View Settings Clicked............");
				                         }catch(ElementNotInteractableException e)
				                         
				                         {
				                                 FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                            String Error23j=e.getMessage();
				                            Error=Error+"\n"+"\n"+Error23j;
				                            MISWriter.write(Error);
				                            MISWriter.close();
				                            e.printStackTrace();
				                            System.out.println("(Settings)View Settings Not Clicked:::::::::::::::"+e);
				                         }
				                   //JavascriptExecutor js1 = (JavascriptExecutor)driver;  
				                    //js.executeScript("scrollBy(0, 7000)");   
				                         
				                       
				                       
				                        Thread.sleep(2000);
				                   driver.findElement(By.xpath("/html/body/div/section/aside/div/div[1]/section/div[1]/ul/li[3]/ul/li[5]/ul/li[5]/ul/li[2]/a/span")).click();
				                         System.out.println(" (Settings)Edit Settings Settings clicked");
				                         driver.switchTo().frame(0) ;
				                         System.out.println("FramEdit opened");
				                        driver.switchTo().defaultContent();
				                        driver.findElement(By.xpath("//a[@title='Group Content Type']")).click();
				                         System.out.println(" Country Expanded");
				                         try {
				                               driver.findElement(By.xpath("//a[@title='Add/Edit Content Type']")).click();
				                               System.out.println("(Group Content Type)Add/Edit/View/DeleteClicked............");
				                               }catch(ElementNotInteractableException e)
				                               
				                              {
				                                       FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                                  String Error23k=e.getMessage();
				                                  Error=Error+"\n"+"\n"+Error23k;
				                                  MISWriter.write(Error);
				                                  MISWriter.close();
				                                  e.printStackTrace();
				                                  System.out.println("(Group Content Type)Add/Edit/View/Delete Not Clicked:::::::::::::::"+e);
				                               }
				                         
				                         Thread.sleep(2000);
				                         driver.switchTo().frame(0);
				                         
				                  driver.switchTo().defaultContent();
				                 try {
				                               driver.findElement(By.xpath("//a[@title='View Content Type']")).click();
				                               System.out.println("(Group Content Type)View Content Type Clicked............");
				                               }catch(ElementNotInteractableException e)
				                               
				                               {
				                                       FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                                  String Error23l=e.getMessage();
				                                  Error=Error+"\n"+"\n"+Error23l;
				                                  MISWriter.write(Error);
				                                  MISWriter.close();
				                                  e.printStackTrace();
				               System.out.println("(Group Content Type)View Content Type Not Clicked:::::::::::::::"+e);
				                               }
				                 Thread.sleep(2000);
				                 driver.switchTo().frame(0);
				                 try {                        
				                              WebElement gsname=driver.findElement(By.name("groupName"));
				                              Select select3=new Select(gsname);
				                              select3.selectByVisibleText("Idea");
				                              System.out.println("Idea Groups opened");
				                              }catch(NoSuchElementException e)
				                              
				                              {
				                                      FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                                 String Error23m=e.getMessage();
				                                 Error=Error+"\n"+"\n"+Error23m;
				                                 MISWriter.write(Error);
				                                 MISWriter.close();
				                                 e.printStackTrace();
				                                 System.out.println("Groups Idea Not opened:::::::::::::::"+e);
				                              }
				                              
				                                Thread.sleep(2000);
				                 
				                              try {
				                                    driver.findElement(By.xpath("//input[@value='Go']")).click();
				                                    System.out.println("Go Clicked");
				                                    
				                                    }catch(ElementNotInteractableException e)
				                                    
				                                    {
				                                FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                                       String Error23n=e.getMessage();
				                                       Error=Error+"\n"+"\n"+Error23n;
				                                       MISWriter.write(Error);
				                                       MISWriter.close();
				                                       e.printStackTrace();
				                                       System.out.println("Go Not Clicked:::::::::::::::"+e);
				                                    }
				                                    
				                                    Thread.sleep(2000);
				                                    try {
				                                    driver.switchTo().defaultContent();
				                                    
				                                    }catch(UnhandledAlertException e)
				                                    
				                                    {
				                                FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                                       String Error23o=e.getMessage();
				                                       Error=Error+"\n"+"\n"+Error23o;
				                                       MISWriter.write(Error);
				                                       MISWriter.close();
				                                       e.printStackTrace();
				                                     System.out.println("Default frame not selected:::::::::::::::"+e);
				                                    }
				                                      Thread.sleep(2000);
				                 
				                      }catch(ElementNotInteractableException e)
				                         
				                         {
				                    	  FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                          String Error23p=e.getMessage();
				                          Error=Error+"\n"+"\n"+Error23p;
				                          MISWriter.write(Error);
				                          MISWriter.close();
				                            e.printStackTrace();
				                            System.out.println("Administration Expanded:::::::::::::::"+e);
				                         }
				                          driver.findElement(By.xpath("//a[@title='My Profile']")).click();
				                           System.out.println(" My Profile Opened");
				                         Thread.sleep(2000);
				                           driver.switchTo().frame(0);
				                           try {
				                               driver.findElement(By.xpath("//input[@value='Save']")).click();
				                               System.out.println("Form Submit clicked");
				                               Thread.sleep(2000);
				                               driver.switchTo().alert().accept();
				                               System.out.println("Alert clicked OK");
				                               Thread.sleep(2000);
				                               }catch(ElementNotInteractableException e)
				                               
				                               {
				                 FileWriter MISWriter = new FileWriter("E:\\freshers\\WIPAYE"+i+".txt");
				                              String Error23q=e.getMessage();
				                              Error=Error+"\n"+"\n"+Error23q;
				                              MISWriter.write(Error);
				                              MISWriter.close();
				                              e.printStackTrace();
				                              System.out.println("Form Not submited:::::::::::::::"+e);
				                               }
				                               
				                               Thread.sleep(2000);
				                         
				                    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				                    driver.switchTo().defaultContent();
				                                
				                      driver.findElement(By.xpath("/html/body/div/header/nav/div/ul/li/a/span")).click();
				                    System.out.println("User Clicked....");
				                    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				                    
				                    driver.findElement(By.linkText("Sign out")).click();
				                    System.out.println("User loged out....linkText");
				                    System.out.println("##############################################################################");
				                    
				    }
			        driver.close();
System.out.println("##############################################################################");
System.out.println("***********SANITY TEST COMPLETED***********");
	            System.out.println("##############################################################################");

				     }
				  }
				                          
