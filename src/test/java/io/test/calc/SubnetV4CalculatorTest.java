package io.test.calc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * I guess I should implement something more "correct" from the math point of view,
 * but I don't want to check all possible subnets and addresses for now.
 */
public class SubnetV4CalculatorTest {

    @Test
    public void test0subnet() {

        List<IpV4Address> addressList = Arrays.asList(
                new IpV4Address(0, 0, 0, 1)
                , new IpV4Address(192, 168, 22, 253)
                , new IpV4Address(254, 254, 254, 254));

        SubnetV4Calculator calc = new SubnetV4Calculator();

        Subnet subnet = calc.calculateMinimalSubnet(addressList);

        Assertions.assertEquals(new Subnet(new IpV4Address(0, 0, 0, 0), 0), subnet);
    }

    @Test
    public void test12subnet() {

        List<IpV4Address> addressList = Arrays.asList(
                new IpV4Address(172, 16, 0, 1)
                , new IpV4Address(172, 20, 11, 253)
                , new IpV4Address(172, 31, 253, 3));

        SubnetV4Calculator calc = new SubnetV4Calculator();

        Subnet subnet = calc.calculateMinimalSubnet(addressList);

        Assertions.assertEquals(new Subnet(new IpV4Address(172, 16, 0, 0), 12), subnet);
    }

    @Test
    public void test16subnet() {

        List<IpV4Address> addressList = Arrays.asList(
                new IpV4Address(192, 168, 21, 1)
                , new IpV4Address(192, 168, 22, 253)
                , new IpV4Address(192, 168, 253, 3));

        SubnetV4Calculator calc = new SubnetV4Calculator();

        Subnet subnet = calc.calculateMinimalSubnet(addressList);

        Assertions.assertEquals(new Subnet(new IpV4Address(192, 168, 0, 0), 16), subnet);
    }

    @Test
    public void test24subnet() {

        List<IpV4Address> addressList = Arrays.asList(
                new IpV4Address(192, 168, 22, 1)
                , new IpV4Address(192, 168, 22, 253)
                , new IpV4Address(192, 168, 22, 3));

        SubnetV4Calculator calc = new SubnetV4Calculator();

        Subnet subnet = calc.calculateMinimalSubnet(addressList);

        Assertions.assertEquals(new Subnet(new IpV4Address(192, 168, 22, 0), 24), subnet);
    }

    @Test
    public void test25subnet1() {

        List<IpV4Address> addressList = Arrays.asList(
                new IpV4Address(192, 168, 1, 3)
                , new IpV4Address(192, 168, 1, 38)
                , new IpV4Address(192, 168, 1, 126));

        SubnetV4Calculator calc = new SubnetV4Calculator();

        Subnet subnet = calc.calculateMinimalSubnet(addressList);

        Assertions.assertEquals(new Subnet(new IpV4Address(192, 168, 1, 0), 25), subnet);
    }

    @Test
    public void test25subnet2() {

        List<IpV4Address> addressList = Arrays.asList(
                new IpV4Address(192, 168, 1, 129)
                , new IpV4Address(192, 168, 1, 211)
                , new IpV4Address(192, 168, 1, 254));

        SubnetV4Calculator calc = new SubnetV4Calculator();

        Subnet subnet = calc.calculateMinimalSubnet(addressList);

        Assertions.assertEquals(new Subnet(new IpV4Address(192, 168, 1, 128), 25), subnet);
    }

    @Test
    public void test26subnet1() {

        List<IpV4Address> addressList = Arrays.asList(
                new IpV4Address(192, 168, 1, 1)
                , new IpV4Address(192, 168, 1, 35)
                , new IpV4Address(192, 168, 1, 61));

        SubnetV4Calculator calc = new SubnetV4Calculator();

        Subnet subnet = calc.calculateMinimalSubnet(addressList);

        Assertions.assertEquals(new Subnet(new IpV4Address(192, 168, 1, 0), 26), subnet);
    }

    @Test
    public void test26subnet2() {

        List<IpV4Address> addressList = Arrays.asList(
                new IpV4Address(192, 168, 1, 65)
                , new IpV4Address(192, 168, 1, 101)
                , new IpV4Address(192, 168, 1, 126));

        SubnetV4Calculator calc = new SubnetV4Calculator();

        Subnet subnet = calc.calculateMinimalSubnet(addressList);

        Assertions.assertEquals(new Subnet(new IpV4Address(192, 168, 1, 64), 26), subnet);
    }

    @Test
    public void test27subnet1() {

        List<IpV4Address> addressList = Arrays.asList(
                new IpV4Address(192, 168, 1, 1)
                , new IpV4Address(192, 168, 1, 3)
                , new IpV4Address(192, 168, 1, 29));

        SubnetV4Calculator calc = new SubnetV4Calculator();

        Subnet subnet = calc.calculateMinimalSubnet(addressList);

        Assertions.assertEquals(new Subnet(new IpV4Address(192, 168, 1, 0), 27), subnet);
    }

    @Test
    public void test27subnet2() {

        List<IpV4Address> addressList = Arrays.asList(
                new IpV4Address(192, 168, 1, 33)
                , new IpV4Address(192, 168, 1, 41)
                , new IpV4Address(192, 168, 1, 62));

        SubnetV4Calculator calc = new SubnetV4Calculator();

        Subnet subnet = calc.calculateMinimalSubnet(addressList);

        Assertions.assertEquals(new Subnet(new IpV4Address(192, 168, 1, 32), 27), subnet);
    }

    @Test
    public void test32subnetSingleEntry() {

        List<IpV4Address> addressList = Collections.singletonList(
                new IpV4Address(192, 168, 1, 33));

        SubnetV4Calculator calc = new SubnetV4Calculator();

        Subnet subnet = calc.calculateMinimalSubnet(addressList);

        Assertions.assertEquals(new Subnet(new IpV4Address(192, 168, 1, 33), 32), subnet);
    }

    @Test
    public void testEmptyList() {

        List<IpV4Address> addressList = Collections.emptyList();

        SubnetV4Calculator calc = new SubnetV4Calculator();

        Assertions.assertThrows(IllegalArgumentException.class, () -> calc.calculateMinimalSubnet(addressList));
    }


}
