package tests

import org.acczg.utils.LyricsAnalyzer
import spock.lang.Specification

class LyricsAnalyzerTest extends Specification {

    def "test main"() {
        expect:
        1 == 1
    }

    def "Find words with ditongos"() {
        given:
        def text = "Então, a olhei e me senti vivo novamente."
        def lyricsAnalyzer = new LyricsAnalyzer()

        expect:
        lyricsAnalyzer.findWordsWithDitongos(text) == ["Então", "olhei"]
    }

    def "Find words with tritongos"() {
        given:
        def text = "Ela é a mistura mais bela de cores. Sua presença me apaziguou, e desde que a vi, meu mundo desaguou em uma mistura de sentimentos."
        def lyricsAnalyzer = new LyricsAnalyzer()

        expect:
        lyricsAnalyzer.findWordsWithTritongos(text) == ["apaziguou", "desaguou"]
    }

    def "Find words with hiatos"() {
        given:
        String text = "Amei a ideia de te ver. Amei a ideia de te ter. Amei a ideia de te amar. E morri em todas as vezes que terminou."
        def lyricsAnalyzer = new LyricsAnalyzer()

        expect:
        lyricsAnalyzer.findWordsWithHiatos(text) == ["ideia", "ideia", "ideia", "terminou"]
    }

    def "Find proparoxítonas"() {
        given:
        String text = "teu olhar um oceano de ternura, céu estrelado onde a alma refugia. teu sorriso melodia mais pura, bálsamo suave que a alma tranquiliza. És o meu abrigo, meu porto seguro, o sonho mais íntimo."
        def lyricsAnalyzer = new LyricsAnalyzer()

        expect:
        lyricsAnalyzer.findProparoxytonas(text) == ['bálsamo', 'íntimo']
        }

    def "Find four words sentences"(){
        given:
        String text = "te pego na escola, e encho sua bola, com todo meu amor. Te levo pra festa \n" +
                "e testo teu sexo com ar de professor \n" +
                "faço promessas malucas \n" +
                "te faço um filho \n" +
                "te dou outra vida \n" +
                "pra te mostrar quem eu sou"

        def lyricsAnalyzer = new LyricsAnalyzer()

        expect:
        lyricsAnalyzer.findFourWordSentences(text.toLowerCase().trim()) == ["te pego na escola", "e encho sua bola", "com todo meu amor", "te levo pra festa", "te faço um filho", "te dou outra vida"]
    }

    def "Find special characteres words"() {
        given:
        String text = "Não posso negar que tem sido difícil lidar com o fim do nosso relacionamento. Os carinhos deram lugar a solidão, e a saudade faz embaçar a vista"
        def lyricsAnalyzer = new LyricsAnalyzer()

        expect:
        lyricsAnalyzer.findSpecialCharactersWords(text.toLowerCase().trim()) == ["não", "solidão", "embaçar"]
    }

}
