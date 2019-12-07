package com.DemoAll.Utils;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.lang.reflect.Array;

/**
 * 数组工具类 
 * 
 * @author Lychie Fan
 */
public class CollectionUtil {
	
	
	/**
	 * 集合是否为空
	 * 
	 * @param collection
	 *            集合
	 * @return 若集合为null, 或集合大小为0, 则返回true, 否则返回false
	 */
	public static boolean isEmpty(Collection<?> collection) {
		return collection == null || collection.size() == 0;
	}

	/**
	 * 集合是否不为空
	 * 
	 * @param collection
	 *            集合
	 * @return 若集合不为null, 而且集合大小不为0, 则返回true, 否则返回false
	 */
	public static boolean isNotEmpty(Collection<?> collection) {
		return !isEmpty(collection);
	}

	/**
	 * 参数转换为List集合
	 * 
	 * @param objs
	 *            参数对象
	 * @return
	 */
	public static <E> List<E> asList(E... objs) {
		return Arrays.asList(objs);
	}

	/**
	 * 参数集合转换为List集合
	 * 
	 * @param collection
	 *            集合参数
	 * @return
	 */
	public static <E> List<E> asList(Collection<E> collection) {
		if (collection == null) {
			return null;
		}
		if (collection instanceof List) {
			return (List<E>) collection;
		}
		return new ArrayList<E>(collection);
	}

	/**
	 * 参数转换为Set集合
	 * 
	 * @param objs
	 *            参数对象
	 * @return
	 */
	public static <E> Set<E> asSet(E... objs) {
		return new HashSet<E>(Arrays.asList(objs));
		
	}

	/**
	 * 参数转换为Set集合
	 * 
	 * @param collection
	 *            集合参数
	 * @return
	 */
	public static <E> Set<E> asSet(Collection<E> collection) {
		if (collection == null) {
			return null;
		}
		if (collection instanceof Set) {
			return (Set<E>) collection;
		}
		return new HashSet<E>(collection);
	}

	/**
	 * 将集合转换为数组
	 * 
	 * @param collection
	 *            集合
	 * @return
	 */
	public static <E> E[] toArray(Collection<E> collection) {
		return CollectionUtil.asArray(collection);
	}

	/**
	 * 创建ArrayList实例
	 * 
	 * @return
	 */
	public static <E> List<E> newList() {
		return new ArrayList<E>();
	}

	/**
	 * 创建一个指定容量的ArrayList实例
	 * 
	 * @param size
	 *            大小
	 * @return
	 */
	public static <E> List<E> newList(int size) {
		return new ArrayList<E>(size);
	}

	/**
	 * 创建一个HashSet实例
	 * 
	 * @return
	 */
	public static <E> Set<E> newSet() {
		return new HashSet<E>(16, .75f);
	}

	/**
	 * 创建一个指定容量大小的HashSet实例
	 * 
	 * @param initialCapacity
	 *            初始容量
	 * @param loadFactor
	 *            加载因子
	 * @return
	 */
	public static <E> Set<E> newSet(int initialCapacity, double loadFactor) {
		return new HashSet<E>(initialCapacity, (float) loadFactor);
	}

	/**
	 * 根据给定的Bean属性名称, 按升序顺序排序集合里面的对象
	 * 
	 * @param collection
	 *            集合
	 * @param propertyName
	 *            属性名称
	 */
	public static <E> void sort(Collection<E> collection, String propertyName) {
		sort(collection, propertyName, true);
	}

	/**
	 * 根据给定的Bean属性名称, 按降序顺序排序集合里面的对象
	 * 
	 * @param collection
	 *            集合
	 * @param propertyName
	 *            属性名称
	 */
	public static <E> void sortByDesc(Collection<E> collection,
			String propertyName) {
		sort(collection, propertyName, false);
	}

	/**
	 * 根据给定的Bean属性名称, 排序集合里面的对象
	 * 
	 * @param collection
	 *            集合
	 * @param key
	 *            排序关键字
	 * @param asc
	 *            是否升序
	 */
	private static <E> void sort(Collection<E> collection, String key,
			boolean asc) {
		List<E> list = new ArrayList<E>(collection);
		Class<?> type = collection.iterator().next().getClass();
		collection.clear();
		collection.addAll(list);
	}

	

	

