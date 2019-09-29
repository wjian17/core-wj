package knowledge.accumulation.springcloud.domain.clone;

import lombok.Data;

import java.io.*;
import java.util.Calendar;
import java.util.Date;

@Data
public class CloneDomain implements Cloneable, Serializable {

    private Date date;

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneDomain cloneDomain = new CloneDomain();
        Date now = new Date();
        cloneDomain.setDate(now);
        CloneDomain cloneDomain1 = (CloneDomain) cloneDomain.clone();
        Calendar c  = Calendar.getInstance();
        c.set(1992,2,2);
//        cloneDomain.setDate(c.getTime());
        now.setTime(c.getTimeInMillis());
        System.out.println(cloneDomain.getDate());
        System.out.println(cloneDomain1.getDate());

        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(cloneDomain);
            byte[] bytes = byteArrayOutputStream.toByteArray();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            CloneDomain cloneDomain2 = (CloneDomain) objectInputStream.readObject();
//            now.setTime(new Date().getTime());
            cloneDomain2.getDate().setTime(new Date().getTime());
            System.out.println(cloneDomain2.getDate());
            System.out.println(cloneDomain1.getDate());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


