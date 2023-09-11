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

    fun getData(): List<Phrase> = phrases
}