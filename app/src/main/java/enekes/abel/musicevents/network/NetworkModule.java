package enekes.abel.musicevents.network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import enekes.abel.musicevents.network.api.ArtistEventsApi;
import enekes.abel.musicevents.network.api.ArtistInformationApi;
import enekes.abel.musicevents.network.api.ArtistSearchApi;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public ArtistEventsApi provideArtistEventsApi() {
        return new ApiClient().createService(ArtistEventsApi.class);
    }


    @Provides
    @Singleton
    public ArtistInformationApi provideArtistInformationApi() {
        return new ApiClient().createService(ArtistInformationApi.class);
    }

    @Provides
    @Singleton
    public ArtistSearchApi provideArtistSearchApi(){
        return new ArtistSearchApiImpl();
    }

}
