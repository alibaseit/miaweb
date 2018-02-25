package com.miaweb;

import org.junit.Test;

import java.util.Optional;

/**
 * Created by dogan on 5/22/17.
 */
public class OptionalTest {
    @Test
    public void optionalUsbTest() {
        Optional<Computer> computer = Optional.ofNullable(new Computer());
        String usbVersion = computer.flatMap(Computer::getSoundCard)
                .flatMap(SoundCard::getUsb)
                .map(Usb::getVersion)
                .orElse("2.1");
        System.out.println(String.format("usb version is %s", usbVersion));
    }
}

class Computer {
    private Optional<SoundCard> soundCard = Optional.of(new SoundCard());

    public Optional<SoundCard> getSoundCard() {
        return soundCard;
    }
}

class SoundCard {
    private Usb usb = null;

    public Optional<Usb> getUsb() {
        return Optional.ofNullable(usb);
    }
}

class Usb {
    public String getVersion() {
        return "3.1";
    }
}