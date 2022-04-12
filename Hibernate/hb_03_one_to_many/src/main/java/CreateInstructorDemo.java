import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
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
                //create the objects
                Instructor tempInstructor =
                        new Instructor("Susan", "Public", "susan.public@luv2code.com");

                InstructorDetail tempInstructorDetail =
                        new InstructorDetail("http://www.youtube.com","video games");

                //associate the objects
                tempInstructor.setInstructorDetail(tempInstructorDetail);

                //start a transaction
                session.beginTransaction();

                //save the instructor
                session.save(tempInstructor);

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
