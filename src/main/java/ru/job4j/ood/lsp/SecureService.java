package ru.job4j.ood.lsp;

public class SecureService extends BaseService {
    public void processData() {  /* Нарушение LSP */
     /* защищенная обработка данных */
    }
}

/* Причина нарушения: SecureService уменьшает область видимости метода processData() */