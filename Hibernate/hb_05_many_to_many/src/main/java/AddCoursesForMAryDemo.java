import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForMAryDemo {
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

            //create more course
            Course tempCourse1 = new Course("Rubik's cube - How to Speed Cube");
            Course tempCourse2 = new Course("Atari 2600 - Game Development");


            //add student to courses
            tempCourse1.addStudent(tempStudent);
            tempCourse2.addStudent(tempStudent);


            //save the courses
            System.out.println("\n Saving the courses");
            session.save(tempCourse1);
            session.save(tempCourse2);

            //commit transaction
            session.getTransaction().commit();


        }
        finally {
            session.close();
            factory.close();
        }
    }
}
