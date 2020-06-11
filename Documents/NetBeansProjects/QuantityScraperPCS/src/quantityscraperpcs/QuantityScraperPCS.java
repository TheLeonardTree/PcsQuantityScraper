package quantityscraperpcs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class QuantityScraperPCS {

    public static void main(String[] args) throws IOException {
     String holder2 = "";
     String URL = "";
	     File file2 = new File("C:\\Users\\tremanleo\\Documents\\NetBeansProjects\\ScrapeTheUrlsOfAPage\\CustomFiles\\FileArea\\UrlLoader.txt"); 
	     int filenamecounter = 0;
	     String GimmeAName = "";
	     String[] SpanHolderArray = new String[99999];
	     int SpanHolderCounter = 0;
	     int TheNumberOfLines = 0;
	     int CounterOfJustice = 0;    
	     String S = ""; 
             String Modifier = "";
	     int newlinecounter = 0;
             String StuffToWrite = "";
             String NameOfTheItem = "";
             String NameTheFile = "";             

  Document doc = Jsoup.connect("https://www.pcs-company.com/ae-041620").timeout(1000 * 1000).get();
        Elements spangrabbers = doc.getElementsByClass("table-wrapper");
        Elements h1s = doc.select("h1");  
    //Grabs the title of the page
     for (Element h1 : h1s) 
{     
   NameOfTheItem = h1.text();
   System.out.println(NameOfTheItem);
}     
                              Modifier = NameOfTheItem.replaceAll(" ", "");
                         NameOfTheItem = Modifier.replaceAll(",", "");
     //Set The Name of The File
     NameTheFile = "C:\\Users\\tremanleo\\Documents\\NetBeansProjects\\QuantityScraperLauncher\\CustomFiles\\CSVArea\\" + NameOfTheItem + ".csv";
       File f = new File(NameTheFile);
	FileWriter fw = new FileWriter(f);
	PrintWriter out = new PrintWriter(fw);  

        for (Element spangrab : spangrabbers)
		    {
		    //System.out.println("New Span: ");
		    //System.out.println(spangrab);
		    holder2 = spangrab.text();
		    //System.out.println(holder2);
		    SpanHolderArray[SpanHolderCounter] = holder2;
		    System.out.println(SpanHolderCounter);
		    System.out.println(SpanHolderArray[SpanHolderCounter]);
		    SpanHolderCounter++;
		    }
		    //Phase 4, Write The Stuff We Need To A File                    
                    //ItemName

                        out.print(NameOfTheItem); 
                        out.print(","); 
                    
                    //Quantity
		    StuffToWrite = SpanHolderArray[CounterOfJustice];
            Modifier = StuffToWrite.replaceAll("Quantity Available: ", "");
            StuffToWrite = Modifier.replaceAll(",", "");            
		     out.print(StuffToWrite);  
		      out.print("\n");  
		  
		        newlinecounter++;
		        if (newlinecounter == 1)
		        {
		            newlinecounter = 0;
		        }
		        CounterOfJustice++;

            	    out.flush(); 
	    //Close the Print Writer
	   out.close();       
	   //Close the File Writer
	   fw.close();    
    }    
}