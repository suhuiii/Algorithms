import java.util.Iterator;

public class Stack<T> {

    T[] stack;
    int counter = 0;

    public Stack(){
        stack = (T[]) new Object[1] ;
    }

    public void push(T value){
        if(isFull()){
            resize(stack.length * 2);
        }

        stack[counter++] = value;
    }

    private boolean isFull() {
        return counter == stack.length;
    }
    public int size(){
        return counter;
    }

    public T pop(){
        if(counter > 0){
            counter --;
        }
        T returnedVal = stack[counter];
        stack[counter] = null;
        if(counter > 0 && counter <= stack.length/4)
            resize(stack.length / 2);

        return returnedVal;

    }

    public T peek(){
        return stack[counter == 0 ? 0 : counter - 1];
    }

    private void resize(int max) {
        T[] newStack =  (T[]) new Object[max];
        for( int i = 0; i < stack.length ; i++){
            newStack[i] =  stack[i];
        }
        stack = newStack;
    }

    public Iterator<T> iterator(){
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T> {
        private int i = counter;
        @Override
        public boolean hasNext(){ return i > 0;}

        @Override
        public T next() {
            return (T) stack[--i];
        }

        @Override
        public void remove(){

        }
    }
}
