package MainItems;

import Code.CodeRequestProcesser;
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
        Info.setGppPath("D:\\JavaProgramLib\\OpenCodeJudger\\GPP\\bin\\gcc.exe");
        Info.setVersion("Indev Alpha Insider UNSTABLE 0.0.1");
    }
}