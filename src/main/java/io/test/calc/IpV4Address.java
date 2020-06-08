package io.test.calc;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Using custom class for IP Address representation - it is simpler for me now.
 * Using integers and masks to simplify arithmetics.
 */

public class IpV4Address implements Comparable<IpV4Address>{

    private final int[] address = new int[4];

    public IpV4Address(int octet1, int octet2, int octet3, int octet4) {
        address[0] = octet1 & 0xFF;
        address[1] = octet2 & 0xFF;
        address[2] = octet3 & 0xFF;
        address[3] = octet4 & 0xFF;
    }

    public IpV4Address(Integer addressAsInt) {
        byte[] bytes = ByteBuffer.allocate(4).putInt(addressAsInt).array();
        for (int i = 0; i < 4; i++) {
            address[i] = bytes[i] & 0xFF;
        }
    }

    public int[] getAddress() {
        return Arrays.copyOf(address, 4);
    }

    public int getAddressAsInt() {
        return address[0] << 24 | address[1] << 16 | address[2] << 8 | address[3];
    }

    @Override
    public String toString() {
       return Arrays.stream(address).mapToObj(Integer::toString).collect(Collectors.joining("."));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IpV4Address that = (IpV4Address) o;
        return Arrays.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(address);
    }

    @Override
    public int compareTo(IpV4Address o) {
        return Arrays.compare(address, o.getAddress());
    }

}
