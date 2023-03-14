# 나만의 게시판 만들기(Spring boot + Ajax)

> 전반적인 웹의 기본 소양이 되는 게시판(블로그) 프로젝트입니다.
>
<img width="1901" alt="메인화면_로그인" src="https://user-images.githubusercontent.com/97447334/224917221-7a1b0fec-c22a-4168-8907-7d56b917368e.png">

## 목차

- [들어가며](#들어가며)
    - [프로젝트 소개](#1.-프로젝트-소개)
    - [프로젝트 기능](#2.-프로젝트-기능)
    - [사용 기술](#3.-기술-스택)
        - [프론트엔드](#3.1-프론트엔드)
        - [백엔드](#3.2-백엔드)
    - [실행 화면](#4.-실행 화면)

- [구조 및 설계](#구조-및-설계)
    - [패키지 구조](#1-패키지-구조)
    - [DB 설계](#2-db-설계)
    - [API 설계](#3-api-설계)

- [개발 내용](#개발-내용)

- [마치며](#마치며)
    - [프로젝트 보완사항](#1-프로젝트-보완사항)
    - [후기](#2-후기)

# 들어가며.

## 1. 프로젝트 소개

> 막연하게 이론으로만 공부하던 지식들을 한 번 구현을 해보고자 하였습니다.<br> 웹 프로그래밍의 기본 소양이라고 할 수 있는 게시판을 직접 만들어보고, 모르는 것은 검색하며 원하는 정보를 효과적으로 검색,
> 질문하는 방법 또한 함께 습득하고자 하였습니다.<br>
> 지금껏 독학으로 관련 기술들을 학습한 이후 제작한 첫 프로젝트이기 때문에 아쉬움도 많이 남지만, 개인적인 만족감을 가지고 있는 프로젝트입니다.

- 기본 CRUD 기능+ Rest API + **비동기통신** = 게시판 웹사이트
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

### 3.1 프론트엔드

- Html/Css
- JavaScript
- Ajax
- Thymeleaf
- Bootstrap 4.3.1

### 3.2 백엔드

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

  <details>
    <summary>게시글 관련</summary>

#### 1. 게시글 전체 목록

<img width="1900" alt="image" src="https://user-images.githubusercontent.com/97447334/224924719-32092d9b-c1d3-4b40-9b55-4691f277f63a.png">

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

</details>

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

