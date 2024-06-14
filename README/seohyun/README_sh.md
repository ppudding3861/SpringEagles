# Spring MVC(Model-View-Controller)
Spring MVC는 스프링 프레임워크의 웹 애플리케이션 개발을 위한 모듈.<br>쉽고 구조화된 방식으로 할 수 있게 도와줌.<br>각 역할이 분리되어 유지보수가 용이하고 확장성도 뛰어남<br>

-Model : 애플리케이션의 데이터, 비즈니스 로직을 처리(서비스, DAO)<br>
-View : 사용자에게 데이터를 시각적으로 표시하는 부분(JSP, Thymeleaf)<br>
-Controller : 사용자의 요청을 처리하고 모델과 뷰를 연결하는 부분
<br>
<br>

<h3>MVC의 동작 흐름</h3>
사용자가 웹 브라우저에서 요청을 보냄-서블릿으로 전달-적절한 컨트롤러에 매핑-요청을 처리해서 렌더링할 뷰 결정-모델 데이터를 사용하여 뷰를 렌더링-사용자에게 html형태로 응답
<br>
<br>

***

<br>
<br>
<br>
<br>


# * View Resolve
컨트롤러 메소드에서 반환하는 뷰 이름을 처리해서 클라이언트에게 응답을 렌더링해준다.

ex)<br><br>
@Controller
public class ClassMappingTestController {

	@GetMapping("/regist")
	public String registOrder(Model model) {
		model.addAttribute("message", "메소드 호출 Practice");
		// 실제 view name 을 반환해서 전달
		// template engine 안에 있는 view resolver에서 찾음
		return "mappingResult";
	}
}

<br>

***
<br>
<br>
<br>
<br>

# * Thymeleaf
자바 기반의 서버사이드 템플릿 엔진.<br>동적인 웹 페이지를 생성하는데 사용됨<br>주로 Spring MVC(Model-View-Controller)와 함께 사용되는데 html파일을 템플릿으로 사용.

표현식은 th:text, th:href 등의 속성을 사용함

스프링부트가 자동으로 Thymeleaf를 위한 뷰 리졸버를 설정함

<h3 th:text="${message}"></h3>
