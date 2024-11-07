package org.acczg.factory

class RepeatedPhrasesAnalyzer implements AnalysisMethod {
    def analyze(List<String> lyrics) {
        lyrics.removeIf { it.length() < 5 }
        Map<String, Integer> frequency = lyrics.countBy { it.toLowerCase() }
        return frequency.findAll { it.value > 1 }
    }
}