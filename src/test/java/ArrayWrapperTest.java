import hw16.task1.ArrayWrapper;
import hw16.task1.IncorrectArrayWrapperIndex;
import hw16.task1.User;
import org.junit.Assert;
import org.junit.Test;

public class ArrayWrapperTest {
    @Test
    public void testGet_String() {
        ArrayWrapper<String> wrapper = new ArrayWrapper<>(new String[]{"1", "2", "3", "4"});
        Assert.assertEquals("2", wrapper.get(2));
    }

    @Test
    public void testGet_Int() {
        ArrayWrapper<Integer> wrapper = new ArrayWrapper<>(new Integer[]{1, 2, 3, 4, 5});
        Assert.assertEquals(Integer.valueOf(4), wrapper.get(4));
    }

    @Test
    public void testGet_CustomClass() {
        User user = new User("first1", "last1");
        ArrayWrapper<User> wrapper = new ArrayWrapper<>(new User[]{null, null, user, null});
        Assert.assertEquals(user, wrapper.get(3));
    }

    @Test(expected = IncorrectArrayWrapperIndex.class)
    public void testGet_LowerBound1() {
        ArrayWrapper<Integer> wrapper = new ArrayWrapper<>(new Integer[]{1, 2, 3});
        wrapper.get(0);
    }

    @Test(expected = IncorrectArrayWrapperIndex.class)
    public void testGet_LowerBound2() {
        ArrayWrapper<Double> wrapper = new ArrayWrapper<>(new Double[]{1., 2., 3.});
        wrapper.get(-2);
    }

    @Test(expected = IncorrectArrayWrapperIndex.class)
    public void testGet_UpperBound1() {
        ArrayWrapper<String> wrapper = new ArrayWrapper<>(new String[]{"1", "2", "3"});
        wrapper.get(4);
    }

    @Test(expected = IncorrectArrayWrapperIndex.class)
    public void testGet_UpperBound2() {
        ArrayWrapper<Long> wrapper = new ArrayWrapper<>(new Long[]{1L, 2L, 3L});
        wrapper.get(10);
    }

    @Test
    public void testReplace_StringReplaced() {
        ArrayWrapper<String> wrapper = new ArrayWrapper<>(new String[]{"1", "2", "3"});
        boolean isReplaced = wrapper.replace(2, "new2");

        Assert.assertTrue(isReplaced);
        Assert.assertEquals("1", wrapper.get(1));
        Assert.assertEquals("new2", wrapper.get(2));
        Assert.assertEquals("3", wrapper.get(3));
    }

    @Test
    public void testReplace_IntReplaced() {
        ArrayWrapper<Integer> wrapper = new ArrayWrapper<>(new Integer[]{1, 2, 3, 4, 5});
        boolean isReplaced = wrapper.replace(2, 9);

        Assert.assertTrue(isReplaced);
        Assert.assertEquals(Integer.valueOf(1), wrapper.get(1));
        Assert.assertEquals(Integer.valueOf(9), wrapper.get(2));
        Assert.assertEquals(Integer.valueOf(3), wrapper.get(3));
        Assert.assertEquals(Integer.valueOf(4), wrapper.get(4));
        Assert.assertEquals(Integer.valueOf(5), wrapper.get(5));
    }

    @Test
    public void testReplace_StringNotReplaced1() {
        ArrayWrapper<String> wrapper = new ArrayWrapper<>(new String[]{"string1", "string2", "string3"});
        boolean isReplaced = wrapper.replace(1, "new1");

        Assert.assertFalse(isReplaced);
        Assert.assertEquals("string1", wrapper.get(1));
        Assert.assertEquals("string2", wrapper.get(2));
        Assert.assertEquals("string3", wrapper.get(3));
    }

    @Test
    public void testReplace_StringNotReplaced2() {
        ArrayWrapper<String> wrapper = new ArrayWrapper<>(new String[]{"string1", "string2", "string3"});
        boolean isReplaced = wrapper.replace(2, "string9");

        Assert.assertFalse(isReplaced);
        Assert.assertEquals("string1", wrapper.get(1));
        Assert.assertEquals("string2", wrapper.get(2));
        Assert.assertEquals("string3", wrapper.get(3));
    }

    @Test
    public void testReplace_IntNotReplaced1() {
        ArrayWrapper<Integer> wrapper = new ArrayWrapper<>(new Integer[]{2, 3, 4, 5});
        boolean isReplaced = wrapper.replace(3, 1);

        Assert.assertFalse(isReplaced);
        Assert.assertEquals(Integer.valueOf(2), wrapper.get(1));
        Assert.assertEquals(Integer.valueOf(3), wrapper.get(2));
        Assert.assertEquals(Integer.valueOf(4), wrapper.get(3));
        Assert.assertEquals(Integer.valueOf(5), wrapper.get(4));
    }

    @Test
    public void testReplace_IntNotReplaced2() {
        ArrayWrapper<Integer> wrapper = new ArrayWrapper<>(new Integer[]{2, 3, 4});
        boolean isReplaced = wrapper.replace(2, 3);

        Assert.assertFalse(isReplaced);
        Assert.assertEquals(Integer.valueOf(2), wrapper.get(1));
        Assert.assertEquals(Integer.valueOf(3), wrapper.get(2));
        Assert.assertEquals(Integer.valueOf(4), wrapper.get(3));
    }
}
