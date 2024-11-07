package org.acczg.view

import org.acczg.factory.AnalysisMethod
import org.acczg.factory.LyricFilterFactory

class FilterMenu {
    AnalysisMethod analyzer

    def showMenu(List lyrics) {
        def option
        boolean menu = true
        def res
        while (menu) {
            println "\n Escolha uma opção de filtro para aplicar na letra da música:"
            println "1. Só Proparoxitonas"
            println "2. Remover plural"
            println "3. Frases com quatro palavras ou mais"
            println "4. Palavras com hiatos"
            println "5. Palavras com ditongo"
            println "6. Palavras com tritongo"
            println "7. Palavras com caracteres especiais"
            println "8. frases repetidas"
            println "0. Exit"
            option = System.in.newReader().readLine()
            switch (option) {
                case "1":
                    res = LyricFilterFactory.getAnalyzer("proparoxitonas")
                    print(res.analyze(lyrics))
                    break
                case "2":
                    res = LyricFilterFactory.getAnalyzer("removePlural")
                    print(res.analyze(lyrics))
                    break
                case "3":
                    res = LyricFilterFactory.getAnalyzer("fourWordSentences")
                    print(res.analyze(lyrics))
                    break
                case "4":
                    res = LyricFilterFactory.getAnalyzer("hiatos")
                    print(res.analyze(lyrics))
                    break
                case "5":
                    res = LyricFilterFactory.getAnalyzer("ditongos")
                    print(res.analyze(lyrics))
                    break
                case "6":
                    res = LyricFilterFactory.getAnalyzer("tritongos")
                    print(res.analyze(lyrics))
                    break
                case "7":
                    res = LyricFilterFactory.getAnalyzer("specialCharacters")
                    print(res.analyze(lyrics))
                    break
                case "8":
                    res = LyricFilterFactory.getAnalyzer("repeatedPhrases")
                    print(res.analyze(lyrics))
                    break
                case "0":
                    println "Exiting..."
                    menu = false
                    break

                    return
                default:
                    println "Invalid option"
            }
        }
    }
}