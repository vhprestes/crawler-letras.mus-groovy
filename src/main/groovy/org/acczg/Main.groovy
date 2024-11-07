package org.acczg

import org.acczg.crawler.Crawler

import org.acczg.view.FilterMenu

static void main(String[] args) {
    println "Hello world!"
    def crawler = new Crawler()
    def lyrics = crawler.getLyrics()

    FilterMenu filterMenu = new FilterMenu()
    filterMenu.showMenu(lyrics)



    }

