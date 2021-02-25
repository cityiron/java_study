```java
    private void expungeStaleEntries() {
        // 1. for 循环遍历每一个被清除对象的 Entry
        for (Object x; (x = queue.poll()) != null; ) {
            // 2. 加锁删除
            synchronized (queue) {
                @SuppressWarnings("unchecked")
                    Entry<K,V> e = (Entry<K,V>) x;
                // 3. 计算此 entry 在桶的位置，并找到 Entry
                int i = indexFor(e.hash, table.length);

                Entry<K,V> prev = table[i];
                Entry<K,V> p = prev;
                // 4. while 循环移动指针进行删除
                while (p != null) {
                    Entry<K,V> next = p.next;
                    if (p == e) {
                        if (prev == e)
                            table[i] = next;
                        else
                            prev.next = next;
                        // Must not null out e.next;
                        // stale entries may be in use by a HashIterator
                        e.value = null; // Help GC
                        size--;
                        break;
                    }
                    prev = p;
                    p = next;
                }
            }
        }
    }
```