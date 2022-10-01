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
- [시스템 아키텍처](#아키텍처)
- [클래스 다이어그램](#다이어그램)
- [시퀀스 다이어그램](#시퀀스)
- [핵심 기능](#핵심)
  + [계층형 구조 아키텍처 설계](#핵심0)
  + [DTO 계층과 서비스 계층 구성](#핵심1)
  + [JUnit Test 구현](#핵심2)
  + [JpaRepository를 통한 CRUD 구현](#핵심3)
  + [로그인 여부 확인](#핵심4)
  + [비밀번호 암호화](#핵심5)
  + [구글 소셜 로그인과 회원가입](#핵심6)
  + [로그인시 JPQL을 사용해 이메일 정보 검색](#핵심7)
  + [유저 권한에 따른 페이지 접근 제한](#핵심8)
  + [목록 페이지 처리](#핵심9)
  + [Querydsl을 사용한 영화 검색](#핵심10)
  + [Modal 창으로 리뷰 리스트 출력](#핵심11)
  + [리뷰 별점](#핵심12)
  + [이미지 업로드](#핵심13)
  + [이미지 클릭 & 사진 확대](#핵심14)

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
+ Querydsl

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

* 개인으로 Spring Boot로 [계층형 아키텍처](https://velog.io/@woongi9/%EC%95%84%ED%82%A4%ED%85%8D%EC%B2%98-%EA%B3%84%EC%B8%B5%ED%98%95-%EC%95%84%ED%82%A4%ED%85%8D%EC%B2%98) 기반  웹 애플리케이션 전과정 경험, 운영
* MVC 프레임워크 기반 백엔드 서버 구축
* [JPA 사용, Hibernate](https://velog.io/@woongi9/JPA%EC%99%80-ORM-%EC%86%8C%EA%B0%9C)를 사용한 [RDBMS](https://velog.io/@woongi9/RDBMS%EC%99%80-NoSQL) 도메인 설계
* [Spring Security를 사용한 로그인 과정](https://velog.io/@woongi9/%EC%8A%A4%ED%94%84%EB%A7%81-Spring-Security-%EB%A1%9C%EA%B7%B8%EC%9D%B8-%EA%B3%BC%EC%A0%95-%EC%84%A4%EB%AA%85%ED%9A%8C)
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

1. 영화 목록
<img width="724" alt="image" src="https://user-images.githubusercontent.com/79649052/168443636-88e4e419-ed6e-4351-af30-a0c8760fbc4f.png">
<br></br>

2. 영화 개별 페이지
<img width="543" alt="image" src="https://user-images.githubusercontent.com/79649052/168444016-3d12cec4-bca8-4581-8581-ea97987abca6.png">
<br></br>

3. 영화 등록
<img width="657" alt="image" src="https://user-images.githubusercontent.com/79649052/168444545-0df7af67-c9f0-47b4-85ea-5686cd79f7bb.png">
<br></br>

4. 리뷰 출력
<img width="608" alt="image" src="https://user-images.githubusercontent.com/79649052/168445286-88c3585a-a01e-4abf-8d66-d4cc13433ac9.png">

<br></br>

5. 리뷰 등록
<img width="490" alt="image" src="https://user-images.githubusercontent.com/79649052/168445114-dde5162f-af53-4035-b732-de46fd97c994.png">
<br></br>

6. 리뷰 수정
<img width="444" alt="image" src="https://user-images.githubusercontent.com/79649052/168445428-36bef563-a85e-4dd3-9ed8-92834634754a.png">

<br></br>

---
## <div id="핵심">핵심 기능</div>

### <div id="핵심0">계층형 구조 아키텍처 설계</div>

<img width="319" alt="image" src="https://user-images.githubusercontent.com/79649052/188583339-85b16ac1-7963-43b0-806c-e0bdc4be69df.png">

* **계층형 구조 사용**
  * controller : 웹 계층
  * service : 비즈니스 로직, 트랜잭션 처리
  * repository : JPA를 직접 사용하는 계층, 엔티티 매니저 사용
  * domain : 엔티티가 모여있는 계층, 모든 계층에서 사용

_토비의 스프링 3계층 아키텍처 참고_

<br></br>

### <div id="핵심1">DTO 계층과 서비스 계층 구성</div>
<img width="192" alt="image" src="https://user-images.githubusercontent.com/79649052/168465090-5785f231-564e-45ae-a778-5f029a60b9c2.png">
<img width="192" alt="image" src="https://user-images.githubusercontent.com/79649052/168465146-1e04758c-dce5-4b8b-bd8c-6371f350b08f.png">

* 화면에 전달하는 데이터이거나 화면 쪽에서 전달되는 데이터 기준으로 DTO 구성
* 서비스 계층에는 기본적으로 DTO에서 Entity로 Entity에서 DTO로 하는 함수와 추가적으로 DTO를 파라미터로 받을 때의 검색, 삭제, 수정 등 필요 함수 구현
<br></br>

### <div id="핵심2">JUnit Test 구현</div>

<img width="223" alt="image" src="https://user-images.githubusercontent.com/79649052/168465177-8c75cf52-60d9-4658-8bbb-acf2f8771a66.png">
* 회원과 영화, 리뷰 예시 추가와 삭제 수정 등 웹 페이지로 구현 전 사전의 기능 확인 코드 JUnit Test를 통해 구현하고 확인과 수정
<br></br>

### <div id="핵심3">JpaRepository를 통한 CRUD 구현</div>

* JpaRepository는 CRUD 구현 뿐만 아니라 paging, sorting, jpa 특화 기능이기에 모든 Repository 인터페이스는 JpaRepository를 상속


<br></br>

### <div id="핵심4">로그인된 상태 확인</div>

<img width="347" alt="image" src="https://user-images.githubusercontent.com/79649052/168465422-26dd00a2-d46f-4e39-a242-9fd4eeaf441a.png">
<로그인X>

<img width="347" alt="image" src="https://user-images.githubusercontent.com/79649052/168465449-8a6159ed-08d6-4dce-bc88-525b0b9160b5.png">
<로그인O>

<img width="508" alt="image" src="https://user-images.githubusercontent.com/79649052/168465488-ebe0c87e-57c7-4012-ae38-87f52c99bf82.png">
* 스프링 시큐리티를 통해 로그인하는 과정이므로 Thymeleaf security의 Authorize 함수를 통해 현재 로그인이 된 상태인 경우 로그아웃 버튼만 보이게 페이지 출력되고, 로그아웃인 상태인 경우 로그인 버튼이 보이게 페이지가 출력된다.
<br></br>

### <div id="핵심5">비밀번호 암호화</div>
  
<img width="344" alt="image" src="https://user-images.githubusercontent.com/79649052/168465710-281a6e63-250a-4b5e-8fa4-bf1fa3df4702.png">
<img width="568" alt="image" src="https://user-images.githubusercontent.com/79649052/168465749-89ef816a-7b13-4311-8f38-715068672240.png">
* BCryptPasswordEncoder는 bcrypt라는 해시 함수를 이용해 패스워드 암호화

* 복호화는 불가능하므로 DB 유출 시에도 비밀번호를 맞출 수 없다.

<img width="538" alt="image" src="https://user-images.githubusercontent.com/79649052/168465811-ddf69bbe-b212-464f-bfc8-ec0a557f18ec.png">
* 패스워드 JUnit 테스트 코드를 통해 이전의 비밀번호와 암호화된 비밀번호는 같은 String 으로 출력되는 것을 PasswordEncoder의 matches 메소드 true 값으로 확인할 수 있다.
<br></br>

### <div id="핵심6">구글 소셜 로그인과 회원가입</div>
  
[구글 소셜 로그인과 회원가입](https://github.com/Woongi9/MovieReviewCommunity/blob/master/src/main/java/org/zerock/review/security/service/OAuth2UserDetailsService.java/loadUser)
* 회원가입이 되지 않은 상태에서는 SaveSocialMember 메소드를 통해 회원가입과 DB에 엔티티가 저장되며 로그인

* 회원가입이 된 회원인 경우 loadUser를 통해 로그인되며 AuthMemberDTO로 리턴되면서 회원 정보를 전달
<br></br>

### <div id="핵심7">로그인시 JPQL을 사용해 이메일 정보 검색</div>
  
<img width="690" alt="image" src="https://user-images.githubusercontent.com/79649052/168466569-487ad144-2b76-4b68-97f5-4511d100b3ad.png">
* 로그인 과정이 구글 소셜 로그인과 아이디 비밀번호를 입력하는 일반 로그인이 있어서 이 둘을 나누는 기준이 Member 엔티티에서 fromSocial을 통해 두 로그인 방식을 구분과 이메일이 등록되어있는지 확인한다.
<br></br>

### <div id="핵심8">유저 권한에 따른 페이지 접근 제한</div>
  
<img width="510" alt="image" src="https://user-images.githubusercontent.com/79649052/168466746-b40b2ef8-ea0e-43ed-9c4b-fd3b95e1d2f9.png">
<img width="510" alt="image" src="https://user-images.githubusercontent.com/79649052/168466754-9d800c18-8f09-4547-a4cc-a857d7c0e314.png">
<img width="392" alt="image" src="https://user-images.githubusercontent.com/79649052/168466770-1693dea1-e931-4a82-954c-4c235e0a48a0.png">

* 스프링 시큐리티의 @PreAuthorize를 통해 현재 사용자의 MemberRole의 상태에 따라 페이지 들어갈 수 있는 자격이 있는지 확인한다.

* 리스트 페이지는 “permitAll()”를 통해 모두가 입장 가능하지만 영화 상세 페이지는 “hasRole(‘USER’)”
를 통해 유저의 권한을 가진 사용자만 들어갈 수 있고, 
영화 등록 페이지는 “hasRole(‘MANAGER’)”
를 통해 관리자 권한을 가진 사용자만 입장 가능하다.
<br></br>

### <div id="핵심9">목록 페이지 처리</div>
  
<img width="606" alt="image" src="https://user-images.githubusercontent.com/79649052/168467408-dc1757a1-3cf7-4e9b-bab1-1246415fae39.png">

<img width="606" alt="image" src="https://user-images.githubusercontent.com/79649052/168467397-1655cb78-d4d5-4f16-85f0-d8cfad896dc4.png">


[PageRequestDTO](https://github.com/Woongi9/MovieReviewCommunity/blob/master/src/main/java/org/zerock/review/dto/PageRequestDTO.java)

[PageResultDTO](https://github.com/Woongi9/MovieReviewCommunity/blob/master/src/main/java/org/zerock/review/dto/PageResultDTO.java)

* PageRequestDTO를 현재 페이지에서 필요한 영화의 목록들 페이지 숫자와 페이지 별 리스트 사이즈를 PageResultDTO로 전달

* PageResultDTO는 이에 맞춰 해당 페이지 리스트를 만들어주고 페이지 번호를 출력하고 밑에 Prev 버튼은 클릭시 클릭할 수 있는 맨 오른쪽 페이지에서 +1, Next 버튼은 맨 왼쪽 페이지에서 -1로 기능하도록 페이지 번호와 같이 출력
<br></br>

### <div id="핵심10">Querydsl을 사용한 영화 검색</div>

#### 22.05.27 기능 추가 완료

<img width="254" alt="image" src="https://user-images.githubusercontent.com/79649052/170722856-f2ad79c5-1c6c-45aa-9cfa-a45cf3a1d768.png">

<img width="847" alt="image" src="https://user-images.githubusercontent.com/79649052/170722750-617f0e19-e82e-4e5d-af1e-99a509bb7408.png">

* 저장소에 새로운 검색 처리 저장소를 만들고 SearchPage 함수를 Qdsl을 통해 구현

  <img width="635" alt="image" src="https://user-images.githubusercontent.com/79649052/170722402-038ef56d-cc6f-4883-bc25-376f3ea46373.png">
  
* 검색 결과 화면
<br></br>

### <div id="핵심11">Modal 창으로 리뷰 리스트 출력</div>
  
<br></br>

### <div id="핵심12">리뷰 별점</div>
  
<img width="490" alt="image" src="https://user-images.githubusercontent.com/79649052/168467268-b16a61a8-df92-4a7d-b251-05d3fa4f5c59.png">

* starr 라이브러리를 통해 별점 입력 UI 적용
<br></br>

### <div id="핵심13">이미지 업로드</div>
  
<img width="626" alt="image" src="https://user-images.githubusercontent.com/79649052/168470843-7d9deab4-b9ad-4a5d-a8a0-7ad96c356e15.png">

* 이미지를 업로드 한다면 ajax 를 통해 PostMapping으로 UploadController에 보내주고, 올라온 파일들은 썸네일용 이미지를 추가하여 현재 시간에 맞는 폴더를 생성하고 저장한다.

* 그리고 JavaScript의 함수로 저장된 썸네일 이미지들을 이미지 추가 밑에 보이도록 구현

* x를 누르면 ajax로 PostMapping으로 해당 이미지를 uploadController의 RemoveFile메소드로 삭제해준다.

<br></br>

### <div id="핵심14">이미지 클릭시 확대</div>
  
<img width="626" alt="image" src="https://user-images.githubusercontent.com/79649052/168471419-11779e12-39c1-4648-b100-78d8e10c0c61.png">

* 영화 상세 페이지에서 이미지 클릭시 ajax의 함수로 UploadController의 display 메소드를 매핑하여 해당 이미지의 썸네일 사진이 아닌 원본 사진을 Modal 창으로 띄워준다.
<br></br>


### <div id="핵심15">AWS EC2 & RDS 배포</div>

#### 22.06.01 기능 추가 완료
  
 <img width="569" alt="image" src="https://user-images.githubusercontent.com/79649052/171350068-3e30841b-e472-48cd-9779-a16f87f9677c.png">

<img width="723" alt="image" src="https://user-images.githubusercontent.com/79649052/171349817-cf9f050b-b633-4e3d-bccf-fa77cfe31fcd.png">

* AWS의 EC2와 RDS를 연동해서 인프라 구축하고 배포

* AWS EC2 서버 내의 이미지 저장 파일 경로 설정 오류


<br></br>

---

## <div id="느낀점">프로젝트를 통해 느낀점</div>

* 지금까지 배워 본 스프링 부트와 스프링 시큐리티 그리고 JPA, Querydsl 등 다양한 기술을 최대한 녹여내려고 노력했다. 하다보니까 점점 더 기술에 욕심나고 아직 실제 사이트에 비하면 많이 조잡하다. 더 촘촘하고 짜임새있는 홈페이지를 만들기 위해서 후에 AWS와 같은 인프라와 DevOps 기능을 추가해서 더 완성도 높은 프로젝트로 만들 예정이다.

* 사실 혼자서 진행중인 프로젝트이기에 꾸준하게 공부하고 이 프로젝트에 녹여내려고 많은 시간을 들였다. 하루에 12시간 넘게 해본적도 있었는데 벽에 부딪힐 때마다 다양한 구글링과 개발자들의 카페에 질문을 올리면서 오류를 수정하며 프로젝트를 진행했다. 이제 드는 생각은 게임을 할 때처럼 한 게임 진다고 무너지지 않고 더 높은 실력과 실력 점수를 가지기 위해 더 열심히 하려는 마음 가짐을 개발에 가질 수 있게 노력하고 있다. 그럼에도 혼자 진행한다는 것의 단점이라면 잘 하고있는지 올바른 방향으로 가고 있는지 잘 알 수가 없다. 점점 구체적인 기능을 구현하기에는 구글링 등으로도 쉽게 찾을 수가 없어진다. 실제 현직에서 경험을 쌓고, 조언과 질문을 구할 사람이 있었으면 더 빠른 성장을 할 수 있을거라고 생각한다.

* 6월 8일 현재 h2를 데이터 베이스로 사용하였지만 mariadb로 바꾸며 자동 생성되던 sql schema를 직접 작성해줘서 AWS RDS에 데이터베이스 테이블을 생성해줘야 하지만 기존의 내 코드에서 수정하는데 이곳저곳 오류가 발견되고 이를 수정중



<br></br>
---
