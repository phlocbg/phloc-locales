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

import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;


/**
 * Various locale settings for the Serbocroatian languages (mostly Bosnian
 * usage).
 * 
 * @author Klaus Brunner
 */
public class Serbocroatian implements ILocaleData
{
  protected static final String SERBOCROATIAN_LANGUAGE = "sh";
  protected static final String BOSNIAN_LANGUAGE = "bs";
  protected static final String CROATIA_COUNTRY = "HR";
  private static final Locale HR_LOCALE = new Locale (CROATIA_COUNTRY);

  private static final Locale [] SUPPORTED_LOCALES = { new Locale (BOSNIAN_LANGUAGE),
                                                      new Locale (SERBOCROATIAN_LANGUAGE) };

  private static final String [] ERAS = { "p.n.e.", "n.e." };

  private static final String PATTERN_CHARS = "GanjkHmsSEDFwWxhKzZ";

  private static final String [] MONTHS = { "januar",
                                           "februar",
                                           "mart",
                                           "april",
                                           "maj",
                                           "juni",
                                           "juli",
                                           "avgust",
                                           "septembar",
                                           "oktobar",
                                           "novembar",
                                           "decembar" };

  private static final String [] SHORT_MONTHS = { "jan",
                                                 "feb",
                                                 "mar",
                                                 "apr",
                                                 "maj",
                                                 "jun",
                                                 "jul",
                                                 "avg",
                                                 "sep",
                                                 "okt",
                                                 "nov",
                                                 "dec" };

  private static final String [] WEEKDAYS = { "",
                                             "nedjelja",
                                             "ponedjeljak",
                                             "utorak",
                                             "srijeda",
                                             "četvrtak",
                                             "petak",
                                             "subota" };

  private static final String [] SHORT_WEEKDAYS = { "", "ned", "pon", "uto", "sri", "čet", "pet", "sub" };

  private static final String DATE_SHORT = "dd.MM.yy.";
  private static final String DATE_MEDIUM = "dd.MM.yyyy.";
  private static final String DATE_LONG = "d. MMMM yyyy.";
  private static final String DATE_FULL = "EEEE, d. MMMM yyyy.";

  private static final String TIME_SHORT = "HH:mm";
  private static final String TIME_MEDIUM = "HH:mm:ss";
  private static final String TIME_LONG = "HH:mm:ss z";
  private static final String TIME_FULL = "HH:mm:ss z";

  private static final char DECIMAL_SEPARATOR = ',';
  private static final char GROUPING_SEPARATOR = '.';
  private static final char PATTERN_SEPARATOR = ';';
  private static final char PERCENT = '%';
  private static final char ZERO_DIGIT = '0';
  private static final char DIGIT = '#';
  private static final char MINUS_SIGN = '-';
  private static final String EXPONENT_SEPARATOR = "E";
  private static final char PER_MILLE = '‰';
  private static final String INFINITY = "∞";
  private static final String NAN = "NaN"; // TODO: is there anything better?
  private static final String CURRENCY_SYMBOL = "¤"; // generic currency symbol
  private static final String PERCENT_FORMAT = "#,##0%";
  private static final String NUMBER_FORMAT = "#,##0.###";
  private static final String INTEGER_FORMAT = "#,##0";
  private static final String CURRENCY_FORMAT = "¤ #,##0.00";

