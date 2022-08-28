
package bootathon;
import java.lang.*;
import java.io.*;

public class LoginAccessMsg_Bean implements Serializable{
    private String msg,payid;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getPayid() {
        return payid;
    }

    public void setPayid(String payid) {
        this.payid = payid;
    }
    
}