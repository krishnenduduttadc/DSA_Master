/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maths;

/**
 *
 * @author krishnendu
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JavaGetRequest {

    private static HttpURLConnection con;

    public static void main(String[] args) throws IOException {

        String url[] = {
            "https://nsurvey.wbsedcl.in/tuntuni/openmap/dt-swap.php?ptId=864941042002031578734257D0&sin=8405I",
            "https://nsurvey.wbsedcl.in/tuntuni/openmap/dt-swap.php?ptId=868988033200881579862074D0&sin=84051",
            "https://nsurvey.wbsedcl.in/tuntuni/openmap/dt-swap.php?ptId=862537046830451582174316D0&sin=AO08L",
            "https://nsurvey.wbsedcl.in/tuntuni/openmap/dt-swap.php?ptId=862537046830451580101227D0&sin=AO054",
            "https://nsurvey.wbsedcl.in/tuntuni/openmap/dt-swap.php?ptId=862537046830451578907328D0&sin=AO00W",
            "https://nsurvey.wbsedcl.in/tuntuni/openmap/dt-swap.php?ptId=869041039367421569040623D0&sin=DSI19",
            "https://nsurvey.wbsedcl.in/tuntuni/openmap/dt-swap.php?ptId=869041039367421568970750D0&sin=DSI18"

        };

        getUtil(url);

    }

    static void getUtil(String[] url) {
        for (int i = 0; i < url.length; i++) {
            try {
                var myurl = new URL(url[i]);
                con = (HttpURLConnection) myurl.openConnection();

                con.setRequestMethod("GET");

                StringBuilder content;

                try (BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()))) {

                    String line;
                    content = new StringBuilder();

                    while ((line = in.readLine()) != null) {

                        content.append(line);
                        content.append(System.lineSeparator());
                    }
                }

                System.out.println(url[i] + "$" + content.toString());

            } catch (Exception e) {

            } finally {

                con.disconnect();
            }
        }
    }
}
