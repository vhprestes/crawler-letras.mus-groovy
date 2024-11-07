package org.acczg.factory

class RemovePluralWordsAnalyzer implements AnalysisMethod {
    def analyze(List<String> lyrics) {
        String pluralPattern = /\b\w+(?:es|s)\b/
        List res = lyrics.collect { it.replaceAll(pluralPattern, "").replaceAll(/\s+/, " ").trim() }.flatten()
        res.removeIf { it.length() == 0 }
        return res
    }
}