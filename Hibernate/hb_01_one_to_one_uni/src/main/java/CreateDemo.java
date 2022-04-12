import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import entity.Student;
import org.hibernate.cfg.Configuration;



public class CreateDemo {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            //create objects
        /*    Instructor tempInstructor =
                    new Instructor("Chad","Darby","darby@gmail.com");

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail("http://www.luv2code.com/youtube",
                            "Luv 2 code !!");
        */
            Instructor tempInstructor =
                    new Instructor("Radha","Patel","radha@gmail.com");

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail("http://www.youtube.com/madhu",
                            "love to sing");

            //associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            //start transaction
            session.beginTransaction();

            //save the instructor
            //this will also save the details object
            //because of CascadeType.ALL
            session.save(tempInstructor);

            //commit the transaction
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }
}
