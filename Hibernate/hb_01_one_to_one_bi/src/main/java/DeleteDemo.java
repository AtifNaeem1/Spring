import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteDemo {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            //start transaction
            session.beginTransaction();

            //get the instructor detail object
            int theId=5;

            InstructorDetail instructorDetail = session.get(InstructorDetail.class,theId);


            //print the instructor detail
            System.out.println("instructor detail:  " + instructorDetail);

            //print the associated instructor
            System.out.println("the associated instructor: " + instructorDetail.getInstructor());

            //remove the associated object reference
            //break bi-directional link
            instructorDetail.getInstructor().setInstructorDetail(null);

            //now delete the instructor details
            System.out.println("Deleting instructor detail");
            session.delete(instructorDetail);


            //commit the transaction
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
