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

import java.text.BreakIterator;
import java.text.spi.BreakIteratorProvider;
import java.util.Locale;

import com.phloc.locales.gl.GalicianLocales;

public final class GalicianBreakIteratorProvider extends BreakIteratorProvider
{
  public GalicianBreakIteratorProvider ()
  {}

  @Override
  public BreakIterator getCharacterInstance (final Locale locale)
  {
    if (locale == null)
      throw new NullPointerException ();
    if (GalicianLocales.GALICIAN_LIST.contains (locale))
      return BreakIterator.getCharacterInstance (GalicianLocales.CASTILIAN);

    throw new IllegalArgumentException ("Locale \"" +
                                        locale +
                                        "\" " +
                                        "is not one of the supported locales (" +
                                        GalicianLocales.GALICIAN_LIST +
                                        ")");
  }

  @Override
  public BreakIterator getLineInstance (final Locale locale)
  {
    if (locale == null)
      throw new NullPointerException ();
    if (GalicianLocales.GALICIAN_LIST.contains (locale))
      return BreakIterator.getLineInstance (GalicianLocales.CASTILIAN);
    throw new IllegalArgumentException ("Locale \"" +
                                        locale +
                                        "\" " +
                                        "is not one of the supported locales (" +
                                        GalicianLocales.GALICIAN_LIST +
                                        ")");
  }

  @Override
  public BreakIterator getSentenceInstance (final Locale locale)
  {
    if (locale == null)
    {
      throw new NullPointerException ();
    }
    if (GalicianLocales.GALICIAN_LIST.contains (locale))
    {
      return BreakIterator.getSentenceInstance (GalicianLocales.CASTILIAN);
    }
    throw new IllegalArgumentException ("Locale \"" +
                                        locale +
                                        "\" " +
                                        "is not one of the supported locales (" +
                                        GalicianLocales.GALICIAN_LIST +
                                        ")");
  }

  @Override
  public BreakIterator getWordInstance (final Locale locale)
  {
    if (locale == null)
      throw new NullPointerException ();
    if (GalicianLocales.GALICIAN_LIST.contains (locale))
      return BreakIterator.getWordInstance (GalicianLocales.CASTILIAN);
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
