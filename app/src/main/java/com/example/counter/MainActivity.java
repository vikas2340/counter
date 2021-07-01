package com.example.counter;

        import  androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.os.Handler;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button start,stop;
    TextView textView1;
    int i=1;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1=findViewById(R.id.textView1);
        start=findViewById(R.id.start);
        stop=findViewById(R.id.stop);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.postDelayed(Timerthread,0);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.removeCallbacks(Timerthread);
            }
        });
    }

    private final Runnable Timerthread=new Runnable() {
        @Override
        public void run() {
            textView1.setText(""+i);
            handler.postDelayed(this,500);
            i++;
        }
    };

}