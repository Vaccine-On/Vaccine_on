# Vaccine_on
### 팀 소개
- 모두가 백신을 접종하여 마스크 없이도 다닐 수 있는 평화로운 날이 오기를 바라며, 백신을 켜라!라는 의미입니다.
- 구성원: 김나연@nayeon0731, 백예림@bbye-rim, 오희주@noion0511
- 소속: 제주대학교 전자전기통신컴퓨터공학부 컴퓨터공학전공

### 프로젝트 소개
- 코로나19 백신 예방접종센터 위치정보 API를 이용해 지역별 코로나19 예방 접종이 가능한 병원을 알려주는 어플을 개발할 계획입니다.
- 예방 접종 예약을 하고 접종하지 않는 '노쇼'로 인한 폐기 물량을 최소화 하기 위해 병원에서는 대기 명단을 만들어 운영 중입니다.
대기 명단은 직접 방문하거나 전화로 예약할 수 있습니다. 그런데 대기 명단에 관한 문의가 너무 많아서 
병원 측에서는 이로 인해 진료 업무에 차질이 생긴다고 합니다. 이를 완화하기 위해 해당 병원에서 예약이 가능한지 불가능한지 알려주는 서비스를 개발할 계획입니다.


### 사용한 Open API & Open Source
1. 코로나 및 병원 관련 정보 API
    - [건강보험심사평가원_병원정보 서비스](https://www.data.go.kr/data/15001698/openapi.do) : 건강보험심사평가원에서 관리하는 병원을 조회할 수 있다. 위치와 홈페이지 등의 다양한 출력결과가 나온다.
    - [건강보험심사평가원_코로나19 병원정보서비스](https://www.data.go.kr/data/15043078/openapi.do) : 코로나바이러스 관련 병원 운영 현황 정보 등을 제공한다. ex) 국민 안심 병원, 코로나19 검사 실시기관, 코로나19 선별 진료소
    - [공공데이터 활용지원센터_코로나19 예방접종센터 조회서비스](https://www.data.go.kr/data/15077586/openapi.do) : 지역별 코로나19 예방접종센터 위치 정보를 정리한 API이다.
2. [안드로이드Android 4.1](https://www.android.com/intl/ko_kr/)
3. [레트로핏Retrofit](http://devflow.github.io/retrofit-kr/)
    - 안드로이드 어플리케이션에서 통신 기능에 사용하는 코드를 사용하기 쉽게 만들어놓은 라이브러리이다. 
    -  REST 기반의 웹 서비스를 통해 JSON 구조의 데이터를 쉽게 가져오고 업로드할 수 있다.

### 라이스

    Copyright [2021] [Vaccine-on]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

