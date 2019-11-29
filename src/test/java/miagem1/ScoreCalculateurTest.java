package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ScoreCalculateurTest {

    private ScoreCalculateur scoreCalculateur;
    private QuestionAChoixMultiple questionAChoixMultiple;

    @Before
    public void setUp() throws Exception {
        this.scoreCalculateur = new ScoreCalculateur();
        this.questionAChoixMultiple = new QuestionAChoixMultiple("q1",new ArrayList<Integer>(Arrays.asList(2,3,5)));
    }

    @Test
    public void calculeScore() {
        // when : un étudiant fourni les indices correspondant aux mauvaises réponses
        List<Integer> indicesEtudiant = new ArrayList<Integer>(Arrays.asList(1,4));
        // and : on demande le calcul du score
        Float score = this.scoreCalculateur.calculeScore(indicesEtudiant, this.questionAChoixMultiple);
        // then : Le score obtenu est 0
        assertEquals(new Float(0f), score);

        // when : un étudiant fourni les indices correspondant à deux bonnes réponses sur trois
        indicesEtudiant = new ArrayList<Integer>(Arrays.asList(2,3));
        // and : on demande le calcul du score
        score = this.scoreCalculateur.calculeScore(indicesEtudiant, this.questionAChoixMultiple);
        // then : Le score obtenu est 2*100/3 à 0,01 près
        assertEquals(new Float(2*100/3f), score, 0.01);

        // when : un étudiant fourni les indices correspondant à deux bonnes réponses sur trois
        indicesEtudiant = new ArrayList<Integer>(Arrays.asList(2,3,5));
        // and : on demande le calcul du score
        score = this.scoreCalculateur.calculeScore(indicesEtudiant, this.questionAChoixMultiple);
        // then : Le score obtenu est 100 à 0,01 près
        assertEquals(new Float(100f), score, 0.01);
    }
}