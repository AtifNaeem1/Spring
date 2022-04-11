import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            //create a student object
            System.out.println("Creating student object...");
            Student tempStudent =  new Student("Daffy" , "Duck" ,"daffy@gmail.com");

            //start transaction
            session.beginTransaction();

            //save the student
            System.out.println("Saving the student..");
            System.out.println(tempStudent);
            session.save(tempStudent);

            //commit the transaction
            session.getTransaction().commit();

            //findOut the Student's id : primary key
            System.out.println("Saved student. Generated id: " + tempStudent.getId());

            //now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            //retrieve student based on the id: primary key
            System.out.println("\n Getting students with id: " + tempStudent.getId());

            Student myStudent = session.get(Student.class,tempStudent.getId());

            System.out.println("Get complete: " + myStudent);

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally {
            factory.close();
        }

    }
}
