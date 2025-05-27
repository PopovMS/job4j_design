package ru.job4j.ood.lsp;

public class Penguin implements Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Пингвины не летают"); /* Нарушение LSP */
    }
}
/* Причина нарушения: Penguin нарушает контракт интерфейса Bird, добавляя дополнительное предусловие (исключение) */