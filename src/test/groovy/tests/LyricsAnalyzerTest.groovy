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

    def "Find repeated phrases"() {
        given:

        String text = "Tive pensando em me mudar\n" +
                "Sem te deixar pra trás, yeah\n" +
                "Resolvi pensar em nós, yeah\n" +
                "Vou te levar daqui\n" +
                "Vou te levar, yeah\n" +
                "Te levar daqui, yeah\n" +
                "Vou te levar, yeah\n" +
                "Te levar daqui\n" +
                "Aquele tempo ficou pra trás\n" +
                "Eu nunca fui feliz ali\n" +
                "Resolvi pensar em nós, yeah\n" +
                "Vou te levar daqui\n" +
                "Vou te levar, yeah\n" +
                "Te levar daqui\n" +
                "Vou te levar, yeah\n" +
                "Te levar daqui\n" +
                "Mantenho a história de luz de glória\n" +
                "Mas só deixa eu te contar o que eu passei por lá\n" +
                "Mas eu ainda fico impressionado com as coisas da cidade\n" +
                "Aqueles mano se foram chegaram antes se foram\n" +
                "Pra onde foram ninguém sabe ninguém faz\n" +
                "Anos e anos da correria faz leva e traz\n" +
                "Anos e anos da correria faz leva e traz, yeah"


        def lyricsAnalyzer = new LyricsAnalyzer()

        expect:
        lyricsAnalyzer.findRepeatedPhrases(text.toLowerCase().trim()) == ["resolvi pensar em nós": 2, "vou te levar daqui": 2, "vou te levar": 4, "te levar daqui": 4, "anos e anos da correria faz leva e traz": 2]
    }




}
