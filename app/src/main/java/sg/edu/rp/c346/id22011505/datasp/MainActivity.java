package sg.edu.rp.c346.id22011505.datasp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    ListView lvEnrolment;

    AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvEnrolment = findViewById(R.id.lvEnrolment);
        client = new AsyncHttpClient();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ArrayList<Enrolment> alEnrolment = new ArrayList<Enrolment>();
        client.get("https://data.gov.sg/api/action/datastore_search?resource_id=fdd36db3-3317-4790-8c27-8e58f7dd1a42&", new JsonHttpResponseHandler() {
            int year;
            String study;
            int enrolment;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {

                    JSONArray firstObj = response.getJSONObject("result").getJSONArray("records");
                    for(int i = 0; i < firstObj.length(); i++) {
                        JSONObject jsonObjForecast = firstObj.getJSONObject(i);
                        year = jsonObjForecast.getInt("year");
                        study = jsonObjForecast.getString("type_of_study");
                        enrolment = jsonObjForecast.getInt("enrolment");
                        Enrolment enrolmentType = new Enrolment(year, study, enrolment);
                        alEnrolment.add(enrolmentType);
                    }
                }
                catch(JSONException e){
                    e.printStackTrace();
            }
                //POINT X – Code to display List View
                ArrayAdapter<Enrolment> adapter = new ArrayAdapter<Enrolment>(MainActivity.this, android.R.layout.simple_list_item_1, alEnrolment);
                lvEnrolment.setAdapter(adapter);

            }//end onSuccess
        });
    }//end onResume

}
