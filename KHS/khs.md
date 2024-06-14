<div align="center">
    <H1> ViewResolver와 Thymeleaf란? </H1>
</div>

<details>
<summary> ** ViewResolver란? **</summary>
<div markdown="1">

### ViewResolver란?
- 실행할 뷰를 찾는 일을 한다.
- 페이지 컨트롤러가 리턴한 뷰 이름에 해당하는 뷰 컴포넌트를 찾는 역할

### 종류는?
- ResouceBundleViewResolver
  *.properties 에서 뷰 이름에 해당하는 컴포넌트의 URL을 찾는다.

- InternalResourceViewResolver
  미리 지정된 접두사, 접미사를 사용하여 뷰 이름으로 컴포넌트의 URL을 완성해 URL을 지정하기 편리하다.
  교체방법은 XML에서 설정하는 방법과 Java Config로 설정하는 방법이 있다.

### 실행과정
- 페이지 컨트롤러는 클라이언트가 요청한 작업을 실행한 후 그 결과를 출력할 뷰의 이름을 리턴한다.
- 프론트 컨트롤러는 RequestHandler가 리턴한 URL을 ViewResolver가 찾아서 실행한다.
- 실행된 결과는 클라이언트에게 응답한다.

</div>
</details>

<details>
<summary> Thymeleaf란? </summary>
<div markdown="1">

### Thymeleaf란?
- 자바 기반의 템플릿 엔진으로 Html,xml,javascript, css 등 다양한 텍스트 파일을 렌더링하는데 사용됩니다.
- 주로 Spring Framework와 함께 사용되며, 서버 사이드 템플릿 엔진으로서 동적 웹 페이지를 생성하는 데 매우 유용하다.

## 특징
1. Natural Templates
- Thymeleaf 템플릿은 브라우저에서 직접 열어도 유효한 HTML로 보일 수 있습니다. 이는 개발자와 디자이너 간의 협업을 용이하게 한다.
- Thymeleaf 문법은 HTML 주석이나 속성으로 표현되기 때문에, 템플릿 파일 자체가 유효한 HTML이 된다.

2. 표현식
- `${...}` : 변수 표현식
- `@{...}` : URL 표현식
- `#{...}` : 메세지 표현식
- `${...}` : 연산 표현식
- `th:text` : 텍스트 출력
- `th:utext` : 유니코드 텍스트 출력
- `th:each` : 반복문
- `th:if` : 조건문
- `th:switch` : 스위치문

3. 확장성
- 사용자 정의 속성(dialect)을 추가하여 기능을 확장할 수 있다.
- 다양한 템플릿 모드(HTML,XML,TEXT등)을 지원하여 유연하게 사용할 수 있다.

4. Thymeleaf의 주요 기능
- 변수 표현식: ${...}을 사용하여 모델 데이터를 템플릿에 바인딩.
- 조건부 평가: th:if 및 th:unless 속성을 사용하여 조건부로 콘텐츠를 렌더링.
- 반복 처리: th:each 속성을 사용하여 컬렉션을 반복 처리.
- 링크 생성: th:href 및 th:src 속성을 사용하여 동적으로 URL을 생성.
- 폼 지원: th:action 및 th:object 속성을 사용하여 폼 데이터를 처리.
</div>
</details>
