/**
 * Copyright (C) 2006-2011 phloc systems
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

import java.text.DateFormatSymbols;

public class LocaleDateFormatSymbols extends DateFormatSymbols
{
  private final ILocaleData m_aLocaleData;

  /**
   * @param aLocaleData
   *        never <code>null</code>.
   */
  public LocaleDateFormatSymbols (final ILocaleData aLocaleData)
  {
    m_aLocaleData = aLocaleData;
    initializeFields ();
  }

  protected void initializeFields ()
  {
    setEras (m_aLocaleData.getEras ());
    setLocalPatternChars (m_aLocaleData.getPatternChars ());
    setMonths (m_aLocaleData.getMonths ());
    setShortMonths (m_aLocaleData.getShortMonths ());
    setWeekdays (m_aLocaleData.getWeekdays ());
    setShortWeekdays (m_aLocaleData.getShortWeekdays ());
  }

  @Override
  public boolean equals (final Object o)
  {
    return super.equals (o);
  }

  @Override
  public int hashCode ()
  {
    return super.hashCode ();
  }
}
