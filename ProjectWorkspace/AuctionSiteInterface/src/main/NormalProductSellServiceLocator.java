/**
 * NormalProductSellServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package main;

public class NormalProductSellServiceLocator extends org.apache.axis.client.Service implements main.NormalProductSellService {

    public NormalProductSellServiceLocator() {
    }


    public NormalProductSellServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public NormalProductSellServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for NormalProductSell
    private java.lang.String NormalProductSell_address = "http://localhost:8080/AuctionSite/services/NormalProductSell";

    public java.lang.String getNormalProductSellAddress() {
        return NormalProductSell_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String NormalProductSellWSDDServiceName = "NormalProductSell";

    public java.lang.String getNormalProductSellWSDDServiceName() {
        return NormalProductSellWSDDServiceName;
    }

    public void setNormalProductSellWSDDServiceName(java.lang.String name) {
        NormalProductSellWSDDServiceName = name;
    }

    public main.NormalProductSell getNormalProductSell() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(NormalProductSell_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getNormalProductSell(endpoint);
    }

    public main.NormalProductSell getNormalProductSell(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            main.NormalProductSellSoapBindingStub _stub = new main.NormalProductSellSoapBindingStub(portAddress, this);
            _stub.setPortName(getNormalProductSellWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setNormalProductSellEndpointAddress(java.lang.String address) {
        NormalProductSell_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (main.NormalProductSell.class.isAssignableFrom(serviceEndpointInterface)) {
                main.NormalProductSellSoapBindingStub _stub = new main.NormalProductSellSoapBindingStub(new java.net.URL(NormalProductSell_address), this);
                _stub.setPortName(getNormalProductSellWSDDServiceName());
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
        if ("NormalProductSell".equals(inputPortName)) {
            return getNormalProductSell();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://main", "NormalProductSellService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://main", "NormalProductSell"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("NormalProductSell".equals(portName)) {
            setNormalProductSellEndpointAddress(address);
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
