## 이전에 만들었던 HealthMe 프로젝트를 이용하여 기존 xml기반 UI를 compose기반 UI로 리펙토링하면서 컴포저블UI에 대해 익숙해져보는 Project
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