  private static final String [][] COUNTRY_TUPLES = { { "AD", "Andora" },
                                                     { "AE", "Ujedinjeni Arapski Emirati" },
                                                     { "AF", "Avganistan" },
                                                     { "AG", "Antigua i Barbuda" },
                                                     { "AI", "Anguila" },
                                                     { "AL", "Albanija" },
                                                     { "AM", "Jermenija" },
                                                     { "AN", "Holandski Antili" },
                                                     { "AO", "Angola" },
                                                     { "AQ", "Antartik" },
                                                     { "AR", "Argentina" },
                                                     { "AS", "Američka Samoa" },
                                                     { "AT", "Austrija" },
                                                     { "AU", "Australija" },
                                                     { "AW", "Aruba" },
                                                     { "AX", "Aalanska Ostrva" },
                                                     { "AZ", "Azerbejdžan" },
                                                     { "BA", "Bosna i Hercegovina" },
                                                     { "BB", "Barbados" },
                                                     { "BD", "Bangladeš" },
                                                     { "BE", "Belgija" },
                                                     { "BF", "Burkina Faso" },
                                                     { "BG", "Bugarska" },
                                                     { "BH", "Bahrein" },
                                                     { "BI", "Burundi" },
                                                     { "BJ", "Benin" },
                                                     { "BM", "Bermuda" },
                                                     { "BN", "Bruneji" },
                                                     { "BO", "Bolivija" },
                                                     { "BR", "Brazil" },
                                                     { "BS", "Bahami" },
                                                     { "BT", "Butan" },
                                                     { "BV", "Buve Ostrvo" },
                                                     { "BW", "Bocvana" },
                                                     { "BY", "Belorusija" },
                                                     { "BZ", "Belize" },
                                                     { "CA", "Kanada" },
                                                     { "CC", "Kokosova (Kiling) Ostrva" },
                                                     { "CD", "Demokratska Republika Kongo (bivši Zair)" },
                                                     { "CF", "Centralnoafrička Republika" },
                                                     { "CG", "Republika Kongo" },
                                                     { "CH", "Švajcarska" },
                                                     { "CI", "Obala Slonovače" },
                                                     { "CK", "Kukova Ostrva" },
                                                     { "CL", "Čile" },
                                                     { "CM", "Kamerun" },
                                                     { "CN", "Kina" },
                                                     { "CO", "Kolumbija" },
                                                     { "CR", "Kostarika" },
                                                     { "CU", "Kuba" },
                                                     { "CV", "Zelenortska Ostrva" },
                                                     { "CX", "Božićno Ostrvo" },
                                                     { "CY", "Kipar" },
                                                     { "CZ", "Češka Republika" },
                                                     { "DE", "Nemačka" },
                                                     { "DJ", "Džibuti" },
                                                     { "DK", "Danska" },
                                                     { "DM", "Dominika" },
                                                     { "DO", "Dominikanska Republika" },
                                                     { "DZ", "Alžir" },
                                                     { "EC", "Ekvador" },
                                                     { "EE", "Estonija" },
                                                     { "EG", "Egipat" },
                                                     { "EH", "Zapadna Sahara" },
                                                     { "ER", "Eritreja" },
                                                     { "ES", "Španija" },
                                                     { "ET", "Etiopija" },
                                                     { "FI", "Finska" },
                                                     { "FJ", "Fidži" },
                                                     { "FK", "Foklandska (Malvinska) Ostrva" },
                                                     { "FM", "Federalne Države Mikronezije" },
                                                     { "FO", "Farska Ostrva" },
                                                     { "FR", "Francuska" },
                                                     { "GA", "Gabon" },
                                                     { "GB", "Ujedinjeno Kraljevstvo" },
                                                     { "GD", "Grenada" },
                                                     { "GE", "Gruzija" },
                                                     { "GF", "Francuska Gvajana" },
                                                     { "GG", "Gernzi" },
                                                     { "GH", "Gana" },
                                                     { "GI", "Gibraltar" },
                                                     { "GL", "Grenland" },
                                                     { "GM", "Gambija" },
                                                     { "GN", "Gvineja" },
                                                     { "GP", "Gvadalupe" },
                                                     { "GQ", "Ekvatorijalna Gvineja" },
                                                     { "GR", "Grčka" },
                                                     { "GS", "Južna Džordžija i Južna Sedvička Ostrva" },
                                                     { "GT", "Gvatemala" },
                                                     { "GU", "Guam" },
                                                     { "GW", "Gvineja Bisao" },
                                                     { "GY", "Gvajana" },
                                                     { "HK", "Hong Kong" },
                                                     { "HM", "Ostrva Herd i Makdonald" },
                                                     { "HN", "Honduras" },
                                                     { "HR", "Hrvatska" },
                                                     { "HT", "Haiti" },
                                                     { "HU", "Mađarska" },
                                                     { "ID", "Indonezija" },
                                                     { "IE", "Irska" },
                                                     { "IL", "Izrael" },
                                                     { "IM", "Ostrvo Man" },
                                                     { "IN", "Indija" },
                                                     { "IO", "Britanska Teritorija Indijskog Okeana" },
                                                     { "IQ", "Irak" },
                                                     { "IR", "Iran (Islamska Republika)" },
                                                     { "IS", "Island" },
                                                     { "IT", "Italija" },
                                                     { "JE", "Džerzi" },
                                                     { "JM", "Jamajka" },
                                                     { "JO", "Džordan" },
                                                     { "JP", "Japan" },
                                                     { "KE", "Kenija" },
                                                     { "KG", "Kirgistan" },
                                                     { "KH", "Kambodža" },
                                                     { "KI", "Kiribati" },
                                                     { "KM", "Komori" },
                                                     { "KN", "Sent Kits i Nevis" },
                                                     { "KP", "Demokratska Narodna Republika Koreja" },
                                                     { "KR", "Republika Koreja" },
                                                     { "KW", "Kuvajt" },
                                                     { "KY", "Kajmanova Ostrva" },
                                                     { "KZ", "Kazahstan" },
                                                     { "LA", "Demokratska Narodna Republika Laos" },
                                                     { "LB", "Liban" },
                                                     { "LC", "Sveta Lucija" },
                                                     { "LI", "Lihtenštajn" },
                                                     { "LK", "Šri Lanka" },
                                                     { "LR", "Liberija" },
                                                     { "LS", "Lesoto" },
                                                     { "LT", "Litvanija" },
                                                     { "LU", "Luksemburg" },
                                                     { "LV", "Letonija" },
                                                     { "LY", "Libija" },
                                                     { "MA", "Maroko" },
                                                     { "MC", "Monako" },
                                                     { "MD", "Republika Moldavija" },
                                                     { "MD_CH", "Kišinjev" },
                                                     { "ME", "Crna Gora" },
                                                     { "MG", "Madagaskar" },
                                                     { "MH", "Maršalska Ostrva" },
                                                     { "MK", "Bivša Jugoslovanska Republika Makedonija" },
                                                     { "ML", "Mali" },
                                                     { "MM", "Mjanmar" },
                                                     { "MN", "Mongolija" },
                                                     { "MO", "Makao" },
                                                     { "MP", "Severna Marijanska Ostrva" },
                                                     { "MQ", "Martinik" },
                                                     { "MR", "Mauritanija" },
                                                     { "MS", "Montserat" },
                                                     { "MT", "Malta" },
                                                     { "MU", "Mauricijus" },
                                                     { "MV", "Maldivi" },
                                                     { "MW", "Malavi" },
                                                     { "MX", "Meksiko" },
                                                     { "MY", "Malezija" },
                                                     { "MZ", "Mozambik" },
                                                     { "NA", "Namibija" },
                                                     { "NC", "Nova Kaledonija" },
                                                     { "NE", "Niger" },
                                                     { "NF", "Norfolk Ostrvo" },
                                                     { "NG", "Nigerija" },
                                                     { "NI", "Nikaragva" },
                                                     { "NL", "Holandija" },
                                                     { "NO", "Norveška" },
                                                     { "NP", "Nepal" },
                                                     { "NR", "Nauru" },
                                                     { "NU", "Nijue" },
                                                     { "NZ", "Novi Zeland" },
                                                     { "OM", "Oman" },
                                                     { "PA", "Panama" },
                                                     { "PE", "Peru" },
                                                     { "PF", "Francuska Polinezija" },
                                                     { "PG", "Papua Nova Gvineja" },
                                                     { "PH", "Filipini" },
                                                     { "PK", "Pakistan" },
                                                     { "PL", "Poljska" },
                                                     { "PM", "Sent Pjer i Mikelon" },
                                                     { "PN", "Pitkern" },
                                                     { "PR", "Portoriko" },
                                                     { "PS", "Palestinska Okupirana Teritorija" },
                                                     { "PT", "Portugal" },
                                                     { "PW", "Palau" },
                                                     { "PY", "Paragvaj" },
                                                     { "QA", "Katar" },
                                                     { "RE", "Reinion" },
                                                     { "RO", "Rumunija" },
                                                     { "RS", "Srbija" },
                                                     { "RU", "Ruska Federacija" },
                                                     { "RW", "Ruanda" },
                                                     { "SA", "Saudijska Arabija" },
                                                     { "SB", "Solomonova Ostrva" },
                                                     { "SC", "Sejšeli" },
                                                     { "SD", "Sudan" },
                                                     { "SE", "Švedska" },
                                                     { "SG", "Singapur" },
                                                     { "SH", "Sveta Helena" },
                                                     { "SI", "Slovenija" },
                                                     { "SJ", "Svalbard i Jan Majen Ostrva" },
                                                     { "SK", "Slovačka" },
                                                     { "SL", "Sijera Leone" },
                                                     { "SM", "San Marino" },
                                                     { "SN", "Senegal" },
                                                     { "SO", "Somalija" },
                                                     { "SR", "Surinam" },
                                                     { "ST", "Sao Tome i Principe" },
                                                     { "SV", "El Salvador" },
                                                     { "SY", "Sirija" },
                                                     { "SZ", "Svaziland" },
                                                     { "TC", "Turks i Kajkos Ostrva" },
                                                     { "TD", "Čad" },
                                                     { "TF", "Francuske Prekomorske Teritorije" },
                                                     { "TG", "Togo" },
                                                     { "TH", "Tajland" },
                                                     { "TJ", "Tadžikistan" },
                                                     { "TK", "Tokelau" },
                                                     { "TL", "Istočni Timor" },
                                                     { "TM", "Turkmenistan" },
                                                     { "TN", "Tunis" },
                                                     { "TO", "Tonga" },
                                                     { "TR", "Turska" },
                                                     { "TT", "Trinidad i Tobago" },
                                                     { "TV", "Tuvalu" },
                                                     { "TW", "Tajvan" },
                                                     { "TZ", "Ujedinjena Republika Tanzanija" },
                                                     { "UA", "Ukrajna" },
                                                     { "UG", "Uganda" },
                                                     { "UK", "Ujedinjeno Kraljevstvo Velike Britanije" },
                                                     { "UM", "Ujedinjene Države Malih Ostrva" },
                                                     { "US", "Sjedinjene Američke Države" },
                                                     { "UY", "Urugvaj" },
                                                     { "UZ", "Uzbekistan" },
                                                     { "VA", "Vatikan Grad Država (Sveta Stolica)" },
                                                     { "VC", "Sent Vinsent i Grenadini" },
                                                     { "VE", "Venecuela" },
                                                     { "VG", "Devičanska Ostrva (Britanska)" },
                                                     { "VI", "Devičanska Ostrva (SAD)" },
                                                     { "VN", "Vijetnam" },
                                                     { "VU", "Vanuatu" },
                                                     { "WF", "Valis i Futuna Ostrva" },
                                                     { "WS", "Samoa" },
                                                     { "YE", "Jemen" },
                                                     { "YT", "Majot" },
                                                     { "ZA", "Južnoafrička Republika" },
                                                     { "ZM", "Zambija" },
                                                     { "ZW", "Zimbabve" },
                                                     // Obsoleted ones
                                                     { "CS", "Srbija i Crna Gora" },
                                                     { "YU", "Jugoslavija" } };

