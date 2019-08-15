package zhuoyuan.li.retrofittest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNetWork();
        mTv = findViewById(R.id.text);
        mTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNetWork();
            }
        });
    }

    private void createNetWork() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://rap2api.taobao.org/app/mock/162762/")
                .build();

        SkillService sSkillService = retrofit.create(SkillService.class);
        final Call<SkillResponse> call = sSkillService.getCall();

        call.enqueue(new Callback<SkillResponse>() {
            @Override
            public void onResponse(Call<SkillResponse> call, Response<SkillResponse> response) {

                SkillResponse skillResponse = response.body();
                assert skillResponse != null;
                List<SkillResponse.Skill> skills = skillResponse.getData();
                mTv.setText(skills.get(0).toString());
            }

            @Override
            public void onFailure(Call<SkillResponse> call, Throwable t) {
                Log.e("retrofit----error", t.toString());
            }
        });
    }
}
