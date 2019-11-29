package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class QuestionAChoixMultipleTest {

    private QuestionAChoixMultiple une_Question;


    @Before
    public void setUp() throws Exception {
        //Given : un objet de type QuestionAChoixMultiple
        List<Integer> indicesBonnesReponses = new ArrayList<>();
        indicesBonnesReponses.add(1);
        indicesBonnesReponses.add(2);

        List<Integer> indicesMauvaisesReponses = new ArrayList<>();
        indicesBonnesReponses.add(3);
        indicesBonnesReponses.add(4);
        this.une_Question = new QuestionAChoixMultiple("Un énoncé", indicesBonnesReponses, indicesMauvaisesReponses);
    }

    @Test
    public void getEnonce() {
        // when : on demande l'énoncé à la question
        String res_Enonce = this.une_Question.getEnonce();
        // then : l'énoncé est non null
        assertNotNull(res_Enonce);
        // and : l'énoncé est bien celui fourni à la construction
        assertEquals(res_Enonce, "Un énoncé");
    }

    @Test
    public void getScoreForIndice() {
        // when : un étudiant fourni l'indice correspondant à la bonne réponse
        int indice_Etudiant = 1;
        // and : on demande le calcul du score
        Float resScore = this.une_Question.getScoreForIndice(indice_Etudiant);
        // then : Le score obtenu est 100
        assertEquals(new Float(50f), resScore, 0.01f);

        // when : un étudiant fourni l'indice correspondant à une mauvaise réponse
        indice_Etudiant = 3;
        resScore = this.une_Question.getScoreForIndice(indice_Etudiant);
        assertEquals(new Float(0f), resScore, 0.01f);
    }
}