  private static final String [][] LANGUAGE_TUPLES = { { "en", "engleski" },
                                                      { "bs", "bosanski" },
                                                      { "hr", "hrvatski" },
                                                      { "sr", "srpski" },
                                                      { "sl", "slovenski" },
                                                      { "mk", "makedonski" },
                                                      { "sh", "srpskohrvatski" },
                                                      // To display SH in its
                                                      // own locale
                                                      { "sh", "srpski" }, };

  public void checkLocaleSupported (final Locale aLocale)
  {
    if (aLocale == null)
      throw new NullPointerException ("locale must not be null");

    // exact search
    for (final Locale aSupported : getSupportedLocales ())
      if (aLocale.equals (aSupported))
        return;

    // relaxed search (seems to be necessary, but might also be a trouble
    // spot?)
    for (final Locale aSupported : getSupportedLocales ())
      if (aLocale.getLanguage ().equals (aSupported.getLanguage ()))
        return;

    throw new IllegalArgumentException ("unsupported locale " + aLocale);
  }

  public String [][] getCountryTuples ()
  {
    return Arrays.copyOf (COUNTRY_TUPLES, COUNTRY_TUPLES.length);
  }

  public String getCurrencyFormat ()
  {
    return CURRENCY_FORMAT;
  }

  public String getCurrencySymbol ()
  {
    return CURRENCY_SYMBOL;
  }

