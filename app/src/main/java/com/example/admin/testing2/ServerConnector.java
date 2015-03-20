package com.example.admin.testing2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by admin on 20.03.15.
 */
public class ServerConnector {
    final String resources = "http://daisyedu.com/rest/resource";
    final String resource = "http://daisyedu.com/rest/resource&id=";
    DocumentsList data;
    boolean useCache = true;
    public boolean Bad = false;
    private  Runnable loadedCallback;
    public ServerConnector() {
        Bad = true;
    }
    public ServerConnector(Runnable lbc) throws Exception {
        final String request = resources;
        loadedCallback = lbc;
        if (useCache) {
            throw new Exception("Not implemented");
        }
        asyncLoad(resources, new Runnable() {
            @Override
            public void run() {
                //TODO: Process async raw data var here(it will contain recieved data)
            }
        });
    }
    private String asyncRawData = "";
    public void asyncLoad(final String url, final Runnable onLoad)  {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    asyncRawData = syncLoad(url);
                    onLoad.run();
                } catch (IOException e) {e.printStackTrace();}
            }
        });
        t.setPriority(Thread.NORM_PRIORITY);
        t.setDaemon(true);
        t.start();
    }
    /**
     * Загружает веб-страницу
     * @param _url URL веб-страницы
     * @return исходный код страницы
     * @throws IOException
     */
    static String syncLoad(String _url) throws IOException {
        URL url = new URL(_url);
        URLConnection urlConnection = url.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        StringBuilder lines = new StringBuilder();
        String line;
        while ( (line=bufferedReader.readLine()) != null){
            lines.append(line).append("");
        }
        return lines.toString();
    }

    public DocumentsList getDocs() {
        return data;
    }
    public DocTree getTree() {
        return getDocs().getTree();
    }
    public String CoachToStr(String _id) {
        int id = Integer.parseInt(_id);
        for(SmallDocument sd:getDocs().asCollection())
            if (sd.getID() == id)
                return sd.getTitle();
        return "";
    }
    public String FormatToStr(String id) {
        switch (id) {
            case "1": return "Онлайн";
            case "2": return "Оффлайн";
            default: return "";
        }
    }
}
