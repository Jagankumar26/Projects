package encapsulations;
import jakarta.persistence.*;
import java.util.Scanner;

import entitypackage.Student;

public class UsingEntity {
  Student student;

public UsingEntity() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter name:");
        String name = sc.nextLine();

        System.out.println("Enter ID:");
        int id = sc.nextInt();
        sc.nextLine(); 

        System.out.println("Enter course:");
        String course = sc.nextLine();

        
      this.  student = new Student(name, id, course);
    }

    
     public Student getStudent() {
        return student;
    
}

}


