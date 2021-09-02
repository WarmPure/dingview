package com.example.animations;

public class Point {

    float x, y;
    float x1,y1;
    float x2, y2;
    int operation;

    public Point() {
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point(float x, float y, int operation) {
        this.x = x;
        this.y = y;
        this.operation = operation;
    }

    public Point(float x, float y, float x1, float y1, int operation) {
        this.x = x;
        this.y = y;
        this.x1 = x1;
        this.y1 = y1;
        this.operation = operation;
    }

    public Point(float x, float y, float x1, float y1, float x2, float y2, int operation) {
        this.x = x;
        this.y = y;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.operation = operation;
    }

    public static Point moveTo(float x, float y, int operation) {
        return new Point(x, y, operation);
    }

    public static Point lineTo(float x, float y, int operation) {
        return new Point(x, y, operation);
    }

    public static Point quadTo(float x, float y, float x1, float y1, int operation) {
        return new Point(x, y, x1, y1, operation);
    }

    public static Point curveTo(float x, float y, float x1, float y1, float x2, float y2, int operation) {
        return new Point(x, y, x1, y1, x2, y2, operation);
    }




}