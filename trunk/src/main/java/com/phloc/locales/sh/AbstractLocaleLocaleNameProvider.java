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
package com.phloc.locales.sh;

import java.util.Locale;
import java.util.spi.LocaleNameProvider;

public abstract class AbstractLocaleLocaleNameProvider extends LocaleNameProvider
{
  /**
   * Get LocaleData for this instance. Must be provided by concrete
   * implementations.
   * 
   * @return LocaleData
   */
  public abstract ILocaleData getLocaleData ();

  @Override
  public final String getDisplayCountry (final String countryCode, final Locale locale)
  {
    getLocaleData ().checkLocaleSupported (locale);

    if (_badCountryCodeFormat (countryCode))
      throw new IllegalArgumentException ("country code not in required format");

    for (final String [] tuple : getLocaleData ().getCountryTuples ())
    {
      final String key = tuple[0];
      final String value = tuple[1];
      if (key.equals (countryCode))
        return value;
    }
    return null;
  }

  private static boolean _badCountryCodeFormat (final String countryCode)
  {
    return countryCode.length () != 2 ||
           Character.isLowerCase (countryCode.charAt (0)) ||
           Character.isLowerCase (countryCode.charAt (1));
  }

  @Override
  public final String getDisplayLanguage (final String languageCode, final Locale locale)
  {
    getLocaleData ().checkLocaleSupported (locale);

    if (_badLanguageCodeFormat (languageCode))
      throw new IllegalArgumentException ("language code not in required format");

    for (final String [] tuple : getLocaleData ().getLanguageTuples ())
    {
      final String key = tuple[0];
      final String value = tuple[1];
      if (key.equals (languageCode))
        return value;
    }
    return null;
  }

  private static boolean _badLanguageCodeFormat (final String languageCode)
  {
    return languageCode.length () != 2 ||
           Character.isUpperCase (languageCode.charAt (0)) ||
           Character.isUpperCase (languageCode.charAt (1));
  }

  @Override
  public final String getDisplayVariant (final String variant, final Locale locale)
  {
    return null;
  }

  @Override
  public final Locale [] getAvailableLocales ()
  {
    return getLocaleData ().getSupportedLocales ();
  }
}
