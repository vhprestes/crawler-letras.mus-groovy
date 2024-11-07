package org.acczg.factory

class ProparoxitonasAnalyzer implements AnalysisMethod {


    @Override
    def analyze(List<String> lyrics) {
        String proparoxytonasPattern = /\b\w*[áéíóúâêîôûãõàèìòùäëïöü][bcdfghjklmnpqrstvwxyz]*[aeiou][bcdfghjklmnpqrstvwxyz]*[aeiou][bcdfghjklmnpqrstvwxyz]*\b/
        return lyrics.collect {
            it.findAll(proparoxytonasPattern).findAll { word ->
                String[] syllables = word.split(/(?<=[aeiouáéíóúâêîôûãõàèìòùäëïöü])/)
                syllables.size() > 2 && syllables[-3] ==~ /.*[áéíóúâêîôûãõàèìòùäëïöü].*/
            }
        }.flatten()
    }
}