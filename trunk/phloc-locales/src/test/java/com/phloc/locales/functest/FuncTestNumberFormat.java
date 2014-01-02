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
package com.phloc.locales.functest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.net.URL;
import java.text.NumberFormat;
import java.text.spi.NumberFormatProvider;
import java.util.Locale;

import org.junit.Test;

import com.phloc.locales.sh.spi.NumberFormatProvider_sh;
import com.phloc.locales.sh.spi.NumberFormatProvider_sh_RS;

public final class FuncTestNumberFormat
{
  private static final Locale BOSNIAN_LOCALE = new Locale ("bs");
  private static final Locale SH_RS_LOCALE = new Locale ("sh", "RS");

  private static final double TEST_DOUBLE = 1234.565d;

  @Test (expected = IllegalArgumentException.class)
  public void providerChecksInvalidLocale ()
  {
    final NumberFormatProvider provider = new NumberFormatProvider_sh ();
    provider.getNumberInstance (new Locale ("??", "!!"));
  }

  @Test (expected = NullPointerException.class)
  public void providerChecksNullLocale ()
  {
    final NumberFormatProvider provider = new NumberFormatProvider_sh ();
    provider.getNumberInstance (null);
  }

  @Test
  public void testGetCurrencyInstanceLocale ()
  {
    final NumberFormatProvider provider = new NumberFormatProvider_sh ();
    final NumberFormat format = provider.getCurrencyInstance (BOSNIAN_LOCALE);
    final String formatted = format.format (TEST_DOUBLE);
    assertEquals ("¤ 1.234,57", formatted);
  }

  @Test
  public void testGetCurrencyInstanceLocaleSerbian ()
  {
    final NumberFormatProvider provider = new NumberFormatProvider_sh_RS ();
    final NumberFormat format = provider.getCurrencyInstance (SH_RS_LOCALE);
    final String formatted = format.format (TEST_DOUBLE);
    assertEquals ("RSD 1.234,57", formatted);
  }

  @Test
  public void testGetIntegerInstanceLocale ()
  {
    final NumberFormatProvider provider = new NumberFormatProvider_sh ();
    final NumberFormat format = provider.getIntegerInstance (BOSNIAN_LOCALE);
    final String formatted = format.format (TEST_DOUBLE);
    assertEquals ("1.235", formatted);
  }

  @Test
  public void testGetNumberInstanceLocale ()
  {
    final NumberFormatProvider provider = new NumberFormatProvider_sh ();
    final NumberFormat format = provider.getNumberInstance (BOSNIAN_LOCALE);
    final String formatted = format.format (TEST_DOUBLE);
    assertEquals ("1.234,565", formatted);
  }

  @Test
  public void testGetPercentInstanceLocale ()
  {
    final NumberFormatProvider provider = new NumberFormatProvider_sh ();
    final NumberFormat format = provider.getPercentInstance (BOSNIAN_LOCALE);
    final String formatted = format.format (TEST_DOUBLE);
    assertEquals ("123.457%", formatted);
  }

  @Test
  public void checkSpiDeclaration ()
  {
    // check that SPI "declaration file" exists
    final URL spifile = Thread.currentThread ()
                              .getContextClassLoader ()
                              .getResource ("META-INF/services/java.text.spi.NumberFormatProvider");
    assertNotNull (spifile);
  }
}
