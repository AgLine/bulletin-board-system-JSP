#  JSP 게시판 프로젝트
---
## 📌 프로젝트 개요
- **기간**: 2023.03
- **개발 환경**: Eclipse, Tomcat v8.5, MariaDB
- **사용 기술**: Java, JSP, Bootstrap, SQL

---
## 🎯 프로젝트 목적
SpringBoot, JSP, Bootstrap을 활용하여 게시판사이트를 개발하였습니다.

로그인한 사용자만 글 작성·수정·삭제가 가능하도록 세션 기반 인증 및 권한 관리를 구현하였으며, 데이터 무결성과 안정성을 고려하여 논리적 삭제(Soft Delete) 방식을 적용했습니다.

---
## 🛠 주요 기능
### 1. 게시글 CRUD
- Create (글 작성): 로그인된 사용자만 작성 가능 (세션 기반 권한 확인)
- Read (글 조회): 로그인 여부와 상관없이 모든 사용자가 게시글 열람 가능
- Update (글 수정): 작성자 본인만 수정 가능 (작성자 ID vs 세션 사용자 ID 비교)
- Delete (글 삭제): 작성자 본인만 삭제 가능, 실제 DB 삭제가 아닌 status 컬럼 변경 → 논리적 삭제 구현

### 2. 사용자 인증 & 세션 관리
- 로그인/로그아웃 기능
- 세션을 통해 사용자 인증 상태 및 권한 유지
- 잘못된 접근 방지를 위해 인증되지 않은 사용자가 게시글 작성/수정/삭제 시도 시 접근 제한

### 3. UI & UX
- Bootstrap 기반 반응형 디자인 적용

---
## 📖 배운 점 & 느낀 점
- 단순히 데이터를 물리적으로 삭제하는 방식 대신 논리적 삭제(Soft Delete) 방식을 적용하면서,실제 서비스에서는 데이터 복구 가능성과 운영 효율성을 함께 고려해야 한다는 점을 배웠습니다.
- 또한, 이렇게 설계된 구조가 사용자 실수로 인한 데이터 손실 방지와 관리자의 운영 편의성에도 기여할 수 있음을 느꼈습니다.

---
## 📷 실행 화면

# 참고문헌
* https://github.com/xerial/sqlite-jdbc
* https://juyoungit.tistory.com/616
* https://www.youtube.com/playlist?list=PLRx0vPvlEmdAZv_okJzox5wj2gG_fNh_6
* https://velog.io/@oh_yunseong/SPRING-PROJECTWEB-HOSTING-cafe24mariaDB
