import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetInstructorCourseDemo {
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

           //get course for instructor
            System.out.println("Courses: " + tempInstructor.getCourses());


            //commit transaction
            session.getTransaction().commit();


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
