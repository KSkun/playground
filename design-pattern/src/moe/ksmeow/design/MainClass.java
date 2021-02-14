package moe.ksmeow.design;

import moe.ksmeow.design.observer.ObserverExample;

public class MainClass {
    private static ObserverExample example;

    public static void main(String[] args) {
        example = new ObserverExample();

        example.runExample();
    }
}
