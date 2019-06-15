package org.dimigo.gui.Stack;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public class TranslatorText {


    private static String clientId = "bai7OMUv_e6Z7C0uXCPZ";//애플리케이션 클라이언트 아이디값";
    private static String clientSecret = "u5EEVXcyLF";//애플리케이션 클라이언트 시크릿값";
    private static String TEXT;
    private static String ret;
    public static String giveText(String TEXT) {
        try {
            String text = URLEncoder.encode( TEXT, "UTF-8" );
            String apiURL = "https://openapi.naver.com/v1/language/translate";
            URL url = new URL( apiURL );
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod( "POST" );
            con.setRequestProperty( "X-Naver-Client-Id", clientId );
            con.setRequestProperty( "X-Naver-Client-Secret", clientSecret );
            // post request
            String postParams = "source=en&target=ko&text=" + text;
            con.setDoOutput( true );
            DataOutputStream wr = new DataOutputStream( con.getOutputStream() );
            wr.writeBytes( postParams );
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if (responseCode == 200) { // 정상 호출
                br = new BufferedReader( new InputStreamReader( con.getInputStream() ) );
            } else {  // 에러 발생
                br = new BufferedReader( new InputStreamReader( con.getErrorStream() ) );
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append( inputLine );
            }
            br.close();

            ret = response.toString() ;

        } catch (Exception e) {
            System.out.println( e );
        }

        return ret;
    }



    public static Object show(String json) throws Exception{
        Map map = new ObjectMapper().readValue(json, Map.class);
        Map message = (Map) map.get("message");
        Map result = (Map) message.get("result");
        return result.get("translatedText");


    }
}

