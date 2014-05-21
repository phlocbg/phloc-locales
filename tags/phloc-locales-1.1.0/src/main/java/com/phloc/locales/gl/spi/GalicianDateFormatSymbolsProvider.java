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

import java.text.DateFormatSymbols;
import java.text.spi.DateFormatSymbolsProvider;
import java.util.Locale;

import com.phloc.locales.gl.GalicianLocales;
import com.phloc.locales.gl.GalicianDateFormatSymbols;

public final class GalicianDateFormatSymbolsProvider extends DateFormatSymbolsProvider
{

  public GalicianDateFormatSymbolsProvider ()
  {
    super ();
  }

  @Override
  public DateFormatSymbols getInstance (final Locale locale)
  {
    if (locale == null)
    {
      throw new NullPointerException ();
    }
    if (GalicianLocales.GALICIAN_LIST.contains (locale))
    {
      return new GalicianDateFormatSymbols ();
    }
    throw new IllegalArgumentException ("Locale \"" +
                                        locale +
                                        "\" " +
                                        "is not one of the supported locales (" +
                                        GalicianLocales.GALICIAN_LIST +
                                        ")");
  }

  @Override
  public Locale [] getAvailableLocales ()
  {
    return GalicianLocales.getLocaleArray ();
  }

}
