****************************************************************************************
*					Security Sample																											*
****************************************************************************************

1. 예제 설명

  JEUS에 Deploy되어 사용되는 servlet,ejb 모듈에서 보안 설정을 보여주기 위한 샘플입니다. 
  비교적 간단하게 확인 할 수 있는 부분만 설정해 놓은 상태이며, 샘플을 이용하는 사람에 따라 다양한 설정이 가능합니다.
  직접 설정을 고쳐보면서 보안 동작을 확인하시기 바랍니다.

  
2. 주의사항

	이 예제를 실수하지 않고 사용하기 위해서는 다음과 같은 사항에 주의하셔야 합니다. 여기에 적혀 있지 않은 문제가 발생할
	경우, 매뉴얼을 참고하십시오. 
	
	1) deployment descriptor에 정의하는 principal은 해당 어플리케이션이 사용되는 security domain에 정의되어 있어야 합니다.
	   (JEUS_HOME/config/<node name>/security/<domain name>/accounts.xml에서 정의합니다.)
	2) 본 샘플에서는 accounts.xml을 제공합니다. 직접 작성하기 번거로울 경우 참고하십시오.
	3) deployment descriptor에 정의하는 role name은 security domain의 role과 다른 개념입니다. 이 두 개의 role 사이에는
	서로 상관 관계가 없습니다.
	4) servlet 이름이나 ejb 이름은 이 샘플이 최초에 만들었을 때 어울리도록 작명 되었습니다. 추후 여러번 수정을 거치게 되면
	  이름과 동작 사이에 괴리가 있을 수 있습니다.
	  
3. 예제 실행 방법

  * 본 예제는 ejb와 servlet을 따로 컴파일하셔야 합니다.
    - ejb 경로 : SAMPLE_HOME/security/app-setting/ejb
    - servlet 경로 : SAMPLE_HOME/security/app-setting/war
    
  * 위의 각 경로에서 ant(또는 ant -f build.xml)를 실행할 경우 빌드부터 디플로이까지 자동으로 진행됩니다.
  
  * 이 예제의 기본 url은 http://<host address>:<port>/security/mainpage입니다.
	


