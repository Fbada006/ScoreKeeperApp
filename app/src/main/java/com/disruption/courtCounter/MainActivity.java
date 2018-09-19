package com.disruption.courtCounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*The variables for tracking the score of the two players*/
    private int scorePlayer1;
    private int scorePlayer2;

    /*Track the appeals*/
    private int appealPlayer1;
    private int appealPlayer2;

    /*Track the lets*/
    private int letPlayer1;
    private int letPlayer2;

    /*Track the faults*/
    private int faultPlayer1;
    private int faultPlayer2;

    /*Track the sets*/
    private int setsPlayer1;
    private int setsPlayer2;

    /*Text views for other fields*/
    private TextView tvAppeal1;
    private TextView tvAppeal2;
    private TextView tvLet1;
    private TextView tvLet2;
    private TextView tvFault1;
    private TextView tvFault2;
    private TextView tvSets1;
    private TextView tvSets2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find all the views
        tvAppeal1 = findViewById(R.id.appeals_1);
        tvAppeal2 = findViewById(R.id.appeals_2);
        tvLet1 = findViewById(R.id.lets_1);
        tvLet2 = findViewById(R.id.lets_2);
        tvFault1 = findViewById(R.id.faults_1);
        tvFault2 = findViewById(R.id.faults_2);
        tvSets1 = findViewById(R.id.sets_won_1);
        tvSets2 = findViewById(R.id.sets_won_2);
    }

    /**
     * This method displays the score for the first team/Player
     *
     * @param score is the score to be displayed
     */
    public void displayScoreForTeamA(int score) {
        TextView scoreViewA = findViewById(R.id.scoreTextViewA);
        scoreViewA.setText(String.valueOf(score));

        //Check the displayed score to inform the user that it is the match point or if the set is over
        if (score == 20) {
            Toast.makeText(this, R.string.match_point, Toast.LENGTH_LONG).show();
        }
        if (score == 21) {
            Toast.makeText(this, R.string.please_switch_sides, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * This method displays the score for the second team/Player
     *
     * @param score is the score to be displayed
     */
    public void displayScoreForTeamB(int score) {
        TextView scoreViewB = findViewById(R.id.scoreTextViewB);
        scoreViewB.setText(String.valueOf(score));

        //Check the displayed score to inform the user that it is the match point or if the set is over
        if (score == 20) {
            Toast.makeText(this, R.string.match_point, Toast.LENGTH_LONG).show();
        }
        if (score == 21) {
            Toast.makeText(this, R.string.please_switch_sides, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * This method adds one point to the first player
     *
     * @param view is the view of the first player/team
     */
    public void pointPlayer1(View view) {
        //Do not increment the score beyond 21
        if (scorePlayer1 < 21) {
            scorePlayer1 = scorePlayer1 + 1;
            displayScoreForTeamA(scorePlayer1);
        } else {
            displayScoreForTeamA(scorePlayer1);
        }
    }

    /**
     * This method adds one point to the second player
     *
     * @param view is the view of the first player/team
     */
    public void pointPlayer2(View view) {
        //Do not increment the score beyond 21
        if (scorePlayer2 < 21) {
            scorePlayer2 = scorePlayer2 + 1;
            displayScoreForTeamB(scorePlayer2);
        } else {
            displayScoreForTeamB(scorePlayer2);
        }
    }

    /**
     * Reset all the fields to 0 except the sets field
     */
    public void resetFields() {
        //Set all the variables to 0 and display them
        faultPlayer1 = 0;
        faultPlayer2 = 0;
        setsPlayer1 = 0;
        setsPlayer2 = 0;
        appealPlayer1 = 0;
        appealPlayer2 = 0;
        tvFault1.setText(String.valueOf(faultPlayer1));
        tvFault2.setText(String.valueOf(faultPlayer2));
        tvLet1.setText(String.valueOf(letPlayer1));
        tvLet2.setText(String.valueOf(letPlayer2));
        tvAppeal1.setText(String.valueOf(appealPlayer1));
        tvAppeal2.setText(String.valueOf(appealPlayer2));

    }

    /**
     * This method resets the scores back to 0
     *
     * @param view is the view that shows the scores.
     */
    public void reset(View view) {
        //Get both scores, set them to zero and display them
        scorePlayer1 = 0;
        scorePlayer2 = 0;
        displayScoreForTeamA(scorePlayer1);
        displayScoreForTeamB(scorePlayer2);
        resetFields();
    }

    /*Increment player 1 appeals*/
    public void incrementAppeal1(View view) {
        tvAppeal1.setText(String.valueOf(appealPlayer1 += 1));
    }

    /*Increment player 2 appeals*/
    public void incrementAppeal2(View view) {
        tvAppeal2.setText(String.valueOf(appealPlayer2 += 1));
    }

    /*Increment player 2 lets*/
    public void incrementLet2(View view) {
        tvLet2.setText(String.valueOf(letPlayer2 += 1));
    }

    /*Increment player 1 lets*/
    public void incrementLet1(View view) {
        tvLet1.setText(String.valueOf(letPlayer1 += 1));
    }

    /*Increment player 2 faults and increase score of player 1*/
    public void incrementFault2(View view) {
        tvFault2.setText(String.valueOf(faultPlayer2 += 1));
        pointPlayer1(view);
    }

    /*Increment player 1 faults and increase score of player 2*/
    public void incrementFault1(View view) {
        tvFault1.setText(String.valueOf(faultPlayer1 += 1));
        pointPlayer2(view);
    }

    /*Increment number of sets won for player 2*/
    public void incrementSet2(View view) {
        tvSets2.setText(String.valueOf(setsPlayer2 += 1));
    }

    /*Increment number of sets for player1*/
    public void incrementSet1(View view) {
        tvSets1.setText(String.valueOf(setsPlayer1 += 1));
    }
}
