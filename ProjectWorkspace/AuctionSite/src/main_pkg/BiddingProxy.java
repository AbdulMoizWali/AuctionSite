package main_pkg;

public class BiddingProxy implements main_pkg.Bidding {
  private String _endpoint = null;
  private main_pkg.Bidding bidding = null;
  
  public BiddingProxy() {
    _initBiddingProxy();
  }
  
  public BiddingProxy(String endpoint) {
    _endpoint = endpoint;
    _initBiddingProxy();
  }
  
  private void _initBiddingProxy() {
    try {
      bidding = (new main_pkg.BiddingServiceLocator()).getBidding();
      if (bidding != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)bidding)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)bidding)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (bidding != null)
      ((javax.xml.rpc.Stub)bidding)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public main_pkg.Bidding getBidding() {
    if (bidding == null)
      _initBiddingProxy();
    return bidding;
  }
  
  public void main(java.lang.String[] args) throws java.rmi.RemoteException{
    if (bidding == null)
      _initBiddingProxy();
    bidding.main(args);
  }
  
  public java.lang.String getProduct(int productid) throws java.rmi.RemoteException{
    if (bidding == null)
      _initBiddingProxy();
    return bidding.getProduct(productid);
  }
  
  public void updateStatus(int auctionID) throws java.rmi.RemoteException{
    if (bidding == null)
      _initBiddingProxy();
    bidding.updateStatus(auctionID);
  }
  
  public java.lang.String getenddate(int auctionID) throws java.rmi.RemoteException{
    if (bidding == null)
      _initBiddingProxy();
    return bidding.getenddate(auctionID);
  }
  
  public void bidInsert(int auctionid, int bidamount, int loginuserid) throws java.rmi.RemoteException{
    if (bidding == null)
      _initBiddingProxy();
    bidding.bidInsert(auctionid, bidamount, loginuserid);
  }
  
  
}