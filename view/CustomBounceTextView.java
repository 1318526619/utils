package per.edward.numberrise;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * description:仿支付宝“数字增长动画”
 *
 * 此Demo博客地址：http://blog.csdn.net/u012814441/article/details/49883961
 * <p/>
 * author:Edward
 * <p/>
 * 2015/11/13
 */
public class CustomBounceTextView extends TextView {

    public CustomBounceTextView(Context context) {
        super(context, null, 0);
    }

    public CustomBounceTextView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public CustomBounceTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 开始数字增长动画(声明了Exception异常，要求使用者必须处理此异常)
     *
     * @param endNumber
     */
    public void start(float endNumber) throws Exception {
        start(endNumber, 1500);
    }

    /**
     * 开始数字增长动画(声明了Exception异常，要求使用者必须处理此异常)
     *
     * @param endNumber
     * @param duration
     */
    public void start(float endNumber, int duration) throws Exception {
        if (endNumber > 10000000) {
            //抛出异常
            throw new IllegalArgumentException(endNumber + "不能大于10000000");
        }

        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, endNumber);
        //动画的持续时间
        valueAnimator.setDuration(duration);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float temp = (float) valueAnimator.getAnimatedValue();

                setText(getRiseNumber(temp));
            }
        });
        //开始执行动画
        valueAnimator.start();
    }


    /**
     * 获取增长的数字
     *
     * @param number
     * @return
     */
    public String getRiseNumber(float number) {
        String numberStr = String.valueOf(number);
        //获取小数点的下标（由于下标是从0开始，为了方便计算将其加1变为从1开始）
        int pointIndex = numberStr.indexOf(".") + 1;
        //计算此字符串的长度
        int length = numberStr.length();
        if (pointIndex + 1 == length) {
            //如果传进来的字符串一位小数，直接在后面拼接1个0
            return numberStr + "0";
        } else if (pointIndex + 2 == length) {
            //如果传进来的字符串两位小数，则直接返回该字符串
            return numberStr;
        } else {
            //如果传进来的字符串小数多于两位，则直接截取第0位到小数点后两位的字符串
            return numberStr.substring(0, pointIndex + 2);
        }

    }
}
