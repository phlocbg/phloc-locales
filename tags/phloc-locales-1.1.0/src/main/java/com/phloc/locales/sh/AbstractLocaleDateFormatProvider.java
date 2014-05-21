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
package com.phloc.locales.sh;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.spi.DateFormatProvider;
import java.util.Locale;

public abstract class AbstractLocaleDateFormatProvider extends DateFormatProvider
{
  /**
   * Get LocaleData for this instance. Must be provided by concrete
   * implementations.
   * 
   * @return LocaleData
   */
  public abstract ILocaleData getLocaleData ();

  @Override
  public final DateFormat getDateInstance (final int style, final Locale locale)
  {
    getLocaleData ().checkLocaleSupported (locale);

    final String format = _selectDateFormatForStyle (style);
    return new SimpleDateFormat (format, new LocaleDateFormatSymbols (getLocaleData ()));
  }

  @Override
  public final DateFormat getDateTimeInstance (final int dateStyle, final int timeStyle, final Locale locale)
  {
    getLocaleData ().checkLocaleSupported (locale);

    final String format = _selectDateFormatForStyle (dateStyle) + " " + _selectTimeFormatForStyle (timeStyle);
    return new SimpleDateFormat (format, new LocaleDateFormatSymbols (getLocaleData ()));
  }

  @Override
  public final DateFormat getTimeInstance (final int style, final Locale locale)
  {
    getLocaleData ().checkLocaleSupported (locale);

    final String format = _selectTimeFormatForStyle (style);
    return new SimpleDateFormat (format, new LocaleDateFormatSymbols (getLocaleData ()));
  }

  private String _selectDateFormatForStyle (final int style)
  {
    String format = null;
    switch (style)
    {
      case DateFormat.FULL:
        format = getLocaleData ().getDateFull ();
        break;
      case DateFormat.LONG:
        format = getLocaleData ().getDateLong ();
        break;
      case DateFormat.MEDIUM:
        format = getLocaleData ().getDateMedium ();
        break;
      case DateFormat.SHORT:
        format = getLocaleData ().getDateShort ();
        break;
      default:
        throw new IllegalArgumentException ("unsupported style " + style);
    }
    return format;
  }

  private String _selectTimeFormatForStyle (final int style)
  {
    String format = null;
    switch (style)
    {
      case DateFormat.FULL:
        format = getLocaleData ().getTimeFull ();
        break;
      case DateFormat.LONG:
        format = getLocaleData ().getTimeLong ();
        break;
      case DateFormat.MEDIUM:
        format = getLocaleData ().getTimeMedium ();
        break;
      case DateFormat.SHORT:
        format = getLocaleData ().getTimeShort ();
        break;
      default:
        throw new IllegalArgumentException ("unsupported style " + style);
    }
    return format;
  }

  @Override
  public final Locale [] getAvailableLocales ()
  {
    return getLocaleData ().getSupportedLocales ();
  }
}
