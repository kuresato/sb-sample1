package sb.sample1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

@SpringBootApplication
@Controller
public class App
{
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("test", "test");
        return "index";
    }

    public static void main( String[] args )
    {
        System.out.println("starting...");
        SpringApplication.run(App.class, args);
    }
}

