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
