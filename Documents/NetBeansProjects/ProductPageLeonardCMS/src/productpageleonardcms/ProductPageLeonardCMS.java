package productpageleonardcms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

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
        */
        
       //Part 0: Define Variables
       int SubLoopCountHolder = 0;
       int subloopcount = 0;
       String[] IdHolder = new String[999999];
       String[] ItemTitle = new String[999999];
       String[] FinalURL = new String[999999];
       String[] ItemCategory = new String[999999];
       //for phase 2
       String[] ArrayCountCategoryNames = new String[99999];
       int[] ArrayCount = new int[99999];
       int[] ArrayItemCount = new int[99999]; 
       int ItemCatCheckerCount = 0;
       String CheckerString = "";
       String LastString = "";
       String CurrentString = "";
       //forphase3
       String[] PTitleHolder = new String[9999];
       String[] MetaDescriptionHolder = new String[9999];
       String[] PageDescriptionHolder = new String[9999];
       int SubLoopCountHolder2 = 0;

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
                
            IdHolder[subloopcount] = line3;     
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
          
          //ArrayCountCategoryNames[] Grabs The Name Of The Item Type So That It Can Be Pulled With The Count
          ArrayCountCategoryNames[ItemCatCheckerCount] = CurrentString;
          
          //ArrayItemCount[] Counts The Item Number That Way We Know At What Number In The ItemCategory[subloopcount] That A New Category Occurs
          ArrayItemCount[ItemCatCheckerCount] = subloopcount; 
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
        
        String HolderPart1 = part[1];
        PTitleHolder[subloopcount] = part[1];
        System.out.println(HolderPart1);
        
        String HolderPart2 = part[2]; 
        MetaDescriptionHolder[subloopcount] = part[2];
        System.out.println(HolderPart2);
        
        String HolderPart3 = part[3];
        PageDescriptionHolder[subloopcount] = part[3];
        System.out.println(HolderPart3);
        
             subloopcount++;
            }
        //Reset Stuff Incase I Need To Use Them Again
             SubLoopCountHolder2 = subloopcount;
             subloopcount = 0;
             brCMS2.close();

    //Part 4 Start The Category Page Creating Loop
    while(subloopcount != ItemCatCheckerCount)
    {
        
        
      subloopcount++;  
    }
