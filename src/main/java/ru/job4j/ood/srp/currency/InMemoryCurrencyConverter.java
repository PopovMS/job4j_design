package ru.job4j.ood.srp.currency;

public class InMemoryCurrencyConverter implements CurrencyConverter {
    private static final int CURRENCIES_COUNT = Currency.values().length;
    private final double[][] conversationTable = new double[CURRENCIES_COUNT][CURRENCIES_COUNT];

    public InMemoryCurrencyConverter() {
        this.conversationTable[Currency.RUB.ordinal()][Currency.USD.ordinal()] = 0.01;
        this.conversationTable[Currency.RUB.ordinal()][Currency.EUR.ordinal()] = 0.0098;
        this.conversationTable[Currency.USD.ordinal()][Currency.EUR.ordinal()] = 0.96;
        this.conversationTable[Currency.USD.ordinal()][Currency.RUB.ordinal()] = 97.66D;
        this.conversationTable[Currency.EUR.ordinal()][Currency.USD.ordinal()] = 1.04;
        this.conversationTable[Currency.EUR.ordinal()][Currency.RUB.ordinal()] = 101.55D;
    }

    @Override
    public double convert(Currency source, double sourceValue, Currency target) {
        return sourceValue * conversationTable[source.ordinal()][target.ordinal()];
    }
}
