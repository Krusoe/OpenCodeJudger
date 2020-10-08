package Code;

import MainItems.Info;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Old School Code Request Processer
 */
public class CodeRequestProcesser {
    private String Text;
    private int lang;//0:C++
    private String realCode;
    private String Status = "Waiting";

    public CodeRequestProcesser(String OriText){
        Text = OriText;
    }
    public void analyzeText() {
        JSONObject json = new JSONObject(Text);
        this.lang = json.getInt("lang");
        this.realCode = json.getString("Code");
    }
    public int runCode(String[] Test){
        int score = 0;
        Runtime rtm = Runtime.getRuntime();
        Process p = null;
        StringBuilder args = new StringBuilder(Info.getGppPath());
        args.append(" --help");
        try{
            StringBuilder sb =new StringBuilder();
            p = rtm.exec(args.toString());
            InputStream a = p.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(a);
            int nxt;
            while((nxt = bis.read()) != -1){
                sb.append((char)nxt);
            }

            bis.close();
            a.close();
            p.destroy();
            System.out.println(sb.toString());
        }catch(Exception e ){
            e.printStackTrace();
        }
        return 0;
    }
}
