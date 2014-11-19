package com.example.android;

import android.content.Context;
import android.graphics.*;
import android.view.View;

/**
 * Created by Apple on 17.11.2014.
 */
public class DrawView extends View {

    Paint p;
    RectF rectf;
    Path path;
    Path path1;

    public DrawView(Context context) {
        super(context);
        p = new Paint();
        p.setStrokeWidth(3);
        p.setStyle(Paint.Style.STROKE);

        rectf = new RectF(350,100,400,150);
        path = new Path();
        path1 = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawARGB(80, 102, 204, 255);
        Float L[]={100f,150f,300f,200f,100f,149f,59f,164f,314f,164f};
        Float K[]={100f,200f,243f,300f,350f,400f,500f,600f,700f,750f};
        Float O[]={0f,100f,200f,300f};
        // очистка path
        path.reset();

        //рисование осей
        path.moveTo(50, 50);
        path.lineTo(50, 400);
        path.lineTo(800,400);

        // рисование path
        p.setColor(Color.BLACK);
        canvas.drawPath(path, p);
        p.setTextSize(20);

        path.reset();
        path.moveTo(50, 400);
        path.lineTo(50+K[0],400-L[0]);
        canvas.drawText(String.format("%.0f", L[0]), 50+K[0], 430, p);

        p.setTextAlign(Paint.Align.CENTER);
        for (int i=1;i<10;i++)
        {
            path.moveTo(50+K[i-1], 400-L[i-1]);
            path.lineTo(50+K[i],400-L[i]);
            canvas.drawText(String.format("%.0f", L[i]), 50+K[i], 430, p);

            p.setTextAlign(Paint.Align.CENTER);
        }
        for(int i=0;i<4;i++)
        {
            canvas.drawText(String.format("%.0f", O[i]), 17, 400-O[i], p);
        }
        p.setColor(Color.RED);
        canvas.drawPath(path, p);

        // настраиваем размер текста = 30
        p.setTextSize(30);
        // рисуем текст в точке (150,500)
        canvas.drawText("y", 20, 50, p);
        canvas.drawText("x", 830, 430, p);
        // настраиваем выравнивание текста на центр
        p.setTextAlign(Paint.Align.LEFT);



    }

}
