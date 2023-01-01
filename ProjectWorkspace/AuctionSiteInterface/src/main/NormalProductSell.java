/**
 * NormalProductSell.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package main;

public interface NormalProductSell extends java.rmi.Remote {
    public void insertNormalSellingWithProduct(java.lang.String title, java.lang.String description, java.lang.String category, java.lang.String location, java.lang.String price) throws java.rmi.RemoteException;
    public void insertNormalSelling(java.lang.String productID, java.lang.String price) throws java.rmi.RemoteException;
    public java.lang.String getNormalSellingProducts() throws java.rmi.RemoteException;
    public void updateNormalSellingtoSold(java.lang.String normalSellingProductID) throws java.rmi.RemoteException;
}
