package classscraping;

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
import javax.swing.JOptionPane;
import java.io.*;  
import javax.swing.JFrame;

public class ClassScraping 
{
public static void main(String[] args) throws IOException {
        
     //Phase 0 Variables:   
     String URL = "https://www.pcs-company.com/years";
     String Checker = "Item No";
     String Checker2 = "Price(USD)";
     String TdHolder = "";
     String TdHolder2 = "";
     String[] TdHolderArray = new String[99999];
     int TdHolderCounter = 0;
     
     String holder2 = "";
     String holder2A = "";
     String[] SpanHolderArray = new String[99999];
     int SpanHolderCounter = 0;
     
    Document doc = Jsoup.connect(URL).timeout(1000 * 1000).get();
    Elements spangrabbers = doc.getElementsByClass("price actual-price");
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
           TdHolder2 = tdgrabber.text();
           //System.out.println(TdHolder2);
           TdHolderArray[TdHolderCounter] = TdHolder2;
           System.out.println(TdHolderCounter);
           System.out.println(TdHolderArray[TdHolderCounter]);
           TdHolderCounter++;
        }
    }  

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
}
}
