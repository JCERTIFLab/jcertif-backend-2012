/**
 * 
 */
package com.jcertif.bo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;

import com.evasion.framework.test.AccessorTester;
import com.evasion.framework.test.ReflectionUtils;

/**
 * @author rossi.oddet
 * 
 */
public class JCertifAccessorTesterImpl implements AccessorTester {

	private static final int INT_TEST_VALUE = RandomUtils.nextInt();
	private static final long LONG_TEST_VALUE = RandomUtils.nextLong();
	private static final byte BYTE_TEST_VALUE = (byte) RandomUtils.nextInt();
	private static final char CHAR_TEST_VALUE = 'a';
	private static final boolean BOOLEAN_TEST_VALUE = RandomUtils.nextBoolean();
	private static final double DOUBLE_TEST_VALUE = RandomUtils.nextDouble();
	private static final float FLOAT_TEST_VALUE = RandomUtils.nextFloat();
	private static final short SHORT_TEST_VALUE = (short) RandomUtils.nextInt();

	/** bean containing the accessors to test */
	private Object bean;

	/**
	 * Constructor.
	 * 
	 * @param bean
	 *            the object containing the accessors to test.
	 */
	public JCertifAccessorTesterImpl(final Object bean) {
		super();
		this.bean = bean;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void testAccessor(final String propertyName) {
		if (StringUtils.isBlank(propertyName)) {
			throw new IllegalArgumentException(
					"Property 'propertyName' can not be null \n");
		}
		final Class<?> propertyType = ReflectionUtils.getPropertyType(bean,
				propertyName);
		if (propertyType == null) {
			Assert.fail("Property name not found " + propertyName);
		}
		this.testAccessor(propertyName, this.getTestValueForType(propertyType));
	}

	/**
	 * Returns a test value for a type
	 * 
	 * @param propertyType
	 *            the type
	 * @return a value
	 */
	private Object getTestValueForType(final Class<?> propertyType) {
		Object result = null;

		try {
			if (propertyType.isPrimitive()) {
				if (Integer.TYPE.equals(propertyType)) {
					result = INT_TEST_VALUE;
				} else if (Long.TYPE.equals(propertyType)) {
					result = LONG_TEST_VALUE;
				} else if (Byte.TYPE.equals(propertyType)) {
					result = BYTE_TEST_VALUE;
				} else if (Short.TYPE.equals(propertyType)) {
					result = SHORT_TEST_VALUE;
				} else if (Character.TYPE.equals(propertyType)) {
					result = CHAR_TEST_VALUE;
				} else if (Double.TYPE.equals(propertyType)) {
					result = DOUBLE_TEST_VALUE;
				} else if (Float.TYPE.equals(propertyType)) {
					result = FLOAT_TEST_VALUE;
				} else if (Boolean.TYPE.equals(propertyType)) {
					result = BOOLEAN_TEST_VALUE;
				}
			} else {
				if (Long.class.isAssignableFrom(propertyType)) {
					result = Long.valueOf(LONG_TEST_VALUE);
				} else if (Boolean.class.isAssignableFrom(propertyType)) {
					result = Boolean.valueOf(BOOLEAN_TEST_VALUE);
				} else if (Double.class.isAssignableFrom(propertyType)) {
					result = new Double(DOUBLE_TEST_VALUE);
				} else if (Float.class.isAssignableFrom(propertyType)) {
					result = new Float(FLOAT_TEST_VALUE);
				} else if (Integer.class.isAssignableFrom(propertyType)) {
					result = Integer.valueOf(INT_TEST_VALUE);
				} else if (Byte.class.isAssignableFrom(propertyType)) {
					result = Byte.valueOf(BYTE_TEST_VALUE);
				} else if (Short.class.isAssignableFrom(propertyType)) {
					result = Short.valueOf(SHORT_TEST_VALUE);
				} else if (Character.class.isAssignableFrom(propertyType)) {
					result = Character.valueOf(CHAR_TEST_VALUE);
				} else if (Calendar.class.isAssignableFrom(propertyType)) {
					result = Calendar.getInstance();
				} else if (List.class.isAssignableFrom(propertyType)) {
					result = new ArrayList<Object>();
				} else if (Set.class.isAssignableFrom(propertyType)) {
					result = new HashSet<Object>();
				} else if (propertyType.isEnum()) {
					result = (propertyType.getEnumConstants())[0];
				} else {
					result = propertyType.newInstance();
				}
			}
		} catch (InstantiationException e) {
			Assert.fail("No default constructor for property type "
					+ propertyType);
		} catch (IllegalAccessException e) {
			Assert.fail("No public default constructor for property type "
					+ propertyType);
		}

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void testAccessor(final String propertyName, final Object value) {
		if (value == null) {
			throw new IllegalArgumentException(
					"Property 'value' can not be null \n");
		}
		if (StringUtils.isBlank(propertyName)) {
			throw new IllegalArgumentException(
					"Property 'propertyName' can not be null \n");
		}
		final Method getter = ReflectionUtils.findGetter(bean, propertyName);
		if (getter == null) {
			Assert.fail("Missing getter for property '" + propertyName + "'");
		}

		final Method setter = ReflectionUtils.findSetter(bean, propertyName);
		if (setter == null) {
			Assert.fail("Missing setter for property '" + propertyName + "'");
		}

		try {
			ReflectionUtils.makeAccessible(getter);
			ReflectionUtils.makeAccessible(setter);

			setter.invoke(bean, value);
			final Object result = getter.invoke(bean);

			if (getter.getReturnType().isPrimitive()) {
				Assert.assertEquals(value, result);
			} else {
				Assert.assertSame("For propertyName :" + propertyName, value,
						result);
			}

		} catch (IllegalArgumentException e) {
			Assert.fail("Wrong argument while invoking getter or setter for property '"
					+ propertyName
					+ " and value "
					+ value
					+ "'\n"
					+ e.getMessage());
		} catch (IllegalAccessException e) {
			Assert.fail("Unable to invoke getter or setter, are they accessible ? \n"
					+ e.getMessage());
		} catch (InvocationTargetException e) {
			Assert.fail("Error while invoking getter or setter for property '"
					+ propertyName + "' \n" + e.getMessage());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void testAccessors(final String[] propertyNames) {
		if (propertyNames == null || propertyNames.length == 0) {
			throw new IllegalArgumentException(
					"Property 'propertyNames' can not be null or empty\n");
		}
		for (String propertyName : propertyNames) {
			this.testAccessor(propertyName);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void testAllAccessors() {
		this.testAllAccessors(new String[] {});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void testAllAccessors(final String[] exclusions) {
		if (exclusions == null) {
			throw new IllegalArgumentException(
					"Property 'exclusions' can not be null\n");
		}
		final List<String> propertyNames = ReflectionUtils
				.findAllProperties(bean);
		propertyNames.removeAll(Arrays.asList(exclusions));
		if (propertyNames.isEmpty()) {
			Assert.fail("This bean has no getter/setter");
		}
		this.testAccessors(propertyNames.toArray(new String[propertyNames
				.size()]));
	}

}