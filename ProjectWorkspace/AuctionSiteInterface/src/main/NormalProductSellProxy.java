package main;

public class NormalProductSellProxy implements main.NormalProductSell {
  private String _endpoint = null;
  private main.NormalProductSell normalProductSell = null;
  
  public NormalProductSellProxy() {
    _initNormalProductSellProxy();
  }
  
  public NormalProductSellProxy(String endpoint) {
    _endpoint = endpoint;
    _initNormalProductSellProxy();
  }
  
  private void _initNormalProductSellProxy() {
    try {
      normalProductSell = (new main.NormalProductSellServiceLocator()).getNormalProductSell();
      if (normalProductSell != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)normalProductSell)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)normalProductSell)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (normalProductSell != null)
      ((javax.xml.rpc.Stub)normalProductSell)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public main.NormalProductSell getNormalProductSell() {
    if (normalProductSell == null)
      _initNormalProductSellProxy();
    return normalProductSell;
  }
  
  public void insertNormalSellingWithProduct(java.lang.String title, java.lang.String description, java.lang.String category, java.lang.String location, java.lang.String price) throws java.rmi.RemoteException{
    if (normalProductSell == null)
      _initNormalProductSellProxy();
    normalProductSell.insertNormalSellingWithProduct(title, description, category, location, price);
  }
  
  public void insertNormalSelling(java.lang.String productID, java.lang.String price) throws java.rmi.RemoteException{
    if (normalProductSell == null)
      _initNormalProductSellProxy();
    normalProductSell.insertNormalSelling(productID, price);
  }
  
  public java.lang.String getNormalSellingProducts() throws java.rmi.RemoteException{
    if (normalProductSell == null)
      _initNormalProductSellProxy();
    return normalProductSell.getNormalSellingProducts();
  }
  
  public void updateNormalSellingtoSold(java.lang.String normalSellingProductID) throws java.rmi.RemoteException{
    if (normalProductSell == null)
      _initNormalProductSellProxy();
    normalProductSell.updateNormalSellingtoSold(normalSellingProductID);
  }
  
  
}