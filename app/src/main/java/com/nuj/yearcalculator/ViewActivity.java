package com.nuj.yearcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {

    TextView yearView, view, view2, view3, view4, colorView, animalView;
    ImageView imageView;
    int numYear=0;
    int first=0;
    int second=0;
    char firstC=' ';
    String firstS="";
    String yearStringO="";
    String yearStringT="";
    String yearStringTH="";
    String yearStringFO="";
    String myYear="";
    String color="";
    String animal="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        yearView = findViewById(R.id.idShowYearNum);
        view = findViewById(R.id.idShowYear);
        view2 = findViewById(R.id.idShowYear2);
        view3 = findViewById(R.id.idShowYear3);
        view4 = findViewById(R.id.idShowYear4);
        colorView = findViewById(R.id.idColor);
        animalView = findViewById(R.id.idAnimal);
        imageView = findViewById(R.id.idImageView);
        Intent intent = getIntent();
        myYear = intent.getStringExtra("my_year");
        calculateAndShow();
    }
    void calculateAndShow() { //이전버튼 누르면 이전화면으로 돌아가게
        switch (myYear.length()){//입력받는 문자열의 길이가 0~3까지여서
            case 1:
                firstC = myYear.charAt(0);
                break;
            case 2:
                firstC = myYear.charAt(1);
                break;
            case 3:
                firstC = myYear.charAt(2);
                break;
            case 4:
                firstC = myYear.charAt(3);
                break;
        }
        numYear = Integer.parseInt(myYear);
        firstS = String.valueOf(firstC); // char -> String
        first = Integer.parseInt(firstS); // String -> int
        second = (numYear % 12);
        switch (first) {//갑(甲) · 을(乙) · 병(丙) · 정(丁) · 무(戊) · 기(己) · 경(庚) · 신(辛) · 임(壬) · 계(癸)
            case 0:
                yearStringO="경";
                yearStringTH="庚";
                color="하얀";
                break;
            case 1:
                yearStringO="신";
                yearStringTH="辛";
                color="하얀";
                break;
            case 2:
                yearStringO="임";
                yearStringTH="壬";
                color="검은";
                break;
            case 3:
                yearStringO="계";
                yearStringTH="癸";
                color="검은";
                break;
            case 4:
                yearStringO="갑";
                yearStringTH="甲";
                color="푸른";
                break;
            case 5:
                yearStringO="을";
                yearStringTH="乙";
                color="푸른";
                break;
            case 6:
                yearStringO="병";
                yearStringTH="丙";
                color="붉은";
                break;
            case 7:
                yearStringO="정";
                yearStringTH="丁";
                color="붉은";
                break;
            case 8:
                yearStringO="무";
                yearStringTH="戊";
                color="황금";
                break;
            case 9:
                yearStringO="기";
                yearStringTH="己";
                color="황금";
                break;
        }
        switch (second) {//자(子), 축(丑), 인(寅), 묘(卯), 진(辰), 사(巳), 오(午), 미(未), 신(申), 유(酉), 술(戌), 해(亥)
            case 0:
                yearStringT="신";
                yearStringFO="申";
                imageView.setImageResource(R.drawable.monkey);
                animal="원숭이";
                break;
            case 1:
                yearStringT="유";
                yearStringFO="酉";
                imageView.setImageResource(R.drawable.chiken);
                animal="닭";
                break;
            case 2:
                yearStringT="술";
                yearStringFO="戌";
                imageView.setImageResource(R.drawable.dog);
                animal="개";
                break;
            case 3:
                yearStringT="해";
                yearStringFO="亥";
                imageView.setImageResource(R.drawable.pig);
                animal="돼지";
                break;
            case 4:
                yearStringT="자";
                yearStringFO="子";
                imageView.setImageResource(R.drawable.mouse);
                animal="쥐";
                break;
            case 5:
                yearStringT="축";
                yearStringFO="丑";
                imageView.setImageResource(R.drawable.cow);
                animal="소";
                break;
            case 6:
                yearStringT="인";
                yearStringFO="寅";
                imageView.setImageResource(R.drawable.tiger);
                animal="호랑이";
                break;
            case 7:
                yearStringT="묘";
                yearStringFO="卯";
                imageView.setImageResource(R.drawable.rabit);
                animal="토끼";
                break;
            case 8:
                yearStringT="진";
                yearStringFO="辰";
                imageView.setImageResource(R.drawable.dragon);
                animal="용";
                break;
            case 9:
                yearStringT="사";
                yearStringFO="巳";
                imageView.setImageResource(R.drawable.snake);
                animal="뱀";
                break;
            case 10:
                yearStringT="오";
                yearStringFO="午";
                imageView.setImageResource(R.drawable.horse);
                animal="말";
                break;
            case 11:
                yearStringT="미";
                yearStringFO="未";
                imageView.setImageResource(R.drawable.sheep);
                animal="양";
                break;
        }
        yearView.setText(numYear + "년은");
        view.setText(yearStringO);
        view2.setText(yearStringT);
        view3.setText(yearStringTH);
        view4.setText(yearStringFO);
        colorView.setText(color);
        animalView.setText(animal);
    }
    public void onPrevClicked(View v){
        finish();
    }
}