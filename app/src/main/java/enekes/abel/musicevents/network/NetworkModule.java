package enekes.abel.musicevents.network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import enekes.abel.musicevents.network.api.ArtistEventsApi;
import enekes.abel.musicevents.network.api.ArtistInformationApi;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public ArtistEventsApi provideArtistEventsApi() {
        return new ApiClient().createService(ArtistEventsApi.class);
    }


    @Provides
    @Singleton
    public ArtistInformationApi provideArtionstInformationApi() {
        return new ApiClient().createService(ArtistInformationApi.class);
    }

}
