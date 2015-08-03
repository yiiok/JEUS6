********************************************************************************
*                        Tmax Soft JEUS 6 릴리즈 정보                          *
*                                                                              *
*                             2007년 6월 7일                                  *
********************************************************************************

                                목     차

                     I.......: 들어가며
                     II......: 설치
                     III.....: 지원 환경
                     IV......: 새 기능과 변경 사항
                     V.......: QuickStart 실행하기
                     VI......: JEUS 실행
                     VII.....: 연락처




I. 들어가며

 TmaxSoft JEUS 6를 선택해 주셔서 감사합니다.

 이 파일은 JAVA EE 5 인증을 받은 TmaxSoft사의 고성능 JEUS 6 어플리케이션 서버의
 릴리즈 정보 파일입니다. JEUS 6는 기존 버전에서 검증된 성능 및 안정성, 가용성에
 JAVA EE 5의 기능 및 편리한 기능 추가로 이전 버전보다 편리하게 사용할 수 있습니다.

 이 파일은 JEUS 6의 기본 정보를 담고 있으므로, 반드시 정독해 주시기 바랍니다.



II. 설치

JEUS 6의 설치 파일은 다음 사이트에서 구할 수 있습니다.

   http://technet.tmaxsoft.com

라이선스 파일 역시 동일한 사이트에서 구할 수 있습니다.

JEUS 6에서는 하나의 인스톨러에서 여러 플랫폼과 비트를 지원합니다.
인스톨러는 크게 Windows용과 Unix용으로 되어 있습니다.

   jeus60-XXX.[bin|exe]

확장자가 .bin이면 Unix용, .exe이면 Windows용 인스톨러입니다.

JEUS의 인스톨 방법은 두 가지가 있습니다.

 A. GUI 방식 설치(Unix/Windows)
    다음처럼 실행하면 GUI 형태로 설치됩니다.

    > jeus60_unix_generic(vm).bin -i GUI 또는 jeus6-win.exe

 B. Console 방식 설치(Unix/Linux 용)
    다음처럼 실행하면 Console 형태로 설치됩니다.

    > jeus60_unix_generic(vm).bin


JEUS의 설치시 기본적으로 5유저로 제한되는 Trial 라이선스가 제공됩니다.



III. 지원 환경

JEUS 6는 다음과 같은 환경을 지원합니다.

   OS     Solaris, HP-UX, AIX, Windows 2000/XP/2003/Vista, Linux(Redhat 7 이상)
   CPU    Intel x86 및 호환, Sun Sparc, PA-RISC, IBM PowerPC
   RAM    최소 256MB의 여유 메모리
   DISK   최소 300MB의 여유 공간
   Java   5.0 지원



