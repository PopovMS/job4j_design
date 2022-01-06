package ru.job4j.tree;

import java.util.*;

/**
 * Класс реализует интерфейс Tree
 * @param <E>
 */
public class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    /**
     * Метод находит узел по значению parent с помощью метода findBy() и добавляет в него дочерний узел
     * со значением child.
     * @param parent - принимает значение искомого родительского узла
     * @param child - принимает значение добавляемого дочернего узла
     * @return Возвращает true, если значение child добавлено,
     * и false, если значение узел со значением child уже есть в дереве
     */
    @Override
    public boolean add(E parent, E child) {
        boolean rsl = findBy(parent).isPresent() && findBy(child).isEmpty();
        if (rsl) {
            Node<E> pNode = findBy(parent).get();
            Node<E> chNode = new Node<>(child);
            pNode.children.add(chNode);
        }
        return rsl;
    }

    /**
     * Метод находит узел по значению
     * @param value принимает значение искомого узла
     * @return возвращает Optional объект с узлом
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}