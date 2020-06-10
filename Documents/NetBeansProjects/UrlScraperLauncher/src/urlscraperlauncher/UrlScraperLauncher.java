
package urlscraperlauncher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class UrlScraperLauncher {

    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
     int counteroftheloop  = 0;
       int loopcap = 0;
       int subloopcount = 0;
       File file3 = new File("C:\\Users\\tremanleo\\Documents\\NetBeansProjects\\UrlScraperLauncher\\CustomFiles\\FileArea\\urlstoscrape.txt");  
       File UrlLoaderFile = new File("C:\\Users\\tremanleo\\Documents\\NetBeansProjects\\UrlScraperLauncher\\CustomFiles\\FileArea\\UrlLoader.txt");
       BufferedReader br3 = new BufferedReader(new FileReader(file3));
       String Manipulator = "";     
       
        //Check the number of lines in the url holder txt file, then set the scraping for that many lines / set the sring array to hold that many lines.
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\tremanleo\\Documents\\NetBeansProjects\\UrlScraperLauncher\\CustomFiles\\FileArea\\urlstoscrape.txt"));
        int NumberOfLines = 0;
        while (reader.readLine() != null) NumberOfLines++;
        reader.close();
        
        loopcap = NumberOfLines;
        System.out.println(loopcap);
        String[] URLHolderArrayL = new String[NumberOfLines]; 
       
        //Read the url list and populate current url with scraping url.
	String line3;
	while ((line3 = br3.readLine()) != null) 
            {                      
            URLHolderArrayL[subloopcount] = line3;
             subloopcount++;
            }
             subloopcount = 0;
             br3.close();

                   while (counteroftheloop != loopcap)
                {  
                System.out.println("Launching URL Scraper.");            
                // Run LeonardScraper2
                Process proc = Runtime.getRuntime().exec("java -jar C:\\Users\\tremanleo\\Documents\\NetBeansProjects\\UrlScraperLauncher\\CustomFiles\\FileArea\\UrlScraper.jar");
                InputStream in = proc.getInputStream();
                InputStream err = proc.getErrorStream();     
                
                //Give it time to run
                TimeUnit.SECONDS.sleep(8);   
                    
                //Move Number Matching URL name from URLHolder Array To Manipulator                       
               Manipulator = URLHolderArrayL[counteroftheloop];
               System.out.println(Manipulator);
               
               //Write URL TO UrlLoader.txt for LeonardScraper2 To Use On Next Iteration
                   FileWriter fw3 = new FileWriter(UrlLoaderFile);
                   PrintWriter out3 = new PrintWriter(fw3);   
                   System.out.println("Manipulator: " + Manipulator);
                   out3.print(Manipulator);
                    out3.flush(); 
                     out3.close();
                     fw3.close();                
                
                counteroftheloop++;
                }
                   //Reset UrlLoader.txt for next use
                   FileWriter fw3 = new FileWriter(UrlLoaderFile);
                   PrintWriter out3 = new PrintWriter(fw3);     
                   out3.print("https://www.pcs-company.com/nitrided-ejector-pins-oversize");
                    out3.flush(); 
                     out3.close(); 
                     fw3.close();    
    }    
}
