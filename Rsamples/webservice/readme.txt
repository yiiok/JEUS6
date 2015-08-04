********************************************************************************
*                              Web Service 예제 정보                           *
********************************************************************************

I. 예제 실행 방법
   본 예제들은 기본적으로 Ant를 사용해서 컴파일하고 실행하도록 되어 있습니다.
   그리고, Example Server를 사용해서 동작합니다. Example Server는 JEUS_HOME에
   있는 readme.txt 파일의 VI. JEUS 실행 부분을 참고하십시오.

   * Build 및 Deploy
    > jant

   * 클라이언트 실행
    > jant run
    또는
    > jant runclient

   * Undeploy
     > jant undeploy

   * 생성된 디렉토리 및 파일 삭제
     > jant clean

   * Build, Deploy, Client run, Undeploy
     (예제에 따라서 4가지를 한꺼번에 실행하는 경우도 있다.)
     > jant

   참고 1 : jant는 JEUS_HOME/bin 디렉토리에 있으며, JEUS_HOME/lib/etc/ant에 있는
   Ant를 실행시켜 줍니다.

   참고 2 : uddi 디렉토리 아래 예제의 경우에는 실행하기 전에 JEUS UDDI
   Application이 JEUS 에 디플로이 되어 있어야 한다. 그리고, Derby를 사용하기 
   때문에 Derby 또한 떠있어야 한다. JEUS UDDI Application은 
   JEUS_HOME/webhome/uddi/jeusuddi_v3c.ear 을 디플로이 하면된다.

   이외에 별도의 Compile 및 Deploy 과정이 필요한 경우에는 각 모듈 디렉토리에
   있는 readme.txt 파일을 참고하십시오.
