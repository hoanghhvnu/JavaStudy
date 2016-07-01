package hoanghh.study.network;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.List;

public class MyProxy extends ProxySelector {

    @Override
    public List<Proxy> select(URI uri) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
        // TODO Auto-generated method stub
        
    }

}
