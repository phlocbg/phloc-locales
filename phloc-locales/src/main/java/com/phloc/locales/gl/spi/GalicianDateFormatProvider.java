/**
 * Copyright (C) 2006-2014 phloc systems
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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.spi.DateFormatProvider;
import java.util.Locale;

import com.phloc.locales.gl.GalicianLocales;

public final class GalicianDateFormatProvider extends DateFormatProvider
{

  private static final String PATTERN_DATE_SHORT = "d'/'MM'/'yy";
  private static final String PATTERN_DATE_MEDIUM = "dd'-'MMM'-'yyyy";
  private static final String PATTERN_DATE_LONG = "d 'de' MMMM 'de' yyyy";
  private static final String PATTERN_DATE_FULL = "EEEE d 'de' MMMM 'de' yyyy";

  private static final String PATTERN_TIME_SHORT = "H':'mm";
  private static final String PATTERN_TIME_MEDIUM = "H':'mm':'ss";
  private static final String PATTERN_TIME_LONG = "H':'mm':'ss z";
  private static final String PATTERN_TIME_FULL = "HH'H'mm'' z";

  public GalicianDateFormatProvider ()
  {
    super ();
  }

  @Override
  public DateFormat getDateInstance (final int style, final Locale locale)
  {
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
      switch (style)
      {
        case DateFormat.FULL:
          return new SimpleDateFormat (PATTERN_DATE_FULL, locale);
        case DateFormat.LONG:
          return new SimpleDateFormat (PATTERN_DATE_LONG, locale);
        case DateFormat.MEDIUM:
          return new SimpleDateFormat (PATTERN_DATE_MEDIUM, locale);
        case DateFormat.SHORT:
          return new SimpleDateFormat (PATTERN_DATE_SHORT, locale);
      }
    }
    throw new IllegalArgumentException ("Locale \"" +
                                        locale +
                                        "\" " +
                                        "is not one of the supported locales (" +
                                        GalicianLocales.GALICIAN_LIST +
                                        ")");
  }

  @Override
  public DateFormat getDateTimeInstance (final int dateStyle, final int timeStyle, final Locale locale)
  {
    if (locale == null)
    {
      throw new NullPointerException ();
    }
    if (!_isStyleValid (dateStyle))
    {
      throw new IllegalArgumentException ("Style \"" + dateStyle + "\" is not valid");
    }
    if (!_isStyleValid (timeStyle))
    {
      throw new IllegalArgumentException ("Style \"" + timeStyle + "\" is not valid");
    }
    if (GalicianLocales.GALICIAN_LIST.contains (locale))
    {
      final StringBuilder pattern = new StringBuilder ();
      switch (dateStyle)
      {
        case DateFormat.FULL:
          pattern.append (PATTERN_DATE_FULL);
          break;
        case DateFormat.LONG:
          pattern.append (PATTERN_DATE_LONG);
          break;
        case DateFormat.MEDIUM:
          pattern.append (PATTERN_DATE_MEDIUM);
          break;
        case DateFormat.SHORT:
          pattern.append (PATTERN_DATE_SHORT);
          break;
        default:
          throw new IllegalArgumentException ("Unsupported date style");
      }
      pattern.append (" ");
      switch (timeStyle)
      {
        case DateFormat.FULL:
          pattern.append (PATTERN_TIME_FULL);
          break;
        case DateFormat.LONG:
          pattern.append (PATTERN_TIME_LONG);
          break;
        case DateFormat.MEDIUM:
          pattern.append (PATTERN_TIME_MEDIUM);
          break;
        case DateFormat.SHORT:
          pattern.append (PATTERN_TIME_SHORT);
          break;
        default:
          throw new IllegalArgumentException ("Unsupported time style");
      }

      return new SimpleDateFormat (pattern.toString (), locale);

    }
    throw new IllegalArgumentException ("Locale \"" +
                                        locale +
                                        "\" " +
                                        "is not one of the supported locales (" +
                                        GalicianLocales.GALICIAN_LIST +
                                        ")");
  }

  @Override
  public DateFormat getTimeInstance (final int style, final Locale locale)
  {
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
      switch (style)
      {
        case DateFormat.FULL:
          return new SimpleDateFormat (PATTERN_TIME_FULL, locale);
        case DateFormat.LONG:
          return new SimpleDateFormat (PATTERN_TIME_LONG, locale);
        case DateFormat.MEDIUM:
          return new SimpleDateFormat (PATTERN_TIME_MEDIUM, locale);
        case DateFormat.SHORT:
          return new SimpleDateFormat (PATTERN_TIME_SHORT, locale);
      }
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
    return (style == DateFormat.SHORT || style == DateFormat.MEDIUM || style == DateFormat.LONG || style == DateFormat.FULL);
  }

  @Override
  public Locale [] getAvailableLocales ()
  {
    return GalicianLocales.getLocaleArray ();
  }
}
