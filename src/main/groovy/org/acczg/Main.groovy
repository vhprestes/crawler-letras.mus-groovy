package org.acczg

import org.acczg.crawler.Crawler
import org.acczg.utils.LyricsAnalyzer

static void main(String[] args) {
    println "Hello world!"
    def crawler = new Crawler()
    def lyrics = crawler.getLyrics()



    LyricsAnalyzer lyricsAnalyzer = new LyricsAnalyzer()
    println "Ditongos: " + lyricsAnalyzer.findWordsWithDitongos(lyrics)
    println "Tritongos: " + lyricsAnalyzer.findWordsWithTritongos(lyrics)
    println "Hiatos: " + lyricsAnalyzer.findWordsWithHiatos(lyrics)
    println "Proparoxytonas: " + lyricsAnalyzer.findProparoxytonas(lyrics)
    println "Sentences with four words: " + lyricsAnalyzer.findFourWordSentences(lyrics)

    println lyrics
}