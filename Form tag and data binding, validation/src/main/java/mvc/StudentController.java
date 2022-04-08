package mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/showForm")
    public String showForm(Model theModel)
    {
        //add student object to a model
        theModel.addAttribute("student" , new Student());

        return "student-form" ;
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student theStudent)
    {
            //log the information
        System.out.println("First name: " + theStudent.getFirstName() + "\n" +
                "Last Name" + theStudent.getLastName());

        return "student-confirmation";
    }
}
