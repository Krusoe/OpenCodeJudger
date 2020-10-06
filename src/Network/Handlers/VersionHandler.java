package Network.Handlers;

import MainItems.Info;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class VersionHandler implements HttpHandler {


    @Override
    public void handle(HttpExchange exc) throws IOException {
        //Prepare the response body
        StringBuffer sb = new StringBuffer();
        sb.append("{\"version\":\"");
        sb.append(Info.getVersion());
        sb.append("\"}");
        byte[] byter = sb.toString().getBytes();

        //Prepare the response headers
        exc.getResponseHeaders().add("Content-type","application/json");
        exc.sendResponseHeaders(200,byter.length);

        //Write & Flush Data
        OutputStream out = exc.getResponseBody();
        out.write(byter);
        out.flush();
        out.close();
    }
}
