/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootathon;
import java.io.*;
public class Payment_Receipt_Bean implements Serializable {
    private String paymentid,userid,transport_value,accommodation_value,cars_value,guide_value,package_tours_value,total_value;

    public String getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(String paymentid) {
        this.paymentid = paymentid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTransport_value() {
        return transport_value;
    }

    public void setTransport_value(String transport_value) {
        this.transport_value = transport_value;
    }

    public String getAccommodation_value() {
        return accommodation_value;
    }

    public void setAccommodation_value(String accommodation_value) {
        this.accommodation_value = accommodation_value;
    }

    public String getCars_value() {
        return cars_value;
    }

    public void setCars_value(String cars_value) {
        this.cars_value = cars_value;
    }

    public String getGuide_value() {
        return guide_value;
    }

    public void setGuide_value(String guide_value) {
        this.guide_value = guide_value;
    }

    public String getPackage_tours_value() {
        return package_tours_value;
    }

    public void setPackage_tours_value(String package_tours_value) {
        this.package_tours_value = package_tours_value;
    }

    public String getTotal_value() {
        return total_value;
    }

    public void setTotal_value(String total_value) {
        this.total_value = total_value;
    }
}
