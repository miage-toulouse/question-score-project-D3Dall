package miagem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QuestionAChoixExclusifTest {

	private QuestionAChoixExclusif une_Question;
	
	@Before
	public void setUp() throws Exception{
		//Given : un objet de type QuestionAChoixExclusif
		this.une_Question = new QuestionAChoixExclusif("Un énoncé", 2);
	}
	
	@Test
	public void testGetEnonce() {
		// when : on demande l'énoncé à la question
		String res_Enonce = this.une_Question.getEnonce();
		// then : l'énoncé est non null
		assertNotNull(res_Enonce);
		// and : l'énoncé est bien celui fourni à la construction
		assertEquals(res_Enonce, "Un énoncé");
	}

	@Test
	public void testGetScoreForIndice() {
		// when : un étudiant fourni l'indice correspondant à la bonne réponse
		int indice_Etudiant = 2;
		// and : on demande le calcul du score
		Float resScore = this.une_Question.getScoreForIndice(indice_Etudiant);
		// then : Le score obtenu est 100
		assertEquals(new Float(100f), resScore);
		// when : un étudiant fourni l'indice correspondant à une mauvaise réponse
		indice_Etudiant = 3;
		resScore = this.une_Question.getScoreForIndice(indice_Etudiant);
		assertEquals(new Float(0f), resScore);
	}

}
