********************************************************************************
*                          Client Container 예제 정보                          *
********************************************************************************

I. 예제 실행 방법
   본 예제들은 기본적으로 Ant를 사용해서 컴파일하고 실행하도록 되어 있습니다.
   그리고, Example Server를 사용해서 동작합니다. Example Server는 JEUS_HOME에
   있는 readme.txt 파일의 VI. JEUS 실행 부분을 참고하십시오.

   * Build, Deploy 및 클라이언트 실행
    > jant

   * Undeploy
     > jant undeploy

   * 생성된 디렉토리 및 파일 삭제
     > jant clean

   참고: jant는 JEUS_HOME/bin 디렉토리에 있으며, JEUS_HOME/lib/etc/ant에 있는
   Ant를 실행시켜 줍니다.
   매 테스트 마다 undeploy와 clean을 하셔야 올바른 동작을 확인할 수 있습니다.	

   Applet이나 Jnlp 예제는 Java Security 모델에 따라 java.policy에 지정된 대로
   Access control을 합니다. 따라서 java.policy 파일에 Applet이나 Jnlp가 사용하는
   클래스에 대해 permission을 제공해 주어야 합니다. 
   java.policy설정은 
   http://java.sun.com/j2se/1.5.0/docs/guide/deployment/deployment-guide/security.html
   문서를 참고하십시오.

   이외에 별도의 Compile 및 Deploy 과정이 필요한 경우에는 각 모듈 디렉토리에
   있는 readme.txt 파일을 참고하십시오.


II. 예제 설명

   * hello		: EJB 3.0 stateless Bean과 @EJB 를 사용하는 client 예제

   * helloApplet	: EJB 3.0 stateless Bean과 Applet을 사용하는 client 예제

   * helloJnlp		: EJB 3.0 stateless Bean과 Jnlp를 사용하는 client 예제

   * helloNoContainer	: EJB 3.0 stateless Bean과 ClientContainer를 사용하지 않고 JNDI를 사용하는 client 예제
