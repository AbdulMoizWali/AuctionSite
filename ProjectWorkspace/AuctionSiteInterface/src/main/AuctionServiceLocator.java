/**
 * AuctionServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package main;

public class AuctionServiceLocator extends org.apache.axis.client.Service implements main.AuctionService {

    public AuctionServiceLocator() {
    }


    public AuctionServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AuctionServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Auction
    private java.lang.String Auction_address = "http://localhost:8080/AuctionSite/services/Auction";

    public java.lang.String getAuctionAddress() {
        return Auction_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AuctionWSDDServiceName = "Auction";

    public java.lang.String getAuctionWSDDServiceName() {
        return AuctionWSDDServiceName;
    }

    public void setAuctionWSDDServiceName(java.lang.String name) {
        AuctionWSDDServiceName = name;
    }

    public main.Auction getAuction() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Auction_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAuction(endpoint);
    }

    public main.Auction getAuction(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            main.AuctionSoapBindingStub _stub = new main.AuctionSoapBindingStub(portAddress, this);
            _stub.setPortName(getAuctionWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAuctionEndpointAddress(java.lang.String address) {
        Auction_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (main.Auction.class.isAssignableFrom(serviceEndpointInterface)) {
                main.AuctionSoapBindingStub _stub = new main.AuctionSoapBindingStub(new java.net.URL(Auction_address), this);
                _stub.setPortName(getAuctionWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Auction".equals(inputPortName)) {
            return getAuction();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://main", "AuctionService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://main", "Auction"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Auction".equals(portName)) {
            setAuctionEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
