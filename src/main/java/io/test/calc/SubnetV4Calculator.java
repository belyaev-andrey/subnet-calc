package io.test.calc;

import java.util.List;
import java.util.stream.Collectors;

public class SubnetV4Calculator {

    /**
     * Calculates minimum subnet for a given address list.
     * @param addressList list of addresses.
     * @return subnet in 192.168.1.0/24 format.
     * @throws IllegalArgumentException if address list is empty.
     */
    public Subnet calculateMinimalSubnet(List<IpV4Address> addressList) {

        if (addressList == null || addressList.size() == 0) {
            throw new IllegalArgumentException("Address list must not be empty");
        }

        int subnetBits = 32;
        int subnetMask = 0b11111111_11111111_11111111_11111111;

        return doCalc(addressList.stream().map(IpV4Address::getAddressAsInt).collect(Collectors.toList()), subnetMask, subnetBits);
    }

    private Subnet doCalc(List<Integer> addressList, int subnetMask, int subnetBits) {
        List<Integer> maskedAddresses = addressList.stream().map(e -> e & subnetMask).collect(Collectors.toList());
        if (allNumbersEqual(maskedAddresses)) {
            Integer subnetAddress = addressList.stream().findFirst().orElseThrow();
            return new Subnet(new IpV4Address(subnetAddress), subnetBits);
        }
        return doCalc(maskedAddresses, subnetMask << 1, subnetBits-1);
    }

    private boolean allNumbersEqual(List<Integer> integerList) {
        return integerList.stream().distinct().count() <= 1;
    }

}
