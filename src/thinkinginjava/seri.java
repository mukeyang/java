package thinkinginjava;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by CS on 2017/9/14.
 */
public class seri {
    public static void main(String[] args) throws IOException {
        Employee employee = new Employee("1", 1, 2.1);
        Employee employee1 = new Employee("2", 2, 3.1);
        Manger m1 = new Manger("3", 1, 1.1);
        Manger m2 = new Manger("4", 1, 1.1);
        m1.setStaff(employee);
        m2.setStaff(employee1);
       Employee[] a = {m1, m2, employee, employee1};
        Path path = Paths.get("2.dat");
        Files.deleteIfExists(path);
        Files.createFile(path);
    try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("2.dat"))){
//           out.writeObject(employee);
//           out.writeObject(employee1);
        out.writeObject(a);
        } catch (Exception e) {
        e.printStackTrace();
    }
        try (ObjectInputStream in=new ObjectInputStream(new FileInputStream("2.dat"))) {
//            Employee employee2 = (Employee) in.readObject();
            Employee[] a2 = (Employee[]) in.readObject();
            Manger manger = Manger.class.cast(a2[0]);
            Employee staff = manger.staff;
            staff.name="aasd";
            System.out.println(a2[2].name);
            Manger manger2 = Manger.class.cast(a2[1]);
            manger2.staff.name="yang";
            for (Employee employee2 : a2) {
                System.out.println(employee2);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Employee implements Serializable,Externalizable{
    String name;
    int num;
    double salary;
    transient String fd=name;

    public Employee(String name, int num, double salary) {
        this.name = name;
        this.num = num;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name+num+salary+fd;
    }

    private void writeObject(ObjectOutputStream out)throws IOException {
        out.defaultWriteObject();
        out.writeUTF(name);
    }

    private void readObject(ObjectInputStream in) throws Exception {
        in.defaultReadObject();
        fd=in.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}
class Manger extends  Employee {
    public Employee getStaff() {
        return staff;
    }

    public void setStaff(Employee staff) {
        this.staff = staff;
    }

    Employee staff;

    public Manger(String name, int num, double salary) {
        super(name, num, salary);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
