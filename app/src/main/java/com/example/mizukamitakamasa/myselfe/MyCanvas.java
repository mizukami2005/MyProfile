package com.example.mizukamitakamasa.myselfe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

/**
 * Created by mizukamitakamasa on 2015/03/28.
 */
public class MyCanvas extends View {

    private int x = 110;
    private int y = 100;
    private boolean clearFlag = false;
    private int touchCount = 0;
    private  int ran;

    public MyCanvas(Context context) {
        super(context);
    }

    private void move(){
        y++;
        if (y >= 500) {
            y = -4;
        }
    }

    @Override
    public void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        //paint.setColor(Color.rgb(255, 255, 0));
        paint.setTextSize(50);
        Random rnd = new Random();
        ran = rnd.nextInt(5);
        for (int i = 0; i < touchCount; i++) {
            if (touchCount % 2 == 0) {
                canvas.drawText("Mizukami Takamasa", x + i * ran, y + i * 100, paint);
            }else {
                canvas.drawText("Takamasa Mizukami", x + i * ran, y + i * 100, paint);
            }
        }

        paint.setAntiAlias(true);
        move();
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("x:", + event.getX() + ",y:" + event.getY());

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                clearFlag = true;
                touchCount++;
                break;
        }

        return true;
    }
}
