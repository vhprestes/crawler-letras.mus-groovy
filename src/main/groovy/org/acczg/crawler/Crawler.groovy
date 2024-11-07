package org.acczg.crawler

import org.jsoup.nodes.Document
import org.jsoup.Jsoup

class Crawler {


    String url = "https://www.letras.mus.br/chico-buarque/45124/"


    def getLyrics() {
        Document doc = Jsoup.connect(url).get()
        def lyrics = doc.select(".lyric-original").text()
        return lyrics
    }
}
