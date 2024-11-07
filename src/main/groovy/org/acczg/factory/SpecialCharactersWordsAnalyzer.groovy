package org.acczg.factory

class SpecialCharactersWordsAnalyzer implements AnalysisMethod {
    def analyze(List<String> lyrics) {
        String pattern = /\b\w*[çãõ]\w*\b/
        return lyrics.collect { it.findAll(pattern).collect { it.toLowerCase() } }.flatten()
    }
}
