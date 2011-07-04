package gcUnrelatedTypes;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;
import com.google.common.collect.Table;

public class Guava {

    
    static class Pair<A,B> {
        final A a;
        final B b;
        public Pair(A a, B b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((a == null) ? 0 : a.hashCode());
            result = prime * result + ((b == null) ? 0 : b.hashCode());
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Pair other = (Pair) obj;
            if (a == null) {
                if (other.a != null)
                    return false;
            } else if (!a.equals(other.a))
                return false;
            if (b == null) {
                if (other.b != null)
                    return false;
            } else if (!b.equals(other.b))
                return false;
            return true;
        }
        
    }
    public static void testMultmap(Multimap<String, Integer> mm) {
        mm.containsEntry("x", "y");
        mm.containsEntry(1, 5);
        mm.containsKey(1);
        mm.containsValue("x");
        mm.remove("x", "x");
        mm.remove(1, 2);
        mm.removeAll(1);

    }

    public static void testMultmapOK(Multimap<String, Integer> mm) {
        mm.containsEntry("x", 1);
        mm.containsKey("x");
        mm.containsValue(1);
        mm.remove("x", 1);
        mm.removeAll("x");
    }
    public static void testMultmapOK2(Multimap<String, Pair<Integer,Long>> mm) {
        Pair<Integer, Long> p = new Pair<Integer, Long>(1, 1L);
        mm.containsEntry("x", p);
        mm.containsKey("x");
        mm.containsValue(p);
        mm.remove("x", p);
        mm.removeAll("x");
    }

    public static void testMultiset(Multiset<String> ms) {
        ms.contains(1);
        ms.count(1);
        ms.remove(1);
        ms.remove(1, 2);
    }

    public static void testTable(Table<String, Integer, Long> t) {
        t.contains("x", "x");
        t.contains(1, 1);
        t.containsRow(1);
        t.containsColumn("x");
        t.containsValue(1);
        t.get("x", "x");
        t.get(1, 1);
        t.remove("x", "x");
        t.remove(1, 1);
    }

    public static void testObjects() {
        Objects.equal("x", 1);
    }

    public static void testSets(Set<String> s1, Set<Integer> s2) {
        Sets.intersection(s1, s2);
        Sets.difference(s1, s2);
        Sets.symmetricDifference(s1, s2);
    }

    public static void testIterables(Iterable<String> i, Collection<Integer> c) {
        Iterables.contains(i, 1);
        Iterables.removeAll(i, c);
        Iterables.retainAll(i, c);
        Iterables.elementsEqual(i, c);
        Iterables.frequency(i, 1);
    }

    public static void testIterators(Iterator<String> i, Collection<Integer> c) {
        Iterators.contains(i, 1);
        Iterators.removeAll(i,c);
        Iterators.retainAll(i, c);
        Iterators.elementsEqual(i, c.iterator());
        Iterators.frequency(i, 1);
    }

}
