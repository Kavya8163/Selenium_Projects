package com.WipayTest_Project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

     public class Wipay_Test_Log {
	 public static void main(String[] args) throws InterruptedException, IOException {	
         
	        //Creating a driver object referencing WebDriver interface
		    WebDriver driver;
	    	String Error="";   
	    		            	         
	        //Setting webdriver.gecko.driver property
	    	
	    	System.setProperty("webdriver.gecko.driver","E:\\freshers\\Firefox\\geckodriver.exe");
	         
	        //launching browser
	        
	        
	        
	        driver = new FirefoxDriver();  
	        WebDriverWait wait=new WebDriverWait(driver,30);	
	        //JavascriptExecutor js = (JavascriptExecutor) driver;
	       
	        int i;         
	        for(i=1;i<=2;i++) 
	       {	
        	try {
	            File WiLog = new File("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	            if (WiLog.createNewFile()) {
	              System.out.println("File created: " + WiLog.getName());
	            } else {
	              System.out.println("File already exists.");
	            }
	          } catch (IOException e) {
	            System.out.println("An error occurred.");
	            e.printStackTrace();
	          }
        	System.out.println("Sanity Test no : "+i);
  	        System.out.println("##############################################################################");
  	        driver.get("http://dev.wicore.in/WiPayTest/");
  	        Thread.sleep(3000);
   
	        try{
		        driver.findElement(By.xpath("//*[@id=\"faq\"]/div/div/h2[1]/a")).click();
		        System.out.println("");
	        
	        Thread.sleep(3000); 
	        
			try{
			    driver.findElement(By.xpath("/html/body/section/div/div/table/tbody/tr/td/a/span")).click();
				System.out.println("---AddNewOpened---");
			}catch(NoSuchElementException e)
			{
				FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
				e.printStackTrace();
				System.out.println("^^^^^^^Exception^^^^^^^^"+e);
				System.out.println("---------AddNewOp----");}
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		    try {
			    driver.findElement(By.name("tg_group_name")).sendKeys("SampleTestGroup");
		        System.out.println("tg_group_name Entered");
		        Thread.sleep(1000); 
	        }catch(NoSuchElementException e)
	        
	        {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("tg_group_name text field not available:::::::::::::::"+e);
	        }
		    try {
			    driver.findElement(By.name("tg_description")).sendKeys("TestGroupLinks");
		        System.out.println("tg_description Entered");
		        Thread.sleep(3000); 
	        }catch(NoSuchElementException e)
	        
	        {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("tg_description text field not available:::::::::::::::"+e);
	        }
			try {
		        driver.findElement(By.xpath("//input[@class='upload']")).click();
		        System.out.println("Submited the Page");
	        }catch(NoSuchElementException e)
	            {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("Submit button not available:::::::::::::::"+e);
	        	
	            }
		 
	         /*((JavascriptExecutor) driver).executeScript("scroll(0,300)");
	           arguments[0].scrollIntoView()", Element
	           Thread.sleep(2000);
	           WebElement plan = driver.findElement(By.xpath("/html/body/section/div/div/div/table/tbody/tr[131]/td/a"));
	           System.out.println("GoToIndexPageClicked");
	 		   plan.click();
	 		   Thread.sleep(2000);
	           JavascriptExecutor js = (JavascriptExecutor) driver;
		       WebElement Element = driver.findElement(By.xpath("/html/body/section/div/div/div/table/tbody/tr[102]/td/a"));*/
			  /* driver.findElement(By.xpath("//*[@id=\"faq\"]")).sendKeys(Keys.CONTROL, Keys.END);
		       System.out.println("Page scrolled down");
		       driver.findElement(By.xpath("/html/body/section/div/div/div/table/tbody/tr[130]/td/a")).click();*/
		        
	        WebElement Element = driver.findElement(By.linkText("Go to Index"));
	        Element.click();
	        System.out.println("*****************Go To Index Clicked***************");
	        }catch(NoSuchElementException e)
	        {   
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=""+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
		        e.printStackTrace();
		        System.out.println("^^^^^^^Exception^^^^^^^^"+e);
		        System.out.println("---------AddNewGroupOpened-----");}
	        Thread.sleep(3000); 
		     try{
		        driver.findElement(By.xpath("/html/body/section/div/div/h2[2]/a")).click();
		        System.out.println("");
			
			        Thread.sleep(3000);       
			 try{
				driver.findElement(By.xpath("/html/body/section/table/tbody/tr/td/a[1]/span")).click();
				System.out.println("---AddEditOpened---");
			}catch(NoSuchElementException e)
			    {
				e.printStackTrace();
				System.out.println("^^^^^^^Exception^^^^^^^^"+e);
				System.out.println("---------AddEditOp----");}
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 try {	        	        
			    WebElement gsname=driver.findElement(By.name("billing_type"));
			    Select select3=new Select(gsname);
			    select3.selectByVisibleText("IP Billing");
			    System.out.println("IP Billing opened");
			 }catch(NoSuchElementException e)
			    {
		    	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
		    	e.printStackTrace();
		    	System.out.println("billing_type IP Billing Not opened:::::::::::::::"+e);
			    }
			        Thread.sleep(500);
			try {	        	        
			    WebElement gsname=driver.findElement(By.name("tg_group_id"));
			    Select select3=new Select(gsname);
			    select3.selectByVisibleText("SampleTestGroup");
			    System.out.println("SampleTestGroup opened");
		    }catch(NoSuchElementException e)
			    {
		    	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
		    	e.printStackTrace();
		    	System.out.println("TestGroup valuepack Not opened:::::::::::::::"+e);
			    }
				   Thread.sleep(500);
				   driver.switchTo().alert().accept();
	        try {
		        driver.findElement(By.xpath("/html/body/section/div/form[1]/table[1]/tbody/tr[3]/td[2]/ul/li[20]/input")).click();
		        System.out.println("Operator VodafoneOpened");
		    }catch(NoSuchElementException e)
	            {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("Operator Vodafone not available:::::::::::::::"+e);
	            }
	         Thread.sleep(1000);
            try {
            	 driver.findElement(By.xpath("//*[@id=\"link\"]")).sendKeys("SampleTestGroupLinks");
			     System.out.println("SampleTestGroupLinks Entered**********");
			     Thread.sleep(3000); 
	        }catch(ElementNotInteractableException e)
		        
		        {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("SampleTestGroupLinks not available:::::::::::::::"+e);
		        }
             Thread.sleep(3000);
			 try {
			   driver.findElement(By.name("merchant_id")).sendKeys("177");
		       System.out.println("merchant_id Entered");
				       Thread.sleep(3000); 
	        }catch(ElementNotInteractableException e)
 		        {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("merchant_id not available:::::::::::::::"+e);
		        }
		     try {
			     driver.findElement(By.name("country_code")).sendKeys("91");
		         System.out.println("country_code Entered");
			         Thread.sleep(3000); 
	        }catch(NoSuchElementException e)
			        
		        {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("country_code not available:::::::::::::::"+e);
	            }
		     try {
				  driver.findElement(By.name("order_id")).sendKeys("12o");
			      System.out.println("order_id 12o Entered");
				  Thread.sleep(3000); 
	         }catch(NoSuchElementException e)
	        
		          {FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
		    	  String Error3=e.getMessage();
		    	  Error=Error+"\n"+"\n"+Error3;
		    	  MISWriter.write(Error);
		    	  MISWriter.close();
		    	  e.printStackTrace();
		    	  System.out.println("order_id not available:::::::::::::::"+e);
		        }
					      
			 try {
			        WebElement gid2=driver.findElement(By.name("content_type"));
			        Select select2=new Select(gid2);
			        select2.selectByVisibleText("Animations");
			        System.out.println("content_type Animations Selected");
						         Thread.sleep(3000); ;
		     }catch(NoSuchElementException e)
		        
			        {FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
		        	String Error3=e.getMessage();
		        	Error=Error+"\n"+"\n"+Error3;
		        	MISWriter.write(Error);
		        	MISWriter.close();
		        	e.printStackTrace();
		        	System.out.println("content_type Animations not avaialble:::::::::::::::"+e);
			        }
		     try {
					driver.findElement(By.name("content_id")).sendKeys("112");
			        System.out.println("content_id 112 Entered");
				    Thread.sleep(3000); 
		     }catch(NoSuchElementException e)
		        
		        {
		        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
		        	String Error3=e.getMessage();
		        	Error=Error+"\n"+"\n"+Error3;
		        	MISWriter.write(Error);
		        	MISWriter.close();
		        	e.printStackTrace();
		        	System.out.println("content_id 112not available:::::::::::::::"+e);
		        }
			  try {
			        WebElement gid2=driver.findElement(By.name("bill_type"));
			        Select select2=new Select(gid2);
			        select2.selectByVisibleText("ValuePack");
			        System.out.println("bill_type ValuePack Selected");
				         Thread.sleep(3000); ;
	         }catch(NoSuchElementException e)
	        
	         {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("bill_type ValuePack not avaialble:::::::::::::::"+e);
	        }
			  try {
				  driver.findElement(By.name("price")).sendKeys("50");
			      System.out.println("price Entered");
			      Thread.sleep(3000); 
	         }catch(NoSuchElementException e)
	        
	         {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("price not available:::::::::::::::"+e);
	         }
			  try {
				  driver.findElement(By.name("min_price")).sendKeys("5");
			      System.out.println("min_price  Entered");
			      Thread.sleep(3000); 
	         }catch(NoSuchElementException e)
	        
	         {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("min_price not available:::::::::::::::"+e);
	         }
			  try {
				  driver.findElement(By.name("model")).sendKeys("Samsung");
			      System.out.println("model  Entered");
			      Thread.sleep(3000); 
			  }catch(NoSuchElementException e)
			       
			  {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("model not available:::::::::::::::"+e);
	          }
			 try {
				  driver.findElement(By.name("title")).sendKeys("AllTypeAnimations");
			      System.out.println("title Entered");
			      Thread.sleep(3000); 
	         }catch(NoSuchElementException e)
	        
	         {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("title not available:::::::::::::::"+e);
	         }

			 try {
				  driver.findElement(By.name("user_id")).sendKeys("Ani1234");
			      System.out.println("user_id Entered");
			      Thread.sleep(3000); 
	        }catch(NoSuchElementException e)
	        
	        {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("user_id not available:::::::::::::::"+e);
	        }
			 try {
				  driver.findElement(By.name("cg_image_url")).sendKeys("imageurlpath");
			      System.out.println("cg_image_url Entered");
			      Thread.sleep(3000); 
	        }catch(NoSuchElementException e)
	        
	        {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("cg_image_url not available:::::::::::::::"+e);
	        }
	        
						  
			 try {
				  driver.findElement(By.name("content_access_url")).sendKeys("http://dev.wicore.in");
			      System.out.println("content_access_url Entered");
			      Thread.sleep(3000); 
			}catch(NoSuchElementException e)
			
			{
				FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
				String Error3=e.getMessage();
				Error=Error+"\n"+"\n"+Error3;
				MISWriter.write(Error);
				MISWriter.close();
				e.printStackTrace();
				System.out.println("content_access_urlnot available:::::::::::::::"+e);
				        }
				 
			 try {
				   driver.findElement(By.name("exp_cbstatus_message")).sendKeys("http://dev.wicore.in");
			       System.out.println("exp_cbstatus_message Entered");
			       Thread.sleep(3000); 
	        }catch(NoSuchElementException e)
	          {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("exp_cbstatus_message not available:::::::::::::::"+e);
	          }
			 try {
				   driver.findElement(By.name("sign")).sendKeys("fff46f67e3de063d2c50800dbc25a133");
			       System.out.println("sign Entered");
			       Thread.sleep(3000); 
	        }catch(NoSuchElementException e)
	        
	        {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("sign  not available:::::::::::::::"+e);
	        }
			 try {
			        driver.findElement(By.xpath("/html/body/section/div/form[1]/table[2]/tbody/tr/td[2]/input[2]")).click();
			        System.out.println("BackButton Submited");
	         }catch(NoSuchElementException e)
	            {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("BackButton  not available:::::::::::::::"+e);
	        	}
	         try{
				    driver.findElement(By.xpath("/html/body/section/table/tbody/tr/td/a[2]/span")).click();
					System.out.println("---AddEditLinksTestOpened---");
			 }catch(NoSuchElementException e)
			 {
				FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
				e.printStackTrace();
				System.out.println("^^^^^^^Exception^^^^^^^^"+e);
				System.out.println("---------AddEditLinksTestNotAvailable----");}
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 try {
				   driver.findElement(By.name("link")).sendKeys("TestCase");
			       System.out.println("TestCase Entered");
			       Thread.sleep(3000); 
	        }catch(NoSuchElementException e)
	        
	        {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("TestCase  not available:::::::::::::::"+e);
	        }
 	        try {
			    driver.findElement(By.name("mid")).sendKeys("174");
		        System.out.println("mid Entered");
		        Thread.sleep(3000); 
	        }catch(NoSuchElementException e)
	        
	        {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
		    	String Error3=e.getMessage();
		    	Error=Error+"\n"+"\n"+Error3;
		    	MISWriter.write(Error);
		    	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("mid  not available:::::::::::::::"+e);
	        }
		    try {
		        WebElement gid2=driver.findElement(By.name("ctype"));
		        Select select2=new Select(gid2);
		        select2.selectByVisibleText("Animations");
		        System.out.println("content_type Animations Selected");
		         Thread.sleep(3000); ;
	        }catch(NoSuchElementException e)
	        
	        {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("content_type Animations not avaialble:::::::::::::::"+e);
	        }
		   try {
		        WebElement gid2=driver.findElement(By.name("bill_type"));
		        Select select2=new Select(gid2);
		        select2.selectByVisibleText("ValuePack");
		        System.out.println("bill_type ValuePack Selected");
		        Thread.sleep(3000); ;
	       }catch(NoSuchElementException e)
	        
	        {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("bill_type ValuePack not avaialble:::::::::::::::"+e);
	         }
			  try {
			     driver.findElement(By.name("make")).sendKeys("make");
		         System.out.println("make Entered");
		         Thread.sleep(3000); 
	         }catch(NoSuchElementException e)
	        
	         {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("make  not available:::::::::::::::"+e);
	         }
			 try {
				  driver.findElement(By.name("model")).sendKeys("model");
			      System.out.println("model Entered");
			      Thread.sleep(3000); 
	         }catch(NoSuchElementException e)
	        
	         {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("model  not available:::::::::::::::"+e);
	         }
			 try {
				  driver.findElement(By.name("access_url")).sendKeys("access_url");
			      System.out.println("access_url Entered");
			      Thread.sleep(3000); 
	        }catch(NoSuchElementException e)
	        
	        {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("access_url  not available:::::::::::::::"+e);
	        }
								  
		   try{
		        driver.findElement(By.xpath("/html/body/section/div/form/table/tbody/tr[16]/td/a")).click();
		        System.out.println("Go to index opened");
		        }
		   catch(NoSuchElementException e)
	        {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
		        e.printStackTrace();
		        System.out.println("^^^^^^^Exception^^^^^^^^"+e);
		        System.out.println("--------Go to index opened-----");}
		       Thread.sleep(3000); 
		    }catch(NoSuchElementException e)
		        {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
		        e.printStackTrace();
		        System.out.println("^^^^^^^Exception^^^^^^^^"+e);
		        System.out.println("---------AddEditLinkOpened-----");}
		        Thread.sleep(3000); 			  
							  
							  
           /* try {
	              driver.findElement(By.xpath("//input[@name='bill_typewise']")).click();
	    		  System.out.println("bill_typewise CheckBox...Selected wait");
	    	      }catch(NoSuchElementException e)
	    	        
	    	      {
	    	       e.printStackTrace();
	    	      	System.out.println("bill_typewise Not Selected:::::::::::::::"+e);
	    	      }
	    	       //Thread.sleep(3000);	 
	    	       Thread.sleep(500);*/
	   
	    	       
        //driver.get("http://dev.wicore.in/WiPayTest/");  
             try{
			    driver.findElement(By.xpath("/html/body/section/div/div/h2[3]/a")).click();
			    System.out.println("");
	        
		       Thread.sleep(3000); 
	        try {	        	        
	  	        WebElement gsname=driver.findElement(By.name("tg_group_id"));
	  	        Select select3=new Select(gsname);
	  	        select3.selectByVisibleText("SampleTestGroup");
	  	        System.out.println("tg_group_id Entered");
	  	    }catch(NoSuchElementException e)
	  	        
  	        {
  	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
  	        	e.printStackTrace();
  	        	System.out.println("tg_group_id Entered Not opened:::::::::::::::"+e);
  	        }
	  	        
	        try {	        	        
	  	        WebElement gsname=driver.findElement(By.name("billing_type"));
	  	        Select select3=new Select(gsname);
	  	        select3.selectByVisibleText("IP Billing");
	  	        System.out.println("IP Billing opened");
	  	   }catch(NoSuchElementException e)
  	        
  	        {
  	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
  	        	e.printStackTrace();
  	        	System.out.println("billing_type IP Billing Not opened:::::::::::::::"+e);
  	        }
	        try {
		        driver.findElement(By.name("sessionName")).sendKeys("session_name");
		        System.out.println("sessionName Entered");
		        Thread.sleep(3000); 
		    }catch(NoSuchElementException e)
		        
	        {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("sessionName text field not available:::::::::::::::"+e);
	        }
	        try {
		        driver.findElement(By.name("port")).sendKeys("url");
		        System.out.println("Port Entered");
		        Thread.sleep(3000); 
	        }catch(NoSuchElementException e)
	        
	        {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("Port text field not available:::::::::::::::"+e);
	        }
	        try {
		        driver.findElement(By.xpath("//input[@class='upload']")).click();
		        
		        System.out.println("Submited");
	        }catch(NoSuchElementException e)
	            {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("Submit button not available:::::::::::::::"+e);
	        	
	            }
	        Thread.sleep(2000);
	        try{
		        driver.findElement(By.xpath("/html/body/form/center/fieldset/a/b")).click();
		        System.out.println("HomePageOpened");
	        }catch(NoSuchElementException e)
	        {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
		        e.printStackTrace();
		        System.out.println("^^^^^^^Exception^^^^^^^^"+e);
		        System.out.println("--------HomePageOpened-----");}
         
	        Thread.sleep(2000);
	        try{
		        driver.findElement(By.xpath("/html/body/form/section/div/div/table[2]/tbody/tr/td[2]/a")).click();
		        System.out.println("Go to index opened");
	        }catch(NoSuchElementException e)
	        {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
		        e.printStackTrace();
		        System.out.println("^^^^^^^Exception^^^^^^^^"+e);
		        System.out.println("--------Go to index opened-----");}
		       Thread.sleep(3000); 
             }catch(NoSuchElementException e)
	         {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
		        e.printStackTrace();
		        System.out.println("^^^^^^^Exception^^^^^^^^"+e);
		        System.out.println("--------TestPageClosed-----");}
             Thread.sleep(2000);
		    // driver.get("http://dev.wicore.in/WiPayTest/");
	        //*************Home************//
	       /* try{
		        driver.findElement(By.xpath("/html/body/form/center/fieldset/a/b")).click();
		        System.out.println("");
		        }catch(NoSuchElementException e)
		        {
		        e.printStackTrace();
		        System.out.println("^^^^^^^Exception^^^^^^^^"+e);
		        System.out.println("--------TestPageOpened-----");}
		        
		         Thread.sleep(3000); */
	        try{
		        driver.findElement(By.xpath("/html/body/section/div/div/h2[4]/a/b")).click();
		        System.out.println("");
	        
	       Thread.sleep(3000); 
		      try {
		        WebElement frd=driver.findElement(By.name("fromd"));
		        Select frdsel=new Select(frd);
		        frdsel.selectByValue("5");
		        System.out.println("From Date 3 selected");
			        
		      }catch(NoSuchElementException e)
		        
	        {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("From Date Not selected:::::::::::::::"+e);
	        }
	       Thread.sleep(3000); 
	       driver.switchTo().alert().accept();
		      
		    try {
		        WebElement frm=driver.findElement(By.name("fromm"));
		        Select frdsel2=new Select(frm);
		        frdsel2.selectByValue("10");
		        System.out.println("From month 'October' selected");
	        }catch(ElementNotInteractableException e)
	        
	        {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("From month October Not selected:::::::::::::::"+e);
	        }
	        
		       Thread.sleep(3000); 
		    try {
		        WebElement frm=driver.findElement(By.name("fromy"));
		        Select frdsel2=new Select(frm);
		        frdsel2.selectByValue("2021");
		        System.out.println("From year '2021' selected");
	        }catch(ElementNotInteractableException e)
	        
	        {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("From month Not selected:::::::::::::::"+e);
	        }
		        
		    Thread.sleep(3000); 
		   try {
		        WebElement frd2=driver.findElement(By.name("tod"));
		        Select frdsel3=new Select(frd2);
		        frdsel3.selectByValue("7"); 
		        System.out.println("From Date 23 selected");
	       }catch(ElementNotInteractableException e)
	        
	        {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("From Date Not selected:::::::::::::::"+e);
	        }
	         Thread.sleep(3000); 
			        
	        try {
		        WebElement frm2=driver.findElement(By.name("tom"));
		        Select frdsel4=new Select(frm2);
		        frdsel4.selectByValue("10");
		        System.out.println("From month 'March' selected");
	        }catch(ElementNotInteractableException e)
	        
	        {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("From Month Not selected:::::::::::::::"+e);
	        }
	        Thread.sleep(3000); 
	         try {
		        WebElement frm2=driver.findElement(By.name("toy"));
		        Select frdsel4=new Select(frm2);
		        frdsel4.selectByValue("2021");
		        System.out.println("From year '2021' selected");
	         }catch(ElementNotInteractableException e)
	        
	         {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("From year '2021' Not selected:::::::::::::::"+e);
	         }
	         Thread.sleep(3000); 
		     try {	        	        
	  	        WebElement tggroup=driver.findElement(By.name("tg_group_id"));
	  	        Select select3=new Select(tggroup);
	  	        select3.selectByVisibleText("APIValidation");
	  	        System.out.println("APIValidation opened");
  	        }catch(NoSuchElementException e)
  	        
  	        {
  	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
  	        	e.printStackTrace();
  	        	System.out.println("TestGroup APIValidation Not opened:::::::::::::::"+e);
  	        }
	         try {	        	        
	  	        WebElement gsname=driver.findElement(By.name("session_name"));
	  	        Select select3=new Select(gsname);
	  	        select3.selectByVisibleText("All");
	  	        System.out.println("session_name All opened");
  	        }catch(NoSuchElementException e)
	        
	        {
  	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("session_name vodafone not available:::::::::::::::"+e);
	        }
	        try {	        	        
	  	        WebElement gsname=driver.findElement(By.name("telco"));
	  	        Select select3=new Select(gsname);
	  	        select3.selectByVisibleText("Vodafone");
	  	        System.out.println("Telco Idea opened");
	        }catch(NoSuchElementException e)
	        
	        {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("Telco Idea  Not opened:::::::::::::::"+e);
	        }
		      
	        try {	        	        
	  	        WebElement gsname=driver.findElement(By.name("result"));
	  	        Select select3=new Select(gsname);
	  	        select3.selectByVisibleText("All");
	  	        System.out.println("result Pass opened");
  	        }catch(NoSuchElementException e)
  	        
  	        {
  	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
  	        	e.printStackTrace();
  	        	System.out.println("result Pass Not opened:::::::::::::::"+e);
  	        }
  
		       /* try {
		        driver.findElement(By.xpath("//input[@class='upload']")).click();
		        
		        System.out.println("Submited");
		         }catch(NoSuchElementException e)
		            {
		        	e.printStackTrace();
		        	System.out.println("Submit button not available:::::::::::::::"+e);
		        	
		            }
	        driver.get("http://dev.wicore.in/WiPayTest/");*/
	        
	        /*try {
	        	
	        			
	        	driver.findElement(By.xpath("//input[@onclick='displayCalendarSelectBox(document.forms[0].fromy,document.forms[0].fromm,document.forms[0].fromd,false,false,this)']")).click();	
		       
		        System.out.println("Date picker clicked");
		     }catch(ElementNotInteractableException e)
		        
		        {
		        	e.printStackTrace();
		        	System.out.println("Date picker Not found:::::::::::::::"+e);
		        }
		        
		        
		       Thread.sleep(3000); 
		        
		        try {
			        driver.findElement(By.xpath("/html/body/div/div[4]/div[3]/img")).click();
			        System.out.println("dropdown clicked");
			        driver.findElement(By.xpath("//*[@id=\"monthDiv_5\"]")).click();
			        System.out.println("Month clicked");
			        driver.findElement(By.xpath("/html/body/div/div[7]/table/tbody/tr[3]/td[3]")).click();
			        System.out.println("date picker Date selected");
		       
		        }catch(ElementNotInteractableException e)
		        
		        {
		        	e.printStackTrace();
		        	System.out.println("date picker month NOT selected:::::::::::::::"+e);
		        }
		        
		       Thread.sleep(3000); 
		        try {	              
			        driver.findElement(By.xpath("/html/body/div/div[4]/img")).click();
			        System.out.println("Calender close(x) clicked ");
		        }catch(ElementNotInteractableException e)
		        
		        {
		        	e.printStackTrace();
		        	System.out.println("Calender close(x) NOT found clicked:::::::::::::::"+e);
		        }*/
			 try {
			        driver.findElement(By.xpath("//input[@class='upload']")).click();
			        System.out.println("Submited");
	         }catch(NoSuchElementException e)
	            {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
	        	e.printStackTrace();
	        	System.out.println("Submit button not available:::::::::::::::"+e);
	            }
                Thread.sleep(7000);
	        try{
		        driver.findElement(By.xpath("/html/body/section/div/form/table[2]/tbody/tr[2]/td[2]/div/a")).click();
		        System.out.println("Go to index opened");
	        }catch(NoSuchElementException e)
	        {
	        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
	        	String Error3=e.getMessage();
	        	Error=Error+"\n"+"\n"+Error3;
	        	MISWriter.write(Error);
	        	MISWriter.close();
		        e.printStackTrace();
		        System.out.println("^^^^^^^Exception^^^^^^^^"+e);
		        System.out.println("--------Go to index opened-----");}
		        Thread.sleep(3000); 
        //driver.get("http://dev.wicore.in/WiPayTest/");
        }catch(NoSuchElementException e)
        {
        	FileWriter MISWriter = new FileWriter("E:\\Selenium\\WIPAYTEST_AUTO_LOG"+i+".txt");
        	String Error3=e.getMessage();
        	Error=Error+"\n"+"\n"+Error3;
        	MISWriter.write(Error);
        	MISWriter.close();
	        e.printStackTrace();
	        System.out.println("^^^^^^^Exception^^^^^^^^"+e);
	        System.out.println("--------ReportPageClosedd-----");}
				        
		        
    }
			   }
}
	


