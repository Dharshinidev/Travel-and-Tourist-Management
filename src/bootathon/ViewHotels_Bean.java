/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootathon;
import java.io.*;

public class ViewHotels_Bean implements Serializable{
    private String district;
    private String Hotel_name1,Hotel_name2,Hotel_name3,Hotel_name4;
    private String Hotel_id1,Hotel_id2,Hotel_id3,Hotel_id4;
    private String con_num1,con_num2,con_num3,con_num4;
    private String location1,location2,location3,location4;
    private String hotel_type1,hotel_type2,hotel_type3,hotel_type4;
    private String hotel_amountACS1,hotel_amountACS2,hotel_amountACS3,hotel_amountACS4;
    private String hotel_amountNACS1,hotel_amountNACS2,hotel_amountNACS3,hotel_amountNACS4;
    private String hotel_amountACD1,hotel_amountACD2,hotel_amountACD3,hotel_amountACD4;
    private String hotel_amountNACD1,hotel_amountNACD2,hotel_amountNACD3,hotel_amountNACD4;
    private String hotel_amountACM1,hotel_amountACM2,hotel_amountACM3,hotel_amountACM4;

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getHotel_name1() {
        return Hotel_name1;
    }

    public void setHotel_name1(String Hotel_name1) {
        this.Hotel_name1 = Hotel_name1;
    }

    public String getHotel_name2() {
        return Hotel_name2;
    }

    public void setHotel_name2(String Hotel_name2) {
        this.Hotel_name2 = Hotel_name2;
    }

    public String getHotel_name3() {
        return Hotel_name3;
    }

    public void setHotel_name3(String Hotel_name3) {
        this.Hotel_name3 = Hotel_name3;
    }

    public String getHotel_name4() {
        return Hotel_name4;
    }

    public void setHotel_name4(String Hotel_name4) {
        this.Hotel_name4 = Hotel_name4;
    }

    public String getHotel_id1() {
        return Hotel_id1;
    }

    public void setHotel_id1(String Hotel_id1) {
        this.Hotel_id1 = Hotel_id1;
    }

    public String getHotel_id2() {
        return Hotel_id2;
    }

    public void setHotel_id2(String Hotel_id2) {
        this.Hotel_id2 = Hotel_id2;
    }

    public String getHotel_id3() {
        return Hotel_id3;
    }

    public void setHotel_id3(String Hotel_id3) {
        this.Hotel_id3 = Hotel_id3;
    }

    public String getHotel_id4() {
        return Hotel_id4;
    }

    public void setHotel_id4(String Hotel_id4) {
        this.Hotel_id4 = Hotel_id4;
    }

    public String getCon_num1() {
        return con_num1;
    }

    public void setCon_num1(String con_num1) {
        this.con_num1 = con_num1;
    }

    public String getCon_num2() {
        return con_num2;
    }

    public void setCon_num2(String con_num2) {
        this.con_num2 = con_num2;
    }

    public String getCon_num3() {
        return con_num3;
    }

    public void setCon_num3(String con_num3) {
        this.con_num3 = con_num3;
    }

    public String getCon_num4() {
        return con_num4;
    }

    public void setCon_num4(String con_num4) {
        this.con_num4 = con_num4;
    }

    public String getLocation1() {
        return location1;
    }

    public void setLocation1(String location1) {
        this.location1 = location1;
    }

    public String getLocation2() {
        return location2;
    }

    public void setLocation2(String location2) {
        this.location2 = location2;
    }

    public String getLocation3() {
        return location3;
    }

    public void setLocation3(String location3) {
        this.location3 = location3;
    }

    public String getLocation4() {
        return location4;
    }

    public void setLocation4(String location4) {
        this.location4 = location4;
    }

    public String getHotel_type1() {
        return hotel_type1;
    }

    public void setHotel_type1(String hotel_type1) {
        this.hotel_type1 = hotel_type1;
    }

    public String getHotel_type2() {
        return hotel_type2;
    }

    public void setHotel_type2(String hotel_type2) {
        this.hotel_type2 = hotel_type2;
    }

    public String getHotel_type3() {
        return hotel_type3;
    }

    public void setHotel_type3(String hotel_type3) {
        this.hotel_type3 = hotel_type3;
    }

    public String getHotel_type4() {
        return hotel_type4;
    }

    public void setHotel_type4(String hotel_type4) {
        this.hotel_type4 = hotel_type4;
    }

    public String getHotel_amountACS1() {
        return hotel_amountACS1;
    }

