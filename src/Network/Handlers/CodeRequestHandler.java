package Network.Handlers;

import Code.CodeRequestProcesser;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import utils.Toolb;

import java.io.*;

public class CodeRequestHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String JSONer = Toolb.readAllString(httpExchange.getRequestBody());
        httpExchange.getResponseHeaders().add("Content-type","application/json");
        httpExchange.sendResponseHeaders(200,"{\"status\":\"OK\"}".getBytes().length);
        OutputStream a = httpExchange.getResponseBody();
        a.write("{\"status\":\"OK\"}".getBytes());
        a.flush();
        a.close();
        CodeRequestProcesser reqp = new CodeRequestProcesser(JSONer);
        //reqp.analyzeText();
        reqp.runCode(new String[] {"a","b"});
    }
}
