package Network;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ConnectURI {
    private final String USER_AGENT = "Mozila/5.0";

    public static URL buildURL(String urlQuery){
        URL url=null;

        try{
            url= new URL(urlQuery.toString());
        } catch (MalformedURLException e){
            e.printStackTrace();
        }

        //Log.v(TAG, "Built URI" + url;
        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            Boolean hasInput = scanner.hasNext();
            if (hasInput){
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }

    public void postJSON(URL address, String jsonData) throws IOException {
        HttpURLConnection con = (HttpURLConnection) address.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "UTF-8");

        con.setDoOutput(true);
        OutputStreamWriter OutputStreamWriter = new OutputStreamWriter(con.getOutputStream());
        OutputStreamWriter.write(jsonData.toString());
        OutputStreamWriter.flush();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + address);
        System.out.println("Post parameter : ");
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) !=null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println("Response are =" + response.toString());
    }


}
