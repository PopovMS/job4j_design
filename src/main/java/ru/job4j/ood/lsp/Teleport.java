package ru.job4j.ood.lsp;

public class Teleport extends Vehicle {
    @Override
    public void move(int distance) {
        /*
         телепортируется мгновенно в любую точку
         не сохраняет пройденное расстояние // Нарушение LSP

         */
    }
}
/*
Причина нарушения: Teleport изменяет постусловия метода move(),
что может привести к некорректной работе кода, ожидающего сохранение пройденного расстояния
 */
