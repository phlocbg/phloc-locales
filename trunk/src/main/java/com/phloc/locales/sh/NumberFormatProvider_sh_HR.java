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


/**
 * A NumberFormatProvider for the Serbocroatian language, Croatian variant.
 * 
 * @author Klaus Brunner
 */
public class NumberFormatProvider_sh_HR extends AbstractLocaleNumberFormatProvider
{
  private static final ILocaleData s_aLocaleData = new Serbocroatian_HR ();

  @Override
  public ILocaleData getLocaleData ()
  {
    return s_aLocaleData;
  }
}
