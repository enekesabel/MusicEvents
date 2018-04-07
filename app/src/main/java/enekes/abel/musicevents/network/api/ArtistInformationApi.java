package enekes.abel.musicevents.network.api;

import enekes.abel.musicevents.network.model.ArtistData;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ArtistInformationApi {
  /**
   * Get artist information
   * Get artist information 
   * @param artistname The name of the artist. If it contains one of the special characters below, please be sure to replace it by the corresponding code: for / use %252F, for ? use %253F, for * use %252A, and for \&quot; use %27C (required)
   * @param appId The application ID assigned to you by Bandsintown (required)
   * @return Call&lt;ArtistData&gt;
   */
  @GET("artists/{artistname}")
  Call<ArtistData> artist(
          @retrofit2.http.Path("artistname") String artistname, @retrofit2.http.Query("app_id") String appId
  );

}
