/**
 * BiddingService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package main_pkg;

public interface BiddingService extends javax.xml.rpc.Service {
    public java.lang.String getBiddingAddress();

    public main_pkg.Bidding getBidding() throws javax.xml.rpc.ServiceException;

    public main_pkg.Bidding getBidding(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
