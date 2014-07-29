package start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * Spring Application
 * - http://novafactory.net/archives/3095
 * </pre>
 *
 * @author nova
 * @since 2014. 7. 28.
 */
@RestController
@EnableAutoConfiguration
public class Application {

    @RequestMapping("/")
    public String index() {
        return "Hello Wolrd!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
