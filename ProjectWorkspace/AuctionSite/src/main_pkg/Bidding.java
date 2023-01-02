/**
 * Bidding.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package main_pkg;

public interface Bidding extends java.rmi.Remote {
    public void main(java.lang.String[] args) throws java.rmi.RemoteException;
    public java.lang.String getProduct(int productid) throws java.rmi.RemoteException;
    public void updateStatus(int auctionID) throws java.rmi.RemoteException;
    public java.lang.String getenddate(int auctionID) throws java.rmi.RemoteException;
    public void bidInsert(int auctionid, int bidamount, int loginuserid) throws java.rmi.RemoteException;
}
