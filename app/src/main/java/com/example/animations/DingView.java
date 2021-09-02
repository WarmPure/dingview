package com.example.animations;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class DingView extends View {


    // 通用  矩形
    private RectF rectF;

    // 嘴巴 矩形
    private RectF rectFMouth;

    private boolean mouthTalkFlag = false;


    // 画笔
    // 红色 画笔
    private Paint paintRed;
    // 黑色 画笔
    private Paint paintBlack;
    // 丁  字
    private Paint painDing;
    // 嘴巴
    private Paint painMouth;
    // 脑袋的轮廓
    private Paint painHead;

    // 百分比

    // 丁
    private ValueAnimator valueAnimatorDing;
    private int progressDing = 0;

    // 眼睛
    private ValueAnimator valueAnimatorEyes;
    private int progressEyes = 0;
    private ValueAnimator valueAnimatorEyein;
    private int progressEyein = 0;

    // 抬头纹
    private ValueAnimator valueAnimatorLine1;
    private int progressLine1 = 0;
    private ValueAnimator valueAnimatorLine2;
    private int progressLine2 = 0;
    private ValueAnimator valueAnimatorLine3;
    private int progressLine3 = 0;

    // 嘴巴
    private ValueAnimator valueAnimatorMouth;
    private int progressMouth = 0;

    // 头
    private ValueAnimator valueAnimatorHead;
    private int progressHead = 0;

    // 腿
    private ValueAnimator valueAnimatorLegs;
    private int progressLegs = 0;

    // 脚
    private ValueAnimator valueAnimatorFoots;
    private int progressFoots = 0;

    //path
    private Path pathLeftEar = new Path();
    private Path pathRightEar = new Path();
    private Path pathBody = new Path();
    private Path pathLeftArm = new Path();
    private Path pathRightArm = new Path();

    // 贝塞尔曲线的绘制
    private ValueAnimator valueAnimatorLeftEar;
    private ValueAnimator valueAnimatorRightEar;
    private ValueAnimator valueAnimatorBody;
    private ValueAnimator valueAnimatorLeftArm;
    private ValueAnimator valueAnimatorRightArm;


    private Point pointLeftEar = new Point();
    private Point pointRightEar = new Point();
    private Point pointBody = new Point();
    private Point pointLeftArm = new Point();
    private Point pointRightArm = new Point();

    boolean isInitPath = false;
    private AnimatorSet animatorSet;

    public DingView(Context context) {
        super(context);

        Log.i("-------", "1");
    }

    public DingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
        Log.i("-------", "2");
    }

    public DingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.i("-------", "3");
    }

    private void init() {

        rectF = new RectF();

        rectFMouth = new RectF();

        paintRed = new Paint();
        paintRed.setColor(Color.rgb(255, 155, 192));
        paintRed.setStyle(Paint.Style.STROKE);
        paintRed.setStrokeWidth(3f);
        paintRed.setAntiAlias(true);

        paintBlack = new Paint();
        paintBlack.setColor(Color.BLACK);
        paintBlack.setStyle(Paint.Style.STROKE);
        paintBlack.setStrokeWidth(3f);
        paintBlack.setAntiAlias(true);

        painDing = new Paint();
        painDing.setColor(Color.LTGRAY);
        painDing.setStyle(Paint.Style.FILL);
        painDing.setStrokeWidth(4f);
        painDing.setAntiAlias(true);
        painDing.setTextSize(500f);
        painDing.setAlpha(0);

        painMouth = new Paint();
        painMouth.setColor(Color.rgb(255, 99, 71));
        painMouth.setStyle(Paint.Style.STROKE);
        painMouth.setStrokeWidth(4f);
        painMouth.setAntiAlias(true);

        painHead = new Paint();
        painHead.setColor(Color.parseColor("#555555"));
        painHead.setStyle(Paint.Style.STROKE);
        painHead.setStrokeWidth(2f);
        painHead.setAntiAlias(true);
        painHead.setAlpha(200);

    }

    private void initIntAnim() {

        // 丁
        valueAnimatorDing = ValueAnimator.ofInt(0, 100);
        valueAnimatorDing.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                progressDing = (int) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimatorDing.setDuration(1000);

        // 眼睛
        valueAnimatorEyes = ValueAnimator.ofInt(0, 100);
        valueAnimatorEyes.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                progressEyes = (int) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimatorEyes.setDuration(800);

        valueAnimatorEyein = ValueAnimator.ofInt(0, 100);
        valueAnimatorEyein.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                progressEyein = (int) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimatorEyein.setDuration(800);

        // 抬头纹
        valueAnimatorLine1 = ValueAnimator.ofInt(0, 100);
        valueAnimatorLine1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                progressLine1 = (int) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimatorLine1.setDuration(300);

        valueAnimatorLine2 = ValueAnimator.ofInt(0, 100);
        valueAnimatorLine2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                progressLine2 = (int) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimatorLine2.setDuration(600);

        valueAnimatorLine3 = ValueAnimator.ofInt(0, 100);
        valueAnimatorLine3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                progressLine3 = (int) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimatorLine3.setDuration(900);

        // 嘴巴
        valueAnimatorMouth = ValueAnimator.ofInt(0, 100);
        valueAnimatorMouth.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                progressMouth = (int) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimatorMouth.setDuration(2000);

        // 头
        valueAnimatorHead = ValueAnimator.ofInt(0, 100);
        valueAnimatorHead.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                progressHead = (int) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimatorHead.setDuration(2000);

        // 腿
        valueAnimatorLegs = ValueAnimator.ofInt(0, 100);
        valueAnimatorLegs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                progressLegs = (int) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimatorLegs.setDuration(1000);

        // 脚
        valueAnimatorFoots = ValueAnimator.ofInt(0, 100);
        valueAnimatorFoots.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                progressFoots = (int) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimatorFoots.setDuration(400);
    }

    private void initPath() {
        // 左耳朵
        ViewPath viewPathLeftEar = new ViewPath();
        pointLeftEar.x = dp2px(73);
        pointLeftEar.y = dp2px(106);
        pathLeftEar.moveTo(pointLeftEar.x, pointLeftEar.y);
        viewPathLeftEar.moveTo(pointLeftEar.x, pointLeftEar.y);
        viewPathLeftEar.curveTo(dp2px(40), dp2px(80), dp2px(30), dp2px(140), dp2px(60), dp2px(130));
        viewPathLeftEar.curveTo(dp2px(50), dp2px(150), dp2px(50), dp2px(180), dp2px(67), dp2px(170));
        valueAnimatorLeftEar = ValueAnimator.ofObject(new ViewPathEvaluator(), viewPathLeftEar.getPoints().toArray());
        valueAnimatorLeftEar.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                pointLeftEar = (Point) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimatorLeftEar.setDuration(1000);


        // 右耳朵
        ViewPath viewPathRightEar = new ViewPath();
        pointRightEar.x = dp2px(277);
        pointRightEar.y = dp2px(110);
        pathRightEar.moveTo(pointRightEar.x, pointRightEar.y);
        viewPathRightEar.moveTo(pointRightEar.x, pointRightEar.y);
        viewPathRightEar.curveTo(dp2px(310), dp2px(80), dp2px(318), dp2px(140), dp2px(285), dp2px(130));
        viewPathRightEar.curveTo(dp2px(295), dp2px(120), dp2px(315), dp2px(150), dp2px(280), dp2px(170));
        valueAnimatorRightEar = ValueAnimator.ofObject(new ViewPathEvaluator(), viewPathRightEar.getPoints().toArray());
        valueAnimatorRightEar.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                pointRightEar = (Point) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimatorRightEar.setDuration(1000);


        // 身体
        ViewPath viewPathBody = new ViewPath();
        pointBody.x = dp2px(165);
        pointBody.y = dp2px(287);
        pathBody.moveTo(pointBody.x, pointBody.y);
        viewPathBody.moveTo(pointBody.x, pointBody.y);
        viewPathBody.curveTo(dp2px(55), dp2px(445), dp2px(285), dp2px(445), dp2px(210), dp2px(290));
        valueAnimatorBody = ValueAnimator.ofObject(new ViewPathEvaluator(), viewPathBody.getPoints().toArray());
        valueAnimatorBody.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                pointBody = (Point) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimatorBody.setDuration(1000);


        // 左胳膊
        ViewPath viewPathLeftArm = new ViewPath();
        pointLeftArm.x = dp2px(152);
        pointLeftArm.y = dp2px(310);
        pathLeftArm.moveTo(pointLeftArm.x, pointLeftArm.y);
        viewPathLeftArm.moveTo(pointLeftArm.x, pointLeftArm.y);
        viewPathLeftArm.curveTo(dp2px(10), dp2px(346), dp2px(135), dp2px(425), dp2px(85), dp2px(350));
        valueAnimatorLeftArm = ValueAnimator.ofObject(new ViewPathEvaluator(), viewPathLeftArm.getPoints().toArray());
        valueAnimatorLeftArm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                pointLeftArm = (Point) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimatorLeftArm.setDuration(1000);


        // 右胳膊
        ViewPath viewPathRightArm = new ViewPath();
        pointRightArm.x = dp2px(218);
        pointRightArm.y = dp2px(310);
        pathRightArm.moveTo(pointRightArm.x, pointRightArm.y);
        viewPathRightArm.moveTo(pointRightArm.x, pointRightArm.y);
        viewPathRightArm.curveTo(dp2px(345), dp2px(346), dp2px(265), dp2px(450), dp2px(282), dp2px(350));
        valueAnimatorRightArm = ValueAnimator.ofObject(new ViewPathEvaluator(), viewPathRightArm.getPoints().toArray());
        valueAnimatorRightArm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                pointRightArm = (Point) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimatorRightArm.setDuration(1000);


        animatorSet = new AnimatorSet();
        // 设置动画集合，按顺序绘制
        animatorSet.playSequentially(valueAnimatorDing, valueAnimatorEyes, valueAnimatorEyein, valueAnimatorLine1, valueAnimatorLine2, valueAnimatorLine3, valueAnimatorMouth, valueAnimatorHead, valueAnimatorLeftEar, valueAnimatorRightEar, valueAnimatorBody, valueAnimatorLeftArm, valueAnimatorRightArm, valueAnimatorLegs, valueAnimatorFoots);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        if (widthMeasureSpec > 0) {
            if (!isInitPath) {
                isInitPath = true;
                initIntAnim();
                initPath();
            }
        }
    }

    // 抬头纹的三条线
