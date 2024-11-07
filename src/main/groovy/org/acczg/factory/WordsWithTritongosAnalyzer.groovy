package org.acczg.factory

class WordsWithTritongosAnalyzer implements AnalysisMethod {
    def analyze(List<String> lyrics) {
        String tritongoPattern = /\b\w*(uai|uei|uou|ieis|ueu)\w*\b/
        return lyrics.collect { it.findAll(tritongoPattern) }.flatten()
    }
}