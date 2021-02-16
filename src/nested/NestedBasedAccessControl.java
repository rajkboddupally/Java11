/*
    Author - Raj Kumar Boddupally
    Date - 02/15/2021
 */

package nested;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/*
JEP 181: Nest-Based Access Control.
It supports private access within nest members directly, no more via an auto-generated bridge method access$000.
Furthermore, new nested APIs for validation and allowed private reflection access within nest members.
 */
public class NestedBasedAccessControl {

    public static void main(String[] args) throws Exception {
        InnerA innerA = new InnerA();
        innerA.printName();

        //isNestmateOf
        System.out.println(NestedBasedAccessControl.class.isNestmateOf(InnerA.class));

        //getNestHost
        System.out.println(InnerB.class.getNestHost());

        //Important - class nested.NestedBasedAccessControl  not InnerB
        System.out.println(InnerB.InnerC.class.getNestHost());

        //getNestMembers
        System.out.println(Arrays.toString(NestedBasedAccessControl.class.getNestMembers()));
    }

    public static class InnerA {
        public void printName() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            //Before Java 11 - IllegalAccessException .. Exception can not access a member of class ... with modifiers "private"
            InnerB obj = new InnerB();
            final Method m = InnerB.class.getDeclaredMethod("printName");
            m.invoke(obj);

            InnerB.InnerC innerC = new InnerB().new InnerC();
            Method method1 = InnerB.InnerC.class.getDeclaredMethod("printName");
            method1.invoke(innerC);
        }
    }

    public static class InnerB {
        private void printName() {
            System.out.println("In InnerB");
        }

        private class InnerC {
            private void printName() {
                System.out.println("In InnerC");
            }
        }
    }

}
