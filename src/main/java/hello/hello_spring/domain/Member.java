package hello.hello_spring.domain;

public class Member {
  
  /*
  * id == 고객이 정하는 id가 아닌, 시스템이 저장하는 id.
  * domain == 특정한 문제를 해결하기 위한 사용자의 요구사항과 문제 영역을 나타냄. ex) 회원, 주문, 쿠폰 등.
  * Member 클래스는 사용자의 요구사항 중 하나인 "회원" 을 나타냄.
  * id 는 시스템이 저장하는 ID로, 각 회원을 유일하게 식별하기 위한 값으로 DB 에서 주로 사용되는 방식.
  * name 필드는 회원의 이름을 저장하는 변수.
  * 스프링 프로젝트에서의 domain 은 비즈니스 로직을 담당.
  * DB 에 저장될 데이터의 형태를 정의.
  * 도메인 객체는 데이터를 저장하고 처리하는 로직을 포함.
  * 이를 통해 실제 비즈니스 요구사항을 구현.
  * */
  private Long id;
  private String name;
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
}
