import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


//solution-- call the getter method when session is opened, once it is loaded in memory,
// we can use it after session is closed
public class LazyLoadingClosingSessionSolution {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            //start a transaction
            session.beginTransaction();

            //get the instructor form db
            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class , theId);

            System.out.println("Instructor: " + tempInstructor);

            System.out.println("Courses: " + tempInstructor.getCourses());

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Session is closed now\n\n");

            //get course for instructor
            System.out.println("Courses: " + tempInstructor.getCourses());

        }
        catch(NullPointerException e)
        {
            System.out.println("Enter correct id");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
