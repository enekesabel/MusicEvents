package enekes.abel.musicevents.network.api;

import java.util.List;

import enekes.abel.musicevents.network.model.EventData;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ArtistEventsApi {
  /**
   * Get all upcoming artist events or all past and upcoming events within a date range
   * artist events 
   * @param artistname The name of the artist. If it contains one of the special characters below, please be sure to replace it by the corresponding code: for / use %252F, for ? use %253F, for * use %252A, and for \&quot; use %27C (required)
   * @param appId The application ID assigned to you by Bandsintown (required)
   * @param date Date range of requested shows e.g. 2015-05-05,2017-05-05 (optional)
   * @return Call&lt;List&lt;EventData&gt;&gt;
   */
  @GET("artists/{artistname}/events")
  Call<List<EventData>> artistEvents(
          @retrofit2.http.Path("artistname") String artistname, @retrofit2.http.Query("app_id") String appId, @retrofit2.http.Query("date") String date
  );

}
