********************************************************************************
*                              Web Service ���� ����                           *
********************************************************************************

I. ���� ���� ���
   �� �������� �⺻������ Ant�� ����ؼ� �������ϰ� �����ϵ��� �Ǿ� �ֽ��ϴ�.
   �׸���, Example Server�� ����ؼ� �����մϴ�. Example Server�� JEUS_HOME��
   �ִ� readme.txt ������ VI. JEUS ���� �κ��� �����Ͻʽÿ�.

   * Build �� Deploy
    > jant

   * Ŭ���̾�Ʈ ����
    > jant run
    �Ǵ�
    > jant runclient

   * Undeploy
     > jant undeploy

   * ������ ���丮 �� ���� ����
     > jant clean

   * Build, Deploy, Client run, Undeploy
     (������ ���� 4������ �Ѳ����� �����ϴ� ��쵵 �ִ�.)
     > jant

   ���� 1 : jant�� JEUS_HOME/bin ���丮�� ������, JEUS_HOME/lib/etc/ant�� �ִ�
   Ant�� ������� �ݴϴ�.

   ���� 2 : uddi ���丮 �Ʒ� ������ ��쿡�� �����ϱ� ���� JEUS UDDI
   Application�� JEUS �� ���÷��� �Ǿ� �־�� �Ѵ�. �׸���, Derby�� ����ϱ� 
   ������ Derby ���� ���־�� �Ѵ�. JEUS UDDI Application�� 
   JEUS_HOME/webhome/uddi/jeusuddi_v3c.ear �� ���÷��� �ϸ�ȴ�.

   �̿ܿ� ������ Compile �� Deploy ������ �ʿ��� ��쿡�� �� ��� ���丮��
   �ִ� readme.txt ������ �����Ͻʽÿ�.
