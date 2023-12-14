package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
  
  /*
  * save == 회원이 저장소에 저장됨.
  * findById == 저장소에서 id를 찾음.
  * findByName == 저장소에서 name을 찾음.
  * findAll == 저장소에 있는 모든 회원을 찾음.
  * */
  
  Member save(Member member);
  Optional<Member> findById(Long id);
  Optional<Member> findByName(String name);
  List<Member> findAll();
}