    public void setHotel_amountACS1(String hotel_amountACS1) {
        this.hotel_amountACS1 = hotel_amountACS1;
    }

    public String getHotel_amountACS2() {
        return hotel_amountACS2;
    }

    public void setHotel_amountACS2(String hotel_amountACS2) {
        this.hotel_amountACS2 = hotel_amountACS2;
    }

    public String getHotel_amountACS3() {
        return hotel_amountACS3;
    }

    public void setHotel_amountACS3(String hotel_amountACS3) {
        this.hotel_amountACS3 = hotel_amountACS3;
    }

    public String getHotel_amountACS4() {
        return hotel_amountACS4;
    }

    public void setHotel_amountACS4(String hotel_amountACS4) {
        this.hotel_amountACS4 = hotel_amountACS4;
    }

    public String getHotel_amountNACS1() {
        return hotel_amountNACS1;
    }

    public void setHotel_amountNACS1(String hotel_amountNACS1) {
        this.hotel_amountNACS1 = hotel_amountNACS1;
    }

    public String getHotel_amountNACS2() {
        return hotel_amountNACS2;
    }

    public void setHotel_amountNACS2(String hotel_amountNACS2) {
        this.hotel_amountNACS2 = hotel_amountNACS2;
    }

    public String getHotel_amountNACS3() {
        return hotel_amountNACS3;
    }

    public void setHotel_amountNACS3(String hotel_amountNACS3) {
        this.hotel_amountNACS3 = hotel_amountNACS3;
    }

    public String getHotel_amountNACS4() {
        return hotel_amountNACS4;
    }

    public void setHotel_amountNACS4(String hotel_amountNACS4) {
        this.hotel_amountNACS4 = hotel_amountNACS4;
    }

    public String getHotel_amountACD1() {
        return hotel_amountACD1;
    }

    public void setHotel_amountACD1(String hotel_amountACD1) {
        this.hotel_amountACD1 = hotel_amountACD1;
    }

    public String getHotel_amountACD2() {
        return hotel_amountACD2;
    }

    public void setHotel_amountACD2(String hotel_amountACD2) {
        this.hotel_amountACD2 = hotel_amountACD2;
    }

    public String getHotel_amountACD3() {
        return hotel_amountACD3;
    }

    public void setHotel_amountACD3(String hotel_amountACD3) {
        this.hotel_amountACD3 = hotel_amountACD3;
    }

    public String getHotel_amountACD4() {
        return hotel_amountACD4;
    }

    public void setHotel_amountACD4(String hotel_amountACD4) {
        this.hotel_amountACD4 = hotel_amountACD4;
    }

    public String getHotel_amountNACD1() {
        return hotel_amountNACD1;
    }

    public void setHotel_amountNACD1(String hotel_amountNACD1) {
        this.hotel_amountNACD1 = hotel_amountNACD1;
    }

    public String getHotel_amountNACD2() {
        return hotel_amountNACD2;
    }

    public void setHotel_amountNACD2(String hotel_amountNACD2) {
        this.hotel_amountNACD2 = hotel_amountNACD2;
    }

    public String getHotel_amountNACD3() {
        return hotel_amountNACD3;
    }

    public void setHotel_amountNACD3(String hotel_amountNACD3) {
        this.hotel_amountNACD3 = hotel_amountNACD3;
    }

    public String getHotel_amountNACD4() {
        return hotel_amountNACD4;
    }

    public void setHotel_amountNACD4(String hotel_amountNACD4) {
        this.hotel_amountNACD4 = hotel_amountNACD4;
    }

    public String getHotel_amountACM1() {
        return hotel_amountACM1;
    }

    public void setHotel_amountACM1(String hotel_amountACM1) {
        this.hotel_amountACM1 = hotel_amountACM1;
    }

    public String getHotel_amountACM2() {
        return hotel_amountACM2;
    }

    public void setHotel_amountACM2(String hotel_amountACM2) {
        this.hotel_amountACM2 = hotel_amountACM2;
    }

    public String getHotel_amountACM3() {
        return hotel_amountACM3;
    }

    public void setHotel_amountACM3(String hotel_amountACM3) {
        this.hotel_amountACM3 = hotel_amountACM3;
    }

    public String getHotel_amountACM4() {
        return hotel_amountACM4;
    }

    public void setHotel_amountACM4(String hotel_amountACM4) {
        this.hotel_amountACM4 = hotel_amountACM4;
    }
}
