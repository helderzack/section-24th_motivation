package com.helder.section24_motivation.data

class PhraseRepository private constructor() {
    companion object {
        private var instance: PhraseRepository? = null

        fun getInstance(): PhraseRepository {
            if(instance == null) {
                instance = PhraseRepository()
            }

            return instance!!
        }
    }
    private val phrases = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", PhraseCategory.Happy),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", PhraseCategory.Happy),
        Phrase("Quando está mais escuro, vemos mais estrelas!", PhraseCategory.Happy),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", PhraseCategory.Happy),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", PhraseCategory.Happy),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", PhraseCategory.Happy),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", PhraseCategory.Sunny),
        Phrase("Você perde todas as chances que você não aproveita.", PhraseCategory.Sunny),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", PhraseCategory.Sunny),
        Phrase("Enquanto não estivermos comprometidos, haverá hesitação!", PhraseCategory.Sunny),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", PhraseCategory.Sunny),
        Phrase("Se você acredita, faz toda a diferença.", PhraseCategory.Sunny),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", PhraseCategory.Sunny)
    )

    private val phrasesInEnglish = listOf(
        Phrase("Not knowing it was impossible, he went there and did it.", PhraseCategory.Happy),
        Phrase("You are not defeated when you lose, you are defeated when you give up!", PhraseCategory.Happy),
        Phrase("When it's darker, we see more stars!", PhraseCategory.Happy),
        Phrase("Insanity is doing the same thing over and over again and expect a different result.", PhraseCategory.Happy),
        Phrase("Don't stop when you're tired, stop when you're finished.", PhraseCategory.Happy),
        Phrase("What can you do right now that has the biggest impact on your success?", PhraseCategory.Happy),
        Phrase("The best way to predict the future is to invent it.", PhraseCategory.Sunny),
        Phrase("You lose every chance you don't take. .", PhraseCategory.Sunny),
        Phrase("Failure is the condiment that flavors success.", PhraseCategory.Sunny),
        Phrase("As long as we are not committed, there will be hesitation!", PhraseCategory.Sunny),
        Phrase("If you don't know where you want to go, any path will do", PhraseCategory.Sunny),
        Phrase("If you believe, it makes all the difference.", PhraseCategory.Sunny),
        Phrase("Risks must be taken, because the greatest danger is not risking anything!", PhraseCategory.Sunny)
    )

    fun getData(deviceLanguage: String): List<Phrase> {
        if(deviceLanguage == "pt") {
            return phrases
        }

        return phrasesInEnglish
    }
}