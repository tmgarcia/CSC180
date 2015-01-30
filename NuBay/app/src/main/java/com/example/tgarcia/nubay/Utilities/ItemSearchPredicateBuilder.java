package com.example.tgarcia.nubay.Utilities;

import com.example.tgarcia.nubay.models.Item;

import java.util.Stack;

/**
 * Created by tgarcia on 1/28/2015.
 */
public class ItemSearchPredicateBuilder
{
    public static class ItemContainsPredicate implements CollectionUtils.Predicate<Item>
    {
        private String query;
        public ItemContainsPredicate(String query)
        {
            this.query = query.toLowerCase();
        }
        @Override
        public boolean evaluate(Item item)
        {
            return(item.getName().toLowerCase().contains(query)
                    || item.getShortDescription().toLowerCase().contains(query)
                    || item.getLongDescription().toLowerCase().contains(query));
        }
    }

    private String query;
    private enum Operator {AND, OR}

    public ItemSearchPredicateBuilder()
    {

    }

    private Stack<CollectionUtils.Predicate> predicatesStack;
    private Stack<Operator> operatorsStack;
    public CollectionUtils.Predicate buildPredicate(String query)
    {
        this.query = query;
        String[] elements = query.split("\\s");

        predicatesStack = new Stack<CollectionUtils.Predicate>();
        operatorsStack = new Stack<Operator>();

        for(int i = 0; i < elements.length; i++)
        {
            String element = elements[i];
            if(element.equalsIgnoreCase("or"))
            {
                Operator or = Operator.OR;
                if(!operatorsStack.isEmpty() && operatorsStack.peek() == Operator.AND)
                {
                    ConsumeTopOperator();
                }
                operatorsStack.push(or);
            }
            else if(element.equalsIgnoreCase("and"))
            {
                Operator and = Operator.AND;
                operatorsStack.push(and);
            }
            else
            {
                CollectionUtils.Predicate predicate = new ItemContainsPredicate(element);
                predicatesStack.push(predicate);
            }
        }
        while(!operatorsStack.isEmpty())
        {
            ConsumeTopOperator();
        }
        return predicatesStack.pop();
    }
    private void ConsumeTopOperator()
    {
        Operator operator = operatorsStack.pop();
        CollectionUtils.Predicate predicateA = predicatesStack.pop();
        CollectionUtils.Predicate predicateB = predicatesStack.pop();
        CollectionUtils.Predicate newPredicate = (operator == Operator.AND)? new CollectionUtils.AndPredicate(predicateA, predicateB) : new CollectionUtils.OrPredicate(predicateA, predicateB);
        predicatesStack.push(newPredicate);
    }

}
