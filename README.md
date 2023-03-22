# 나만의 게시판 만들기(Spring boot + Ajax)

> 전반적인 웹의 기본 소양이 되는 게시판(블로그) 프로젝트입니다.
>
<img width="1901" alt="메인화면_로그인" src="https://user-images.githubusercontent.com/97447334/224917221-7a1b0fec-c22a-4168-8907-7d56b917368e.png">

## 목차

- [들어가며](#들어가며)
    - [프로젝트 소개](#1-프로젝트-소개)
    - [프로젝트 기능](#2-프로젝트-기능)
    - [기술 스택](#3-기술-스택)
        - [프론트엔드](#프론트엔드)
        - [백엔드](#백엔드)
    - [실행 화면](#4-실행-화면)

- [구조 및 설계](#구조-및-설계)
    - [DB 설계](#1-DB-설계)
    - [API 설계](#2-API-설계)

- [마치며](#마치며)
    - [아쉬운 점](#1-아쉬운-점) 
    - [후기](#2-후기)

# 들어가며.

## 1. 프로젝트 소개

> 지금까지 공부해온 지식들로 프로젝트를 한 번 구현을 해보고자 하였습니다.<br> 
> 웹 프로그래밍의 기본 소양이라고 할 수 있는 게시판을 직접 만들어보고 원하는 정보를 효과적으로 검색하는 법, 좋은 질문을 하는 방법 또한 함께 습득하고자 하였습니다.<br>
> 독학으로 습득한 지식들을 이용해 제작한 첫 프로젝트이기 때문에 만족감을 가지고 있지만, 한편으로는 아쉬운 점과 함께 보완할 부분도 많이 느꼈습니다.  

- CRUD + Rest API + 비동기통신
    - 평소 비동기 사이트에 대해 깔끔함과 쾌적함을 느껴 비동기 웹사이트 제작을 다짐했습니다.
- 개발 기간 : 23.01.12 ~ 23.03.07
- 참여 인원 : 1명

## 2. 프로젝트 기능

- **사용자**
    - 회원가입시 유효성 검사 및 중복 검사
    - Security 회원가입 및 로그인
    - 스프링 시큐리티를 이용한 권한별 렌더링 및 로그인 기능 제공
    - OAuth 2.0 소셜 로그인 (구글, 페이스북)
    - 회원정보 수정
- **게시판**
    - CRUD 기능
    - 썸머노트를 이용한 글쓰기 폼 제공
    - 조회수
    - 페이징
    - 카테고리 지정
- **댓글**
    - CRUD 기능
- **관리자**
    - 전체 회원 조회 가능
        - 각 회원 게시물 확인가능
        - 일반 회원 등급 변경 가능 (`USER` <-> `ADMIN`)
    - 관리자는 게시물 삭제 권한 부여

## 3. 기술 스택

### 프론트엔드

- Html/Css
- JavaScript
- Ajax
- Thymeleaf
- Bootstrap 4.3.1

### 백엔드

**Language |** Java 11

**Framework |** Spring 5.3.21 (Spring Boot 2.7.7, Spring MVC 5.3.24, Spring Data JPA 2.7.7)

**Build Tool |** Gradle 7.6

**DB |** MySQL 8

### 💉️ 주요 Dependency

- Lombok
- Spring Security
- OAuth2
- JPA
- Thymeleaf
- P6SPY

## 4. 실행 화면

<details>
    <summary>메인 화면</summary>

#### 1. 비 로그인시

<img width="1912" alt="스크린샷 2023-03-14 오후 5 40 36" src="https://user-images.githubusercontent.com/97447334/224944473-bc0dbfba-88a6-43f4-ae13-3d120355e288.png">
- 비로그인시 회원가입 / 로그인 기능만 활성화

#### 2. 로그인했을 시

<img width="1914" alt="스크린샷 2023-03-14 오후 5 40 45" src="https://user-images.githubusercontent.com/97447334/224944462-de617855-f02f-4fc6-844d-2ece66490d0c.png">

- 로그인시 글쓰기 및 카테고리별 글 확인 가능 활성화
- 회원정보 수정, 로그아웃 기능 활성화

</details>

<br>

<details>
    <summary>회원 관련</summary>

#### 1. 회원가입 화면

<img width="1163" alt="image" src="https://user-images.githubusercontent.com/97447334/224927791-3d50a0f2-1c69-43c4-9dad-41f158d11ef3.png">
<img width="446" alt="image" src="https://user-images.githubusercontent.com/97447334/224928100-f96900f2-5fb8-4a0c-9242-6c7dffdd083b.png">
<img width="443" alt="image" src="https://user-images.githubusercontent.com/97447334/224928136-c7e8c91c-b320-4d9b-ad27-96e197589cd3.png">
<img width="441" alt="image" src="https://user-images.githubusercontent.com/97447334/224928225-297409cd-b9cc-48aa-a48d-04d6e71992fd.png">
<img width="444" alt="image" src="https://user-images.githubusercontent.com/97447334/224928416-855873d1-00a6-494b-a0d2-461ff7f5ff3d.png">

- 각 형식에 맞지 않게 입력시 유효성 검사에 맞는 알림창으로 표시

#### 2. 로그인 화면

<img width="1163" alt="image" src="https://user-images.githubusercontent.com/97447334/224927215-bda01e12-bdd8-4669-a183-7d5ef811b896.png">
<img width="1237" alt="image" src="https://user-images.githubusercontent.com/97447334/224928990-70105c0c-4ec6-4a7b-af50-5bf4fe04a853.png">

- 아이디 혹은 비밀번호가 틀렸을 시 경고 알림
- 로그인에 성공하면 메인 화면으로 이동

#### 3. 소셜 로그인 화면

<img width="1485" alt="image" src="https://user-images.githubusercontent.com/97447334/224930337-4fedeb2e-abce-415c-a65c-a5c72894c98f.png">
<img width="964" alt="image" src="https://user-images.githubusercontent.com/97447334/224930053-872eaaa1-c316-4cfb-8b41-32ab416dd84a.png">

- 구글,페이스북 로그인이 가능하다.

#### 4.1 회원정보 수정 (일반 회원)

<img width="1196" alt="image" src="https://user-images.githubusercontent.com/97447334/224930631-4bd56aa1-5cf2-4f18-8ae6-91adbc45bd2e.png">

- 아이디를 제외한 비밀번호, 이메일 수정 가능

#### 4.1 회원정보 수정 (소셜 로그인 회원)

<img width="1184" alt="image" src="https://user-images.githubusercontent.com/97447334/224937279-54a03675-ad80-41c8-aae7-1a133691a2f8.png">

- 회원 정보 수정이 불가하게 막아두었다.

</details>

<br>

  <details>
    <summary>게시글 관련</summary>

#### 1. 게시글 전체 목록

<img width="1905" alt="image" src="https://user-images.githubusercontent.com/97447334/225900085-2247e8be-5079-4ba0-9248-642e49c6171a.png">

- 한 페이지에 5개씩 페이징 처리

#### 2. 게시물 작성 화면

<img width="1306" alt="image" src="https://user-images.githubusercontent.com/97447334/224931483-814c73bf-caf7-416a-be20-31c79ad0a333.png">

- 로그인한 사용자만 글 작성 가능, 작성 후 메인으로 `redirect`
- 썸머노트를 이용한 작성 폼
- 카테고리 설정 가능

<img width="1188" alt="스크린샷 2023-03-14 오후 5 43 15" src="https://user-images.githubusercontent.com/97447334/224945216-1f7033e9-591c-4051-8114-4bcf60b8681a.png">
<img width="1183" alt="스크린샷 2023-03-14 오후 5 43 27" src="https://user-images.githubusercontent.com/97447334/224945200-eb1f8128-e92c-47af-9b71-4b80dad27a95.png">

- 게시물의 제목,내용을 적지 않을 시 등록 불가.

<img width="1229" alt="image" src="https://user-images.githubusercontent.com/97447334/224936504-5c4e812c-f234-4499-b9d9-deebca93e18b.png">

- 글 작성이 되었다는 알림과 함께 글 작성이 완료된다.

#### 3.1 게시물 상세 (글쓴이)

<img width="1165" alt="스크린샷 2023-03-14 오후 5 45 52" src="https://user-images.githubusercontent.com/97447334/224945734-3ec4099f-a674-4219-9e70-39323e03b32a.png">

#### 3.2 게시물 상세 (글쓴이 외)

<img width="1213" alt="스크린샷 2023-03-14 오후 5 46 09" src="https://user-images.githubusercontent.com/97447334/224945724-3b9f0e71-57ab-44b7-809a-788995ae5687.png">

- 글 번호, 작성자, 카테고리, 조회수등 글에 대한 정보 노출
- 돌아가기, 수정, 삭제 기능 활성화
    - `수정`, `삭제`는 글쓴이(관리자)가 아니면 불가능

#### 4. 게시물 수정

<img width="1201" alt="image" src="https://user-images.githubusercontent.com/97447334/224933988-7d74917d-ebc9-42c9-aac4-f4d0947637ab.png">
<img width="1289" alt="image" src="https://user-images.githubusercontent.com/97447334/224934070-33923e74-5f13-424c-9081-b6e37a76f1d2.png">
<img width="1215" alt="image" src="https://user-images.githubusercontent.com/97447334/224934129-f9c43db5-a35c-4826-b2df-5f97fd9d9332.png">

- 제목,내용,카테고리 모두 수정이 가능하다.

#### 5. 댓글 작성 및 삭제
<img width="1295" alt="스크린샷 2023-03-15 오후 4 51 18" src="https://user-images.githubusercontent.com/97447334/225242989-c92165c8-7ca9-4ce1-bbff-a4215f8cf713.png">
<img width="1311" alt="스크린샷 2023-03-15 오후 4 51 34" src="https://user-images.githubusercontent.com/97447334/225243299-6de7f315-c77b-43c5-b09c-b58f85bc8f13.png">
<img width="1276" alt="스크린샷 2023-03-15 오후 4 51 43" src="https://user-images.githubusercontent.com/97447334/225243004-79edf914-0365-4f64-ba1e-e628a67e55e0.png">
<img width="1172" alt="스크린샷 2023-03-15 오후 4 51 55" src="https://user-images.githubusercontent.com/97447334/225243014-32eec6e1-629d-43c6-a004-de3052f2519b.png">

</details>

<br>

<details>
    <summary>관리자 관련</summary>

#### 1. 관리자 탭

<img width="866" alt="스크린샷 2023-03-14 오후 5 16 42" src="https://user-images.githubusercontent.com/97447334/224938158-5b337857-b1e3-477a-93d5-1ec6fbd581a3.png">

- Role이 `ADMIN`인 회원은 관리자가 되며, 히든 페이지인 `관리자 페이지` 노출

#### 2. 관리자 페이지 Home

<img width="1167" alt="image" src="https://user-images.githubusercontent.com/97447334/224938405-5ce66148-7307-4905-9925-c6afc3f97bf1.png">

- `전체 회원`을 확인 할 수 있다.
- `방문 통계`를 통해 `전체 회원수`, `전체 조회수`를 확인할 수 있다.

#### 3. 전체 회원

<img width="1160" alt="image" src="https://user-images.githubusercontent.com/97447334/224938867-4e76a14f-bca3-4c13-bd5a-3efa68c45265.png">

- 전체 회원을 최신 가입자 순으로 확인할 수 있다.
- 회원의 정보 (등급, 소셜 로그인 유무, 아이디, 이메일, 가입일자)를 확인할 수 있다.
- `링크` 버튼을 통해 회원별 게시글 내역을 확인할 수 있다.

#### 4. 회원별 게시글 확인 및 등급 수정

<img width="1157" alt="스크린샷 2023-03-14 오후 5 37 31" src="https://user-images.githubusercontent.com/97447334/224943670-5bf32ea3-7851-412f-98c3-019b49aab6b5.png">
<img width="1277" alt="스크린샷 2023-03-14 오후 5 37 48" src="https://user-images.githubusercontent.com/97447334/224943700-72ff30a5-8e1b-4290-81ee-39a85b5d0c25.png">

<img width="1038" alt="image" src="https://user-images.githubusercontent.com/97447334/224939601-955f60a4-b3e5-4834-825a-e1bf818d13d8.png">

- 회원별 작성 게시물 및 해당 게시물의 정보(카테고리, 작성일자, 수정일자, 조회수)등을 확인할 수 있다.
- 회원의 등급을 변경할 수 있다. (USER <-> ADMIN)

<img width="1204" alt="image" src="https://user-images.githubusercontent.com/97447334/224940172-2a8932a4-0803-4359-80d6-19e39fa98713.png">

- 회원이 쓴 상세 게시물을 확인할 수 있다.
- 관리자는 악성 게시물등을 방지하기 위하여 일반 회원의 게시물을 삭제할 수 있다.

#### 5. 방문 통계 페이지

<img width="1168" alt="image" src="https://user-images.githubusercontent.com/97447334/224940971-42cf5138-2c98-4cd9-918e-185f96938c1b.png">

- 전체 회원수를 알 수 있고, `상세보기` 클릭시 이 전의 가입된 회원 목록으로 이동한다.
- 전체 게시물의 총 조회수를 알 수 있다.

</details>
<br>

# 구조 및 설계
## 1. DB 설계
<img width="1003" alt="image" src="https://user-images.githubusercontent.com/97447334/226087698-10fe1d18-acd9-46c6-9924-bd9007be3e12.png">
<img width="790" alt="image" src="https://user-images.githubusercontent.com/97447334/225251339-1d55ff3c-2ebd-4b58-99f8-f642312c17d0.png">
<img width="796" alt="image" src="https://user-images.githubusercontent.com/97447334/225251383-b0910c74-d928-4b59-beff-c1a177a04c3c.png">

<img width="802" alt="image" src="https://user-images.githubusercontent.com/97447334/225251438-7104a47a-e83f-41f2-a465-11a6a3e47970.png">

## 2. API 설계
<img width="697" alt="image" src="https://user-images.githubusercontent.com/97447334/225931836-24e3fe4a-6ed1-4c7f-888c-656bf48f2bc4.png">
<img width="777" alt="image" src="https://user-images.githubusercontent.com/97447334/225931914-ea7ec228-55b8-4762-875f-7b85cdc6b034.png">
<img width="604" alt="image" src="https://user-images.githubusercontent.com/97447334/225931988-6d33e8ca-c27d-4134-8dc5-1b1b7099539c.png">
<img width="803" alt="image" src="https://user-images.githubusercontent.com/97447334/225932037-fa7c3777-4e57-4666-b683-ccbe92cf7f76.png">

# 마치며.
## 1. 아쉬운 점
- 프론트단과 함께 구성을 하다보니 완벽하게 RESTful 하지 못한 API이다.
  - 백엔드 API에만 집중해서라도 RESTful한 API를 짜는 연습 필요.
- 테스트 코드를 작성하지 못했다.
  - 단위 테스트(MockMvc/Rest Assured등)를 사용해서 테스트 코드 짜는 연습 필요.
- Entity <-> DTO 간 연결 로직 연습 필요. 
  - 처음 설계시 많은 고민과 준비를 한 후에 코드를 짜봐야겠다. 
- 트러블 슈팅에 관한 블로깅을 하지 못했다.
  - 구현에만 신경을 쓰다보니 에러나 이슈에 관하여 기록으로 남기질 못했다.
## 2. 후기
혼자 독학하면서 처음 만들어본 프로젝트이기 때문에,<br>
공부한 것들로 무언갈 구현해보고 만들어 가는 것에 큰 희열과 설렘을 느꼈습니다.<br>
하지만 프로젝트를 만들며 공부를 더 이어가다 보니 갈수록 아쉬운 점도 많이 남았고, 부족한 부분도 제 눈에 보였습니다.<br>
책, 온라인 강의에서 공부한 예제들과 블로그 및 여러 도움을 주신 커뮤니티 개발자분들이 보여주신 예제 코드들에서 이해했던 부분들은 실제로 코드를 짜면서 다양한 방법으로 애로 사항을 마주했습니다.<br>
`'내가 지금 짜고 있는 코드가 좋은 코드인가?'`, `'지금 이 코드가 이 레이어에서 처리하는게 맞는가?'`, `'DTO의 전달은 어느 레이어에서 하는게 효과적일까'`등 많은 고민이 있었습니다.<br>
고민을 해결하기 위해 며칠을 끙끙 앓아 힘들었던 기억도 있지만, 올바른 검색과 의미 있는 질문들로 통해 문제를 해결하였을 때만큼 희열은 느꼈던 적은 없는 것 같습니다.<br>
덕분에 어떤 상황에서도 내가 짠 로직이 `'Best Practice'`한 로직일까 스스로 고민하고 의심하는 것이 습관이 되었습니다.

<br>

또한 첫 프로젝트를 통해 배웠던 기술들을 사용해 보며 앞으로 내가 필요한 기술과 더욱 채워야할 지식등을 더 잘 알 수 있게 되었습니다.<br>
이로인해 더 좋은 공부 방향을 잡을 수 있게 되었고, 내가 어떤 것을 잘 모르는지에 대해 스스로 알 수 있었던 좋은 기회였습니다.<br>
특히 프로젝트 진행 전 `탄탄하고 체계적인 설계`, 프로젝트를 진행하며 `테스트 코드`를 짜보는 점 등은 정말 피부에 와닿을 정도로 중요하단 것을 알게 되었습니다.<br> 
얼른 부족한 실무적인 지식, 이론적인 지식을 채워 다음 프로젝트는 더욱 발전되어 하나의 로직이라도 더 `'Best Practice'`한 코드를 짜고, 더 체계적이고 튼튼한 웹 애플리케이션을 만들고 싶은 욕심이 생겼습니다.<br>
나아가 더 좋은 개발자가 될 수 있을 것 같다는 자신감도 많이 생겼습니다!!<br>
<br>

긴 글 읽어주셔서 감사합니다! 😄
