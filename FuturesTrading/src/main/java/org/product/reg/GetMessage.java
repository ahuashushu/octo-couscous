package org.product.reg;


import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * 获取短信验证码类
 * @author LB_lfx
 *
 *
 */
public class GetMessage {

    public static final String ACCOUNT_SID="7fc95f099e3f44a0bd2731248fd0c20f";
    public static final String AUTH_TOKEN="74a515f752eb436c8e79f2889f30af96";
    public static final String BASE_URL = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";//请求地址是固定的不用改
    public static final int NUM=2;
    public static RandUtil randUtil=new RandUtil();
    public static String randon=randUtil.getRand();
    public static String smsContent="【易架构】您的验证码为"+randon+"，请于"+NUM+"分钟内正确输入，如非本人操作，请忽略此短信。";
    /**
     * (获取短信验证码)
     * @param to
     * @return String
     */
    public  static String getResult(String to) {
        RandUtil r=new RandUtil();
//        randNum = r.getRand();
//        String smsContent="【易架构】您的验证码为"+randon+"，请于"+"2"+"分钟内正确输入，如非本人操作，请忽略此短信。";         //这里的randNum 和 smsContent和上面的静态变量是一样的，可删除可保留
        String args = QueryUtil.queryArguments(ACCOUNT_SID, AUTH_TOKEN, smsContent, to);
        OutputStreamWriter out = null;
        InputStream in = null;
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();


        try {
            URL url = new URL(BASE_URL);
            URLConnection connection = url.openConnection(); //打开链接
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setConnectTimeout(5000);  //设置链接超时
            connection.setReadTimeout(10000);    //设置读取超时

            //提交数据
            out = new OutputStreamWriter(connection.getOutputStream(),"utf-8");
            out.write(args);
            out.flush();

            //读取返回数据
            br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = "";
            while((line = br.readLine())!=null){
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (br!=null) {
                    br.close();
                }
                if (out!=null) {
                    out.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        JSONObject jsonObject = JSONObject.fromObject(sb.toString());
        System.out.println(jsonObject+"---------------");
        Object object = jsonObject.get("respCode");
        System.out.println("状态码："+object+"验证码："+randon);
        System.out.println(!object.equals("00000"));
        if (!object.equals("00000")) {
            return object.toString();
        }else{

            return randon;
        }


    }
//  测试功能
//  public static void main(String[] args) {
//
//      String result =getResult("15502203513");
//      System.out.println("验证码："+randon+"\t"+result);
//  }

    public static boolean decide(String captcha){
        if(randon.equals(captcha)){
            return true;
        }
        System.out.println(randon+" "+ captcha);
        return false;
    }
}