IV. 새 기능 및 변경 사항

 A. 지원 Specification

   JEUS 6는 JAVA EE 5를 완벽 지원하고 있습니다. 대표적인 Specification은 다음과 같습니다. 
   보다 자세한 사항은 JEUS릴리즈노트를 참고하시기 바랍니다.

   - Enterprise JavaBeans 3.0
   - Servlet 2.5
   - Java ServerPages 2.1
   - Java Message Service 1.1
   - Java Database Connectivity 3.0
   - Java Connector Architecture 1.5
   - Java Management 1.1
   - Java Naming&Directory Interface 1.2.1
   - Java Authorization Contract for Containers 1.1
   - Simple Object Access Protocol 1.2
   - Enterprise Web Services 1.2

   이외에 WebService를 위한 다음과 같은 Specification도 지원합니다.
   - WS-Security 1.1
   - Universal Description, Discovery and Integration 2.0/3.0
   - Web Service Description Language 1.1
   - JAXB 2.1
   - JAX-WS 2.1

 B. 주요기능

   - Server
     * 공유 라이브러리 지원
       클래스 라이브러리를 여러 Application에서 공유해서 사용하도록 하는 기능으로써
       JEUS 전체에 영향을 미치지 않고, Application에서 설정해서 사용할 수 있습니다.
     
     * Engine Container 부팅 여부 설정 기능
       JEUS 기동시 Engine Container의 부팅 여부를 설정할 수 있으며 부팅 후에 
       WebAdmin등을 통하여 컨테이너를 부팅 시킬 수 있습니다.
     
     * 다중로거 기능 추가
       JEUS Manager나 Engine Container에 여러 개의 로거를 등록함으로써 필요한 
       로그를 별도로 분리해서 로깅할 수 있습니다.
     
     * console tool 통합
       기존에서 용도별로 따로 제공되던 console tool이 jeusadmin 하나로 통합되었습니다.
       (jmsadmin은 별도 제공)
   
   - EJB
     * deploy 성능 개선
       EJB 3.0을 사용할 경우 Stub/Skeleton을 생성, 컴파일 하지 않고 dynamic proxy를 
       사용하여 빠르게 deploy할 수 있습니다.
     
     * JEUS RMI 지원
       기존 JDK의 RMI가 아닌 JEUS 고유의 프로토콜을 사용하는 RMI를 사용할 수 있습니다.
       최신 NIO 기술을 사용함으로써, 대용량의 EJB Client 호출을 효율적으로 처리할 수 있습니다.
     
     * Stateful Session Bean 기능 강화
       Stateful Session Bean에서 기본적으로 Session Manager를 사용하도록 하여, 
       EJB passivation이나 EJB Clustering에서 Fail over가 보다 완벽하게 되었습니다.
     
   - WebContainer
     * NIO HTTPListener 지원
       Non-blocking I/O에 기반한 HTTP Listener를 제공하여서 많은 커넥션을 적은 수의 
       thread 를 가지고 안정적으로 처리할 수 있습니다.
     
     * Caching 기능 추가  
       서블릿 필터를 사용하여 정적 컨텐츠에 대하여 HTTP 응답 전체를 캐싱하는 기능과
       태그 라이브러리를 이용하여 JSP 내의 일부분을 캐싱하는 기능이 제공됩니다.
       
     * Reverse Proxy 기능 추가
       외부의 요청을 받아서 내부 서버에 요청을 전달하고 해당 응답을 다시 외부로 전달해주는 
       Reverse Proxy 기능을 사용할 수 있습니다.
     
     * Application 별로 Character Set Encoding 설정 가능
       jeus-web-dd.xml에 request, response encoding 을 설정하여  애플리케이션(웹모듈)별로
       encoding 처리를 할 수 있습니다.

   - Web Service
     * JAX-WS 2.1 지원
       별도의 Deployment Description을 작성할 필요없이, 기존의 클래스에 간단히 
       Metadata Annotation을 추가하는 것으로 Web Service를 개발할 수 있습니다.

     * 다양한 WS-* 스택 지원
       WS-Security 1.1
       WS-Security Policy 1.2
       WS-SecureConversation
       WS-Reliable Messaging
       WS-Addressing

   - JMS
     * Non-Acknowledge 모드 추가
       Session을 생성할 때 acknowledge모드를 jeus.jms.JeusSession.NONE_ACKNOWLEDGE로 
       설정할 수 있는데, 이 모드는 producer는 send시에 서버로부터 ack을 수신하지 않고, 
       consumer는 receive시 서버로 ack을 전송하지 않기 때문에 빠른 속도로 메시지를 
       주고 받을 수 있습니다.
       
     * JMS Message 타입으로 File Message 추가
       JMS를 통해서 대용량의 파일을 보낼 수 있는 기능이 추가되었습니다. 
       JMS는 메시지를 메모리에 올려서 송수신 하기 때문에 메시지 크기가 클 경우에는 
       OutOfMemoryError가 발생할 수 있지만 FileMessage는 파일의 내용을 블록 단위로 전송하기 
       때문에 위와 같은 문제를 피할 수 있습니다.

   - Session Server
     * 중앙식 세션 서버 설정 간소화
       단일 노드에서 세션 서버를 설정시 이전과 같이 container에 세션 서버의 정보를 입력하지 않고
       매니저의 설정만으로 컨테이너가 인식할 수 있습니다.
       클러스터링 상태에서도 primary와 backup 세션 서버만 지정하면 나머지 노드의 컨테이너는 자동으로
       이를 인식하여 세션 클러스터링에 참여하게 됩니다.
       
     * 분산식 세션 서버 자동 백업 지정
       백업을 서버를 지정하지 않아도 JEUS에서 자동으로 클러스터링 되어있는 노드중에서 가장 적절한 
       백업 서버를 선택하여 주므로 사용자는 이를 신경쓰지 않아도 됩니다.

   - Security
     * JAAS Login Module 강화
       Java의 표준 기능인 Java Authentication&Authorization Service 기능을 이용해서 
       JEUS의 권한 인증과 부여기능을 작성할 수 있습니다.
       
     * LDAP/DB Realm Repository 지원
       LDAP과 DB Realm을 이용한 User Authentication과 Authrization 기능이 제공된다. 
       특히 DB Realm의 경우에는 성능 향상을 위한 Caching을 제공하므로, 빠른 성능을 제공합니다.

   - WebAdmin
     * MBean 모니터링 기능 추가       
     * 트랜잭션 모니터링 기능 추가       
     * 쓰래드 모니터링 기능 추가       
     * 웹 관리자 도움말 강화


 기능 추가 및 변경 사항에 대한 보다 자세한 내용은 매뉴얼을 참고하시기 바랍니다.

 매뉴얼 및 기타 문서는 Documentation Center 페이지(JEUS_HOME/docs/index.html)를 통해서 확인할 수 있습니다.



