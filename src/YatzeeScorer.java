/**
 * Created by fultone on 9/21/17.
 */
public class YatzeeScorer {

    int[] diceValues = {-1, -1, -1, -1, -1};
    boolean[] scorecard = {false, false, false, false}; //Tracks if certain rolls have been scored yet: {Yahtzee, Large Straight, Full House, Three of a Kind}
    int score = 0;

    public YatzeeScorer(int d1, int d2, int d3, int d4, int d5){
        diceValues[0] = d1;
        diceValues[1] = d2;
        diceValues[2] = d3;
        diceValues[3] = d4;
        diceValues[4] = d5;
    }

    // HELPER METHODS
    public int countOccrs(int v){ // Counts how many times a dice value v appears in diceValues array
        int count = 0;
        for(int i:diceValues){
            if(i == v){
                count++;
            }
        }
        return count;
    }

    public int getScore(){
        return score;
    }

    public int sumDice(){
        int sum = 0;
        for(int i:diceValues){
            sum += i;
        }
        return sum;
    }

    // YAHTZEE-RELATED METHODS
    public boolean isYatzee(){
        if(countOccrs(diceValues[0])==5){
                scorecard[0] = true; //Marks that the user has scored a Yahtzee
                return true;
        }
        return false;
    }

    public boolean hasScoredYatzee(){
        return scorecard[0];
    }

    public void scoreYatzee(){
        score += 50;
    } //Gives the user 50 points for scoring a Yahtzee

    // LARGE STRAIGHT-RELATED METHODS
    public boolean isLgStraight(){
        boolean[] lgStrt = {false, false, false, false, false, false}; //Array to find which dice values were rolled
        for(int i:diceValues){
            if(i>=1 && i<=6){
                lgStrt[i-1] = true;
            }
        }
        if(lgStrt[0]==true && lgStrt[1]==true && lgStrt[2]==true && lgStrt[3]==true && lgStrt[4]==true //If rolled: 1,2,3,4,5 => large straight
                || lgStrt[1]==true && lgStrt[2]==true && lgStrt[3]==true && lgStrt[4]==true && lgStrt[5]==true){ //Or if rolled: 2,3,4,5,6 => large straight
            scorecard[1] = true; //Marks that the user has scored a Large Straight
            return true;
        }
        return false;
    }

    public boolean hasScoredLgStrt(){
        return scorecard[1];
    }

    public void scoreLgStrt(){
        score += 40;
    }

    // FULL HOUSE-RELATED METHODS
    public boolean isFullHouse(){
        int[] fullHouse = {diceValues[0], diceValues[1], diceValues[2], diceValues[3]};
        for(int i:fullHouse){
            if(countOccrs(i) != 2 && countOccrs(i) !=3){
                return false;
            }
        }
        scorecard[2] = true;
        return true;
    }

    public boolean hasScoredFullHouse(){
        return scorecard[2];
    }

    public void scoreFullHouse(){
        score += 25;
    }

    // THREE OF A KIND-RELATED METHODS
    public boolean isThreeKind(){
        int count1 = countOccrs(diceValues[0]);
        int count2 = countOccrs(diceValues[1]);
        int count3 = countOccrs(diceValues[2]);
        if(count1>=3 || count2>=3 || count3>=3){
            scorecard[3] = true;
            return true;
        }
        return false;
    }

    public boolean hasScoredThreeKind(){
        return scorecard[3];
    }

    public void scoreThreeKind(){
        score += sumDice();
    }
}
