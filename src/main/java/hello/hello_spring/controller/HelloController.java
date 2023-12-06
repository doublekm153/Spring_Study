package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

//  웹 애플리케이션에서 /hello 라고 검색하면 해당 메서드가 호출
  @GetMapping("hello")
  public String hello(Model model) {
    /*
    * model에 data라는 이름으로 hello!!를 담아서 view에 넘긴다.
    * view에서는 model에 담긴 값을 꺼내서 사용할 수 있다.
    * view는 resources/templates/hello.html
    *
    * model.addAttribute 에서 hello 객체를 data 이름으로 추가한다.
    * 뷰 코드에서 data 로 지정한 이름을 통해서 hello 를 사용한다.
    * */
    
    model.addAttribute("data", "hello!!");
    
    /*
    * return 값이 resources/templates/hello.html
    * 즉, hello 란, templates/hello.html 을 찾아서 렌더링한다.
    * */
    return "hello";
  }
  
  /*
  * localhost:8080/hello-mvc?test=안녕
  * 이라고 입력했을 때
  * hello 안녕 이라는 값이 출력된다.
  *
  * @RequestParam("test") 에 test 는 URL 의 파라미터 이름을 나타냄.
  * 안녕 은 파라미터의 값.
  * 즉, @RequestParam("test") 의 test 는 url에서 ? 뒤에 있는 test 를 가리킴.
  *
  * String spring 에서의 spring 은 test=안녕 에서의 안녕을 저장하는 변수.
  * 즉, 안녕 이라는 값이 spring 이라는 문자열 변수에 저장.
  *
  * "data" 는 뷰에서 사용할 데이터의 이름을 나타냄.
  *
  * "data", spring 에서 spring 은 String spring 에서 spring 에 저장된 안녕 이라는 값이다.
  * "data" 라는 이름으로 안녕 을 담아서 hello-template.html 에 넘긴다는 의미.
  * hello-template.html 에서는 hello + 안녕 이라는 값이 출력된다.
  *
  * spring 은 URL 의 test 파라미터 값을 저장.
  * 이 값을 data 라는 이름으로 뷰에 전달.
  * 뷰에서는 ${data} 로 값을 사용.
  * */
  @GetMapping("hello-mvc")
  public String helloMvc(@RequestParam("test") String spring, Model model) {
    model.addAttribute("data", spring);
    return "hello-template";
  }
}