//Test Section For Making HTML File So I Don't Break Everything
//This Will Be Put Into The Loop In Part 4 Later
   FileWriter fw2 = new FileWriter("C:\\Users\\tremanleo\\Documents\\LeonardCMS\\test.html");
   PrintWriter out2 = new PrintWriter(fw2);  

   out2.print("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"<head><title>Premium Gate Cutters</title>\n" +
"<meta name=\"description\" content=\"Buy Premium Gate Cutters &amp; Trimmers From DME. We Have Discounts For Bulk Purchases. Choose From 7 Blade Shapes, 10 Lengths. Made Of High Carbon Steel!\">\n" +
"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"<link rel=\"manifest\" href=\"/superpwa-manifest.json\">\n" +
"<meta name=\"theme-color\" content=\"#D5E0EB\">\n" +
"<link rel=\"alternate\" hreflang=\"en\" href=\"https://www.dme.net/Premium-Gate-Cutters.php\" />\n" +
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
"<br>\n" +
"<center><h2>Purchase Premium Gate Cutters With The Buy Now Button Next To The Model You Want</h2></center>\n" +
"<br>\n" +
"<h3>DME Premium Gate Cutters are made from premium steel and have a sharper blade for a high performance cut. Available with several blade characteristics.</h3>\n" +
"<center>\n" +
"<div class=\"container2\">\n" +
"<div class=\"row\">\n" +
"<div class=\"col\"><b>Description</b></div>\n" +
"<div class=\"col\"><b>Part Number</b></div>\n" +
"<div class=\"col\"><b>Shop Now</b></div>\n" +
"</div>\n" +
"<div class=\"row\"><div class=\"col\">GATE CUTTER FLAT FACE PREMIUM 4.625 OAL .687 BLADE</div><div class=\"col\">FF4 </div><div class=\"col\"><a title=\"FF4 \" href=\"https://store.milacron.com/item-detail?itemId=399314&organizationId=2&itemCategory=1220&searchString=&searchType=\">Buy Now</a></div>\n" +
"</div>\n" +
"<div class=\"row\"><div class=\"col\">GATE CUTTER FLAT FACE PREMIUM 5\" OAL .75 BLADE</div><div class=\"col\">FF5 </div><div class=\"col\"><a title=\"FF5 \" href=\"https://store.milacron.com/item-detail?itemId=399315&organizationId=2&itemCategory=1220&searchString=&searchType=\">Buy Now</a></div>\n" +
"</div>\n" +
"<div class=\"row\"><div class=\"col\">GATE CUTTER FLAT FACE PREMIUM 6.125 OAL .812 BLADE</div><div class=\"col\">FF6 </div><div class=\"col\"><a title=\"FF6 \" href=\"https://store.milacron.com/item-detail?itemId=399316&organizationId=2&itemCategory=1220&searchString=&searchType=\">Buy Now</a></div>\n" +
"</div>\n" +
"<div class=\"row\"><div class=\"col\">GATE CUTTER FLAT FACE PREMIUM ERGONOMIC 6.125 OAL .875 BLADE</div><div class=\"col\">FF6EL </div><div class=\"col\"><a title=\"FF6EL \" href=\"https://store.milacron.com/item-detail?itemId=399317&organizationId=2&itemCategory=1220&searchString=&searchType=\">Buy Now</a></div>\n" +
"</div>\n" +
"<div class=\"row\"><div class=\"col\">GATE CUTTER FLAT FACE PREMIUM ERGONOMIC 6.125 OAL .875 BLADE</div><div class=\"col\">FF6ER </div><div class=\"col\"><a title=\"FF6ER \" href=\"https://store.milacron.com/item-detail?itemId=399318&organizationId=2&itemCategory=1220&searchString=&searchType=\">Buy Now</a></div>\n" +
"</div>\n" +
"<div class=\"row\"><div class=\"col\">GATE CUTTER FLAT FACE PREMIUM W/ STOP PIN 6\" OAL .75 BLADE</div><div class=\"col\">FF6P </div><div class=\"col\"><a title=\"FF6P \" href=\"https://store.milacron.com/item-detail?itemId=399319&organizationId=2\">Buy Now</a></div>\n" +
"</div>\n" +
"<div class=\"row\"><div class=\"col\">GATE CUTTER FLAT FACE PREMIUM 7.50 OAL 1\" BLADE</div><div class=\"col\">FF7 </div><div class=\"col\"><a title=\"FF7 \" href=\"https://store.milacron.com/item-detail?itemId=399320&organizationId=2\">Buy Now</a></div>\n" +
"</div>\n" +
"<div class=\"row\"><div class=\"col\">GATE CUTTER FLAT FACE PREMIUM ERGONOMIC 7.50 OAL 1.062 BLADE</div><div class=\"col\">FF7EL </div><div class=\"col\"><a title=\"FF7EL \" href=\"https://store.milacron.com/item-detail?itemId=399321&organizationId=2\">Buy Now</a></div>\n" +
"</div>\n" +
"<div class=\"row\"><div class=\"col\">GATE CUTTER FLAT FACE PREMIUM ERGONOMIC 7.50 OAL 1.062 BLADE</div><div class=\"col\">FF7ER </div><div class=\"col\"><a title=\"FF7ER \" href=\"https://store.milacron.com/item-detail?itemId=399322&organizationId=2\">Buy Now</a></div>\n" +
"</div>\n" +
"<div class=\"row\"><div class=\"col\">GATE CUTTER FLAT FACE PREMIUM W/ STOP PIN 7.50 OAL 1\" BLADE</div><div class=\"col\">FF7P </div><div class=\"col\"><a title=\"FF7P \" href=\"https://store.milacron.com/item-detail?itemId=399323&organizationId=2\">Buy Now</a></div>\n" +
"</div>\n" +
"<div class=\"row\"><div class=\"col\">7-1/2\" OAL POWER UP PREMIUM GATE CUTTER</div><div class=\"col\">FF7PU </div><div class=\"col\"><a title=\"FF7PU \" href=\"https://store.milacron.com/item-detail?itemId=1020220&organizationId=2\">Buy Now</a></div>\n" +
"</div>\n" +
"<div class=\"row\"><div class=\"col\">GATE CUTTER FLAT FACE PREMIUM 8\" OAL 1.25 BLADE</div><div class=\"col\">FF8 </div><div class=\"col\"><a title=\"FF8 \" href=\"https://store.milacron.com/item-detail?itemId=399324&organizationId=2\">Buy Now</a></div>\n" +
"</div>\n" +
"<div class=\"row\"><div class=\"col\">GATE CUTTER ANGLE HEAD PREMIUM 45 DEGREES 5.875 OAL 1\" BLADE</div><div class=\"col\">GA5 </div><div class=\"col\"><a title=\"GA5 \" href=\"https://store.milacron.com/item-detail?itemId=399339&organizationId=2\">Buy Now</a></div>\n" +
"</div>\n" +
"<div class=\"row\"><div class=\"col\">GATE CUTTER ANGLE HEAD PREMIUM 90 DEGREES 5.5 OAL .75 BLADE</div><div class=\"col\">GA6 </div><div class=\"col\"><a title=\"GA6 \" href=\"https://store.milacron.com/item-detail?itemId=399340&organizationId=2\">Buy Now</a></div>\n" +
"</div>\n" +
"<div class=\"row\"><div class=\"col\">GATE CUTTER ANGLE HEAD PREMIUM 45 DEGREES 6.50 OAL 6.50 BLADE</div><div class=\"col\">GA7 </div><div class=\"col\"><a title=\"GA7 \" href=\"https://store.milacron.com/item-detail?itemId=399342&organizationId=2\">Buy Now</a></div>\n" +
"</div>\n" +
"<div class=\"row\"><div class=\"col\">GATE CUTTER FLAT FACE PREMIUM 5.750 OAL .875 BLADE</div><div class=\"col\">GR5 </div><div class=\"col\"><a title=\"GR5 \" href=\"https://store.milacron.com/item-detail?itemId=399325&organizationId=2\">Buy Now</a></div>\n" +
"</div>\n" +
"<div class=\"row\"><div class=\"col\">GATE CUTTER NIPPER PREMIUM 4.625 OAL .687 BLADE</div><div class=\"col\">S4 </div><div class=\"col\"><a title=\"S4 \" href=\"https://store.milacron.com/item-detail?itemId=399329&organizationId=2\">Buy Now</a></div>\n" +
"</div>\n" +
"<div class=\"row\"><div class=\"col\">GATE CUTTER NIPPER PREMIUM 5\" OAL .75 BLADE</div><div class=\"col\">S5 </div><div class=\"col\"><a title=\"S5 \" href=\"https://store.milacron.com/item-detail?itemId=399330&organizationId=2\">Buy Now</a></div>\n" +
"</div>\n" +
"<div class=\"row\"><div class=\"col\">GATE CUTTER NIPPER PREMIUM 5\" OAL .562 BLADE</div><div class=\"col\">S5A </div><div class=\"col\"><a title=\"S5A \" href=\"https://store.milacron.com/item-detail?itemId=399326&organizationId=2\">Buy Now</a></div>\n" +
"</div>\n" +
"<div class=\"row\"><div class=\"col\">GATE CUTTER NIPPER PREMIUM 6.125 OAL .875 BLADE</div><div class=\"col\">S6 </div><div class=\"col\"><a title=\"S6 \" href=\"https://store.milacron.com/item-detail?itemId=399331&organizationId=2\">Buy Now</a></div>\n" +
"</div>\n" +
"<div class=\"row\"><div class=\"col\">GATE CUTTER NIPPER PREMIUM 6.125 OAL .875 BLADE</div><div class=\"col\">S6EL </div><div class=\"col\"><a title=\"S6EL \" href=\"https://store.milacron.com/item-detail?itemId=399332&organizationId=2\">Buy Now</a></div>\n" +
"</div>\n" +
"<div class=\"row\"><div class=\"col\">GATE CUTTER NIPPER PREMIUM 6.125 OAL .875 BLADE</div><div class=\"col\">S6ER </div><div class=\"col\"><a title=\"S6ER \" href=\"https://store.milacron.com/item-detail?itemId=399333&organizationId=2\">Buy Now</a></div>\n" +
"</div>\n" +
"<div class=\"row\"><div class=\"col\">GATE CUTTER NIPPER PREMIUM 6\" OAL .75 BLADE</div><div class=\"col\">S6P </div><div class=\"col\"><a title=\"S6P \" href=\"https://store.milacron.com/item-detail?itemId=399334&organizationId=2\">Buy Now</a></div>\n" +
"</div>\n" +
"<div class=\"row\"><div class=\"col\">GATE CUTTER NIPPER PREMIUM ROUND BACK 7.50 OAL 1\" BLADE</div><div class=\"col\">S7 </div><div class=\"col\"><a title=\"S7 \" href=\"https://store.milacron.com/item-detail?itemId=399335&organizationId=2\">Buy Now</a></div>\n" +
"</div>\n" +
"<div class=\"row\"><div class=\"col\">GATE CUTTER NIPPER PREMIUM ERGONOMIC 7.50 OAL 1.062 BLADE</div><div class=\"col\">S7EL </div><div class=\"col\"><a title=\"S7EL \" href=\"https://store.milacron.com/item-detail?itemId=399336&organizationId=2\">Buy Now</a></div>\n" +
"</div>\n" +
"<div class=\"row\"><div class=\"col\">GATE CUTTER NIPPER PREMIUM ERGONOMIC 7.50 OAL 1.062 BLADE</div><div class=\"col\">S7ER </div><div class=\"col\"><a title=\"S7ER \" href=\"https://store.milacron.com/item-detail?itemId=399337&organizationId=2\">Buy Now</a></div>\n" +
"</div>\n" +
"<div class=\"row\"><div class=\"col\">7-1/8\" OAL POWER UP PREMIUM GATE CUTTER</div><div class=\"col\">S7PU </div><div class=\"col\"><a title=\"S7PU \" href=\"https://store.milacron.com/item-detail?itemId=1020221&organizationId=2\">Buy Now</a></div>\n" +
"</div>\n" +
"<div class=\"row\"><div class=\"col\">GATE CUTTER NIPPER PREMIUM ROUND BACK 8\" OAL 1.25 BLADE</div><div class=\"col\">S8 </div><div class=\"col\"><a title=\"S8 \" href=\"https://store.milacron.com/item-detail?itemId=399338&organizationId=2\">Buy Now</a></div>\n" +
"</div>\n" +
"<div class=\"row\">\n" +
"<div class=\"col\"><center><a href=\"https://www.dme.net/gatecutters.php\">Back</a></center></div>\n" +
"</div>\n" +
"</div>\n" +
"</center>\n" +
"<div class=\"bnavbar\">&nbsp;</div>\n" +
"<div class=\"bnavbar2\"><center><a href=\"https://www.dme.net/digital-privacy-policy/\"><h4>Privacy Policy</h4></a></center></div><div class=\"bnavbar2\"><a href=\"https://www.dme.net/terms-of-sale-returns/\"><h4>Terms Of Use</h4></a></div><div class=\"hideformobilebnav\">&nbsp;</div><div class=\"hideformobilebnav\">&nbsp;</div><div class=\"bnavbar2\"><h4>© 2020 DME Company</h4></div>\n" +
"<div class=\"bnavbar\">&nbsp;</div>\n" +
"<script async src=\"https://www.googletagmanager.com/gtag/js?id=UA-153770781-1\"></script>\n" +
"<script>\n" +
"  window.dataLayer = window.dataLayer || [];\n" +
"  function gtag(){dataLayer.push(arguments);}\n" +
"  gtag('js', new Date());\n" +
"  gtag('config', 'UA-153770781-1');\n" +
"</script>\n" +
"<script>\n" +
"if('serviceWorker' in navigator) {\n" +
"  navigator.serviceWorker\n" +
"           .register('/superpwa-sw.js')\n" +
"           .then(function() { console.log(\"Service Worker Registered\"); });\n" +
"}\n" +
"</script>\n" +
"<script defer src=\"https://static.cloudflareinsights.com/beacon.min.js\" data-cf-beacon='{\"rayId\":\"59589a0dede47fac\",\"version\":\"2020.5.0\",\"startTime\":1589836612852}'></script>\n" +
"</body>\n" +
"</html>");

   out2.flush(); 
   //Close the Print Writer
   out2.close();       
   //Close the File Writer
   fw2.close();     
       
    }  
}