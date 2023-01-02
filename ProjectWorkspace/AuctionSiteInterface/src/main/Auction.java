/**
 * Auction.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package main;

public interface Auction extends java.rmi.Remote {
    public java.lang.String getProductAuctionInformation(java.lang.String productName) throws java.rmi.RemoteException;
    public java.util.Calendar addHoursToJavaUtilDate(java.util.Calendar date, int hours) throws java.rmi.RemoteException;
    public void updateAuctionStatus(java.lang.String auctionID, java.lang.String status, boolean approved) throws java.rmi.RemoteException;
    public void insertAuctionWithProduct(java.lang.String userID, java.lang.String title, java.lang.String description, java.lang.String category, java.lang.String location, java.lang.String start, java.lang.String minBidPrice) throws java.rmi.RemoteException;
    public void insertAuction(java.lang.String productID, java.lang.String startDate, java.lang.String minBidPrice) throws java.rmi.RemoteException;
    public java.lang.String getAuctions() throws java.rmi.RemoteException;
}
