package com.example.tgarcia.nubay.Utilities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tgarcia on 1/28/2015.
 */
public class CollectionUtils
{
    public static interface Predicate<T>
    {
        boolean evaluate(T obj);
    }

    public static <T> List<T> filter(List<T> elements, Predicate test)
    {
        List<T> filtered = new ArrayList<T>();
        for(T element : elements)
        {
            if(test.evaluate(element))
            {
                filtered.add(element);
            }
        }
        return filtered;
    }

    public static class ContainsPredicate implements Predicate<String>
    {
        private String query;
        public ContainsPredicate(String query)
        {
            this.query = query;
        }

        @Override
        public boolean evaluate(String obj)
        {
            return obj.contains(query);
        }
    }

    public static class OrPredicate<T> implements Predicate<T>
    {
        private Predicate<T> predicateA;
        private Predicate<T> predicateB;
        public OrPredicate(Predicate predicateA, Predicate predicateB)
        {
            this.predicateA = predicateA;
            this.predicateB = predicateB;
        }
        @Override
        public boolean evaluate(T obj)
        {
            return (predicateA.evaluate(obj) || predicateB.evaluate(obj));
        }
    }
    public static class AndPredicate<T> implements Predicate<T>
    {
        private Predicate<T> predicateA;
        private Predicate<T> predicateB;
        public AndPredicate(Predicate predicateA, Predicate predicateB)
        {
            this.predicateA = predicateA;
            this.predicateB = predicateB;
        }
        @Override
        public boolean evaluate(T obj)
        {
            return (predicateA.evaluate(obj) && predicateB.evaluate(obj));
        }
    }
}