//    private float[] linesArr = new float[4];
    private float[] linesArr1 = {dp2px(160), dp2px(60), dp2px(210), dp2px(60)};
    private float[] linesArr2 = {dp2px(160), dp2px(50), dp2px(210), dp2px(50)};
    private float[] linesArr3 = {dp2px(154), dp2px(70), dp2px(216), dp2px(70)};

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 旋转画布，结束还需旋转回去（在这里实现倾斜）
        canvas.rotate(-15, dp2px(getContext(), 225), dp2px(getContext(), 150));
        //  丁
        if (progressDing > 0) {
            painDing.setAlpha(progressDing);
            canvas.drawText("丁", getWidth() / 3f, getHeight() * progressDing / 300f, painDing);
        }

        // 重新设置画笔为描边
        paintRed.setStyle(Paint.Style.STROKE);
        // 眼睛部分：眼眶
        // 左眼
        rectF.set(dp2px(110), dp2px(115), dp2px(140), dp2px(145));
        canvas.drawArc(rectF, 0, progressEyes * 3.6f, false, paintRed);

        // 右眼
        rectF.set(dp2px(225), dp2px(115), dp2px(255), dp2px(145));
        canvas.drawArc(rectF, 0, progressEyes * 3.6f, false, paintRed);
        // 黑眼球
        if (progressEyes < 100) {
            paintBlack.setStyle(Paint.Style.STROKE);
        } else {
            paintBlack.setStyle(Paint.Style.FILL);
        }

        if (!mouthTalkFlag) {
            rectF.set(dp2px(123), dp2px(123), dp2px(133), dp2px(133));
            canvas.drawArc(rectF, 0, progressEyein * 3.6f, false, paintBlack);
            rectF.set(dp2px(238), dp2px(123), dp2px(248), dp2px(133));
            canvas.drawArc(rectF, 0, progressEyein * 3.6f, false, paintBlack);
        } else {
            rectF.set(dp2px(getNum(116, 130)), dp2px(getNum(116, 130)), dp2px(getNum(130, 140)), dp2px(getNum(130, 140)));
            canvas.drawArc(rectF, 0, progressEyein * 3.6f, false, paintBlack);
            rectF.set(dp2px(getNum(228,243)), dp2px(getNum(114,128)), dp2px(getNum(240,253)), dp2px(getNum(124,138)));
            canvas.drawArc(rectF, 0, progressEyein * 3.6f, false, paintBlack);
        }

        // 抬头纹
        canvas.drawLine(dp2px(160), dp2px(50), dp2px(160 + 50 * progressLine1 / 100f), dp2px(50), paintRed);
        canvas.drawLine(dp2px(160), dp2px(60), dp2px(160 + 50 * progressLine2 / 100f), dp2px(60), paintRed);
        canvas.drawLine(dp2px(155), dp2px(70), dp2px(155 + 60 * progressLine3 / 100f), dp2px(70), paintRed);

