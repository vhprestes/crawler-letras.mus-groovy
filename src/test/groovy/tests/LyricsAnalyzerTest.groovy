package tests

import org.acczg.factory.AnalysisMethod
import org.acczg.factory.LyricFilterFactory
import org.acczg.utils.LyricsAnalyzer
import spock.lang.Specification

class LyricsAnalyzerTest extends Specification {

    def "test main"() {
        expect:
        1 == 1
    }

    def "Find words with ditongos"() {
        given:
        List text = ["Então, a olhei e me senti vivo novamente.", "Sede", "Poeta"]
        AnalysisMethod lyricsAnalyzer = LyricFilterFactory.getAnalyzer("ditongos")

        expect:
        lyricsAnalyzer.analyze(text) == ["Então", "olhei"]
    }

    def "Find words with tritongos"() {
        given:
        List text = ["Ela é a mistura mais bela de cores", "Sua presença me apaziguou", "e desde que a vi", "meu mundo desaguou", "em uma mistura de sentimentos"]
        AnalysisMethod lyricsAnalyzer = LyricFilterFactory.getAnalyzer("tritongos")

        expect:
        lyricsAnalyzer.analyze(text) == ["apaziguou", "desaguou"]
    }

    def "Find words with hiatos"() {
        given:
        List text = ["Amei a ideia de te ver. Amei a ideia de te ter. Amei a ideia de te amar. E morri em todas as vezes que terminou"]
        AnalysisMethod lyricsAnalyzer = LyricFilterFactory.getAnalyzer("hiatos")

        expect:
        lyricsAnalyzer.analyze(text) == ["ideia", "ideia", "ideia"]
    }

    def "Find proparoxítonas"() {
        given:
        List text = ["teu olhar um oceano de ternura, céu estrelado onde a alma refugia. teu sorriso melodia mais pura, bálsamo suave que a alma tranquiliza. És o meu abrigo, meu porto seguro, o sonho mais íntimo."]
        AnalysisMethod lyricsAnalyzer = LyricFilterFactory.getAnalyzer("proparoxitonas")

        expect:
        lyricsAnalyzer.analyze(text) == ['bálsamo', 'íntimo']
    }

    def "Find four words sentences"() {
        given:
        List text = ["te pego na escola", "encho sua bola", "com todo meu amor", "Te levo pra festa",
                     "e testo teu sexo com", "ar de professor",
                     "faço promessas malucas",
                     "só pra te ver feliz",
                     "te faço um filho",
                     "te dou outra vida",
                     "pra te mostrar quem eu sou"]
        List res = ["te pego na escola", "com todo meu amor",
                    "Te levo pra festa", "e testo teu sexo com",
                    "só pra te ver feliz", "te faço um filho",
                    "te dou outra vida", "pra te mostrar quem eu sou"]


        AnalysisMethod lyricsAnalyzer = LyricFilterFactory.getAnalyzer("fourWordSentences")

        expect:
        lyricsAnalyzer.analyze(text) == res
    }

    def "Find special characteres words"() {
        given:
        List text = ["Não posso negar que tem sido difícil lidar com o fim do nosso relacionamento. Os carinhos deram lugar a solidão, e a saudade faz embaçar a vista"]
        AnalysisMethod lyricsAnalyzer = LyricFilterFactory.getAnalyzer("specialCharacters")

        expect:
        lyricsAnalyzer.analyze(text) == ["não", "solidão", "embaçar"]
    }


    def "Find repeated phrases"() {
        given:
        List<String> text = [
                "Tive pensando em me mudar",
                "Sem te deixar pra trás, yeah",
                "Resolvi pensar em nós, yeah",
                "Vou te levar daqui",
                "Vou te levar, yeah",
                "Te levar daqui, yeah",
                "Vou te levar, yeah",
                "Te levar daqui",
                "Aquele tempo ficou pra trás",
                "Eu nunca fui feliz ali",
                "Resolvi pensar em nós, yeah",
                "Vou te levar daqui",
                "Vou te levar, yeah",
                "Te levar daqui",
                "Vou te levar, yeah",
                "Te levar daqui",
                "Mantenho a história de luz de glória",
                "Mas só deixa eu te contar o que eu passei por lá",
                "Mas eu ainda fico impressionado com as coisas da cidade",
                "Aqueles mano se foram chegaram antes se foram",
                "Pra onde foram ninguém sabe ninguém faz",
                "Anos e anos da correria faz leva e traz",
                "Anos e anos da correria faz leva e traz, yeah"
        ]

        AnalysisMethod lyricsAnalyzer = LyricFilterFactory.getAnalyzer("repeatedPhrases")

        expect:
        lyricsAnalyzer.analyze(text) == ["resolvi pensar em nós, yeah": 2, "vou te levar daqui": 2, "vou te levar, yeah": 4, "te levar daqui": 3]
    }


    def "test method to remove plural"() {
        given:
        List text = ["eu tento esquecer", "os tempos que passamos", "os planos que fizemos", "esses sentimentos", "casa", "casas", "seres"]
        AnalysisMethod lyricsAnalyzer = LyricFilterFactory.getAnalyzer("removePlural")

        expect:
        lyricsAnalyzer.analyze(text) == ["eu tento esquecer", "que", "que", "casa"]

    }


}
