package com.example.androishaper.volleysingelton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txt;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=findViewById(R.id.txtView);
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.btn)
        {
            // Get a RequestQueue
            RequestQueue queue = MySingleton.getInstance(this.getApplicationContext()).getRequestQueue();
            String url="http://192.168.1.100/AndroidVolley/welcome.php";
            final StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    txt.setText(response.substring(0,17));

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    txt.setText("Connection Complied"+error);

                }
            }


            );


// Add a request (in this example, called stringRequest) to your RequestQueue.
            MySingleton.getInstance(this).addToRequestQueue(stringRequest);

        }

    }
}
