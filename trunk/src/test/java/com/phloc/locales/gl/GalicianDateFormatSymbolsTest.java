/**
 * Copyright (C) 2006-2012 phloc systems
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
package com.phloc.locales.gl;

import java.util.Calendar;
import java.util.TimeZone;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.phloc.locales.gl.GalicianDateFormatSymbols;
import com.phloc.locales.gl.GalicianLocales;
import com.phloc.locales.gl.spi.GalicianTimeZoneNameProvider;

/**
 * Test class for class {@link GalicianDateFormatSymbols}.
 */
public final class GalicianDateFormatSymbolsTest
{
  private GalicianDateFormatSymbols m_aDateFormatSymbols;

  @Before
  public void setUp ()
  {
    m_aDateFormatSymbols = new GalicianDateFormatSymbols ();
  }

  @Test
  public void testWeekdays () throws Exception
  {
    Assert.assertEquals ("luns", m_aDateFormatSymbols.getWeekdays ()[Calendar.MONDAY]);
    Assert.assertEquals ("xoves", m_aDateFormatSymbols.getWeekdays ()[Calendar.THURSDAY]);
    Assert.assertEquals ("venres", m_aDateFormatSymbols.getWeekdays ()[Calendar.FRIDAY]);
  }

  @Test
  public void testTimeZoneNames () throws Exception
  {
    final TimeZone timeZone1 = TimeZone.getTimeZone ("CEST");
    System.out.println (timeZone1.getDisplayName (GalicianLocales.GALICIAN_ES));
    System.out.println (timeZone1.getDisplayName (GalicianLocales.CASTILIAN));
    final GalicianTimeZoneNameProvider prov = new GalicianTimeZoneNameProvider ();
    System.out.println ("-" + prov.getDisplayName ("CEST", false, TimeZone.LONG, GalicianLocales.GALICIAN_ES) + "-");
  }
}
