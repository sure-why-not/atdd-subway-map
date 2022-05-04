# 지하철 노선도 미션

---

## 1단계 기능 요구사항 
### 지하철 역 정보 관리 API
- [x] 등록 기능
- [x] 목록 조회 기능
  - [x] 이미 등록된 이름이면 에러 응답 
- [x] 삭제 기능

### 지하철 노선 관리 API
- [x] 등록 기능
  - [x] 이미 등록된 이름이면 에러 응답
- [x] 전체 목록 조회 기능
- [x] 단일 노선 조회 기능
- [x] 수정 기능
  - [x] 수정 된 노선 이름이 중복이면 에러 응답
- [x] 삭제 기능

## 1단계 프로그래밍 제약 사항
- 스프링 빈 사용 금지(@controller 제외)

---

## 2단계 기능 요구사항
- 스프링 빈 활용하기
- 스프링 JDBC 활용하여 H2 DB에 저장하기
  - Dao 객체가 아닌 DB에서 데이터를 관리하기
- H2 DB를 통해 저장
