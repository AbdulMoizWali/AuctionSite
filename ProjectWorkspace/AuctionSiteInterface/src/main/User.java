/**
 * User.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package main;

public interface User extends java.rmi.Remote {
    public java.lang.String getUserData(java.lang.String userID) throws java.rmi.RemoteException;
    public java.lang.String getProductUserData(int sellingid) throws java.rmi.RemoteException;
    public void insertUserData(java.lang.String username, java.lang.String password, java.lang.String first_name, java.lang.String last_name, java.lang.String phone, java.lang.String address, java.lang.String CNIC) throws java.rmi.RemoteException;
    public void updateUserdata(java.lang.String userid, java.lang.String username, java.lang.String password, java.lang.String firstname, java.lang.String lastname, java.lang.String phone, java.lang.String address, java.lang.String balance, java.lang.String CNIC) throws java.rmi.RemoteException;
    public java.lang.String getloginID(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
}
