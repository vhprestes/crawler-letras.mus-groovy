package org.acczg.utils

class LyricsAnalyzer {

    def findSpecialCharactersWords(List<String> lyrics) {
        String pattern = /\b\w*[çãõ]\w*\b/
        def res = lyrics.collect { it.findAll(pattern).collect {it.toLowerCase()} }.flatten()
        return res
    }

    def findRepeatedPhrases(List<String> lyrics) {
        lyrics.removeIf { it.length() < 5 }
        Map<String, Integer> frequency = lyrics.countBy { it.toLowerCase() }
        return frequency.findAll { it.value > 1 }
    }

    static def findWordsWithDitongos(List<String> lyrics) {
        String ditongoPattern = /\b\w*(ai|au|ei|eu|iu|oi|ou|ui|ão|õe|ãe|ãi)\w*\b/
        return lyrics.collect { it.findAll(ditongoPattern) }.flatten()
    }

    def findWordsWithTritongos(List<String> lyrics) {
        String tritongoPattern = /\b\w*(uai|uei|uou|ieis|ueu)\w*\b/
        return lyrics.collect { it.findAll(tritongoPattern) }.flatten()
    }

    def findWordsWithHiatos(List<String> lyrics) {
        String hiatoPattern = /\b\w*(a[áãeêí]|e[íé]|i[ía]|o[ía]|u[aíu])\w*\b/
        List<String> res = lyrics.collect { it.findAll(hiatoPattern) }.flatten()
        res.removeIf { it.contains("qu") }
        return res
    }

    def findFourWordSentences(List<String> lyrics) {
        def res = []
        for (String sentence : lyrics) {
            if (sentence.split(/\s+/).size() >= 4) {
                sentence.trim().toLowerCase()
                res.add(sentence)
            }
        }
        return res

    }

    def findProparoxitonas(List<String> lyrics) {
        String proparoxytonasPattern = /\b\w*[áéíóúâêîôûãõàèìòùäëïöü][bcdfghjklmnpqrstvwxyz]*[aeiou][bcdfghjklmnpqrstvwxyz]*[aeiou][bcdfghjklmnpqrstvwxyz]*\b/
        return lyrics.collect {
            it.findAll(proparoxytonasPattern).findAll { word ->
                String[] syllables = word.split(/(?<=[aeiouáéíóúâêîôûãõàèìòùäëïöü])/)
                syllables.size() > 2 && syllables[-3] ==~ /.*[áéíóúâêîôûãõàèìòùäëïöü].*/
            }
        }.flatten()
    }

    def removePluralWords(List<String> lyrics) {
        String pluralPattern = /\b\w+(?:es|s)\b/
        List res = lyrics.collect { it.replaceAll(pluralPattern, "").replaceAll(/\s+/, " ").trim() }.flatten()
        res.removeIf { it.length() == 0 }
        return res
    }
}