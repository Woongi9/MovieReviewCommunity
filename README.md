# MovieReviewCommunity

---
## 목차

- [개발 목적](#목적)
- [개발 환경](#환경)
- [사용 기술](#기술)
  + [백엔드](#백엔드)
  + [DB](#데베)
  + [프론트엔드](#프론트)
- [주요 내용](#주요)
- [패키징 구조](#패키지)
- [실행 화면](#화면)
- [시스템 아키텍처](#아케텍처)
- [E-R 다이어그램](#다이어그램)
- [시퀀스 다이어그램](#시퀀스)
- [핵심 기능](#핵심)
  + [로그인 & 로그아웃](#로그인)
  + [쿠키 생성](#쿠키)
  + [세션 관리](#세션)
  + [서블릿 필터](#필터)
  + [타임아웃](#타임아웃)
  + [Firebase DB 접근](#DB접근)
  + [타임리프, 체크박스, 라디오 버튼, 셀렉트 박스](#items)
- [프로젝트를 통해 느낀점](#느낀점)

<br></br>

---

## <div id="목적">개발 목적</div>

 이전에 했던 프로젝트의 기술들과 새롭게 배운 JPA와 Querydsl, Spring Security를 추가로 하여 영화에 대하 리뷰 게시판을 만들어봤습니다. 그리고 추가적으로  AWS의 EC2, RDS, lambda, S3그리고 Travis CI를 업데이트 할 예정입니다.

<br></br>

---

## <div id="환경">개발 환경</div>

* IntelliJ
* Postman
* Github
* h2 Database

<br></br>

---

## <div id="기술">사용 기술</div>

<br></br>

### 주요 프레임워크/라이브러리

### <div id="백엔드">백엔드</div>
+ Java 11 openjdk
+ Spring Boot 2.6.0
+ Spring Security
+ Thymeleaf
+ Lombok
+ JPA
+ Querydsl
+ JPQL

### Build tool
+ Gradle


#### <div id="데베">DB</div>
+ h2

#### <div id="프론트">프론트엔드</div>
+ Javascript
+ HTML/CSS
+ Bootstrap
+ Ajax
+ JSON

<br></br>

---

## <div id="주요">주요 내용</div>

* 개인으로 Spring Boot를 사용하여 웹 애플리케이션 전과정 경험, 운영
* MVC 프레임워크 기반 백엔드 서버 구축
* JPA 사용, Hibernate를 사용한 도메인 설계
* Spring Security를 사용한 로그인 과정

<br></br>

---
## <div id="패키지">패키징 구조</div>

<br></br>

---

## <div id="화면">실행 화면</div>


<br></br>

---

## <div id="아키텍처">시스템 아키텍처</div>
<img width="577" alt="image" src="https://user-images.githubusercontent.com/79649052/160830171-4787b5fb-d9bf-4f36-8cd3-e8b975b00061.png">

<br></br>

---

## <div id="다이어그램">시퀀스 다이어그램</div>
<img width="500" alt="image" src="https://user-images.githubusercontent.com/79649052/160884813-2e96ed49-c764-4900-b4f6-ca493ac1fdc8.png">

<br></br>

---

## <div id="시퀀스">다이어그램</div>

<br></br>

---
## <div id="핵심">핵심 기능</div>

<br></br>

---

## <div id="느낀점">프로젝트를 통해 느낀점</div>

*  그동안 배웠던 스프링 부트와 백엔드에 대해 배운 것을 혼자서 프로젝트를 만드는게 확실히 많이 도움이 되는 것 같다. 강의로 들으면서 따라 치고, 따로 자료를 볼 때는 막연하게 느끼던 개념들을 확실히 직접 생각하고, 부딪혀 보니까 많이 성장함을 느꼈다. 하루에 밥을 먹고, 운동하고, 씻는 시간을 제외한 눈을 뜨고 감을 때까지 이 프로젝트에 열중하고 몰입할 수 있는 시간이었다.
*  지금의 부족한 점 때문에 계속 발전하고 싶다. 다른 프로젝트나 훗날 이 일을 업으로 삼고, 일했을 때 지금과 같은 열정과 성취감으로 발전하는 개발자가 되고싶다. 
*  아직 부족한 점이 많다. 앞으로 이 프로젝트는 현재 배우고있는 JPA도 사용하고, UI도 더 보기 좋게 바꿔놓을 것이다.

<br></br>
---
