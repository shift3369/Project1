# Project1

## 사용법
1. 처음 프로젝트 사용시 저장될 폴더에 복사한다.
```
git clone https://github.com/Membership3/Project1.git
```
2. 이 후 Android Strudio 에 Import Project 하여 사용한다.( Gradle build )
3. Run Configuration 작성하여 실행환경을 작성한다.

## OpenSource Library
1. Universal-image-loader
	- 이미지 로딩 및 캐시 관련 라이브러리
	- Apache License 2.0 라이센스
2. KenBurnsView
	- KenBurnsEffect 적용한 View
	- Apache License 2.0 라이센스
				
## Activity
1. IntroActivity
	- 인트로 화면
	- KenBurnsView 적용
	- 현재 기준 3000ms 후 MainActivty로 전환 된다.
2. MainActivity
	- 메인 화면
	- DrawerLayout 적용
	- 구글 기본 Example 각 부분이 Xml 파일로 지정 되어 있다.
	- 메뉴 항목은 /res/menu 에 저장되어 있다.