	/**
	 * 数组是否为空
	 * 
	 * @param array
	 *            数组
	 * @return 若数组为null, 或长度为0, 则返回true, 否则返回false
	 */
	public static boolean isEmpty(Object[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * 数组是否为空
	 * 
	 * @param array
	 *            数组
	 * @return 若数组为null, 或长度为0, 则返回true, 否则返回false
	 */
	public static boolean isEmpty(boolean[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * 数组是否为空
	 * 
	 * @param array
	 *            数组
	 * @return 若数组为null, 或长度为0, 则返回true, 否则返回false
	 */
	public static boolean isEmpty(byte[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * 数组是否为空
	 * 
	 * @param array
	 *            数组
	 * @return 若数组为null, 或长度为0, 则返回true, 否则返回false
	 */
	public static boolean isEmpty(char[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * 数组是否为空
	 * 
	 * @param array
	 *            数组
	 * @return 若数组为null, 或长度为0, 则返回true, 否则返回false
	 */
	public static boolean isEmpty(double[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * 数组是否为空
	 * 
	 * @param array
	 *            数组
	 * @return 若数组为null, 或长度为0, 则返回true, 否则返回false
	 */
	public static boolean isEmpty(float[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * 数组是否为空
	 * 
	 * @param array
	 *            数组
	 * @return 若数组为null, 或长度为0, 则返回true, 否则返回false
	 */
	public static boolean isEmpty(int[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * 数组是否为空
	 * 
	 * @param array
	 *            数组
	 * @return 若数组为null, 或长度为0, 则返回true, 否则返回false
	 */
	public static boolean isEmpty(long[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * 数组是否为空
	 * 
	 * @param array
	 *            数组
	 * @return 若数组为null, 或长度为0, 则返回true, 否则返回false
	 */
	public static boolean isEmpty(short[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * 数组是否为不空
	 * 
	 * @param array
	 *            数组
	 * @return 若数组不为null, 而且长度不为0, 则返回true, 否则返回false
	 */
	public static boolean isNotEmpty(Object[] array) {
		return !isEmpty(array);
	}

	/**
	 * 数组是否为不空
	 * 
	 * @param array
	 *            数组
	 * @return 若数组不为null, 而且长度不为0, 则返回true, 否则返回false
	 */
	public static boolean isNotEmpty(boolean[] array) {
		return !isEmpty(array);
	}

	/**
	 * 数组是否为不空
	 * 
	 * @param array
	 *            数组
	 * @return 若数组不为null, 而且长度不为0, 则返回true, 否则返回false
	 */
	public static boolean isNotEmpty(byte[] array) {
		return !isEmpty(array);
	}

	/**
	 * 数组是否为不空
	 * 
	 * @param array
	 *            数组
	 * @return 若数组不为null, 而且长度不为0, 则返回true, 否则返回false
	 */
	public static boolean isNotEmpty(char[] array) {
		return !isEmpty(array);
	}

	/**
	 * 数组是否为不空
	 * 
	 * @param array
	 *            数组
	 * @return 若数组不为null, 而且长度不为0, 则返回true, 否则返回false
	 */
	public static boolean isNotEmpty(double[] array) {
		return !isEmpty(array);
	}

	/**
	 * 数组是否为不空
	 * 
	 * @param array
	 *            数组
	 * @return 若数组不为null, 而且长度不为0, 则返回true, 否则返回false
	 */
	public static boolean isNotEmpty(float[] array) {
		return !isEmpty(array);
	}

	/**
	 * 数组是否为不空
	 * 
	 * @param array
	 *            数组
	 * @return 若数组不为null, 而且长度不为0, 则返回true, 否则返回false
	 */
	public static boolean isNotEmpty(int[] array) {
		return !isEmpty(array);
	}

	/**
	 * 数组是否为不空
	 * 
	 * @param array
	 *            数组
	 * @return 若数组不为null, 而且长度不为0, 则返回true, 否则返回false
	 */
	public static boolean isNotEmpty(long[] array) {
		return !isEmpty(array);
	}

	/**
	 * 数组是否为不空
	 * 
	 * @param array
	 *            数组
	 * @return 若数组不为null, 而且长度不为0, 则返回true, 否则返回false
	 */
	public static boolean isNotEmpty(short[] array) {
		return !isEmpty(array);
	}

	/**
	 * 判断参数是否是一个数组
	 * 
	 * @param obj
	 *            对象
	 * @return
	 */
	public static boolean isArray(Object obj) {
		return obj != null && obj.getClass().isArray();
	}

	/**
	 * 将参数组装成数组
	 * 
	 * @param obj
	 *            参数对象
	 * @return
	 */
	public static <E> E[] asArray(E... obj) {
		return obj;
	}

	/**
	 * 将参数集合转换为数组表示
	 * 
	 * @param collection
	 *            集合参数
	 * @return
	 */
	public static <E> E[] asArray(Collection<E> collection) {
		if (collection == null || collection.size() == 0) {
			return null;
		}
		int length = collection.size();
		E e = collection.iterator().next();
		@SuppressWarnings("unchecked")
		E[] array = (E[]) Array.newInstance(e.getClass(), length);
		return collection.toArray(array);
	}

	/**
	 * 获取数组元素的实际数据类型
	 * 
	 * @param array
	 *            数组
	 * @return
	 */
	public static <E> Class<E> getElementType(E[] array) {
		Class<?> clas = array.getClass();
		@SuppressWarnings("unchecked")
		Class<E> type = (Class<E>) clas.getComponentType();
		return type;
	}

	/**
	 * 获取数组元素的实际数据类型
	 * 
	 * @param array
	 *            数组
	 * @return
	 */
	public static Class<?> getElementType(Object array) {
		if (!isArray(array)) {
			throw new IllegalArgumentException("argument must be an array");
		}
		return array.getClass().getComponentType();
	}

	/**
	 * 数组转化为List
	 * 
	 * @param array
	 *            数组
	 * @return
	 */
	public static <E> List<E> toList(E[] array) {
		return Arrays.asList(array);
	}

	/**
	 * 数组转化为List
	 * 
	 * @param array
	 *            数组
	 * @return
	 */
	public static List<Boolean> toList(boolean[] array) {
		int length = Array.getLength(array);
		return asList(new Boolean[length], array, length);
	}

	/**
	 * 数组转化为List
	 * 
	 * @param array
	 *            数组
	 * @return
	 */
	public static List<Byte> toList(byte[] array) {
		int length = Array.getLength(array);
		return asList(new Byte[length], array, length);
	}

	/**
	 * 数组转化为List
	 * 
	 * @param array
	 *            数组
	 * @return
	 */
	public static List<Character> toList(char[] array) {
		int length = Array.getLength(array);
		return asList(new Character[length], array, length);
	}

	/**
	 * 数组转化为List
	 * 
	 * @param array
	 *            数组
	 * @return
	 */
	public static List<Double> toList(double[] array) {
		int length = Array.getLength(array);
		return asList(new Double[length], array, length);
	}

	/**
	 * 数组转化为List
	 * 
	 * @param array
	 *            数组
	 * @return
	 */
	public static List<Float> toList(float[] array) {
		int length = Array.getLength(array);
		return asList(new Float[length], array, length);
	}

	/**
	 * 数组转化为List
	 * 
	 * @param array
	 *            数组
	 * @return
	 */
	public static List<Integer> toList(int[] array) {
		int length = Array.getLength(array);
		return asList(new Integer[length], array, length);
	}

	/**
	 * 数组转化为List
	 * 
	 * @param array
	 *            数组
	 * @return
	 */
	public static List<Long> toList(long[] array) {
		int length = Array.getLength(array);
		return asList(new Long[length], array, length);
	}

	/**
	 * 数组转化为List
	 * 
	 * @param array
	 *            数组
	 * @return
	 */
	public static List<Short> toList(short[] array) {
		int length = Array.getLength(array);
		return asList(new Short[length], array, length);
	}

	/**
	 * 数组元素中是否包含参数对象
	 * 
	 * @param array
	 *            数组
	 * @param arg
	 *            元素参数
	 * @return
	 */
	public static <E> boolean contains(E[] array, E arg) {
		return indexOf(array, arg) >= 0;
	}

	/**
	 * 数组元素中是否包含参数对象
	 * 
	 * @param array
	 *            数组
	 * @param arg
	 *            元素参数
	 * @return
	 */
	public static boolean contains(byte[] array, byte arg) {
		return indexOf(array, arg) >= 0;
	}

	/**
	 * 数组元素中是否包含参数对象
	 * 
	 * @param array
	 *            数组
	 * @param arg
	 *            元素参数
	 * @return
	 */
	public static boolean contains(char[] array, char arg) {
		return indexOf(array, arg) >= 0;
	}

	/**
	 * 数组元素中是否包含参数对象
	 * 
	 * @param array
	 *            数组
	 * @param arg
	 *            元素参数
	 * @return
	 */
	public static boolean contains(short[] array, short arg) {
		return indexOf(array, arg) >= 0;
	}

	/**
	 * 数组元素中是否包含参数对象
	 * 
	 * @param array
	 *            数组
	 * @param arg
	 *            元素参数
	 * @return
	 */
	public static boolean contains(int[] array, int arg) {
		return indexOf(array, arg) >= 0;
	}

	/**
	 * 数组元素中是否包含参数对象
	 * 
	 * @param array
	 *            数组
	 * @param arg
	 *            元素参数
	 * @return
	 */
	public static boolean contains(long[] array, long arg) {
		return indexOf(array, arg) >= 0;
	}

	/**
	 * 数组元素中是否包含参数对象
	 * 
	 * @param array
	 *            数组
	 * @param arg
	 *            元素参数
	 * @return
	 */
	public static boolean contains(float[] array, float arg) {
		return indexOf(array, arg) >= 0;
	}

	/**
	 * 数组元素中是否包含参数对象
	 * 
	 * @param array
	 *            数组
	 * @param arg
	 *            元素参数
	 * @return
	 */
	public static boolean contains(double[] array, double arg) {
		return indexOf(array, arg) >= 0;
	}

	/**
	 * 数组元素中是否包含参数对象
	 * 
	 * @param array
	 *            数组
	 * @param arg
	 *            元素参数
	 * @return
	 */
	public static boolean contains(boolean[] array, boolean arg) {
		return indexOf(array, arg) >= 0;
	}

	/**
	 * 元素所在数组的索引
	 * 
	 * @param array
	 *            数组
	 * @param element
	 *            元素
	 * @return 若数组中不存在该元素, 则返回-1
	 */
	public static <E> int indexOf(E[] array, E element) {
		int size = array.length;
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (array[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (element.equals(array[i])) {
					return i;
				}
			}
		}
		return -1;
	}

	/**
	 * 元素所在数组的索引
	 * 
	 * @param array
	 *            数组
	 * @param element
	 *            元素
	 * @return 若数组中不存在该元素, 则返回-1
	 */
	public static int indexOf(boolean[] array, boolean element) {
		return indexFrom(array, element);
	}

	/**
	 * 元素所在数组的索引
	 * 
	 * @param array
	 *            数组
	 * @param element
	 *            元素
	 * @return 若数组中不存在该元素, 则返回-1
	 */
	public static int indexOf(byte[] array, byte element) {
		return indexFrom(array, element);
	}

	/**
	 * 元素所在数组的索引
	 * 
	 * @param array
	 *            数组
	 * @param element
	 *            元素
	 * @return 若数组中不存在该元素, 则返回-1
	 */
	public static int indexOf(char[] array, char element) {
		return indexFrom(array, element);
	}

	/**
	 * 元素所在数组的索引
	 * 
	 * @param array
	 *            数组
	 * @param element
	 *            元素
	 * @return 若数组中不存在该元素, 则返回-1
	 */
	public static int indexOf(double[] array, double element) {
		return indexFrom(array, element);
	}

	/**
	 * 元素所在数组的索引
	 * 
	 * @param array
	 *            数组
	 * @param element
	 *            元素
	 * @return 若数组中不存在该元素, 则返回-1
	 */
	public static int indexOf(float[] array, float element) {
		return indexFrom(array, element);
	}

	/**
	 * 元素所在数组的索引
	 * 
	 * @param array
	 *            数组
	 * @param element
	 *            元素
	 * @return 若数组中不存在该元素, 则返回-1
	 */
	public static int indexOf(int[] array, int element) {
		return indexFrom(array, element);
	}

	/**
	 * 元素所在数组的索引
	 * 
	 * @param array
	 *            数组
	 * @param element
	 *            元素
	 * @return 若数组中不存在该元素, 则返回-1
	 */
	public static int indexOf(long[] array, long element) {
		return indexFrom(array, element);
	}

	/**
	 * 元素所在数组的索引
	 * 
	 * @param array
	 *            数组
	 * @param element
	 *            元素
	 * @return 若数组中不存在该元素, 则返回-1
	 */
	public static int indexOf(short[] array, short element) {
		return indexFrom(array, element);
	}
	
	/**
	 * 列举
	 * 
	 * @param array
	 *            数组
	 * @return
	 */
	public static <E> Enumeration<E> enumeration(E[] array) {
		return new ArrayEnumeration<E>(array);
	}

	/**
	 * 元素所在数组的索引
	 * 
	 * @param array
	 *            数组
	 * @param element
	 *            元素
	 * @return 若数组中不存在该元素, 则返回-1
	 */
	private static int indexFrom(Object array, Object element) {
		int length = Array.getLength(array);
		for (int i = 0; i < length; i++) {
			Object e = Array.get(array, i);
			if (element.equals(e)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 数组转化为List
	 * 
	 * @param target
	 *            目标数组
	 * @param origin
	 *            源数组对象
	 * @param length
	 *            数组长度
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static <E> List<E> asList(E[] target, Object origin, int length) {
		// java.lang.ArrayStoreException
		// System.arraycopy(origin, 0, target, 0, length);
		for (int i = 0; i < length; i++) {
			target[i] = (E) Array.get(origin, i);
		}
		return Arrays.asList(target);
	}
	
	/**
	 * 数组列举
	 * 
	 * @author Lychie Fan
	 */
	private static class ArrayEnumeration<E> implements Enumeration<E> {

		private E[] es;
		private int index;
		private int length;

		private ArrayEnumeration(E[] es) {
			this.es = es;
			this.length = es.length;
		}

		@Override
		public boolean hasMoreElements() {
			return index < length;
		}

		@Override
		public E nextElement() {
			return es[index++];
		}

	}

}