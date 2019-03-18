package com.example.clock;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

public class AnalogClock extends View {

    private Paint paint;

    private Paint pHours;
    private Paint pMinutes;
    private Paint pSeconds;

    private int hour = 0;
    private int minute = 0;
    private int seconds = 0;

    public AnalogClock(Context context, AttributeSet attrs){
        super(context,attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.GRAY);

        pHours = new Paint(Paint.ANTI_ALIAS_FLAG);
        pHours.setColor(Color.BLACK);
        pHours.setStrokeWidth(10);

        pMinutes = new Paint(Paint.ANTI_ALIAS_FLAG);
        pMinutes.setColor(Color.BLACK);
        pMinutes.setStrokeWidth(5);

        pSeconds = new Paint(Paint.ANTI_ALIAS_FLAG);
        pSeconds.setColor(Color.RED);
        pSeconds.setStrokeWidth(4);
    }


    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        canvas.drawCircle(100,100,100,paint);
        canvas.drawLine(100, 100, getHourPos(hour, minute).x, getHourPos(hour, minute).y, pHours);
        canvas.drawLine(100, 100, getMinutePos(minute).x, getMinutePos(minute).y, pMinutes);
        canvas.drawLine(100, 100, getMinutePos(seconds).x, getMinutePos(seconds).y, pSeconds);
    }

    public Point getHourPos(int hour, int minute)
    {
        int xHour = (int) (Math.cos((hour * 30 + minute / 2) * 3.14f / 180 - 3.14f / 2) * 75 + 100);
        int yHour = (int) (Math.sin((hour * 30 + minute / 2) * 3.14f / 180 - 3.14f / 2) * 75 + 100);
        return new Point(xHour, yHour);
    }

    public Point getMinutePos(int minute)
    {
        int xMinute = (int) (Math.cos(minute * 3.14f / 30 - 3.14f / 2) * 90 + 100);
        int yMinute = (int) (Math.sin(minute * 3.14f / 30 - 3.14f / 2) * 90 + 100);
        return new Point(xMinute, yMinute);
    }


    public void refresh(String h, String m, String s)
    {
        hour = Integer.parseInt(h);
        minute = Integer.parseInt(m);
        seconds = Integer.parseInt(s);
    }
}
