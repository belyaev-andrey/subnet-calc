package io.test.calc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class IpV4AddressTest {

    @Test
    public void testAddressCreation() {
        IpV4Address address = new IpV4Address(192, 168, 1, 0);
        Assertions.assertEquals("192.168.1.0", address.toString());
    }

    @Test
    public void testAddressCreationHex() {
        IpV4Address address = new IpV4Address(0x01, 0xFE, 0x10, 0x0F);
        Assertions.assertEquals("1.254.16.15", address.toString());
    }

    @Test
    public void testAddressCreationBin() {
        IpV4Address address = new IpV4Address(0b10000000, 0b11110000, 0b00000010, 0b00001100);
        Assertions.assertEquals("128.240.2.12", address.toString());
    }

    @Test
    public void testAddressCreationInt() {
        IpV4Address address = new IpV4Address(0b10000000_11110000_00000010_00001100);
        Assertions.assertEquals("128.240.2.12", address.toString());
    }

    @Test
    public void testAddressAsInt() {
        IpV4Address address = new IpV4Address(0b10000000_11110000_00000010_00001100);
        Assertions.assertEquals(0b10000000_11110000_00000010_00001100, address.getAddressAsInt());
    }


    @Test
    public void compareEqualIpAddresses() {
        IpV4Address address1 = new IpV4Address(192, 168, 1, 0);
        IpV4Address address2 = new IpV4Address(192, 168, 1, 0);
        Assertions.assertEquals(0, address1.compareTo(address2));
        Assertions.assertEquals(address1, address2);
        Assertions.assertEquals(address2, address1);
    }

    @Test
    public void compareIpAddressesSameSubnet() {
        IpV4Address address1 = new IpV4Address(192, 168, 1, 1);
        IpV4Address address2 = new IpV4Address(192, 168, 1, 2);
        Assertions.assertTrue(address1.compareTo(address2) < 0);
        Assertions.assertTrue(address2.compareTo(address1) > 0);
    }

    @Test
    public void compareIpAddressesDifferentSubnets() {
        IpV4Address address1 = new IpV4Address(191, 232, 1, 1);
        IpV4Address address2 = new IpV4Address(192, 168, 4, 2);
        Assertions.assertTrue(address1.compareTo(address2) < 0);
        Assertions.assertTrue(address2.compareTo(address1) > 0);
    }


}
