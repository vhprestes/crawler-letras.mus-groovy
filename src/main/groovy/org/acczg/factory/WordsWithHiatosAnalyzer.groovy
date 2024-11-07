package org.acczg.factory

class WordsWithHiatosAnalyzer implements AnalysisMethod {
    def analyze(List<String> lyrics) {
        String hiatoPattern = /\b\w*(a[áãeêí]|e[íé]|i[ía]|o[ía]|u[aíu])\w*\b/
        List<String> res = lyrics.collect { it.findAll(hiatoPattern) }.flatten()
        res.removeIf { it.contains("qu") }
        return res
    }
}