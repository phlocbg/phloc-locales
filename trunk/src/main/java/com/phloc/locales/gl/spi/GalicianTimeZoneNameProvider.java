/**
 * Copyright (C) 2006-2013 phloc systems
 * http://www.phloc.com
 * office[at]phloc[dot]com
 *
 * Based on Klaus Brunners
 * locale-sh: a Java Locale Service Provider for Bosnian/Croatian/Serbian
 * http://klaus.e175.net/java-locale-sh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.phloc.locales.gl.spi;

import java.text.DateFormatSymbols;
import java.util.Locale;
import java.util.TimeZone;
import java.util.spi.TimeZoneNameProvider;

import com.phloc.locales.gl.GalicianLocales;

public final class GalicianTimeZoneNameProvider extends TimeZoneNameProvider
{

  public GalicianTimeZoneNameProvider ()
  {
    super ();
  }

  @Override
  public String getDisplayName (final String ID, final boolean daylight, final int style, final Locale locale)
  {
    if (ID == null)
    {
      throw new NullPointerException ();
    }
    if (locale == null)
    {
      throw new NullPointerException ();
    }
    if (!_isStyleValid (style))
    {
      throw new IllegalArgumentException ("Style \"" + style + "\" is not valid");
    }
    if (GalicianLocales.GALICIAN_LIST.contains (locale))
    {

      final DateFormatSymbols symbols = DateFormatSymbols.getInstance (GalicianLocales.GALICIAN_ES);
      final String [][] zoneStrings = symbols.getZoneStrings ();
      /*
       * First, try to retrieve a name using the specified ID as the main
       * timezone ID
       */
      for (final String [] zoneString : zoneStrings)
      {
        if (ID.equalsIgnoreCase (zoneString[0]))
        {
          switch (style)
          {
            case TimeZone.LONG:
              return (daylight ? zoneString[3] : zoneString[1]);
            case TimeZone.SHORT:
              return (daylight ? zoneString[4] : zoneString[2]);
          }
        }
      }
      /*
       * Then try to retrieve a name using the specified ID as a short name
       * (first, non-daylight saving - then, daylight-saving).
       */
      if (!daylight)
      {
        for (final String [] zoneString : zoneStrings)
        {
          if (ID.equalsIgnoreCase (zoneString[2]))
          {
            switch (style)
            {
              case TimeZone.LONG:
                return (daylight ? zoneString[3] : zoneString[1]);
              case TimeZone.SHORT:
                return (daylight ? zoneString[4] : zoneString[2]);
            }
          }
        }
      }
      else
      {
        for (final String [] zoneString : zoneStrings)
        {
          if (ID.equalsIgnoreCase (zoneString[4]))
          {
            switch (style)
            {
              case TimeZone.LONG:
                return (daylight ? zoneString[3] : zoneString[1]);
              case TimeZone.SHORT:
                return (daylight ? zoneString[4] : zoneString[2]);
            }
          }
        }
      }

      /*
       * If we don't have a name yet, default to en_US
       */
      final TimeZone timeZone = TimeZone.getTimeZone (ID);
      return timeZone.getDisplayName (new Locale ("en", "US"));
    }
    throw new IllegalArgumentException ("Locale \"" +
                                        locale +
                                        "\" " +
                                        "is not one of the supported locales (" +
                                        GalicianLocales.GALICIAN_LIST +
                                        ")");
  }

  private static boolean _isStyleValid (final int style)
  {
    return (style == TimeZone.SHORT || style == TimeZone.LONG);
  }

  @Override
  public Locale [] getAvailableLocales ()
  {
    return GalicianLocales.getLocaleArray ();
  }

}
