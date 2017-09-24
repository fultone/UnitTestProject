import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by fultone on 9/21/17.
 */
public class YatzeeScorerTester {
    protected YatzeeScorer yatzee_normalplay;
    protected YatzeeScorer yatzee_insufficientdice;
    protected YatzeeScorer lgstraight_normalplay;
    protected YatzeeScorer lgstraight_insufficientdice;
    protected YatzeeScorer fullhouse_normalplay;
    protected YatzeeScorer fullhouse_insufficientdice;
    protected YatzeeScorer threekind_normalplay;
    protected YatzeeScorer threekind_insufficientdice;
    @Before
    public void setUp() throws Exception{
        yatzee_normalplay = new YatzeeScorer(1,1,1,1,1);
        yatzee_insufficientdice = new YatzeeScorer(1,2,1,1,1);
        lgstraight_normalplay = new YatzeeScorer(4,3,6,2,5);
        lgstraight_insufficientdice = new YatzeeScorer(1,2,3,5,6);
        fullhouse_normalplay = new YatzeeScorer(3,2,3,3,2);
        fullhouse_insufficientdice = new YatzeeScorer(1,2,3,3,3);
        threekind_normalplay = new YatzeeScorer(1,1,2,4,1);
        threekind_insufficientdice = new YatzeeScorer(1,2,2,1,4);
    }

    @Test
    public void test_GetScore(){
        assertEquals(0,yatzee_insufficientdice.getScore());
    }

    // YAHTZEE TESTS!
    @Test
    public void testYatzee_NormalPlay(){
        assertTrue(yatzee_normalplay.hasScoredYatzee() == false); //If the user has not yet scored a Yahtzee...
        assertTrue(yatzee_normalplay.isYatzee() == true); //...and they rolled a Yahtzee.
    }

    @Test
    public void testYatzee_InsufficientDice(){
        assertTrue(yatzee_normalplay.hasScoredYatzee() == false); //If the user has not yet scored a Yahtzee...
        assertTrue(yatzee_insufficientdice.isYatzee() == false); //...and they did not roll a Yahtzee.
    }

    @Test
    public void testYatzee_AlreadyScored(){
        assertTrue(yatzee_normalplay.isYatzee() == true); // Once the user scores a Yahtzee...
        assertTrue(yatzee_normalplay.hasScoredYatzee() == true); // ...the program recognizes that it has been rolled.

    }

    @Test
    public void testYatzee_CurrentScore(){
        yatzee_normalplay.scoreYatzee();
        assertEquals(50, yatzee_normalplay.getScore()); // Adds 50 to the user's score
        // I chose to separate the "score" methods from the "isYahtzee, isFullHouse, etc" methods -- the "score" methods could easily be called within the "is__" methods if the actual playing of the game required
    }
    //All four tests commented above are repeated for "Large Straight," "Full House," and "Three of a Kind."

    //LARGE STRAIGHT TESTS!
    @Test
    public void testLgStraight_NormalPlay(){
        assertTrue(lgstraight_normalplay.hasScoredLgStrt() == false);
        assertTrue(lgstraight_normalplay.isLgStraight() == true);

    }

    @Test
    public void testLgStraight_InsufficientDice(){
        assertTrue(lgstraight_insufficientdice.hasScoredLgStrt() == false);
        assertTrue(lgstraight_insufficientdice.isLgStraight() == false);
    }

    @Test
    public void testLgStraight_AlreadyScored(){
        assertTrue(lgstraight_normalplay.isLgStraight() == true);
        assertTrue(lgstraight_normalplay.hasScoredLgStrt() == true);
    }

    @Test
    public void testLgStraight_CurrentScore(){
        lgstraight_normalplay.scoreLgStrt();
        assertEquals(40, lgstraight_normalplay.getScore());
    }

    //FULL HOUSE TESTS!
    @Test
    public void testFullHouse_NormalPlay(){
        assertTrue(fullhouse_normalplay.hasScoredFullHouse() == false);
        assertTrue(fullhouse_normalplay.isFullHouse() == true);
    }

    @Test
    public void testFullHouse_InsufficientDice(){
        assertTrue(fullhouse_normalplay.hasScoredFullHouse() == false);
        assertTrue(fullhouse_insufficientdice.isFullHouse() == false);
    }

    @Test
    public void testFullHouse_AlreadyScored(){
        assertTrue(fullhouse_normalplay.isFullHouse() == true);
        assertTrue(fullhouse_normalplay.hasScoredFullHouse() == true);
    }

    @Test
    public void testFullHouse_CurrentScore(){
        fullhouse_normalplay.scoreFullHouse();
        assertEquals(25, fullhouse_normalplay.getScore());
    }

    //THREE OF A KIND TESTS!
    @Test
    public void testThreeKind_NormalPlay(){
        assertTrue(threekind_normalplay.hasScoredThreeKind() == false);
        assertTrue(threekind_normalplay.isThreeKind() == true);
    }

    @Test
    public void testThreeKind_InsufficientDice(){
        assertTrue(threekind_insufficientdice.hasScoredThreeKind() == false);
        assertTrue(threekind_insufficientdice.isThreeKind() == false);
    }

    @Test
    public void testThreeKind_AlreadyScored(){
        assertTrue(threekind_normalplay.isThreeKind() == true);
        assertTrue(threekind_normalplay.hasScoredThreeKind() == true);
    }

    @Test
    public void testThreeKind_CurrentScore(){
        threekind_normalplay.scoreThreeKind();
        assertEquals(threekind_normalplay.sumDice(), threekind_normalplay.getScore());
    }

}
