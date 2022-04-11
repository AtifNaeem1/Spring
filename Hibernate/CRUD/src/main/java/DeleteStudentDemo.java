import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            int studentId = 3;

            //now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            //deleting student based on the id: primary key
            System.out.println("\n Getting students with id: " + studentId);

            Student myStudent = session.get(Student.class,studentId);

            System.out.println("Deleting Student... ");

            session.delete(myStudent);



            //deleting student id=2
            System.out.println("Deleting student id=2");

            session.createQuery("delete from Student where id=2").executeUpdate();

            session.getTransaction().commit();


            System.out.println("Done!");

        }
        finally {
            factory.close();
        }

    }
}
