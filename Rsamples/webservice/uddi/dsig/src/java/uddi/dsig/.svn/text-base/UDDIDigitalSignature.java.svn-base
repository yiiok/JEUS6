package uddi.dsig;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Vector;

import jeus.uddi.v3.api.response.AuthToken;
import jeus.uddi.v3.api.response.BusinessDetail;
import jeus.uddi.v3.api.response.DispositionReport;
import jeus.uddi.v3.api.response.ErrInfo;
import jeus.uddi.v3.api.response.Result;
import jeus.uddi.v3.client.UDDIClient;
import jeus.uddi.v3.client.UDDIException;
import jeus.uddi.v3.datatype.Name;
import jeus.uddi.v3.datatype.business.BusinessEntity;

public class UDDIDigitalSignature {

    public static void main(String[] args) {
        String businessKey = "";
        try {

            String keystoreType = "JKS";
            String privateKeyAlias = "Tmaxsoft";
            String privateKeyPasswd = "jeusjeus";
            String certificateAlias = "Tmaxsoft";

            InputStream inputStream = new FileInputStream("build/mykeystore");
            KeyStore keyStore = KeyStore.getInstance(keystoreType);
            keyStore.load(inputStream, privateKeyPasswd.toCharArray());
            PrivateKey privateKey = (PrivateKey) keyStore.getKey(privateKeyAlias, privateKeyPasswd.toCharArray());
            X509Certificate certificate = (X509Certificate) keyStore.getCertificate(certificateAlias);

            UDDIClient client = new UDDIClient();

            client.setInquiryURL("http://localhost:8088/uddi/inquiry");
            client.setPublishURL("http://localhost:8088/uddi/publish");

            AuthToken authToken = client.get_authToken("jeus", "jeus");

            // execute the SaveBusiness request
            BusinessEntity businessEntity = new BusinessEntity();
            businessEntity.addName(new Name("test_Biz", "en"));
            Vector businessVector = new Vector();
            businessVector.add(businessEntity);
            BusinessDetail detail = client.save_business(authToken.getAuthInfoString(), businessVector);
            BusinessEntity savedBusiness = (BusinessEntity) detail.getBusinessEntityVector().get(0);

            BusinessEntity businessEntity2 = new BusinessEntity();
            businessEntity2.setBusinessKey(savedBusiness.getBusinessKey());

            // generate a BusinessEntity Vector
            Vector businessVector2 = new Vector();
            businessVector2.add(businessEntity2);

            // execute the SaveBusiness request
            BusinessDetail detail2 = client.save_business(authToken.getAuthInfoString(), businessEntity2, privateKey,
                    certificate);

            Vector businessEntityVector = detail2.getBusinessEntityVector();

            if ((businessEntityVector != null) && !businessEntityVector.isEmpty()) {
                BusinessEntity savedBusiness2 = (BusinessEntity) businessEntityVector.elementAt(0);
                businessKey = savedBusiness2.getBusinessKey();
                System.out.println("Published Business Key: " + businessKey);

                Vector nameVector = savedBusiness2.getNameVector();

                for (int j = 0; j < nameVector.size(); j++) {
                    Name name = (Name) nameVector.elementAt(j);
                    System.out.println("Published Business name: " + name.getValue());
                }
            } else {
                System.out.println("No Published Business(es)");
            }
        } catch (UDDIException ex) {
            DispositionReport dispReport = ex.getDispositionReport();

            if (dispReport != null) {
                Vector resultVector = dispReport.getResultVector();

                if (resultVector != null) {
                    Result result = (Result) resultVector.elementAt(0);
                    System.out.println("Errno:   " + result.getErrno());

                    ErrInfo errInfo = result.getErrInfo();

                    if (errInfo != null) {
                        System.out.println("ErrCode:  " + errInfo.getErrCode());
                        System.out.println("ErrValue:  " + errInfo.getValue());
                    }
                }
            } else {
                ex.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
