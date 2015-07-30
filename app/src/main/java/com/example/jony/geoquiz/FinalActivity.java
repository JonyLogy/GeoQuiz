package com.example.jony.geoquiz;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Jony on 30.07.2015.
 */

public class FinalActivity extends Activity {

    public static final String EXTRA_FINAL_SCORE =
            "com.example.jony.geoquiz.final_score";

    private int mFinalScore;

    TextView mFinalScoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        mFinalScore = getIntent().getIntExtra(EXTRA_FINAL_SCORE, 0);

        mFinalScoreTextView = (TextView) findViewById(R.id.final_score_text_view);
        mFinalScoreTextView.setText(String.valueOf(mFinalScore));

    }
}
