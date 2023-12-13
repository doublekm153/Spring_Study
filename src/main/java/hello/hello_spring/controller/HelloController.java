package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/*
  * @Controller 는 스프링이 실행될 때 해당 클래스를 스캔해서 객체를 생성하고 스프링 컨테이너에 넣어둔다.
  *
  * @GetMapping 은 사용자가 localhost:8080/hello 라고 요청을 보내면
  * hello 라는 메서드가 처리하도록 지정한다.
  * 웹 애플리케이션에서 /hello 라고 검색하면 해당 메서드가 호출
  *
  * Model 은 Controller 와 View 사이에 데이터를 전달하는 역할을 하는 객체.
  * Model 인터페이스는 addAttribute 메서드 제공.
  * 해당 메서드를 통해 데이터를 추가하면 뷰에서 이 데이터를 참조할 수 있음.
  * 즉, 컨트롤러에서 뷰로 데이터를 넘겨주는 역할.
  *
  * model 은 Model 인터페이스의 객체의 참조 변수.
  * 해당 변수를 통해 Model 인터페이스의 메서드에 접근할 수 있음.
  *
  * model에 data라는 이름으로 hello!!를 담아서 view에 넘긴다.
  * view에서는 model에 담긴 값을 꺼내서 사용할 수 있다.
  * view는 resources/templates/hello.html
  *
  * model.addAttribute 에서 hello 객체를 data 이름으로 추가한다.
  * 뷰 코드에서 data 로 지정한 이름을 통해서 hello 를 사용한다.
  *
  * return 값이 resources/templates/hello.html
  * 즉, hello 란, templates/hello.html 을 찾아서 렌더링한다.
  * */
@Controller
public class HelloController {
  @GetMapping("hello")
  public String hello(Model model) {
    model.addAttribute("data", "hello!!");
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
  
  /*
  * localhost:8080/hello-string?test=안녕 이라고 입력하면
  * 웹 페이지에는 hello안녕 이라는 값이 출력된다.
  * @ResponseBody 는 http 응답에 이 데이터를 직접 넣어주겠다는 의미.
  * http 통신 프로토콜은 헤더부 + 바디부로 이루어져 있음.
  * @ResponseBody 를 사용하면 바디부에 return 값이 그대로 들어간다.
  * 페이지에서 소스를 보면 html 태그 같은 것이 없고, return 값이 그대로 들어간다.
  * */
  
  @GetMapping("hello-string")
  @ResponseBody
  public String helloString(@RequestParam("test") String spring) {
    return "hello" + spring;
  }
  
  /*
  * api 방식은 객체를 반환하는 것. (JSON 방식)
  * localhost:8080/hello-api?test=안녕 이라고 입력하면
  * 웹 페이지에는 {"name":"안녕"} 이라는 값이 출력된다.
  * Hello 클래스는 name 이라는 필드를 가지고 있음.
  * name 필드를 가져오는 getName, 변경할 수 있는 setName 메서드를 가지고 있음.
  * 즉, Hello 클래스는 name 필드를 가지고 있고,
  * name 필드를 가져오는 getName, 변경할 수 있는 setName 메서드를 가지고 있음.
  * Hello 클래스를 만들고, hello 라는 변수를 생성.
  * hello.setName(spring) 에서 setName 은 Hello 클래스에서 정의한 메서드.
  * setName 메서드는 Hello 클래스의 name 필드를 설정하는 역할.
  * spring 은 helloApi 메서드의 매개변수.
  * String spring 에서의 spring 값이 setName 메서드의 매개변수로 전달.
  * 즉, "안녕" 이라는 값이 setName 메서드의 매개변수로 전달.
  * @ResponseBody 는 http 응답에 이 데이터를 직접 넣어주겠다는 의미.
  * http 통신 프로토콜은 헤더부 + 바디부로 이루어져 있음.
  * @ResponseBody 를 사용하면 바디부에 return 값이 그대로 들어간다.
  * 페이지에서 소스를 보면 html 태그 같은 것이 없고, return 값이 그대로 들어간다.
  * @ResponseBody 어노테이션이 붙은 메서드에서 객체를 반환하면,
  * 스프링 MVC 는 이 객체를 HTTP 응답의 본문에 쓰기 위해 JSON 형태로 변환.
  * 이런 경우, Hello 객체는 { "name": "안녕" } 이라는 JSON 응답을 만들어냄.
  */
  
  @GetMapping("hello-api")
  @ResponseBody
  public Hello helloApi(@RequestParam("test") String spring) {
    Hello hello = new Hello();
    hello.setName(spring);
    return hello;
  }
  
  static class Hello {
    private String name;
    
//    꺼낼 때는 getName 사용
    public String getName() {
      return name;
    }
    
//    넣을 때는 setName 사용
    public void setName(String name) {
      this.name = name;
    }
  }
}