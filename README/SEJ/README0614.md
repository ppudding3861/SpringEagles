<div align="center">
    <H1> Tymeleaf & VueResolve 개념정리 </H1>
</div>

<div align="left">
    <H2> 1. Tymeleaf</H2>
   
</div>

<div>
  <p>
    <h3>1. 개념 </h3>
  </p>
    <li> java 웹 애플리케이션에서 서버사이드 템플릿 엔진으로 사용되는 라이브러리.
     <br>
     <li>서버 사이드 템플릿 엔진으로, HTML, XML 등 템플릿 파일을 서버에서 렌더링하여 클라이언트에게 전달.
     <br>
     <li> 프론트와 백엔드를 연결하고 HTML 템플릿을 동적으로 생성하는 데 사용.
     <br>
     <li> 주로 Spring Framework 와 함께 사용되며, Spring Boot 와의 통합이 원활.


  <p>
    <h3>2. 타임리프의 장점</h3>
  </p>

   <li>Thymeleaf 는 코도를 변경하지 않아 서버팀과 퍼블리셔팀의 협업이 편해짐
    <br>
   <li>비즈니스 로직과 분리되어 View(뷰)단에 집중 할 수 있다
    <br>
   <li> 서버상에서 동작하지 않아도 되기 때문에, 서버 동작 없이 화면을 확인할 수 있음
   


<div>
  <p>
    <h3>3. 타임리프(Thymeleaf) 설정과 기본기능</h3>
  </p>
  
  <li> 설정하기 </li>
  <blockquote>

    xmlns:th=" "

  </blockquote>
  <p>
    -> html 단에 xmlns:th="http://www.thymeleaf.org" 입력하면 된다.
   <br>
    -> 순수 HTML로만 이루어진 페이지인 경우 선언하지 않아도 된다.
  </p>

  
  <br>

  <li> 기본적인 기능 </li>
   <p>
   1. JSP의 EL 표현식 ${}와 마찬가지로 ${} 표현식을 사용해서 컨트롤러에서 전달받은 데이터에 접근 가능.
  </p>
  <blockquote>

    th:text="${}"
   
    예시)
    <div th:text="${data}"></div>

  </blockquote>

-----

  <p>
   2. 변수형태의 값을 재정의하는 속성으로, th:with 를 이용하여 새로운 변수값을 생성할 수 있다
  </p>
  <blockquote>
    
    th:with="${}"
   
    예시)
    <div th:with=”userId=${number}”>

  </blockquote>

-----

  <p>
   3. th:object 속성은 주로 HTML form요소 내에서 사용되며, 객체를 지정하는 데 사용
    이 속성을 사용해서 폼 데이터를 생성하고수정할 때 Thymeleaf가 어떤 객체와 연결되어 있는지 명시적으로 지엉 가능 
    </p>
  <blockquote>
    
    th:object="${}"
   
    예시)
    <form th:object="${myObject}" method="post" action="/submit">

  </blockquote>

-----




  

</div>


</div>
<br><br>

<div align="left">
    <H3> 2. 사용 기술 </H3>
</div>



<br><br>

<div align="left">
    <H3> 3. 객체-관계 모델 - ERD </H3>
</div>

<br><br>

<div align="left">
    <H3> 4. 순서도 - Flow Chart </H3>
</div>




<br><br>

<div align="left">
    <H3> 5. 상세 설명 </H3>
</div>

<div>
  <p>
    1. 키오크크 시작 화면: </br></br>
    2. 키오스크 메인메뉴 화면: </br></br>
    3. 키오스크 주문 상세 페이지: </br></br>
    4. 키오스크 결제 페이지: </br></br>
  </p>
</div>
<br><br>

<div align="left">
    <H3> 6. 진행 상황 </H3>
<details>
<summary> 팁원1 </summary>
<div markdown="1">

+ 24.05.29 : 주문 리스트 뼈대 부분 완성
+ 24.05.31 : 주문 리스트 & 결제 금액 뼈대 완성

</div>
</details>

<details>
<summary> 팁원1 </summary>
<div markdown="1">

+ 24.05.28 : Footer 레이아웃 완성
+ 24.05.29 : 메인메뉴 레이아웃 거의 완성.
+ 24.05.30 : 리드미 이미지 추가
+ 24.05.31 : json data 추가

</div>
</details>

<details>
<summary> 팁원1 </summary>
<div markdown="1">

+ 24.05.28 레이아웃 뼈대 완성
+ 24.05.29 결제페이지 및 css 부분완성

</div>
</details>

<details>
<summary> 팁원1 </summary>
<div markdown="1">

+ 내용을  적으시오

</div>
</details>

<details>
<summary> 팁원1 </summary>
<div markdown="1">

+ 내용을  적으시오

</div>
</details>

<details>
<summary> 팁원1 </summary>
<div markdown="1">

+ 내용을  적으시오

</div>
</details>
