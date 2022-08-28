/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootathon;
import java.io.*;

public class RentalCarsBooking_Bean implements Serializable{
    private String userid,carid,carbooked,driverbooked,paymentid;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getCarid() {
        return carid;
    }

    public void setCarid(String carid) {
        this.carid = carid;
    }

    public String getCarbooked() {
        return carbooked;
    }

    public void setCarbooked(String carbooked) {
        this.carbooked = carbooked;
    }

    public String getDriverbooked() {
        return driverbooked;
    }

    public void setDriverbooked(String driverbooked) {
        this.driverbooked = driverbooked;
    }

    public String getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(String paymentid) {
        this.paymentid = paymentid;
    }

}