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


package enekes.abel.musicevents.network;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-05T20:59:23.263+02:00")
public class StringUtil {
  /**
   * Check if the given array contains the given value (with case-insensitive comparison).
   *
   * @param array The array
   * @param value The value to search
   * @return true if the array contains the value
   */
  public static boolean containsIgnoreCase(String[] array, String value) {
    for (String str : array) {
      if (value == null && str == null) return true;
      if (value != null && value.equalsIgnoreCase(str)) return true;
    }
    return false;
  }

  /**
   * Join an array of strings with the given separator.
   * <p>
   * Note: This might be replaced by utility method from commons-lang or guava someday
   * if one of those libraries is added as dependency.
   * </p>
   *
   * @param array     The array of strings
   * @param separator The separator
   * @return the resulting string
   */
  public static String join(String[] array, String separator) {
    int len = array.length;
    if (len == 0) return "";

    StringBuilder out = new StringBuilder();
    out.append(array[0]);
    for (int i = 1; i < len; i++) {
      out.append(separator).append(array[i]);
    }
    return out.toString();
  }
}
