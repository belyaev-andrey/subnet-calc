package io.test.calc;

import java.util.Objects;

public class Subnet {

    private final IpV4Address address;
    private final Integer bits;

    public Subnet(IpV4Address address, Integer bits) {
        this.address = address;
        this.bits = bits;
    }

    public IpV4Address getAddress() {
        return address;
    }

    public Integer getBits() {
        return bits;
    }

    @Override
    public String toString() {
        return String.format("%s/%d", address, bits);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subnet subnet = (Subnet) o;
        return address.equals(subnet.address) &&
                bits.equals(subnet.bits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, bits);
    }
}
