package org.acczg.factory

class FourWordSentencesAnalyzer implements AnalysisMethod {
    def analyze(List<String> lyrics) {
        def res = []
        for (String sentence : lyrics) {
            if (sentence.split(/\s+/).size() >= 4) {
                sentence.trim().toLowerCase()
                res.add(sentence)
            }
        }
        return res
    }
}