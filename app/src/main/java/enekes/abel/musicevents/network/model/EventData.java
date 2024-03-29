/*
 * Bandsintown API
 * # What is the Bandsintown API? The Bandsintown API is designed for enterprise partners and artists with websites, media players, and/or mobile applications that would like to list an artist's events and provide their users with the ability to buy tickets and RSVP to these events.  It offers read-only access to artist info and artist events: - artist info: returns the link to the Bandsintown artist page, the link to the artist photo, the current number of trackers and more - artist events: returns the list of upcoming events including their date and time, venue name and location, ticket links, lineup, description and the link to the Bandsintown event page  Note you can also search for events on a given date or within a given date range, including past dates.  # Getting Started - In order to use the Bandsintown API, you must have written consent from Bandsintown Inc. Any other use of the Bandsintown API is prohibited. [Contact Bandsintown](http://help.bandsintown.com/) to tell us what you plan to do and request your personal application ID. - Find out about the API methods available and the format of the API responses below. Select the method you wish to use and try it out online with the app ID provided to you. - Call our Bandsintown API with the app ID provided straight from your website or back-end platform and choose which element of the API response you wish to display. Scroll to the bottom of this page to find out about the Models used. 
 *
 * OpenAPI spec version: 3.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package enekes.abel.musicevents.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * EventData
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-05T20:59:23.263+02:00")
public class EventData {
  @SerializedName("id")
  private String id = null;

  @SerializedName("artist_id")
  private String artistId = null;

  @SerializedName("url")
  private String url = null;

  @SerializedName("on_sale_datetime")
  private String onSaleDatetime = null;

  @SerializedName("datetime")
  private String datetime = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("venue")
  private VenueData venue = null;

  @SerializedName("offers")
  private List<OfferData> offers = new ArrayList<OfferData>();

  @SerializedName("lineup")
  private List<String> lineup = new ArrayList<String>();

  public EventData id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "13722599", required = true, value = "")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public EventData artistId(String artistId) {
    this.artistId = artistId;
    return this;
  }

   /**
   * Get artistId
   * @return artistId
  **/
  @ApiModelProperty(example = "438314", required = true, value = "")
  public String getArtistId() {
    return artistId;
  }

  public void setArtistId(String artistId) {
    this.artistId = artistId;
  }

  public EventData url(String url) {
    this.url = url;
    return this;
  }

   /**
   * Get url
   * @return url
  **/
  @ApiModelProperty(example = "http://www.bandsintown.com/event/13722599?app_id=foo&artist=Skrillex&came_from=67", required = true, value = "")
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public EventData onSaleDatetime(String onSaleDatetime) {
    this.onSaleDatetime = onSaleDatetime;
    return this;
  }

   /**
   * Get onSaleDatetime
   * @return onSaleDatetime
  **/
  @ApiModelProperty(example = "2017-03-01T18:00:00.000+0000", required = true, value = "")
  public String getOnSaleDatetime() {
    return onSaleDatetime;
  }

  public void setOnSaleDatetime(String onSaleDatetime) {
    this.onSaleDatetime = onSaleDatetime;
  }

  public EventData datetime(String datetime) {
    this.datetime = datetime;
    return this;
  }

   /**
   * Get datetime
   * @return datetime
  **/
  @ApiModelProperty(example = "2017-03-19T11:00:00.000+0000", required = true, value = "")
  public String getDatetime() {
    return datetime;
  }

  public void setDatetime(String datetime) {
    this.datetime = datetime;
  }

  public EventData description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(example = "This is a description", value = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public EventData venue(VenueData venue) {
    this.venue = venue;
    return this;
  }

   /**
   * Get venue
   * @return venue
  **/
  @ApiModelProperty(required = true, value = "")
  public VenueData getVenue() {
    return venue;
  }

  public void setVenue(VenueData venue) {
    this.venue = venue;
  }

  public EventData offers(List<OfferData> offers) {
    this.offers = offers;
    return this;
  }

  public EventData addOffersItem(OfferData offersItem) {
    this.offers.add(offersItem);
    return this;
  }

   /**
   * Get offers
   * @return offers
  **/
  @ApiModelProperty(required = true, value = "")
  public List<OfferData> getOffers() {
    return offers;
  }

  public void setOffers(List<OfferData> offers) {
    this.offers = offers;
  }

  public EventData lineup(List<String> lineup) {
    this.lineup = lineup;
    return this;
  }

  public EventData addLineupItem(String lineupItem) {
    this.lineup.add(lineupItem);
    return this;
  }

   /**
   * Get lineup
   * @return lineup
  **/
  @ApiModelProperty(required = true, value = "")
  public List<String> getLineup() {
    return lineup;
  }

  public void setLineup(List<String> lineup) {
    this.lineup = lineup;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventData eventData = (EventData) o;
    return Objects.equals(this.id, eventData.id) &&
        Objects.equals(this.artistId, eventData.artistId) &&
        Objects.equals(this.url, eventData.url) &&
        Objects.equals(this.onSaleDatetime, eventData.onSaleDatetime) &&
        Objects.equals(this.datetime, eventData.datetime) &&
        Objects.equals(this.description, eventData.description) &&
        Objects.equals(this.venue, eventData.venue) &&
        Objects.equals(this.offers, eventData.offers) &&
        Objects.equals(this.lineup, eventData.lineup);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, artistId, url, onSaleDatetime, datetime, description, venue, offers, lineup);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventData {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    artistId: ").append(toIndentedString(artistId)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    onSaleDatetime: ").append(toIndentedString(onSaleDatetime)).append("\n");
    sb.append("    datetime: ").append(toIndentedString(datetime)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    venue: ").append(toIndentedString(venue)).append("\n");
    sb.append("    offers: ").append(toIndentedString(offers)).append("\n");
    sb.append("    lineup: ").append(toIndentedString(lineup)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

