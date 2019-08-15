package zhuoyuan.li.retrofittest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface SkillService {
    @GET("skill/samurai")
    Call<SkillResponse> getCall();
}
