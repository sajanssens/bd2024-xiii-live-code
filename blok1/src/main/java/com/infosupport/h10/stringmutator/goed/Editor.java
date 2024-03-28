package com.infosupport.h10.stringmutator.goed;

import java.util.ArrayList;
import java.util.List;

public class Editor {
    private String content = """
               The authors refer to inheritance as white-box reuse, with white-box referring to visibility, because the internals of parent classes are often visible to subclasses. In contrast, the authors refer to object composition (in which objects with well-defined interfaces are used dynamically at runtime by objects obtaining references to other objects) as black-box reuse because no internal details of composed objects need be visible in the code using them.
               
               The authors discuss the tension between inheritance and encapsulation at length and state that in their experience, designers overuse inheritance (Gang of Four 1995:20). The danger is stated as follows:
               
               "Because inheritance exposes a subclass to details of its parent's implementation, it's often said that 'inheritance breaks encapsulation'". (Gang of Four 1995:19)
               They warn that the implementation of a subclass can become so bound up with the implementation of its parent class that any change in the parent's implementation will force the subclass to change. Furthermore, they claim that a way to avoid this is to inherit only from abstract classes—but then, they point out that there is minimal code reuse.
            """;

    List<StringMutator> mutators = new ArrayList<>();

    public Editor() {
        ToUpper tu = new ToUpper();
        LaatsteRegel lr = new LaatsteRegel();
        Derde d = new Derde();

        mutators.add(tu);
        mutators.add(lr);
        mutators.add(d);
    }

    public void edit() {
        for (StringMutator mutator : mutators) {
            content = mutator.mutate(content);
        }

        System.out.println(content);
    }

    public static void main(String[] args) {
        new Editor().edit();
    }
}
