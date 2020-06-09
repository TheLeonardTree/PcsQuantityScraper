package scrapetheurlsofapage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.IOException;
import java.net.URL;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ScrapeTheUrlsOfAPage {
    public static void main(String[] args) throws IOException {
       //Phase 0 Variables:   
	     String URL = "https://www.pcs-company.com/hardened-throughout-step-pins";
	     String Checker = "Item No";
	     String Checker2 = "Price(USD)";
	     String TdHolder = "";
	     String TdHolder2 = "";
             String ItemNameStopper = "";
             String ItemNameStopper2 = "";
	     String[] TdHolderArray = new String[99999];
	     int TdHolderCounter = 0;
	      File file = new File("C:\\Users\\tremanleo\\Documents\\NetBeansProjects\\ScrapeTheUrlsOfAPage\\CustomFiles\\FileArea\\Counter.txt"); 
	      File file2 = new File("C:\\Users\\tremanleo\\Documents\\NetBeansProjects\\ScrapeTheUrlsOfAPage\\CustomFiles\\FileArea\\UrlLoader.txt"); 
	     int filenamecounter = 0;
	     int filenamecounter2 = 0;
	     String GimmeAName = "";
	     String holder2 = "";
	     String holder2A = "";
	     String[] SpanHolderArray = new String[99999];
	     int SpanHolderCounter = 0;
	     int TheNumberOfLines = 0;
	     int CounterOfJustice = 0;    
	     String StuffToWrite = ""; 
             String Modifier = "";
	     int newlinecounter = 0;

	//Phase 1 Name the Output File
	//Phase 0 Deciding The Name of the CSV File
	// Read The Counter      
	      BufferedReader br = new BufferedReader(new FileReader(file));
				String line;
				while ((line = br.readLine()) != null) 
	                        {
	                                filenamecounter = Integer.parseInt(line);  
				}
	                        br.close();
	                                                
	//Rename The Output File
	GimmeAName = ("C:\\Users\\tremanleo\\Documents\\NetBeansProjects\\ScrapeTheUrlsOfAPage\\CustomFiles\\CSVArea\\PCSURLS" + filenamecounter + ".csv");    
	File f = new File(GimmeAName);
	FileWriter fw = new FileWriter(f);
	PrintWriter out = new PrintWriter(fw);     

	filenamecounter = filenamecounter + 1;

	//Save The New Number
	   FileWriter fw2 = new FileWriter("C:\\Users\\tremanleo\\Documents\\NetBeansProjects\\ScrapeTheUrlsOfAPage\\CustomFiles\\FileArea\\Counter.txt");
	   PrintWriter out2 = new PrintWriter(fw2);  
	   out2.print(filenamecounter);
	   out2.flush(); 
	   //Close the Print Writer
	   out2.close();       
	   //Close the File Writer
	   fw2.close();      
	    
	    //Phase 2 Find The URL To Connect To
	BufferedReader br2 = new BufferedReader(new FileReader(file2));                      
	String line2 = "";
				while ((line2 = br2.readLine()) != null) 
	                        {
	                            URL = line2;
	                                System.out.println(line2);
				}	            
	                       br2.close();
	    
	    //Phase 3 connect to the url and scrape the stuff we need

  Document doc = Jsoup.connect(URL).timeout(1000 * 1000).get();
    
	   Elements tdgrabbers = doc.select("td");
	    for (Element tdgrabber : tdgrabbers)
	    {
	        //System.out.println("New TD: ");
	        //System.out.println(tdgrabber); 
	        TdHolder = tdgrabber.attr("data-label");
	       // System.out.println(holder);
	        if(TdHolder.equals(Checker))
	        {
	           //System.out.println("Success");
	           //System.out.println(TdHolder);
                    
                   //Trying to seperate everything inside of the td from just the url.
                    // Tdholder2 will be for just the url.
                   //ItemNameStopper will be for the item name.
	           TdHolder2 = tdgrabber.outerHtml();
                   ItemNameStopper = tdgrabber.text();
                   
                   Modifier = TdHolder2.replaceAll("<td data-label=\"Item No\"><a href=\"", "https://www.pcs-company.com");
                   TdHolder2 = Modifier.replaceAll("\">" , "");
                   Modifier = TdHolder2.replaceAll("</a></td>" , "");
                   ItemNameStopper2 = ItemNameStopper + "" + ItemNameStopper; 
                   System.out.println("ItemNameStopper2: " + ItemNameStopper2);
                   System.out.println("ItemNameStopper: " + ItemNameStopper);
                   
                   TdHolder2 = Modifier.replaceAll(ItemNameStopper, "");
                   System.out.println("TDHolder2: " + TdHolder2);
	           //System.out.println(TdHolder2);
	           TdHolderArray[TdHolderCounter] = TdHolder2;
               out.print(TdHolderArray[TdHolderCounter]);  
	      out.print("\n");  
	           System.out.println(TdHolderCounter);
	           System.out.println(TdHolderArray[TdHolderCounter]);
	           TdHolderCounter++; 
	        }
                	   //Flush the output to the file
	    out.flush(); 
	    //Close the Print Writer    
	    }  
            	    out.flush(); 
	    //Close the Print Writer
	   out.close();       
	   //Close the File Writer
	   fw.close();    
	           TdHolderCounter++;
	        }
	    }