package lab06;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Lab06_4Test {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://google.com/");
        System.out.println(url.getAuthority());
        if(url.getContent().toString().startsWith("http")) {
            System.out.println("URL contains http");
        }else if(url.getContent().toString().startsWith("https")) {
            System.out.println("URL contains https");
        }

        System.out.println("Domain name is " + url.getHost());
    }
}
