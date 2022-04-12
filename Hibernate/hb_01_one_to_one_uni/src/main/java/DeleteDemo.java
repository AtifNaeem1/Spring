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

           //get instructor by primary key/id
            int theId=1;
            Instructor tempInstructor = session.get(Instructor.class,theId);

            //delete instructor
            if(tempInstructor != null)
            {
                //it will also delete detail object due to cascade all
                session.delete(tempInstructor);
            }

            //commit the transaction
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }
}
