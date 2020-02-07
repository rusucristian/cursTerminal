package com.rusu;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {

    }

    private static Document getPage() throws IOException {
        String url = "https://bnm.md/";
        Document pageDocument = Jsoup.parse(new URL(url), 10000);
        return pageDocument;
    }
}
