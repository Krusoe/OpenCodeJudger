package MainItems;

import Network.HttpReqHandler;

public class Main{
    public static void main(String[] args){
        Main.initalizer();

        HttpReqHandler h = new HttpReqHandler();
        Thread t = new Thread(h);
        t.start();
        while(true);
    }
    public static void initalizer(){
        Info.setVersion("Indev Alpha Insider UNSTABLE 0.0.1");
    }
}