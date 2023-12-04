package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

//  웹 애플리케이션에서 /hello 라고 검색하면 해당 메서드가 호출
  @GetMapping("hello")
  public String hello(Model model) {
    /*
    * model에 data라는 이름으로 hello!!를 담아서 view에 넘긴다.
    * view에서는 model에 담긴 값을 꺼내서 사용할 수 있다.
    * view는 resources/templates/hello.html
    * */
    
    model.addAttribute("data", "hello!!");
    
    /*
    * return 값이 resources/templates/hello.html
    * 즉, hello 란, templates/hello.html 을 찾아서 렌더링한다.
    * */
    return "hello";
  }
}
