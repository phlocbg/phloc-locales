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
package com.phloc.locales;

import java.text.DecimalFormatSymbols;

public class LocaleDecimalFormatSymbols extends DecimalFormatSymbols
{
  private final ILocaleData m_aLocaleData;

  /**
   * @param aLocaleData
   *        Never <code>null</code>
   */
  public LocaleDecimalFormatSymbols (final ILocaleData aLocaleData)
  {
    m_aLocaleData = aLocaleData;
    initializeFields ();
  }

  protected void initializeFields ()
  {
    setDecimalSeparator (m_aLocaleData.getDecimalSeparator ());
    setGroupingSeparator (m_aLocaleData.getGroupingSeparator ());
    setPatternSeparator (m_aLocaleData.getPatternSeparator ());
    setPercent (m_aLocaleData.getPercent ());
    setZeroDigit (m_aLocaleData.getZeroDigit ());
    setDigit (m_aLocaleData.getDigit ());
    setMinusSign (m_aLocaleData.getMinusSign ());
    setExponentSeparator (m_aLocaleData.getExponentSeparator ());
    setPerMill (m_aLocaleData.getPerMille ());
    setInfinity (m_aLocaleData.getInfinity ());
    setNaN (m_aLocaleData.getNaN ());
    setCurrencySymbol (m_aLocaleData.getCurrencySymbol ());
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
