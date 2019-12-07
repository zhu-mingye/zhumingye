 package com.DemoAll.Utils;
import java.util.Random;
import java.math.BigDecimal;

/**
 * 随机种子工具类
 * 
 * @author Lychie Fan
 */
public class RandomUtil {

	private static final int DISPLAYABLE_MIN_INDEX = 33;
	private static final int DISPLAYABLE_MAX_INDEX = 127 - 1;
	private static final ThreadLocal<Random> local = new ThreadLocal<Random>() {
		@Override
		protected Random initialValue() {
			return new Random();
		}
	};

	/**
	 * 获取Random实例
	 * 
	 * @return
	 */
	public static Random getRandom() {
		return local.get();
	}

	/**
	 * 产生[0, x]区间的随机数
	 * 
	 * @param x
	 *            > 0
	 * @return
	 */
	public static int intSeed(int x) {
		return intSeed(0, x);
	}

	/**
	 * 产生[x, y]区间的随机数
	 * 
	 * @param x
	 *            >= 0
	 * @param y
	 *            > x
	 * @return
	 */
	public static int intSeed(int x, int y) {
		if (x < 0) { // ensure x >= 0
			throw new IllegalArgumentException(
					"x must be greater than or equal 0");
		}
		if (x >= y) { // ensure y > x
			throw new IllegalArgumentException("y must be greater than x");
		}
		return x + getRandom().nextInt(y - x + 1);
	}

	/**
	 * 产生[0, x]区间的随机数
	 * 
	 * @param x
	 *            > 0
	 * @return
	 */
	public static long longSeed(long x) {
		return longSeed(0, x);
	}

	/**
	 * 产生[x, y]区间的随机数
	 * 
	 * @param x
	 *            >= 0
	 * @param y
	 *            > x
	 * @return
	 */
	public static long longSeed(long x, long y) {
		if (x < 0) { // ensure x >= 0
			throw new IllegalArgumentException(
					"x must be greater than or equal 0");
		}
		if (x >= y) { // ensure y > x
			throw new IllegalArgumentException("y must be greater than x");
		}
		return Math.abs(getRandom().nextLong() % (y - x + 1)) + x;
	}

	/**
	 * 产生[0, x]区间的随机小数
	 * 
	 * @param x
	 *            > 0
	 * @return
	 */
	public static float floatSeed(float x) {
		return (float) doubleSeed(0., x);
	}

	/**
	 * 产生[x, y]区间的随机小数
	 * 
	 * @param x
	 *            >= 0
	 * @param y
	 *            > x
	 * @return
	 */
	public static float floatSeed(float x, float y) {
		return (float) doubleSeed(x, y);
	}

	/**
	 * 产生[0, x]区间的随机小数
	 * 
	 * @param x
	 *            > 0
	 * @return
	 */
	public static double doubleSeed(double x) {
		return doubleSeed(0., x);
	}

	/**
	 * 产生[x, y]区间的随机小数
	 * 
	 * @param x
	 *            >= 0
	 * @param y
	 *            > x
	 * @return
	 */
	public static double doubleSeed(double x, double y) {
		if (x < 0) { // ensure x >= 0
			throw new IllegalArgumentException(
					"x must be greater than or equal 0");
		}
		if (x >= y) { // ensure y > x
			throw new IllegalArgumentException("y must be greater than x");
		}
		BigDecimal dx = new BigDecimal(String.valueOf(x));
		BigDecimal dy = new BigDecimal(String.valueOf(y));
		double diff = dy.subtract(dx).doubleValue();
		dx = dx.add(new BigDecimal(String.valueOf(getRandom().nextDouble()
				* diff)));
		return dx.doubleValue();
	}

	/**
	 * 随机产生true或false
	 * 
	 * @return
	 */
	public static boolean boolSeed() {
		return intSeed(0, 1) == 0 ? false : true;
	}

	/**
	 * 随机产生有效的可显示的字符
	 * 
	 * @param x
	 *            >= 33
	 * @param y
	 *            > x & <= 126
	 * @return
	 */
	public static char charSeed(char x, char y) {
		if (x < DISPLAYABLE_MIN_INDEX) { // ensure x >= 33 ('!')
			throw new IllegalArgumentException(
					"x must be greater than or equal '!'");
		}
		if (x >= y) { // ensure y > x
			throw new IllegalArgumentException("y must be greater than x");
		}
		if (y > DISPLAYABLE_MAX_INDEX) { // ensure y <= 126 ('~')
			throw new IllegalArgumentException(
					"y must be less than or equal '~'");
		}
		return (char) (getRandom().nextInt(y - x + 1) + x);
	}

}