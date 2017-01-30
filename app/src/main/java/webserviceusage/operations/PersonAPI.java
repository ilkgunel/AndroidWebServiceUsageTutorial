package webserviceusage.operations;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import webserviceusage.pojo.Person;

public interface PersonAPI {
    @GET("/SpringRestTutorial/getExample")
    Call<Person[]> getSonValues();

    @POST("/SpringRestTutorial/postPerson")
    Call<Person> postPerson(@Body Person person);
}
