import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            int studentId = 1;

            //now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            //retrieve student based on the id: primary key
            System.out.println("\n Getting students with id: " + studentId);

            Student myStudent = session.get(Student.class,studentId);

            System.out.println("Updating Student... ");

            myStudent.setFirstName("Scooby");

            //commit the transaction
            session.getTransaction().commit();

            //update email for all students
            session = factory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("update Student set email='interns@zemosolabs.com'").executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally {
            factory.close();
        }

    }
}
