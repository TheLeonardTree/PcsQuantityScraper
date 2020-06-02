package productpageleonardcms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ProductPageLeonardCMS 
{
    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException 
    {
       /* 
        Part 0: Define Variables
        Part 1: Import Data From CSV To String Arrays
        Part 2: Organize Pages By Category
        Part3: Import Title, Meta Description and Page Description For Pages
        Part 4: Start The Category Page Creating Loop
        Part 4A: Name the HTML Page
        Part 4B: Create The HTML Page By Using The Information Pulled From The CSV
        Part 4C: Print The HTML Page To A Folder
        Part 4D: Loop Through Every Page We Need To Make
        Part 5: Actually Write The Pages To Each File
        Part 6: Write The Sitemap.xml File
        Part 7: Making Category Category Pages
        */
        
       //Part 0: Define Variables
       int SubLoopCountHolder = 0;
       int subloopcount = 0;
       int FileNamePhase6Count = 1;
       String[] IdHolder = new String[999999];
       String[] ItemTitle = new String[999999];
       String[] FinalURL = new String[999999];
       String[] ItemCategory = new String[999999];
       String FileNameWithoutSpaces = "";
       String FileNameModifier = "";
       //for phase 2
       String[] ArrayCountCategoryNames = new String[99999];
       int[] ArrayCount = new int[99999];
       int[] ArrayItemCount = new int[99999]; 
       int ItemCatCheckerCount = 0;
       String CheckerString = "";
       String LastString = "";
       String CurrentString = "";
       //for phase3
       String[] CategoryHolder = new String[9999];
       String[] PTitleHolder = new String[9999];
       String[] MetaDescriptionHolder = new String[9999];
       String[] PageDescriptionHolder = new String[9999];
       int SubLoopCountHolder2 = 0;
       //for phase 4
       int filenamecounter = 0;
       String GimmeAName = "";
       //for phase 6
       File fileSitemap = new File("C:\\Users\\tremanleo\\Documents\\LeonardCMS\\LeonardCMSSiteMap.xml"); 

       //Part 1: Read The CSV To Get The Objects For Mass Page Creation Into String Arrays For Later Use
       File fileCMS = new File("C:\\Users\\tremanleo\\Documents\\LeonardCMS\\MakeMassPages.csv"); 
       BufferedReader brCMS = new BufferedReader(new FileReader(fileCMS));
       String Manipulator = "";      
      
	String line3;  
	while ((line3 = brCMS.readLine()) != null) 
            {         	
        String[] part = line3.split(",");
        String HolderPart0 = part[0];
        IdHolder[subloopcount] = part[0];
        
        String HolderPart1 = part[1];
        ItemTitle[subloopcount] = part[1];
        
        String HolderPart3 = part[2]; 
        FinalURL[subloopcount] = part[2];
        
        String HolderPart4 = part[3]; 
        ItemCategory[subloopcount] = part[3];
                   
             subloopcount++;
            }
        //Reset Stuff Incase I Need To Use Them Again
             SubLoopCountHolder = subloopcount;
             subloopcount = 0;
             brCMS.close();
        //Part 2: Organize Items By Category
        //We Use A Loop To Count Item Category Up, The CSV Must Be Arranged By Item Category Before Inputting Here
        //We Check Each String In The ItemCategory String Array Against The Next One.
        //If They Don't Match After The First Time (The First Time Starts With No Value), 
        //then they get marked false and the arraycount goes up by 1, the ArrayCountCategoryNames[]
        //logs the name of the category and the ArrayItemCount[] logs the subloop number at which the new category started.  
        //Example: The Item Changes Name On 1, 35, 46, 47, 72 in the ItemCategory[subloopcount] atm.
        //I probably should have just made a class for each of these or something tbh....
       while(subloopcount != SubLoopCountHolder)
       { 
          CurrentString = ItemCategory[subloopcount];   
          boolean isFound = CurrentString.contains(LastString); // true
          
          if(isFound == false)
          {
          //ArrayCount[] Counts The Number Of Categories    
          ArrayCount[ItemCatCheckerCount] = ItemCatCheckerCount;   
         // System.out.println("Array Count: "+ ArrayCount[ItemCatCheckerCount]);
          //ArrayCountCategoryNames[] Grabs The Name Of The Item Type So That It Can Be Pulled With The Count
          ArrayCountCategoryNames[ItemCatCheckerCount] = CurrentString;
          //System.out.println("Array Category: "+ ArrayCountCategoryNames[ItemCatCheckerCount]);
          //ArrayItemCount[] Counts The Item Number That Way We Know At What Number In The ItemCategory[subloopcount] That A New Category Occurs
          ArrayItemCount[ItemCatCheckerCount] = subloopcount; 
          //System.out.println("Array Item Count: "+ ArrayItemCount[ItemCatCheckerCount]);
          ItemCatCheckerCount++; 
          }
          LastString = CurrentString;
          subloopcount++;
       }
       subloopcount = 0;
       LastString = "";
       CurrentString = ""; 
    
    //Section For Printing Out CSV For Normal Stuff
   //FileWriter fw2 = new FileWriter("C:\\Users\\tremanleo\\Documents\\LeonardCMS\\fillthisout.csv");
   //PrintWriter out2 = new PrintWriter(fw2);  
 

     //  while(subloopcount != ItemCatCheckerCount)
    //{
      //   out2.print(ArrayCountCategoryNames[subloopcount]+ "\n");
      //System.out.println(ArrayCountCategoryNames[subloopcount]); 
        // out2.flush();        
      //subloopcount++;  
   //}
   //     //Close the Print Writer
   //out2.close();       
   //      //Close the File Writer
   //fw2.close();       
   
    //Part3: Import Title, Meta Description and Page Description For Pages Then Organize It So That It Can Be Used For Page Creation
    File fileCMS2 = new File("C:\\Users\\tremanleo\\Documents\\LeonardCMS\\fillthisout.csv"); 
       BufferedReader brCMS2 = new BufferedReader(new FileReader(fileCMS2));
       Manipulator = "";      
      
	String line4;  
	while ((line4 = brCMS2.readLine()) != null) 
            {         	
        String[] part = line4.split(",");
        String HolderPart0 = part[0];
        CategoryHolder[subloopcount] = part[0];        
        
        String HolderPart1 = part[1];
        PTitleHolder[subloopcount] = part[1];
        
        String HolderPart2 = part[2]; 
        MetaDescriptionHolder[subloopcount] = part[2];
        
        String HolderPart3 = part[3];
        PageDescriptionHolder[subloopcount] = part[3];
        
             subloopcount++;
            }
        //Reset Stuff Incase I Need To Use Them Again
             SubLoopCountHolder2 = subloopcount;
             subloopcount = 0;
             brCMS2.close();

    //Part 4-5 Name The File For The Category Page Creating Loop
    //Part 4, name the file something unique.

   
//part 5 actually write the pages to each file
   int counterthing = 0;
   int QuickAndDirtyFix = 0;
   String CategoryNameThing = "ArrayItemCount[ItemCatCheckerCount]";
   String PageTitleNameThing = "";
   String PageMetaDescriptionNameThing = "";
   String PageDescriptionNameThing = "";
   
    while(subloopcount != SubLoopCountHolder)
    {   
        if(subloopcount == 0)
        {
            subloopcount++;
            counterthing++;
                 File file = new File("C:\\Users\\tremanleo\\Documents\\LeonardCMS\\Counter.txt");
       BufferedReader br = new BufferedReader(new FileReader(file));

       String line5;
			while ((line5 = br.readLine()) != null) 
                        {
                                filenamecounter = Integer.parseInt(line5);                                                                                               
			}
                        br.close();  
    //Rename The Output File
    
    //Combine The Title With A Climbing Number Then Remove Spaces To Make The FileName
    FileNameWithoutSpaces = PTitleHolder[FileNamePhase6Count];
    FileNameModifier = FileNameWithoutSpaces.replaceAll(" ", "");
    FileNameWithoutSpaces = FileNameModifier.replaceAll("/", "");
    FileNamePhase6Count++;
    
              FileWriter fw = new FileWriter("C:\\Users\\tremanleo\\Documents\\LeonardCMS\\Counter.txt");
      PrintWriter out = new PrintWriter(fw); 
GimmeAName = ("C:\\Users\\tremanleo\\Documents\\LeonardCMS\\HtmlHolder\\" + FileNameWithoutSpaces + ".html");    
File f = new File(GimmeAName);
filenamecounter = filenamecounter + 1;
//Save The New Number
   out.print(filenamecounter);
   out.flush(); 
   //Close the Print Writer
   out.close();       
   //Close the File Writer
   fw.close();     
   
          CategoryNameThing = CategoryHolder[counterthing];
          //announce new page start to system
          PageTitleNameThing = PTitleHolder[counterthing];
          PageMetaDescriptionNameThing = MetaDescriptionHolder[counterthing];
          PageDescriptionNameThing = PageDescriptionHolder[counterthing]; 
             FileWriter fw2 = new FileWriter(GimmeAName);
            PrintWriter out2 = new PrintWriter(fw2);  
          out2.print("<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head><title>" + PageTitleNameThing +  "</title>\n" +
            "<meta name=\"description\" content=\"" + PageMetaDescriptionNameThing + "\">\n" +
            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "<link rel=\"manifest\" href=\"/superpwa-manifest.json\">\n" +
            "<meta name=\"theme-color\" content=\"#D5E0EB\">\n" +
            "<link rel=\"alternate\" hreflang=\"en\" href=\"" + GimmeAName + "/>\n" +
            "<link rel=\"icon\" href=\"https://www.dme.net/wp-content/uploads/2019/09/cropped-dme-icon2020-1-32x32.png\" sizes=\"32x32\" />\n" +
            "<link rel=\"icon\" href=\"https://www.dme.net/wp-content/uploads/2019/09/cropped-dme-icon2020-1-192x192.png\" sizes=\"192x192\" />\n" +
            "<link rel=\"apple-touch-icon-precomposed\" href=\"https://www.dme.net/wp-content/uploads/2019/09/cropped-dme-icon2020-1-180x180.png\" />\n" +
            "<style>\n" +
            ".fill {object-fit: fill;}\n" +
            ".bnavbar\n" +
            "{\n" +
            "background-color: black;	\n" +
            "width: 100%;\n" +
            "height: 50px;\n" +
            "display: inline-block;\n" +
            "color: white;\n" +
            "vertical-align: middle; \n" +
            "}\n" +
            ".bnavbar2\n" +
            "{\n" +
            "width: 20%;\n" +
            "background-color: black;	\n" +
            "height: 50px;\n" +
            "display: inline-block;\n" +
            "color: white;\n" +
            "vertical-align: middle; \n" +
            "}\n" +
            ".wnavbar\n" +
            "{\n" +
            "display: inline-block;\n" +
            "padding-top: 1%;\n" +
            "padding-right: 2.2%;\n" +
            "padding-left: 2.2%;\n" +
            "padding-bottom: 1%;\n" +
            "font-weight: 900;\n" +
            "margin: auto;\n" +
            "color: black;\n" +
            "font-size: 25px;\n" +
            "vertical-align: middle; \n" +
            "} \n" +
            "  .container\n" +
            "  {\n" +
            "  flex-flow: row wrap;\n" +
            "  display: flex; \n" +
            "  justify-content: space-around;  \n" +
            "  padding: 0;\n" +
            "  margin: 0;\n" +
            "  list-style: none;\n" +
            "  }\n" +
            "  .item\n" +
            "  {\n" +
            "  text-align: center;\n" +
            "  word-break: break-word;  \n" +
            "  padding: 20px;\n" +
            "  width: flex;\n" +
            "  height: 300px;\n" +
            "  margin-top: 0px;\n" +
            "  margin-bottom: 0px;\n" +
            "  line-height: 70px;\n" +
            "  font-weight: bold;\n" +
            "  font-size: .5 em;\n" +
            "  text-align: center;\n" +
            "  }  \n" +
            "  .back\n" +
            "  {\n" +
            "  padding: 20px;\n" +
            "  width: flex;\n" +
            "  height: 100px;\n" +
            "  line-height: 70px;\n" +
            "  font-weight: bold;\n" +
            "  font-size: .5 em;\n" +
            "  text-align: center;\n" +
            "  }\n" +
            ".contain {\n" +
            "object-fit: \n" +
            "contain; \n" +
            "flex-wrap: wrap;\n" +
            "align-content: center;\n" +
            "}\n" +
            "a:link {\n" +
            "color: #c50d16;\n" +
            "font-weight: 600;\n" +
            "text-decoration: none;\n" +
            "}\n" +
            "a:visited {\n" +
            "color: #c50d16;\n" +
            "font-weight: 600;\n" +
            "text-decoration: none;\n" +
            "}\n" +
            "a:hover {\n" +
            "color: #c50d16;\n" +
            "font-weight: 600;\n" +
            "text-decoration: none;\n" +
            "}\n" +
            "a:active {\n" +
            "color: #c50d16;\n" +
            "font-weight: 600;\n" +
            "text-decoration: none;\n" +
            "}\n" +
            "h1{color: #c50d16;}\n" +
            "h2{\n" +
            "text-align: center;\n" +
            "color: #c50d16;\n" +
            "}\n" +
            "h3{\n" +
            "color: #black;\n" +
            "text-align: center;\n" +
            "padding-right: 5%;\n" +
            "padding-left: 5%;\n" +
            "}\n" +
            "h5{color: #000000; font-family:'Poppins';}\n" +
            "h4{color: #FFFF; vertical-align: middle;}\n" +
            "p{color: #c50d16;}\n" +
            ".container2\n" +
            "{\n" +
            "  padding-top: 2.5%;	\n" +
            "  padding-right: 5%;\n" +
            "  padding-bottom: 2.5%;\n" +
            "  padding-left: 5%;	\n" +
            "}\n" +
            ".holditall\n" +
            "#grad {\n" +
            "background-image: linear-gradient(to bottom, #d3d3d3, white);\n" +
            "width: 100%;\n" +
            "height: 40px;\n" +
            "}"+
            "{\n" +
            "#grad2 {\n" +
            "background-image: linear-gradient(to top, #d3d3d3, white);\n" +
            "width: 100%;\n" +
            "height: 40px;\n" +
            "}"+
            "flex: 1;\n" +
            "\n" +
            "  display: flex;\n" +
            "  justify-content: center;\n" +
            "  flex-direction: column;\n" +
            "}\n" +
            "#grad {\n" +
            "  background-image: linear-gradient(to bottom, #d3d3d3, white);\n" +
            "  width: 100%;\n" +
            "  height: 40px;\n" +
            "}\n" +
            "#grad2 {\n" +
            "  background-image: linear-gradient(to top, #d3d3d3, white);\n" +
            "  width: 100%;\n" +
            "  height: 40px;\n" +
            "}\n" +
            "* {\n" +
            "  margin: 0;\n" +
            "  padding: 0;\n" +
            "}\n" +
            ".fill {object-fit: fill;}\n" +
            "img\n" +
            "{\n" +
            "vertical-align: middle;\n" +
            "        text-align: center;\n" +
            "        display: block;\n" +
            "}\n" +
            ".row {\n" +
            "  display: flex; /* equal height of the children */\n" +
            "  padding-right: 2.5%;\n" +
            "  padding-left: 2.5%;	\n" +
            "}\n" +
            ".col {\n" +
            "  flex: 1; /* additionally, equal width */  \n" +
            "  border: solid;\n" +
            "}\n" +
            ".col2 {\n" +
            "  flex: 1; /* additionally, equal width */  \n" +
            "  border: solid;\n" +
            "}\n" +
            ".contain {object-fit: contain;}\n" +
            ".colore\n" +
            "{\n" +
            "  font-size: 18px;\n" +
            "  color:\"black\";\n" +
            "  padding-top: 20px;\n" +
            "  padding-right: 25%;\n" +
            "  padding-left: 25%;	\n" +
            "}\n" +
            "@media (max-width: 5000px) \n" +
            "{\n" +
            "	.hideformobilebnav\n" +
            "	{\n" +
            "width: 20%;\n" +
            "background-color: black;	\n" +
            "height: 50px;\n" +
            "display: inline-block;\n" +
            "color: white;\n" +
            "vertical-align: middle; \n" +
            "	}\n" +
            "}\n" +
            "\n" +
            "@media (max-width: 750px) \n" +
            "{\n" +
            "	img \n" +
            "	{\n" +
            "	width: 40%;\n" +
            "	height: 40%;\n" +
            "	}\n" +
            "	.container2\n" +
            "	{\n" +
            "	  padding-top: 0%;	\n" +
            "	  padding-right: 0%;\n" +
            "	  padding-bottom: 0%;\n" +
            "	  padding-left: 0;	\n" +
            "	}\n" +
            "	.col {\n" +
            "	  flex: 1; /* additionally, equal width */  \n" +
            "	  border: solid;\n" +
            "	  width: 20%;\n" +
            "		font-size: 12px;\n" +
            "	}\n" +
            "	.col2 {\n" +
            "	  flex: 1; /* additionally, equal width */  \n" +
            "	  border: solid;\n" +
            "	  width: 15%;\n" +
            "		font-size: 12px;\n" +
            "		display: none;\n" +
            "	}\n" +
            "	h2{\n" +
            "	font-size: 12px;\n" +
            "	\n" +
            "	}\n" +
            "	.hideformobilebnav\n" +
            "	{\n" +
            "		width: 20%;\n" +
            "		background-color: black;	\n" +
            "		height: 50px;\n" +
            "		display: none;\n" +
            "		color: white;\n" +
            "		vertical-align: middle; \n" +
            "	}\n" +
            "	.bnavbar2\n" +
            "	{\n" +
            "	width: 33.33%;\n" +
            "	}\n" +
            "	.colore\n" +
            "	{\n" +
            "	  font-size: 12px;\n" +
            "	  color: black;\n" +
            "	  color: black;\n" +
            "	  padding-top: 2.5px;\n" +
            "	  padding-right: 2.5%;\n" +
            "	  padding-left: 2.5%;	\n" +
            "	  padding-bottom: 2.5px;\n" +
            "	}\n" +
            "}\n" +
            "</style>\n" +
            "</head>\n" +
            "<body>\n" +
            "<div class=\"bnavbar\">&nbsp;</div>\n" +
            "<div class=\"wnavbar\" width=\"10%\"><a href=\"https://www.dme.net/\" title=\"homepage\"><img src=\"https://www.dme.net/wp-content/uploads/2019/09/DME-Logo_Black-R.png\" width=\"277px\" height=\"52px\" alt=\"logo\"></a></div> <div width=\"10%\" class=\"wnavbar\"> <a href=\"https://www.dme.net/\" title=\"homepage\"><h5>HOME</h5></a> </div><div width=\"10%\" class=\"wnavbar\"> <a href=\"https://www.dme.net/products/\" alt=\"Products Page\"><h5> PRODUCTS</h5></a> </div><div width=\"10%\" class=\"wnavbar\"><h5> SOLUTIONS</h5></div><div width=\"10%\" class=\"wnavbar\"> <a href=\"https://www.dme.net/support/\" alt=\"Support\"><h5>SUPPORT</h5></a> </div><div width=\"10%\" class=\"wnavbar\"> <a href=\"https://www.dme.net/company/\"> <h5>COMPANY</h5></a></div><div class=\"wnavbar\"> <a href=\"https://store.milacron.com/naconfiguratorlist\"><h5>CONFIGURATORS</h5> </a></div><div class=\"wnavbar\"><a href=\"https://store.milacron.com/shop-parts?breadCrumFullItem=94\" title=\"EStore\" alt=\"Estore\"><img src=\"https://www.dme.net/wp-content/uploads/2020/02/shop-estore-button.png\" width=\"177px\" height=\"60px\" title=\"eStore\" alt=\"shop eStore\"></a></div>\n" +
            "<div id=\"grad\" width=\"100%\"></div>" +
            "<br>\n" +
            "<center><h2>" + PageTitleNameThing + " With The Buy Now Button Next To The Model You Want</h2></center>\n" +
            "<br>\n" +
            "<h3>" + PageDescriptionNameThing + "</h3>" +
            "<center>" +
            "<div class=\"container2\">" +
            "<div class=\"row\">" +
            "<div class=\"col\"><b>Description</b></div>" +
            "<div class=\"col\"><b>Part Number</b></div>" +
            "<div class=\"col\"><b>Shop Now</b></div>" +
            "</div>");  
            out2.flush(); 
        }
        if(subloopcount == ArrayItemCount[counterthing])
        {
          //This section here needs to end the previous page, as pages are divided by categories.
            FileWriter fw2 = new FileWriter(GimmeAName, true);
            PrintWriter out2 = new PrintWriter(fw2);  
             out2.print("<div class=\"row\"><div class=\"col\"><center><a href=\"https://www.dme.net/main-categories.php\">Back</a></center></div> \n" + 
               "</div> \n" + "\n" +
                "</div> \n" + 
                "</center> \n " + 
                "<div id=\"grad2\" width=\"100%\"></div>"+
                "<div class=\"bnavbar\">&nbsp;</div> \n" +
                "<div class=\"bnavbar2\"><center><a href=\"https://www.dme.net/digital-privacy-policy/\"><h4>Privacy Policy</h4></a></center></div><div class=\"bnavbar2\"><a href=\"https://www.dme.net/terms-of-sale-returns/\"><h4>Terms Of Use</h4></a></div><div class=\"hideformobilebnav\">&nbsp;</div><div class=\"hideformobilebnav\">&nbsp;</div><div class=\"bnavbar2\"><h4>© 2020 DME Company</h4></div> \n " +
                 "<div class=\"bnavbar\">&nbsp;</div>" + "\n" +
                "<script async src=\"https://www.googletagmanager.com/gtag/js?id=UA-153770781-1\"></script> \n" +
                "<script>\n" +
                "window.dataLayer = window.dataLayer || []; \n" +
                "function gtag(){dataLayer.push(arguments);} \n " + 
                "gtag('js', new Date());\n" +
                "gtag('config', 'UA-153770781-1');\n" + 
                "</script>\n" + "\n" +
                "<script>\n" + "\n" +
                "if('serviceWorker' in navigator) {\"navigator.serviceWorker" + "\n" +
                ".register('/superpwa-sw.js')\n" +
                ".then(function() { console.log(\"Service Worker Registered\"); });" +
                "}" + "\n" +
                "</script></body></html>");
            out2.flush(); 
            //Close the Print Writer
            out2.close();       
            //Close the File Writer
            fw2.close();    
          //This section checks the item number, if it is the appropreate number it will change the category. 
          //This Part Sets The Variables For The New Page.
          CategoryNameThing = ArrayCountCategoryNames[counterthing];
          //announce new page start to system
          PageTitleNameThing = PTitleHolder[counterthing];
          PageMetaDescriptionNameThing = MetaDescriptionHolder[counterthing];
          PageDescriptionNameThing = PageDescriptionHolder[counterthing];          
                  
          //This section needs to write the start of the page.
                                    File file = new File("C:\\Users\\tremanleo\\Documents\\LeonardCMS\\Counter.txt");
                          BufferedReader br = new BufferedReader(new FileReader(file));

                          String line5;
                                           while ((line5 = br.readLine()) != null) 
                                           {
                                                   filenamecounter = Integer.parseInt(line5);                                                                                               
                                           }
                                           br.close();  
                       //Rename The Output File
                                                //Combine The Title With A Climbing Number Then Remove Spaces To Make The FileName
                                                
    FileNameWithoutSpaces = PTitleHolder[FileNamePhase6Count];
    FileNameModifier = FileNameWithoutSpaces.replaceAll(" ", "");
    FileNameWithoutSpaces = FileNameModifier.replaceAll("/", "");
    FileNamePhase6Count++;
                         FileWriter fw = new FileWriter("C:\\Users\\tremanleo\\Documents\\LeonardCMS\\Counter.txt");
                         PrintWriter out = new PrintWriter(fw);

                   GimmeAName = ("C:\\Users\\tremanleo\\Documents\\LeonardCMS\\HtmlHolder\\" + FileNameWithoutSpaces + ".html");  
                   File f = new File(GimmeAName);
                   filenamecounter = filenamecounter + 1;
                   //Save The New Number
                      out.print(filenamecounter);
                      out.flush(); 
                      //Close the Print Writer
                      out.close();       
                      //Close the File Writer
                      fw.close();  
                      QuickAndDirtyFix = counterthing + 1 ;
                      PageTitleNameThing = PTitleHolder[QuickAndDirtyFix];
          PageMetaDescriptionNameThing = MetaDescriptionHolder[QuickAndDirtyFix];
          PageDescriptionNameThing = PageDescriptionHolder[QuickAndDirtyFix]; 
            fw2 = new FileWriter(GimmeAName);
            out2 = new PrintWriter(fw2);          
          out2.print("<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head><title>" + PageTitleNameThing +  "</title>\n" +
            "<meta name=\"description\" content=\"" + PageMetaDescriptionNameThing + "\">\n" +
            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "<link rel=\"manifest\" href=\"/superpwa-manifest.json\">\n" +
            "<meta name=\"theme-color\" content=\"#D5E0EB\">\n" +
            "<link rel=\"alternate\" hreflang=\"en\" href=\"" + GimmeAName + "/>\n" +
            "<link rel=\"icon\" href=\"https://www.dme.net/wp-content/uploads/2019/09/cropped-dme-icon2020-1-32x32.png\" sizes=\"32x32\" />\n" +
            "<link rel=\"icon\" href=\"https://www.dme.net/wp-content/uploads/2019/09/cropped-dme-icon2020-1-192x192.png\" sizes=\"192x192\" />\n" +
            "<link rel=\"apple-touch-icon-precomposed\" href=\"https://www.dme.net/wp-content/uploads/2019/09/cropped-dme-icon2020-1-180x180.png\" />\n" +
            "<style>\n" +
            ".fill {object-fit: fill;}\n" +
            ".bnavbar\n" +
            "{\n" +
            "background-color: black;	\n" +
            "width: 100%;\n" +
            "height: 50px;\n" +
            "display: inline-block;\n" +
            "color: white;\n" +
            "vertical-align: middle; \n" +
            "}\n" +
            ".bnavbar2\n" +
            "{\n" +
            "width: 20%;\n" +
            "background-color: black;	\n" +
            "height: 50px;\n" +
            "display: inline-block;\n" +
            "color: white;\n" +
            "vertical-align: middle; \n" +
            "}\n" +
            ".wnavbar\n" +
            "{\n" +
            "display: inline-block;\n" +
            "padding-top: 1%;\n" +
            "padding-right: 2.2%;\n" +
            "padding-left: 2.2%;\n" +
            "padding-bottom: 1%;\n" +
            "font-weight: 900;\n" +
            "margin: auto;\n" +
            "color: black;\n" +
            "font-size: 25px;\n" +
            "vertical-align: middle; \n" +
            "} \n" +
            "  .container\n" +
            "  {\n" +
            "  flex-flow: row wrap;\n" +
            "  display: flex; \n" +
            "  justify-content: space-around;  \n" +
            "  padding: 0;\n" +
            "  margin: 0;\n" +
            "  list-style: none;\n" +
            "  }\n" +
            "  .item\n" +
            "  {\n" +
            "  text-align: center;\n" +
            "  word-break: break-word;  \n" +
            "  padding: 20px;\n" +
            "  width: flex;\n" +
            "  height: 300px;\n" +
            "  margin-top: 0px;\n" +
            "  margin-bottom: 0px;\n" +
            "  line-height: 70px;\n" +
            "  font-weight: bold;\n" +
            "  font-size: .5 em;\n" +
            "  text-align: center;\n" +
            "  }  \n" +
            "  .back\n" +
            "  {\n" +
            "  padding: 20px;\n" +
            "  width: flex;\n" +
            "  height: 100px;\n" +
            "  line-height: 70px;\n" +
            "  font-weight: bold;\n" +
            "  font-size: .5 em;\n" +
            "  text-align: center;\n" +
            "  }\n" +
            ".contain {\n" +
            "object-fit: \n" +
            "contain; \n" +
            "flex-wrap: wrap;\n" +
            "align-content: center;\n" +
            "}\n" +
            "a:link {\n" +
            "color: #c50d16;\n" +
            "font-weight: 600;\n" +
            "text-decoration: none;\n" +
            "}\n" +
            "a:visited {\n" +
            "color: #c50d16;\n" +
            "font-weight: 600;\n" +
            "text-decoration: none;\n" +
            "}\n" +
            "a:hover {\n" +
            "color: #c50d16;\n" +
            "font-weight: 600;\n" +
            "text-decoration: none;\n" +
            "}\n" +
            "a:active {\n" +
            "color: #c50d16;\n" +
            "font-weight: 600;\n" +
            "text-decoration: none;\n" +
            "}\n" +
            "h1{color: #c50d16;}\n" +
            "h2{\n" +
            "text-align: center;\n" +
            "color: #c50d16;\n" +
            "}\n" +
            "h3{\n" +
            "color: #black;\n" +
            "text-align: center;\n" +
            "padding-right: 5%;\n" +
            "padding-left: 5%;\n" +
            "}\n" +
            "h5{color: #000000; font-family:'Poppins';}\n" +
            "h4{color: #FFFF; vertical-align: middle;}\n" +
            "p{color: #c50d16;}\n" +
            ".container2\n" +
            "{\n" +
            "  padding-top: 2.5%;	\n" +
            "  padding-right: 5%;\n" +
            "  padding-bottom: 2.5%;\n" +
            "  padding-left: 5%;	\n" +
            "}\n" +
            ".holditall\n" +
            "{\n" +
            "flex: 1;\n" +
            "\n" +
            "  display: flex;\n" +
            "  justify-content: center;\n" +
            "  flex-direction: column;\n" +
            "}\n" +
            "#grad {\n" +
            "  background-image: linear-gradient(to bottom, #d3d3d3, white);\n" +
            "  width: 100%;\n" +
            "  height: 40px;\n" +
            "}\n" +
            "#grad2 {\n" +
            "  background-image: linear-gradient(to top, #d3d3d3, white);\n" +
            "  width: 100%;\n" +
            "  height: 40px;\n" +
            "}\n" +
            "* {\n" +
            "  margin: 0;\n" +
            "  padding: 0;\n" +
            "}\n" +
            ".fill {object-fit: fill;}\n" +
            "img\n" +
            "{\n" +
            "vertical-align: middle;\n" +
            "        text-align: center;\n" +
            "        display: block;\n" +
            "}\n" +
            ".row {\n" +
            "  display: flex; /* equal height of the children */\n" +
            "  padding-right: 2.5%;\n" +
            "  padding-left: 2.5%;	\n" +
            "}\n" +
            ".col {\n" +
            "  flex: 1; /* additionally, equal width */  \n" +
            "  border: solid;\n" +
            "}\n" +
            ".col2 {\n" +
            "  flex: 1; /* additionally, equal width */  \n" +
            "  border: solid;\n" +
            "}\n" +
            ".contain {object-fit: contain;}\n" +
            ".colore\n" +
            "{\n" +
            "  font-size: 18px;\n" +
            "  color:\"black\";\n" +
            "  padding-top: 20px;\n" +
            "  padding-right: 25%;\n" +
            "  padding-left: 25%;	\n" +
            "}\n" +
            "@media (max-width: 5000px) \n" +
            "{\n" +
            "	.hideformobilebnav\n" +
            "	{\n" +
            "width: 20%;\n" +
            "background-color: black;	\n" +
            "height: 50px;\n" +
            "display: inline-block;\n" +
            "color: white;\n" +
            "vertical-align: middle; \n" +
            "	}\n" +
            "}\n" +
            "\n" +
            "@media (max-width: 750px) \n" +
            "{\n" +
            "	img \n" +
            "	{\n" +
            "	width: 40%;\n" +
            "	height: 40%;\n" +
            "	}\n" +
            "	.container2\n" +
            "	{\n" +
            "	  padding-top: 0%;	\n" +
            "	  padding-right: 0%;\n" +
            "	  padding-bottom: 0%;\n" +
            "	  padding-left: 0;	\n" +
            "	}\n" +
            "	.col {\n" +
            "	  flex: 1; /* additionally, equal width */  \n" +
            "	  border: solid;\n" +
            "	  width: 20%;\n" +
            "		font-size: 12px;\n" +
            "	}\n" +
            "	.col2 {\n" +
            "	  flex: 1; /* additionally, equal width */  \n" +
            "	  border: solid;\n" +
            "	  width: 15%;\n" +
            "		font-size: 12px;\n" +
            "		display: none;\n" +
            "	}\n" +
            "	h2{\n" +
            "	font-size: 12px;\n" +
            "	\n" +
            "	}\n" +
            "	.hideformobilebnav\n" +
            "	{\n" +
            "		width: 20%;\n" +
            "		background-color: black;	\n" +
            "		height: 50px;\n" +
            "		display: none;\n" +
            "		color: white;\n" +
            "		vertical-align: middle; \n" +
            "	}\n" +
            "#grad {\n" +
            "background-image: linear-gradient(to bottom, #d3d3d3, white);\n" +
            "width: 100%;\n" +
            "height: 40px;\n" +
            "}"+
            "{\n" +
            "#grad2 {\n" +
            "background-image: linear-gradient(to top, #d3d3d3, white);\n" +
            "width: 100%;\n" +
            "height: 40px;\n" +
            "}"+
            "	.bnavbar2\n" +
            "	{\n" +
            "	width: 33.33%;\n" +
            "	}\n" +
            "	.colore\n" +
            "	{\n" +
            "	  font-size: 12px;\n" +
            "	  color: black;\n" +
            "	  color: black;\n" +
            "	  padding-top: 2.5px;\n" +
            "	  padding-right: 2.5%;\n" +
            "	  padding-left: 2.5%;	\n" +
            "	  padding-bottom: 2.5px;\n" +
            "	}\n" +
            "}\n" +
            "</style>\n" +
            "</head>\n" +
            "<body>\n" +
            "<div class=\"bnavbar\">&nbsp;</div>\n" +
            "<div class=\"wnavbar\" width=\"10%\"><a href=\"https://www.dme.net/\" title=\"homepage\"><img src=\"https://www.dme.net/wp-content/uploads/2019/09/DME-Logo_Black-R.png\" width=\"277px\" height=\"52px\" alt=\"logo\"></a></div> <div width=\"10%\" class=\"wnavbar\"> <a href=\"https://www.dme.net/\" title=\"homepage\"><h5>HOME</h5></a> </div><div width=\"10%\" class=\"wnavbar\"> <a href=\"https://www.dme.net/products/\" alt=\"Products Page\"><h5> PRODUCTS</h5></a> </div><div width=\"10%\" class=\"wnavbar\"><h5> SOLUTIONS</h5></div><div width=\"10%\" class=\"wnavbar\"> <a href=\"https://www.dme.net/support/\" alt=\"Support\"><h5>SUPPORT</h5></a> </div><div width=\"10%\" class=\"wnavbar\"> <a href=\"https://www.dme.net/company/\"> <h5>COMPANY</h5></a></div><div class=\"wnavbar\"> <a href=\"https://store.milacron.com/naconfiguratorlist\"><h5>CONFIGURATORS</h5> </a></div><div class=\"wnavbar\"><a href=\"https://store.milacron.com/shop-parts?breadCrumFullItem=94\" title=\"EStore\" alt=\"Estore\"><img src=\"https://www.dme.net/wp-content/uploads/2020/02/shop-estore-button.png\" width=\"177px\" height=\"60px\" title=\"eStore\" alt=\"shop eStore\"></a></div>\n" +
            "<div id=\"grad\" width=\"100%\"></div>" +
            "<br>\n" +
            "<center><h2>" + PageTitleNameThing + " With The Buy Now Button Next To The Model You Want</h2></center>" +
            "<br>" +
            "<h3>" + PageDescriptionNameThing + "</h3>" +
            "<center>" +
            "<div class=\"container2\">" +
            "<div class=\"row\">" +
            "<div class=\"col\"><b>Description</b></div>" +
            "<div class=\"col\"><b>Part Number</b></div>" +
            "<div class=\"col\"><b>Shop Now</b></div>" +
            "</div>");   
         out2.flush(); 
          counterthing++;  
        }
                     FileWriter fw2 = new FileWriter(GimmeAName, true);
            PrintWriter out2 = new PrintWriter(fw2);  
        out2.print("<div class=\"row\"><div class=\"col\">" + ItemTitle[subloopcount] + "</div><div class=\"col\">" + IdHolder[subloopcount] + "</div><div class=\"col\"><a title=\"" + IdHolder[subloopcount] +"\" href=\"" + FinalURL[subloopcount] + "\">Buy The " + IdHolder[subloopcount] + " Now</a></div>\n" +
"</div>\n");
      out2.flush(); 
      subloopcount++;  
      if(subloopcount == SubLoopCountHolder)
      {
            fw2 = new FileWriter(GimmeAName, true);
            out2 = new PrintWriter(fw2);  
             out2.print("<div class=\"row\"><div class=\"col\"><center><a href=\"https://www.dme.net/main-categories.php\">Back</a></center></div> \n" + 
                "</div> \n" + "\n" +
                "</div> \n" + 
                "</center> \n " + 
                "<div id=\"grad2\" width=\"100%\"></div>"+
                "<div class=\"bnavbar\">&nbsp;</div> \n" +
                "<div class=\"bnavbar2\"><center><a href=\"https://www.dme.net/digital-privacy-policy/\"><h4>Privacy Policy</h4></a></center></div><div class=\"bnavbar2\"><a href=\"https://www.dme.net/terms-of-sale-returns/\"><h4>Terms Of Use</h4></a></div><div class=\"hideformobilebnav\">&nbsp;</div><div class=\"hideformobilebnav\">&nbsp;</div><div class=\"bnavbar2\"><h4>© 2020 DME Company</h4></div> \n " +
                 "<div class=\"bnavbar\">&nbsp;</div>" + "\n" +
                "<script async src=\"https://www.googletagmanager.com/gtag/js?id=UA-153770781-1\"></script> \n" +
                "<script>\n" +
                "window.dataLayer = window.dataLayer || []; \n" +
                "function gtag(){dataLayer.push(arguments);} \n " + 
                "gtag('js', new Date());\n" +
                "gtag('config', 'UA-153770781-1');\n" + 
                "</script>\n" + "\n" +
                "<script>\n" + "\n" +
                "if('serviceWorker' in navigator) {\"navigator.serviceWorker" + "\n" +
                ".register('/superpwa-sw.js')\n" +
                ".then(function() { console.log(\"Service Worker Registered\"); });" +
                "}" + "\n" +
                "</script></body></html>");
            out2.flush(); 
            //Close the Print Writer
            out2.close();       
            //Close the File Writer
            fw2.close();      
      }
    }
subloopcount = 0;    
//Part 6 Create the sitemap.xml file
       FileWriter fw5 = new FileWriter(fileSitemap);
       PrintWriter out5 = new PrintWriter(fw5);    
       
       out5.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?><?xml-stylesheet type=\"text/xsl\" href=\"//www.dme.net/wp-content/plugins/wordpress-seo/css/main-sitemap.xsl\"?>\n" +
"<urlset xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:image=\"http://www.google.com/schemas/sitemap-image/1.1\" xsi:schemaLocation=\"http://www.sitemaps.org/schemas/sitemap/0.9 http://www.sitemaps.org/schemas/sitemap/0.9/sitemap.xsd http://www.google.com/schemas/sitemap-image/1.1 http://www.google.com/schemas/sitemap-image/1.1/sitemap-image.xsd\" xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">");
       out5.flush(); 
       FileNamePhase6Count = 1;
       while(subloopcount != ItemCatCheckerCount)
       {

    FileNameWithoutSpaces = PTitleHolder[FileNamePhase6Count];
    FileNameModifier = FileNameWithoutSpaces.replaceAll(" ", "");
    FileNameWithoutSpaces = FileNameModifier.replaceAll("/", "");
         out5.print("	<url>\n" +
                "<loc>" + FileNameWithoutSpaces + ".html</loc>\n" +
                "</url>");
         FileNamePhase6Count++;
         out5.flush();
         subloopcount++;  
       }
       subloopcount = 0;       
       out5.print("</urlset>\n");
       out5.flush(); 
       out5.close();       
       fw5.close();        
       //Part 7: Making Category Category Pages
       //I need to split this into groups. I can use string confirmation to do this.
    }  
}