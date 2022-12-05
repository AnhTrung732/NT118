package com.example.lab05_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnFadeInXml, btnFadeInCode, btnFadeOutXml, btnFadeOutCode,
            btnBlinkXml,
            btnBlinkCode, btnZoomInXml, btnZoomInCode, btnZoomOutXml,
            btnZoomOutCode, btnRotateXml,
            btnRotateCode, btnMoveXml, btnMoveCode, btnSlideUpXml, btnSlideUpCode,
            btnBounceXml,
            btnBounceCode, btnCombineXml, btnCombineCode;
    private ImageView ivUitLogo;
    private Animation.AnimationListener animationListener;

    private void findViewsByIds() {
        ivUitLogo = (ImageView) findViewById(R.id.iv_uit_logo);
        btnFadeInXml = (Button) findViewById(R.id.btn_fade_in_xml);
        btnFadeInCode = (Button) findViewById(R.id.btn_fade_in_code);
        btnFadeOutXml = (Button) findViewById(R.id.btn_fade_out_xml);
        btnFadeOutCode = (Button) findViewById(R.id.btn_fade_out_code);
        btnBlinkXml = (Button) findViewById(R.id.btn_blink_xml);
        btnBlinkCode = (Button) findViewById(R.id.btn_blink_code);
        btnZoomInXml = (Button) findViewById(R.id.btn_zoom_in_xml);
        btnZoomInCode = (Button) findViewById(R.id.btn_zoom_in_code);
        btnZoomOutXml = (Button) findViewById(R.id.btn_zoom_out_xml);
        btnZoomOutCode = (Button) findViewById(R.id.btn_zoom_out_code);
        btnRotateXml = (Button) findViewById(R.id.btn_rotate_xml);
        btnRotateCode = (Button) findViewById(R.id.btn_rotate_code);
        btnMoveXml = (Button) findViewById(R.id.btn_move_xml);
        btnMoveCode = (Button) findViewById(R.id.btn_move_code);
        btnSlideUpXml = (Button) findViewById(R.id.btn_slide_up_xml);
        btnSlideUpCode = (Button) findViewById(R.id.btn_slide_up_code);
        btnBounceXml = (Button) findViewById(R.id.btn_bounce_xml);
        btnBounceCode = (Button) findViewById(R.id.btn_bounce_code);
        btnCombineXml = (Button) findViewById(R.id.btn_combine_xml);
        btnCombineCode = (Button) findViewById(R.id.btn_combine_code);
    }

    private void initVariables() {
        animationListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(getApplicationContext(), "Animation Stopped",
                        Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        };
        ivUitLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iNewActivity = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(iNewActivity);

                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
            }
        });
    }
    private Animation initFadeInAnimation()
    {
        AlphaAnimation animation = new AlphaAnimation(0f, 1f);
        animation.setDuration (1000);
        animation.setFillAfter (true);

        animation.setAnimationListener (animationListener) ;
        return animation;
    }
    private Animation initBlinkAnimation()
    {
        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(300); //You can manage the blinking time with this parameter
        //animation.setStartOffset(20);
        animation.setRepeatMode(Animation.REVERSE);
        //animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatCount(3);
        animation.setAnimationListener (animationListener) ;

        return animation;
    }
    private Animation initFadeOutAnimation()
    {
        AlphaAnimation animation = new AlphaAnimation(1f, 0f);
        animation.setDuration (1000);
        animation.setFillAfter (true);

        animation.setAnimationListener (animationListener) ;
        return animation;
    }

    private void handleClickAnimationXml(Button btn, int animId)
    {
        final Animation animation = AnimationUtils.loadAnimation(MainActivity.this, animId);
        animation.setAnimationListener(animationListener);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("00000000000");
                ivUitLogo.startAnimation(animation);
            }
        });
    }
    public void ClickAnimationXml(){
        handleClickAnimationXml(btnBlinkXml,R.anim.anim_blink);
        handleClickAnimationXml(btnBounceXml,R.anim.anim_bounce);
        handleClickAnimationXml(btnCombineXml,R.anim.anim_combine);
        handleClickAnimationXml(btnFadeInXml,R.anim.anim_fade_in);
        handleClickAnimationXml(btnFadeOutXml,R.anim.anim_fade_out);
        handleClickAnimationXml(btnMoveXml,R.anim.anim_move);
        handleClickAnimationXml(btnRotateXml,R.anim.anim_rotate);
        handleClickAnimationXml(btnSlideUpXml,R.anim.anim_slide_up);
        handleClickAnimationXml(btnZoomInXml,R.anim.anim_zoom_in);
        handleClickAnimationXml(btnZoomOutXml,R.anim.anim_zoom_out);
    }
    private void handleClickAnimationCode(Button btn, final Animation animation) {
        // Handle onclickListenner to start animation
        //animation.setAnimationListener(animationListener);
        System.out.println("222222222222");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("1111111111111");
                ivUitLogo.startAnimation(animation);
            }
        });
    }
    public void ClickAnimationCode(){
        handleClickAnimationCode(btnBlinkCode,initBlinkAnimation());
//        handleClickAnimationXml(btnBounceXml,R.anim.anim_bounce);
//        handleClickAnimationXml(btnCombineXml,R.anim.anim_combine);
        handleClickAnimationCode(btnFadeInCode, initFadeInAnimation());
        handleClickAnimationCode(btnFadeOutCode,initFadeOutAnimation());
//        handleClickAnimationXml(btnMoveXml,R.anim.anim_move);
//        handleClickAnimationXml(btnRotateXml,R.anim.anim_rotate);
//        handleClickAnimationXml(btnSlideUpXml,R.anim.anim_slide_up);
//        handleClickAnimationXml(btnZoomInXml,R.anim.anim_zoom_in);
//        handleClickAnimationXml(btnZoomOutXml,R.anim.anim_zoom_out);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewsByIds();
        initVariables();

        ClickAnimationXml();
        ClickAnimationCode();

    }
}