/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootathon;

import java.sql.*;

public class Backend {

    //To create tables
    void createTable(){
        try{
           register();
           busTicketBooking();
           trainTicketBooking();
           destinations();
           restaurant();
          guides();
          accommodation();
           accommodation_UserInfo();
           rentalCars();
           packageTours();
           packageTours_UserInfo();
           payment();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    //Creation of Table Containing Registration Form Details
    void register(){
        try{
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","deva","deva2505"); 
           Statement st=con.createStatement();
           String query="create table register(Firstname varchar(25),Lastname varchar(25),Gender varchar(10),DOB varchar(30),Age number(5),Mobile_Number varchar(13),Mail_Id varchar(35),Address_Line1 varchar(100),City varchar(25),District varchar(25),State varchar(25),Password varchar(16))";
           st.executeUpdate(query);
           con.setAutoCommit(true); 
        }
        catch(Exception a){      
            System.out.println(a);
        }
    }
    
    //Insertion of values into register table
    void insert_register(String fname,String lname,String gender,String dob,String age,String phno,String mail,String addressline1,String city,String district,String state,String pass){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","deva","deva2505");
            Statement st=con.createStatement();
            String query="insert into register values('"+fname+"','"+lname+"','"+gender+"','"+dob+"','"+age+"','"+phno+"','"+mail+"','"+addressline1+"','"+city+"','"+district+"','"+state+"','"+pass+"')";
            st.executeUpdate(query);
            
            con.setAutoCommit(true);
             
        }
        catch(Exception e){
            //System.out.println(e);
        }      
    }
    
    //Fetching details for login from the register table
    ResultSet login_details(){
        ResultSet rs=null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","deva","deva2505"); 
            Statement st=con.createStatement();
            String query="select Mail_Id,Password from register";
            rs=st.executeQuery(query);
            con.setAutoCommit(true);
        }
        catch(Exception e){
            //System.out.println(e);
        }
        return rs;
    }
    
    //Creation of Table Containing Bus Ticket Booking Details
    void busTicketBooking(){
                try{
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","deva","deva2505"); 
           Statement st=con.createStatement();
           String query = "create table busTicketBooking(From_location varchar(20),To_location varchar(20),Date1 varchar(6),Month1 varchar(10),Year1 varchar(6),Timing varchar(10),Bus_Name varchar(13),Ac_or_Non_AC varchar(12),Departure_Time varchar(15),Arrival_Time varchar(15),Available_Seats_sleeper varchar(100),Available_Seats_seater varchar(100),Booked_seats_sleeper varchar(100),Booked_seats_seater varchar(100),Amount_per_person_sleeper varchar(25),Amount_per_person_seater varchar(25))";
            st.executeUpdate(query);
            String query1 = "insert into busTicketBooking values('chennai','kanniyakumari','28','August','2021','night','APStravels','Ac','10 00pm','08 00am','1,2,3,4,5,6,7,8,9,10','11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30','11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30','18,19,20,21,22,23,24,25,26,27,28,29,30','800','1500')";
            st.executeUpdate(query1);
            String query2 = "insert into busTicketBooking values('chennai','kanniyakumari','28','August','2021','night','AkStravels','Ac','8 00pm','06 00am','1,2,3,4,5,6,7,8,9,10','11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30','1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17','18,19,20,21,22,23,24,25,26,27,28,29,30','800','1500')";
            st.executeUpdate(query2);
            String query3 = "insert into busTicketBooking values('chennai','kanniyakumari','28','August','2021','night','PKStravels','Ac','9 00pm','07 00am','1,2,3,4,5,6,7,8,9,10','11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30','11,12,13,14,115,6,7,8,9,10,11,12,13,14,15,16,17','18,19,20,21,22,23,24,25,26,27,28,29,30','800','1500')";
            st.executeUpdate(query3);
   
           con.setAutoCommit(true); 
        }
        catch(Exception a){
            System.out.println(a);
        }
    }
       ResultSet ticketBooking(String from, String to, String date, String month, String year, String bus_type) {
            ResultSet rs=null;
        System.out.println("------");
        try {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","deva", "deva2505");
            Statement stmt1 = con.createStatement();
            System.out.println("Befor query");
            String query = "select * from  busTicketBooking where From_location='"+from+"' and To_Location='"+to+"' and Date1='"+date+"' and Month1='"+month+"' and Year1='"+year+"' and Ac_or_Non_AC='"+bus_type+"'";
            rs= stmt1.executeQuery(query);
            
            System.out.println("After query");
        }
        catch(Exception e){
            
        }
        return rs;
       }
    
