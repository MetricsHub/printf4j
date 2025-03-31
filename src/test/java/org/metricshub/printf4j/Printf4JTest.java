package org.metricshub.printf4j;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.metricshub.printf4j.Printf4J.sprintf;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class Printf4JTest {

	@Test
	public void testPlus() {
		assertEquals("+42", sprintf("%+d", 42));
		assertEquals("-42", sprintf("%+d", -42));
		assertEquals("  +42", sprintf("%+5d", 42));
		assertEquals("  -42", sprintf("%+5d", -42));
		assertEquals("            +42", sprintf("%+15d", 42));
		assertEquals("            -42", sprintf("%+15d", -42));
		assertEquals("Hello testing", sprintf("%+s", "Hello testing"));
		assertEquals("+1024", sprintf("%+d", 1024));
		assertEquals("-1024", sprintf("%+d", -1024));
		assertEquals("+1024", sprintf("%+i", 1024));
		assertEquals("-1024", sprintf("%+i", -1024));
		assertEquals("1024", sprintf("%+u", 1024));
		assertEquals("4294966272", sprintf("%+u", 4294966272L));
		assertEquals("777", sprintf("%+o", 511));
		assertEquals("37777777001", sprintf("%+o", 4294966785L));
		assertEquals("1234abcd", sprintf("%+x", 305441741));
		assertEquals("edcb5433", sprintf("%+x", 3989525555L));
		assertEquals("1234ABCD", sprintf("%+X", 305441741));
		assertEquals("EDCB5433", sprintf("%+X", 3989525555L));
		assertEquals("x", sprintf("%+c", 'x'));
		//		  assertEquals("0", sprintf("%+.0d", 0));
	}

	@Test
	public void testBlank() {
		assertEquals(" 42", sprintf("% d", 42));
		assertEquals("-42", sprintf("% d", -42));
		assertEquals("   42", sprintf("% 5d", 42));
		assertEquals("  -42", sprintf("% 5d", -42));
		assertEquals("             42", sprintf("% 15d", 42));
		assertEquals("            -42", sprintf("% 15d", -42));
		assertEquals("            -42", sprintf("% 15d", -42));
		assertEquals("        -42.987", sprintf("% 15.3f", -42.987));
		assertEquals("         42.987", sprintf("% 15.3f", 42.987));
		assertEquals("Hello testing", sprintf("% s", "Hello testing"));
		assertEquals(" 1024", sprintf("% d", 1024));
		assertEquals("-1024", sprintf("% d", -1024));
		assertEquals(" 1024", sprintf("% i", 1024));
		assertEquals("-1024", sprintf("% i", -1024));
		assertEquals("1024", sprintf("% u", 1024));
		assertEquals("4294966272", sprintf("% u", 4294966272L));
		assertEquals("777", sprintf("% o", 511));
		assertEquals("37777777001", sprintf("% o", 4294966785L));
		assertEquals("1234abcd", sprintf("% x", 305441741));
		assertEquals("edcb5433", sprintf("% x", 3989525555L));
		assertEquals("1234ABCD", sprintf("% X", 305441741));
		assertEquals("EDCB5433", sprintf("% X", 3989525555L));
		assertEquals("x", sprintf("% c", 'x'));
	}

	@Test
	public void testZero() {
		assertEquals("42", sprintf("%0d", 42));
		assertEquals("42", sprintf("%0ld", 42L));
		assertEquals("-42", sprintf("%0d", -42));
		assertEquals("00042", sprintf("%05d", 42));
		assertEquals("-0042", sprintf("%05d", -42));
		assertEquals("000000000000042", sprintf("%015d", 42));
		assertEquals("-00000000000042", sprintf("%015d", -42));
		assertEquals("000000000042.12", sprintf("%015.2f", 42.1234));
		assertEquals("00000000042.988", sprintf("%015.3f", 42.9876));
		assertEquals("-00000042.98760", sprintf("%015.5f", -42.9876));
	}

	@Test
	public void testMinus() {
		assertEquals("42", sprintf("%-d", 42));
		assertEquals("-42", sprintf("%-d", -42));
		assertEquals("42   ", sprintf("%-5d", 42));
		assertEquals("-42  ", sprintf("%-5d", -42));
		assertEquals("42             ", sprintf("%-15d", 42));
		assertEquals("-42            ", sprintf("%-15d", -42));
		assertEquals("42", sprintf("%-0d", 42));
		assertEquals("-42", sprintf("%-0d", -42));
		assertEquals("42   ", sprintf("%-05d", 42));
		assertEquals("-42  ", sprintf("%-05d", -42));
		assertEquals("42             ", sprintf("%-015d", 42));
		assertEquals("-42            ", sprintf("%-015d", -42));
		assertEquals("42", sprintf("%0-d", 42));
		assertEquals("-42", sprintf("%0-d", -42));
		assertEquals("42   ", sprintf("%0-5d", 42));
		assertEquals("-42  ", sprintf("%0-5d", -42));
		assertEquals("42             ", sprintf("%0-15d", 42));
		assertEquals("-42            ", sprintf("%0-15d", -42));
		assertEquals("-4.200e+01     ", sprintf("%0-15.3e", -42.));
		assertEquals("-42.0          ", sprintf("%0-15.3g", -42.));
	}

	@Test
	public void testHash() {
		assertEquals("", sprintf("%#.0x", 0));
		//		assertEquals("0", sprintf("%#.1x", 0)); // This is the real expected behavior, which is wrong IMO
		assertEquals("0x0", sprintf("%#.1x", 0));
		assertEquals("", sprintf("%#.0llx", 0));
		assertEquals("0x0000614e", sprintf("%#.8x", 0x614e)); // This is the real expected behavior
		//		assertEquals("0b110", sprintf("%#b", 6)); // Binary is not supported for now
	}

	@Test
	public void testSpecifier() {
		assertEquals("Hello testing", sprintf("Hello testing"));
		assertEquals("Hello testing", sprintf("%s", "Hello testing"));
		assertEquals("1024", sprintf("%d", 1024));
		assertEquals("-1024", sprintf("%d", -1024));
		assertEquals("1024", sprintf("%i", 1024));
		assertEquals("-1024", sprintf("%i", -1024));
		assertEquals("1024", sprintf("%u", 1024));
		assertEquals("4294966272", sprintf("%u", 4294966272L));
		assertEquals("777", sprintf("%o", 511));
		assertEquals("37777777001", sprintf("%o", 4294966785L));
		assertEquals("1234abcd", sprintf("%x", 305441741));
		assertEquals("edcb5433", sprintf("%x", 3989525555L));
		assertEquals("1234ABCD", sprintf("%X", 305441741));
		assertEquals("EDCB5433", sprintf("%X", 3989525555L));
		assertEquals("%", sprintf("%%"));
	}

	@Test
	public void testWidth() {
		assertEquals("Hello testing", sprintf("%1s", "Hello testing"));
		assertEquals("1024", sprintf("%1d", 1024));
		assertEquals("-1024", sprintf("%1d", -1024));
		assertEquals("1024", sprintf("%1i", 1024));
		assertEquals("-1024", sprintf("%1i", -1024));
		assertEquals("1024", sprintf("%1u", 1024));
		assertEquals("4294966272", sprintf("%1u", 4294966272L));
		assertEquals("777", sprintf("%1o", 511));
		assertEquals("37777777001", sprintf("%1o", 4294966785L));
		assertEquals("1234abcd", sprintf("%1x", 305441741));
		assertEquals("edcb5433", sprintf("%1x", 3989525555L));
		assertEquals("1234ABCD", sprintf("%1X", 305441741));
		assertEquals("EDCB5433", sprintf("%1X", 3989525555L));
		assertEquals("x", sprintf("%1c", 'x'));
	}

	@Test
	public void testWidth20() {
		assertEquals("               Hello", sprintf("%20s", "Hello"));
		assertEquals("                1024", sprintf("%20d", 1024));
		assertEquals("               -1024", sprintf("%20d", -1024));
		assertEquals("                1024", sprintf("%20i", 1024));
		assertEquals("               -1024", sprintf("%20i", -1024));
		assertEquals("                1024", sprintf("%20u", 1024));
		assertEquals("          4294966272", sprintf("%20u", 4294966272L));
		assertEquals("                 777", sprintf("%20o", 511));
		assertEquals("         37777777001", sprintf("%20o", 4294966785L));
		assertEquals("            1234abcd", sprintf("%20x", 305441741));
		assertEquals("            edcb5433", sprintf("%20x", 3989525555L));
		assertEquals("            1234ABCD", sprintf("%20X", 305441741));
		assertEquals("            EDCB5433", sprintf("%20X", 3989525555L));
		assertEquals("                   x", sprintf("%20c", 'x'));
	}

	@Test
	public void testWidthStar20() {
		assertEquals("               Hello", sprintf("%*s", 20, "Hello"));
		assertEquals("                1024", sprintf("%*d", 20, 1024));
		assertEquals("               -1024", sprintf("%*d", 20, -1024));
		assertEquals("                1024", sprintf("%*i", 20, 1024));
		assertEquals("               -1024", sprintf("%*i", 20, -1024));
		assertEquals("                1024", sprintf("%*u", 20, 1024));
		assertEquals("          4294966272", sprintf("%*u", 20, 4294966272L));
		assertEquals("                 777", sprintf("%*o", 20, 511));
		assertEquals("         37777777001", sprintf("%*o", 20, 4294966785L));
		assertEquals("            1234abcd", sprintf("%*x", 20, 305441741));
		assertEquals("            edcb5433", sprintf("%*x", 20, 3989525555L));
		assertEquals("            1234ABCD", sprintf("%*X", 20, 305441741));
		assertEquals("            EDCB5433", sprintf("%*X", 20, 3989525555L));
		assertEquals("                   x", sprintf("%*c", 20, 'x'));
	}

	@Test
	public void testMinus20() {
		assertEquals("Hello               ", sprintf("%-20s", "Hello"));
		assertEquals("1024                ", sprintf("%-20d", 1024));
		assertEquals("-1024               ", sprintf("%-20d", -1024));
		assertEquals("1024                ", sprintf("%-20i", 1024));
		assertEquals("-1024               ", sprintf("%-20i", -1024));
		assertEquals("1024                ", sprintf("%-20u", 1024));
		assertEquals("1024.1234           ", sprintf("%-20.4f", 1024.1234));
		assertEquals("4294966272          ", sprintf("%-20u", 4294966272L));
		assertEquals("777                 ", sprintf("%-20o", 511));
		assertEquals("37777777001         ", sprintf("%-20o", 4294966785L));
		assertEquals("1234abcd            ", sprintf("%-20x", 305441741));
		assertEquals("edcb5433            ", sprintf("%-20x", 3989525555L));
		assertEquals("1234ABCD            ", sprintf("%-20X", 305441741));
		assertEquals("EDCB5433            ", sprintf("%-20X", 3989525555L));
		assertEquals("x                   ", sprintf("%-20c", 'x'));
		assertEquals("|    9| |9 | |    9|", sprintf("|%5d| |%-2d| |%5d|", 9, 9, 9));
		assertEquals("|   10| |10| |   10|", sprintf("|%5d| |%-2d| |%5d|", 10, 10, 10));
		assertEquals("|    9| |9           | |    9|", sprintf("|%5d| |%-12d| |%5d|", 9, 9, 9));
		assertEquals("|   10| |10          | |   10|", sprintf("|%5d| |%-12d| |%5d|", 10, 10, 10));
	}

	@Test
	public void testZeroMinus20() {
		assertEquals("Hello               ", sprintf("%0-20s", "Hello"));
		assertEquals("1024                ", sprintf("%0-20d", 1024));
		assertEquals("-1024               ", sprintf("%0-20d", -1024));
		assertEquals("1024                ", sprintf("%0-20i", 1024));
		assertEquals("-1024               ", sprintf("%0-20i", -1024));
		assertEquals("1024                ", sprintf("%0-20u", 1024));
		assertEquals("4294966272          ", sprintf("%0-20u", 4294966272L));
		assertEquals("777                 ", sprintf("%0-20o", 511));
		assertEquals("37777777001         ", sprintf("%0-20o", 4294966785L));
		assertEquals("1234abcd            ", sprintf("%0-20x", 305441741));
		assertEquals("edcb5433            ", sprintf("%0-20x", 3989525555L));
		assertEquals("1234ABCD            ", sprintf("%0-20X", 305441741));
		assertEquals("EDCB5433            ", sprintf("%0-20X", 3989525555L));
		assertEquals("x                   ", sprintf("%0-20c", 'x'));
	}

	@Test
	public void testPadding20() {
		assertEquals("00000000000000001024", sprintf("%020d", 1024));
		assertEquals("-0000000000000001024", sprintf("%020d", -1024));
		assertEquals("00000000000000001024", sprintf("%020i", 1024));
		assertEquals("-0000000000000001024", sprintf("%020i", -1024));
		assertEquals("00000000000000001024", sprintf("%020u", 1024));
		assertEquals("00000000004294966272", sprintf("%020u", 4294966272L));
		assertEquals("00000000000000000777", sprintf("%020o", 511));
		assertEquals("00000000037777777001", sprintf("%020o", 4294966785L));
		assertEquals("0000000000001234abcd", sprintf("%020x", 305441741));
		assertEquals("000000000000edcb5433", sprintf("%020x", 3989525555L));
		assertEquals("0000000000001234ABCD", sprintf("%020X", 305441741));
		assertEquals("000000000000EDCB5433", sprintf("%020X", 3989525555L));
	}

	@Test
	public void testPaddingPrecision20() {
		assertEquals("00000000000000001024", sprintf("%.20d", 1024));
		assertEquals("-00000000000000001024", sprintf("%.20d", -1024));
		assertEquals("00000000000000001024", sprintf("%.20i", 1024));
		assertEquals("-00000000000000001024", sprintf("%.20i", -1024));
		assertEquals("00000000000000001024", sprintf("%.20u", 1024));
		assertEquals("00000000004294966272", sprintf("%.20u", 4294966272L));
		assertEquals("00000000000000000777", sprintf("%.20o", 511));
		assertEquals("00000000037777777001", sprintf("%.20o", 4294966785L));
		assertEquals("0000000000001234abcd", sprintf("%.20x", 305441741));
		assertEquals("000000000000edcb5433", sprintf("%.20x", 3989525555L));
		assertEquals("0000000000001234ABCD", sprintf("%.20X", 305441741));
		assertEquals("000000000000EDCB5433", sprintf("%.20X", 3989525555L));
	}

	@Test
	public void testPaddingHashZero20() {
		assertEquals("00000000000000001024", sprintf("%#020d", 1024));
		assertEquals("-0000000000000001024", sprintf("%#020d", -1024));
		assertEquals("00000000000000001024", sprintf("%#020i", 1024));
		assertEquals("-0000000000000001024", sprintf("%#020i", -1024));
		assertEquals("00000000000000001024", sprintf("%#020u", 1024));
		assertEquals("00000000004294966272", sprintf("%#020u", 4294966272L));
		assertEquals("00000000000000000777", sprintf("%#020o", 511));
		assertEquals("00000000037777777001", sprintf("%#020o", 4294966785L));
		assertEquals("0x00000000001234abcd", sprintf("%#020x", 305441741));
		assertEquals("0x0000000000edcb5433", sprintf("%#020x", 3989525555L));
		assertEquals("0X00000000001234ABCD", sprintf("%#020X", 305441741));
		assertEquals("0X0000000000EDCB5433", sprintf("%#020X", 3989525555L));
	}

	@Test
	public void testPaddingHash20() {
		assertEquals("                1024", sprintf("%#20d", 1024));
		assertEquals("               -1024", sprintf("%#20d", -1024));
		assertEquals("                1024", sprintf("%#20i", 1024));
		assertEquals("               -1024", sprintf("%#20i", -1024));
		assertEquals("                1024", sprintf("%#20u", 1024));
		assertEquals("          4294966272", sprintf("%#20u", 4294966272L));
		//		assertEquals("                0777", sprintf("%#20o", 511));
		//		assertEquals("        037777777001", sprintf("%#20o", 4294966785L));
		//		assertEquals("          0x1234abcd", sprintf("%#20x", 305441741));
		//		assertEquals("          0xedcb5433", sprintf("%#20x", 3989525555L));
		//		assertEquals("          0X1234ABCD", sprintf("%#20X", 305441741));
		//		assertEquals("          0XEDCB5433", sprintf("%#20X", 3989525555L));
	}

	@Test
	@Disabled
	public void testPadding20Dot5() {
		assertEquals("               01024", sprintf("%20.5d", 1024));
		assertEquals("              -01024", sprintf("%20.5d", -1024));
		assertEquals("               01024", sprintf("%20.5i", 1024));
		assertEquals("              -01024", sprintf("%20.5i", -1024));
		assertEquals("               01024", sprintf("%20.5u", 1024));
		assertEquals("          4294966272", sprintf("%20.5u", 4294966272L));
		assertEquals("               00777", sprintf("%20.5o", 511));
		assertEquals("         37777777001", sprintf("%20.5o", 4294966785L));
		assertEquals("            1234abcd", sprintf("%20.5x", 305441741));
		assertEquals("          00edcb5433", sprintf("%20.10x", 3989525555L));
		assertEquals("            1234ABCD", sprintf("%20.5X", 305441741));
		assertEquals("          00EDCB5433", sprintf("%20.10X", 3989525555L));
	}

	@Test
	@Disabled
	public void testPaddingNegativeNumbers() {
		// space padding
		assertEquals("-5", sprintf("% 1d", -5));
		assertEquals("-5", sprintf("% 2d", -5));
		assertEquals(" -5", sprintf("% 3d", -5));
		assertEquals("  -5", sprintf("% 4d", -5));
		// zero padding
		assertEquals("-5", sprintf("%01d", -5));
		assertEquals("-5", sprintf("%02d", -5));
		assertEquals("-05", sprintf("%03d", -5));
		assertEquals("-005", sprintf("%04d", -5));
	}

	@Test
	@Disabled
	public void testPaddingNegativeFloat() {
		// space padding
		assertEquals("-5.0", sprintf("% 3.1f", -5.));
		assertEquals("-5.0", sprintf("% 4.1f", -5.));
		assertEquals(" -5.0", sprintf("% 5.1f", -5.));
		assertEquals("    -5", sprintf("% 6.1g", -5.));
		assertEquals("-5.0e+00", sprintf("% 6.1e", -5.));
		assertEquals("  -5.0e+00", sprintf("% 10.1e", -5.));
		// zero padding
		assertEquals("-5.0", sprintf("%03.1f", -5.));
		assertEquals("-5.0", sprintf("%04.1f", -5.));
		assertEquals("-05.0", sprintf("%05.1f", -5.));
		// zero padding no decimal point
		assertEquals("-5", sprintf("%01.0f", -5.));
		assertEquals("-5", sprintf("%02.0f", -5.));
		assertEquals("-05", sprintf("%03.0f", -5.));
		assertEquals("-005.0e+00", sprintf("%010.1e", -5.));
		assertEquals("-05E+00", sprintf("%07.0E", -5.));
		assertEquals("-05", sprintf("%03.0g", -5.));
	}

	@Test
	@Disabled
	public void testLength() {
		assertEquals("", sprintf("%.0s", "Hello testing"));
		assertEquals("                    ", sprintf("%20.0s", "Hello testing"));
		assertEquals("", sprintf("%.s", "Hello testing"));
		assertEquals("                    ", sprintf("%20.s", "Hello testing"));
		assertEquals("                1024", sprintf("%20.0d", 1024));
		assertEquals("               -1024", sprintf("%20.0d", -1024));
		assertEquals("                    ", sprintf("%20.d", 0));
		assertEquals("                1024", sprintf("%20.0i", 1024));
		assertEquals("               -1024", sprintf("%20.i", -1024));
		assertEquals("                    ", sprintf("%20.i", 0));
		assertEquals("                1024", sprintf("%20.u", 1024));
		assertEquals("          4294966272", sprintf("%20.0u", 4294966272L));
		assertEquals("                    ", sprintf("%20.u", 0L));
		assertEquals("                 777", sprintf("%20.o", 511));
		assertEquals("         37777777001", sprintf("%20.0o", 4294966785L));
		assertEquals("                    ", sprintf("%20.o", 0L));
		assertEquals("            1234abcd", sprintf("%20.x", 305441741));
		assertEquals("                                          1234abcd", sprintf("%50.x", 305441741));
		assertEquals(
			"                                          1234abcd     12345",
			sprintf("%50.x%10.u", 305441741, 12345)
		);
		assertEquals("            edcb5433", sprintf("%20.0x", 3989525555L));
		assertEquals("                    ", sprintf("%20.x", 0L));
		assertEquals("            1234ABCD", sprintf("%20.X", 305441741));
		assertEquals("            EDCB5433", sprintf("%20.0X", 3989525555L));
		assertEquals("                    ", sprintf("%20.X", 0L));
		assertEquals("  ", sprintf("%02.0u", 0L));
		assertEquals("  ", sprintf("%02.0d", 0));
	}

	@Test
	@Disabled
	public void testFloat() {
		// test special-case floats using math.h macros
		assertEquals("     nan", sprintf("%8f", Float.NaN));
		assertEquals("     inf", sprintf("%8f", Float.POSITIVE_INFINITY));
		assertEquals("-inf    ", sprintf("%-8f", Float.NEGATIVE_INFINITY));
		assertEquals("    +inf", sprintf("%+8e", Float.POSITIVE_INFINITY));
		assertEquals("3.1415", sprintf("%.4f", 3.1415354));
		assertEquals("30343.142", sprintf("%.3f", 30343.1415354));
		assertEquals("34", sprintf("%.0f", 34.1415354));
		assertEquals("1", sprintf("%.0f", 1.3));
		assertEquals("2", sprintf("%.0f", 1.55));
		assertEquals("1.6", sprintf("%.1f", 1.64));
		assertEquals("42.90", sprintf("%.2f", 42.8952));
		assertEquals("42.895200000", sprintf("%.9f", 42.8952));
		assertEquals("42.8952230000", sprintf("%.10f", 42.895223));
		// this testcase checks, that the precision is truncated to 9 digits.
		// a perfect working float should return the whole number
		assertEquals("42.895223123000", sprintf("%.12f", 42.89522312345678));
		// this testcase checks, that the precision is truncated AND rounded to 9 digits.
		// a perfect working float should return the whole number
		assertEquals("42.895223877000", sprintf("%.12f", 42.89522387654321));
		assertEquals(" 42.90", sprintf("%6.2f", 42.8952));
		assertEquals("+42.90", sprintf("%+6.2f", 42.8952));
		assertEquals("+42.9", sprintf("%+5.1f", 42.9252));
		assertEquals("42.500000", sprintf("%f", 42.5));
		assertEquals("42.5", sprintf("%.1f", 42.5));
		assertEquals("42167.000000", sprintf("%f", 42167.0));
		assertEquals("-12345.987654321", sprintf("%.9f", -12345.987654321));
		assertEquals("4.0", sprintf("%.1f", 3.999));
		assertEquals("4", sprintf("%.0f", 3.5));
		assertEquals("4", sprintf("%.0f", 4.5));
		assertEquals("3", sprintf("%.0f", 3.49));
		assertEquals("3.5", sprintf("%.1f", 3.49));
		assertEquals("a0.5  ", sprintf("a%-5.1f", 0.5));
		assertEquals("a0.5  end", sprintf("a%-5.1fend", 0.5));
		assertEquals("12345.7", sprintf("%G", 12345.678));
		assertEquals("12345.68", sprintf("%.7G", 12345.678));
		assertEquals("1.2346E+08", sprintf("%.5G", 123456789.));
		assertEquals("12345.0", sprintf("%.6G", 12345.));
		assertEquals("  +1.235e+08", sprintf("%+12.4g", 123456789.));
		assertEquals("0.0012", sprintf("%.2G", 0.001234));
		assertEquals(" +0.001234", sprintf("%+10.4G", 0.001234));
		assertEquals("+001.234e-05", sprintf("%+012.4g", 0.00001234));
		assertEquals("-1.23e-308", sprintf("%.3g", -1.2345e-308));
		assertEquals("+1.230E+308", sprintf("%+.3E", 1.23e+308));
		// out of range for float: should switch to exp notation if supported
		assertEquals("1.0e+20", sprintf("%.1f", 1E20));
	}

	@Test
	@Disabled
	public void testTypes() {
		assertEquals("0", sprintf("%i", 0));
		assertEquals("1234", sprintf("%i", 1234));
		assertEquals("32767", sprintf("%i", 32767));
		assertEquals("-32767", sprintf("%i", -32767));
		assertEquals("30", sprintf("%li", 30L));
		assertEquals("-2147483647", sprintf("%li", -2147483647L));
		assertEquals("2147483647", sprintf("%li", 2147483647L));
		assertEquals("30", sprintf("%lli", 30L));
		assertEquals("-9223372036854775807", sprintf("%lli", -9223372036854775807L));
		assertEquals("9223372036854775807", sprintf("%lli", 9223372036854775807L));
		assertEquals("100000", sprintf("%lu", 100000L));
		assertEquals("4294967295", sprintf("%lu", 0xFFFFFFFFL));
		assertEquals("281474976710656", sprintf("%llu", 281474976710656L));
		assertEquals("18446744073709551615", sprintf("%llu", Long.parseUnsignedLong("18446744073709551615")));
		assertEquals("2147483647", sprintf("%zu", 2147483647L));
		assertEquals("2147483647", sprintf("%zd", 2147483647L));
		assertEquals("-2147483647", sprintf("%zi", -2147483647L));
		assertEquals("1110101001100000", sprintf("%b", 60000));
		assertEquals("101111000110000101001110", sprintf("%lb", 12345678L));
		assertEquals("165140", sprintf("%o", 60000));
		assertEquals("57060516", sprintf("%lo", 12345678L));
		assertEquals("12345678", sprintf("%lx", 0x12345678L));
		assertEquals("1234567891234567", sprintf("%llx", 0x1234567891234567L));
		assertEquals("abcdefab", sprintf("%lx", 0xabcdefabL));
		assertEquals("ABCDEFAB", sprintf("%lX", 0xabcdefabL));
		assertEquals("v", sprintf("%c", 'v'));
		assertEquals("wv", sprintf("%cv", 'w'));
		assertEquals("A Test", sprintf("%s", "A Test"));
		assertEquals("255", sprintf("%hhu", 0xFFFFL));
		assertEquals("13398", sprintf("%hu", 0x123456L));
		assertEquals("Test16 65535", sprintf("%s%hhi %hu", "Test", 10000, 0xFFFFFFFF));
	}

	@Test
	@Disabled
	public void testUnknown() {
		assertEquals("kmarco", sprintf("%kmarco", 42, 37));
	}

	@Test
	@Disabled
	public void testStringLength() {
		assertEquals("This", sprintf("%.4s", "This is a test"));
		assertEquals("test", sprintf("%.4s", "test"));
		assertEquals("123", sprintf("%.7s", "123"));
		assertEquals("", sprintf("%.7s", ""));
		assertEquals("1234ab", sprintf("%.4s%.2s", "123456", "abcdef"));
		assertEquals(".2s", sprintf("%.4.2s", "123456"));
		assertEquals("123", sprintf("%.*s", 3, "123456"));
	}

	@Test
	@Disabled
	public void testMisc() {
		assertEquals("53000atest-20 bit", sprintf("%u%u%ctest%d %s", 5, 3000, 'a', -20, "bit"));
		assertEquals("0.33", sprintf("%.*f", 2, 0.33333333));
		assertEquals("1", sprintf("%.*d", -1, 1));
		assertEquals("foo", sprintf("%.3s", "foobar"));
		assertEquals(" ", sprintf("% .0d", 0));
		assertEquals("     00004", sprintf("%10.5d", 4));
		assertEquals("hi x", sprintf("%*sx", -3, "hi"));
		assertEquals("0.33", sprintf("%.*g", 2, 0.33333333));
		assertEquals("3.33e-01", sprintf("%.*e", 2, 0.33333333));
	}

	@Test
	public void testChar() {
		assertEquals("A", sprintf("%c", 65));
		assertEquals("A", sprintf("%c", 65L));
		assertEquals("A", sprintf("%c", 65.0));
		assertEquals("A", sprintf("%c", 65.1));
		assertEquals("A", sprintf("%c", Integer.valueOf(65)));
		assertEquals("A", sprintf("%c", Long.valueOf(65)));
		assertEquals("A", sprintf("%c", Float.valueOf(65)));
		assertEquals("A", sprintf("%c", Double.valueOf(65)));
		assertEquals("6", sprintf("%c", "65"));
		Object nothing = null;
		assertEquals("\u0000", sprintf("%c", nothing));
	}

	@Test
	public void testToChar() {
		assertEquals('A', Printf4J.toChar(65));
		assertEquals('A', Printf4J.toChar(65L));
		assertEquals('A', Printf4J.toChar(65.0));
		assertEquals('A', Printf4J.toChar(65.1));
		assertEquals('A', Printf4J.toChar(65.9));
		assertEquals('A', Printf4J.toChar(Integer.valueOf(65)));
		assertEquals('A', Printf4J.toChar(Long.valueOf(65)));
		assertEquals('A', Printf4J.toChar(Float.valueOf(65)));
		assertEquals('A', Printf4J.toChar(Double.valueOf(65)));
		assertEquals('6', Printf4J.toChar("65"));
		assertEquals('\u0000', Printf4J.toChar(""));
		Object nothing = null;
		assertEquals('\u0000', Printf4J.toChar(nothing));
	}

	@Test
	public void testToLong() {
		assertEquals(65L, Printf4J.toLong('A'));
		assertEquals(65L, Printf4J.toLong(65));
		assertEquals(65L, Printf4J.toLong(65L));
		assertEquals(65L, Printf4J.toLong(65.0));
		assertEquals(65L, Printf4J.toLong(65.1));
		assertEquals(65L, Printf4J.toLong(65.9));
		assertEquals(65L, Printf4J.toLong(Integer.valueOf(65)));
		assertEquals(65L, Printf4J.toLong(Long.valueOf(65)));
		assertEquals(65L, Printf4J.toLong(Float.valueOf(65)));
		assertEquals(65L, Printf4J.toLong(Double.valueOf(65)));
		assertEquals(65L, Printf4J.toLong("65"));
		assertEquals(65L, Printf4J.toLong("65A"));
		assertEquals(65L, Printf4J.toLong("65A6666666666666666666666666600000000033333333333999999999999"));
		assertEquals(0L, Printf4J.toLong(""));
		Object nothing = null;
		assertEquals(0L, Printf4J.toLong(nothing));
	}

	@Test
	public void testToDouble() {
		assertEquals(65.0, Printf4J.toDouble('A'));
		assertEquals(65.0, Printf4J.toDouble(65));
		assertEquals(65.0, Printf4J.toDouble(65L));
		assertEquals(65.0, Printf4J.toDouble(65.0));
		assertEquals(65.1, Printf4J.toDouble(65.1));
		assertEquals(65.9, Printf4J.toDouble(65.9));
		assertEquals(65.0, Printf4J.toDouble(Integer.valueOf(65)));
		assertEquals(65.0, Printf4J.toDouble(Long.valueOf(65)));
		assertEquals(65.0, Printf4J.toDouble(Float.valueOf(65)));
		assertEquals(65.0, Printf4J.toDouble(Double.valueOf(65)));
		assertEquals(65.0, Printf4J.toDouble("65"));
		assertEquals(65.0, Printf4J.toDouble("65A"));
		assertEquals(65.0, Printf4J.toDouble("65A6666666666666666666666666600000000033333333333999999999999"));
		assertEquals(65.0, Printf4J.toDouble("6.5E+1"));
		assertEquals(0.0, Printf4J.toDouble(""));
		Object nothing = null;
		assertEquals(0.0, Printf4J.toDouble(nothing));
	}
}
