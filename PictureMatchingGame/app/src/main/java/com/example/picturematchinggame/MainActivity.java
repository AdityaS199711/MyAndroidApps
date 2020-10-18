package com.example.picturematchinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView myView = null;
    private int countPair = 0;
    final int [] drawable = new int[]{R.drawable.pic_0, R.drawable.pic_1, R.drawable.pic_2, R.drawable.pic_3, R.drawable.pic_4, R.drawable.pic_5};

    int [] positions = {0,1,2,3,4,5,0,1,2,3,4,5};
    int currentPosition = -1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView)findViewById(R.id.gridView);
        PictureAdapter picAdapter = new PictureAdapter(this);
        gridView.setAdapter(picAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(currentPosition < 0)
                {
                    currentPosition = position;
                    myView = (ImageView)view;
                    ((ImageView)view).setImageResource(drawable[positions[position]]);
                }

                else
                    {
                        if(currentPosition == position)
                        {
                            ((ImageView)view).setImageResource(R.drawable.questionmark);

                        }

                        else if (positions[currentPosition] != positions[position])
                        {
                            myView.setImageResource(R.drawable.questionmark);
                            Toast.makeText(getApplicationContext(), "Try Again",Toast.LENGTH_SHORT).show();
                        }

                        else
                            {
                                ((ImageView)view).setImageResource(drawable[positions[position]]);
                                countPair--;

                                if(countPair == 0)
                                {
                                    Toast.makeText(getApplicationContext(), "Well Done!! You have successfully matched all the pairs",Toast.LENGTH_LONG).show();
                                }
                            }
                            currentPosition = -1;

                    }
            }
        });
    }
}