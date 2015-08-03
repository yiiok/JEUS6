package trust.sts;

import javax.xml.ws.Provider;
import javax.xml.ws.Service;
import javax.xml.ws.Service.Mode;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceProvider;

import com.sun.xml.ws.security.trust.sts.BaseSTSImpl;

import javax.annotation.Resource;

import javax.xml.transform.Source;
import javax.xml.ws.handler.MessageContext;

@ServiceMode(value = Service.Mode.PAYLOAD)
@WebServiceProvider(wsdlLocation = "WEB-INF/wsdl/sts.wsdl",
        targetNamespace = "http://tempuri.org/",
        serviceName = "SecurityTokenService",
        portName = "ISecurityTokenService_Port")
public class STSImpl extends BaseSTSImpl implements Provider<Source> {

    @Resource
    protected WebServiceContext context;

    protected MessageContext getMessageContext() {
        MessageContext msgCtx = context.getMessageContext();
        return msgCtx;
    }
}
