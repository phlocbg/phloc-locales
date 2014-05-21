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

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.spi.NumberFormatProvider;
import java.util.Locale;

public abstract class AbstractLocaleNumberFormatProvider extends NumberFormatProvider
{
  /**
   * Get LocaleData for this instance. Must be provided by concrete
   * implementations.
   * 
   * @return LocaleData
   */
  public abstract ILocaleData getLocaleData ();

  @Override
  public final NumberFormat getCurrencyInstance (final Locale locale)
  {
    getLocaleData ().checkLocaleSupported (locale);

    final DecimalFormat currencyInstance = new DecimalFormat (getLocaleData ().getCurrencyFormat (),
                                                              new LocaleDecimalFormatSymbols (getLocaleData ()));
    currencyInstance.setRoundingMode (RoundingMode.HALF_UP);

    return currencyInstance;
  }

  @Override
  public final NumberFormat getIntegerInstance (final Locale locale)
  {
    getLocaleData ().checkLocaleSupported (locale);

    final DecimalFormat integerInstance = new DecimalFormat (getLocaleData ().getIntegerFormat (),
                                                             new LocaleDecimalFormatSymbols (getLocaleData ()));

    // following settings are required by contract for this method
    integerInstance.setParseIntegerOnly (true);
    integerInstance.setRoundingMode (RoundingMode.HALF_EVEN);

    return integerInstance;
  }

  @Override
  public final NumberFormat getNumberInstance (final Locale locale)
  {
    getLocaleData ().checkLocaleSupported (locale);

    final DecimalFormat instance = new DecimalFormat (getLocaleData ().getNumberFormat (),
                                                      new LocaleDecimalFormatSymbols (getLocaleData ()));
    instance.setRoundingMode (RoundingMode.HALF_UP);

    return instance;
  }

  @Override
  public final NumberFormat getPercentInstance (final Locale locale)
  {
    getLocaleData ().checkLocaleSupported (locale);

    final DecimalFormat percentInstance = new DecimalFormat (getLocaleData ().getPercentFormat (),
                                                             new LocaleDecimalFormatSymbols (getLocaleData ()));
    percentInstance.setRoundingMode (RoundingMode.HALF_UP);

    return percentInstance;
  }

  @Override
  public final Locale [] getAvailableLocales ()
  {
    return getLocaleData ().getSupportedLocales ();
  }
}
