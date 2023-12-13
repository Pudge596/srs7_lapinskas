package com.example.srs7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GestureDetectorCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    private GestureDetector gestureDetector;
    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt = findViewById(R.id.textView8);
        txt.setOnClickListener(this);
        gestureDetector = new GestureDetector(this, new MainActivity2.SwipeGestureListener());

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this,MainActivity4.class);
        startActivity(intent);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event) || super.onTouchEvent(event);
    }
    private class SwipeGestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float diffX = e1.getX() - e2.getX();
            float diffY = e1.getY() - e2.getY();

            if (Math.abs(diffX) >Math.abs(diffY)
                    &&Math.abs(diffX) > SWIPE_THRESHOLD
                    &&Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                // Свайп влево или вправо обнаружен
                if (diffX> 0) {
                    // Свайп вправо
                    startActivity(new Intent(MainActivity2.this, MainActivity3.class));
                } else {
                    // Свайп влево
                    // Можете добавить другие действия, если нужно
                }
                return true;
            }

            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
}
