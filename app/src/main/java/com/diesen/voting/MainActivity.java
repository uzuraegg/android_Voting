package com.diesen.voting;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    /** リセットボタン*/
    private Button reset_button;

    /** 回答数*/
    private TextView answered_text;

    /** 結果発表ボタン*/
    private Button announce_button;

    /** 質問入力欄 */
    private EditText question_edit;

    /** NOボタン */
    private Button no_button;

    /** YESボタン */
    private Button yes_button;

    /** NO回答人数 */
    private int no_count = 0;

    /** YES回答人数 */
    private int yes_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answered_text = findViewById(R.id.ans_num);
        answered_text.setText(String.format(getString(R.string.ans_num), yes_count+no_count));

        // リセットボタンに、押された際のイベントを設定
        reset_button = findViewById(R.id.resetButton);
        reset_button.setOnClickListener(this);

        // 答えの決定ボタンに、押された際のイベントを設定
        announce_button = findViewById(R.id.announceButton);
        announce_button.setOnClickListener(this);

        // NOボタンに、押された際のイベントを設定
        no_button = findViewById(R.id.noButton);
        no_button.setOnClickListener(this);

        // YESボタンに、押された際のイベントを設定
        yes_button = findViewById(R.id.yesButton);
        yes_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        // イベントが発生したViewのIDで処理を分岐
        switch (v.getId()) {

            // リセットボタンならば
            case R.id.resetButton:
                // 回答リセット
                yes_count = 0;
                no_count = 0;
                answered_text.setText(String.format(getString(R.string.ans_num), yes_count+no_count));
                break;

            // 結果発表ボタンならば
            case R.id.announceButton:

                //announce();
                break;

            // Noボタンならば
            case R.id.noButton:

                no_count++;
                answered_text.setText(String.format(getString(R.string.ans_num), yes_count+no_count));
                break;

            // Yesボタンならば
            case R.id.yesButton:

                yes_count++;
                answered_text.setText(String.format(getString(R.string.ans_num), yes_count+no_count));
                break;
        }
    }
}