  public String getDateFull ()
  {
    return DATE_FULL;
  }

  public String getDateLong ()
  {
    return DATE_LONG;
  }

  public String getDateMedium ()
  {
    return DATE_MEDIUM;
  }

  public String getDateShort ()
  {
    return DATE_SHORT;
  }

  public char getDecimalSeparator ()
  {
    return DECIMAL_SEPARATOR;
  }

  public char getDigit ()
  {
    return DIGIT;
  }

  public String [] getEras ()
  {
    return Arrays.copyOf (ERAS, ERAS.length);
  }

  public String getExponentSeparator ()
  {
    return EXPONENT_SEPARATOR;
  }

  public char getGroupingSeparator ()
  {
    return GROUPING_SEPARATOR;
  }

  public String getInfinity ()
  {
    return INFINITY;
  }

  public String getIntegerFormat ()
  {
    return INTEGER_FORMAT;
  }

  public String [][] getLanguageTuples ()
  {
    return Arrays.copyOf (LANGUAGE_TUPLES, LANGUAGE_TUPLES.length);
  }

  public char getMinusSign ()
  {
    return MINUS_SIGN;
  }

  public String [] getMonths ()
  {
    return Arrays.copyOf (MONTHS, MONTHS.length);
  }

  public String getNaN ()
  {
    return NAN;
  }

