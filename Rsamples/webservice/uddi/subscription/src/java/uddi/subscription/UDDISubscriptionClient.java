package uddi.subscription;

import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

import jeus.uddi.client.transport.TransportException;
import jeus.uddi.datatype.RegistryObject;
import jeus.uddi.v3.api.request.inquiry.FindBusiness;
import jeus.uddi.v3.api.response.AuthToken;
import jeus.uddi.v3.api.response.BusinessDetail;
import jeus.uddi.v3.api.response.SubscriptionResultsList;
import jeus.uddi.v3.api.response.Subscriptions;
import jeus.uddi.v3.client.UDDIClient;
import jeus.uddi.v3.client.UDDIException;
import jeus.uddi.v3.datatype.Name;
import jeus.uddi.v3.datatype.business.BusinessEntity;
import jeus.uddi.v3.datatype.subscription.CoveragePeriod;
import jeus.uddi.v3.datatype.subscription.Subscription;
import jeus.uddi.v3.datatype.subscription.SubscriptionFilter;
import jeus.uddi.xmlbinding.BindException;

public class UDDISubscriptionClient {

    public static void main(String[] args) {
        try {
            UDDIClient client = new UDDIClient();
            client.setInquiryURL("http://localhost:8088/uddi/inquiry");
            client.setPublishURL("http://localhost:8088/uddi/publish");
            client.setSubscriptionURL("http://localhost:8088/uddi/subscription");
            AuthToken authToken = client.get_authToken("jeus", "jeus");

            // execute the SaveBusiness request
            BusinessEntity businessEntity = new BusinessEntity();
            businessEntity.addName(new Name("sub_Biz", "en"));
            Vector businessVector = new Vector();
            businessVector.add(businessEntity);
            client.save_business(authToken.getAuthInfoString(), businessVector);

            // Make a subscription
            Subscription subscription = new Subscription();
            // subscription.setBrief(true);
            // subscription.setBindingKey("");
            // subscription.setNotificationInterval("");

            // Make a subscriptionFilter
            FindBusiness findBusiness = new FindBusiness();
            findBusiness.addName(new Name("sub_Biz", "en"));
            subscription.setSubscriptionFilter(new SubscriptionFilter(findBusiness));

            // execute save_subscription request
            Subscriptions subscriptions = client.save_subscription(authToken.getAuthInfoString(), subscription);

            Subscription savedSubscription = subscriptions.getSubscription(0);
            System.out.println(savedSubscription.toXML());
            String subscriptionKey = savedSubscription.getSubscriptionKeyString();

            SubscriptionResultsList results = client.get_subscriptionResults(
                    authToken.getAuthInfoString(), subscriptionKey,
                    new CoveragePeriod(new GregorianCalendar(2005,
                            Calendar.JANUARY, 1), null), null);
            RegistryObject resultsList = results.getResultsList();
            System.out.println(resultsList.toXML());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UDDIException e) {
            e.printStackTrace();
        } catch (BindException e) {
            e.printStackTrace();
        } catch (TransportException e) {
            e.printStackTrace();
        }
    }
}
