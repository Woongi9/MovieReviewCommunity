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
- [클래스 다이어그램](#다이어그램)
- [시퀀스 다이어그램](#시퀀스)
- [핵심 기능](#핵심)
- [프로젝트를 통해 느낀점](#느낀점)

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
* 구글 소셜 로그인 구현

<br></br>

---
## <div id="패키지">패키징 구조</div>

<img width="338" alt="image" src="https://user-images.githubusercontent.com/79649052/168413841-413adc0a-9933-41f8-b41b-dd8f0c636b6d.png">
<img width="338" alt="image" src="https://user-images.githubusercontent.com/79649052/168413921-a6721342-499c-4397-a496-b42355de816a.png">
<img width="338" alt="image" src="https://user-images.githubusercontent.com/79649052/168413936-21219a77-b916-492a-93fd-96b0be88bd5e.png">
<img width="338" alt="image" src="https://user-images.githubusercontent.com/79649052/168413946-3baa19bd-02ac-45fe-a9a8-9bc9fce20e78.png">

<br></br>

---

## <div id="화면">실행 화면</div>

### 1. 로그인 & 로그아웃
#### 1.1 유저 로그인
<img width="80%" src="https://user-images.githubusercontent.com/79649052/168415306-e82e1531-7dec-4e2b-8753-cb258f236408.gif"/>

<br></br>

#### 1.2 구글 소셜 로그인
<img width="80%" src="https://user-images.githubusercontent.com/79649052/168415413-156f061b-0075-4493-852d-eb95730d91a3.gif"/>

<br></br>

### 2. 영화 목록
<img width="80%" src="https://user-images.githubusercontent.com/79649052/168415494-25274eb3-2d60-45f9-ba12-fa62e2698160.gif"/>

_2 페이지부터는 테스트 코드를 통한 반복 생성으로 이미지 따로 지정 X_

<br></br>

### 3. 영화 등록
#### 3.1 유저 권한

<img width="80%" src="https://user-images.githubusercontent.com/79649052/168415509-07e4bbc6-3750-4dce-8587-eb8023157d45.gif"/>

_Chrome에 구글 로그이 되어있느 사용자가 있어 클릭만 해도 별도의 계정 정보 입력없이 로그인_

<br></br>

#### 3.2 관리자 권한

<img width="80%" src="https://user-images.githubusercontent.com/79649052/168415516-8cb2cfcc-7b3c-417d-9a8f-5fc261708224.gif"/>

<br></br>

### 4. 영화 상세 페이지

<img width="80%" src="https://user-images.githubusercontent.com/79649052/168415524-9cee9a0c-4865-47ac-a10d-e5382e9805aa.gif"/>

<br></br>

### 5. 리뷰 등록

<img width="80%" src="https://user-images.githubusercontent.com/79649052/168415565-817eb456-bd26-44db-b39c-1611d59a0079.gif"/>

<br></br>

### 6. 리뷰 수정 & 삭제

<img width="80%" src="https://user-images.githubusercontent.com/79649052/168415591-3a34ddb2-393e-4860-a4b1-9d13a03899ff.gif"/>

<br></br>

---

## <div id="아키텍처">시스템 아키텍처</div>

<img width="752" alt="image" src="https://user-images.githubusercontent.com/79649052/168418835-4e8d448d-7ae8-4302-84e5-772592c0ee2a.png">


<br></br>

---

## <div id="다이어그램">클래스 다이어그램</div>

<img width="860" alt="image" src="https://user-images.githubusercontent.com/79649052/168436350-4f5bfa9d-8652-46fe-ad1e-d111bfa50762.png">

<br></br>

---

## <div id="시퀀스">시퀀스 다이어그램</div>

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
