import org.hibernate.Session;
import org.hibernate.SessionFactory;
import entity.Student;
import org.hibernate.cfg.Configuration;



public class CreateStudentDemo {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            //create a student object
            Student tempStudent =  new Student("Paul" , "Wall" ,"paul@gmail.com");

            //start transaction
            session.beginTransaction();

            //save the student
            session.save(tempStudent);

            //commit the transaction
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }
}
