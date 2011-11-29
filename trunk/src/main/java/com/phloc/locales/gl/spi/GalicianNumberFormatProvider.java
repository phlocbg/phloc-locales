/*
 * =============================================================================
 * 
 *   Copyright (c) 2008, The JAVAGALICIAN team (http://www.javagalician.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package com.phloc.locales.gl.spi;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.spi.NumberFormatProvider;
import java.util.Locale;

import com.phloc.locales.gl.GalicianDecimalFormatSymbols;
import com.phloc.locales.gl.Locales;

public final class GalicianNumberFormatProvider extends NumberFormatProvider
{

  public GalicianNumberFormatProvider ()
  {
    super ();
  }

  @Override
  public NumberFormat getCurrencyInstance (final Locale locale)
  {
    if (locale == null)
    {
      throw new NullPointerException ();
    }
    if (Locales.GALICIAN_LIST.contains (locale))
    {
      final NumberFormat format = NumberFormat.getCurrencyInstance (Locales.CASTILIAN);
      if (format instanceof DecimalFormat)
      {
        ((DecimalFormat) format).setDecimalFormatSymbols (new GalicianDecimalFormatSymbols ());
      }
      return format;
    }
    throw new IllegalArgumentException ("Locale \"" +
                                        locale +
                                        "\" " +
                                        "is not one of the supported locales (" +
                                        Locales.GALICIAN_LIST +
                                        ")");
  }

  @Override
  public NumberFormat getIntegerInstance (final Locale locale)
  {
    if (locale == null)
    {
      throw new NullPointerException ();
    }
    if (Locales.GALICIAN_LIST.contains (locale))
    {
      final NumberFormat format = NumberFormat.getIntegerInstance (Locales.CASTILIAN);
      if (format instanceof DecimalFormat)
      {
        ((DecimalFormat) format).setDecimalFormatSymbols (new GalicianDecimalFormatSymbols ());
      }
      return format;
    }
    throw new IllegalArgumentException ("Locale \"" +
                                        locale +
                                        "\" " +
                                        "is not one of the supported locales (" +
                                        Locales.GALICIAN_LIST +
                                        ")");
  }

  @Override
  public NumberFormat getNumberInstance (final Locale locale)
  {
    if (locale == null)
    {
      throw new NullPointerException ();
    }
    if (Locales.GALICIAN_LIST.contains (locale))
    {
      final NumberFormat format = NumberFormat.getNumberInstance (Locales.CASTILIAN);
      if (format instanceof DecimalFormat)
      {
        ((DecimalFormat) format).setDecimalFormatSymbols (new GalicianDecimalFormatSymbols ());
      }
      return format;
    }
    throw new IllegalArgumentException ("Locale \"" +
                                        locale +
                                        "\" " +
                                        "is not one of the supported locales (" +
                                        Locales.GALICIAN_LIST +
                                        ")");
  }

  @Override
  public NumberFormat getPercentInstance (final Locale locale)
  {
    if (locale == null)
    {
      throw new NullPointerException ();
    }
    if (Locales.GALICIAN_LIST.contains (locale))
    {
      final NumberFormat format = NumberFormat.getPercentInstance (Locales.CASTILIAN);
      if (format instanceof DecimalFormat)
      {
        ((DecimalFormat) format).setDecimalFormatSymbols (new GalicianDecimalFormatSymbols ());
      }
      return format;
    }
    throw new IllegalArgumentException ("Locale \"" +
                                        locale +
                                        "\" " +
                                        "is not one of the supported locales (" +
                                        Locales.GALICIAN_LIST +
                                        ")");
  }

  @Override
  public Locale [] getAvailableLocales ()
  {
    return Locales.GALICIAN_ARRAY;
  }

}
