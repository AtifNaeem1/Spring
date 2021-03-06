import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCoursesForMaryDemo {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            //start a transaction
            session.beginTransaction();

            //get the student mary from database
            int studentId=2;
            Student tempStudent = session.get(Student.class, studentId);
            System.out.println("\nLoaded Students:  " + tempStudent);
            System.out.println("Courses: " + tempStudent.getCourses());



            //commit transaction
            session.getTransaction().commit();


        }
        finally {
            session.close();
            factory.close();
        }
    }
}
