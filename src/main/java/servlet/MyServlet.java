package servlet;

import model.Person;
import service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MyServlet extends HttpServlet {
    private static final String PATH = "/index.jsp";
    PersonService personService = new PersonService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        List<Person> personList = personService.getAllPersons();
        req.setAttribute("personlist", personList);
        req.getRequestDispatcher(PATH).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("user_id");
        if(id == null){
            Person person = new Person();
            person.setName(req.getParameter("name"));
            person.setLastname(req.getParameter("lastname"));
            personService.createNewPerson(person);
            req.setAttribute("user_id",person.getId());
        } else {
            personService.deletePersonById(id);
        }
            List<Person> personList = personService.getAllPersons();
            req.setAttribute("personlist", personList);
            req.getRequestDispatcher(PATH).forward(req, resp);
    }

}
