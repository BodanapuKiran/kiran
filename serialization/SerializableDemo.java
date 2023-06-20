import java.io.*;
class Account implements Serializable{
String name="durga";
transient String password="anushka";
transient int pin=1234;
private void writeObject(ObjectOutputStream os)throws Exception{
  os.defaultWriteObject();
  String epwd ="123"+password;
  int epin=4444+pin;
  os.writeObject(epwd);
  os.writeInt(epin);
  }
private void readObject(ObjectInputStream is) throws Exception{
   is.defaultReadObject();
    String epwd=(String)is.readObject();
           password=epwd.substring(3);
 int epin=is.readInt();
     pin=epin-4444;
}
}
public class SerializableDemo {
public static void main(String[] args) throws Exception{
Account a1=new Account();
System.out.println(a1.name+"..."+a1.password+"..."+a1.pin);
FileOutputStream fos =new FileOutputStream("C:/Users/Bodhanapu Kiran/eclipse-workspace/javaByDurgaSir/serialization/kiran.txt");
ObjectOutputStream oos=new ObjectOutputStream(fos);
oos.writeObject(a1);
FileInputStream fis =new FileInputStream("C:/Users/Bodhanapu Kiran/eclipse-workspace/javaByDurgaSir/serialization/kiran.txt");
ObjectInputStream ois=new ObjectInputStream(fis);
     Account a2=(Account)ois.readObject();
System.out.println(a2.name+"..."+a2.password+"..."+a2.pin);
}
}