********************************************************************************
                  TmaxSoft Application Server JEUS 6 Samples 
********************************************************************************

I. 예제 실행 방법
   본 예제들은 기본적으로 Ant를 사용해서 컴파일하고 실행하도록 되어 있습니다.
   
   먼저, JEUS_HOME 환경변수를 JEUS가 설치된 디렉토리로 지정해야 합니다.

   각 예제별로 약간의 차이는 있지만, 대부분 다음과 같이 예제를 실행시킵니다.

   * Build, deploy 및 실행
     > jant 혹은 jant all
    
   * Build
     > jant build

   * Deploy
     > jant deploy

   * 클라이언트 실행
     > jant run
     또는 
     > jant runclient

   * Undeploy
     > jant undeploy

   * 생성된 디렉토리 및 파일 삭제
     > jant clean

   이외에 별도의 과정이 필요한 경우에는 각 모듈 디렉토리에
   있는 readme.txt 파일을 참고하십시오.


II. 디렉토리 구성

  예제 디렉토리는 JEUS_HOME/samples 디렉토리를 말하며, 구성은 다음과 같습니다.

  JEUS_HOME/samples
   |
   +- ant_task        : ant task 실행 예제
   +- client          : appclient 및 client 실행 예제
   +- common          : 공통 build scripts 디렉토리(참고: common/build.properties, common/app-server.properties) 
   +- ejb             : ejb sample 디렉토리
   +- getting_started : JEUS6 인스톨 및 시작하기 안내서에 나오는 예제들 모음
   +- jmx             : jmx 실행 예제
   +- jsf             : jsf 실행 예제
   +- quickstart      : Petstore 2.0을 위한 홈 디렉토리
   +- scheduler       : scheduler 실행 예제
   +- snmp            : snmp 실행 예제
   +- webservice      : JAX-RPC 및 JAX-WS 관련 예제
   |                      

