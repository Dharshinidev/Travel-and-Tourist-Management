package bootathon;
import java.lang.*;
import java.net.*;
import java.sql.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws Exception {
        //while(true)
        //{
        ServerSocket ss=new ServerSocket(7000);
        while(true){
        
        Socket s = ss.accept();
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
        Object obj=ois.readObject();
        
        ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
        Backend be=new Backend();
        
        if(obj instanceof Registration_Bean)
        {
            
            Registration_Bean regb=(Registration_Bean)obj;
            String fname,lname,gender,dob,age,phno,mail,addressline1,city,district,state,pass;
            fname=regb.getFname();
            lname=regb.getLname();
            gender=regb.getGender();
            dob=regb.getDob();
            age=regb.getAge();
            phno=regb.getPhno();
            mail=regb.getMail();
            addressline1=regb.getAddressline1();
            city=regb.getCity();
            district=regb.getDistrict();
            state=regb.getState();
            pass=regb.getPass();
           
                  be.insert_register(fname,lname,gender,dob,age,phno,mail,addressline1,city,district,state,pass);
        }
        
        else if(obj instanceof Login_Bean)
        {
            Login_Bean loginb=(Login_Bean)obj;
            String mail,pass;
            mail=loginb.getUserid();
            pass=loginb.getPass();
            String payid="";
            ResultSet rs=be.login_details();
            LoginAccessMsg_Bean logacb=new LoginAccessMsg_Bean();
           
            int exists=0;
            String passcheck="";
            while(rs.next())
            {   
                if(mail.equals(rs.getString(1)))
                {
                    passcheck=rs.getString(2);
                    exists=1;
                }
            }
            if(exists!=1)
            {
                logacb.setMsg("0");
            }
            else
            {
                if(!pass.equals(passcheck))
                {
                    logacb.setMsg("-1");
                }
                else                           
                {
                    logacb.setMsg("1");
                    payid=be.paymentUserIdInsertion(mail);
                    logacb.setPayid(payid);
                    
                } 
            }
           oos.writeObject(logacb);
           }
           
        
        
       else if(obj instanceof HolidayDestinations_Bean)
        {
            HolidayDestinations_Bean hdb=(HolidayDestinations_Bean)obj;
            String state,placetype;
            state=hdb.getState();
            placetype=hdb.getPlaceType();
            ResultSet rs=be.destinations_details(state,placetype);
            ViewPlaces_Bean vplb=new ViewPlaces_Bean();
            vplb.setState(state);
            vplb.setPlacetype(placetype);
            
            rs.next();
            vplb.setDistrict1(rs.getString(3));
            vplb.setPlace1(rs.getString(4));
            vplb.setDescription1(rs.getString(5));
            
            rs.next();
            vplb.setDistrict2(rs.getString(3));
            vplb.setPlace2(rs.getString(4));
            vplb.setDescription2(rs.getString(5));
            
            rs.next();
            vplb.setDistrict3(rs.getString(3));
            vplb.setPlace3(rs.getString(4));
            vplb.setDescription3(rs.getString(5));
            
            rs.next();
            vplb.setDistrict4(rs.getString(3));
            vplb.setPlace4(rs.getString(4));
            vplb.setDescription4(rs.getString(5));
            
            rs.next();
            vplb.setDistrict5(rs.getString(3));
            vplb.setPlace5(rs.getString(4));
            vplb.setDescription5(rs.getString(5));
           
            oos.writeObject(vplb);
        }
        
        else if(obj instanceof Restaurant_District_Bean)
        {
            System.out.println("hello");
            Restaurant_District_Bean disb=(Restaurant_District_Bean)obj;
            String district;
            district=disb.getDistrict();
            ViewRestaurants_Bean vresb=new ViewRestaurants_Bean();
            vresb.setDistrict(district);
            ResultSet rs=be.restaurant_details(district);
            
            rs.next();
            vresb.setRestaurant_name1(rs.getString(2));
            vresb.setRestaurant_Location1(rs.getString(3));
            vresb.setRestaurant_Type1(rs.getString(4));
            vresb.setRestaurant_Ratings1(rs.getString(5));
            
            rs.next();
            vresb.setRestaurant_name2(rs.getString(2));
            vresb.setRestaurant_Location2(rs.getString(3));
            vresb.setRestaurant_Type2(rs.getString(4));
            vresb.setRestaurant_Ratings2(rs.getString(5));
            
            rs.next();
            vresb.setRestaurant_name3(rs.getString(2));
            vresb.setRestaurant_Location3(rs.getString(3));
            vresb.setRestaurant_Type3(rs.getString(4));
            vresb.setRestaurant_Ratings3(rs.getString(5));
            
            oos.writeObject(vresb);
        }
        
        else if(obj instanceof Guides_District_Bean)
        {
            Guides_District_Bean disb=(Guides_District_Bean)obj;
            String district;
            district=disb.getDistrict();
            ViewGuides_Bean vguib=new ViewGuides_Bean();
            vguib.setDistrict(district);
            ResultSet rs=be.guides_details(district);
            
            rs.next();
            vguib.setGuideid1(rs.getString(2));
            vguib.setGuideName1(rs.getString(3));
            vguib.setGuideGender1(rs.getString(4));
            vguib.setContactNumber1(rs.getString(5));
            vguib.setAmountPerDay1(rs.getString(6));
            vguib.setBooked1(rs.getString(7));
            
            rs.next();
            vguib.setGuideid2(rs.getString(2));
            vguib.setGuideName2(rs.getString(3));
            vguib.setGuideGender2(rs.getString(4));
            vguib.setContactNumber2(rs.getString(5));
            vguib.setAmountPerDay2(rs.getString(6));
            vguib.setBooked2(rs.getString(7));
            
            rs.next();
            vguib.setGuideid3(rs.getString(2));
            vguib.setGuideName3(rs.getString(3));
            vguib.setGuideGender3(rs.getString(4));
            vguib.setContactNumber3(rs.getString(5));
            vguib.setAmountPerDay3(rs.getString(6));
            vguib.setBooked3(rs.getString(7));
            oos.writeObject(vguib);
            
        }
        
        else if(obj instanceof GuideBooking_Bean)
        {
            GuideBooking_Bean guibb=(GuideBooking_Bean)obj;
            String userid,guideid,booked,paymentid,dayscount;
            userid=guibb.getUserid();
            guideid=guibb.getGuideid();
            booked=guibb.getBooked();
            paymentid=guibb.getPaymentid();
            dayscount=guibb.getNo_of_days();
            String amount=be.guideBooking(userid,guideid,booked,dayscount);
            be.paymentUpdation(paymentid,"Guide",amount);
            
        }
            
        else if(obj instanceof RentalCars_District_Bean)
        {
            RentalCars_District_Bean rcdb=(RentalCars_District_Bean)obj;
            String district=rcdb.getDistrict();
            ViewRentalCars_Bean vrcb=new ViewRentalCars_Bean();
            ResultSet rs=be.rentalCars_details(district);
            vrcb.setDistrict(district);
            
            rs.next();
            vrcb.setCarModel1(rs.getString(2));
            vrcb.setCarId1(rs.getString(3));
            vrcb.setCarRentperday1(rs.getString(4));
            vrcb.setDriverName1(rs.getString(5));
            vrcb.setDriverContactNumber1(rs.getString(6));
            vrcb.setDriverGender1(rs.getString(7));
            vrcb.setDriverAmountperday1(rs.getString(8));
            vrcb.setCarbooked1(rs.getString(9));
            vrcb.setDriverbooked1(rs.getString(10));
            
            rs.next();
            vrcb.setCarModel2(rs.getString(2));
            vrcb.setCarId2(rs.getString(3));
            vrcb.setCarRentperday2(rs.getString(4));
            vrcb.setDriverName2(rs.getString(5));
            vrcb.setDriverContactNumber2(rs.getString(6));
            vrcb.setDriverGender2(rs.getString(7));
            vrcb.setDriverAmountperday2(rs.getString(8));
            vrcb.setCarbooked2(rs.getString(9));
            vrcb.setDriverbooked2(rs.getString(10));
            
            rs.next();
            vrcb.setCarModel3(rs.getString(2));
            vrcb.setCarId3(rs.getString(3));
            vrcb.setCarRentperday3(rs.getString(4));
            vrcb.setDriverName3(rs.getString(5));
            vrcb.setDriverContactNumber3(rs.getString(6));
            vrcb.setDriverGender3(rs.getString(7));
            vrcb.setDriverAmountperday3(rs.getString(8));
            vrcb.setCarbooked3(rs.getString(9));
            vrcb.setDriverbooked3(rs.getString(10));
            
            rs.next();
            vrcb.setCarModel4(rs.getString(2));
            vrcb.setCarId4(rs.getString(3));
            vrcb.setCarRentperday4(rs.getString(4));
            vrcb.setDriverName4(rs.getString(5));
            vrcb.setDriverContactNumber4(rs.getString(6));
            vrcb.setDriverGender4(rs.getString(7));
            vrcb.setDriverAmountperday4(rs.getString(8));
            vrcb.setCarbooked4(rs.getString(9));
            vrcb.setDriverbooked4(rs.getString(10));
            
            oos.writeObject(vrcb);
        }
        
        else if(obj instanceof RentalCarsBooking_Bean)
        {
            RentalCarsBooking_Bean rcbb=(RentalCarsBooking_Bean)obj;
            String userid,carid,carbooked,driverbooked,paymentid;
            userid=rcbb.getUserid();
            carid=rcbb.getCarid();
            carbooked=rcbb.getCarbooked();
            driverbooked=rcbb.getDriverbooked();
            paymentid=rcbb.getPaymentid();
            String amount=be.RentalCarsBooking(userid, carid, carbooked, driverbooked);
            be.paymentUpdation(paymentid,"Rental_Car",amount);
        
        }
        
        else if(obj instanceof AccommodationDistrict_Bean)
        {
            AccommodationDistrict_Bean acdb=(AccommodationDistrict_Bean)obj;
            String district;
            district=acdb.getDistrict();
            ResultSet rs=be.accommodation_details(district);
            ViewHotels_Bean vhotb=new ViewHotels_Bean();
            vhotb.setDistrict(district);
            
            rs.next();
            vhotb.setHotel_id1(rs.getString(2));
            vhotb.setHotel_name1(rs.getString(3));
            vhotb.setHotel_type1(rs.getString(4));
            vhotb.setLocation1(rs.getString(5));
            vhotb.setCon_num1(rs.getString(6));
            vhotb.setHotel_amountACS1(rs.getString(7));
            vhotb.setHotel_amountNACS1(rs.getString(8));
            vhotb.setHotel_amountACD1(rs.getString(9));
            vhotb.setHotel_amountNACD1(rs.getString(10));
            vhotb.setHotel_amountACM1(rs.getString(11));
            
            rs.next();
            vhotb.setHotel_id2(rs.getString(2));
            vhotb.setHotel_name2(rs.getString(3));
            vhotb.setHotel_type2(rs.getString(4));
            vhotb.setLocation2(rs.getString(5));
            vhotb.setCon_num2(rs.getString(6));
            vhotb.setHotel_amountACS2(rs.getString(7));
            vhotb.setHotel_amountNACS2(rs.getString(8));
            vhotb.setHotel_amountACD2(rs.getString(9));
            vhotb.setHotel_amountNACD2(rs.getString(10));
            vhotb.setHotel_amountACM2(rs.getString(11));
            
            rs.next();
            vhotb.setHotel_id3(rs.getString(2));
            vhotb.setHotel_name3(rs.getString(3));
            vhotb.setHotel_type3(rs.getString(4));
            vhotb.setLocation3(rs.getString(5));
            vhotb.setCon_num3(rs.getString(6));
            vhotb.setHotel_amountACS3(rs.getString(7));
            vhotb.setHotel_amountNACS3(rs.getString(8));
            vhotb.setHotel_amountACD3(rs.getString(9));
            vhotb.setHotel_amountNACD3(rs.getString(10));
            vhotb.setHotel_amountACM3(rs.getString(11));
            
            rs.next();
            vhotb.setHotel_id4(rs.getString(2));
            vhotb.setHotel_name4(rs.getString(3));
            vhotb.setHotel_type4(rs.getString(4));
            vhotb.setLocation4(rs.getString(5));
            vhotb.setCon_num4(rs.getString(6));
            vhotb.setHotel_amountACS4(rs.getString(7));
            vhotb.setHotel_amountNACS4(rs.getString(8));
            vhotb.setHotel_amountACD4(rs.getString(9));
            vhotb.setHotel_amountNACD4(rs.getString(10));
            vhotb.setHotel_amountACM4(rs.getString(11));
            oos.writeObject(vhotb);
            
        }
        
        else if(obj instanceof CheckforRooms_Bean)
        {
            CheckforRooms_Bean cfrb=(CheckforRooms_Bean)obj;
            String userid,hotelid,roomtype,checkindate,paymentid;
            int dayscount;
            paymentid=cfrb.getPaymentid();
            userid=cfrb.getUserid();
            hotelid=cfrb.getHotelid();
            roomtype=cfrb.getRoomtype();
            System.out.println(roomtype);
            checkindate=cfrb.getCheckindate();
            dayscount=Integer.parseInt((cfrb.getDayscount()));
            ResultSet rs=be.room_details(hotelid);
            String amounttype="";
            if(roomtype.equals("AC Single Cot"))
            {
                roomtype="AC_SingleCot";
                amounttype="Amount_ACS";                                   
            }
            else if(roomtype.equals("NON-AC Single Cot"))
            {
                roomtype="NonAC_SingleCot";
                amounttype="Amount_NACS";
            }
            else if(roomtype.equals("AC Double Cot"))
            {
                roomtype="AC_DoubleCot";
                amounttype="Amount_ACD";
            }
            else if(roomtype.equals("NON-AC Double Cot"))
            {
                roomtype="NonAC_DoubleCot";
                amounttype="Amount_NACD";
            }
            else if(roomtype.equals("AC Master Room"))
            {
                roomtype="AC_MasterRoom";
                amounttype="Amount_ACM";
            }
            int i=1;
            int availdays=0;
            RoomAvailability_Bean roomavb=new RoomAvailability_Bean();
            while(rs.next())
            {
                if(rs.getString(2).equals(checkindate))
                {
                    do
                    {
                        if(i<=dayscount && Integer.parseInt(rs.getString(roomtype))>0)
                        {
                            availdays=availdays+1;
                        }
                        i++;  
                        if(i>dayscount)
                        {
                            break;
                        }
                    }while(rs.next());
                    break;
                }
            }
            if(availdays==dayscount)
            {
               ResultSet rs1=be.room_details(hotelid);
                rs1.next();
                do
                {
                    if(rs1.getString(2).equals(checkindate))
                    {
                        for(int j=0;j<dayscount;j++)
                        {
                            be.RoomsUpdation(hotelid,rs1.getString("Dates"),roomtype,String.valueOf(Integer.parseInt(rs1.getString(roomtype))-1));    
                            rs1.next();
                        }
                        break;
                    }
                }while(rs1.next());
                String amount=be.RoomBooking(userid,hotelid,roomtype,checkindate,String.valueOf(dayscount),amounttype);
                be.paymentUpdation(paymentid,"Accommodation",amount);
                roomavb.setAvailability("1");
            }
            else
            {
                roomavb.setAvailability("0");
            }
            oos.writeObject(roomavb);
        }
        
        else if(obj instanceof SearchPackageTours_Bean)
        {
            
            SearchPackageTours_Bean sptb=(SearchPackageTours_Bean)obj;
            String from,to;
            from=sptb.getFrom();
            to=sptb.getTo();
            ResultSet rs=be.packageTours_details(from);
            ViewPackage_Bean vpacb=new ViewPackage_Bean();
            
            rs.next();
            vpacb.setPackageid1(rs.getString(1));
            vpacb.setFrom1(rs.getString(2));
            vpacb.setTo1(rs.getString(3));
            vpacb.setPackage_name1(rs.getString(4));
            vpacb.setStates_covered1(rs.getString(5));
            vpacb.setStart_date1(rs.getString(6));
            vpacb.setNo_of_days1(rs.getString(7));
            vpacb.setNo_of_persons1(rs.getString(8));
            vpacb.setTransport1(rs.getString(9));
            vpacb.setAmount1(rs.getString(10));
            
            rs.next();
            vpacb.setPackageid2(rs.getString(1));
            vpacb.setFrom2(rs.getString(2));
            vpacb.setTo2(rs.getString(3));
            vpacb.setPackage_name2(rs.getString(4));
            vpacb.setStates_covered2(rs.getString(5));
            vpacb.setStart_date2(rs.getString(6));
            vpacb.setNo_of_days2(rs.getString(7));
            vpacb.setNo_of_persons2(rs.getString(8));
            vpacb.setTransport2(rs.getString(9));
            vpacb.setAmount2(rs.getString(10));
            
            oos.writeObject(vpacb);
            
        }
        
        else if(obj instanceof PackageToursBooking_Bean)
        {
            PackageToursBooking_Bean ptbb=(PackageToursBooking_Bean)obj;
            String packageid,userid,paymentid;
            packageid=ptbb.getPackageid();
            userid=ptbb.getUserid();
            paymentid=ptbb.getPaymentid();
            String amount=be.PackageToursBooking(packageid,userid);
            be.paymentUpdation(paymentid,"Package_Tour",amount);
        }
        
        else if(obj instanceof PaymentId_Bean)
        {
            PaymentId_Bean payb=(PaymentId_Bean)obj;
            String paymentid;
            paymentid=payb.getPaymentid();
            ResultSet rs=be.payment_details(paymentid);
            Payment_Receipt_Bean payreb=new Payment_Receipt_Bean();
            payreb.setPaymentid(paymentid);
            
            rs.next();
            int transport,accommodation,rentalcars,guides,packagetours,total;
            String userid;
            userid=rs.getString(2);
            transport=Integer.parseInt(rs.getString(3));
            accommodation=Integer.parseInt(rs.getString(4));
            rentalcars=Integer.parseInt(rs.getString(5));
            guides=Integer.parseInt(rs.getString(6));
            packagetours=Integer.parseInt(rs.getString(7));
            total=transport+accommodation+rentalcars+guides+packagetours;
            
            be.paymentUpdation(paymentid,"Total",String.valueOf(total));
            
            payreb.setUserid(userid);
            payreb.setTransport_value(String.valueOf(transport));
            payreb.setAccommodation_value(String.valueOf(accommodation));
            payreb.setCars_value(String.valueOf(rentalcars));
            payreb.setGuide_value(String.valueOf(guides));
            payreb.setPackage_tours_value(String.valueOf(packagetours));
            payreb.setTotal_value(String.valueOf(total));
            
            oos.writeObject(payreb);
            
        }
     }  
    }   
}

