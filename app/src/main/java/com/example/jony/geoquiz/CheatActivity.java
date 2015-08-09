package com.example.jony.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends Activity {

    public static final String EXTRA_ANSWER_IS_TRUE =
            "com.example.jony.geoquiz.answer_is_true";

    public static final String EXTRA_ANSWER_SHOWN =
            "com.example.jony.geoquiz.answer_shown";

    public static final String ANSWER_IS_SHOWN =
            "com.example.jony.geoquiz.answer_shown";

    private static boolean isShown = false;

    private boolean mAnswerIsTrue;
    private TextView mAnswerTextView;
    private Button mShowAnswer;

    private void setAnswerShownResult(boolean isAnswerShown) {
        isShown = isAnswerShown;
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }

    private void setAnswerText (boolean answer) {
        if (answer)
            mAnswerTextView.setText(R.string.true_button);
        else
            mAnswerTextView.setText(R.string.false_button);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mAnswerTextView = (TextView) findViewById(R.id.answer_text_view);

        mShowAnswer = (Button) findViewById(R.id.show_answer_button);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAnswerText(mAnswerIsTrue);
                setAnswerShownResult(true);
            }
        });

        if (savedInstanceState != null) {
            isShown = savedInstanceState.getBoolean(ANSWER_IS_SHOWN, false);
        }

        if(isShown) {
            setAnswerShownResult(isShown);
            setAnswerText(mAnswerIsTrue);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean(ANSWER_IS_SHOWN, isShown);
    }
}
