package working;

class Stack {
        private int[] stack;
        private int tos = -1;

        Stack (int n) {
            stack = new int[n];
        }

        void push (int item) {
            if(tos == this.stack.length - 1) {
                System.out.println("Stack if full! No item added!");
            } else {
                this.stack[++tos] = item;
                System.out.println("Item pushed into the stack: " + item);
            }
        }

        int pop() {
            if (tos < 0) {
                System.out.println("Stack underflow!");
                return 0;
            } else {
                System.out.println("Item popped out of the stack: " + this.stack[tos]);
                return this.stack[tos--];
            }
        }
}

