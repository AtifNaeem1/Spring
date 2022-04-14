import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLOutput;

public class CreateCourseAndStudentsDemo {
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

            //create a course
            Course tempCourse = new Course("Pacman - How to score one million points");

            //save the course
            System.out.println("\nSaving the course ..");
            session.save(tempCourse);
            System.out.println("Saved the course: " + tempCourse);


            //create the students
            Student tempStudent1 = new Student("John", "Doe", "john@gmail.com");
            Student tempStudent2 = new Student("Mary", "Public", "mary@gmail.com");

            //add students to the course
            tempCourse.addStudent(tempStudent1);
            tempCourse.addStudent(tempStudent2);

            //save the students
            System.out.println("\n Saving the students");
            session.save(tempStudent1);
            session.save(tempStudent2);
            System.out.println("Saved students: " +  tempCourse.getStudents());

           //save the course
            session.save(tempCourse);

            //commit transaction
            session.getTransaction().commit();


        }
        finally {
            session.close();
            factory.close();
        }
    }
}
