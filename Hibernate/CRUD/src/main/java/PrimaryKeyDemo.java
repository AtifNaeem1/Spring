import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            //create a student object
            System.out.println("Creating 3 students objects...");
            Student tempStudent1 =  new Student("John" , "Doe" ,"john@gmail.com");
            Student tempStudent2 =  new Student("Mary" , "Public" ,"mary@gmail.com");
            Student tempStudent3 =  new Student("Bonita" , "Applebum" ,"bonita@gmail.com");

            //start transaction
            session.beginTransaction();

            //save the student
            System.out.println("Saving the students..");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            //commit the transaction
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }

    }
}
