## 이전에 만들었던 HealthMe 프로젝트를 이용하여 기존 xml기반 UI를 compose기반 UI로 리펙토링하면서 컴포저블UI에 대해 익숙해져보는 Project

<h3 align="center">✨ Tech Stack & Tools ✨</h3>
<div align="center">
    
`Jetpack Compose` `MVVM` `ViewModel` `Navigation3` `Coroutine`

</div>

<!-- `Koin` `Clean Architecture` `JUnit4` ``

-->
<!-- <div align="center">
    <img src="https://img.shields.io/badge/c-A8B9CC?style=for-the-badge&logo=c&logoColor=white" />
    <img src="https://img.shields.io/badge/python-3776AB?style=for-the-badge&logo=python&logoColor=white"/>
    <img src="https://img.shields.io/badge/kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white" />
 <div align="center">
    <img src="https://img.shields.io/badge/android studio-3DDC84?style=for-the-badge&logo=androidstudio&logoColor=white" />
    <img src="https://img.shields.io/badge/Firebase-FFCA28?style=for-the-badge&logo=Firebase&logoColor=white" />
    <img src="https://img.shields.io/badge/jetpack compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white">
</div> 

</div> -->
---

### 개발 진척 일지

#### 2025-12-07
- **Environment**: Gradle, Kotlin, AGP 버전 업데이트, `compileSdk` 36 설정
- **Chore**: 불필요한 설정 파일 제거 및 `.gitignore` 업데이트

#### 2025-12-08
- **UI Components**: `AuthCodeInputField`, `EmailAuthInputField`, `MediumButton`, `BigButton`, `InputField` 구현 및 스타일 적용
- **Feature**:
  - 회원가입 이메일 인증 화면(`SetEmail`) 및 로직(정규식 검사, 코드 입력 등) 구현
  - 로그인 화면(`LogIn`) 디자인
  - 앱 첫 실행 화면(`FirstScreen`) 구현
- **Refactoring**: `BigButton` 재사용성 개선, 입력 필드 UX 개선 (TextField 전환, 한 줄 제한, 키보드 타입 설정)
- **Design System**: `AppColors`, `AppFonts`, `AppTextStyle` 등 공통 리소스 및 테마 정의


#### 2025-12-09
- **Feature**: 비밀번호 설정 화면(`SetPassword`) 레이아웃 및 디자인 구현
- **UI Components**: `PasswordInputField` 컴포넌트 구현 및 텍스트 필드 속성 적용
- **Design**: 비밀번호 유효성 조건 문구 및 일치 여부 확인용 체크 아이콘 추가

#### 2025-12-13
- **Environment**: Android Gradle Plugin(AGP) 버전 업데이트 (8.13.1 -> 8.13.2)

#### 2025-12-14
- **Navigation**: `Navigation 3` 및 `kotlinx-serialization` 라이브러리 추가, `NavigationRoot`를 통한 화면 전환 구조(Splash, SetEmail, SetPassword, Login) 구축
- **Feature**:
  - `Login`, `SetPassword` 화면 Route 정의
  - `MediumButton`, `BigButton` 클릭 이벤트 및 활성화 상태 제어 기능 추가
  - 인증 번호 전송/재전송에 따른 UI(버튼, 입력 필드) 상태 제어 로직 구현

#### 2025-12-15
- **Architecture**: `SetEmailViewModel` 및 `SetPasswordViewModel` 도입으로 UI와 비즈니스 로직 분리 (MVVM 적용)
- **Feature**:
  - **SetEmail**: 이메일 유효성 검사 및 인증 코드 확인 로직 연결, 다음 화면으로 이메일 데이터 전달 구현
  - **SetPassword**: 비밀번호 유효성 검사 상태 관리 및 UI(체크 아이콘) 연동, 비밀번호 설정 화면 라우팅
  - **SetInformation**: 개인정보 입력 화면 UI 및 컴포넌트(`InformationInputField`) 초기 구현
- **Refactoring**:
  - `EmailAuthInputField` 등 주요 입력 필드 상태 호이스팅(State Hoisting) 적용
  - `SetEmail`, `SetPassword` 패키지 구조 재정리 및 불필요한 코드/리소스 정리

#### 2025-12-20
- **Feature**: 이용약관 동의 관련 컴포넌트(`AgreeTerms`) 및 다이얼로그 구현, 회원가입 정보 입력 후 약관 동의 화면으로의 내비게이션 연결
- **Refactoring**: 약관 동의 관련 변수명 직관적으로 수정 (`isNextButtonEnable` -> `isNextButtonEnabled` 등) 및 코드 정리
- **Fix**: `AgreeTermsDialog` 상태 관리 이슈 수정 (`rememberSaveable` -> `remember`)
- **Design**: `AgreeAllTermsButton` 체크박스 레이아웃 개선

#### 2025-12-21
- **Feature**: 회원가입 완료 화면(`SignUpComplete`) 구현, 약관 동의 후 완료 화면으로의 라우팅 처리
- **Design**: 완료 화면에 로고 아이콘 추가 및 인사말 텍스트 색상 적용
