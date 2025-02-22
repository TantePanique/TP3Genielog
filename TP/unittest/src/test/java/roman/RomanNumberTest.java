package roman;

import java.util.HashMap;
import java.util.Map;

import roman.RomanNumber;

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class RomanNumberTest {
  public static final HashMap<Integer, String> KNOWN_VALUES = new HashMap<>();
  static {
    KNOWN_VALUES.put(1, "I");
    KNOWN_VALUES.put(2, "II");
    KNOWN_VALUES.put(3, "III");
    KNOWN_VALUES.put(4, "IV");
    KNOWN_VALUES.put(5, "V");
    KNOWN_VALUES.put(6, "VI");
    KNOWN_VALUES.put(7, "VII");
    KNOWN_VALUES.put(8, "VIII");
    KNOWN_VALUES.put(9, "IX");
    KNOWN_VALUES.put(10, "X");
    KNOWN_VALUES.put(50, "L");
    KNOWN_VALUES.put(100, "C");
    KNOWN_VALUES.put(500, "D");
    KNOWN_VALUES.put(1000, "M");
    KNOWN_VALUES.put(31, "XXXI");
    KNOWN_VALUES.put(148, "CXLVIII");
    KNOWN_VALUES.put(294, "CCXCIV");
    KNOWN_VALUES.put(312, "CCCXII");
    KNOWN_VALUES.put(421, "CDXXI");
    KNOWN_VALUES.put(528, "DXXVIII");
    KNOWN_VALUES.put(621, "DCXXI");
    KNOWN_VALUES.put(782, "DCCLXXXII");
    KNOWN_VALUES.put(870, "DCCCLXX");
    KNOWN_VALUES.put(941, "CMXLI");
    KNOWN_VALUES.put(1043, "MXLIII");
    KNOWN_VALUES.put(1110, "MCX");
    KNOWN_VALUES.put(1226, "MCCXXVI");
    KNOWN_VALUES.put(1301, "MCCCI");
    KNOWN_VALUES.put(1485, "MCDLXXXV");
    KNOWN_VALUES.put(1509, "MDIX");
    KNOWN_VALUES.put(1607, "MDCVII");
    KNOWN_VALUES.put(1754, "MDCCLIV");
    KNOWN_VALUES.put(1832, "MDCCCXXXII");
    KNOWN_VALUES.put(1993, "MCMXCIII");
    KNOWN_VALUES.put(2074, "MMLXXIV");
    KNOWN_VALUES.put(2152, "MMCLII");
    KNOWN_VALUES.put(2212, "MMCCXII");
    KNOWN_VALUES.put(2343, "MMCCCXLIII");
    KNOWN_VALUES.put(2499, "MMCDXCIX");
    KNOWN_VALUES.put(2574, "MMDLXXIV");
    KNOWN_VALUES.put(2646, "MMDCXLVI");
    KNOWN_VALUES.put(2723, "MMDCCXXIII");
    KNOWN_VALUES.put(2892, "MMDCCCXCII");
    KNOWN_VALUES.put(2975, "MMCMLXXV");
    KNOWN_VALUES.put(3051, "MMMLI");
    KNOWN_VALUES.put(3185, "MMMCLXXXV");
    KNOWN_VALUES.put(3250, "MMMCCL");
    KNOWN_VALUES.put(3313, "MMMCCCXIII");
    KNOWN_VALUES.put(3408, "MMMCDVIII");
    KNOWN_VALUES.put(3501, "MMMDI");
    KNOWN_VALUES.put(3610, "MMMDCX");
    KNOWN_VALUES.put(3743, "MMMDCCXLIII");
    KNOWN_VALUES.put(3844, "MMMDCCCXLIV");
    KNOWN_VALUES.put(3888, "MMMDCCCLXXXVIII");
    KNOWN_VALUES.put(3940, "MMMCMXL");
    KNOWN_VALUES.put(3999, "MMMCMXCIX");
  }

  // String -> RomanNumber
  @Test
  public void fromRomanKnownValues() {
    for (Map.Entry<Integer, String> v : KNOWN_VALUES.entrySet()) {
      assertThat(RomanNumber.valueOf(v.getValue()).intValue(), is(v.getKey()));
    }
  }

  // int -> RomanNumber
  @Test(expected = IllegalArgumentException.class)
  public void toRomanZero() {
    RomanNumber.valueOf(0);
  }

	// RomanNumber -> int
	@Test
	public void romNtoInt() {
		int res = 0;
		res=RomanNumber.fromRoman("V");
		assertEquals(res,5);

		res=RomanNumber.fromRoman("MMMDCX");
		assertEquals(res,3610);
	}

	// int -> romanNumber
	@Test
	public void intToRomN(){
		String res;
		res=RomanNumber.toRoman(6);
		assertEquals(res,"VI");

		res=RomanNumber.toRoman(3611);
		assertEquals(res,"MMMDCXI");
	}

	// fail negative
	@Test(expected = IllegalArgumentException.class)
	public void failNegative() {
		String res;
    int num = -5;
		res=RomanNumber.toRoman(num);
	}

	// fail nonint
  // s'execute pas car de toute faŋon ŋa prend que des int
  /*
	@Test(expected = IllegalArgumentException.class)
	public void failNonint() {
		int res = 0;
		res=RomanNumber.toRoman(5.34);
	}
  */

	// fail out of bound
	@Test(expected = IllegalArgumentException.class)
	public void failOutOfBound() {
		String res;
    int num = 5000;
		res=RomanNumber.toRoman(num);
	}

	// fail failTooMuchSymbol
	@Test(expected = IllegalArgumentException.class)
	public void failTooMuchSymbolX() {
		int res = 0;
		res=RomanNumber.fromRoman("XXXX");
	}

	// fail failTooMuchSymbol
	@Test(expected = IllegalArgumentException.class)
	public void failTooMuchSymbolI() {
		int res = 0;
		res=RomanNumber.fromRoman("IIII");
	}

	// fail failTooMuchSymbol
	@Test(expected = IllegalArgumentException.class)
	public void failTooMuchSymbolC() {
		int res = 0;
		res=RomanNumber.fromRoman("CCCC");
	}

	// fail TooMuchPair
	@Test(expected = IllegalArgumentException.class)
	public void failTooMuchPairV() {
		int res = 0;
		res=RomanNumber.fromRoman("VV");
	}

	// fail TooMuchPair
	@Test(expected = IllegalArgumentException.class)
	public void failTooMuchPairL() {
		int res = 0;
		res=RomanNumber.fromRoman("LL");
	}

	// fail TooMuchPair
	@Test(expected = IllegalArgumentException.class)
	public void failTooMuchPairD() {
		int res = 0;
		res=RomanNumber.fromRoman("DD");
	}

	//fail antecedents
	@Test(expected = IllegalArgumentException.class)
	public void failAntecedent1() {
		int res = 0;
		res=RomanNumber.fromRoman("VX");
	}

	//fail antecedents
	@Test(expected = IllegalArgumentException.class)
	public void failAntecedent2() {
		int res = 0;
		res=RomanNumber.fromRoman("XCX");
	}


	//fail antecedents
	@Test(expected = IllegalArgumentException.class)
	public void failAntecedent3() {
		int res = 0;
		res=RomanNumber.fromRoman("IXI");
	}

	//validity int
	@Test
	public void validityInt(){
		for(int i=1;i<4000;i++){
			assertTrue(RomanNumber.fromRoman(RomanNumber.toRoman(i))==i);
		}
	}

	//RomanNumber.toRoman return cap
	@Test
	public void validToRomanRCap() {
		String Rom;
		for(int i=1;i<4000;i++){
			Rom = RomanNumber.toRoman(i);
			for(int j=0;j<Rom.length();j++){
				assertTrue(Character.isUpperCase(Rom.charAt(j)));
			}
		}
	}

	//fail no CAP
	@Test(expected = IllegalArgumentException.class)
	public void failNoCap() {
		int res = 0;
		res=RomanNumber.fromRoman("xii");
	}

}
