package main;

public class AuctionProxy implements main.Auction {
  private String _endpoint = null;
  private main.Auction auction = null;
  
  public AuctionProxy() {
    _initAuctionProxy();
  }
  
  public AuctionProxy(String endpoint) {
    _endpoint = endpoint;
    _initAuctionProxy();
  }
  
  private void _initAuctionProxy() {
    try {
      auction = (new main.AuctionServiceLocator()).getAuction();
      if (auction != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)auction)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)auction)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (auction != null)
      ((javax.xml.rpc.Stub)auction)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public main.Auction getAuction() {
    if (auction == null)
      _initAuctionProxy();
    return auction;
  }
  
  public void insertAuction(java.lang.String productID, java.lang.String startDate, java.lang.String minBidPrice) throws java.rmi.RemoteException{
    if (auction == null)
      _initAuctionProxy();
    auction.insertAuction(productID, startDate, minBidPrice);
  }
  
  public java.lang.String getAuctions() throws java.rmi.RemoteException{
    if (auction == null)
      _initAuctionProxy();
    return auction.getAuctions();
  }
  
  public java.lang.String getProductAuctionInformation(java.lang.String productName) throws java.rmi.RemoteException{
    if (auction == null)
      _initAuctionProxy();
    return auction.getProductAuctionInformation(productName);
  }
  
  public java.util.Calendar addHoursToJavaUtilDate(java.util.Calendar date, int hours) throws java.rmi.RemoteException{
    if (auction == null)
      _initAuctionProxy();
    return auction.addHoursToJavaUtilDate(date, hours);
  }
  
  public void insertAuctionWithProduct(java.lang.String title, java.lang.String description, java.lang.String category, java.lang.String location, java.lang.String start, java.lang.String minBidPrice) throws java.rmi.RemoteException{
    if (auction == null)
      _initAuctionProxy();
    auction.insertAuctionWithProduct(title, description, category, location, start, minBidPrice);
  }
  
  public void updateAuctionStatus(java.lang.String auctionID, java.lang.String status, boolean approved) throws java.rmi.RemoteException{
    if (auction == null)
      _initAuctionProxy();
    auction.updateAuctionStatus(auctionID, status, approved);
  }
  
  
}