package com.coderz.f1.myapplication;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Random;

public class ShadowDrawable extends Drawable {
    private int _opacity = 0;
    @ColorInt
    private int _shadowColor = 0x00000000;

    private Paint p;

    public ShadowDrawable(){
        p = new Paint();
        p.setColor(getRandomColor());
        p.setStyle(Paint.Style.FILL);
    }

    private int getRandomColor(){
        Random rnd = new Random();
        int r = rnd.nextInt(255);
        int g = rnd.nextInt(255);
        int b = rnd.nextInt(255);
        int c = Color.argb(255,r,g,b);
        return c;
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        p.setColor(getRandomColor());
        canvas.drawRect(this.getBounds(),p);
    }

    @Override
    public void setAlpha(int i) {
        _opacity = i;
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return _opacity;
    }

    @ColorInt
    public int getShadowColor() {
        return _shadowColor;
    }

    public void setShadowColor(@ColorInt int _shadowColor) {
        this._shadowColor = _shadowColor;
    }
}
