# bustago-web

```
git clone https://github.com/devsurimlee/bustago-web
./gradlew bootRun -Pprofile=local
or
./gradlew build
java -jar ./build/libs/bustago-web-0.0.1-SNAPSHOT.jar --args='--profile=local'
```

* profiles group
  * local, dev, live (default: local)

* commit 코멘트 규칙 
  * feat : 새로운 기능 추가
  * fix : 버그 수정
  * docs : 문서 관련
  * style : 스타일 변경 (포매팅 수정, 들여쓰기 추가, …)
  * refactor : 코드 리팩토링
  * test : 테스트 관련 코드
  * build : 빌드 관련 파일 수정
  * ci : CI 설정 파일 수정
  * perf : 성능 개선
  * chore : 그 외 자잘한 수정

```
ex) feat: 회원가입 api 작업 완료
```

* branch 생성 규칙
  * 브랜치는 기능단위로 생성하고 이름은 feat/숫자로 정한다.
  * 작업이 끝나면 pull request를 생성하고 깃허브에서 merge처리한다.
  * 커밋이 많은 경우 적절히 통합하여 올린다. (squash 이용)
  

