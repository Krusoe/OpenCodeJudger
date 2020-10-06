package Network;

import Network.Handlers.VersionHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class HttpReqHandler implements Runnable {
    public void run() {
        RealReqHandler re = new RealReqHandler();
        try{
            re.init();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            re.stopStream();
        }
    }
}
class RealReqHandler{
    HttpServer server;
    public void init() throws IOException{
        server = HttpServer.create(new InetSocketAddress(8080), 0);

        regContexts();

        //Server thread pool init
        server.setExecutor(Executors.newFixedThreadPool(10));
        server.start();
    }
    public void stopStream(){
        ;
    }
    private void regContexts(){
        //Register
        server.createContext("/version", new VersionHandler());

    }
}