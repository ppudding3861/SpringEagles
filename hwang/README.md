 1. Thymeleaf
타임리프는 흔히 View Template(뷰 템플릿)이라고 부른다.

뷰 템플릿은 컨트롤러가 전달하는 데이터를 이용하여 동적으로 화면을 구성할 수 있게 해준다.

📌 2. JSP와 Thymeleaf 차이점
기존 MVC 패턴 방식에는 JSP를 사용하였다.

먼저 JSP 의 경우에는 서블릿 이라는 형태로 변환되어 실행이 된다.

서블릿이 자바 소스이다 보니 HTML 코드에서 JAVA 코드를 넣어 동적 웹페이지를 구성한다.

Thymeleaf는 HTML, JS, CSS 등을 처리할 수 있는 웹 및 독립형 환경에서 사용이 가능한 java 템플릿 엔진이다.

또한 서블릿으로 변환되지 않기 때문에 비즈니스 로직이 완전히 분리된다.

Thymeleaf 템플릿 엔진의 장점은 페이지를 생성하는데 필요한 정보를 태그의 속성으로 넣을 수 있어 유지보수가 간단하다.


📌 3. Spring boot에 Thymeleaf 적용하기
먼저 Thnymeleaf를 사용하기 위해서는 dependency를 추가 해야된다.

📖 Maven(pom.xml)
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
📖 Gradle(build.gradle)
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
    ...
}
타임리프는 MVC패턴 중 View 역할을 담당하고 있기 때문에 데이터 값을 받기 위해선 Controller 가 필요하다.

📖 index.html
<a href="thleaf/ex1">연습 1</a><br/>
처음 메인페이지에서 연습1 이라는 하이퍼링크를 클릭하면 서버 Cotroller에게 요청을 보낸다.

📖 Controller.java
@Controller
@RequestMapping(value="thleaf")
public class NiceController {
   @GetMapping("/ex1")
   public String abc1(Model model) {
      ItemVo vo = new ItemVo();
      vo.setId("korea1");
      vo.setName("사과");
      vo.setPrice(5000);
      vo.setRegDate(LocalDate.now());
      
      model.addAttribute("vo", vo);
      return "show1";
   }
}
@Controller 선언을 통해 NiceController 클래스는 Controller 역할을 한다.

Controller는 "/thleaf"로 시작하는 모든 요청을 처리하고 "/ex1" 경로로 들어오는 GET 요청

을 처리하는 메소드인 abc1을 정의하고 있다.

이 메소드는 Model 객체를 매개변수로 받아서 모델에 데이터를 추가하고, "show1"이라는 뷰 이름을 반환하여 데이터를 보내게 된다.

📖 show1.html (Thymeleaf)
<html xmlns:th="http://www.thymeleaf.org">
<!-- 생략 -->
<table border="1">
	<tr>
		<td>
			아이디
			<span th:text="${vo.id}"></span>
		</td>	
	</tr>
	<tr>
		<td>
			상품명
			<span th:text="${vo.name}"></span>
		</td>	
	</tr>
	<tr>
		<td>
			가격
			<span th:text="${vo.price}"></span>
		</td>	
	</tr>
	<tr>
		<td>
			등록일
			<span th:text="${vo.regDate}"></span>
		</td>	
	</tr>
</table>
<!-- 생략 -->
</html>
Controller 에게 데이터 값을 받은 view templats 이다.

우리가 아는 HTML이 아니라 thymeleaf 문서이다.

<html xmlns:th="http://www.thymeleaf.org">
html 문서언어는 타임리프를 사용하겠다는 의미이다.

<th:text="${vo.id}"
이 코드는 서버에서 받은 데이터를 화면에 표시하는 데 사용된다.

${vo.id} 이 부분은 Thymeleaf에서 변수나 객체의 속성을 표현할 때 사용하는 표현식이다.

뷰 리졸버(View Resolver)
먼저 핸들러 매핑과 핸들러 어댑터를 통해 핸들러를 실행한 이후, 핸들러(컨트롤러)가 처리하고 ModelAndView를 반환한다.
이후 ModelAndView를 알맞은 View로 전달하기 위해 DispatcherServlet에 의해 뷰 리졸버가 호출된다.
 
즉, 뷰 리졸버는 ModelAndView 객체를 View 영역으로 전달하기 위해 알맞은 View 정보를 설정하는 역할을 한다.
 
뷰 리졸버 활용 예제
OldController.java
@Component("/springmvc/old-controller")
public class OldController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");

        return new ModelAndView("new-form");
    }
}
위 코드는 스프링 MVC의 Controller 인터페이스의 구현체 핸들러(컨트롤러)이다.

별다른 로직을 수행하지 않으며, ModelAndView 객체를 반환한다.
ModelAndView에는 “new-form”이라는 문자열 데이터를 포함하고 있다.

 
new-form.jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<form action="save" method="post">
  username: <input type="text" name="username" />
  age: <input type="text" name="age" />
  <button type="submit">전송</button>
</form>
</body>
</html>
위 코드는 뷰 리졸버가 찾아서 설정할 실제 View이다.
해당 코드 파일의 위치가 “webapp/WEB-INF/views/”에 위치하고 있다고 가정한다.
 
프로젝트를 실행 후 http://localhost:8080/springmvc/old-controller에 접속하면 Whitelabel Error Page 오류가 발생할 것이다.
 
application.properties
spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix=.jsp

위 코드를 application.properties에 추가하여 다시 실행하면 해당 View가 정상적으로 반환될 것이다.
 
뷰 리졸버 - InternalResouceViewResolver
스프링 부트는 InternalResouceViewResolver라는 뷰 리졸버를 자동으로 등록한다.
이때 application.properties에 등록한 설정 정보를 사용하여 등록하게 된다.


또는 OldController의 리턴 값을 new ModelAndView(”/WEB-INF/views/new-form.jsp”)으로 전체 경로를 주어도 동작하기는 하나 권장하지 않는 방법이다.
 
뷰 리졸버의 동작 방식
스프링 부트가 자동으로 등록하는 뷰 리졸버의 종류는 다양하다.
// 빈 이름으로 뷰를 찾아서 반환한다. (예: 엑셀 파일 생성기능에 사용)
1 = BeanNameViewResolver

// JSP를 처리할 수 있는 뷰를 반환한다.
2 = InternalResourceViewResolver

...

이 외에도 다양한 뷰 리졸버가 있다.


![alt text](image.png)

핸들러 어댑터를 통해 논리 뷰 이름을 획득한다.

new-form 획득


ViewResolver를 순차적으로 호출한다.

InternalResourceViewResolver 호출


뷰 리졸버는 뷰 정보를 반환한다.

뷰 리졸버는 InternalResourceView를 반환


반환된 뷰 정보는 forward()를 호출해서 처리할 수 있는 경우에 사용한다.

InternalResourceView는 forward()를 호출


view.render()가 호출되고 해당 뷰가 실행된다

view.render() 호출되고 InternalResourceView는 forward()를 사용해서 JSP를 실행



 
출처: https://ittrue.tistory.com/237 [IT is True:티스토리]