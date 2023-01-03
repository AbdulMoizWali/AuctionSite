package main;

public class UserProxy implements main.User {
  private String _endpoint = null;
  private main.User user = null;
  
  public UserProxy() {
    _initUserProxy();
  }
  
  public UserProxy(String endpoint) {
    _endpoint = endpoint;
    _initUserProxy();
  }
  
  private void _initUserProxy() {
    try {
      user = (new main.UserServiceLocator()).getUser();
      if (user != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)user)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)user)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (user != null)
      ((javax.xml.rpc.Stub)user)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public main.User getUser() {
    if (user == null)
      _initUserProxy();
    return user;
  }
  
  public java.lang.String getUserData(java.lang.String userID) throws java.rmi.RemoteException{
    if (user == null)
      _initUserProxy();
    return user.getUserData(userID);
  }
  
  public java.lang.String getProductUserData(int sellingid) throws java.rmi.RemoteException{
    if (user == null)
      _initUserProxy();
    return user.getProductUserData(sellingid);
  }
  
  public void insertUserData(java.lang.String username, java.lang.String password, java.lang.String first_name, java.lang.String last_name, java.lang.String phone, java.lang.String address, java.lang.String CNIC) throws java.rmi.RemoteException{
    if (user == null)
      _initUserProxy();
    user.insertUserData(username, password, first_name, last_name, phone, address, CNIC);
  }
  
  public void updateUserdata(java.lang.String userid, java.lang.String username, java.lang.String password, java.lang.String firstname, java.lang.String lastname, java.lang.String phone, java.lang.String address, java.lang.String balance, java.lang.String CNIC) throws java.rmi.RemoteException{
    if (user == null)
      _initUserProxy();
    user.updateUserdata(userid, username, password, firstname, lastname, phone, address, balance, CNIC);
  }
  
  public java.lang.String getloginID(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException{
    if (user == null)
      _initUserProxy();
    return user.getloginID(username, password);
  }
  
  
}