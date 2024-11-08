package org.acczg.factory

class WordsWithTritongosAnalyzer implements AnalysisMethod {
    def analyze(List<String> lyrics) {
        String tritongoPattern = /\b\w*(uai|uei|uou|ieis|ueu)\w*\b/
        List res = lyrics.collect { it.findAll(tritongoPattern) }.flatten()
        for (String word : res) {
//            o fonema a antes de gu indica referencia ao tritongo água, portanto é triptongo e nao ditongo + hiato. caso do falecido trema. F.
            if (word.contains("uou") && (!word.contains("gu") || word.contains("aqu"))) {
                res.remove(word)
            }
            return res
        }
        return res
    }
}