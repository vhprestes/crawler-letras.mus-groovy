package org.acczg.utils

class LyricsAnalyzer {
//    LyricsAnalyzer(String text) {
//      this.lirycs = text
//   }

    def findSpecialCharactersWords(String text) {
        def pattern = /\b\w*[çãõ]\w*\b/
        return text.findAll(pattern)
    }

    def findRepeatedPhrases(String text) {
        def sentences = text.split(/[.,!?\r\n]/).collect { it.trim() }
        sentences.removeIf { it.length() < 5 }
        def frequency = sentences.countBy { it }
        return frequency.findAll { it.value > 1 }
    }


    static def findWordsWithDitongos(String text) {
        def ditongoPattern = /\b\w*(ai|au|ei|eu|iu|oi|ou|ui|ão|õe|ãe|ãi)\w*\b/
        return text.findAll(ditongoPattern)
    }

    def findWordsWithTritongos(String text) {
        def tritongoPattern = /\b\w*(uai|uei|uou|ieis|ueu)\w*\b/
        return text.findAll(tritongoPattern)
    }

    def findWordsWithHiatos(String text) {
        def hiatoPattern = /\b\w*(a[áãeêí]|e[íé]|i[ía]|o[ía]|u[íu])\w*\b/
        return text.findAll(hiatoPattern)
    }

    def findFourWordSentences(String text) {
        def sentences = text.split(/[.,!?\r\n]/).collect { it.trim() }
        return sentences.findAll { it.split(/\s+/).size() == 4 }
    }


    def findProparoxytonas(String text) {
        def proparoxytonasPattern = /\b\w*[áéíóúâêîôûãõàèìòùäëïöü][bcdfghjklmnpqrstvwxyz]*[aeiou][bcdfghjklmnpqrstvwxyz]*[aeiou][bcdfghjklmnpqrstvwxyz]*\b/
        return text.findAll(proparoxytonasPattern).findAll { word ->
            def syllables = word.split(/(?<=[aeiouáéíóúâêîôûãõàèìòùäëïöü])/)
            return syllables.size() > 2 && syllables[-3] ==~ /.*[áéíóúâêîôûãõàèìòùäëïöü].*/
        }
    }


    def removePluralWords(String text) {
        def pluralPattern = /\b\w+(?:es|s)\b/
        return text.replaceAll(pluralPattern, "").replaceAll(/\s+/, " ").trim()
    }

}
