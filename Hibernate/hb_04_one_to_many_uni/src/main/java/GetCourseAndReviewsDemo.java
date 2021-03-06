import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseAndReviewsDemo {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            //start a transaction
            session.beginTransaction();

            //get the course
            int theId = 10;
            Course tempCourse = session.get(Course.class, theId);

            //print the course
            System.out.println(tempCourse);

            //print course reviews
            System.out.println(tempCourse.getReviews());

            //commit transaction
            session.getTransaction().commit();


        } finally {
            session.close();
            factory.close();
        }
    }
}
