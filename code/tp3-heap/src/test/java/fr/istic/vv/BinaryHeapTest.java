package fr.istic.vv;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BinaryHeapTest {
    @Test
    void testPop() {
        BinaryHeap<Integer> heap = new BinaryHeap<>(Integer::compareTo);
        for (int i=0;i<15;i++){
            Random random = new Random();
            heap.push(random.nextInt(20));
        }

        assertEquals(15, heap.count());
        Random random = new Random();
        int nb;
        nb = random.nextInt(15);
        for (int i=0;i<nb;i++){
            heap.pop();
        }

        assertEquals(15-nb, heap.count());
    }

    @Test
    void testPeak() {
        BinaryHeap<Integer> heap = new BinaryHeap<>(Integer::compareTo);
        for (int i=0;i<15;i++){
            Random random = new Random();
            heap.push(random.nextInt(20));
        }
        heap.push(0);
        assertEquals(16, heap.count());
        assertEquals(0, heap.peek());
        assertEquals(0, heap.peek());
        assertEquals(16, heap.count());
        for (int i=0;i<16;i++){
            heap.pop();
        }
        assertNull(heap.peek());
    }

    @Test
    void testPush() {
        BinaryHeap<Integer> heap = new BinaryHeap<>(Integer::compareTo);
        heap.push(1);
        heap.push(2);
        heap.push(3);
        assertEquals(3, heap.count());

        heap = new BinaryHeap<>(Integer::compareTo);
        for (int i = 0; i < 100; i++) {
            heap.push(i);
        }
        getaVoid(heap);
    }

    private static void getaVoid(BinaryHeap<Integer> heap) {
        assertEquals(100, heap.count());
    }

    @Test
    void testCount() {
        BinaryHeap<Integer> heap = new BinaryHeap<>(Integer::compareTo);
        heap.push(2);
        assertEquals(1, heap.count());
        heap.pop();
        assertEquals(0, heap.count());

        Random random = new Random();
        int taille = random.nextInt(50);
        for (int i=0;i<taille;i++){
            Random rand = new Random();
            heap.push(rand.nextInt(20));
        }
        assertEquals(taille, heap.count());
    }


}