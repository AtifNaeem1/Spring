import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            //start transaction
            session.beginTransaction();

            //query students
            List<Student> theStudents = session.createQuery("from Student").getResultList();

            //display the students
            System.out.println(theStudents);


            //query students : lastname=Doe
            theStudents=session.createQuery("from Student s where s.lastName='Doe'").getResultList();
            System.out.println(theStudents);


            //query students: lastname='Doe' or firstName = 'Daffy'
            theStudents=session.createQuery("from Student s where s.lastName='Doe'"
            + " OR s.firstName='Daffy'").getResultList();
            System.out.println(theStudents);
            //commit the transaction
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }
}
