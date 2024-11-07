package org.acczg.factory

class LyricFilterFactory {
    static AnalysisMethod getAnalyzer(String type) {
        switch (type) {
            case "specialCharacters":
                return new SpecialCharactersWordsAnalyzer()
            case "repeatedPhrases":
                return new RepeatedPhrasesAnalyzer()
            case "ditongos":
                return new WordsWithDitongosAnalyzer()
            case "tritongos":
                return new WordsWithTritongosAnalyzer()
            case "hiatos":
                return new WordsWithHiatosAnalyzer()
            case "fourWordSentences":
                return new FourWordSentencesAnalyzer()
            case "proparoxitonas":
                return new ProparoxitonasAnalyzer()
            case "removePlural":
                return new RemovePluralWordsAnalyzer()
            default:
                throw new IllegalArgumentException("Tipo de análise desconhecido: " + type)
        }
    }
}
