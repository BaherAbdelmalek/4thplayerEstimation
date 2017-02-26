package data;

import models.Cards;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by baher on 12/2/16.
 */
public interface RestApi {
    @GET("/playerCards")
    Call<Cards> getMyCards();
    @GET("/waitForDash")
    Call<Cards> waitForDash();
    @GET("/waitForCall")
    Call<Cards> waitForCall();
    @GET("/waitForBids")
    Call<Cards> waitForbids();
    @GET("/myCard")
    Call<Cards> playcard(@Query("card") int card);
    @GET("/isDash")
    Call<Cards> isDashcall(@Query("dash") int  dash);
    @GET("/isCall")
    Call<Cards> iscall(@Query("call") int  call);
    @GET("/getBid")
    Call<Cards> mybid(@Query("bids") int  bid);
    @GET("/waitForRoll")
    Call<Cards> waitforRoll();


}
