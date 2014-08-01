package jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <pre>
 * Hello Controller
 * </pre>
 *
 * @author nova
 * @since 2014. 7. 30.
 */
@RestController
public class HelloController {

    @Autowired
    private HelloDao dao;

    @RequestMapping("/")
    public List getAllListForBeanPropertyRowMapper() {
        return dao.listForBeanPropertyRowMapper();
    }

    @RequestMapping(value = "/add")
    public String add(@RequestParam("name") String name, @RequestParam("message") String message) {
        Hello hello = new Hello();
        hello.setName(name);
        hello.setMessage(message);

        int affectedRows = dao.insert(hello);
        if (affectedRows != 1) {
            return "Error!!";
        } else {
            return "Insert to Hello: " + name + ", " + message;
        }
    }

    @RequestMapping("/custom")
    public List getAllListCustomRowMapper() {
        return dao.listForCustomRowMapper();
    }

}
