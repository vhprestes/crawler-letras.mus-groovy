package org.acczg.factory

class WordsWithDitongosAnalyzer implements AnalysisMethod {
    def analyze(List<String> lyrics) {
        String ditongoPattern = /\b\w*(ai|au|ei|eu|iu|oi|ou|ui|ão|õe|ãe|ãi)\w*\b/
        return lyrics.collect { it.findAll(ditongoPattern) }.flatten()
    }
}