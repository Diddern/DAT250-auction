
package client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "AuctionServerImplService", targetNamespace = "http://ws/", wsdlLocation = "http://ady.local:8080/DAT250-auction/AuctionServerImplService?wsdl")
public class AuctionServerImplService
    extends Service
{

    private final static URL AUCTIONSERVERIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException AUCTIONSERVERIMPLSERVICE_EXCEPTION;
    private final static QName AUCTIONSERVERIMPLSERVICE_QNAME = new QName("http://ws/", "AuctionServerImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://ady.local:8080/DAT250-auction/AuctionServerImplService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        AUCTIONSERVERIMPLSERVICE_WSDL_LOCATION = url;
        AUCTIONSERVERIMPLSERVICE_EXCEPTION = e;
    }

    public AuctionServerImplService() {
        super(__getWsdlLocation(), AUCTIONSERVERIMPLSERVICE_QNAME);
    }

    public AuctionServerImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), AUCTIONSERVERIMPLSERVICE_QNAME, features);
    }

    public AuctionServerImplService(URL wsdlLocation) {
        super(wsdlLocation, AUCTIONSERVERIMPLSERVICE_QNAME);
    }

    public AuctionServerImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, AUCTIONSERVERIMPLSERVICE_QNAME, features);
    }

    public AuctionServerImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AuctionServerImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AuctionServerImpl
     */
    @WebEndpoint(name = "AuctionServerImplPort")
    public AuctionServerImpl getAuctionServerImplPort() {
        return super.getPort(new QName("http://ws/", "AuctionServerImplPort"), AuctionServerImpl.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AuctionServerImpl
     */
    @WebEndpoint(name = "AuctionServerImplPort")
    public AuctionServerImpl getAuctionServerImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws/", "AuctionServerImplPort"), AuctionServerImpl.class, features);
    }

    private static URL __getWsdlLocation() {
        if (AUCTIONSERVERIMPLSERVICE_EXCEPTION!= null) {
            throw AUCTIONSERVERIMPLSERVICE_EXCEPTION;
        }
        return AUCTIONSERVERIMPLSERVICE_WSDL_LOCATION;
    }

}