  public String getNumberFormat ()
  {
    return NUMBER_FORMAT;
  }

  public String getPatternChars ()
  {
    return PATTERN_CHARS;
  }

  public char getPatternSeparator ()
  {
    return PATTERN_SEPARATOR;
  }

  public char getPercent ()
  {
    return PERCENT;
  }

  public String getPercentFormat ()
  {
    return PERCENT_FORMAT;
  }

  public char getPerMille ()
  {
    return PER_MILLE;
  }

  public String [] getShortMonths ()
  {
    return Arrays.copyOf (SHORT_MONTHS, SHORT_MONTHS.length);
  }

  public String [] getShortWeekdays ()
  {
    return Arrays.copyOf (SHORT_WEEKDAYS, SHORT_WEEKDAYS.length);
  }

  public Locale [] getSupportedLocales ()
  {
    return Arrays.copyOf (SUPPORTED_LOCALES, SUPPORTED_LOCALES.length);
  }

  public String getTimeFull ()
  {
    return TIME_FULL;
  }

  public String getTimeLong ()
  {
    return TIME_LONG;
  }

  public String getTimeMedium ()
  {
    return TIME_MEDIUM;
  }

  public String getTimeShort ()
  {
    return TIME_SHORT;
  }

  public String [] getWeekdays ()
  {
    return Arrays.copyOf (WEEKDAYS, WEEKDAYS.length);
  }

  public char getZeroDigit ()
  {
    return ZERO_DIGIT;
  }

  public Collator getCollator ()
  {
    return Collator.getInstance (HR_LOCALE);
    // TODO: shouldn't rely on HR locale
  }
}
