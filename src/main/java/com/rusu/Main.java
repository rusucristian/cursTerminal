package com.rusu;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        Document page = getPage();

        getDate();

        Element formCurrency = page.select("form[class = exchange-rates-ajax-form]").first();
        Elements allCurrency = formCurrency.select("li");
//        Elements currency = allCurrency.select("span[class = currency]");
//        Elements value = allCurrency.select("span[class^=rate]");

        for (Element value : allCurrency) {
//            System.out.println(value.select("span[class = currency]").text() + "        " + value.select("span[class^=rate]").text());
            System.out.printf("%s%13s\n", value.select("span[class = currency]").text(), value.select("span[class^=rate]").text());
        }
    }

    private static Document getPage() throws IOException {
        String url = "https://bnm.md/";
        Document pageDocument = Jsoup.parse(new URL(url), 10000);
        return pageDocument;
    }

    private static void getDate(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        System.out.printf("%13s\n", dateFormat.format(date));
    }
}