V. QuickStart 실행하기

JEUS 6에서는 JEUS 6를 간단하게 사용할 수 있도록 QuickStart를 제공합니다.
Windows 플랫폼에서는 JEUS의 설치가 끝남과 동시에 QuickStart GUI 프로그램이
실행됩니다.

QuickStart GUI 프로그램 이외에서 QuickStart를 실행하려면 다음과 같이 실행합니다.

 > startderby      : derby 구동
 > jeus-quickstart : QuickStart 예제에 맞춰 JEUS 구동

주의: QuickStart 실행시 Petstore가 deploy 되므로 일정 시간이 소요됩니다.

WebAdmin를 사용하려면 웹 브라우저를 이용해서 다음 URL로 접속하면 됩니다.

  http://localhost:23008/webadmin

Petstore의 동작 화면은 다음 URL로 확인할 수 있습니다.

  http://localhost:8088/petstore/




VI. JEUS 실행

JEUS 6의 스크립트는 이전 버전과 사용법은 동일합니다. 그러나 다양한 환경을 지원
하기 위해서 jeus.properties(Windows 환경에서는 jeus.properties.cmd)파일의 기능이
보강되었습니다.

 A. JEUS의 기동
   1. JEUS를 실행하려면 jeus.properties 파일의 다음 항목이 제대로 설정되었나
      확인합니다.

      JEUS_HOME, JEUS_BASEPORT, JAVA_HOME

   2. Virtual Node를 사용할 것인지 정합니다.
      JEUS_HOME/config/vhost.properties에서 jeus.vhost.enabled=true/false로
      사용 여부를 지정합니다.
      속성의 값이 true이면 현재 노드명과 JEUS_BASEPORT의 값을 조합해서 VirtualNode를 생성합니다.

      예) 다음과 같이 설정되어 있을 경우
      jeus.vhost.enabled=true
      example=tmaxsoft:21000

      tmaxsoft라는 노드의 머신에서 JEUS_BASEPORT 21000으로 부팅하면 VirtualNode가
      example로 됩니다. 이후에는 example을 노드명으로 사용하게 됩니다.
      jeusadmin도 다음과 같이 실행합니다.

      > jeusadmin example

   3. 프롬프트에서 jeus를 입력합니다.
      > jeus

   4. jeusadmin으로 접속해서 boot 합니다.
      > jeusadmin node_name
      node_name> boot

  Tip:
    jeus.properties의 환경 변수에서 USERNAME, PASSWORD 값을 입력하면 jeus를 입력
    하는 것으로 One-step boot을 진행합니다.


 B. WebAdmin 접속
   WebAdmin는 이전 버전과 동일하게 접속합니다.
   URL은 다음과 같습니다.

   http://<IP-address>:<JEUS_BASEPORT + 8>/webadmin

 C. Example Server의 Boot/Shutdown
   Example Server는 JEUS 6의 VirtualNode 기능을 사용해서 샘플을 실행시킬 수 있는
   환경을 제공하는 JEUS를 일컫습니다.

   구동은 다음과 같이 합니다.

   1. Windows의 경우
      시작 메뉴에서 TmaxSoft->JEUS6.0->Example Server->Boot Example Server를
      실행합니다.
      또는 JEUS_HOME\bin\startexampleserver.cmd를 실행합니다.

   2. Unix/Linux
      JEUS_HOME/bin/startexampleserver를 실행합니다.

   이렇게 Example Server가 Boot되면 JEUS_HOME/samples 디렉토리에 있는 예제를
   실행시킬 수 있습니다.

   예)
     > cd samples/ejb/basic/statelessSession  ; 샘플 디렉토리로 이동
     > jant                                   ; EJB deploy
     > jant run                               ; 클라이언트 프로그램 실행
     > jant undeploy                          ; EJB undeploy
     > jant clean                             ; 생성된 파일 삭제

   Example Server를 Shutdown하려면 다음과 같이 합니다.

   1. Windows의 경우
      시작 메뉴에서 TmaxSoft->JEUS6.0->Example Server->Down Example Server를
      실행합니다.
      또는 JEUS_HOME\bin\stopexampleserver.cmd를 실행합니다.

   2. Unix/Linux
      JEUS_HOME/bin/stopexampleserver를 실행합니다.






VII. 연락처

제품에 대한 문의사항은 홈 페이지에 문의하시거나, E-mail로 연락을 바랍니다.

  홈페이지: www.tmax.co.kr
  TechNet : technet.tmaxsoft.com
  E-mail  : info@tmax.co.kr


  Copyright 2007, TmaxSoft Co., Ltd. All Rights Reserved.