 public String Booking(String from, String to) {
        String Booked_sleeper_seats = null;
        System.out.println("------");
        try {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "deva", "deva2505");
            Statement stmt1 = con.createStatement();
            System.out.println("Before query");
            // String query = "select * from  busTicketBooking where From_location='"+from+"' and To_Location='"+to+"' and Date='"+date+"' and Month='"+month+"' and Year='"+year+"' and Ac_or_Non_AC='"+bus_type+"'";
            String query = "select * from busTicketBooking where From_location ='" + from + "' and To_Location='" + to + "'";
            System.out.println(from);
            System.out.println("After query");

            ResultSet rs = stmt1.executeQuery(query);
            System.out.println("After query====");
            while (rs.next()) {
                Booked_sleeper_seats = rs.getString("Booked_seats_sleeper");
                System.out.println(Booked_sleeper_seats);
            }
            con.close();
            System.out.println("Done");
        } catch (Exception e) {
            System.out.println(e);
        }
        return Booked_sleeper_seats;
    }
     public String[]  updateBooking(String from, String to,String bus_type, String selected) {
        String Booked_sleeper_seats = null, NonBooked_sleeper_seats = null;
        String arr2[] = new String[2];
       // String AC = "Ac";
        try {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "deva", "deva2505");
            Statement stmt1 = con.createStatement();
            System.out.println("Before query");
            // String query = "select * from  busTicketBooking where From_location='"+from+"' and To_Location='"+to+"' and Date='"+date+"' and Month='"+month+"' and Year='"+year+"' and Ac_or_Non_AC='"+bus_type+"'";
            String query = "select * from busTicketBooking where From_location ='" + from + "' and To_Location='" + to + "' and Ac_or_Non_AC='"+bus_type+"'";
            System.out.println(from);
            System.out.println("After query");

            ResultSet rs = stmt1.executeQuery(query);
            System.out.println("After query====");
            while (rs.next()) {
                Booked_sleeper_seats = rs.getString("Booked_seats_sleeper");
                NonBooked_sleeper_seats = rs.getString("AVAILABLE_SEATS_SLEEPER");
                arr2[0] = Booked_sleeper_seats;
                arr2[1] = rs.getString("Amount_per_person_sleeper");
                System.out.println(arr2[0]);
                System.out.println(arr2[1]);
                
                System.out.println(Booked_sleeper_seats);
                System.out.println(NonBooked_sleeper_seats);
            }
            String arr1[] = NonBooked_sleeper_seats.split(",");
            NonBooked_sleeper_seats = "";
            for (int i = 0; i < arr1.length; i++) {
                if (!arr1[i].equals(selected)) {
                    NonBooked_sleeper_seats += arr1[i];
                    NonBooked_sleeper_seats +=",";
                }
            }
            Booked_sleeper_seats += "," + selected;
            System.out.println(Booked_sleeper_seats);
            System.out.println(NonBooked_sleeper_seats);

            String query1 = "update busTicketBooking set Booked_seats_sleeper = '" + Booked_sleeper_seats + "',AVAILABLE_SEATS_SLEEPER ='" + NonBooked_sleeper_seats + "' where From_location='" + from + "' and To_Location='" + to + "'";
            System.out.println(query1);
            stmt1.executeQuery(query1);

            con.close();
            System.out.println("Done");
        } 
          catch (Exception ex) {
            System.out.println(ex);
        }
        return arr2;
    }
    
    //Creation of Table Containing Train Ticket Booking Details
    void trainTicketBooking(){
        try{
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","deva","deva2505"); 
           Statement st=con.createStatement();
           String query="create table trainTicketBooking(From_location varchar(25),To_location varchar(25),Start_Date varchar(30),Timing varchar(20),Train_Name varchar(30),Train_Number varchar(20),Compartment_Number varchar(20),Arrival_Time varchar(20),Departure_Time varchar(20),Total_Seats varchar(12),Sleeper_Class varchar(100),First_Class varchar(100),Second_Class varchar(100),Third_Class varchar(100),No_of_Available_Seats varchar(25),Amount_per_person varchar(25),Booked varchar(20))";
           st.executeUpdate(query);
           con.setAutoCommit(true); 
        }
        catch(Exception a){
            System.out.println(a);
        }
    } 
    
    //Creation of Table Containing Holiday Destinations Details
    void destinations(){
        try{
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","deva","deva2505"); 
           Statement st=con.createStatement();
           String query="create table destinations(State varchar(30),Place_Type varchar(35),District varchar(30),Places varchar(50),Place_Description varchar(500))";
           st.executeUpdate(query);
           String query1="insert into destinations values('Tamil Nadu','Holy Places','Kanyakumari','Bhagavathi Amman Temple','This is a famous temple of Kanyakumari which is 3000 years old.\nThe presiding deity is Kanya Kumari also known as Bhagavathy Amma.\nThis place is one of the 108 Shakti Peethas of India.\nImportant feature of the alluring idol of the Devi Kanyakumari is the\ndiamond nose ring of the Goddess. Goddess is adorned with this\nexquisite nose ring in the evening and hence Devi is also called\nMookuthi Amma. We were fortunate to have darshan of Mookuthi Amma.')";
           st.executeUpdate(query1);
           String query2="insert into destinations values('Tamil Nadu','Holy Places','Kanyakumari','Suchindram Thaanumaalayan Temple','The striking aspect of this temple is that it is dedicated to\nthe Trinity of God, Lord Shiva, Lord Vishnu and Lord Brahma.\nIt is 11 km from Kanyakumari city and 7 km from Nagercoil town .\nThe temple is rich in sculpture and architecture and a visitor to\nthis temple is amply rewarded with the sight of such exquisite\nart of hundreds of years old.')";
           st.executeUpdate(query2);
           String query3="insert into destinations values('Tamil Nadu','Holy Places','Tanjore','Brihadeeswara Temple','Brihadeeswara Temple also known as Peruvudaiyar Kovil in tamil\nis a popular Hindu temple dedicated to Lord Brahadeeshwarar (Lord Shiva).\nThis Big Temple is one of the largest temples in India.\nThe Huge Cap of Tanjore big temple is constructed in\nsuch a way that the shadow of the big gopuram will not\nfall on the ground an noon in any season.It is a\nmust visit place in Tamil Nadu.')";
           st.executeUpdate(query3);
           String query4="insert into destinations values('Tamil Nadu','Holy Places','Madurai','Meenakshi Amman Temple','Arulmigu Meenakshi Sundareshwarar Temple is a historic Hindu temple\nlocated on the southern bank of the Vaigai River in the\ntemple city of Madurai. It is dedicated to the goddess Meenakshi,\na form of Parvati, and her consort, Sundareshwar, a form of Shiva.\nThe temple has a Hall of Thousand Pillars and each pillar is\ncarved with various sculptures. Meenakshi Temple has a pond called\nPorthamarai Kulam or The Golden Lotus Pond in its complex.')";
           st.executeUpdate(query4);
           String query5="insert into destinations values('Tamil Nadu','Holy Places','Chidambaram','Chidambaram Natarajar Temple','The Chidambaram temple complex proudly boasts of being one of the\noldest temple complexes in Southern India. The most unique characteristic\nof the Nataraj Temple is the bejewelled image of Nataraj.\nThe temple has five main Halls or Sabhas.Since ancient times,\nit is believed that this is the place where Shiva and\nhis consort Parvati are present, but invisible to most people.')";
           st.executeUpdate(query5);
           String query6="insert into destinations values('Tamil Nadu','Hill Stations','Nilgiris','Coonoor','Coonoor is the second largest hill station located in the\nNilgiri hills . It is famous for its verdant environs and\nfor a variety of wildflowers and birds. Coonoor provides a\nperfect setting for activities like trekking and hiking.\nIt is also famous for its tea plantations and festivals.')";
           st.executeUpdate(query6);
           String query7="insert into destinations values('Tamil Nadu','Hill Stations','Nilgiris','Ooty','Ooty is called the Queen of Hill Stations. Ooty is offering\nyou to explore the best ever beauty of lush green foothills,\ncaptivating landscapes, and the exciting wildlife sanctuary. The perfect combination of\nnatural and manmade beauty will make you decide to come to\nthis place again and again.')";
           st.executeUpdate(query7);
           String query8="insert into destinations values('Tamil Nadu','Hill Stations','Nilgiris','Kothagiri','Kotagiri is the oldest and the third largest hill stations in the\nNilgiris. Its climate is claimed to be one of the best\nin the World.The Kotagiri weather is more bracing than\nthat of Coonoor and balmier than that of Ooty.\nTill date the beauty of hill resort of Kotagiri attracts\ntourists and the sun scorched souls from far and wide.')";
           st.executeUpdate(query8);
           String query9="insert into destinations values('Tamil Nadu','Hill Stations','Salem','Yercaud','Yercaud is the highly visited attractions amongst nature lovers,\nteenagers and families. It is renowned for its splendid exquisiteness,\nverdant greenery and coffee plantations. It experiences salubrious climate\nall through the year and offers a great opportunity to the\ntourists to relish its striking scenic beauty, which is\nspectacular and amazing.')";
           st.executeUpdate(query9);
           String query10="insert into destinations values('Tamil Nadu','Hill Stations','Dindigul','Kodaikanal','Often referred as Princess of Hill Stations, Kodaikanal is\none of the most popular tourist destinations.Kodaikanal Hill Station is\na destination where you can make a trip in any time\nor any season throughout the year due to its persistent\nlovely pleasant weather.Some popular sightseeing spots like Kodai Lake,\nBryant Park and Bear Shola Falls are worthy of a visit.')";
           st.executeUpdate(query10);
           String query11="insert into destinations values('Tamil Nadu','Beaches','Kanyakumari','Kanyakumari Beach','Situated at the confluence of the Bay of Bengal,\nthe Arabian Sea, and the Indian Ocean, this is the\nonly place in India where one can enjoy the unique\nspectacle of Sunset and Moonrise simultaneously on full moon days.\nOne of the main attractions in this place is the\nThiruvalluvar Statue and the Vivekananda Rock Memorial.')";
           st.executeUpdate(query11);
           String query12="insert into destinations values('Tamil Nadu','Beaches','Chennai','Marina Beach','The famous Marina beach is the second longest beach in the World.\nThis is one of the top tourist places to visit in\nChennai city and also one of the popular attraction not to\nmiss in a Chennai tour packages.')";
           st.executeUpdate(query12);
           String query13="insert into destinations values('Tamil Nadu','Beaches','Ramanathapuram','Dhanushkodi Beach','Dhanushkodi Beach lies on the tip of the Rameswaram island.\nIn this beach, the Bay of Bengal and Indian Ocean\nmerge which is known as Arichal Munai in Tamil.\nThe Dhanushkodi Beach attracted thousands of tourists each day.')";
           st.executeUpdate(query13);
           String query14="insert into destinations values('Tamil Nadu','Beaches','Chennai','Elliot Beach','Elliot Beach is located in Besant Nagar, Chennai. It forms\nthe end-point of the Marina Beach shore.Embellished by\ngolden sand beaches, curling waves and limitless stretch of sea,\nthe beach entices tourists from different parts of the world.\nThe serene and tranquil nature of the beach uplifts the\nhuman spirit and refreshes the mind and soul.')";
           st.executeUpdate(query14);
           String query15="insert into destinations values('Tamil Nadu','Beaches','Chennai','Covelong Beach','Covelong beach is an incredible beach situated on the\nCoromandel Coast at a distance of 40 km from Chennai.\nHere , people would be delighted to view the inspiring waves\ndashing on the silver sand.It is the dream destination\nfor all those who wander in the search of a\ntranquil vacation.')";
           st.executeUpdate(query15);
           String query16="insert into destinations values('Tamil Nadu','Places of Architectural Importance','Madurai','Madurai Meenakshi Amman Temple','The Meenakshi Temple is a prime example of Dravidian architecture.\nThe city and the temple align to the directions of\nthe compass.The temple has 14 gopurams or gateway towers\nand 33,000 sculptures including two golden sculptured vimanas that is the\ntower above the sanctum. The southern gopuram is the tallest\nof them all.It is a must visit place in India.')";
           st.executeUpdate(query16);
           String query17="insert into destinations values('Tamil Nadu','Places of Architectural Importance','Tanjore','Brihadeeswarar Temple','The structure of this temple is an example of Dravidian architecture\nand it represents the ideology of Tamil civilization and Chola Empire.\nThe temple has the most tallest vimanam (temple tower)\nin the world and its Kumbam weighs approximately 80 tons.\nIt still remains a mystery that how in that period\nwithout any big machines or technology they would have lifted and\nplaced that big Kumbam on the top of the temple tower.')";
           st.executeUpdate(query17);
           String query18="insert into destinations values('Tamil Nadu','Places of Architectural Importance','Madurai','Thirumalai Nayakkar Mahal','Thirumalai Nayakkar Mahal is known for its huge pillars where\neach pillar is 82 feet high with a width of\n19 feet. The palace is bifurcated into two vast areas\ncalled Swarga Vilasam and Ranga Vilasam.The interior is richly\ndecorated whilst the exterior is treated in a more austere style.\nThis is a must visit place in Tamil Nadu.')";
           st.executeUpdate(query18);
           String query19="insert into destinations values('Tamil Nadu','Places of Architectural Importance','Tanjore','Gangaikonda Cholapuram','Gangaikonda Cholapuram is regarded as the reproduction of the\nBrihadisvara Temple that was built by Rajaraja Chola,\nfather of Rajendra Chola. The temple is renowned for having\nthe biggest Shivalingam in the Southern part of India.\nChandesura Anugraha Murthy and Sarasvathy are the most beautiful sculptures\n of the temple.')";
           st.executeUpdate(query19);
           String query20="insert into destinations values('Tamil Nadu','Places of Architectural Importance','Chengalpattu','Mahabalipuram','Mamallapuram or Mahabalipuram in Tamil Nadu is a temple of art,\ncreated by the Pallava rulers. It is a virtual treasure\ntrove of sculpture and architecture.Krishnas Butterball is a \ngigantic granite boulder resting on a short incline in the\nhistorical coastal resort town of Mamallapuram.')";
           st.executeUpdate(query20);
           con.setAutoCommit(true); 
        }
        catch(Exception a){
            System.out.println(a);
        }
    } 
    
    //Fetching details from the destinations table
    ResultSet destinations_details(String state,String place_type){
        ResultSet rs=null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","deva","deva2505"); 
            Statement st=con.createStatement();
            String query="select * from destinations where State='"+state+"' and Place_Type='"+place_type+"'";
            rs=st.executeQuery(query);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return rs;
    }
    
    //Creation of Table Containing Restaurant Details
    void restaurant(){
        try{
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","deva","deva2505"); 
           Statement st=con.createStatement();
           String query="create table restaurant(District varchar(25),Restaurant_Name varchar(45),Restaurant_Location varchar(400),Type varchar(10),Restaurant_Rating varchar(18))";
           st.executeUpdate(query);
           String query1="insert into restaurant values('Kanyakumari','Indus Buffet','17/58 B-2 Hotel Shri Padham Heritage,\nVivekanandapuram Opposite Vivekananda Kendra,\nBehind IOC Petrol Pump,\nKanyakumari, Tamil Nadu - 629702.','Pure Veg','5 Stars')";
           st.executeUpdate(query1);
           String query2="insert into restaurant values('Kanyakumari','The Ocean Heritage Restaurant','2/12, East Car Street ,\nKanyakumari,\nTamil Nadu - 629702.','Non Veg','4 Stars')";
           st.executeUpdate(query2);
           String query3="insert into restaurant values('Kanyakumari','Suchindram Maruti Hotel','No.6, opp. to Theppakulam,\nSuchindram,\nTamil Nadu - 629704.','Pure Veg','4.4 Stars')";
           st.executeUpdate(query3);
           String query4="insert into restaurant values('Tanjore','Sri Sivas','New Bus Stand opp,\nTrichy Main Rd,\nThanjavur,\nTamil Nadu - 613005.','Pure Veg','3.8 Stars')";
           st.executeUpdate(query4);
           String query5="insert into restaurant values('Tanjore','Adyar Ananda Bhavan','Trichy - Tindivanam Highway,\nN S C Bose Nagar, Ramani Nagar,\nThanjavur,\nTamil Nadu - 613010.','Pure Veg','4 Stars')";
           st.executeUpdate(query5);
           String query6="insert into restaurant values('Tanjore','Banana Leaf','Trichy Main Rd,\nNear Bharath College, Thiruvalluvar Nagar,\nNew Housing Unit,\nThanjavur, Tamil Nadu - 613005.','Non Veg','3.8 Stars')";
           st.executeUpdate(query6);
           String query7="insert into restaurant values('Madurai','Sree Sabarees','West, Mela Perumal Maistry Street,\nMadurai Main,\nMadurai,\nTamil Nadu - 625001.','Pure Veg','4.5 Stars')";
           st.executeUpdate(query7);
           String query8="insert into restaurant values('Madurai','Bell Jumbo Restaurant','Theni Main Rd,\nHMS Colony, Ponmeni,\nMudakuchalai,\nTamil Nadu - 625016.','Non Veg','3.8 Stars')";
           st.executeUpdate(query8);
           String query9="insert into restaurant values('Madurai','Hotel Amirtha Restaurant','29/30 West Tower Street,\nWest Masi Street,\nMadurai - 625001.','Pure Veg','4.5 Stars')";
           st.executeUpdate(query9);
           String query10="insert into restaurant values('Salem','Salem Paradise Multi Cuisine Restaurant','40/22 Ramakrishana Road ,\nAmmasi Gounder street,\nSalem,\nTamil Nadu - 636007.','Non Veg','4.2 Stars')";
           st.executeUpdate(query10);
           String query11="insert into restaurant values('Salem','Sri Saravana Bhavan','Omalur Main Road,\nState Bank Colony,\nSalem - 636004,\nIndia.','Pure Veg','4 Stars')";
           st.executeUpdate(query11);
           String query12="insert into restaurant values('Salem','Hotel Lakshmi Prakash','315, 1, Brindavan Road,\nFairlands,\nSalem,\nTamil Nadu - 636016.','Non Veg','4 Stars')";
           st.executeUpdate(query12);
           String query13="insert into restaurant values('Dindigul','Dindigul Thalappakatti Restaurant','Old No.31, New, no.26,\nRailway Station Road,\nDindigul,\nTamil Nadu - 624001.','Non Veg','3.7 Stars')";
           st.executeUpdate(query13);
           String query14="insert into restaurant values('Dindigul','Taj Restaurant','South Car Street,\nDindigul,\nTamil Nadu - 624001.','Non Veg','4.1 Stars')";
           st.executeUpdate(query14);
           String query15="insert into restaurant values('Dindigul','Meenakshi Bhavan','Sub Collector Office Road,\nSpencer Compound,\nDindigul,\nTamil Nadu - 624001.','Pure Veg','4 Stars')";
           st.executeUpdate(query15);
           String query16="insert into restaurant values('Nilgiris','Preethi Veg Restaurant','34, Ettines Road,\nCharring Cross,\nOoty, The Nilgiris,\nTamil Nadu - 643001.','Pure Veg','3.6 Stars')";
           st.executeUpdate(query16);
           String query17="insert into restaurant values('Nilgiris','CBM Restaurant','TDK Pillai Road Ground Floor,\nELDEE Complex,\nCoonoor,\nTamil Nadu - 643102.','Pure Veg','4.6 Stars')";
           st.executeUpdate(query17);
           String query18="insert into restaurant values('Nilgiris','Green Nasco Food Court','Charting cross,\nMain Bazaar Road,\nOoty,\nTamil Nadu - 643001.','Non Veg','3.4 Stars')";
           st.executeUpdate(query18);
           String query19="insert into restaurant values('Chidambaram','Sri Krishna Vilas','95/129,\nEast Car Street,\nChidambaram,\nTamil Nadu - 608001.','Non Veg','4.3 Stars')";
           st.executeUpdate(query19);
           String query20="insert into restaurant values('Chidambaram','Ramesh High Class Vegetarian Hotel','East Car Street,\nChidambaram,\nTamil Nadu - 608001.','Pure Veg','4.1 Stars')";
           st.executeUpdate(query20);
           String query21="insert into restaurant values('Chidambaram','Arupadai Unavagam','10, Rave Main Rd,\nParangipettai,\nTamil Nadu - 608502.','Pure Veg','4.9 Stars')";
           st.executeUpdate(query21);
           String query22="insert into restaurant values('Chennai','MKC - Madras Kitchen Company','154, Velachery Main Road,\nDhadeswaram Nagar,\nVelachery, Chennai,\nTamil Nadu - 600042.','Non Veg','4.4 Stars')";
           st.executeUpdate(query22);
           String query23="insert into restaurant values('Chennai','Broken Bridge Cafe Indian Restaurant','Somerset Greenways,\n94, Sathyadev Ave,\nMRC Nagar, Raja Annamalai Puram,\nChennai, Tamil Nadu - 600028.','Non Veg','4.4 Stars')";
           st.executeUpdate(query23);
           String query24="insert into restaurant values('Chennai','Annalakshmi Restaurant','No 6 Mayor Ramanathan Salai,\nSpur Tank road,\nChennai,\nTamil Nadu - 600031.','Pure Veg','4.5 Stars')";
           st.executeUpdate(query24);
           String query25="insert into restaurant values('Chengalpattu','Sree Bhagavathy Villas Hotel','Alagesan Nagar,\nVaradharaja Nagar,\nChengalpattu,\nTamil Nadu - 603001.','Pure Veg','3.8 Stars')";
           st.executeUpdate(query25);
           String query26="insert into restaurant values('Chengalpattu','Hotel Ananda Bavan','245 Pazheveli Village,\nChengalpattu Bypass road,\nVembakkam post,\nChengalpattu, Tamil Nadu - 603111.','Pure Veg','4 Stars')";
           st.executeUpdate(query26);
           String query27="insert into restaurant values('Chengalpattu','V S P Restaurants','No,67, Pillayar Koil Street,\nPotheri( Back Side SRM College),\nChengalpattu - 603203.','Non Veg','4.5 Stars')";
           st.executeUpdate(query27);
           String query28="insert into restaurant values('Ramanathapuram','Vitamin R(Sea view)','21/26-A1,Agasthiyar Theertham Street,\nNear Agni Theertham,\nRameswaram,\nTamil Nadu - 623526.','Pure Veg','4.5 Stars')";
           st.executeUpdate(query28);
           String query29="insert into restaurant values('Ramanathapuram','Hotel Ishwarya Veg','Sannadhi Street,\nV. O. C. Nagar,\nRameswaram,\nTamil Nadu - 623526.','Pure Veg','3.5 Stars')";
           st.executeUpdate(query29);
           String query30="insert into restaurant values('Ramanathapuram','Chickinn Restaurant','52, Kadhar Pallivasal Street,\nRamanathapuram,\nTamil Nadu - 623501.','Non Veg','4 Stars')";
           st.executeUpdate(query30);
           con.setAutoCommit(true); 
        }
        catch(Exception a){
            System.out.println(a);
        }
    }  
    
    //Fetching details from the restaurant table
    ResultSet restaurant_details(String district){
        ResultSet rs=null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","deva","deva2505"); 
            Statement st=con.createStatement();
            String query="select * from restaurant where District='"+district+"'";
            rs=st.executeQuery(query);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return rs;
    }
    
    //Creation of Table Containing Guides Details
    void guides(){
        try{
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","deva","deva2505"); 
           Statement st=con.createStatement();
           String query="create table guides(District varchar(25),Guide_Id varchar(15),Guide_Name varchar(25),Guide_Gender varchar(15),Contact_Number varchar(16),Amount_per_day varchar(17),Booked varchar(10),Mail_Id varchar(35))";
           st.executeUpdate(query);
           String query1="insert into guides values('Kanyakumari','KK1','Suresh','Male','9875656231','700','NO','Nil')";
           st.executeUpdate(query1);
           String query2="insert into guides values('Kanyakumari','KK2','James','Male','9785656213','600','NO','Nil')";
           st.executeUpdate(query2);
           String query3="insert into guides values('Kanyakumari','KK3','Ramesh','Male','9786553413','650','NO','Nil')";
           st.executeUpdate(query3);
           String query4="insert into guides values('Tanjore','TJ1','Balaji','Male','9183353313','650','NO','Nil')";
           st.executeUpdate(query4);
           String query5="insert into guides values('Tanjore','TJ2','Murugan','Male','9984455312','600','NO','Nil')";
           st.executeUpdate(query5);
           String query6="insert into guides values('Tanjore','TJ3','Gomathi','Female','9884825377','700','NO','Nil')";
           st.executeUpdate(query6);
           String query7="insert into guides values('Madurai','MD1','Maanickam','Male','9022455312','600','NO','Nil')";
           st.executeUpdate(query7);
           String query8="insert into guides values('Madurai','MD2','Thiagarajan','Male','9480455312','650','NO','Nil')";
           st.executeUpdate(query8);
           String query9="insert into guides values('Madurai','MD3','Vennila','Female','9388455311','650','NO','Nil')";
           st.executeUpdate(query9);
           String query10="insert into guides values('Salem','SM1','Selvi','Female','9680455314','650','NO','Nil')";
           st.executeUpdate(query10);
           String query11="insert into guides values('Salem','SM2','Ravi','Male','8300455314','650','NO','Nil')";
           st.executeUpdate(query11);
           String query12="insert into guides values('Salem','SM3','Thiyagu','Male','9710455314','600','NO','Nil')";
           st.executeUpdate(query12);
           String query13="insert into guides values('Dindigul','DG1','Mani','Male','9680455314','650','NO','Nil')";
           st.executeUpdate(query13);
           String query14="insert into guides values('Dindigul','DG2','Saravanan','Male','9700455200','550','NO','Nil')";
           st.executeUpdate(query14);
           String query15="insert into guides values('Dindigul','DG3','Raju','Male','8680450311','600','NO','Nil')";
           st.executeUpdate(query15);
           String query16="insert into guides values('Nilgiris','NG1','Shyam','Male','6380455314','750','NO','Nil')";
           st.executeUpdate(query16);
           String query17="insert into guides values('Nilgiris','NG2','Megala','Female','8390955243','700','NO','Nil')";
           st.executeUpdate(query17);
           String query18="insert into guides values('Nilgiris','NG3','Shiva','Male','6382045531','700','NO','Nil')";
           st.executeUpdate(query18);
           String query19="insert into guides values('Chidambaram','CD1','Nataraj','Male','6382245580','650','NO','Nil')";
           st.executeUpdate(query19);
           String query20="insert into guides values('Chidambaram','CD2','Ganapathy','Male','8332245580','600','NO','Nil')";
           st.executeUpdate(query20);
           String query21="insert into guides values('Chidambaram','CD3','Moorthi','Male','9382455451','600','NO','Nil')";
           st.executeUpdate(query21);
           String query22="insert into guides values('Chennai','CN1','Ganesh','Male','8090455434','600','NO','Nil')";
           st.executeUpdate(query22);
           String query23="insert into guides values('Chennai','CN2','Basker','Male','9310468421','550','NO','Nil')";
           st.executeUpdate(query23);
           String query24="insert into guides values('Chennai','CN3','Babu','Male','9801441252','600','NO','Nil')";
           st.executeUpdate(query24);
           String query25="insert into guides values('Chengalpattu','CG1','Manikandan','Male','9001441252','500','NO','Nil')";
           st.executeUpdate(query25);
           String query26="insert into guides values('Chengalpattu','CG2','Megala','Female','8145112523','550','NO','Nil')";
           st.executeUpdate(query26);
           String query27="insert into guides values('Chengalpattu','CG3','Nagaraj','Male','9990141342','500','NO','Nil')";
           st.executeUpdate(query27);
           String query28="insert into guides values('Ramanathapuram','RP1','Michael','Male','9910412523','700','NO','Nil')";
           st.executeUpdate(query28);
           String query29="insert into guides values('Ramanathapuram','RP2','Thiru','Male','9833432532','650','NO','Nil')";
           st.executeUpdate(query29);
           String query30="insert into guides values('Ramanathapuram','RP3','Madan','Male','9467132245','600','NO','Nil')";
           st.executeUpdate(query30);
           con.setAutoCommit(true); 
        }
        catch(Exception a){
            System.out.println(a);
        }
    }  
    
    //Fetching details from the guides table
    ResultSet guides_details(String district){
        ResultSet rs=null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","deva","deva2505"); 
            Statement st=con.createStatement();
            String query="select * from guides where District='"+district+"'";
            rs=st.executeQuery(query);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return rs;
    }
    
    //Guide Booking (Updation of guides table), fetching amount for payment
    String guideBooking(String userid,String guideid,String booked,String dayscount){
        int amount=0;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","deva","deva2505"); 
            Statement st=con.createStatement();
            String query="update guides set Mail_Id='"+userid+"',Booked='"+booked+"' where Guide_Id='"+guideid+"'";
            st.executeUpdate(query);
            System.out.println(guideid);
            String query1="select Amount_per_day from guides where Guide_Id='"+guideid+"'";
            ResultSet rs=st.executeQuery(query1);
            rs.next();
            int amt=Integer.parseInt(rs.getString(1));
            int amt1=Integer.parseInt(dayscount);
            amount=amt*amt1;
            con.setAutoCommit(true);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return String.valueOf(amount);
    }
     
    //Creation of Table Containing Accommodation Details
    void accommodation(){
        try{
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","deva","deva2505"); 
           Statement st=con.createStatement();
           String query="create table accommodation(District varchar(25),Dates varchar(30),Hotel_Id varchar(15),Hotel_Name varchar(50),Hotel_Type varchar(15),Hotel_location varchar(250),Contact_Number varchar(20),AC_SingleCot varchar(15),Amount_ACS varchar(20),NonAC_SingleCot varchar(17),Amount_NACS varchar(20),AC_DoubleCot varchar(15),Amount_ACD varchar(20),NonAC_DoubleCot varchar(17),Amount_NACD varchar(20),AC_MasterRoom varchar(15),Amount_ACM varchar(20))";
           st.executeUpdate(query);
           String query1="insert into accommodation values('Kanyakumari','5-September-2021','KK101','Hotel Ocean Heritage','3 Star Hotel','2, 11B, East Car Street,\nopp. Hotel Maadhini, Kanyakumari,\nTamil Nadu - 620702','9486163959','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query1);
           String query2="insert into accommodation values('Kanyakumari','6-September-2021','KK101','Hotel Ocean Heritage','3 Star Hotel','2, 11B, East Car Street,\nopp. Hotel Maadhini, Kanyakumari,\nTamil Nadu - 620702','9486163959','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query2);
           String query3="insert into accommodation values('Kanyakumari','7-September-2021','KK101','Hotel Ocean Heritage','3 Star Hotel','2, 11B, East Car Street,\nopp. Hotel Maadhini, Kanyakumari,\nTamil Nadu - 620702','9486163959','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query3);
           String query4="insert into accommodation values('Kanyakumari','8-September-2021','KK101','Hotel Ocean Heritage','3 Star Hotel','2, 11B, East Car Street,\nopp. Hotel Maadhini, Kanyakumari,\nTamil Nadu - 620702','9486163959','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query4);
           String query5="insert into accommodation values('Kanyakumari','9-September-2021','KK101','Hotel Ocean Heritage','3 Star Hotel','2, 11B, East Car Street,\nopp. Hotel Maadhini, Kanyakumari,\nTamil Nadu - 620702','9486163959','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query5);
           String query6="insert into accommodation values('Kanyakumari','5-September-2021','KK102','Hotel Sri Devi','2 Star Hotel','6/68, Main Rd,\nKanyakumari,\nTamil Nadu - 629702','9944839878','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query6);
           String query7="insert into accommodation values('Kanyakumari','6-September-2021','KK102','Hotel Sri Devi','2 Star Hotel','6/68, Main Rd,\nKanyakumari,\nTamil Nadu - 629702','9944839878','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query7);
           String query8="insert into accommodation values('Kanyakumari','7-September-2021','KK102','Hotel Sri Devi','2 Star Hotel','6/68, Main Rd,\nKanyakumari,\nTamil Nadu - 629702','9944839878','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query8);
           String query9="insert into accommodation values('Kanyakumari','8-September-2021','KK102','Hotel Sri Devi','2 Star Hotel','6/68, Main Rd,\nKanyakumari,\nTamil Nadu - 629702','9944839878','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query9);
           String query10="insert into accommodation values('Kanyakumari','9-September-2021','KK102','Hotel Sri Devi','2 Star Hotel','6/68, Main Rd,\nKanyakumari,\nTamil Nadu - 629702','9944839878','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query10);
           String query11="insert into accommodation values('Kanyakumari','5-September-2021','KK103','Tri Sea Hotel(P)Ltd','3 Star Hotel','Near Seashore,Kovalam Rd,\nKanyakumari,\nTamil Nadu - 629702','04652246586','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query11);
           String query12="insert into accommodation values('Kanyakumari','6-September-2021','KK103','Tri Sea Hotel(P)Ltd','3 Star Hotel','Near Seashore,Kovalam Rd,\nKanyakumari,\nTamil Nadu - 629702','04652246586','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query12);
           String query13="insert into accommodation values('Kanyakumari','7-September-2021','KK103','Tri Sea Hotel(P)Ltd','3 Star Hotel','Near Seashore,Kovalam Rd,\nKanyakumari,\nTamil Nadu - 629702','04652246586','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query13);
           String query14="insert into accommodation values('Kanyakumari','8-September-2021','KK103','Tri Sea Hotel(P)Ltd','3 Star Hotel','Near Seashore,Kovalam Rd,\nKanyakumari,\nTamil Nadu - 629702','04652246586','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query14);
           String query15="insert into accommodation values('Kanyakumari','9-September-2021','KK103','Tri Sea Hotel(P)Ltd','3 Star Hotel','Near Seashore,Kovalam Rd,\nKanyakumari,\nTamil Nadu - 629702','04652246586','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query15);
           String query16="insert into accommodation values('Kanyakumari','5-September-2021','KK104','Hotel Skyark','3 Star Hotel','17/60-D4, Opp Vivekananda Kendra,\nVivekanandapuram, Kanyakumari,\nTamil Nadu - 629702','8122246624','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query16);
           String query17="insert into accommodation values('Kanyakumari','6-September-2021','KK104','Hotel Skyark','3 Star Hotel','17/60-D4, Opp Vivekananda Kendra,\nVivekanandapuram, Kanyakumari,\nTamil Nadu - 629702','8122246624','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query17);
           String query18="insert into accommodation values('Kanyakumari','7-September-2021','KK104','Hotel Skyark','3 Star Hotel','17/60-D4, Opp Vivekananda Kendra,\nVivekanandapuram, Kanyakumari,\nTamil Nadu - 629702','8122246624','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query18);
           String query19="insert into accommodation values('Kanyakumari','8-September-2021','KK104','Hotel Skyark','3 Star Hotel','17/60-D4, Opp Vivekananda Kendra,\nVivekanandapuram, Kanyakumari,\nTamil Nadu - 629702','8122246624','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query19);
           String query20="insert into accommodation values('Kanyakumari','9-September-2021','KK104','Hotel Skyark','3 Star Hotel','17/60-D4, Opp Vivekananda Kendra,\nVivekanandapuram, Kanyakumari,\nTamil Nadu - 629702','8122246624','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query20);
           String query21="insert into accommodation values('Tanjore','5-September-2021','TJ101','Hotel Green Palace','3 Star Hotel','Trichy to Nagappattinam Highway,\nVilar Byepass,\nThanjavur - 613006.','8526333222','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query21);
           String query22="insert into accommodation values('Tanjore','6-September-2021','TJ101','Hotel Green Palace','3 Star Hotel','Trichy to Nagappattinam Highway,\nVilar Byepass,\nThanjavur - 613006.','8526333222','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query22);
           String query23="insert into accommodation values('Tanjore','7-September-2021','TJ101','Hotel Green Palace','3 Star Hotel','Trichy to Nagappattinam Highway,\nVilar Byepass,\nThanjavur - 613006.','8526333222','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query23);
           String query24="insert into accommodation values('Tanjore','8-September-2021','TJ101','Hotel Green Palace','3 Star Hotel','Trichy to Nagappattinam Highway,\nVilar Byepass,\nThanjavur - 613006.','8526333222','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query24);
           String query25="insert into accommodation values('Tanjore','9-September-2021','TJ101','Hotel Green Palace','3 Star Hotel','Trichy to Nagappattinam Highway,\nVilar Byepass,\nThanjavur - 613006.','8526333222','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query25);
           String query26="insert into accommodation values('Tanjore','5-September-2021','TJ102','Sangam Hotel','3 Star Hotel','Trichy Road,\nThanjavur,\nTamil Nadu - 613007','04362239451','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query26);
           String query27="insert into accommodation values('Tanjore','6-September-2021','TJ102','Sangam Hotel','3 Star Hotel','Trichy Road,\nThanjavur,\nTamil Nadu - 613007','04362239451','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query27);
           String query28="insert into accommodation values('Tanjore','7-September-2021','TJ102','Sangam Hotel','3 Star Hotel','Trichy Road,\nThanjavur,\nTamil Nadu - 613007','04362239451','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query28);
           String query29="insert into accommodation values('Tanjore','8-September-2021','TJ102','Sangam Hotel','3 Star Hotel','Trichy Road,\nThanjavur,\nTamil Nadu - 613007','04362239451','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query29);
           String query30="insert into accommodation values('Tanjore','9-September-2021','TJ102','Sangam Hotel','3 Star Hotel','Trichy Road,\nThanjavur,\nTamil Nadu - 613007','04362239451','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query30);
           String query31="insert into accommodation values('Tanjore','5-September-2021','TJ103','Hotel Victoriyah','2 Star Hotel','6th Cross Road Plot B1,\nNear Rohini hospital,\n613007 - Thanjavur','8870011164','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query31);
           String query32="insert into accommodation values('Tanjore','6-September-2021','TJ103','Hotel Victoriyah','2 Star Hotel','6th Cross Road Plot B1,\nNear Rohini hospital,\n613007 - Thanjavur','8870011164','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query32);
           String query33="insert into accommodation values('Tanjore','7-September-2021','TJ103','Hotel Victoriyah','2 Star Hotel','6th Cross Road Plot B1,\nNear Rohini hospital,\n613007 - Thanjavur','8870011164','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query33);
           String query34="insert into accommodation values('Tanjore','8-September-2021','TJ103','Hotel Victoriyah','2 Star Hotel','6th Cross Road Plot B1,\nNear Rohini hospital,\n613007 - Thanjavur','8870011164','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query34);
           String query35="insert into accommodation values('Tanjore','9-September-2021','TJ103','Hotel Victoriyah','2 Star Hotel','6th Cross Road Plot B1,\nNear Rohini hospital,\n613007 - Thanjavur','8870011164','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query35);
           String query36="insert into accommodation values('Tanjore','5-September-2021','TJ104','Grand Ashok','3 Star Hotel','RTO Office, Trichy Main Rd,\nThanjavur,\nTamil Nadu - 613403','04362266699','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query36);
           String query37="insert into accommodation values('Tanjore','6-September-2021','TJ104','Grand Ashok','3 Star Hotel','RTO Office, Trichy Main Rd,\nThanjavur,\nTamil Nadu - 613403','04362266699','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query37);
           String query38="insert into accommodation values('Tanjore','7-September-2021','TJ104','Grand Ashok','3 Star Hotel','RTO Office, Trichy Main Rd,\nThanjavur,\nTamil Nadu - 613403','04362266699','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query38);
           String query39="insert into accommodation values('Tanjore','8-September-2021','TJ104','Grand Ashok','3 Star Hotel','RTO Office, Trichy Main Rd,\nThanjavur,\nTamil Nadu - 613403','04362266699','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query39);
           String query40="insert into accommodation values('Tanjore','9-September-2021','TJ104','Grand Ashok','3 Star Hotel','RTO Office, Trichy Main Rd,\nThanjavur,\nTamil Nadu - 613403','04362266699','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query40);
           String query41="insert into accommodation values('Madurai','5-September-2021','MD101','Hotel Prem Nivas','2 Star Hotel','102, W Perumal Maistry St,\nMadurai Main,\nMadurai, Tamil Nadu - 625001','04522342532','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query41);
           String query42="insert into accommodation values('Madurai','6-September-2021','MD101','Hotel Prem Nivas','2 Star Hotel','102, W Perumal Maistry St,\nMadurai Main,\nMadurai, Tamil Nadu - 625001','04522342532','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query42);
           String query43="insert into accommodation values('Madurai','7-September-2021','MD101','Hotel Prem Nivas','2 Star Hotel','102, W Perumal Maistry St,\nMadurai Main,\nMadurai, Tamil Nadu - 625001','04522342532','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query43);
           String query44="insert into accommodation values('Madurai','8-September-2021','MD101','Hotel Prem Nivas','2 Star Hotel','102, W Perumal Maistry St,\nMadurai Main,\nMadurai, Tamil Nadu - 625001','04522342532','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query44);
           String query45="insert into accommodation values('Madurai','9-September-2021','MD101','Hotel Prem Nivas','2 Star Hotel','102, W Perumal Maistry St,\nMadurai Main,\nMadurai, Tamil Nadu - 625001','04522342532','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query45);
           String query46="insert into accommodation values('Madurai','5-September-2021','MD102','Treebo Trend Royal Elite','3 Star Hotel','12/1, Jawahar Rd,\nNear by Vadamalayan Hospital,\nChinna Chokikulam, Tamil Nadu - 625002','9322800100','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query46);
           String query47="insert into accommodation values('Madurai','6-September-2021','MD102','Treebo Trend Royal Elite','3 Star Hotel','12/1, Jawahar Rd,\nNear by Vadamalayan Hospital,\nChinna Chokikulam, Tamil Nadu - 625002','9322800100','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query47);
           String query48="insert into accommodation values('Madurai','7-September-2021','MD102','Treebo Trend Royal Elite','3 Star Hotel','12/1, Jawahar Rd,\nNear by Vadamalayan Hospital,\nChinna Chokikulam, Tamil Nadu - 625002','9322800100','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query48);
           String query49="insert into accommodation values('Madurai','8-September-2021','MD102','Treebo Trend Royal Elite','3 Star Hotel','12/1, Jawahar Rd,\nNear by Vadamalayan Hospital,\nChinna Chokikulam, Tamil Nadu - 625002','9322800100','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query49);
           String query50="insert into accommodation values('Madurai','9-September-2021','MD102','Treebo Trend Royal Elite','3 Star Hotel','12/1, Jawahar Rd,\nNear by Vadamalayan Hospital,\nChinna Chokikulam, Tamil Nadu - 625002','9322800100','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query50);
           String query51="insert into accommodation values('Madurai','5-September-2021','MD103','Hotel President','3 Star Hotel','8A, Yanaikkal St,\nSimmakkal, Madurai Main,\nMadurai, Tamil Nadu - 625001','9842170213','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query51);
           String query52="insert into accommodation values('Madurai','6-September-2021','MD103','Hotel President','3 Star Hotel','8A, Yanaikkal St,\nSimmakkal, Madurai Main,\nMadurai, Tamil Nadu - 625001','9842170213','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query52);
           String query53="insert into accommodation values('Madurai','7-September-2021','MD103','Hotel President','3 Star Hotel','8A, Yanaikkal St,\nSimmakkal, Madurai Main,\nMadurai, Tamil Nadu - 625001','9842170213','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query53);
           String query54="insert into accommodation values('Madurai','8-September-2021','MD103','Hotel President','3 Star Hotel','8A, Yanaikkal St,\nSimmakkal, Madurai Main,\nMadurai, Tamil Nadu - 625001','9842170213','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query54);
           String query55="insert into accommodation values('Madurai','9-September-2021','MD103','Hotel President','3 Star Hotel','8A, Yanaikkal St,\nSimmakkal, Madurai Main,\nMadurai, Tamil Nadu - 625001','9842170213','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query55);
           String query56="insert into accommodation values('Madurai','5-September-2021','MD104','Poppys Hotel Madurai','4 Star Hotel','122, Airport-Mattuthavani Ring Rd,\nMadurai,\nTamil Nadu - 625107','04524551555','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query56);
           String query57="insert into accommodation values('Madurai','6-September-2021','MD104','Poppys Hotel Madurai','4 Star Hotel','122, Airport-Mattuthavani Ring Rd,\nMadurai,\nTamil Nadu - 625107','04524551555','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query57);
           String query58="insert into accommodation values('Madurai','7-September-2021','MD104','Poppys Hotel Madurai','4 Star Hotel','122, Airport-Mattuthavani Ring Rd,\nMadurai,\nTamil Nadu - 625107','04524551555','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query58);
           String query59="insert into accommodation values('Madurai','8-September-2021','MD104','Poppys Hotel Madurai','4 Star Hotel','122, Airport-Mattuthavani Ring Rd,\nMadurai,\nTamil Nadu - 625107','04524551555','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query59);
           String query60="insert into accommodation values('Madurai','9-September-2021','MD104','Poppys Hotel Madurai','4 Star Hotel','122, Airport-Mattuthavani Ring Rd,\nMadurai,\nTamil Nadu - 625107','04524551555','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query60);
           String query61="insert into accommodation values('Salem','5-September-2021','SM101','Radisson Salem','4 Star Hotel','157/3-A, Bangalore Highway,\nMamangam, Salem,\nTamil Nadu - 636302','18001080333','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query61);
           String query62="insert into accommodation values('Salem','6-September-2021','SM101','Radisson Salem','4 Star Hotel','157/3-A, Bangalore Highway,\nMamangam, Salem,\nTamil Nadu - 636302','18001080333','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query62);
           String query63="insert into accommodation values('Salem','7-September-2021','SM101','Radisson Salem','4 Star Hotel','157/3-A, Bangalore Highway,\nMamangam, Salem,\nTamil Nadu - 636302','18001080333','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query63);
           String query64="insert into accommodation values('Salem','8-September-2021','SM101','Radisson Salem','4 Star Hotel','157/3-A, Bangalore Highway,\nMamangam, Salem,\nTamil Nadu - 636302','18001080333','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query64);
           String query65="insert into accommodation values('Salem','9-September-2021','SM101','Radisson Salem','4 Star Hotel','157/3-A, Bangalore Highway,\nMamangam, Salem,\nTamil Nadu - 636302','18001080333','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query65);
           String query66="insert into accommodation values('Salem','5-September-2021','SM102','Cj Pallazzio','4 Star Hotel','201/6, Junction Main Rd,\nState Bank Colony, Meyyanur,\nSalem, Tamil Nadu - 636005','04272556677','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query66);
           String query67="insert into accommodation values('Salem','6-September-2021','SM102','Cj Pallazzio','4 Star Hotel','201/6, Junction Main Rd,\nState Bank Colony, Meyyanur,\nSalem, Tamil Nadu - 636005','04272556677','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query67);
           String query68="insert into accommodation values('Salem','7-September-2021','SM102','Cj Pallazzio','4 Star Hotel','201/6, Junction Main Rd,\nState Bank Colony, Meyyanur,\nSalem, Tamil Nadu - 636005','04272556677','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query68);
           String query69="insert into accommodation values('Salem','8-September-2021','SM102','Cj Pallazzio','4 Star Hotel','201/6, Junction Main Rd,\nState Bank Colony, Meyyanur,\nSalem, Tamil Nadu - 636005','04272556677','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query69);
           String query70="insert into accommodation values('Salem','9-September-2021','SM102','Cj Pallazzio','4 Star Hotel','201/6, Junction Main Rd,\nState Bank Colony, Meyyanur,\nSalem, Tamil Nadu - 636005','04272556677','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query70);
           String query71="insert into accommodation values('Salem','5-September-2021','SM103','Hotel Green Ridge','3 Star Hotel','15/1,Chennekothapalli Rd,Near Dharan Hospital,\nSelva Nagar, Chinnusamy Nagar,Seelanaickenpatti,\nSalem, Tamil Nadu - 636201','8098202600','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query71);
           String query72="insert into accommodation values('Salem','6-September-2021','SM103','Hotel Green Ridge','3 Star Hotel','15/1,Chennekothapalli Rd,Near Dharan Hospital,\nSelva Nagar, Chinnusamy Nagar,Seelanaickenpatti,\nSalem, Tamil Nadu - 636201','8098202600','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query72);
           String query73="insert into accommodation values('Salem','7-September-2021','SM103','Hotel Green Ridge','3 Star Hotel','15/1,Chennekothapalli Rd,Near Dharan Hospital,\nSelva Nagar, Chinnusamy Nagar,Seelanaickenpatti,\nSalem, Tamil Nadu - 636201','8098202600','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query73);
           String query74="insert into accommodation values('Salem','8-September-2021','SM103','Hotel Green Ridge','3 Star Hotel','15/1,Chennekothapalli Rd,Near Dharan Hospital,\nSelva Nagar, Chinnusamy Nagar,Seelanaickenpatti,\nSalem, Tamil Nadu - 636201','8098202600','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query74);
           String query75="insert into accommodation values('Salem','9-September-2021','SM103','Hotel Green Ridge','3 Star Hotel','15/1,Chennekothapalli Rd,Near Dharan Hospital,\nSelva Nagar, Chinnusamy Nagar,Seelanaickenpatti,\nSalem, Tamil Nadu - 636201','8098202600','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query75);
           String query76="insert into accommodation values('Salem','5-September-2021','SM104','Kirthika Palace - Grow Hotels','3 Star Hotel','Rajiv Gandhi St,\nMeyyanur, Salem,\nTamil Nadu - 636005','9443124454','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query76);
           String query77="insert into accommodation values('Salem','6-September-2021','SM104','Kirthika Palace - Grow Hotels','3 Star Hotel','Rajiv Gandhi St,\nMeyyanur, Salem,\nTamil Nadu - 636005','9443124454','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query77);
           String query78="insert into accommodation values('Salem','7-September-2021','SM104','Kirthika Palace - Grow Hotels','3 Star Hotel','Rajiv Gandhi St,\nMeyyanur, Salem,\nTamil Nadu - 636005','9443124454','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query78);
           String query79="insert into accommodation values('Salem','8-September-2021','SM104','Kirthika Palace - Grow Hotels','3 Star Hotel','Rajiv Gandhi St,\nMeyyanur, Salem,\nTamil Nadu - 636005','9443124454','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query79);
           String query80="insert into accommodation values('Salem','9-September-2021','SM104','Kirthika Palace - Grow Hotels','3 Star Hotel','Rajiv Gandhi St,\nMeyyanur, Salem,\nTamil Nadu - 636005','9443124454','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query80);
           String query81="insert into accommodation values('Dindigul','5-September-2021','DG101','Vivera Grand Hotel','3 Star Hotel','19, Palani Rd, New Agraharam,\nGovindapuram, Dindigul,\nTamil Nadu - 624001','9659000001','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query81);
           String query82="insert into accommodation values('Dindigul','6-September-2021','DG101','Vivera Grand Hotel','3 Star Hotel','19, Palani Rd, New Agraharam,\nGovindapuram, Dindigul,\nTamil Nadu - 624001','9659000001','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query82);
           String query83="insert into accommodation values('Dindigul','7-September-2021','DG101','Vivera Grand Hotel','3 Star Hotel','19, Palani Rd, New Agraharam,\nGovindapuram, Dindigul,\nTamil Nadu - 624001','9659000001','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query83);
           String query84="insert into accommodation values('Dindigul','8-September-2021','DG101','Vivera Grand Hotel','3 Star Hotel','19, Palani Rd, New Agraharam,\nGovindapuram, Dindigul,\nTamil Nadu - 624001','9659000001','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query84);
           String query85="insert into accommodation values('Dindigul','9-September-2021','DG101','Vivera Grand Hotel','3 Star Hotel','19, Palani Rd, New Agraharam,\nGovindapuram, Dindigul,\nTamil Nadu - 624001','9659000001','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query85);
           String query86="insert into accommodation values('Dindigul','5-September-2021','DG102','Hotel Chenduran Park','2 Star Hotel','Near, 311, Old R.M.S Road,\nRailway Station Rd, Nagal Nagar,\nTamil Nadu - 624001','04512441200','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query86);
           String query87="insert into accommodation values('Dindigul','6-September-2021','DG102','Hotel Chenduran Park','2 Star Hotel','Near, 311, Old R.M.S Road,\nRailway Station Rd, Nagal Nagar,\nTamil Nadu - 624001','04512441200','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query87);
           String query88="insert into accommodation values('Dindigul','7-September-2021','DG102','Hotel Chenduran Park','2 Star Hotel','Near, 311, Old R.M.S Road,\nRailway Station Rd, Nagal Nagar,\nTamil Nadu - 624001','04512441200','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query88);
           String query89="insert into accommodation values('Dindigul','8-September-2021','DG102','Hotel Chenduran Park','2 Star Hotel','Near, 311, Old R.M.S Road,\nRailway Station Rd, Nagal Nagar,\nTamil Nadu - 624001','04512441200','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query89);
           String query90="insert into accommodation values('Dindigul','9-September-2021','DG102','Hotel Chenduran Park','2 Star Hotel','Near, 311, Old R.M.S Road,\nRailway Station Rd, Nagal Nagar,\nTamil Nadu - 624001','04512441200','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query90);
           String query91="insert into accommodation values('Dindigul','5-September-2021','DG103','Hotel Parsons Court','3 Star Hotel','85, Mengles Rd,\nMendonsa Colony, Nagal Nagar,\nTamil Nadu - 624003','9677702007','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query91);
           String query92="insert into accommodation values('Dindigul','6-September-2021','DG103','Hotel Parsons Court','3 Star Hotel','85, Mengles Rd,\nMendonsa Colony, Nagal Nagar,\nTamil Nadu - 624003','9677702007','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query92);
           String query93="insert into accommodation values('Dindigul','7-September-2021','DG103','Hotel Parsons Court','3 Star Hotel','85, Mengles Rd,\nMendonsa Colony, Nagal Nagar,\nTamil Nadu - 624003','9677702007','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query93);
           String query94="insert into accommodation values('Dindigul','8-September-2021','DG103','Hotel Parsons Court','3 Star Hotel','85, Mengles Rd,\nMendonsa Colony, Nagal Nagar,\nTamil Nadu - 624003','9677702007','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query94);
           String query95="insert into accommodation values('Dindigul','9-September-2021','DG103','Hotel Parsons Court','3 Star Hotel','85, Mengles Rd,\nMendonsa Colony, Nagal Nagar,\nTamil Nadu - 624003','9677702007','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query95);
           String query96="insert into accommodation values('Dindigul','5-September-2021','DG104','Hotel Vales Park ','2 Star Hotel','No.49-A,Mengles Road,\nNagal Nagar, Dindigul,\nTamil Nadu - 624003','04512420943','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query96);
           String query97="insert into accommodation values('Dindigul','6-September-2021','DG104','Hotel Vales Park ','2 Star Hotel','No.49-A,Mengles Road,\nNagal Nagar, Dindigul,\nTamil Nadu - 624003','04512420943','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query97);
           String query98="insert into accommodation values('Dindigul','7-September-2021','DG104','Hotel Vales Park ','2 Star Hotel','No.49-A,Mengles Road,\nNagal Nagar, Dindigul,\nTamil Nadu - 624003','04512420943','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query98);
           String query99="insert into accommodation values('Dindigul','8-September-2021','DG104','Hotel Vales Park ','2 Star Hotel','No.49-A,Mengles Road,\nNagal Nagar, Dindigul,\nTamil Nadu - 624003','04512420943','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query99);
           String query100="insert into accommodation values('Dindigul','9-September-2021','DG104','Hotel Vales Park ','2 Star Hotel','No.49-A,Mengles Road,\nNagal Nagar, Dindigul,\nTamil Nadu - 624003','04512420943','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query100);
           String query101="insert into accommodation values('Nilgiris','5-September-2021','NS101','Silver Spruce Entire Nature Resort','4 Star Resort','3/119 A9, Pear Garden,\nThanthanadu Village, Kotagiri,\nTamil Nadu - 643217','7867045212','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query101);
           String query102="insert into accommodation values('Nilgiris','6-September-2021','NS101','Silver Spruce Entire Nature Resort','4 Star Resort','3/119 A9, Pear Garden,\nThanthanadu Village, Kotagiri,\nTamil Nadu - 643217','7867045212','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query102);
           String query103="insert into accommodation values('Nilgiris','7-September-2021','NS101','Silver Spruce Entire Nature Resort','4 Star Resort','3/119 A9, Pear Garden,\nThanthanadu Village, Kotagiri,\nTamil Nadu - 643217','7867045212','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query103);
           String query104="insert into accommodation values('Nilgiris','8-September-2021','NS101','Silver Spruce Entire Nature Resort','4 Star Resort','3/119 A9, Pear Garden,\nThanthanadu Village, Kotagiri,\nTamil Nadu - 643217','7867045212','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query104);
           String query105="insert into accommodation values('Nilgiris','9-September-2021','NS101','Silver Spruce Entire Nature Resort','4 Star Resort','3/119 A9, Pear Garden,\nThanthanadu Village, Kotagiri,\nTamil Nadu - 643217','7867045212','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query105);
           String query106="insert into accommodation values('Nilgiris','5-September-2021','NS102','Hanging Huts Resorts','4 Star Resorts','5/32, Thabbacombai,\nAracode,\nTamil Nadu - 643217','9042958500','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query106);
           String query107="insert into accommodation values('Nilgiris','6-September-2021','NS102','Hanging Huts Resorts','4 Star Resorts','5/32, Thabbacombai,\nAracode,\nTamil Nadu - 643217','9042958500','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query107);
           String query108="insert into accommodation values('Nilgiris','7-September-2021','NS102','Hanging Huts Resorts','4 Star Resorts','5/32, Thabbacombai,\nAracode,\nTamil Nadu - 643217','9042958500','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query108);
           String query109="insert into accommodation values('Nilgiris','8-September-2021','NS102','Hanging Huts Resorts','4 Star Resorts','5/32, Thabbacombai,\nAracode,\nTamil Nadu - 643217','9042958500','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query109);
           String query110="insert into accommodation values('Nilgiris','9-September-2021','NS102','Hanging Huts Resorts','4 Star Resorts','5/32, Thabbacombai,\nAracode,\nTamil Nadu - 643217','9042958500','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query110);
           String query111="insert into accommodation values('Nilgiris','5-September-2021','NS103','Rayne Forest','3 Star Hotel','Orion, Groves Hill Rd,\nKotagiri,\nTamil Nadu - 643217','9962000061','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query111);
           String query112="insert into accommodation values('Nilgiris','6-September-2021','NS103','Rayne Forest','3 Star Hotel','Orion, Groves Hill Rd,\nKotagiri,\nTamil Nadu - 643217','9962000061','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query112);
           String query113="insert into accommodation values('Nilgiris','7-September-2021','NS103','Rayne Forest','3 Star Hotel','Orion, Groves Hill Rd,\nKotagiri,\nTamil Nadu - 643217','9962000061','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query113);
           String query114="insert into accommodation values('Nilgiris','8-September-2021','NS103','Rayne Forest','3 Star Hotel','Orion, Groves Hill Rd,\nKotagiri,\nTamil Nadu - 643217','9962000061','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query114);
           String query115="insert into accommodation values('Nilgiris','9-September-2021','NS103','Rayne Forest','3 Star Hotel','Orion, Groves Hill Rd,\nKotagiri,\nTamil Nadu - 643217','9962000061','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query115);
           String query116="insert into accommodation values('Nilgiris','5-September-2021','NS104','Apple Breeze Resort','3 Star Resort','Kota Hall Rd,\nKotagiri,\nTamil Nadu - 643217','9488274141','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query116);
           String query117="insert into accommodation values('Nilgiris','6-September-2021','NS104','Apple Breeze Resort','3 Star Resort','Kota Hall Rd,\nKotagiri,\nTamil Nadu - 643217','9488274141','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query117);
           String query118="insert into accommodation values('Nilgiris','7-September-2021','NS104','Apple Breeze Resort','3 Star Resort','Kota Hall Rd,\nKotagiri,\nTamil Nadu - 643217','9488274141','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query118);
           String query119="insert into accommodation values('Nilgiris','8-September-2021','NS104','Apple Breeze Resort','3 Star Resort','Kota Hall Rd,\nKotagiri,\nTamil Nadu - 643217','9488274141','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query119);
           String query120="insert into accommodation values('Nilgiris','9-September-2021','NS104','Apple Breeze Resort','3 Star Resort','Kota Hall Rd,\nKotagiri,\nTamil Nadu - 643217','9488274141','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query120);
           String query121="insert into accommodation values('Chidambaram','5-September-2021','CD101','Hotel Saradharam','3 Star Hotel','19, VGP St,\nChidambaram,\nTamil Nadu - 608001','9442591475','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query121);
           String query122="insert into accommodation values('Chidambaram','6-September-2021','CD101','Hotel Saradharam','3 Star Hotel','19, VGP St,\nChidambaram,\nTamil Nadu - 608001','9442591475','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query122);
           String query123="insert into accommodation values('Chidambaram','7-September-2021','CD101','Hotel Saradharam','3 Star Hotel','19, VGP St,\nChidambaram,\nTamil Nadu - 608001','9442591475','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query123);
           String query124="insert into accommodation values('Chidambaram','8-September-2021','CD101','Hotel Saradharam','3 Star Hotel','19, VGP St,\nChidambaram,\nTamil Nadu - 608001','9442591475','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query124);
           String query125="insert into accommodation values('Chidambaram','9-September-2021','CD101','Hotel Saradharam','3 Star Hotel','19, VGP St,\nChidambaram,\nTamil Nadu - 608001','9442591475','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query125);
           String query126="insert into accommodation values('Chidambaram','5-September-2021','CD102','The Grand Park Hotel','3 Star Hotel','59, East Car Street,\nNear Natarajar Temple, Chidambaram,\nTamil Nadu - 608001','9488370859','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query126);
           String query127="insert into accommodation values('Chidambaram','6-September-2021','CD102','The Grand Park Hotel','3 Star Hotel','59, East Car Street,\nNear Natarajar Temple, Chidambaram,\nTamil Nadu - 608001','9488370859','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query127);
           String query128="insert into accommodation values('Chidambaram','7-September-2021','CD102','The Grand Park Hotel','3 Star Hotel','59, East Car Street,\nNear Natarajar Temple, Chidambaram,\nTamil Nadu - 608001','9488370859','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query128);
           String query129="insert into accommodation values('Chidambaram','8-September-2021','CD102','The Grand Park Hotel','3 Star Hotel','59, East Car Street,\nNear Natarajar Temple, Chidambaram,\nTamil Nadu - 608001','9488370859','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query129);
           String query130="insert into accommodation values('Chidambaram','9-September-2021','CD102','The Grand Park Hotel','3 Star Hotel','59, East Car Street,\nNear Natarajar Temple, Chidambaram,\nTamil Nadu - 608001','9488370859','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query130);
           String query131="insert into accommodation values('Chidambaram','5-September-2021','CD103','Vandayar Hotel','3 Star Hotel','12, V.G.P. Street,\nChidambaram,\nTamil Nadu - 608001','9487775374','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query131);
           String query132="insert into accommodation values('Chidambaram','6-September-2021','CD103','Vandayar Hotel','3 Star Hotel','12, V.G.P. Street,\nChidambaram,\nTamil Nadu - 608001','9487775374','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query132);
           String query133="insert into accommodation values('Chidambaram','7-September-2021','CD103','Vandayar Hotel','3 Star Hotel','12, V.G.P. Street,\nChidambaram,\nTamil Nadu - 608001','9487775374','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query133);
           String query134="insert into accommodation values('Chidambaram','8-September-2021','CD103','Vandayar Hotel','3 Star Hotel','12, V.G.P. Street,\nChidambaram,\nTamil Nadu - 608001','9487775374','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query134);
           String query135="insert into accommodation values('Chidambaram','9-September-2021','CD103','Vandayar Hotel','3 Star Hotel','12, V.G.P. Street,\nChidambaram,\nTamil Nadu - 608001','9487775374','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query135);
           String query136="insert into accommodation values('Chidambaram','5-September-2021','CD104','MANSOOR LODGE','2 Star Hotel','91, E Car St,\nChidambaram,\nTamil Nadu - 608001','9443339446','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query136);
           String query137="insert into accommodation values('Chidambaram','6-September-2021','CD104','MANSOOR LODGE','2 Star Hotel','91, E Car St,\nChidambaram,\nTamil Nadu - 608001','9443339446','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query137);
           String query138="insert into accommodation values('Chidambaram','7-September-2021','CD104','MANSOOR LODGE','2 Star Hotel','91, E Car St,\nChidambaram,\nTamil Nadu - 608001','9443339446','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query138);
           String query139="insert into accommodation values('Chidambaram','8-September-2021','CD104','MANSOOR LODGE','2 Star Hotel','91, E Car St,\nChidambaram,\nTamil Nadu - 608001','9443339446','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query139);
           String query140="insert into accommodation values('Chidambaram','9-September-2021','CD104','MANSOOR LODGE','2 Star Hotel','91, E Car St,\nChidambaram,\nTamil Nadu - 608001','9443339446','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query140);
           String query141="insert into accommodation values('Chennai','5-September-2021','CN101','Taz Kamar Family Hotel','3 Star Hotel','36, Rangan St, Postal Colony,\nT. Nagar, Chennai,\nTamil Nadu - 600017','04424342290','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query141);
           String query142="insert into accommodation values('Chennai','6-September-2021','CN101','Taz Kamar Family Hotel','3 Star Hotel','36, Rangan St, Postal Colony,\nT. Nagar, Chennai,\nTamil Nadu - 600017','04424342290','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query142);
           String query143="insert into accommodation values('Chennai','7-September-2021','CN101','Taz Kamar Family Hotel','3 Star Hotel','36, Rangan St, Postal Colony,\nT. Nagar, Chennai,\nTamil Nadu - 600017','04424342290','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query143);
           String query144="insert into accommodation values('Chennai','8-September-2021','CN101','Taz Kamar Family Hotel','3 Star Hotel','36, Rangan St, Postal Colony,\nT. Nagar, Chennai,\nTamil Nadu - 600017','04424342290','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query144);
           String query145="insert into accommodation values('Chennai','9-September-2021','CN101','Taz Kamar Family Hotel','3 Star Hotel','36, Rangan St, Postal Colony,\nT. Nagar, Chennai,\nTamil Nadu - 600017','04424342290','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query145);
           String query146="insert into accommodation values('Chennai','5-September-2021','CN102','Novotel Chennai Chamiers Road','5 Star Hotel','City Centre, Near Boat Club and\nAnna Salai, Nandanam,\nChennai, Tamil Nadu - 600035','04424302333','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query146);
           String query147="insert into accommodation values('Chennai','6-September-2021','CN102','Novotel Chennai Chamiers Road','5 Star Hotel','City Centre, Near Boat Club and\nAnna Salai, Nandanam,\nChennai, Tamil Nadu - 600035','04424302333','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query147);
           String query148="insert into accommodation values('Chennai','7-September-2021','CN102','Novotel Chennai Chamiers Road','5 Star Hotel','City Centre, Near Boat Club and\nAnna Salai, Nandanam,\nChennai, Tamil Nadu - 600035','04424302333','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query148);
           String query149="insert into accommodation values('Chennai','8-September-2021','CN102','Novotel Chennai Chamiers Road','5 Star Hotel','City Centre, Near Boat Club and\nAnna Salai, Nandanam,\nChennai, Tamil Nadu - 600035','04424302333','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query149);
           String query150="insert into accommodation values('Chennai','9-September-2021','CN102','Novotel Chennai Chamiers Road','5 Star Hotel','City Centre, Near Boat Club and\nAnna Salai, Nandanam,\nChennai, Tamil Nadu - 600035','04424302333','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query150);
           String query151="insert into accommodation values('Chennai','5-September-2021','CN103','Citadines OMR Chennai','4 Star Hotel','Rajiv Gandhi Salai(OMR), Sholinganallur,\n290, Rajiv Gandhi IT Expy,\nChennai, Tamil Nadu - 600119','04471117111','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query151);
           String query152="insert into accommodation values('Chennai','6-September-2021','CN103','Citadines OMR Chennai','4 Star Hotel','Rajiv Gandhi Salai(OMR), Sholinganallur,\n290, Rajiv Gandhi IT Expy,\nChennai, Tamil Nadu - 600119','04471117111','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query152);
           String query153="insert into accommodation values('Chennai','7-September-2021','CN103','Citadines OMR Chennai','4 Star Hotel','Rajiv Gandhi Salai(OMR), Sholinganallur,\n290, Rajiv Gandhi IT Expy,\nChennai, Tamil Nadu - 600119','04471117111','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query153);
           String query154="insert into accommodation values('Chennai','8-September-2021','CN103','Citadines OMR Chennai','4 Star Hotel','Rajiv Gandhi Salai(OMR), Sholinganallur,\n290, Rajiv Gandhi IT Expy,\nChennai, Tamil Nadu - 600119','04471117111','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query154);
           String query155="insert into accommodation values('Chennai','9-September-2021','CN103','Citadines OMR Chennai','4 Star Hotel','Rajiv Gandhi Salai(OMR), Sholinganallur,\n290, Rajiv Gandhi IT Expy,\nChennai, Tamil Nadu - 600119','04471117111','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query155);
           String query156="insert into accommodation values('Chennai','5-September-2021','CN104','Courtyard by Marriott','4 Star Hotel','564, Anna Salai,\nThiru Vi Ka Kudiyiruppu,Teynampet,\nChennai, Tamil Nadu - 600018','04466764000','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query156);
           String query157="insert into accommodation values('Chennai','6-September-2021','CN104','Courtyard by Marriott','4 Star Hotel','564, Anna Salai,\nThiru Vi Ka Kudiyiruppu,Teynampet,\nChennai, Tamil Nadu - 600018','04466764000','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query157);
           String query158="insert into accommodation values('Chennai','7-September-2021','CN104','Courtyard by Marriott','4 Star Hotel','564, Anna Salai,\nThiru Vi Ka Kudiyiruppu,Teynampet,\nChennai, Tamil Nadu - 600018','04466764000','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query158);
           String query159="insert into accommodation values('Chennai','8-September-2021','CN104','Courtyard by Marriott','4 Star Hotel','564, Anna Salai,\nThiru Vi Ka Kudiyiruppu,Teynampet,\nChennai, Tamil Nadu - 600018','04466764000','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query159);
           String query160="insert into accommodation values('Chennai','9-September-2021','CN104','Courtyard by Marriott','4 Star Hotel','564, Anna Salai,\nThiru Vi Ka Kudiyiruppu,Teynampet,\nChennai, Tamil Nadu - 600018','04466764000','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query160);
           String query161="insert into accommodation values('Chengalpattu','5-September-2021','CG101','Fairfield by Marriott Chennai Mahindra World City','4 Star Hotel','Near, Main Entrance,\nMahindra World City,\nChennai, Tamil Nadu - 603002','04445406699','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query161);
           String query162="insert into accommodation values('Chengalpattu','6-September-2021','CG101','Fairfield by Marriott Chennai Mahindra World City','4 Star Hotel','Near, Main Entrance,\nMahindra World City,\nChennai, Tamil Nadu - 603002','04445406699','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query162);
           String query163="insert into accommodation values('Chengalpattu','7-September-2021','CG101','Fairfield by Marriott Chennai Mahindra World City','4 Star Hotel','Near, Main Entrance,\nMahindra World City,\nChennai, Tamil Nadu - 603002','04445406699','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query163);
           String query164="insert into accommodation values('Chengalpattu','8-September-2021','CG101','Fairfield by Marriott Chennai Mahindra World City','4 Star Hotel','Near, Main Entrance,\nMahindra World City,\nChennai, Tamil Nadu - 603002','04445406699','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query164);
           String query165="insert into accommodation values('Chengalpattu','9-September-2021','CG101','Fairfield by Marriott Chennai Mahindra World City','4 Star Hotel','Near, Main Entrance,\nMahindra World City,\nChennai, Tamil Nadu - 603002','04445406699','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query165);
           String query166="insert into accommodation values('Chengalpattu','5-September-2021','CG102','Ranga Residency','3 Star Hotel','No.7, Alagesan Rd,\nVedachalam Nagar, Chengalpattu,\nTamil Nadu - 603001','8056034999','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query166);
           String query167="insert into accommodation values('Chengalpattu','6-September-2021','CG102','Ranga Residency','3 Star Hotel','No.7, Alagesan Rd,\nVedachalam Nagar, Chengalpattu,\nTamil Nadu - 603001','8056034999','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query167);
           String query168="insert into accommodation values('Chengalpattu','7-September-2021','CG102','Ranga Residency','3 Star Hotel','No.7, Alagesan Rd,\nVedachalam Nagar, Chengalpattu,\nTamil Nadu - 603001','8056034999','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query168);
           String query169="insert into accommodation values('Chengalpattu','8-September-2021','CG102','Ranga Residency','3 Star Hotel','No.7, Alagesan Rd,\nVedachalam Nagar, Chengalpattu,\nTamil Nadu - 603001','8056034999','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query169);
           String query170="insert into accommodation values('Chengalpattu','9-September-2021','CG102','Ranga Residency','3 Star Hotel','No.7, Alagesan Rd,\nVedachalam Nagar, Chengalpattu,\nTamil Nadu - 603001','8056034999','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query170);
           String query171="insert into accommodation values('Chengalpattu','5-September-2021','CG103','Hotel Vassi Palaze','3 Star Hotel','Plot No.3 CMDA Town Centre,\nKattankulathur, Maraimalai Nagar,\nTamil Nadu - 603203','9176657108','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query171);
           String query172="insert into accommodation values('Chengalpattu','6-September-2021','CG103','Hotel Vassi Palaze','3 Star Hotel','Plot No.3 CMDA Town Centre,\nKattankulathur, Maraimalai Nagar,\nTamil Nadu - 603203','9176657108','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query172);
           String query173="insert into accommodation values('Chengalpattu','7-September-2021','CG103','Hotel Vassi Palaze','3 Star Hotel','Plot No.3 CMDA Town Centre,\nKattankulathur, Maraimalai Nagar,\nTamil Nadu - 603203','9176657108','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query173);
           String query174="insert into accommodation values('Chengalpattu','8-September-2021','CG103','Hotel Vassi Palaze','3 Star Hotel','Plot No.3 CMDA Town Centre,\nKattankulathur, Maraimalai Nagar,\nTamil Nadu - 603203','9176657108','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query174);
           String query175="insert into accommodation values('Chengalpattu','9-September-2021','CG103','Hotel Vassi Palaze','3 Star Hotel','Plot No.3 CMDA Town Centre,\nKattankulathur, Maraimalai Nagar,\nTamil Nadu - 603203','9176657108','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query175);
           String query176="insert into accommodation values('Chengalpattu','5-September-2021','CG104','Bakya Slot - Luxury Rooms','4 Star Hotel','HIG-41, Vallal MGR Salai,\nGrand Southern Trunk Rd, Maraimalai Nagar,\nTamil Nadu - 603209','7305081971','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query176);
           String query177="insert into accommodation values('Chengalpattu','6-September-2021','CG104','Bakya Slot - Luxury Rooms','4 Star Hotel','HIG-41, Vallal MGR Salai,\nGrand Southern Trunk Rd, Maraimalai Nagar,\nTamil Nadu - 603209','7305081971','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query177);
           String query178="insert into accommodation values('Chengalpattu','7-September-2021','CG104','Bakya Slot - Luxury Rooms','4 Star Hotel','HIG-41, Vallal MGR Salai,\nGrand Southern Trunk Rd, Maraimalai Nagar,\nTamil Nadu - 603209','7305081971','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query178);
           String query179="insert into accommodation values('Chengalpattu','8-September-2021','CG104','Bakya Slot - Luxury Rooms','4 Star Hotel','HIG-41, Vallal MGR Salai,\nGrand Southern Trunk Rd, Maraimalai Nagar,\nTamil Nadu - 603209','7305081971','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query179);
           String query180="insert into accommodation values('Chengalpattu','9-September-2021','CG104','Bakya Slot - Luxury Rooms','4 Star Hotel','HIG-41, Vallal MGR Salai,\nGrand Southern Trunk Rd, Maraimalai Nagar,\nTamil Nadu - 603209','7305081971','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query180);
           String query181="insert into accommodation values('Ramanathapuram','5-September-2021','RP101','Viceroy Residency Manor','2 Star Hotel','45/1a2 b Saakkarakottai Village,\nBharathi nagar,\nRamanathapuram - 623503','04567239999','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query181);
           String query182="insert into accommodation values('Ramanathapuram','6-September-2021','RP101','Viceroy Residency Manor','2 Star Hotel','45/1a2 b Saakkarakottai Village,\nBharathi nagar,\nRamanathapuram - 623503','04567239999','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query182);
           String query183="insert into accommodation values('Ramanathapuram','7-September-2021','RP101','Viceroy Residency Manor','2 Star Hotel','45/1a2 b Saakkarakottai Village,\nBharathi nagar,\nRamanathapuram - 623503','04567239999','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query183);
           String query184="insert into accommodation values('Ramanathapuram','8-September-2021','RP101','Viceroy Residency Manor','2 Star Hotel','45/1a2 b Saakkarakottai Village,\nBharathi nagar,\nRamanathapuram - 623503','04567239999','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query184);
           String query185="insert into accommodation values('Ramanathapuram','9-September-2021','RP101','Viceroy Residency Manor','2 Star Hotel','45/1a2 b Saakkarakottai Village,\nBharathi nagar,\nRamanathapuram - 623503','04567239999','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query185);
           String query186="insert into accommodation values('Ramanathapuram','5-September-2021','RP102','Hotel Rameswaram KNP Nest','2 Star Hotel','14 Kattupillayar Kovil Street,\nNext to Bharat Sevasrama Sangham,\nRameswaram, Tamil Nadu-623526','9047898979','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query186);
           String query187="insert into accommodation values('Ramanathapuram','6-September-2021','RP102','Hotel Rameswaram KNP Nest','2 Star Hotel','14 Kattupillayar Kovil Street,\nNext to Bharat Sevasrama Sangham,\nRameswaram, Tamil Nadu-623526','9047898979','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query187);
           String query188="insert into accommodation values('Ramanathapuram','7-September-2021','RP102','Hotel Rameswaram KNP Nest','2 Star Hotel','14 Kattupillayar Kovil Street,\nNext to Bharat Sevasrama Sangham,\nRameswaram, Tamil Nadu-623526','9047898979','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query188);
           String query189="insert into accommodation values('Ramanathapuram','8-September-2021','RP102','Hotel Rameswaram KNP Nest','2 Star Hotel','14 Kattupillayar Kovil Street,\nNext to Bharat Sevasrama Sangham,\nRameswaram, Tamil Nadu-623526','9047898979','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query189);
           String query190="insert into accommodation values('Ramanathapuram','9-September-2021','RP102','Hotel Rameswaram KNP Nest','2 Star Hotel','14 Kattupillayar Kovil Street,\nNext to Bharat Sevasrama Sangham,\nRameswaram, Tamil Nadu-623526','9047898979','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query190);
           String query191="insert into accommodation values('Ramanathapuram','5-September-2021','RP103','Chakraa Residency','2 Star Hotel','Kochi Dhanushkodi Road(G.H. ROAD),\nOpp.B-1 Police Station,\nRamanathapuram, Tamil Nadu 623501','9488922666','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query191);
           String query192="insert into accommodation values('Ramanathapuram','6-September-2021','RP103','Chakraa Residency','2 Star Hotel','Kochi Dhanushkodi Road(G.H. ROAD),\nOpp.B-1 Police Station,\nRamanathapuram, Tamil Nadu 623501','9488922666','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query192);
           String query193="insert into accommodation values('Ramanathapuram','7-September-2021','RP103','Chakraa Residency','2 Star Hotel','Kochi Dhanushkodi Road(G.H. ROAD),\nOpp.B-1 Police Station,\nRamanathapuram, Tamil Nadu 623501','9488922666','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query193);
           String query194="insert into accommodation values('Ramanathapuram','8-September-2021','RP103','Chakraa Residency','2 Star Hotel','Kochi Dhanushkodi Road(G.H. ROAD),\nOpp.B-1 Police Station,\nRamanathapuram, Tamil Nadu 623501','9488922666','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query194);
           String query195="insert into accommodation values('Ramanathapuram','9-September-2021','RP103','Chakraa Residency','2 Star Hotel','Kochi Dhanushkodi Road(G.H. ROAD),\nOpp.B-1 Police Station,\nRamanathapuram, Tamil Nadu 623501','9488922666','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query195);
           String query196="insert into accommodation values('Ramanathapuram','5-September-2021','RP104','AWINCO INTERNATIONAL IN','3 Star Hotel','1/2795, Mandapam Road,\nAdam Nagar(Near Old Check Post),\nPattinamkathan, Ramanthapuram.','04567231111','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query196);
           String query197="insert into accommodation values('Ramanathapuram','6-September-2021','RP104','AWINCO INTERNATIONAL IN','3 Star Hotel','1/2795, Mandapam Road,\nAdam Nagar(Near Old Check Post),\nPattinamkathan, Ramanthapuram.','04567231111','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query197);
           String query198="insert into accommodation values('Ramanathapuram','7-September-2021','RP104','AWINCO INTERNATIONAL IN','3 Star Hotel','1/2795, Mandapam Road,\nAdam Nagar(Near Old Check Post),\nPattinamkathan, Ramanthapuram.','04567231111','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query198);
           String query199="insert into accommodation values('Ramanathapuram','8-September-2021','RP104','AWINCO INTERNATIONAL IN','3 Star Hotel','1/2795, Mandapam Road,\nAdam Nagar(Near Old Check Post),\nPattinamkathan, Ramanthapuram.','04567231111','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query199);
           String query200="insert into accommodation values('Ramanathapuram','9-September-2021','RP104','AWINCO INTERNATIONAL IN','3 Star Hotel','1/2795, Mandapam Road,\nAdam Nagar(Near Old Check Post),\nPattinamkathan, Ramanthapuram.','04567231111','5','700','4','500','5','1200','5','900','4','1700')";
           st.executeUpdate(query200);
           con.setAutoCommit(true); 
        }
        catch(Exception a){
            System.out.println(a);
        }
    } 
    
    //Fetching hotel details , room amount details from the accommodation table
    ResultSet accommodation_details(String district){
        ResultSet rs=null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","deva","deva2505"); 
            Statement st=con.createStatement();
            String query="select District,Hotel_Id,Hotel_Name,Hotel_Type,Hotel_location,Contact_Number,Amount_ACS,Amount_NACS,Amount_ACD,Amount_NACD,Amount_ACM from accommodation where District='"+district+"' and Dates='5-September-2021'";
            rs=st.executeQuery(query);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return rs;
    }
    
    //Fetching room details of a particular hotel to check availability from the accommodation table
    ResultSet room_details(String hotelid){
        ResultSet rs=null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","deva","deva2505"); 
            Statement st=con.createStatement();
            String query="select Hotel_Id,Dates,AC_SingleCot,NonAC_SingleCot,AC_DoubleCot,NonAC_DoubleCot,AC_MasterRoom from accommodation where Hotel_Id='"+hotelid+"'";
            rs=st.executeQuery(query);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return rs;
    }
    
    //Rooms Updation after a Booking
    void RoomsUpdation(String hotelid,String date,String type,String count)
    {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","deva","deva2505"); 
            Statement st=con.createStatement();
            String query="update accommodation set "+type+"='"+count+"' where Hotel_Id='"+hotelid+"' and Dates='"+date+"'";
            st.executeUpdate(query);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    //Creation of Table containing UserId with the Room_details he/she booked
    void accommodation_UserInfo(){
        try{
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","deva","deva2505"); 
           Statement st=con.createStatement();
           String query="create table accommodation_UserInfo(Mail_Id varchar(35),Hotel_Id varchar(15),Room_Type varchar(30),CheckIn_Date varchar(30),No_of_days varchar(12))";
           st.executeUpdate(query);
           con.setAutoCommit(true); 
        }
        catch(Exception a){
            System.out.println(a);
        }
    }  
    
    //Room Booking (Insertion of values into accommodation_UserInfo table), fetching amount for payment
    String RoomBooking(String userid,String hotelid,String roomtype,String checkindate,String dayscount,String amounttype){
        int amount=0;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","deva","deva2505"); 
            Statement st=con.createStatement();
            String query="insert into accommodation_UserInfo values('"+userid+"','"+hotelid+"','"+roomtype+"','"+checkindate+"','"+dayscount+"')";
            st.executeUpdate(query);
            String query1="select "+amounttype+" from accommodation where Hotel_Id='"+hotelid+"'";
            ResultSet rs=st.executeQuery(query1);
            rs.next();
            amount=Integer.parseInt(rs.getString(1))*Integer.parseInt(dayscount);
            con.setAutoCommit(true);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return String.valueOf(amount);
    }
    
    //Creation of Table containing Rental Cars Details
    void rentalCars(){
        try{
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","deva","deva2505"); 
           Statement st=con.createStatement();
           String query="create table rentalCars(District varchar(18),Car_Model varchar(35),Car_Id varchar(10),Car_Rent_per_day varchar(17),Driver_Name varchar(15),Driver_Contact_Number varchar(23),Driver_Gender varchar(15),Driver_Amount_per_day varchar(24),CarBooked varchar(20),DriverBooked varchar(20),Mail_Id varchar(35))";
           st.executeUpdate(query);
           String query1="insert into rentalCars values('Kanyakumari','Maruti Suzuki Swift Dzire','KK1001','600','Anandh','9878641232','Male','550','NO','NO','Nil')";
           st.executeUpdate(query1);
           String query2="insert into rentalCars values('Kanyakumari','Maruti Suzuki XL6','KK1002','650','Raja','9745562232','Male','500','NO','NO','Nil')";
           st.executeUpdate(query2);
           String query3="insert into rentalCars values('Kanyakumari','Maruti Alto 800','KK1003','650','John','9003025641','Male','550','NO','NO','Nil')";
           st.executeUpdate(query3);
           String query4="insert into rentalCars values('Kanyakumari','Toyota Enova Crysta','KK1004','700','Lingam','6382453342','Male','600','NO','NO','Nil')";
           st.executeUpdate(query4);
           String query5="insert into rentalCars values('Tanjore','Toyota Enova Crysta','TJ1001','700','Kalaiarasan','9300434342','Male','600','NO','NO','Nil')";
           st.executeUpdate(query5);
           String query6="insert into rentalCars values('Tanjore','Maruti Suzuki Swift Dzire','TJ1002','600','Anandhkumar','9822043232','Male','550','NO','NO','Nil')";
           st.executeUpdate(query6);
           String query7="insert into rentalCars values('Tanjore','Maruti Suzuki XL6','TJ1003','650','Rangan','8300211232','Male','500','NO','NO','Nil')";
           st.executeUpdate(query7);
           String query8="insert into rentalCars values('Tanjore','Maruti Alto 800','TJ1004','650','Kumar','8120302568','Male','550','NO','NO','Nil')";
           st.executeUpdate(query8);
           String query9="insert into rentalCars values('Madurai','Toyota Enova Crysta','MD1001','700','Karthick','9234523412','Male','600','NO','NO','Nil')";
           st.executeUpdate(query9);
           String query10="insert into rentalCars values('Madurai','Maruti Suzuki Swift Dzire','MD1002','600','Prakash','8082204322','Male','550','NO','NO','Nil')";
           st.executeUpdate(query10);
           String query11="insert into rentalCars values('Madurai','Maruti Suzuki XL6','MD1003','650','Praveen','8345023231','Male','500','NO','NO','Nil')";
           st.executeUpdate(query11);
           String query12="insert into rentalCars values('Madurai','Maruti Alto 800','MD1004','650','Ram','9120345610','Male','550','NO','NO','Nil')";
           st.executeUpdate(query12);
           String query13="insert into rentalCars values('Salem','Toyota Enova Crysta','SM1001','700','Naveen','9830013412','Male','600','NO','NO','Nil')";
           st.executeUpdate(query13);
           String query14="insert into rentalCars values('Salem','Maruti Suzuki Swift Dzire','SM1002','600','Prabhu','9304200432','Male','550','NO','NO','Nil')";
           st.executeUpdate(query14);
           String query15="insert into rentalCars values('Salem','Maruti Suzuki XL6','SM1003','650','Ashwanth','8323402300','Male','500','NO','NO','Nil')";
           st.executeUpdate(query15);
           String query16="insert into rentalCars values('Salem','Maruti Alto 800','SM1004','650','Bala','9234667161','Male','550','NO','NO','Nil')";
           st.executeUpdate(query16);
           String query17="insert into rentalCars values('Dindigul','Toyota Enova Crysta','DG1001','700','Nagesh','8310013241','Male','600','NO','NO','Nil')";
           st.executeUpdate(query17);
           String query18="insert into rentalCars values('Dindigul','Maruti Suzuki Swift Dzire','DG1002','600','Prabhakar','6782345432','Male','550','NO','NO','Nil')";
           st.executeUpdate(query18);
           String query19="insert into rentalCars values('Dindigul','Maruti Suzuki XL6','DG1003','650','Arjun','8901202345','Male','500','NO','NO','Nil')";
           st.executeUpdate(query19);
           String query20="insert into rentalCars values('Dindigul','Maruti Alto 800','DG1004','650','Rajesh','8893461242','Male','550','NO','NO','Nil')";
           st.executeUpdate(query20);
           String query21="insert into rentalCars values('Nilgiris','Toyota Enova Crysta','NS1001','700','Bharani','8901213412','Male','600','NO','NO','Nil')";
           st.executeUpdate(query21);
           String query22="insert into rentalCars values('Nilgiris','Maruti Suzuki Swift Dzire','NS1002','600','Bharath','9990120012','Male','550','NO','NO','Nil')";
           st.executeUpdate(query22);
           String query23="insert into rentalCars values('Nilgiris','Maruti Suzuki XL6','NS1003','650','Vishnu','8145621230','Male','500','NO','NO','Nil')";
           st.executeUpdate(query23);
           String query24="insert into rentalCars values('Nilgiris','Maruti Alto 800','NS1004','650','Vishal','9934667162','Male','550','NO','NO','Nil')";
           st.executeUpdate(query24);
           String query25="insert into rentalCars values('Chidambaram','Toyota Enova Crysta','CD1001','700','Navneeth','6782213412','Male','600','NO','NO','Nil')";
           st.executeUpdate(query25);
           String query26="insert into rentalCars values('Chidambaram','Maruti Suzuki Swift Dzire','CD1002','600','Gokul','9998220012','Male','550','NO','NO','Nil')";
           st.executeUpdate(query26);
           String query27="insert into rentalCars values('Chidambaram','Maruti Suzuki XL6','CD1003','650','Gnanavel','9896762111','Male','500','NO','NO','Nil')";
           st.executeUpdate(query27);
           String query28="insert into rentalCars values('Chidambaram','Maruti Alto 800','CD1004','650','Rajan','9486254201','Male','550','NO','NO','Nil')";
           st.executeUpdate(query28);
           String query29="insert into rentalCars values('Chennai','Toyota Enova Crysta','CN1001','700','Govind','6782341534','Male','600','NO','NO','Nil')";
           st.executeUpdate(query29);
           String query30="insert into rentalCars values('Chennai','Maruti Suzuki Swift Dzire','CN1002','600','Vijay','9482382200','Male','550','NO','NO','Nil')";
           st.executeUpdate(query30);
           String query31="insert into rentalCars values('Chennai','Maruti Suzuki XL6','CN1003','650','Manoj','9889176211','Male','500','NO','NO','Nil')";
           st.executeUpdate(query31);
           String query32="insert into rentalCars values('Chennai','Maruti Alto 800','CN1004','650','Hari','8486212201','Male','550','NO','NO','Nil')";
           st.executeUpdate(query32);
           String query33="insert into rentalCars values('Chengalpattu','Toyota Enova Crysta','CP1001','700','Guna','6891341530','Male','600','NO','NO','Nil')";
           st.executeUpdate(query33);
           String query34="insert into rentalCars values('Chengalpattu','Maruti Suzuki Swift Dzire','CP1002','600','Maadhesh','9982382212','Male','550','NO','NO','Nil')";
           st.executeUpdate(query34);
           String query35="insert into rentalCars values('Chengalpattu','Maruti Suzuki XL6','CP1003','650','Sai Sanjay','9128917621','Male','500','NO','NO','Nil')";
           st.executeUpdate(query35);
           String query36="insert into rentalCars values('Chengalpattu','Maruti Alto 800','CP1004','650','Krishna','9386212014','Male','550','NO','NO','Nil')";
           st.executeUpdate(query36);
           String query37="insert into rentalCars values('Ramanathapuram','Toyota Enova Crysta','RP1001','700','Michael','9998034153','Male','600','NO','NO','Nil')";
           st.executeUpdate(query37);
           String query38="insert into rentalCars values('Ramanathapuram','Maruti Suzuki Swift Dzire','RP1002','600','Sarvesh','9234123829','Male','550','NO','NO','Nil')";
           st.executeUpdate(query38);
           String query39="insert into rentalCars values('Ramanathapuram','Maruti Suzuki XL6','RP1003','650','Jagadheesh','9028214618','Male','500','NO','NO','Nil')";
           st.executeUpdate(query39);
           String query40="insert into rentalCars values('Ramanathapuram','Maruti Alto 800','RP1004','650','Mathew','9992314785','Male','550','NO','NO','Nil')";
           st.executeUpdate(query40);
           con.setAutoCommit(true); 
        }
        catch(Exception a){
            System.out.println(a);
        }
    }  
    
    //Fetching details from the rentalCars table
    ResultSet rentalCars_details(String district){
        ResultSet rs=null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","deva","deva2505"); 
            Statement st=con.createStatement();
            String query="select * from rentalCars where District='"+district+"'";
            rs=st.executeQuery(query);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return rs;
    }
    
    //RentalCars Booking (Updation of rentalCars table), fetching amount for payment
    String RentalCarsBooking(String userid,String carid,String carbooked,String driverbooked){
        int amount=0;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","deva","deva2505"); 
            Statement st=con.createStatement();
            String query="update rentalCars set Mail_Id='"+userid+"',CarBooked='"+carbooked+"',DriverBooked='"+driverbooked+"' where Car_Id='"+carid+"'";
            st.executeUpdate(query);
            String query1="select Car_Rent_per_day,Driver_Amount_per_day from rentalCars where Car_Id='"+carid+"'";
            ResultSet rs=st.executeQuery(query1);
            rs.next();
            amount=Integer.parseInt(rs.getString(1));
            if(driverbooked.equals("YES"))
            {
                amount=amount+Integer.parseInt(rs.getString(2));
            }
            con.setAutoCommit(true);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return String.valueOf(amount);
    }
    
    //Creation of Table containing Package Tours Details
    void packageTours(){
        try{
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","deva","deva2505"); 
           Statement st=con.createStatement();
           String query="create table packageTours(Package_Id varchar(25),From_location varchar(25),To_location varchar(25),Package_Name varchar(30),States_covered varchar(120),Start_Date varchar(30),No_of_days varchar(12),No_of_persons varchar(15),Transport varchar(15),Amount varchar(15))";
           st.executeUpdate(query);
           String query1="insert into packageTours values('P001','Tamil Nadu','Uttarakhand','Pilgrimage Tour Package','Tamil Nadu , Karnataka , Maharashtra ,\nGujarat , Madhya Pradesh ,\n Uttar Pradesh ,Uttarkhand','28th September 2021','6','1','Bus','40000')";
           st.executeUpdate(query1);
           String query2="insert into packageTours values('P002','Tamil Nadu','Goa','Vacation Package','Tamil Nadu , Kerala ,\nKarnataka , Goa','1st September 2021','5','1','Bus','30000')";
           st.executeUpdate(query2);
           String query3="insert into packageTours values('P003','Kerala','Uttarakhand','Pilgrimage Tour Package','Kerala , Karnataka , Maharashtra ,\nGujarat , Madhya Pradesh ,\nUttar Pradesh ,Uttarkhand','15th September 2021','6','1','Bus','40000')";
           st.executeUpdate(query3);
           String query4="insert into packageTours values('P004','Kerala','Goa','Holiday Package','Kerala , Karnataka , Goa','7th September 2021','4','1','Bus','25000')";
           st.executeUpdate(query4);
           String query5="insert into packageTours values('P005','Karnataka','Uttarakhand','Pilgrimage Tour Package','Karnataka , Maharashtra ,\nGujarat ,Madhya Pradesh ,\nUttar Pradesh ,Uttarkhand','20th September 2021','6','1','Bus','40000')";
           st.executeUpdate(query5);
           String query6="insert into packageTours values('P006','Karnataka','Himachal Pradesh','Holiday Package','Karnataka ,\n Maharashtra ,Madhya Pradesh ,\nRajasthan , Haryana ,\nPunjab,Himachal Pradesh','7th September 2021','7','1','Bus','55000')";
           st.executeUpdate(query6);
           String query7="insert into packageTours values('P007','Andhra Pradesh','Uttarakhand','Pilgrimage Tour Package','Andhra Pradesh , Karnataka , Maharashtra ,\nGujarat , Madhya Pradesh , Uttar Pradesh ,\nUttarkhand','4th October 2021','6','1','Bus','40000')";
           st.executeUpdate(query7);
           String query8="insert into packageTours values('P008','Andhra Pradesh','Himachal Pradesh','Holiday Package','Andhra Pradesh , Karnataka , Maharashtra ,\nMadhya Pradesh , Rajasthan , Haryana ,\nPunjab, Himachal Pradesh','7th October 2021','8','1','Bus','60000')";
           st.executeUpdate(query8);
           String query9="insert into packageTours values('P009','Maharashtra','Uttarakhand','Pilgrimage Tour Package','Maharashtra , Gujarat , Madhya Pradesh ,\nUttar Pradesh , Uttarkhand','11th October 2021','5','1','Bus','35000')";
           st.executeUpdate(query9);
           String query10="insert into packageTours values('P010','Maharashtra','Tamil Nadu','Holiday Package','Maharashtra , Karnataka ,\nKerala , Tamil Nadu','17th October 2021','5','1','Bus','25000')";
           st.executeUpdate(query10);
           con.setAutoCommit(true); 
        }
        catch(Exception a){
            System.out.println(a);
        }
    }  
    
    //Fetching details from the packageTours table
    ResultSet packageTours_details(String from_location){
        ResultSet rs=null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","deva","deva2505"); 
            Statement st=con.createStatement();
            String query="select * from packageTours where From_location='"+from_location+"'";
            rs=st.executeQuery(query);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return rs;
    }
    
    //Creation of Table containing UserId with the Package_Id he/she booked
    void packageTours_UserInfo(){
        try{
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","deva","deva2505"); 
           Statement st=con.createStatement();
           String query="create table packageTours_UserInfo(Mail_Id varchar(35),Package_Id varchar(25))";
           st.executeUpdate(query);
           con.setAutoCommit(true); 
        }
        catch(Exception a){
            System.out.println(a);
        }
    }  
    
    //PackageTours Booking (Insertion of values into packageTours_UserInfo table) , fetching amount for payment
    String PackageToursBooking(String packageid,String userid){
        String amount="";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","deva","deva2505"); 
            Statement st=con.createStatement();
            String query="insert into packageTours_UserInfo values('"+userid+"','"+packageid+"')";
            st.executeUpdate(query);
            String query1="select Amount from packageTours where Package_Id='"+packageid+"'";
            ResultSet rs=st.executeQuery(query1);
            rs.next();
            amount=rs.getString(1);
            con.setAutoCommit(true);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return amount;
    }
   
    //Creation of Table containing Payment Details
    void payment(){
        try{
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","deva","deva2505"); 
           Statement st=con.createStatement();
           String query="create table payment(PaymentId varchar(20),Mail_Id varchar(35),Transport varchar(15),Accommodation varchar(20),Rental_Car varchar(20),Guide varchar(20),Package_Tour varchar(20),Total varchar(20))";
           st.executeUpdate(query);
           con.setAutoCommit(true); 
        }
        catch(Exception a){
            System.out.println(a);
        }
    } 
    
    
    //Insert UserId (Insertion of Userid into payment table)
    String paymentUserIdInsertion(String userid){
        String paymentid="";
        try{
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","deva","deva2505"); 
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery("select count(PaymentId) from payment");
           rs.next();
           int rowscount=Integer.parseInt(rs.getString(1));
           paymentid="PAY"+String.valueOf(rowscount+1);
           String query="insert into payment values('"+paymentid+"','"+userid+"','0','0','0','0','0','0')";
           st.executeUpdate(query);
           con.setAutoCommit(true); 
        }
        catch(Exception a){
            System.out.println(a);
        }
        return paymentid;
    }
    
    //Updation of Payment in the payment table
    void paymentUpdation(String paymentid,String updationfield,String newvalue){
        try{
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","deva","deva2505"); 
           Statement st=con.createStatement();
           String query0="select "+updationfield+" from payment where PaymentId='"+paymentid+"'";
           ResultSet rs=st.executeQuery(query0);
           rs.next();
           String oldval=rs.getString(1);
           String updatedval=String.valueOf(Integer.parseInt(oldval)+Integer.parseInt(newvalue));
           String query="update payment set "+updationfield+"='"+updatedval+"' where PaymentId='"+paymentid+"'";
           st.executeUpdate(query);
           con.setAutoCommit(true); 
        }
        catch(Exception a){
            System.out.println(a);
        }
    }
    
    //Fetching details from the payment table
    ResultSet payment_details(String paymentid){
        ResultSet rs=null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","deva","deva2505"); 
            Statement st=con.createStatement();
            String query="select * from payment where PaymentId='"+paymentid+"'";
            rs=st.executeQuery(query);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return rs;
    }
    
    public static void main(String[] args){
        Backend bc=new Backend();
        bc.createTable();
    }
}
