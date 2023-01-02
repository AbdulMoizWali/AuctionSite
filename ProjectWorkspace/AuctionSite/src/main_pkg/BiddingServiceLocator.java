/**
 * BiddingServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package main_pkg;

public class BiddingServiceLocator extends org.apache.axis.client.Service implements main_pkg.BiddingService {

    public BiddingServiceLocator() {
    }


    public BiddingServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BiddingServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Bidding
    private java.lang.String Bidding_address = "http://localhost:8080/AuctionSite/services/Bidding";

    public java.lang.String getBiddingAddress() {
        return Bidding_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BiddingWSDDServiceName = "Bidding";

    public java.lang.String getBiddingWSDDServiceName() {
        return BiddingWSDDServiceName;
    }

    public void setBiddingWSDDServiceName(java.lang.String name) {
        BiddingWSDDServiceName = name;
    }

    public main_pkg.Bidding getBidding() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Bidding_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBidding(endpoint);
    }

    public main_pkg.Bidding getBidding(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            main_pkg.BiddingSoapBindingStub _stub = new main_pkg.BiddingSoapBindingStub(portAddress, this);
            _stub.setPortName(getBiddingWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBiddingEndpointAddress(java.lang.String address) {
        Bidding_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (main_pkg.Bidding.class.isAssignableFrom(serviceEndpointInterface)) {
                main_pkg.BiddingSoapBindingStub _stub = new main_pkg.BiddingSoapBindingStub(new java.net.URL(Bidding_address), this);
                _stub.setPortName(getBiddingWSDDServiceName());
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
        if ("Bidding".equals(inputPortName)) {
            return getBidding();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://main", "BiddingService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://main", "Bidding"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Bidding".equals(portName)) {
            setBiddingEndpointAddress(address);
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
