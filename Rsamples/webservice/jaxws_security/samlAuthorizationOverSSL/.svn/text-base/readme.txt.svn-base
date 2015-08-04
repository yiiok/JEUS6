1. in Unix, "export WSIMPORT_OPTS=-Djavax.net.ssl.trustStore=./mytruststore -Djavax.net.ssl.trustStorePassword=jeus123"
   in Windows, "set WSIMPORT_OPTS=-Djavax.net.ssl.trustStore=.\mytruststore -Djavax.net.ssl.trustStorePassword=jeus123"

2. Move 'keystore' and 'truststore' files to 'JEUS_HOME\config\NODE_NAME' directory.

3. Add 'ssl configuration' to WEBMain.xml.

ex)
            <http-listener>
                <listener-id>https1</listener-id>
                <port>8089</port>
                <thread-pool>
                    <min>10</min>
                    <max>20</max>
                    <step>1</step>
                    <max-idle-time>300000</max-idle-time>
                    <max-wait-queue>4</max-wait-queue>
                    <max-queue>-1</max-queue>
                </thread-pool>
                <scheme>https</scheme>
                <back-log>50</back-log>
                <server-access-control>false</server-access-control>
                <ssl-config>
                    <enable-secure>true</enable-secure>
                    <keystore-pass>jeus123</keystore-pass>
                    <truststore-pass>jeus123</truststore-pass>
                </ssl-config>
            </http-listener>