//        canvas.drawLines(linesArr1, paintRed);
//        canvas.drawLines(linesArr2, paintRed);
//        canvas.drawLines(linesArr3, paintRed);


        // 嘴巴
        if (!mouthTalkFlag) {
            rectFMouth.set(dp2px(155), dp2px(220), dp2px(155 + 40 * progressMouth / 100f), dp2px(250));
            canvas.drawRect(rectFMouth, painMouth);
        } else {
            rectFMouth.set(dp2px(155), dp2px(220), dp2px(195), dp2px(getNum(221, 255)));
            canvas.drawRect(rectFMouth, painMouth);
        }


        // 脑袋 轮廓
        rectF.set(dp2px(66), dp2px(20), dp2px(282), dp2px(280));
//        canvas.drawRect(rectF,paintRed);
        if (progressHead < 100) {
            // 如果进度不完整，只进行描边操作
            painHead.setStyle(Paint.Style.STROKE);
        } else {
            // 如果进度完整，即环形绘制完成，设置画笔为填充模式,设置填充及描边（FILL_AND_STROKE）也行
//            painHead.setStyle(Paint.Style.FILL);
//            painHead.setAlpha(7);
        }
        canvas.drawArc(rectF, 0, progressHead * 3.6f, false, painHead);

        // 左耳朵
        paintRed.setStyle(Paint.Style.STROKE);
        pathLeftEar.lineTo(pointLeftEar.x, pointLeftEar.y);
        canvas.drawPath(pathLeftEar, paintRed);

        // 右耳朵
        pathRightEar.lineTo(pointRightEar.x, pointRightEar.y);
        canvas.drawPath(pathRightEar, paintRed);


        canvas.rotate(15, dp2px(getContext(), 225), dp2px(getContext(), 130));

        // 身体
        pathBody.lineTo(pointBody.x, pointBody.y);
        canvas.drawPath(pathBody, paintRed);

        // 左胳膊
        pathLeftArm.lineTo(pointLeftArm.x, pointLeftArm.y);
        canvas.drawPath(pathLeftArm, paintRed);

        // 右胳膊
        pathRightArm.lineTo(pointRightArm.x, pointRightArm.y);
        canvas.drawPath(pathRightArm, paintRed);


        // 腿和脚，需要内容填充
        paintRed.setStyle(Paint.Style.FILL);
        // 腿
        canvas.drawRect(dp2px(160), dp2px(404), dp2px(163), dp2px(404 + 30 * progressLegs / 100f), paintRed);
        canvas.drawRect(dp2px(188), dp2px(404), dp2px(191), dp2px(404 + 30 * progressLegs / 100f), paintRed);

        // 小黑脚
        paintBlack.setStyle(Paint.Style.FILL);
        rectF.set(dp2px(156), dp2px(432), dp2px(156 + 20 * progressFoots / 100f), dp2px(444));
        canvas.drawRoundRect(rectF, dp2px(5), dp2px(5), paintBlack);

        canvas.rotate(-15, dp2px(getContext(), 185), dp2px(getContext(), 432));
        rectF.set(dp2px(185), dp2px(432), dp2px(185 + 20 * progressFoots / 100f), dp2px(444));
        canvas.drawRoundRect(rectF, dp2px(5), dp2px(5), paintBlack);
        canvas.rotate(15, dp2px(getContext(), 185), dp2px(getContext(), 432));
    }

    private int dp2px(float dpValue) {
        return dp2px(getContext(), dpValue);
    }

    public static int dp2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public void startMouth() {

        mouthTalkFlag = true;

        valueAnimatorMouth.start();
        valueAnimatorEyein.start();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Long startAnimation() {

        reset();
        initPath();
        animatorSet.start();

        if (animatorSet.isStarted()) {

            return animatorSet.getTotalDuration();
        }

        return -1L;
    }

    private void reset() {

        mouthTalkFlag = false;
        pathLeftEar.reset();
        pathRightEar.reset();
        pathBody.reset();
        pathLeftArm.reset();
        pathRightArm.reset();
    }

    /**
     * 生成一个startNum 到 endNum之间的随机数(不包含endNum的随机数)
     *
     * @param startNum
     * @param endNum
     * @return
     */
    public static int getNum(int startNum, int endNum) {
        if (endNum > startNum) {
            Random random = new Random();
            return random.nextInt(endNum - startNum) + startNum;
        }
        return 0;
    }

}
