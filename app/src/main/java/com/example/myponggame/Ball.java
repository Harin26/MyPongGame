package com.example.myponggame;

import android.graphics.RectF;

public class Ball {

    private RectF mRect;
    private float mXVelocity;
    private float mYVelocity;
    private float mBallWidth;
    private float mBallHeight;

    public Ball(int screenX) {
        mBallWidth = screenX / 100;
        mBallHeight = screenX / 100;

        mRect = new RectF();
    }
    public RectF getRect() {
        return mRect;
    }


    //method
    public void update(long fps){

        mRect.left = mRect.left + (mXVelocity / fps);
        mRect.top = mRect.top + (mYVelocity / fps);

        mRect.right = mRect.left + mBallWidth;
        mRect.bottom = mRect.top + mBallHeight;
    }
    public void reverseYVelocity(){

        mYVelocity = -mYVelocity;

    }
    public void reverseXVelocity(){

        mXVelocity = -mXVelocity;

    }
    public void reset(int x, int y){

        mRect.left = x / 2;
        mRect.top = 0;
        mRect.right = x / 2 + mBallWidth;
        mRect.bottom = mBallHeight;

        mYVelocity = -(y / 3);
        mXVelocity = (y / 3);
    }
    public void increaseVelocity(){


        mXVelocity = mXVelocity * 1.1f;
        mYVelocity = mYVelocity * 1.1f;

    }
    public void batBounce(RectF batPosition){

        float batCenter = batPosition.left + (batPosition.width() / 2);

        float ballCenter = mRect.left + (mBallWidth / 2);

        float relativeIntersect = (batCenter - ballCenter);

        if(relativeIntersect < 0){

            mXVelocity = Math.abs(mXVelocity);
        }else{
            mXVelocity = -Math.abs(mXVelocity);
        }
        reverseYVelocity();
    }
}
