package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("Hellooo") // 이걸 get 하면
    public String Hello(Model model) {
        model.addAttribute("data", "SJ");
        return "hello"; // 이걸 렌더링해라 ( /templates/hello.html )
    }

    @GetMapping("hello-mvc")
    public String HelloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String HelloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello HelloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);

        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

